package csd.starter;

import java.io.PrintStream;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ReserveCommand(args,System.out);
        CheckoutCommand(args,System.out);
    }

    public static void ReserveCommand(String[] args,PrintStream out) {
        final Club club = new Club();
        final ReservationService resSrvc = new ReservationService(club);

        if(args[0].equals("Reserve")) {
            club.AddCourt(new Court("Court One"));
            resSrvc.ReserveCourt("Court One", new Interval(LocalDateTime.of(
                    2016, 10, 1, 17, 0), LocalDateTime.of(2016, 10, 1, 18, 0)));
            out.print("Reservation Done Successfully");

        }
    }

    public static void CheckoutCommand(String[] args, PrintStream out) {
        if (args[0].equals("Checkout")) {
            int resId = Integer.parseInt(args[1]);
            int totalPaid = Integer.parseInt(args[2]);
            Reservation res = ReservationRepository.GetreservationById(resId);
            CheckoutResponse response = ClubServices.ChekoutService(res,totalPaid);
            out.print(response.Message);
        }
    }
}
