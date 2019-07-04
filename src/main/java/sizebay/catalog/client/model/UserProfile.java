package sizebay.catalog.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfile implements Serializable {

    String id;
    String email;
    String facebook;
    String password;

    List<UserProfileIdentification> profiles;

    public static UserProfile empty(String id) {

        List<UserProfileIdentification> profile = new ArrayList<>();
        profile.add(UserProfileIdentification.empty());

        UserProfile user = new UserProfile().setId(id).setProfiles(profile);

        return user;

    }

}
