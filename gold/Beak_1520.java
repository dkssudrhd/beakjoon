package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Road{
    int x;
    int y;
    int size;

    public Road(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
    }
}

public class Beak_1520 {

    static int[][] board;
    static int n, m;
    static int count =0;
    static List<Road> roads = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        roads.add(new Road(0,0, board[0][0]));

        for(Road road : roads) {
            addList(road);
        }
        System.out.println(count);
    }

    public static void addList(Road road) {
        if(road.x ==n-1 && road.y ==m-1) {
            count++;
            return;
        }
        int x = road.x;
        int y = road.y;
        int size = road.size;
        if(x >0 && board[x-1][y] < size){
            addList(new Road(x-1, y, board[x-1][y]));
        }
        if(x<n-1 && board[x+1][y] < size){
            addList(new Road(x+1, y, board[x+1][y]));
        }
        if(y>0 && board[x][y-1] < size){
            addList(new Road(x, y-1, board[x][y-1]));
        }
        if(y<m-1 && board[x][y+1] < size){
            addList(new Road(x, y+1, board[x][y+1]));
        }
    }

}
