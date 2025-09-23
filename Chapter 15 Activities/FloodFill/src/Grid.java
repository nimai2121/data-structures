//. . .
import java.util.Stack;

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    //. . .

    

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(row, column));
        int counter = 1;
        //. . .
        while (!stack.isEmpty())
        {
            Pair p = stack.pop();
            int r = p.getRow();
            int c = p.getColumn();
            /* if (r >= 0 && r < SIZE && c >= 0 && c < SIZE && pixels[r][c] == 0)
            {
                pixels[r][c] = counter++;
                stack.push(new Pair(r - 1, c)); // up
                stack.push(new Pair(r + 1, c)); // down
                stack.push(new Pair(r, c - 1)); // left
                stack.push(new Pair(r, c + 1)); // right
            }*/

            if (pixels[r][c] == 0)
            {
                pixels[r][c] = counter++;
                if (r > 0 && pixels[r - 1][c] == 0) {
                    stack.push(new Pair(r - 1, c));
                } // up
                if (r < 9 && pixels[r + 1][c] == 0) {
                    stack.push(new Pair(r + 1, c));
                } // down
                if (c > 0 && pixels[r][c - 1] == 0) {
                    stack.push(new Pair(r, c - 1));
                } // left
                if (c < 9 && pixels[r][c + 1] == 0) {
                    stack.push(new Pair(r, c + 1));
                } // right
            }
        }
        /*for (int r = row; r < SIZE; r++) {
            for (int c = column; c < SIZE; c++) {
                pixels[r][c] = 0;
            }
        }*/
        //System.out.println(stack.toString());
    }

    //@Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%3d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
