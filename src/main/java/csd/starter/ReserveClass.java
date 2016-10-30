package csd.starter;

/**
 * Created by amir on 10/30/2016.
 */
public class ReserveClass {
    static int lastReserve = -1;
    public static boolean Reserve(int i) {
        if(lastReserve != -1)
        {
            return false;
        }
        lastReserve = i;
        return true;
    }
}
