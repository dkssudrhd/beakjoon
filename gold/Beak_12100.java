package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_12100 {

    static int max = 0;

    public static int max(int[][] array){
        int max = 0;
        for (int[] numbers : array) {
            for (int number : numbers) {
                if (number > max) {
                    max = number;
                }
            }
        }
        return max;
    }

    public static int[][] arrayCopy(int[][] array) {
        int[][] newArray = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(array[i], 0, newArray[i], 0, array[i].length);
        }
        return newArray;
    }

    public static void checking(int[][] array){
        for(int[] numbers: array){
            for (int number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public static void play(int[][] array, int n){
        if(n>5){
            int nowMax = max(array);
            if(max < nowMax){
                max = nowMax;
            }
            return;
        }
        int[][] upArray = arrayCopy(array);
        up(upArray);
        play(upArray, n+1);
        int[][] downArray = arrayCopy(array);
        down(downArray);
        play(downArray, n+1);
        int[][] leftArray = arrayCopy(array);
        left(leftArray);
        play(leftArray, n+1);
        int[][] rightArray = arrayCopy(array);
        right(rightArray);
        play(rightArray, n+1);

    }

    public static void up(int[][] array){
        for(int i=0; i<array.length; i++){
            int now = array[0][i];
            int nowJ = 0;
            for(int j=1; j<array[0].length; j++){
                if(now == 0){
                    now = array[j][i];
                } else if(array[j][i] == 0){
                    continue;
                }
                else if(now == array[j][i]){
                    array[nowJ++][i] = now *2;
                    now = 0;
                } else{
                    array[nowJ++][i] = now;
                    now = array[j][i];
                }
            }
            array[nowJ][i] = now;
            for(int j=nowJ+1; j<array[0].length; j++){
                array[j][i] = 0;
            }
        }
    }
    public static void down(int[][] array){
        for(int i=0; i<array.length; i++){
            int now = 0;
            int nowJ = array.length - 1;

            for(int j=1; j<=array.length; j++){
                if(now == 0){
                    now = array[array.length - j][i];
                } else if(array[array.length - j][i] == 0){
                    continue;
                } else if(now == array[array.length - j][i]){
                    array[nowJ--][i] = now*2;
                    now = 0;
                } else{
                    array[nowJ--][i] = now;
                    now = array[array[0].length - j][i];
                }
            }
            array[nowJ][i] = now;
            for(int j=0; j < nowJ ; j++){
                array[j][i] = 0;
            }
        }
    }

    public static void left(int[][] array){
        for(int i=0; i<array.length; i++){
            int now = array[i][0];
            int nowJ = 0;
            for(int j=1; j<array[0].length; j++){
                if(now == 0){
                    now = array[i][j];
                } else if(array[i][j] ==0){
                    continue;
                }
                else if(now == array[i][j]){
                    array[i][nowJ++] = now *2;
                    now = 0;
                } else{
                    array[i][nowJ++] = now;
                    now = array[i][j];
                }
            }
            array[i][nowJ] = now;
            for(int j=nowJ+1; j<array[0].length; j++){
                array[i][j] = 0;
            }
        }

    }

    public static void right(int[][] array){

        for(int i=0; i<array.length; i++){
            int now = 0;
            int nowJ = array[0].length - 1;

            for(int j=1; j<=array[0].length; j++){
                if(now == 0){
                    now = array[i][array[0].length - j];
                } else if(array[i][array[0].length - j] == 0){
                    continue;
                } else if(now == array[i][array[0].length - j]){
                    array[i][nowJ--] = now*2;
                    now = 0;
                } else{
                    array[i][nowJ--] = now;
                    now = array[i][array[0].length - j];
                }
            }
            array[i][nowJ] = now;
            for(int j=0; j < nowJ ; j++){
                array[i][j] = 0;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        play(array, 1);
        System.out.println(max);
    }


}
