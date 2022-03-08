package hu.progmatic.vacuumCleaner;

import java.util.Arrays;
import java.util.HashSet;

public class RobotVacuumCleaner {
    private final int startingAngle;
    private final int startingRow;
    private final int startingCol;
    private int angle;
    private int row;
    private int col;
    private final HashSet<String> cleanedCells = new HashSet();
    private final String[][] room;

    public RobotVacuumCleaner(int startingAngle, int startingRow, int startingCol, String[][] room) {
        this.startingAngle = startingAngle;
        this.startingRow = startingRow;
        this.startingCol = startingCol;
        this.angle = startingAngle;
        this.row = startingRow;
        this.col = startingCol;
        this.room = room;
    }

    public int getStartingRow() {
        return startingRow;
    }

    public int getStartingCol() {
        return startingCol;
    }

    public void cleaningProcess() {
        if (visited()) {
            moveBack();
            return;
        }
        System.out.println("Sarting cleaningProcess on (" + row + "," + col + ")");
        clean();
        if (move()) {
            cleaningProcess();
        }
        turnLeft();
        if (move()) {
            cleaningProcess();
        }
        turnLeft();
        if (move()) {
            cleaningProcess();
        }
        turnLeft();
        if (move()) {
            cleaningProcess();
        }
        turnLeft();
        if (angle == startingAngle && row == startingRow && col == startingCol) {
            System.out.println("Cleaned all the cells and back to starting point.");
            System.out.println("Cleaned cells: " + cleanedCells.toString());
            System.out.println(Arrays.deepToString(room));
            System.out.println("The area is completely clean and we are happy!");
            return;
        }
        System.out.println("Explored all directions (" + row + "," + col + ")");
        System.out.println("Moving back to previous cell");
        moveBack();
    }

    private boolean move() {
        switch (angle) {
            case 0:
                if (col + 1 < room[0].length && !(room[row][col + 1].equals("W") || room[row][col + 1].equals("O"))) {
                    col++;
                    System.out.println("Moved to next column (" + row + "," + col + ")");
                    return true;
                } else {
                    System.out.println("Move failed. Wall or Obstacle detected to the right of (" + row + " " + col + ")");
                }
                break;
            case 90:
                if (row - 1 >= 0 && !(room[row - 1][col].equals("W") || room[row - 1][col].equals("O"))) {
                    row--;
                    System.out.println("Moved to previous row (" + row + "," + col + ")");
                    return true;
                } else {
                    System.out.println("Move failed. Wall or Obstacle detected at the top of (" + row + "," + col + ")");
                }
                break;
            case 180:
                if (col - 1 >= 0 && !(room[row][col - 1].equals("W") || room[row][col - 1].equals("O"))) {
                    col--;
                    System.out.println("Moved to previous column (" + row + "," + col + ")");
                    return true;
                } else {
                    System.out.println("Move failed. Wall or Obstacle detected to the left of (" + row + "," + col + ")");
                }
                break;
            case 270:
                if (row + 1 < room.length && !(room[row + 1][col].equals("W") || room[row + 1][col].equals("O"))) {
                    row++;
                    System.out.println("Moved to next row (" + row + "," + col + ")");
                    return true;
                } else {
                    System.out.println("Move failed. Wall or Obstacle detected at the bottom of (" + row + "," + col + ")");
                }
                break;
        }
        return false;
    }

    private void turnLeft() {
        System.out.println("Current Direction: " + angle);
        angle = (angle + 90) % 360;
        System.out.println("Turned Left. New Direction: " + angle);
    }

    private void turnRight() {
        System.out.println("Current Direction: " + angle);
        if (angle == 0) {
            angle = 270;
            System.out.println("Turned Right. New Direction: " + angle);
            return;
        }
        angle = (angle - 90) % 360;
        System.out.println("New Direction: " + angle);
    }

    private void clean() {
        String cell = "(" + row + "," + col + ")";
        room[row][col] = "C";
        System.out.println("Cleaning current cell " + cell);
        cleanedCells.add(cell);
        System.out.println("Cleaned cells: " + cleanedCells.toString());
    }

    private boolean visited() {
        String cell = "(" + row + "," + col + ")";
        if (cleanedCells.contains(cell)) {
            System.out.println("Current cell (" + row + "," + col + ") is already cleaned. Move back to previous cell");
            return true;
        }
        return false;
    }

    private void moveBack() {
        turnRight();
        turnRight();
        move();
        turnRight();
        turnRight();
    }
}
