package csd.starter;

import java.awt.peer.SystemTrayPeer;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        CheckoutCommand(args,System.out);
    }

    public static void CheckoutCommand(String[] args, PrintStream out) {
        if (args[0] == "Checkout")
        {
            int resId = Integer.parseInt(args[1]);
            int totalPaid = Integer.parseInt(args[2]);
            Reservation res = ReservationRepository.GetreservationById(resId);
            CheckoutResponse response = ClubServices.ChekoutService(res,totalPaid);

            out.print(response.Message);
        }
    }
}
