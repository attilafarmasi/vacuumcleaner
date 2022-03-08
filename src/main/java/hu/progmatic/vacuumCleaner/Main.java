package hu.progmatic.vacuumCleaner;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] myApartment = {
                {"O", "D", "D", "D", "W", "D", "D", "W", "O", "D", "O", "O"},
                {"O", "D", "O", "D", "W", "D", "D", "W", "D", "D", "D", "D"},
                {"O", "D", "O", "D", "W", "D", "D", "W", "D", "W", "W", "W"},
                {"O", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D"},
                {"D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "O", "O"},
                {"D", "D", "D", "D", "W", "D", "O", "O", "O", "D", "O", "O"}};

        RobotVacuumCleaner protoType = new RobotVacuumCleaner(90, 5, 1, myApartment);

        if (myApartment[protoType.getStartingRow()][protoType.getStartingCol()].equals("W")) {
            System.out.println("Wrong starting point: Wall or Obstacle!");
            System.out.println("Please set the vacuum-cleaner to a free cell!");
            return;
        }
        System.out.println(Arrays.deepToString(myApartment));
        protoType.cleaningProcess();
    }
}
