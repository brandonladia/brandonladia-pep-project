package Controller;

import Service.SocialMediaService;
import io.javalin.Javalin;
import io.javalin.http.Context;

//import other stuff
import Model.Account;
import Model.Message;
import Service.SocialMediaService;
//import stuff above

/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {
//adding stuff
    SocialMediaService socialMediaService;
    public SocialMediaController(){
        socialMediaService = new SocialMediaService();
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
        app.post("/register", );
        app.post("/login", );
        app.post("/messages", );
        app.get("/messages", );
        app.get("/messages/{message_id}", );
        app.delete("/messages/{message_id}", );
        app.patch("/messages/{message_id}", );
        app.get("/accounts/{account_id}/messages", );
        //created endpoints above

        //example here  app.get("example-endpoint", this::exampleHandler);
        return app;
    }

    /**
     * This is an example handler for an example endpoint.
     * @param context The Javalin Context object manages information about both the HTTP request and response.
     */
    private void exampleHandler(Context context) {
        context.json("sample text");
    }


}