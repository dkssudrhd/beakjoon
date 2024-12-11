package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Box{
    int a;
    int b;

    public Box(int a, int b){
        this.a = a;
        this.b = b;
    }
}


/**
 * 문제의 핵심이 기한이 가장 적게 남은 기프티콘만 사용할 수 있다.
 * 1. 먼저 입력값 받아오기
 * 2. 남은 기간으로 정렬
 * 3. poll 기간이 안되면 다시 넣기 유효기간 추가하고
 */
public class Beak_17420 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = 0;

        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());

        PriorityQueue<Box> pq = new PriorityQueue<>((o1, o2) -> o1.a - o2.a);
        PriorityQueue<Integer> pqB = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int A = Integer.parseInt(stA.nextToken());
            int B = Integer.parseInt(stB.nextToken());
            pqB.add(B);
            pq.offer(new Box(A, B));
        }

        int nowB = pqB.poll();
        while(!pq.isEmpty()){
            Box box = pq.poll();
            if(box.a < nowB){
                int k = (nowB - box.a)/30;
                if((nowB - box.a)%30 !=0){
                    k++;
                }
                box.a += 30 *k;
                sum += k;
                pq.offer(box);
            }else if(box.b == nowB){
                if(pqB.isEmpty())
                    break;
                nowB = pqB.poll();
            }else{
                box.a += 30;
                sum++;
                pq.offer(box);
            }
        }
        System.out.println(sum);

    }
}