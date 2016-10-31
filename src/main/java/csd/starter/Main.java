package csd.starter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        databaseEntry databaseObj = new databaseEntry();
        databaseHandler dbHandler = new databaseHandler();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your username : ");
        String userName = br.readLine();
        databaseObj.setUsername(userName);

        System.out.println("Enter your selected date/Time : ");
        String time = br.readLine();
        databaseObj.setDateTime(time);

        databaseObj.setCourtNumber();


        databaseObj.setRID();

        dbHandler.addEntry(databaseObj);

    }
}
