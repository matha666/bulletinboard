package com.example.bulletinboard.controller;

import com.example.bulletinboard.dto.PostRequest;
import com.example.bulletinboard.model.Post;
import com.example.bulletinboard.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    @Autowired private PostService postService;

    @PostMapping("/register")
    public ResponseEntity<String> registerPost(@RequestBody PostRequest postRequest) {
        postService.registerPost(postRequest.getTitle(), postRequest.getContent());
        return ResponseEntity.ok("Post registered successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }
}
