//package gold.fail;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Beak_2098 {
//
//    static int[][] array;
//    static int n;
//    static int min = Integer.MAX_VALUE;
//
//    static boolean[] visited;
//
//    public static void dfs(int depth, int before, int sum, int start){
//        if(depth == n){
//            min = Math.min(min, sum + array[before][start]);
//            return;
//        }
//        for(int i=0; i<n; i++){
//            if(!visited[i]){
//                visited[i] = true;
//                sum += array[before][i];
//                if(sum < min){
//                    dfs(depth+1, i, sum, start);
//                }
//                sum -= array[before][i];
//                visited[i] = false;
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//        visited = new boolean[n];
//        array = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < n; j++) {
//                array[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        for(int i = 0; i < n; i++){
//            visited[i] = true;
//            dfs(1, i, 0, i);
//            visited[i] = false;
//        }
//        System.out.println(min);
//
//    }
//}
