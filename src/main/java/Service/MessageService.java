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
        //default below to pass first test case
        //return messageDAO.createMessage(message);
        //testing code below
        //if and only if message_text is not blank, is under 255 characters and posted_by is real user
        boolean test1 = message.getMessage_text().isBlank();
        boolean test2 = message.getMessage_text().length() >= 255;
        boolean test3 = messageDAO.getAllMessages().contains((Object)message.posted_by);
        if(test1 || test2|| test3){
            return null;
        } else {
            return messageDAO.createMessage(message);
        }
        //keep working above
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
    //we do this so that we can get the messageByID that was deleted
        if(messageDAO.getMessageByID(id) != null){
            messageDAO.deleteMessageByID(id);
            return messageDAO.getMessageByID(id);
        } else {
            return null;
        }
    }

//update message text identified by ID
    public Message updateMessageById(Message message){
        //to make it run
        // return messageDAO.updateMessageById(message);
        //boolean cases here?
        boolean test2 = message.getMessage_text().length() > 255;
        boolean test3 = message.getMessage_text().isBlank();
        boolean test1 = messageDAO.getMessageByID(message.getMessage_id()) != null;
        //boolean cases here?
        List<Message> messages = messageDAO.getAllMessages();
        messages.forEach(System.out::println);
        System.out.println("anything" + message.toString() + test1);
        if(test1 || test2 || test3){
            System.out.println("message failed update");
            return null;
        } else {
            System.out.println("Before DAO " + message.toString());
            messageDAO.updateMessageById(message);
            message = messageDAO.getMessageByID(message.getMessage_id());
            System.out.println(message);
            System.out.println("After DAO " + message.toString());
            return message;
            //return messageDAO.updateMessageById(message);
        }
        
    }

//retrieve all messages written by a particular user
    public List<Message> getAllMessagesFromUser(int id){
        List<Message> userMessages = messageDAO.getAllMessagesFromUser(id);
        return userMessages;
    }

}
