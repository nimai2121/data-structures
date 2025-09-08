import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SudokuSolver {
    private final int M = 3;
    private final int N = M * M;
    private int[][] grid;
    private ArrayList<Set<Integer>> rows;
    private ArrayList<Set<Integer>> cols;
    private ArrayList<Set<Integer>> squares;
    private Set<Integer> nums;

    public SudokuSolver(String fileName) {
        // read the puzzle file
        System.out.println(System.getProperty("user.dir"));

        try (Scanner in = new Scanner(new File(fileName))) {

            this.grid = new int[N][N];

            for (int row = 0; row < N; row++) {
                String line = in.next();

                for (int col = 0; col < N; col++) {
                    String strVal = line.substring(col, col + 1);
                    int number;
                    if (strVal.equals("x")) {
                        number = 0;
                    } else {
                        number = Integer.parseInt(strVal);
                    }
                    this.grid[row][col] = number;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + fileName);
        }

        Set<Integer> losRow = new HashSet<>();
        rows = new ArrayList<>();
        //losRow.size[N];
       //System.out.println(grid);
        // create the list of sets for each row (this.rows)
        for (int i = 0; i < N; i++) { 
             //put each row in a set and then put it in a list. 
            for (int j = 0; j < N; j++) {  
                losRow.add(this.grid[i][j]);

                System.out.print(losRow);
                //rows.add(losRow);
                //System.out.println();
            }
            rows.add(losRow);
            System.out.println(losRow);

            losRow = new HashSet<>();
            
            

            //System.out.println(rows);
            
            
        }
        
        // ...

        // create the list of sets for each col (this.cols)
        // ...
        Set<Integer> losCol = new HashSet<>();
        cols = new ArrayList<>();

        for (int i = 0; i < N; i++) { 
             //put each row in a set and then put it in a list. 
            for (int j = 0; j < N; j++) {  

                losCol.add(this.grid[j][i]);

                System.out.print(losCol);
                //rows.add(losRow);
                //System.out.println();
            }
            cols.add(losCol);
            System.out.println(losCol);

            losCol = new HashSet<>();
            
            

            //System.out.println(rows);
            
            
        }



        // create the list of sets for each square (this.squares)
        /* the squares are added to the list row-by-row:
            0 1 2
            3 4 5
            6 7 8
         */
        // ...

        Set<Integer> losSqu = new HashSet<>();
        squares = new ArrayList<>();

        for (int i = 0; i < M; i++) { 
             //put each row in a set and then put it in a list. 
            for (int j = 0; j < M; j++) {  

                losSqu.add(this.grid[i][j]);

                System.out.print(losSqu);
                //rows.add(losRow);
                //System.out.println();
            }
            squares.add(losSqu);
            System.out.println(losSqu);

            losSqu = new HashSet<>();
            
            

            //System.out.println(rows);
            
            
        }


        

        // create a hash set for [1..9] (this.nums)
        // ...

        // visually inspect that all the sets are correct
        for (int row = 0; row < N; row++) {
            System.out.println("row " + row + ": " + this.rows.get(row));
        }
        for (int col = 0; col < N; col++) {
            System.out.println("col " + col + ": " + this.cols.get(col));
        }
        for (int square = 0; square < N; square++) {
            System.out.println("square " + square + ": " + this.squares.get(square));
        }
        System.out.println(this.nums);
    }

    public boolean solve() {
        // find an empty location, if any
        boolean finished = true;
        int nextRow = -1;
        int nextCol = -1;
        for (int row = 0; row < N && finished; row++) {
            for (int col = 0; col < N && finished; col++) {
                if (this.grid[row][col] == 0) {
                    finished = false;
                    nextRow = row;
                    nextCol = col;
                }
            }
        }

        // the board is complete; we solved it
        if (finished) {
            return true;
        }

        // get all possible numbers for the row and column we are trying to populate
        /*
            Create a new set based on the this.nums and remove all elements in the sets
            corresponding to nextRow, nextCol, and the corresponding square (use the
            removeAll method).

            Properly indexing the squares list of sets is tricky. Verify that your
            algorithm is correct.
         */
        Set<Integer> possibleNums = new HashSet<Integer>();
        possibleNums.addAll(this.nums);
        
        // ...

        // if there are no possible numbers, we cannot solve the board in its current state
        if (possibleNums.isEmpty()) {
            return false;
        }

        // try each possible number
        for (Integer possibleNum : possibleNums) {
            // update the grid and all three corresponding sets with possibleNum //add to all 3 sets
            // ...

            // recursively solve the board
            if (this.solve()) {
                // the board is solved!
                return true;
            } else {
                /*
                 Undo the move before trying another possible number by setting the corresponding
                 element in the grid back to 0 and removing possibleNum from all three corresponding
                 sets.
                 */
                // ...
            }
        }

        return false;
    }

    public String toString() {
        String str = "";

        for (int[] row : grid) {
            for (int val : row) {
                str += val + "\t";
            }

            str += "\n";
        }

        return str;
    }

    public static void main(String[] args) {
        String fileName = "Chapter 15 Activities/Sudoku/src/puzzle1.txt";

        SudokuSolver solver = new SudokuSolver(fileName);
        System.out.println(solver);
        if (solver.solve()) {
            System.out.println("Solved!");
            System.out.println(solver);
        } else {
            System.out.println("Unsolveable...");
        }
    }
}