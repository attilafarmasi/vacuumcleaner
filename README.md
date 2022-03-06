# Robot vacuum cleaner
## Goal
* create a program, which can help vacuum-cleaners to clean up the whole area

## Methods
* clean() = clean the actual cell
* turnLeft() / turnRight() = vacuum-cleaner will stay on the same cell after calling turnLeft / turnRight (each turn will be 90 degrees)
* move() = returns true if next cell is free and vacuum-cleaner moves into the cell - returns false if next cell is obstacle and vacuum-cleaner stays on the actual cell
* visited() = returns true if cell is already cleaned
* moveBack() = cell is already cleaned, move back to the previous cell
* dfs() =

## Angles
* 0 (degree) = looking to the right
* 90 (degree) = looking to the top
* 180 (degree) = looking to the left
* 270 (degree) = looking to the bottom

## 2D view of the dirty area

     0   1   2   3
-------------------
 0 | W | D | W | D
-------------------
 1 | D | DS | D | D
-------------------
 2 | D | W | W | D
-------------------
 3 | D | D | D | D
-------------------
* D = dirty area
* W = wall or obstacle (fixed)
* S = strating point - can not be wall or obstacle

## 2D view of the cleaned area

     0   1   2   3
-------------------
0 | W | C | W | C
-------------------
1 | C | CE | C | C
-------------------
2 | C | W | W | C
-------------------
3 | C | C | C | C
-------------------
* C = cleaned area
* W = wall or obstacle (fixed)
* E = ending point

