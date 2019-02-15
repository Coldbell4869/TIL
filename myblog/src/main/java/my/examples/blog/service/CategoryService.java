package my.examples.blog.service;

import lombok.RequiredArgsConstructor;
import my.examples.blog.domain.Category;
import my.examples.blog.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

}
