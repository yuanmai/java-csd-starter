package csd.starter;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

import static csd.starter.Main.databaseObj;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MainTest
{
    Main m_test = new Main();
    @Before
    public void initiateMain()
    {
        m_test = new Main();
    }
    @Test
    public void test() throws IOException {
        databaseEntry databaseObjIntest = new databaseEntry();
        databaseObjIntest.setUsername("Mohamed");
        databaseObjIntest.setDateTime("Today");
        databaseObjIntest.setCourtNumber();
        databaseObjIntest.setRID();

        m_test.addEntryInDB(databaseObjIntest);

        assertEquals("Mohamed", databaseObjIntest.getUsername());
        assertEquals("Today", databaseObjIntest.getDateTime());
        assertEquals("C3", databaseObjIntest.getCourtNumber());
        assertEquals(databaseObjIntest.getCourtNumber()+databaseObjIntest.getDateTime(), databaseObjIntest.getRID());
    }
}
