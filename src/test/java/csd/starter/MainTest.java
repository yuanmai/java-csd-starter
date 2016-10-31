package csd.starter;

import org.junit.*;

import java.util.*;

public class MainTest {

    @Test
    public void As_tennis_player_Want_to_make_reservation_online_so_that_I_can_start_playing_when_I_arrive() {
        Player tennisPlayer = new Player("Ahmed");
        Manager manager = new Manager("Zaazaa");
        PremiumPlayer prePlayer = new PremiumPlayer("ElFoly");
        Court court = new Court("CourtA", 10, 10);
        Club club = new Club();
        Reservation resev = new Reservation(new Date(116, 10, 10, 11, 0), new Date(116, 10, 10, 13, 0), tennisPlayer, court);
        Assert.assertEquals(true, club.Reserve(resev));
    }

    @Test
    public void test_ui_interaction()
    {
        Main.main(new String[] { "Amir\r\n10-10-2010 10:10\r\n10\r\n10"});
    }
}
