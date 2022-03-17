package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;
import java.security.Principal;
import java.util.Date;

@Controller
public class PostControl {
    private final PostService service;

    public PostControl(PostService service) {
        this.service = service;
    }

    @GetMapping("/post")
    public String getPost(@RequestParam("id") String id, Model model) {
        var post = service.findPostById(Integer.parseInt(id));
        model.addAttribute("post", post);
        return "post";
    }

    @GetMapping("/createPost")
    public String showPostForm(Model model) {
        Post post = new Post();
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("post", post);
        return "edit";
    }

    @RequestMapping("/savePost")
    public String createPost(@ModelAttribute("post") Post post, Principal principal) {
        post.setUser(service.findUserByUsername(principal.getName()));
        post.setCreated(new Date(System.currentTimeMillis()));
        service.save(post);
        return "redirect:/index";
    }

    @RequestMapping("/editPost")
    public String updatePost(@RequestParam("postId") String id, Model model) {
        var post = service.findPostById(Integer.parseInt(id));
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("post", post);
        return "edit";
    }

    @RequestMapping("/deletePost")
    public String deletePost(@RequestParam("postId") String id) {
        service.deletePost(Integer.parseInt(id));
        return "redirect:/index";
    }
}
