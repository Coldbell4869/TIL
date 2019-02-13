package my.examples.shop.service;

import my.examples.shop.domain.Account;
import my.examples.shop.repository.AccountRepository;
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

