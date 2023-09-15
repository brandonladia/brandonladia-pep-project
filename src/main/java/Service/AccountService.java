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

        return account;
    }
//process new login. maybe change name
    public void processLogin(){
        //create code
        
    }

}
