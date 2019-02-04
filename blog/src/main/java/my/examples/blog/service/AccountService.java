package my.examples.blog.service;

import my.examples.blog.domain.Account;
import my.examples.blog.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccountAll(){
        return accountRepository.findAll();
    }
}
