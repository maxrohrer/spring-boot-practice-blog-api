package com.max.blogAPI;

import java.util.ArrayList;
import java.util.List;

public class BlogFactory {

    private List<Blog> blogs;

    private static BlogFactory instance = null;
    public static BlogFactory getInstance() {
        if(instance == null) {
            instance = new BlogFactory();
        }
        return instance;
    }

    public BlogFactory(){
        blogs = new ArrayList<Blog>();
        blogs.add(new Blog(1, "Go up, up and away with your Google Assistant",
                "With holiday travel coming up, and 2018 just around the corner, " +
                        "you may be already thinking about getaways for next year. Consider " +
                        "the Google Assistant your new travel buddy, ready at the drop of a hat—or a passport"));
        blogs.add(new Blog(2, "Get local help with your Google Assistant",
                "No matter what questions you’re asking—whether about local traffic or " +
                        "a local business—your Google Assistant should be able to help. And starting " +
                        "today, it’s getting better at helping you, if you’re looking for nearby services " +
                        "like an electrician, plumber, house cleaner and more"));
        blogs.add(new Blog(3, "The new maker toolkit: IoT, AI and Google Cloud Platform",
                "Voice interaction is everywhere these days—via phones, TVs, laptops and smart home devices " +
                        "that use technology like the Google Assistant. And with the availability of maker-friendly " +
                        "offerings like Google AIY’s Voice Kit, the maker community has been getting in on the action " +
                        "and adding voice to their Internet of Things (IoT) projects."));
        blogs.add(new Blog(4, "Learn more about the world around you with Google Lens and the Assistant",
                "Looking at a landmark and not sure what it is? Interested in learning more about a movie as " +
                        "you stroll by the poster? With Google Lens and your Google Assistant, you now have a helpful " +
                        "sidekick to tell you more about what’s around you, right on your Pixel."));
        blogs.add(new Blog(5, "7 ways the Assistant can help you get ready for Turkey Day",
                "Thanksgiving is just a few days away and, as always, your Google Assistant is ready to help. " +
                        "So while the turkey cooks and the family gathers, here are some questions to ask your Assistant."));
    }

    public List<Blog> getBlogs() {
        return this.blogs;
    }

    public Blog getBlogById(int id) {
        for(Blog blog : blogs) {
            if(blog.getId() == id) {
                return blog;
            }
        }
        return null;
    }

    public List<Blog> searchBlogs(String query) {
        List<Blog> blogResults = new ArrayList<Blog>();
        for(Blog blog : blogs) {
            if(
                    blog.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    blog.getContent().toLowerCase().contains(query.toLowerCase())
            ) {
                blogResults.add(blog);
            }
        }
        return blogResults;
    }

    public Blog createBlog(int id, String title, String content) {
        Blog blog = new Blog(id, title, content);
        this.blogs.add(blog);
        return blog;
    }

    public Blog updateBlog(int id, String title, String content) {
        for(Blog blog : blogs) {
            if(blog.getId() == id) {
                blog.setTitle(title);
                blog.setContent(content);
                return blog;
            }
        }
        return null;
    }

    public boolean deleteBlog(int id) {
        int blogIdx = -1;
        for(Blog blog : blogs) {
            if(blog.getId() == id) {
                blogIdx = blogs.indexOf(blog);
                if(blogIdx > -1) {
                    blogs.remove(blogIdx);
                }
            }
        }
        return true;
    }
}
