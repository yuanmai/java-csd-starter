package csd.starter;

/**
 * Created by MSAFWAT on 10/30/2016.
 */
public class ReservationService {
    private Club _club;
    private int _count = 0;

    public ReservationService(Club club) {

        _club = club;

    }

    public int ReserveCourt(String court, Interval resInterval) {

        if (_club.GetCourtByName(court) == null)
            throw new InvalidCourtException();

        return ++_count;

    }
}
