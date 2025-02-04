class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int ans = 0;

        // Initialize our board of size mxn
        Board board = new Board(m, n);

        // For every guard, set the coordinate of that guard to a g
        for (int[] g: guards) {
            board.setCoord(g[0], g[1], 2);
        }

        // For every wall, set the coordinate of that wall to a w
        for (int[] w: walls) {
            board.setCoord(w[0], w[1], 3);
        }

        // Using nested loops to print array readable
        // for (int i = 0; i < board.boardSpace.length; i++) {
        //     for (int j = 0; j < board.boardSpace[i].length; j++) {
        //         System.out.print(board.boardSpace[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        for (int i = 0; i < board.boardSpace.length; i++) {
            for (int j = 0; j < board.boardSpace[i].length; j++) {
                if(board.boardSpace[i][j] == 2) {
                    board.claimSquares(i, j);
                }
            }
        }

        for (int i = 0; i < board.boardSpace.length; i++) {
            for (int j = 0; j < board.boardSpace[i].length; j++) {
                if(board.boardSpace[i][j] == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }

}

class Board {
    int width;
    int height;
    int[][] boardSpace;
    
    public Board(int x, int y) {
        // For height = 3, width = 4
        // boardSpace[1][2] = 1
        // {{0, 0, 0, 0},
        //  {0, 0, 1, 0},
        //  {0, 0, 0, 0}}
        // 
        // 0 = ungarded (intended return)
        // 1 = protected
        // 2 = guard
        // 3 = wall
        width = y;
        height = x;
        boardSpace = new int[x][y];
        for(int i = 0; i < boardSpace.length; i++) {
            Arrays.fill(boardSpace[i], 0);
        }
        // Using nested loops to print array readable
        // for (int i = 0; i < boardSpace.length; i++) {
        //     for (int j = 0; j < boardSpace[i].length; j++) {
        //         System.out.print(boardSpace[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }

    public int getAtCoord(int x, int y) {
        // System.out.println("New New Crash: x: " + x + "y: " + y);
        return boardSpace[x][y];
    }

    public void setCoord(int x, int y, int value) {
        boardSpace[x][y] = value;
    }

    public void claimSquares(int x, int y) {
        // Claim to the up
        for(int i = x-1; i >= 0; i--) {
            if(boardSpace[i][y] != 3 && boardSpace[i][y] != 2) {
                setCoord(i, y, 1);
                continue;
            }
            break;
        }

        // Claim to the down
        for(int i = x+1; i < height; i++) {
            if(boardSpace[i][y] != 3 && boardSpace[i][y] != 2) {
                setCoord(i, y, 1);
                continue;
            }
            break;
        }

        // Claim to the left
        for(int i = y-1; i >= 0; i--) {
            if(boardSpace[x][i] != 3 && boardSpace[x][i] != 2) {
                setCoord(x, i, 1);
                continue;
            }
            break;
        }

        // Claim to the right
        for(int i = y+1; i < width; i++) {
            if(boardSpace[x][i] != 3 && boardSpace[x][i] != 2) {
                setCoord(x, i, 1);
                continue;
            }
            break;
        }
    }
}
