package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int index;
    int value;

    public Node(int index, int value){
        this.index = index;
        this.value = value;
    }
}

public class Beak_1753 {

    static ArrayList<Node>[] connection;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        connection = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            connection[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];
        arr = new int[n+1];
        Arrays.fill(arr, Integer.MAX_VALUE);

        int start = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            connection[a].add(new Node(b,c));
        }

        dijkstra(start);
        for(int i=1; i< arr.length; i++){
            if(arr[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(arr[i]);
            }
        }


    }
    static void dijkstra(int start){
        Queue<Node> q = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        arr[start] = 0;
        q.add(new Node(start,0));
        visited[start] = true;

        while(!q.isEmpty()){
            Node now = q.poll();
            visited[now.index] = true;

            for(Node next : connection[now.index]){
                if(!visited[next.index] && arr[next.index] > now.value + next.value){
                    arr[next.index] = now.value + next.value;
                    q.add(new Node(next.index,next.value));
                }
            }

        }
    }
}
