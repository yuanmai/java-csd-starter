package csd.starter;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.fail;

public class MainTest {

    @Test
    public void test() {
        Assert.assertEquals(true, ReserveClass.Reserve(1));
        Assert.assertEquals(false, ReserveClass.Reserve(1));
    }
}
