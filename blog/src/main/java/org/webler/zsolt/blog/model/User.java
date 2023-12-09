package org.webler.zsolt.blog.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "_user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    @Size(min = 3)
    private String username;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "author", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @Setter(AccessLevel.NONE)
    private final List<Post> posts = new java.util.ArrayList<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
    @Setter(AccessLevel.NONE)
    private final List<Comment> comments = new java.util.ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Setter(AccessLevel.NONE)
    private final List<Role> roles = new java.util.ArrayList<>();


    public Post addPost(Post post) {
        posts.add(post);
        post.setAuthor(this);
        return post;
    }

    public Comment addComment(Comment comment) {
        comments.add(comment);
        comment.setAuthor(this);
        return comment;
    }

    public Role addRole(Role role) {
        roles.add(role);
        role.setUser(this);
        return role;
    }

}
