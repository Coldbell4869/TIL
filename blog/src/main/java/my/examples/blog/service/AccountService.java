package my.examples.blog.service;

import lombok.RequiredArgsConstructor;
import my.examples.blog.domain.Account;
import my.examples.blog.domain.Role;
import my.examples.blog.repository.AccountRepository;
import my.examples.blog.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;

    public List<Account> getAccountAll(){
        return accountRepository.findAll();
    }

    @Transactional
    public Account join(Account account) {

        Role role = roleRepository.getRoleByName("USER");
        account.addRole(role);
        return accountRepository.save(account);
    }
}
