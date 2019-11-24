package me.mrixs.springblog.service;

import me.mrixs.springblog.model.Post;
import me.mrixs.springblog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public void addPost(Post post){
        if (post.getCreationDate() == null)
            post.setCreationDate(new Date());
        postRepository.save(post);
    }

    public Post getPost(Long id){
        return postRepository.findById(id).orElse(null);
    }

    public void updatePost(Post post){
        postRepository.save(post);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
