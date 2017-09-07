package BackTracking;

public class KnightMoves {

    //size of the board
    static final int N =8;

    static boolean isSafe(int x,int y,int sol[][])
    {
        return(x>=0&&x<N && y>=0&&y<N && sol[x][y]==-1);
    }

    static void printSol(int sol[][])
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                System.out.print(sol[i][j]+"\t");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        int[] xmove = {2, 1, -1, -2, -2, -1,  1,  2};
        int[] ymove = {1, 2,  2,  1, -1, -2, -2, -1};

        int sol[][] = new int[8][8];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                sol[i][j] = -1;
            }
        }

        //start at [0][0]
        sol[0][0]=0;
        if(!KnightUtil(0,0,sol,xmove,ymove,1))
            System.out.println("Cant Place the knight");
        else
            printSol(sol);

    }

    static boolean KnightUtil(int x,int y,int sol[][],int xMoves[],int yMoves[],int imoves)
    {
        int x_moves,y_moves;
        if(imoves ==N*N)
            return true;
        else
        {
              for(int j=0;j<8;j++)
                {
                    x_moves = x + xMoves[j];
                    y_moves = y + yMoves[j];

                    if(isSafe(x_moves,y_moves,sol))
                    {
                        sol[x_moves][y_moves] = imoves;
                        if(KnightUtil(x_moves,y_moves,sol,xMoves,yMoves,imoves+1))
                            return true;
                        else
                            sol[x_moves][y_moves]=-1;
                    }

                }
         }
        return false;
    }

}
