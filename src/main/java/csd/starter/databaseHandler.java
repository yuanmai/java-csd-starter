package csd.starter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by matef1 on 10/30/2016.
 */
public class databaseHandler {
    private final static String DATABASE_ENTRY = "%s   %s  %s  %s";

    public void addEntry(List<databaseEntry> entries) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\moatef\\Desktop\\ScrumCode\\database.txt"));

        for (int i = 0; i < entries.size(); i++) {
            String writtenLine = String.format(DATABASE_ENTRY, entries.get(i).getUsername(), entries.get(i).getDateTime(), entries.get(i).getCourtNumber(), entries.get(i).getRID());
            writer.write(writtenLine);
            writer.newLine();
        }

        writer.close();
    }

}
