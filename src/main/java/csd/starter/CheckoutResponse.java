package csd.starter;

/**
 * Created by anassar on 10/30/2016.
 */
public class CheckoutResponse extends ResponseBase {
    public int Change ;

    public CheckoutResponse(boolean success, int change, String message) {
        super(message, success);
        Change = change;
    }
}
