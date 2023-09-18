package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        List<Message> messageList = new ArrayList<>();
        String sql = "SELECT * FROM message";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Message message = new Message(
                    rs.getInt("message_id"),
                    rs.getInt("posted_by"),
                    rs.getString("message_text"),
                    rs.getLong("time_posted_epoch")
                );
                messageList.add(message);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return messageList;
    }

//retrieve a message by ID
    public Message getMessageByID(int id){
        Connection conn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM message WHERE message_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Message message = new Message(
                    rs.getInt("message_id"),
                    rs.getInt("posted_by"),
                    rs.getString("message_text"),
                    rs.getLong("time_posted_epoch"));
                return message;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        return null;
    }

//delete a message by ID
    public Message deleteMessageByID(int id){
        Connection conn = ConnectionUtil.getConnection();
        String sql = "DELETE * FROM message WHERE message_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            //executeUpdate returns number of rows affected
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

//update a message by ID
//finish coding this
//finish coding this 
    public Message updateMessageById(Message message){
        Connection conn = ConnectionUtil.getConnection();
        String sql = "UPDATE message SET message_txt = ? WHERE message_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, message.getMessage_text());
            ps.setInt(2, message.getMessage_id());
            ps.executeUpdate();
            String updateMessage = "SELECT * FROM message WHERE message_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(updateMessage);
            ps2.setInt(1, message.getMessage_id());
            ResultSet rs = ps2.executeQuery();
            if(rs.next()){
                return (new Message(
                    rs.getInt("message_id"),
                    rs.getInt("posted_by"),
                    rs.getString("message_txt"),
                    rs.getLong("time_posted_epoch"))); 
            } else {
                return null;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       return null; 
}

//retrieve all messages from a particular user
    public List<Message> getAllMessagesFromUser(int id){
        Connection conn = ConnectionUtil.getConnection();
        List<Message> messageList = new ArrayList<>();
        String sql = "SELECT * FROM message WHERE posted_by = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Message message = new Message(
                    rs.getInt("message_id"),
                    rs.getInt("posted_by"),
                    rs.getString("message_text"),
                    rs.getLong("time_posted_epoch"));
                    messageList.add(message);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return messageList;
    }

}
