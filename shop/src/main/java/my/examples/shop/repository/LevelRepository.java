package my.examples.shop.repository;

import my.examples.shop.domain.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level, Long> {
}
