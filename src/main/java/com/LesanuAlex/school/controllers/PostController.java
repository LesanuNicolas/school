package com.LesanuAlex.school.controllers;

import com.LesanuAlex.school.models.Post;
import com.LesanuAlex.school.services.PostService;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
public class PostController {

    private final PostService postService;

    @PostMapping("/posts/1")
    public Post getPost() {
    return  postService.getPost();
    }

    @PostMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

}

