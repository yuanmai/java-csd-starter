package csd.starter;

import java.util.ArrayList;

/**
 * Created by ndaoud on 30-Oct-16.
 */
public class Club {
    public ArrayList<Court> Courts = new ArrayList<Court>();

    public void AddCourt(Court newCourt) {
        Courts.add(newCourt);
    }

    public Court GetCourtByName(String name) {
        for(Court item :Courts)
        {
            if(item.Name == name)
                return item;
        }
        return null;
    }
}
