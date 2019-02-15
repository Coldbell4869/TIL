package my.examples.blog.service;

import lombok.RequiredArgsConstructor;
import my.examples.blog.domain.Account;
import my.examples.blog.domain.Category;
import my.examples.blog.domain.Post;
import my.examples.blog.repository.AccountRepository;
import my.examples.blog.repository.CategoryRepository;
import my.examples.blog.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final AccountRepository accountRepository;
    private final CategoryRepository categoryRepository;

    public final static String NAME_SEARCH = "name_search";
    public final static String TITLE_SEARCH = "title_search";
    public final static String CONTENT_SEARCH = "content_search";
    public final static String TITLE_OR_CONTENT_SEARCH = "title_content_search";

    @Transactional
    public Post addPost(Post post,Long categoryId, Long accountId){
        Optional<Category> optionalCategory
                = categoryRepository.findById(categoryId);
        Optional<Account> optionalAccount
                = accountRepository.findById(accountId);
        post.setAccount(optionalAccount.get());
        post.setCategory(optionalCategory.get());

        return postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public List<Post> getPosts(int page, Long categoryId, String searchKind, String searchStr) {
        int limit = 5;
        int start = page * limit - limit;
        return postRepository.getPosts(categoryId, start, limit, searchKind, searchStr);
    }
}
