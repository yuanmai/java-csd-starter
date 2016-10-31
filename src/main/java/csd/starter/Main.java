package csd.starter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static databaseEntry databaseObj;
    public static databaseHandler dbHandler = new databaseHandler();

    public static void addEntryInDB(List<databaseEntry> entries) throws IOException {
        try
        {
            dbHandler.addEntry(entries);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<databaseEntry> entries = new ArrayList<databaseEntry>();
        do
        {
            databaseObj = new databaseEntry();
            System.out.println("Enter your username : ");
            String userName = br.readLine();
            databaseObj.setUsername(userName);

            System.out.println("Enter your selected date/Time : ");
            String time = br.readLine();
            databaseObj.setDateTime(time);

            databaseObj.setCourtNumber();


            databaseObj.setRID();
            entries.add(databaseObj);
            System.out.println("If you want to add another entry, type yes, otherwise type done.");
        }while(!br.readLine().equals("done"));



        addEntryInDB(entries);

    }
}
