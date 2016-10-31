package csd.starter;

import java.util.Date;

/**
 * Created by akamel on 10/30/2016.
 */
public class Player extends User {

    public Player(String name) {
        super(name, "Player");
    }

    public Player(String name, String role) {
        super(name, role);
    }

    void requestReservation(Reservation resev) {

    }
}
