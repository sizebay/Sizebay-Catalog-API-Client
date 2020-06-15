package sizebay.catalog.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.val;
import sizebay.catalog.client.http.ApiException;

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
  String password;
  String facebookToken;
  String googleUserId;

  List<Profile> profiles = new ArrayList<>();

  public void insertProfileInProfileList(Profile newProfile) {
    newProfile.generateIdentifier();
    this.getProfiles().add(newProfile);
    this.activeProfileById(newProfile.getId());
  }

  public void activeProfileById(long profileId) {
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

  public void activeProfileByGender(String gender) {

    if(!gender.equals("M") && !gender.equals("F") && !gender.equals("U"))
      throw new ApiException("Unspecified genre. Enter M for men, F for women and U for unisex");

    if(!isNull(this.getProfiles())) {

      val profile = this.applyGenderFilter(gender);

      if(!isNull(profile)) this.activeProfileById(profile.getId());
    }
  }

  public Profile retrieveActiveProfile() {
    val userProfiles = this.getProfiles();

    if(isNull(userProfiles)) return null;

    return userProfiles.stream().filter(p -> p.getIsActive() == ACTIVE).findFirst().orElse(null);
  }

  public Long retrieveActiveProfileId() {
    final Profile userProfile = this.retrieveActiveProfile();

    return isNull(userProfile) ? null : userProfile.getId();
  }

  public void activeProfileBy(String gender, Product.AgeGroupEnum age) {

    if(!gender.equals("M") && !gender.equals("F") && !gender.equals("U"))
      throw new ApiException("Unspecified genre. Enter M for men, F for women and U for unisex");

    if(!isNull(this.getProfiles())) {

      val profile = this.applyGenderFilter(gender, age);

      if(!isNull(profile)) this.activeProfileById(profile.getId());
    }
  }

  public Profile applyGenderFilter(String gender, Product.AgeGroupEnum age) {
    val userProfiles = this.getProfiles();
    val profiles = getFilteredProfiles(gender, age, userProfiles);
    if(profiles.size() == 0)
      return null;
    // throw new ApiException(404, "No profiles found in this gender");

    return profiles.get(0);
  }

  private List<Profile> getFilteredProfiles(String gender, Product.AgeGroupEnum age, List<Profile> userProfiles) {
    if (gender.equals("U")) {
      userProfiles.sort(new SortProfileByLastActiveTime());
      return userProfiles;
    } else {
      return userProfiles.stream().filter(p -> p.getGender().equals(gender) && validateAgeGroup(p, age))
          .sorted(new SortProfileByLastActiveTime())
          .collect(Collectors.toList());
    }
  }

  private boolean validateAgeGroup(Profile p, Product.AgeGroupEnum age) {

    if (p.getAge() > 1 && p.getAge() <= 13) {
      return Product.AgeGroupEnum.KIDS.equals(age);
    } else if (p.getAge() <= 1) {
      return Product.AgeGroupEnum.INFANT.equals(age);
    } else return Product.AgeGroupEnum.ADULT.equals(age);
  }


  public Profile applyGenderFilter(String gender) {
    val userProfiles = this.getProfiles();
    val profiles = getFilteredProfiles(gender, userProfiles);
    if(profiles.size() == 0)
      return null;
      // throw new ApiException(404, "No profiles found in this gender");

    return profiles.get(0);
  }

  private List<Profile> getFilteredProfiles(String gender, List<Profile> userProfiles) {
    if (gender.equals("U")) {
      userProfiles.sort(new SortProfileByLastActiveTime());
      return userProfiles;
    } else {
      return userProfiles.stream().filter(p -> p.getGender().equals(gender))
                                                            .sorted(new SortProfileByLastActiveTime())
                                                            .collect(Collectors.toList());
    }
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

  public boolean isAnApplicationUser() {
  	return (!isNull(this.getFacebookToken()) && !this.getFacebookToken().isEmpty())
				|| (!isNull(this.getGoogleUserId()) && !this.getGoogleUserId().isEmpty());
	}

}
