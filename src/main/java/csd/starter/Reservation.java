package csd.starter;

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

        Calendar toCal = Calendar.getInstance();
        toCal.setTime(to);

        Calendar endDateCal = Calendar.getInstance();
        endDateCal.setTime(endDate);

        while(fromCal.compareTo(endDateCal) < 0 ){
            this.from = from;
            this.to = to;
            fromCal.add(Calendar.DATE, repetition);
            toCal.add(Calendar.DATE, repetition);
        }


    }

}
