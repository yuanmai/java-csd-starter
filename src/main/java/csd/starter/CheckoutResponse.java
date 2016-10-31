package csd.starter;

/**
 * Created by anassar on 10/30/2016.
 */
public class CheckoutResponse {
    public boolean Success;
    public int Change ;
    public String Message;

    public CheckoutResponse(boolean success, int change, String message) {
        Success = success;
        Change = change;
        Message = message;
    }
}
