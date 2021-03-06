package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MemRepository {
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private final Map<Integer, User> users = new ConcurrentHashMap<>();
    private AtomicInteger postId = new AtomicInteger(-1);
    private AtomicInteger userId = new AtomicInteger(-1);

    public MemRepository() {
        Authority admin = Authority.of("ADMIN");
        Authority user = Authority.of(("USER"));

        User adminUser = User.of("Admin", "admin", admin);
        User user0 = User.of("Ivan", "123", user);
        User user1 = User.of("Diana", "123", user);

        users.put(userId.incrementAndGet(), adminUser);
        users.put(userId.incrementAndGet(), user0);
        users.put(userId.incrementAndGet(), user1);

        var firstPost = Post.of("Продам машину лада седан", user0, "Не бита не крашена");
        firstPost.setId(postId.incrementAndGet());
        var secondPost = Post.of("Отдам щенка в хорошие руки", user1, "Дворняжка, кабель");
        secondPost.setId(postId.incrementAndGet());
        var thirdPost = Post.of("Продам гараж", user0, "Как раз для лады седан");
        thirdPost.setId(postId.incrementAndGet());

        posts.put(firstPost.getId(), firstPost);
        posts.put(secondPost.getId(), secondPost);
        posts.put(thirdPost.getId(), thirdPost);
    }

    public List<Post> getAllPosts() {
        return new ArrayList<>(posts.values());
    }

    public Post findPostById(int id) {
        return posts.get(id);
    }

    public void save(Post post) {
        post.setId(postId.incrementAndGet());
        post.setUser(users.get(0));
        post.setCreated(new Date(System.currentTimeMillis()));
        posts.put(post.getId(), post);
    }

    public void update(Post post) {
        post.setUser(users.get(0));
        post.setCreated(new Date(System.currentTimeMillis()));
        posts.replace(post.getId(), post);
    }

    public void deletePost(int id) {
        posts.remove(id);
    }
}
