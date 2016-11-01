package csd.starter;

/**
 * Created by yollaek on 10/31/2016.
 */
public class NotAvailableSlotsException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Court has no available free slots for given duration";
    }
}
