package com.max.blogAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {

    BlogMockData mockData = BlogMockData.getInstance();

    @RequestMapping("/")
    public String index() {
        return "API up and running";
    }

    @GetMapping("/blogs")
    public List<Blog> getBlogs() {
        return mockData.getBlogs();
    }

    @GetMapping("/blogs/{id}")
    public Blog getBlog(@PathVariable int id) {
        
    }
}
