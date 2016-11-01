package csd.starter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by akamel on 10/30/2016.
 */
public class Court {
    String Name;
    private int x;
    private int y;

    public Court(String name, int x, int y)
    {
        this.Name = name;
        this.x = x;
        this.y = y;
    }

    public double getCurrentDistance(double x, double y) {
        return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
    }
}
