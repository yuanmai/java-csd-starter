package csd.starter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.StringJoiner;

import static org.junit.Assert.assertEquals;
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
    public void retrievingTheSecondCourtAfterAddingTwoCourtsSucceeds() {
        final Club club = new Club();
        final Court secondCourt = new Court("Court Two");

        club.AddCourt(new Court("Court One"));
        club.AddCourt(secondCourt);
        Assert.assertEquals(secondCourt, club.GetCourtByName("Court Two"));

    }

    @Test
    public void getNonExistentCourtReturnsNull() {
        final Club club = new Club();

        Assert.assertEquals(null, club.GetCourtByName(""));

    }

    @Test
    public void reservingEmptySlotSucceeds() {
        final Club club = new Club();
        final ReservationService srvc = new ReservationService(club);

        club.AddCourt((new Court("Court Two")));
        ReservationResponse response = srvc.ReserveCourtService("Court Two",10,new Date(2016,10,31),4,5);
        Assert.assertEquals(true,response.Success);

    }

    @Test
    public void reservingTwoEmptySlotsInTheSameCourtSucceeds() {
        final Club club = new Club();
        final ReservationService srvc = new ReservationService(club);

        club.AddCourt((new Court("Court Three")));

        ReservationResponse response = srvc.ReserveCourtService("Court Three",10,new Date(2016,10,31,10,0,0),4,5);
        ReservationResponse responseTwo = srvc.ReserveCourtService("Court Three",10,new Date(2016,10,31,12,0,0),4,5);

        Assert.assertEquals(true,response.Success);
    }

    @Test
    public void reservingTwoSlotsInTheSameCourtInTheSameTimFails() {
        final Club club = new Club();
        final ReservationService srvc = new ReservationService(club);

        club.AddCourt((new Court("Court Three")));

        ReservationResponse response = srvc.ReserveCourtService("Court Three",10,new Date(2016,10,31,10,0,0),4,5);
        ReservationResponse responseTwo = srvc.ReserveCourtService("Court Three",10,new Date(2016,10,31,10,0,0),4,5);

        Assert.assertEquals(true,response.Success);
        Assert.assertEquals(false,responseTwo.Success);
    }

    @Test
    public void reservingNonExistingCourtFails() {
        final Club club = new Club();
        final ReservationService srvc = new ReservationService(club);

        ReservationResponse response = srvc.ReserveCourtService("Court Three",10,new Date(2016,10,31,10,0,0),4,5);

        Assert.assertEquals(false,response.Success);
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

    @Test
    public void SuccessfulPaymentTestWithExtraChange() {

        Reservation rev1 = new Reservation(new Date(2016,10,30, 10,00, 00),10,1,4, 5 );

        CheckoutResponse resp = ClubServices.ChekoutService(rev1, 30);

        Assert.assertEquals(resp.Success, true);
        Assert.assertEquals(resp.Change, 10);
    }

    @Test
    public void PassSuccessfulCheckoutInputsToMainCommandLine() {
        ByteArrayOutputStream BAout = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(BAout);
        Main.CheckoutCommand(new String[]{"Checkout","10","20"},out);
        String content = new String(BAout.toByteArray(), StandardCharsets.UTF_8);
        Assert.assertEquals("Checkout Done Successfully",content);
    }

    @Test
    public void PassSuccessfulReserveInputsToMainCommandLine() {
        ByteArrayOutputStream BAout = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(BAout);
        Main.ReserveCommand(new String[]{"Reserve", "10", "4" ,"5"},out);
        String content = new String(BAout.toByteArray(), StandardCharsets.UTF_8);
        Assert.assertEquals("Reservation Service Done Successfully",content);
    }

    @Test
    public void PassInvalidCommandToMainCommandLine() {
        ByteArrayOutputStream BAout = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(BAout);
        Main.ReserveCommand(new String[]{"Hamada", "10", "4" ,"5"},out);
        Main.CheckoutCommand(new String[]{"Hamada", "10", "4" ,"5"},out);
        String content = new String(BAout.toByteArray(), StandardCharsets.UTF_8);
        Assert.assertEquals("",content);
    }




    @Test
    public void get_reservation_by_id_test_should_not_return_null() {
        ReservationRepository repo = new ReservationRepository();
        Assert.assertNotEquals(null,repo.GetreservationById(10));
    }
}
