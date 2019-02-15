package my.examples.blog.controller.api;

import lombok.RequiredArgsConstructor;
import my.examples.blog.domain.Comment;
import my.examples.blog.dto.CommentForm;
import my.examples.blog.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentApiController {
    private final CommentService commentService;

    @PostMapping
    public Comment addComment(@RequestBody CommentForm commentForm){
        Comment comment = commentService.addComment(commentForm);
        return comment;
    }
    @GetMapping
    public List<Comment> getComments(@RequestParam(name = "postId") Long postId){
        List<Comment> list = commentService.getComments(postId);

        return list;
    }
}
