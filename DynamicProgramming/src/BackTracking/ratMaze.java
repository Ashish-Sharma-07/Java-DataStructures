package BackTracking;

public class ratMaze {

    private static int N =4;

    private static boolean isSafe(int x,int y, int prb[][])
    {
        return(x>=0 && x< N && y>=0 && y <N && prb[x][y]==0);
    }

    private static void printSol(int sol[][])
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
                System.out.print("\t"+sol[i][j]);
            System.out.println();
        }

    }

    private static boolean solveMaze(int x,int y,int xMove[],int yMove[],int prob[][],int sol[][])
    {
        int next_x,next_y;
        if((x+1)*(y+1)==N*N)
            return true;
        for(int i=0;i<2;i++)
        {
            next_x = x+xMove[i];
            next_y = y+yMove[i];
            if(isSafe(next_x,next_y,prob))
            {
                sol[next_x][next_y] = 1;
                if(solveMaze(next_x,next_y,xMove,yMove,prob,sol))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int xMove[]={1,0};
        int yMove[]={0,1};

        int prob[][]={
                {0,0,0,1},
                {1,1,0,1},
                {1,1,0,1},
                {1,0,1,0}
        };
        int sol[][] = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };

        sol[0][0] = 1;
        if(!solveMaze(0,0,xMove,yMove,prob,sol))
            System.out.println("Cant Solve the maze");
        else
            printSol(sol);

    }
}
