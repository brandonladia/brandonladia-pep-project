package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Account;
import Util.ConnectionUtil;

public class AccountDAO {

//new users
public Account addUser(Account account){
    Connection conn = ConnectionUtil.getConnection();
    
    return null;
    }

//logins
public void newlogin(){
    Connection conn = ConnectionUtil.getConnection();
}
}
