package csd.starter;

import java.util.Date;

/**
 * Created by akamel on 10/30/2016.
 */
public class Reservation {
    Date from;
    Date to;
    User user;
    Court court;

    public Reservation(Date from, Date to, User user, Court court) {
        this.from = from;
        this.to = to;
        this.user = user;
        this.court = court;
    }

    void Checkin()
    {

    }

    void Checkout()
    {

    }
}
