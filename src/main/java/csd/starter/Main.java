package csd.starter;

import java.awt.peer.SystemTrayPeer;

public class Main {
    public static void main(String[] args) {
        if (args[0] == "Checkout")
        {
            int resId = Integer.parseInt(args[2]);
            int totalPaid = Integer.parseInt(args[4]);
            Reservation res = ReservationRepository.GetreservationById(resId);
            CheckoutResponse response = ClubServices.ChekoutService(res,totalPaid);

            System.out.print(response.Message);

        }
    }
}
