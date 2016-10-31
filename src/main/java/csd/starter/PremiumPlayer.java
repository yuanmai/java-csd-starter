package csd.starter;

import java.util.Date;

/**
 * Created by akamel on 10/30/2016.
 */
public class PremiumPlayer extends Player {

    public PremiumPlayer(String name){
        super(name, "Player");
    }

    public enum scheduleType{
        daily,
        weekly,
        monthly
    }
