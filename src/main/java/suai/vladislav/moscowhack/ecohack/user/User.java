package suai.vladislav.moscowhack.ecohack.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import suai.vladislav.moscowhack.ecohack.hike.HikeGroup;
import suai.vladislav.moscowhack.ecohack.hike.HikeGroupXUser;
import suai.vladislav.moscowhack.ecohack.hike.HikeInvite;
import suai.vladislav.moscowhack.ecohack.hike.HikeRequest;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstname;
    private String lastname;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<HikeInvite> hikeInvites;

    @JsonManagedReference
    @OneToMany(mappedBy = "userCreator")
    private List<HikeInvite> hikeInvitesCreator;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<HikeRequest> hikeRequests;

    @JsonManagedReference
    @OneToMany(mappedBy = "userCreator")
    private List<HikeRequest> hikeRequestsCreator;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<HikeGroup> hikeGroups;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<HikeGroupXUser> hikeGroupXUsers;
}
