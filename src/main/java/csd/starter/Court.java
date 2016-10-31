package csd.starter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ndaoud on 30-Oct-16.
 */
public class Court {
    public String Name;
    public int Id;
    public ArrayList<Reservation> Reservations = new ArrayList<Reservation>();

    public Court(String name) {
        Name = name;
    }

    public boolean HasFreeSlotAt(Date date, int numofunits) {
        for(Reservation item :Reservations)
        {
            if(item.date.equals(date))
                return false;
        }
        return true;
    }
}
