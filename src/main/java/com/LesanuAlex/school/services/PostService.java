package com.LesanuAlex.school.services;

import com.LesanuAlex.school.models.Post;
import com.LesanuAlex.school.repositories.PostRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Data
public class PostService {

    private final RestTemplate restTemplate;
    private final PostRepository postRepository;

    public Post getPost() {
        Post post = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", Post.class);
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        Post[] post = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/", Post[].class);
        List<Post> list = Arrays.asList(post);
                list.stream()
                    .forEach(postRepository::save);
            return list;
        }


    }
