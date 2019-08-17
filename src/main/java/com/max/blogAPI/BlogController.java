package com.max.blogAPI;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    @RequestMapping("/")
    public String index() {
        return "API up and running";
    }
}
