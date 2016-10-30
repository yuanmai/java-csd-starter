package csd.starter;

import java.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void AddCourtTest() {
        Court newCourt = new Court("Court One");
        Club club = new Club();
        club.AddCourt(newCourt);

        Court getCourt = club.GetCourtByName(newCourt.Name);

        Assert.assertEquals(getCourt,newCourt);
    }

    @Test
    public void reservingEmptySlotSucceeds() {
        final Club club = new Club();
        final ReservationService srvc = new ReservationService(club);
        final LocalDateTime startTime = LocalDateTime.of(2016, 10, 1, 17, 0);
        final LocalDateTime endTime = LocalDateTime.of(2016, 10, 1, 18, 0);

        club.AddCourt((new Court("Court Two")));
        Assert.assertEquals(1, srvc.ReserveCourt(
                "Court Two", new Interval(startTime, endTime)));

    }

    @Test
    public void reservingTwoEmptySlotsInTheSameCourtSucceeds() {
        final Club club = new Club();
        final ReservationService srvc = new ReservationService(club);
        LocalDateTime startTime = LocalDateTime.of(2016, 10, 1, 17, 0);
        LocalDateTime endTime = LocalDateTime.of(2016, 10, 1, 18, 0);

        club.AddCourt((new Court("Court Three")));
        Assert.assertEquals(1, srvc.ReserveCourt(
                "Court Three", new Interval(startTime, endTime)));
        startTime = LocalDateTime.of(2016, 10, 1, 19, 0);
        startTime = LocalDateTime.of(2016, 10, 1, 20, 0);
        Assert.assertEquals(2, srvc.ReserveCourt(
                "Court Three", new Interval(startTime, endTime)));

    }
}
