package com.upgrad.technicalblogpost.controller;

import com.upgrad.technicalblogpost.Service.PostService;
import com.upgrad.technicalblogpost.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class PostController {

    PostService postService = new PostService();

    @RequestMapping("/posts")
    public String getUserPost(Model model) {
        ArrayList<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }
}

