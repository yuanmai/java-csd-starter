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
        Court court = new Court();
        Reservation resev = new Reservation(new Date(1000), new Date(2000), tennisPlayer, court);


        Assert.assertEquals(true, court.Reserve(resev));
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
