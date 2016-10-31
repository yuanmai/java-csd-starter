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

    void requestReservation(Date from, Date to) {

    }
}
