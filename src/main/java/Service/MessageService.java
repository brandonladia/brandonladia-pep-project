package Service;

import java.util.List;

import DAO.MessageDAO;
import Model.Message;

public class MessageService {
    MessageDAO messageDAO;

//no args constructor for Message to instantiate a new MessageDAO
    public MessageService(){
        messageDAO = new MessageDAO();
    }

//constructor for when MessageDAO is provided
    public MessageService(MessageDAO messageDAO){
        this.messageDAO = messageDAO;
    }

//create new message

//retrieve all messages
    public List<Message> getAllMessages(){
        return messageDAO.getAllMessages();
    }
    
//retrieve message by ID

//delete message identified by ID

//update message text identified by ID

//retrieve all messages written by a particular user

}
