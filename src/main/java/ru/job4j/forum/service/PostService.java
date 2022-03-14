package ru.job4j.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.AuthorityRepository;
import ru.job4j.forum.repository.PostRepository;
import ru.job4j.forum.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;

    public List<Post> getAllPosts() {
        List<Post> rsl = new ArrayList<>();
        postRepository.findAll().forEach(rsl::add);
        return rsl;
    }

    public Post findPostById(int id) {
        return postRepository.findById(id).get();
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public void deletePost(int id) {
        postRepository.deleteById(id);
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public Authority findByAuthority(String role_user) {
        return authorityRepository.findByAuthority(role_user);
    }

    public void add(User user) {
        userRepository.save(user);
    }
}
