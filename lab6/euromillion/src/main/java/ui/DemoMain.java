package ui;

import euromillions.CuponEuromillions;
import euromillions.Dip;
import euromillions.EuromillionsDraw;
import java.util.logging.Logger;
import java.util.logging.Level;

public class DemoMain {

    /**
     * demonstrates a client for ramdom euromillions bets
     */
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(DemoMain.class.getName());

        // played sheet
        CuponEuromillions thisWeek = new CuponEuromillions();
        logger.log(Level.FINE, "Betting with three random bets...");
        thisWeek.addDipToCuppon(Dip.generateRandomDip());
        thisWeek.addDipToCuppon(Dip.generateRandomDip());
        thisWeek.addDipToCuppon(Dip.generateRandomDip());

        // simulate a random draw
        EuromillionsDraw draw = EuromillionsDraw.generateRandomDraw();

        //report results
        logger.log(Level.FINE, "You played:");
        String weekFormat = thisWeek.format();
        logger.fine(weekFormat);

        logger.log(Level.FINE, "Draw results:");
        String drawFormat = draw.getDrawResults().format();
        logger.fine(drawFormat);

        logger.log(Level.FINE, "Your score:");
        for (Dip dip : draw.findMatches(thisWeek)) {
            String dipFormat = dip.format();
            logger.fine(dipFormat);

        }
    }
}
