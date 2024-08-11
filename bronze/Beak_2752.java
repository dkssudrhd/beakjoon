package bronze;

import java.io.*;
import java.util.*;

public class Beak_2752 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<3; i++){
            queue.add(Integer.valueOf(st.nextToken()));
        }
        while(!queue.isEmpty()){
            System.out.print(queue.remove() + " ");
        }
    }

}