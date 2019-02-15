package my.examples.blog.repository.custom;

import com.querydsl.jpa.JPQLQuery;
import my.examples.blog.domain.Post;
import my.examples.blog.domain.QPost;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class PostRepositoryImpl extends QuerydslRepositorySupport implements PostRepositoryCustom {
    public PostRepositoryImpl(){
        super(Post.class); // Entity클래스 정보를 부모 클래스에게 전달.
    }

    @Override
    public List<Post> getPosts(Long categoryId, int start, int limit, String searchKind, String searchStr) {
        // JPQL
        // SELECT distinct p FROM Post p INNER JOIN FETCH p.account INNER JOIN FETCH p.category ORDER BY p.id DESC
        // SELECT distinct p FROM Post p INNER JOIN FETCH p.account INNER JOIN FETCH p.category WHERE p.category.id = :categoryId ORDER BY p.id DESC
        // SELECT distinct p FROM Post p INNER JOIN FETCH p.account INNER JOIN FETCH p.category WHERE p.account.name = :searchStr ORDER BY p.id DESC
        // SELECT distinct p FROM Post p INNER JOIN FETCH p.account INNER JOIN FETCH p.category WHERE p.category.id = :categoryId and p.account.name = :searchStr ORDER BY p.id DESC

        QPost qPost = QPost.post;
        JPQLQuery<Post> jpqlQuery = from(qPost).innerJoin(qPost.account).fetchJoin()
                                    .innerJoin(qPost.category).fetchJoin()
                                    .leftJoin(qPost.imageFiles).fetchJoin()
                                    .distinct();
        if(categoryId != null){
            jpqlQuery.where(qPost.category.id.eq(categoryId));
        }

//        중복 메소드처리
//        if("NAME_SEARCH".equals(searchKind)){
//            jpqlQuery.where(qPost.account.name.like("%" + searchStr + "%"));
//        }else if("TITLE_SEARCH".equals(searchKind)){
//            jpqlQuery.where(qPost.title.like("%" + searchStr + "%"));
//        }else if("CONTENT_SEARCH".equals(searchKind)){
//            jpqlQuery.where(qPost.content.like("%" + searchStr + "%"));
//        }else if("TITLE_OR_CONTENT_SEARCH".equals(searchKind)){
//            jpqlQuery.where(qPost.content.like("%" + searchStr + "%")
//                    .or(qPost.content.like("%" + searchStr + "%")));
//        }
        searchWhere(searchKind, searchStr, qPost, jpqlQuery);

        jpqlQuery.orderBy(qPost.id.desc());
        jpqlQuery.offset(start).limit(limit);
        return jpqlQuery.fetch();
    }

    @Override
    public long getPostsCount(Long categoryId, String searchKind, String searchStr) {
        // JPQL
        // SELECT distinct p FROM Post p INNER JOIN FETCH p.account INNER JOIN FETCH p.category ORDER BY p.id DESC
        // SELECT distinct p FROM Post p INNER JOIN FETCH p.account INNER JOIN FETCH p.category WHERE p.category.id = :categoryId ORDER BY p.id DESC
        // SELECT distinct p FROM Post p INNER JOIN FETCH p.account INNER JOIN FETCH p.category WHERE p.account.name = :searchStr ORDER BY p.id DESC
        // SELECT distinct p FROM Post p INNER JOIN FETCH p.account INNER JOIN FETCH p.category WHERE p.category.id = :categoryId and p.account.name = :searchStr ORDER BY p.id DESC
        // ....

        QPost qPost = QPost.post;
        JPQLQuery<Post> jpqlQuery = from(qPost).innerJoin(qPost.account).fetchJoin()
                .innerJoin(qPost.category).fetchJoin()
                .leftJoin(qPost.imageFiles).fetchJoin()
                .distinct();
        if (categoryId != null) {
            jpqlQuery.where(qPost.category.id.eq(categoryId));
        }

        searchWhere(searchKind, searchStr, qPost, jpqlQuery);
        return jpqlQuery.fetchCount();
    }

    private void searchWhere(String searchKind, String searchStr, QPost qPost, JPQLQuery<Post> jpqlQuery){
        if("NAME_SEARCH".equals(searchKind)){
            jpqlQuery.where(qPost.account.name.like("%" + searchStr + "%"));
        } else if ("TITLE_SEARCH".equals(searchKind)) {
            jpqlQuery.where(qPost.title.like("%" + searchStr + "%"));
        } else if ("CONTENT_SEARCH".equals(searchKind)) {
            jpqlQuery.where(qPost.content.like("%" + searchStr + "%"));
        } else if ("TITLE_OR_CONTENT_SEARCH".equals(searchKind)) {
            jpqlQuery.where(qPost.title.like("%" + searchStr + "%")
                    .or(qPost.content.like("%" + searchStr + "%")));
        }
    }
}
