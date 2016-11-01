package csd.starter;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Player tennisPlayer = new Player("Ahmed");
        Court courtA = new Court("CourtA", 10, 10);
        Court courtB = new Court("CourtB", 100, 100);
        Club.ActiveClub.courts.add(courtA);
        Club.ActiveClub.courts.add(courtB);

        System.out.print("Nearest court to Player "+tennisPlayer.name+" is: ");
        Court nearest = tennisPlayer.getNearestCourt(1, 1);
        System.out.println(nearest.Name);

        Reservation resev = new Reservation(new Date(116, 10, 10, 11, 0), new Date(116, 10, 10, 13, 0), tennisPlayer, nearest);
        Club.ActiveClub.Reserve(resev);
        Club.ActiveClub.PrintReservationLog();
    }
}
