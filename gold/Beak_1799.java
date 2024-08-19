package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Playground {
    int count;
    boolean[][] board;
    int bishops = 0;

    public void addBishop() {
        bishops++;
    }

    public Playground(int count, boolean[][] board) {
        this.count = count;
        this.board = board;
    }

    public Playground(Playground before) {
        this.count = before.count;
        this.bishops = before.bishops;
        board = new boolean[before.board.length][before.board[0].length];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(before.board[i], 0, board[i], 0, board[0].length);
        }
    }
    public void boardChange(int x, int y){
        count--;
        board[x][y] = false;

        detailChange(x, y, -1, -1);
        detailChange(x, y, 1, -1);
        detailChange(x, y, -1, 1);
        detailChange(x, y, 1, 1);
    }

    public void detailChange(int x, int y, int changeX, int changeY){
        while(x>=0 && y>=0 && x<board.length && y<board[0].length){
            if(board[x][y]){
                board[x][y] = false;
                count--;
            }
            x += changeX;
            y += changeY;
        }
    }
}

public class Beak_1799 {

    static int[] max = new int[2];

    static void playing(Playground playground, int startX, int startY, int color) {
        boolean yes= true;

        if(max[color] < playground.bishops){
            max[color] = playground.bishops;
        }
        if(playground.count ==0)
            return;

        for(int i = startX; i < playground.board.length; i++) {
            for(int j = 0; j < playground.board[0].length; j++) {
                if(i == startX && yes  ){
                    j = startY;
                    yes = false;
                }
                if(playground.board[i][j] && ((i+j)%2 == color)) {
                    Playground copy = new Playground(playground);
                    copy.boardChange(i, j);
                    copy.addBishop();
                    playing(copy, i, j, color);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());

        boolean[][] board = new boolean[n][n];

        int count =0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    count++;
                    board[i][j] = true;
                }
            }
        }
        Playground first = new Playground(count, board);
        playing(first, 0, 0, 0);
        playing(first, 0, 1, 1);

        System.out.println(max[0] + max[1]);
        br.close();
    }

}
