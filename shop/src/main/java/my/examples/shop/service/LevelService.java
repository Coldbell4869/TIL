package my.examples.shop.service;

import my.examples.shop.domain.Level;
import my.examples.shop.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class LevelService {
    @Autowired
    LevelRepository levelRepository;

    @Transactional
    public void addLevel(Level level) {
        Level result = levelRepository.save(level);
        System.out.println(result.getId() + ", " + result.getName());
    }
}
