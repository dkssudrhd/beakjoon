package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak_2590 {
    static int n;
    static int[] board = new int [7];
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            board[Integer.parseInt(br.readLine())]++;
        }
        //6번처리
        sum = board[6];
        n -= board[6];

        //5번처리
        sum += board[5];
        n -= board[5];

        //5-1번처리
        if(board[1] >= 11 * board[5]){
            board[1] -= board[5] * 11;
            n -= board[5] * 11;
        }else{
            n -= board[1];
            board[1] = 0;
        }

        // 4번처리
        sum += board[4];
        n -= board[4];

    }
}
