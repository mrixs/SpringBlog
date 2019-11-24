package me.mrixs.springblog.controller;

import me.mrixs.springblog.model.Post;
import me.mrixs.springblog.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping("")
    public void addPost(@RequestBody Post post){
        postService.addPost(post);
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable Long id){
        return postService.getPost(id);
    }

    @PutMapping("/{id}")
    public void updatePost(@RequestBody Post post, @PathVariable Long id){
        if (post.getId().equals(id))
            postService.addPost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }
}
