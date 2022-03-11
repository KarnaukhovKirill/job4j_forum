package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public PostService() {
        User user = User.of("Ivan", "123");
        User user1 = User.of("Diana", "123");

        users.add(user);
        users.add(user1);

        posts.add(Post.of("Продам машину лада седан", user, "Не бита не крашена"));
        posts.add(Post.of("Отдам щенка в хорошие руки", user1, "Дворняжка, кабель"));
        posts.add(Post.of("Продам гараж", user, "Как раз для лады седан"));

    }

    public List<Post> getAll() {
        return posts;
    }
}
