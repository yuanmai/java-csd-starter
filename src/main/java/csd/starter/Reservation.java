package csd.starter;

import jdk.nashorn.internal.AssertsEnabled;
import org.joda.time.Days;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by akamel on 10/30/2016.
 */
public class Reservation {
    Date from;
    Date to;
    Date scheduleEndDate;
    User user;
    Court court;

    public Reservation(Date from, Date to, User user, Court court) {
        this.from = from;
        this.to = to;
        this.user = user;
        this.court = court;
    }

    public Reservation(Date from, Date to, Date endDate, User user, Court court, PremiumPlayer.scheduleType schedType) {

        int repetition = (schedType== PremiumPlayer.scheduleType.daily)? 1 :
                (schedType == PremiumPlayer.scheduleType.weekly)? 7 :
                        30;

        this.user = user;
        this.court = court;
        this.scheduleEndDate = endDate;

        Calendar fromCal = Calendar.getInstance();
        fromCal.setTime(from);

        System.out.println(fromCal);

        Calendar toCal = Calendar.getInstance();
        toCal.setTime(to);
        System.out.println(toCal);

        Calendar endDateCal = Calendar.getInstance();
        endDateCal.setTime(endDate);
        System.out.println(endDateCal);

//        System.out.println(fromCal.compareTo(endDateCal));

//        int i = 1;
        while(fromCal.compareTo(endDateCal) < 0 ){
//            System.out.println(i);
//            i++;
            this.from = from;
            this.to = to;
            fromCal.add(Calendar.DATE, repetition);
            toCal.add(Calendar.DATE, repetition);
        }


    }

}
