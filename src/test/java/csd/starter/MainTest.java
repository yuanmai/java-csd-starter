package csd.starter;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class MainTest {

    @Test
    public void test() {

        Player tennisPlayer = new Player();
        Manager manager = new Manager();
        PremiumPlayer prePlayer = new PremiumPlayer();
        Court court = new Court("CourtA", 10, 10);
        Reservation resev = new Reservation(new Date(1000), new Date(2000), tennisPlayer, court);
        Assert.assertEquals(true, court.Reserve(resev));
    }
}
