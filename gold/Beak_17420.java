package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Box{
    int a;
    int b;

    public Box(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int aSetting(int nowDay){
        int k = (nowDay - a)/30;
        if((nowDay-a)%30 != 0){
            k++;
        }
        a += 30*k;
        System.out.println("now a: " + a + " now b : " + b);
        return k;
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
        List<Box> boxes = new ArrayList<>();        // 같은 기한의
        int boxesA = -1;

        while(!pq.isEmpty()){
            Box box = pq.poll();

            if(box.a < nowB){                       // 기한이 다된 기프티콘
                sum += box.aSetting(nowB);
                pq.offer(box);
            }else if(box.b == nowB){                //  가장 적게 남은 기프티콘일 경우
                if(pqB.isEmpty())
                    break;
                nowB = pqB.poll();
                for(Box b : boxes){
                    sum += b.aSetting(box.a);
                    pq.offer(b);
                }
                boxes.clear();
            }else if(boxes.isEmpty()){              // 사용할 수는 있는
                boxes.add(box);
                boxesA = box.a;
            }else if(boxesA < box.a){
                for(Box b : boxes){
                    sum += b.aSetting(box.a);
                    pq.offer(b);
                }
                boxes.clear();
            }
        }
        System.out.println(sum);

    }
}