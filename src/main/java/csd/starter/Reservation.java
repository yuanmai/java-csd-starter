package csd.starter;

import java.util.Date;
import java.util.Random;

/**
 * Created by anassar on 10/30/2016.
 */
public class Reservation {


    public final Date date;
    public final int userid;
    public final int courtid;
    public final int numofunits;
    public final int unitrate;
    public final int Id;

    public Reservation(Date date, int userid, int courtid, int numofunits, int unitrate) {
        Random rand = new Random();
        this.Id = rand.nextInt();
        this.date = date;
        this.userid = userid;
        this.courtid = courtid;
        this.numofunits = numofunits;
        this.unitrate = unitrate;
    }

    public int getTotalPrice() {
        return this.numofunits*this.unitrate;
    }
}
