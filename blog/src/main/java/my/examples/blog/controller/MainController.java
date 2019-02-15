package my.examples.blog.controller;

import my.examples.blog.domain.Post;
import my.examples.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    PostService postService;

    @GetMapping("/main")
    public String main(
        @RequestParam(name = "page", required = false, defaultValue = "1") int page,
        @RequestParam(name = "categoryId", required = false) Long categoryId,
        @RequestParam(name = "searchKind", required = false) String searchKind,
        @RequestParam(name = "searchStr", required = false) String searchStr,
            Model model){

        List<Post> posts = postService.getPosts(page, categoryId, searchKind, searchStr);
        model.addAttribute("posts", posts);
        return "index";
    }

}
