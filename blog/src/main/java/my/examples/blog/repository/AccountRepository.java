package my.examples.blog.repository;

import my.examples.blog.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a from Account a WHERE a.email = :email")
    public Account getAccountByEmail(@Param("email") String email);
}
