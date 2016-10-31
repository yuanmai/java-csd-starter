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

    boolean CheckAvail(Date from, Date to)
    {
        return false;
    }
}
