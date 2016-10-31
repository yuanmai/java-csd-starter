package csd.starter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static databaseEntry databaseObj;
    public static databaseHandler dbHandler = new databaseHandler();

    public static void addEntryInDB(databaseEntry databaseObj) throws IOException {
        try
        {
            dbHandler.addEntry(databaseObj);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws IOException
    {
        databaseObj = new databaseEntry();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your username : ");
        String userName = br.readLine();
        databaseObj.setUsername(userName);

        System.out.println("Enter your selected date/Time : ");
        String time = br.readLine();
        databaseObj.setDateTime(time);

        databaseObj.setCourtNumber();


        databaseObj.setRID();

        addEntryInDB(databaseObj);

    }
}
