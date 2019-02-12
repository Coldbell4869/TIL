package my.examples.blog.service;

import lombok.RequiredArgsConstructor;
import my.examples.blog.domain.Account;
import my.examples.blog.domain.Category;
import my.examples.blog.domain.Post;
import my.examples.blog.repository.AccountRepository;
import my.examples.blog.repository.CategoryRepository;
import my.examples.blog.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final AccountRepository accountRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public Post addPost(Post post, Long categoryId, Long accountId){
        Optional<Category> optionalCategory
                = categoryRepository.findById(categoryId);
        Optional<Account> optionalAccount
                = accountRepository.findById(accountId);
        post.setAccount(optionalAccount.get());
        post.setCategory(optionalCategory.get());

        return postRepository.save(post);
    }
}
