package com.upgrad.technicalblogpost.controller;

import com.upgrad.technicalblogpost.Service.PostService;
import com.upgrad.technicalblogpost.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class PostController {

    PostService postService = new PostService();

    @RequestMapping("/posts")
    public String getUserPost(Model model) {
        ArrayList<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }
    //TODO: GET : posts/newpost  ,  POST: post/create
    @RequestMapping("/posts/newpost")
    public String newPost(){
        return "posts/create";
    }
    @RequestMapping(value="/posts/create", method= RequestMethod.POST)
    public String createPost(Post newPost){
        newPost.setDate(new Date());
        postService.createPost(newPost);
        return "redirect:/posts";
    }
}

