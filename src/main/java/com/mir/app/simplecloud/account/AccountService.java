package com.mir.app.simplecloud.account;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Account account = accountRepository.findByUserId(userName);
        if (account == null) {
            throw new UsernameNotFoundException(userName);
        }
        return User.builder()
                .username(account.getUserId())
                .password(account.getPassword())
                .roles(account.getRole())
                .build();
    }
}
