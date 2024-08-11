package bronze;
import java.io.*;
import java.util.*;

public class Beak_14697 {

    public static boolean checking2(int n1, int n2, int number){
        int sumN1= 0;
        while(sumN1 <= number){
            int now = number-sumN1;
            if(now%n2 == 0){
                return true;
            }
            sumN1 += n1;
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());
        int c = Integer.valueOf(st.nextToken());
        int n = Integer.valueOf(st.nextToken());


        Boolean can = false;

        int sumA =0;
        while(sumA <= n){
            int now = n-sumA;
            if(checking2(b, c, now)){
                System.out.print(1);
                can = true;
                break;
            }
            sumA += a;
        }

        if(!can){
            System.out.print(0);
        }
    }

}