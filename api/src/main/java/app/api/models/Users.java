package app.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users implements UserDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @Column(nullable = false, length = 50)
        private String name;

        @Column(nullable = false, length = 50)
        private String email;

        @Column(nullable = false, columnDefinition = "text")
        private String picUrl;

        @Column(nullable = false, columnDefinition = "text")
        private String password;

        @Column(nullable = false)
        private Boolean deleted = false;

        @CreationTimestamp
        @Column(name = "created_at")
        private Date createdAt = new Date();

        @OneToMany(mappedBy = "owner")
        private Set<Posts> ownerPostses;

        @OneToMany(mappedBy = "user")
        private Set<Likes> userLikes;

        @OneToMany(mappedBy = "user")
        private Set<Reposts> userReposts;

        @OneToMany(mappedBy = "repostedBy")
        private Set<Posts> repostedByPosts;

        @OneToMany(mappedBy = "user")
        private Set<Comments> userComments;

        @OneToMany(mappedBy = "follower")
        private Set<Follows> followerFollows;

        @OneToMany(mappedBy = "user")
        private Set<Follows> userFollows;

        public Users(String name, String password, String email, String picUrl) {
                this.name = name;
                this.password = password;
                this.email = email;
                this.picUrl = picUrl;
        }

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
