package csd.starter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amir on 10/31/2016.
 */
public class Club {
    List sheet = new ArrayList<Reservation>();
    public List<Court> courts = new ArrayList<Court>();

    public static Club ActiveClub = new Club();


    boolean Reserve(Reservation resev)
    {
        sheet.add(resev);
        //System.out.println("Reservation from "+resev.from.toString() +" to "+resev.to.toString() +" done to user "+resev.user.name);
        return true;
    }

    public void PrintReservationLog()
    {
        System.out.println("========================================");
        System.out.println("Reservation Log:");
        for(int i=0; i<sheet.size(); i++)
        {
            Reservation resev = (Reservation)sheet.get(i);
            System.out.println("Reservation from "+resev.from.toString() +" to "+resev.to.toString() +" done to user "+resev.user.name +" on court: " + resev.court.Name);
        }
    }
}
