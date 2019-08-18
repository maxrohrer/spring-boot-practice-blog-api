package com.max.blogAPI;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {

    BlogFactory blogFactory = BlogFactory.getInstance();

    @RequestMapping("/")
    public String index() {
        return "API up and running";
    }

    @GetMapping("/blogs")
    public List<Blog> getBlogs() {
        return blogFactory.getBlogs();
    }

    @PostMapping("/blogs")
    public Blog addBlog(@RequestBody Map<String, String> body) {
        return blogFactory.createBlog(Integer.parseInt(body.get("id")), body.get("title"), body.get("content"));
    }

    @GetMapping("/blogs/{id}")
    public Blog getBlog(@PathVariable int id) {
        return blogFactory.getBlogById(id);
    }

    @PutMapping("/blogs/{id}")
    public Blog updateBlog(@PathVariable int id, @RequestBody Map<String, String> body) {
        return blogFactory.updateBlog(id, body.get("title"), body.get("content"));
    }

    @DeleteMapping("/blogs/{id}")
    public boolean deleteBlog(@PathVariable int id) {
        return blogFactory.deleteBlog(id);
    }

    @GetMapping("/blogs/search")
    public List<Blog> searchBlogs(@RequestBody Map<String, String> body) {
        return blogFactory.searchBlogs(body.get("query"));
    }
}
