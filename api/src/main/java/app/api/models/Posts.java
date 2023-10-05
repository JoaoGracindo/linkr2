package app.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.OffsetDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, columnDefinition = "text")
    private String link;

    @Column(columnDefinition = "text")
    private String description;

    @Column(nullable = false)
    private Boolean deleted;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private Users owner;

    @OneToMany(mappedBy = "post")
    private Set<TagsPivot> postTagsPivots;

    @OneToMany(mappedBy = "post")
    private Set<Likes> postLikes;

    @OneToMany(mappedBy = "post")
    private Set<Reposts> postReposts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reposted_by_id")
    private Users repostedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origin_post_id")
    private Posts originPost;

    @OneToMany(mappedBy = "originPost")
    private Set<Posts> originPostPosts;

    @OneToMany(mappedBy = "post")
    private Set<Comments> postComments;

}
