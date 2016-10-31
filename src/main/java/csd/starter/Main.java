package csd.starter;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Player tennisPlayer = new Player("Ahmed");
        Court court = new Court("CourtA", 10, 10);
        Club.ActiveClub.courts.add(court);

        Reservation resev = new Reservation(new Date(116, 10, 10, 11, 0), new Date(116, 10, 10, 13, 0), tennisPlayer, court);
        Club.ActiveClub.Reserve(resev);
        Club.ActiveClub.PrintReservationLog();

        System.out.print("Nearest court to Player Ahmed is: ");
        Court nearest = tennisPlayer.GetNearestCourt(1, 1);
        System.out.println(nearest.Name);
    }
}
