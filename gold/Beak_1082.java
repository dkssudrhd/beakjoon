package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_1082 {
    static int n, m;
    static int[] p;
    static int smallNumber;
    static int small;
    static int smallNumberNotZero = Integer.MAX_VALUE;
    static int smallNotZero;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer ="";

        n = Integer.parseInt(br.readLine());
        p = new int[n];

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        p[0] = Integer.parseInt(st.nextToken());
        smallNumber = p[0];
        for(int i=1; i<n; i++){
            p[i] = Integer.parseInt(st.nextToken());
            if(p[i] <= smallNumber){
                smallNumber = p[i];
                small = i;
            }
            if(p[i] <= smallNumberNotZero){
                smallNumberNotZero = p[i];
                smallNotZero = i;
            }
        }

        m = Integer.parseInt(br.readLine());



        if(m - smallNumberNotZero < 0 || n == 1){
            System.out.println("0");
            return;
        }

        answer = smallNotZero + "";
        int answerCount = (m-smallNumberNotZero)/smallNumber;
        int remain = (m-smallNumberNotZero)%smallNumber;

        for(int i=0; i<answerCount; i++){
            answer += small;
        }


        String priAnswer = "";
        int priAnswerSize = 0;

        for(int i=0; i< answerCount; i++){
            if(i==0) {
                for (int j = n - 1; j >= 0; j--) {
                    if (p[j] - smallNumberNotZero <= remain) {
                        remain -= (p[j] - smallNumberNotZero);
                        priAnswer += j + "";
                        break;
                    }
                }
            } else{
                for (int j = n - 1; j >= 0; j--) {
                    if (p[j] - smallNumber <= remain) {
                        remain -= (p[j] - smallNumber);
                        priAnswer += j + "";
                        break;
                    }
                }
            }

            if(remain <= 0 &&  priAnswerSize == priAnswer.length()){
                break;
            }
            priAnswerSize++;
        }
        System.out.println(priAnswer + answer.substring(priAnswerSize));
    }
}
