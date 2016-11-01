package csd.starter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by amir on 10/31/2016.
 */
public class PlayerTest {

    @Before
    public void PrepareTest()
    {
        Club.ActiveClub.courts.add(new Court("CourtA", 10, 10));
        Club.ActiveClub.courts.add(new Court("CourtB", 5, 5));
        Club.ActiveClub.courts.add(new Court("CourtC", 1, 1));
    }

    @Test
    public void player_can_get_the_nearest_court_to_him()
    {
        Player player = new Player("Player A");
        Court court = player.getNearestCourt(6,6);
        Assert.assertEquals("CourtB", court.Name);
    }
}
