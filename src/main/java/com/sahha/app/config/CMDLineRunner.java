package com.sahha.app.config;

import com.sahha.app.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class CMDLineRunner implements CommandLineRunner {
    private final AccountService accountService;

    public CMDLineRunner(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        accountService.getAccountsTokenService();

    }
}
