package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak_15989 {
    public static void main(String[] args) throws IOException {
        int[][] numbers = new int[10001][4];

        numbers[1][1] = 1;
        numbers[2][1] = 1;
        numbers[2][2] = 1;
        numbers[3][1] = 1;
        numbers[3][2] = 1;
        numbers[3][3] = 1;


        for(int i=4; i<=10000; i++){
            numbers[i][1] = numbers[i-1][1];
            numbers[i][2] = numbers[i-2][1] + numbers[i-2][2];
            numbers[i][3] = numbers[i-3][1] + numbers[i-3][2] + numbers[i-3][3];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int number=Integer.parseInt(br.readLine());
            int size = numbers[number][1] + numbers[number][2] + numbers[number][3];
            sb.append(size).append("\n");
        }
        System.out.print(sb.toString());
    }
}
