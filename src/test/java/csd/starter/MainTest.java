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

//    @Test
//    public void size_should_be_increased_by_one_after_pushing() {
//        queue.add("First Element"); //Act SUT (system/subsystem Under Test)
//
//        Assert.assertEquals(1, queue.size()); //Assert
//    }
//
//    @Test(expected = NoSuchElementException.class)
//    public void popping_an_empty_queue_shall_throw_exception() {
//        queue.remove();
//    }

    @Test
    public void premium_user_reserve_one_slot(){
        PremiumPlayer premPlayer = new PremiumPlayer("Ahmed");
        Court court = new Court("court_A", 10, 100);
        court.Name = "B1";
        Club club = new Club();
        Reservation resev = new Reservation(new Date(116, 10, 10, 11, 0),
                new Date(116, 10, 10, 13, 0),
                premPlayer, court);
        Assert.assertEquals(true, club.Reserve(resev));
    }

    @Test
    public void premium_user_request_schedule(){
        PremiumPlayer premPlayer = new PremiumPlayer("ZAAZAA");
        Court court = new Court("Court_B", 20, 100);
        Club club = new Club();
        Reservation resev = new Reservation(new Date(116, 10, 10, 11, 0),
                new Date(116, 10, 10, 13, 0),
                new Date(116, 11, 10, 13, 0),
                premPlayer, court, PremiumPlayer.scheduleType.weekly);

        Assert.assertEquals(true, club.Reserve(resev, PremiumPlayer.scheduleType.weekly));

    }

    @Test
    public void MainTest()
    {
        Main.main(new String[] { "Amir\r\n10-10-2010 10:10\r\n10\r\n10"});
    }
}
