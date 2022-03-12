package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

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
    public String showPostForm() {
        return "create";
    }

    @RequestMapping("/savePost")
    public String createPost(@ModelAttribute("post") Post post) {
        service.save(post);
        return "redirect:/index";
    }

    @RequestMapping("/editPost")
    public String updatePost(@RequestParam("id") String id, Model model) {
        var post = service.findPostById(Integer.parseInt(id));
        model.addAttribute("post", post);
        return "edit";
    }

    @RequestMapping("/deletePost")
    public String deletePost(@RequestParam("id") String id) {
        service.deletePost(Integer.parseInt(id));
        return "redirect:/index";
    }
}
