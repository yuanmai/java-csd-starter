package csd.starter;

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
