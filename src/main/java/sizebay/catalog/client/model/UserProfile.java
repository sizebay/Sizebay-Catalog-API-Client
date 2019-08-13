package sizebay.catalog.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfile implements Serializable {

  private static final int ACTIVE = 1, INACTIVE = 0;

  String id;
  String email;
  String facebook;
  String password;

  List<Profile> profiles = new ArrayList<>();

  public void insertAndUpdateProfilesList(Profile newProfile) {
    final long profileId = newProfile.getId();
    final boolean removeProfile = profileId != 0;

    if(removeProfile) this.getProfiles().removeIf(p -> p.getId() == profileId);

    newProfile.generateIdentifier();

    this.getProfiles().add(newProfile);
    this.activeProfile(newProfile.getId());
  }

  public void activeProfile(long profileId) {
    final List<Profile> profiles = this.getProfiles();

    profiles.stream().forEach(p -> {
      if(p.getId() == profileId) {
        p.setIsActive(ACTIVE);
        p.setLastActiveTime(System.currentTimeMillis());
      } else {
        p.setIsActive(INACTIVE);
      }
    });
  }

  public Profile retrieveActiveProfile() {
    final List<Profile> userProfiles = this.getProfiles();

    if(isNull(userProfiles)) return null;

    return userProfiles.stream().filter(p -> p.getIsActive() == ACTIVE).findAny().orElse(null);
  }

  public Profile retrieveActiveProfileByGender(String gender) {
    final List<Profile> userProfiles = this.getProfiles();

    if(isNull(userProfiles)) return null;

    Profile profile = retrieveActiveProfile();

    if(profile.getGender().equals(gender)) {
      return profile;
    } else {
      return userProfiles.stream().filter(p -> p.getGender().equals(gender))
                                  .sorted(new SortProfileByLastActiveTime())
                                  .collect(Collectors.toList()).get(0);
    }

  }

  public Long retrieveActiveProfileId() {
    final Profile userProfile = this.retrieveActiveProfile();

    return isNull(userProfile) ? null : userProfile.getId();
  }

  public static UserProfile empty(String id, String password) {

    return new UserProfile().setId(id).setPassword(password);
  }

  class SortProfileByLastActiveTime implements Comparator<Profile> {
    public int compare(Profile profileOne, Profile profileTwo) {

      if(profileOne.getLastActiveTime() > profileTwo.getLastActiveTime()) {
        return -1;
      } else {
        return 0;
      }

    }
  }

}
