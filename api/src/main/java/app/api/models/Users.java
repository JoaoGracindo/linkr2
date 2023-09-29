package app.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users implements UserDetails {

        @Id
        @Column(nullable = false, updatable = false)
        @SequenceGenerator(name = "primary_sequence", sequenceName = "primary_sequence", allocationSize = 1, initialValue = 10000)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
        private Integer id;

        @Column(nullable = false, length = 50)
        private String name;

        @Column(nullable = false, length = 50)
        private String email;

        @Column(nullable = false, columnDefinition = "text")
        private String picUrl;

        @Column(nullable = false, columnDefinition = "text")
        private String password;

        @Column(nullable = false)
        private Boolean deleted;

        @Column(nullable = false)
        private OffsetDateTime createdAt;

        @OneToMany(mappedBy = "owner")
        private Set<Posts> ownerPostses;

        @OneToMany(mappedBy = "user")
        private Set<Likes> userLikeses;

        @OneToMany(mappedBy = "user")
        private Set<Reposts> userRepostses;

        @OneToMany(mappedBy = "repostedBy")
        private Set<Posts> repostedByPostses;

        @OneToMany(mappedBy = "user")
        private Set<Comments> userCommentses;

        @OneToMany(mappedBy = "follower")
        private Set<Follows> followerFollowses;

        @OneToMany(mappedBy = "user")
        private Set<Follows> userFollowses;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of(new SimpleGrantedAuthority("user"));
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

}
