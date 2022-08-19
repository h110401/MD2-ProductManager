package service.account;

import config.Config;

import static data.Path.*;

import model.Account;

import static model.Role.*;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceIMPL implements IAccountService {

    static List<Account> accountList = new ArrayList<>();

    static Config<List<Account>> config = new Config<>();

    static {
//        accountList.add(new Account(1, "admin", "admin", ADMIN));
//        accountList.add(new Account(2, "user1", "user1", USER));
//        accountList.add(new Account(3, "user2", "user2", USER));
//        config.write(accountList, PATH_ACCOUNT_LIST);

        accountList = config.read(PATH_ACCOUNT_LIST);
    }

    @Override
    public List<Account> findAll() {
        return accountList;
    }

    @Override
    public void save(Account account) {
        accountList.add(account);
    }


}
