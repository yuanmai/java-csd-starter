package csd.starter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by akamel on 10/31/2016.
 */
public class UIInteractive {


    public void Reserve(String input)
    {
        /*
        Player tennisPlayer = new Player("Ahmed");

        Reservation resev = new Reservation(new Date(116, 10, 10, 11, 0), new Date(116, 10, 10, 13, 0), tennisPlayer, court);
        Club.ActiveClub.Reserve(resev);
        Club.ActiveClub.PrintReservationLog();

        System.out.print("Nearest court to Player Ahmed is: ");
        Court nearest = tennisPlayer.GetNearestCourt(1, 1);
        System.out.println(nearest.Name);
        */

        Scanner scanner;
        if(input != null)
            scanner = new Scanner(input);
        else
            scanner = new Scanner(System.in);

        System.out.println("Enter the name of the player: ");

        String playerName = scanner.nextLine();
        Player player = new Player(playerName);

        System.out.println("Enter the date and time for the reservation dd-MM-yyyy HH:mm");
        String dateString = scanner.nextLine();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }

        Date date2 = new Date(date.getYear(), date.getMonth(), date.getDay(), date.getHours(), date.getMinutes());

        System.out.println("Enter your location x and y");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        Court nearestCourt = player.getNearestCourt(x, y);
        if(nearestCourt != null)
        {
            System.out.println("Nearest court is: "+nearestCourt.Name);
        }
        else
        {
            System.out.println("Can't find a near court");
            return;
        }

        Reservation resev = new Reservation(date, date2, player, nearestCourt);
        Club.ActiveClub.Reserve(resev);
        Club.ActiveClub.PrintReservationLog();
    }

    public void SetupData()
    {
        Court courtA = new Court("CourtA", 10, 10);
        Club.ActiveClub.courts.add(courtA);

        Court courtB = new Court("CourtB", 20, 20);
        Club.ActiveClub.courts.add(courtB);

        Court courtC = new Court("CourtC", 30, 30);
        Club.ActiveClub.courts.add(courtC);
    }
}
