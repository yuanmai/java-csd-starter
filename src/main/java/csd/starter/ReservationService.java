package csd.starter;

/**
 * Created by MSAFWAT on 10/30/2016.
 */
public class ReservationService {
    private int _count = 0;

    public ReservationService(Club club) {
    }

    public int ReserveCourt(String court, Interval resInterval) {

        return ++_count;

    }
}
