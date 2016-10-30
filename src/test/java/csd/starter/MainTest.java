package csd.starter;

import org.junit.Assert;
import org.junit.Test;

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
}
