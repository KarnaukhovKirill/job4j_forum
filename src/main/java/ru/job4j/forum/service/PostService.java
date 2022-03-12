package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.MemRepository;
import java.util.List;

@Service
public class PostService {
    private final MemRepository repository;

    public PostService(MemRepository repository) {
        this.repository = repository;
    }

    public List<Post> getAllPosts() {
        return repository.getAllPosts();
    }

    public Post findPostById(int id) {
        return repository.findPostById(id);
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            repository.save(post);
        } else {
            repository.update(post);
        }
    }

    public void deletePost(int id) {
        repository.deletePost(id);
    }
}
