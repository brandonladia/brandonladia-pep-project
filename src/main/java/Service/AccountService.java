package Service;

import DAO.AccountDAO;
import Model.Account;

public class AccountService {
    AccountDAO accountDAO;

//no args constructor for Account to instantiate a new AccountDAO
    public AccountService(){
        accountDAO = new AccountDAO();
    }

//constructor for when AccountDAO is provided
    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

//use accountDAO to register new user
    public Account addAccount(Account account){
    //    return accountDAO.addAccount(account);
    //trying code
        if(account.getUsername() == null || account.getUsername().equals("") || account.getPassword().length() < 4){
            return null;
        } else {
            return accountDAO.addAccount(account);
        }
    }
//process new login. maybe change name
    public Account processLogin(Account account){
        return accountDAO.processlogin(account);
    }
}
