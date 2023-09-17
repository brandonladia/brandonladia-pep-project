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
    public Message creatMessage(Message message){
        return messageDAO.createMessage(null);
    }
//finish implementing

//retrieve all messages
    public List<Message> getAllMessages(){
        return messageDAO.getAllMessages();
    }
    
//retrieve message by ID
    public Message getMessageByID(int id){
        Message getMessage = messageDAO.getMessageByID(id);
        return getMessage;
    }

//delete message identified by ID
    public Message deleteMessageByID(int id){
        return messageDAO.deleteMessageByID(id);
    }

//update message text identified by ID
    public Message updateMessageById(){
        return null;
    }

//retrieve all messages written by a particular user
    public List<Message> getAllMessagesFromUser(int id){
        List<Message> userMessages = messageDAO.getAllMessagesFromUser(id);
        return userMessages;
    }

}
