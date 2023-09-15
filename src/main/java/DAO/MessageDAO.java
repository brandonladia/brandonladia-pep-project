package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Model.Message;
import Util.ConnectionUtil;

public class MessageDAO {

//create a message
    public Message createMessage(Message message){
        Connection conn = ConnectionUtil.getConnection();
        String sql = "INSERT INTO message (posted_by, message_text, time_posted_epoch) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, message.getPosted_by());
            ps.setString(2, message.getMessage_text());
            ps.setLong(3, message.getTime_posted_epoch());
            
            ps.executeUpdate();
            ResultSet pkeyResultSet = ps.getGeneratedKeys();
            if(pkeyResultSet.next()){
                int generated_message_id = (int) pkeyResultSet.getLong(1);
                return new Message(generated_message_id, message.getPosted_by(), message.getMessage_text(), message.getTime_posted_epoch());
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        
        return null;
    }

//retrieve all messages
    public List<Message> getAllMessages(){
        Connection conn = ConnectionUtil.getConnection();

        return null;
    }

//retrieve a message by ID
    public Message getMessageByID(){
        Connection conn = ConnectionUtil.getConnection();

        return null;
    }

//delete a message by ID

//update a message by ID

//retrieve all messages from a particular user
    public List<Message> getAllMessagesFromUser(){
        Connection conn = ConnectionUtil.getConnection();

        return null;
    }

}
