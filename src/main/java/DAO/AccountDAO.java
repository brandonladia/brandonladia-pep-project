package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Account;
import Util.ConnectionUtil;

public class AccountDAO {


//new users
public Account addAccount(Account account){
    Connection conn = ConnectionUtil.getConnection();
    String sql = "INSERT INTO account (username, password) VALUES (?, ?)";
    try {
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, account.getUsername());
        ps.setString(2, account.getPassword());
        
        ps.executeUpdate();
        ResultSet pkeyResultSet = ps.getGeneratedKeys();
        if(pkeyResultSet.next()){
//                         is it getInt() or getLong() IS ITTTTTT OR NOTTTTTT
            int generated_account_id = (int) pkeyResultSet.getInt(1);
            return new Account(generated_account_id, account.getUsername(), account.getPassword());
        }

    } catch (SQLException e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
    }

    return null;
    }

//logins
public void processlogin(){
    Connection conn = ConnectionUtil.getConnection();
    
}
}
