package csd.starter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by amir on 10/31/2016.
 */
public class Club {
    List sheet = new ArrayList<Reservation>();
    protected static List<Court> courts = new ArrayList<Court>();
    public static final Club ActiveClub = new Club();

    private String reservationFrom = "Reservation from";

    private static final Logger logger = Logger.getLogger( Club.class.getName() );

    boolean reserve(Reservation resev)
    {
        sheet.add(resev);
        return true;
    }

    boolean reserve(Reservation reserv, PremiumPlayer.scheduleType scheduleType)
    {
        sheet.add(reserv);
        logger.log(Level.INFO, reservationFrom + reserv.from.toString() +" to "+reserv.to.toString() +" done to user: "+reserv.user.name +
                " On  " + scheduleType + " basis till: " + reserv.scheduleEndDate);
        return true;
    }

    public void printReservationLog()
    {
        logger.log(Level.INFO, "========================================");
        logger.log(Level.INFO, "Reservation Log:");
        for(int i=0; i<sheet.size(); i++)
        {
            Reservation resev = (Reservation)sheet.get(i);
            logger.log(Level.INFO, "Reservation from "+resev.from.toString() +" to "+resev.to.toString() +" done to user "+resev.user.name +" on court: " + resev.court.Name);
        }
    }
}
