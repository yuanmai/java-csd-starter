package csd.starter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by akamel on 10/30/2016.
 */
public class Court {
    String Name;
    public int x;
    public int y;

    public Court(String name, int x, int y)
    {
        this.Name = name;
        this.x = x;
        this.y = y;
    }

    List sheet = new ArrayList<Reservation>();

    boolean CheckAvail(Date from, Date to)
    {
        return false;
    }
    boolean Reserve(Reservation resev)
    {
        sheet.add(resev);
        System.out.println("Reservation from "+resev.from.toString() +" to "+resev.to.toString() +" done to user "+resev.user.name);
        return true;
    }
}
