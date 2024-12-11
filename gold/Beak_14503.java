package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_14503 {

    static int[][] room;
    static int r, c, d;
    static int count=0;
    static int[][] turn = {{-1,0}, {0,1}, {0,-1}, {1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        room = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

    }

    public void clean(){
        if(room[r][c] == 0){
            room[r][c] = 1;
            count++;
        }else if(room[r+1][c] == 0){
            r++;
        }else if(room[r][c-1] == 0){
            c--;
        }else if(room[r-1][c] == 0){
            r--;
        }else if(room[r][c+1] == 0){
            c++;
        }
    }
}
