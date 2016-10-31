package csd.starter;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        UIInteractive interactive = new UIInteractive();
        interactive.SetupData();

        if(args.length == 0)
            interactive.Reserve(null);
        else
            interactive.Reserve(args[0]);
    }
}
