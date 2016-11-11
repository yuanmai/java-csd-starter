package csd.starter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by matef1 on 10/30/2016.
 */
public class databaseEntry {

    private String username;
    private String dateTime;
    private String courtNumber;
    private String RID;
    private List<String> courtsList = Arrays.asList("C1", "C2", "C3");

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setDateTime(String dTime) {
        this.dateTime = dTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setCourtNumber() {
        if (courtsList.size() > 0) {
            this.courtNumber = courtsList.get(courtsList.size()-1);

            for (Iterator<String> iter = courtsList.listIterator(); iter.hasNext(); ) {
                String a = iter.next();
                if (this.courtNumber.equals(iter.toString())) {
                    iter.remove();
                }
            }

        }
    }

    public String getCourtNumber()

    {
        return courtNumber;
    }

    public void setRID() {
        String concString = this.courtNumber + this.dateTime;
        this.RID = concString;
    }

    public String getRID() {
        return RID;
    }
}
