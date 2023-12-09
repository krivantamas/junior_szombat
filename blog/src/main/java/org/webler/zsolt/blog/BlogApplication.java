package org.webler.zsolt.blog;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.webler.zsolt.blog.model.*;
import org.webler.zsolt.blog.repository.CategoryRepository;
import org.webler.zsolt.blog.repository.PostRepository;
import org.webler.zsolt.blog.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

    @Bean
    @Autowired
    InitializingBean initDatabase(UserRepository userRepository, PostRepository postRepository, CategoryRepository categoryRepository) {

        return () -> {
            System.out.println("FUT");
            User user = new User().builder()
                    .username("TesztUser")
                    .password("1234")
                    .email("test@test.com")
                    .build();

            List<Post> posts = List.of(
                    new Post().builder()
                            .title("tesztpost")
                            .content("tesztcontent")
                            .status(Status.DRAFT)
                            .build(),
                    new Post().builder()
                            .title("tesztpost2")
                            .content("tesztcontent2")
                            .status(Status.DRAFT)
                            .build());


            List<Comment> comments = List.of(new Comment().builder()
                            .content("tesztcontent")
                            .createdTime(LocalDateTime.now())
                            .modificationTime(LocalDateTime.now())
                            .build(),
                    new Comment().builder()
                            .content("tesztcontent2")
                            .createdTime(LocalDateTime.now())
                            .modificationTime(LocalDateTime.now()).build()
            );

            for (Post post : posts) {
                user.addPost(post);
            }
            for (Comment comment : comments) {
                user.addComment(comment);
                user.getPosts().get(0).addComment(comment);
            }

            userRepository.saveAndFlush(user);


            Post p = postRepository.findById(1L).get();

            p.setContent("valami más");



            Category test = new Category().builder().categoryName("test").build();

            //categoryRepository.save(test);

            p.addCategory(test);

            postRepository.save(p);


        };
    }

}
