package Controller;

//import Service.SocialMediaService;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.io.Console;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//import other stuff
import Model.Account;
import Model.Message;
import Service.AccountService;
import Service.MessageService;

//import stuff above

/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {
//adding stuff
    AccountService accountService;
    MessageService messageService;

    public SocialMediaController(){
        accountService = new AccountService();
        messageService = new MessageService();
    }
//created above stuff

    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * 
     * POST
     * localhost:8080/register
     * 
     * POST
     * localhost:8080/login
     * 
     * POST, GET
     * localhost:8080/messages/
     * 
     * GET, DELETE, PATCH
     * localhost:8080/messages/{message_id}
     * 
     * GET
     * localhost:8080/accounts/{account_id}/messages
     * 
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */
    public Javalin startAPI() {
        Javalin app = Javalin.create();
        
        //creating endpoints below
        app.post("/register", this::postRegisterHandler);
        app.post("/login", this::postLoginHandler);
        app.post("/messages", this::postMessagesHandler);
        app.get("/messages", this::getAllMessagesHandler);
        app.get("/messages/{message_id}", this::getMessagesByIdHandler);
        app.delete("/messages/{message_id}", this::deleteMessagesByIdHandler);
        app.patch("/messages/{message_id}", this::updateMessagesByIdHandler);
        app.get("/accounts/{account_id}/messages", this::getMessagesbyUserHandler);
        //created endpoints above

        //example here  app.get("example-endpoint", this::exampleHandler);
        return app;
    }

    /**
     * This is an example handler for an example endpoint.
     * @param context The Javalin Context object manages information about both the HTTP request and response.
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    // private void exampleHandler(Context context) {
    //     context.json("sample text");
    // }

    //implement postRegisterHandler "addAccount()"
    private void postRegisterHandler(Context ctx) throws JsonMappingException, JsonProcessingException{
        ObjectMapper om = new ObjectMapper();
        Account account = om.readValue(ctx.body(), Account.class);
        Account newAccount = accountService.addAccount(account);
        //needed a conditional
        if(newAccount == null){
            ctx.status(400);
        } else {
            ctx.json(newAccount);
        }
    }

    //implement postLoginHandler
    public void postLoginHandler(Context ctx) throws JsonMappingException, JsonProcessingException{
        ObjectMapper om = new ObjectMapper();
        Account account = om.readValue(ctx.body(), Account.class);
        Account testAccount = accountService.processLogin(account);
        if(testAccount != null){
            ctx.json(testAccount);
        } else {
            ctx.status(401);
        }
    }

    //implement postMessagesHandler "createMessage()"
    public void postMessagesHandler(Context ctx) throws JsonMappingException, JsonProcessingException{
        ObjectMapper om = new ObjectMapper();
        Message message = om.readValue(ctx.body(), Message.class);
        Message newMessage = messageService.creatMessage(message);
        if(newMessage != null){
            ctx.json(newMessage);
        } else {
            ctx.status(400);
        }
    }
    //complete logic above

    //implement getAllMessagesHandler
    private void getAllMessagesHandler(Context ctx){
        ctx.json(messageService.getAllMessages());
    }

    //implement getMessagesByIdHandler
    private void getMessagesByIdHandler(Context ctx){
    //so we can use "id" with json
        int id = Integer.parseInt(ctx.pathParam("message_id")); /* Needed to be 'message_id' instead of 'id' */
        //ctx.json(messageService.getMessageByID(id));
        if(messageService.getMessageByID(id) == null){
            
        } else {
            ctx.json(messageService.getMessageByID(id));
        }
        /* Find a way to handle exceptions where the message_id doesn't exist. It throws a null pointer exception because message id of '100' doesnt exist in your db. */
    }

    //implement deleteMessagesByIdHandler
    private void deleteMessagesByIdHandler(Context ctx){
       int id = Integer.parseInt(ctx.pathParam("message_id"));
       if(messageService.getMessageByID(id) == null){
        
       } else {
        ctx.json(messageService.deleteMessageByID(id));
        System.out.println("The deleted message " + messageService.getMessageByID(id));
       }
    }

    //implement updateMessagesByIdHandler
    private void updateMessagesByIdHandler(Context ctx) throws JsonMappingException, JsonProcessingException{
        ObjectMapper om = new ObjectMapper();
        int id = Integer.parseInt(ctx.pathParam("message_id"));
        Message deletedMessage = om.readValue(ctx.body(), Message.class);
        if(deletedMessage == null){
            ctx.status(400);
        } else{
            deletedMessage.setMessage_id(id);
            Message updatedMessage = messageService.updateMessageById(deletedMessage);
            if(updatedMessage != null){
                ctx.json(om.writeValueAsString(updatedMessage));
            } else {
                ctx.status(400);
            }
        }
    }

    //implement getMessagesbyUserHandler
    private void getMessagesbyUserHandler(Context ctx){
        int id = Integer.parseInt(ctx.pathParam("account_id")); /* Needed to be 'account_id' insead of 'id' */
        ctx.json(messageService.getAllMessagesFromUser(id));
        
    }
}