package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

@Controller
public class PostControl {

    @GetMapping("/post")
    public String getPost(@RequestParam("id") String id, Model model) {
        /**
         * todo
         */
        return "post";
    }

    @GetMapping("/createPost")
    public String showPostForm() {
        return "create";
    }

    @RequestMapping("/savePost")
    public String createPost(@ModelAttribute("post") Post post) {
        /**
         * savePost
         * todo
         */
        return "redirect:/index";
    }

    @RequestMapping("/editPost")
    public String updatePost(@RequestParam("id") String id, Model model) {
        /**
         * 1.findPost
         * 2.sendPost to view
         * todo
         */
        return "edit";
    }}
