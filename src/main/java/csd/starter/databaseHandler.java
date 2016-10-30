package csd.starter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by matef1 on 10/30/2016.
 */
public class databaseHandler {
    private final static String DATABASE_ENTRY = "%s   %s  %s  %s";

    public void addEntry(databaseEntry databaseObject) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\moatef\\Desktop\\ScrumCode\\database.txt"));

        String writtenLine = String.format(DATABASE_ENTRY, databaseObject.getUsername(), databaseObject.getDateTime(), databaseObject.getCourtNumber(), databaseObject.getRID());
        writer.write(writtenLine);

        writer.close();
    }

}
