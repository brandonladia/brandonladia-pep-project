package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Account;
import Util.ConnectionUtil;

public class AccountDAO {

//create connection
Connection conn = ConnectionUtil.getConnection();

//new users
public Account addUser(Account account){
    
    return null;
    }

//logins
public void processlogin(){

}
}
