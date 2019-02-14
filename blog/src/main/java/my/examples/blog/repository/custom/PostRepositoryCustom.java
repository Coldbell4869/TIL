package my.examples.blog.repository.custom;

import my.examples.blog.domain.Post;

import java.util.List;

public interface PostRepositoryCustom {
    public List<Post> getPosts(Long categoryId, int start, int limit, String searchKind, String searchStr);
    public long getPostsCount(Long categoryId, String searchKind, String searchStr);
}
