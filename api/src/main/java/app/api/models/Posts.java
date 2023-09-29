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
import jakarta.persistence.SequenceGenerator;
import java.time.OffsetDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Posts {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer id;

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
    private Set<Likes> postLikeses;

    @OneToMany(mappedBy = "post")
    private Set<Reposts> postRepostses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reposted_by_id")
    private Users repostedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origin_post_id")
    private Posts originPost;

    @OneToMany(mappedBy = "originPost")
    private Set<Posts> originPostPostses;

    @OneToMany(mappedBy = "post")
    private Set<Comments> postCommentses;

}
