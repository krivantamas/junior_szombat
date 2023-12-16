package org.webler.zsolt.blog.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String content;

    @Column(nullable = false)
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdTime;

    @Column(nullable = false)
    @Setter(AccessLevel.NONE)
    private LocalDateTime modificationTime;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @Setter(AccessLevel.NONE)
    private final List<Comment> comments = new java.util.ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "post_category",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();

    public Category addCategory(Category category) {
        categories.add(category);
        category.addPost(this);
        return category;
    }

    public Comment addComment(Comment comment) {
        comments.add(comment);
        comment.setPost(this);
        return comment;
    }

    @PrePersist
    public void prePersist() {
        this.createdTime = LocalDateTime.now();
        this.modificationTime = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.modificationTime = LocalDateTime.now();
    }
}
