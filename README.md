# Robot vacuum cleaner
## Goal
* create a program, which can help vacuum-cleaners to clean up the whole area

## Methods
* clean() = clean the actual cell
* turnLeft() / turnRight() = vacuum-cleaner will stay on the same cell after calling turnLeft / turnRight (each turn will be 90 degrees)
* move() = returns true if next cell is free and vacuum-cleaner moves into the cell - returns false if next cell is wall/obstacle and vacuum-cleaner stays on the actual cell
* visited() = returns true if cell is already cleaned
* moveBack() = cell is already cleaned, move back to the previous cell
* cleaningProcess() = collects and manages th rest of the methods 

## Angles
* 0 (degree) = looking to the right
* 90 (degree) = looking to the top
* 180 (degree) = looking to the left
* 270 (degree) = looking to the bottom


