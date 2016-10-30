package csd.starter;

import java.util.Date;

/**
 * Created by anassar on 10/30/2016.
 */
public class ReservationRepository {
    public static Reservation GetreservationById(int id)
    {
      return  new Reservation(new Date(2016,10,30, 10,00, 00),10,1,4, 5 );
    }
}
