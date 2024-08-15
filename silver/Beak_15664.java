package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak_15664{
    static int n;
    static int m;
    static int[] numberList;
    static int[] arr;
    static int[] before;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numberList = new int[n];

        for(int i=0; i<n; i++){
            numberList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numberList);

        arr = new int[m];
        before = new int[m];
        dfs(0,0);
        System.out.print(sb);
        br.close();
    }
    private static void dfs(int depth, int start){
        if(depth==m){
            if(beforeIsNotEqual()){
                for(int num : arr){
                    sb.append(num).append(" ");
                }
                sb.append("\n");
            }
            return;
        }
        for(int i=start; i<numberList.length; i++){
            arr[depth] = numberList[i];
            dfs(depth+1, i+1);
        }
    }
    private static boolean beforeIsNotEqual(){
        boolean equire = true;
        for(int i =0; i< arr.length ; i++){
            if(arr[i] != before[i]){
                equire = false;
            }
            before[i] = arr[i];
        }
        return !equire;
    }
}
