package csd.starter;

/**
 * Created by msafwat on 10/31/2016.
 */
public class InvalidCourtException extends Throwable {
    @Override
    public String getMessage() {
        return "Court Name not found";
    }
}
