package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Beak_2239 {

    static int[][] board;
    static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[10][10];

        for(int i=1; i<=9 ; i++){
            String line = br.readLine();
            for(int j=1; j<=9; j++){
                board[i][j] = line.charAt(j-1) - '0';
                if(board[i][j] == 0){
                    count++;
                }
            }
        }

        System.out.println(count);

        List<Integer>[][] can = new ArrayList[10][10];
        for(int i=1; i<=9 ; i++){
            for(int j=1; j<=9; j++){
                can[i][j] = new ArrayList<>();
            }
        }
    }
}
