package csd.starter;

import java.util.Date;

/**
 * Created by akamel on 10/30/2016.
 */
public class Player extends User {

    public Player(String name) {
        this.name = name;
        this.role = "Player";
    }

    public Player(String name, String role) {
        this.name = name;
        this.role = role;
    }

    void requestReservation(Reservation resev) {

    }

    public Court GetNearestCourt(int x, int y)
    {
        double nearestDistance = Double.MAX_VALUE;
        Court nearestCourt = null;
        for(int i=0; i<Club.ActiveClub.courts.size(); i++)
        {
            Court currentCourt = Club.ActiveClub.courts.get(i);
            double currentDistance = Math.sqrt(Math.pow(x-currentCourt.x, 2) + Math.pow(y-currentCourt.y, 2));
            if(currentDistance <  nearestDistance)
            {
                nearestCourt = currentCourt;
            }
        }
        return nearestCourt;
    }
}
