package DAO;

import java.sql.Connection;

import Model.Message;
import Util.ConnectionUtil;

public class MessageDAO {
//create connection
    Connection conn = ConnectionUtil.getConnection();

//create a message
    public Message createMessage(){
        
        return null;
    }

//retrieve all messages
    public List<Message> getAllMessages(){

        return null;
    }

//retrieve a message by ID
    public Message getMessageByID(){

        return null;
    }

//delete a message by ID

//update a message by ID

//retrieve all messages from a particular user
    public List<Message> getAllMessagesFromUser(){

        return null;
    }

}
