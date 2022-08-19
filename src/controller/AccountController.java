package controller;

import model.Account;
import service.account.AccountServiceIMPL;
import service.account.IAccountService;

import java.util.List;

public class AccountController {

    IAccountService accountService = new AccountServiceIMPL();


    public List<Account> getAccountList() {
        return accountService.findAll();
    }

    public void saveAccount(Account account) {
        accountService.save(account);
    }

}
