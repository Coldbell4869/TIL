package my.examples.blog.service;

import lombok.RequiredArgsConstructor;
import my.examples.blog.domain.Comment;
import my.examples.blog.domain.Post;
import my.examples.blog.dto.CommentForm;
import my.examples.blog.repository.CommentRepository;
import my.examples.blog.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Comment addComment(CommentForm commentForm){
        Post post = postRepository.getPost(commentForm.getPostId());
        Comment comment = new Comment();
        comment.setContent(commentForm.getContent());
        comment.setPasswd(commentForm.getPasswd());
        comment.setName(commentForm.getName());
        comment.setPost(post);

        return commentRepository.save(comment);
    }

    @Transactional(readOnly = true)
    public List<Comment> getComments(Long postId) {
        return commentRepository.getComments(postId);
    }
}
