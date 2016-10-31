package csd.starter;

import org.junit.*;

import java.util.*;

public class MainTest {

    @Test
    public void As_tennis_player_Want_to_make_reservation_online_so_that_I_can_start_playing_when_I_arrive() {
        Player tennisPlayer = new Player("Ahmed");
        Manager manager = new Manager("Zaazaa");
        PremiumPlayer prePlayer = new PremiumPlayer("ElFoly");
        Court court = new Court();
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
}
