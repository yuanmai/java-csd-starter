package csd.starter;

/**
 * Created by yollaek on 10/31/2016.
 */
public class ResponseBase {
    public boolean Success;
    public String Message;

    public ResponseBase(String message, boolean success) {
        Message = message;
        Success = success;
    }
}
