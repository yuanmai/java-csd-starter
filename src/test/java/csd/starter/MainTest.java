package csd.starter;

import java.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.fail;

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

    @Test(expected = InvalidCourtException.class)
    public void reservingNonExistingCourtFails() {
        final Club club = new Club();
        final ReservationService srvc = new ReservationService(club);
        final LocalDateTime startTime = LocalDateTime.of(2016, 10, 1, 17, 0);
        final LocalDateTime endTime = LocalDateTime.of(2016, 10, 1, 18, 0);

        srvc.ReserveCourt("Court Two", new Interval(startTime, endTime));

    }

    @Test
    public void SuccessfulPaymentTest() {

        Reservation rev1 = new Reservation(new Date(2016,10,30, 10,00, 00),10,1,4, 5 );

        CheckoutResponse resp = ClubServices.ChekoutService(rev1, 20);

        Assert.assertEquals(resp.Success, true);
        Assert.assertEquals(resp.Change, 0);

    }

    @Test
    public void NotSuccessfulPaymentTest() {

        Reservation rev1 = new Reservation(new Date(2016,10,30, 10,00, 00),10,1,4, 5 );

        CheckoutResponse resp = ClubServices.ChekoutService(rev1, 10);

        Assert.assertEquals(resp.Success, false);
        Assert.assertEquals(resp.Change, -10);
    }
}
