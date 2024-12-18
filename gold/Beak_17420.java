package gold;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Task {
    int A;
    int B;

    public Task(int A, int B) {
        this.A = A;
        this.B = B;
    }
}

public class Beak_17420 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];

        String[] aInput = br.readLine().split(" ");
        String[] bInput = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(aInput[i]);
        }

        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(bInput[i]);
        }

        List<Task> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(new Task(A[i], B[i]));
        }

        // TASK 구조체를 B로 먼저 정렬하고, B가 같다면 A로 정렬
        Collections.sort(arr, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                if (t1.B == t2.B) {
                    return Integer.compare(t1.A, t2.A);
                }
                return Integer.compare(t1.B, t2.B);
            }
        });

        long answer = 0; // 정수 범위를 넘어설 수 있으므로 long 사용
        int prevMax = arr.get(0).B; // 이전 구간의 최대 B 값
        int curMax = -1; // 현재 구간에서의 A 최대값

        for (int i = 0; i < N; i++) {
            if (prevMax > arr.get(i).A) {
                // 이전 구간의 최댓값 보다 현재 A값이 작을 경우
                if (prevMax < arr.get(i).B) {
                    prevMax = arr.get(i).B;
                }

                int cnt = ((prevMax - arr.get(i).A) + 29) / 30; // 30일 단위로 보정
                arr.get(i).A += (cnt * 30);
                answer += cnt;
            }

            // 현재 구간에서의 최대 A값 계산
            curMax = Math.max(curMax, arr.get(i).A);

            // 구간이 바뀔 때 이전 구간의 최대값을 갱신
            if ((i + 1) < N && arr.get(i).B != arr.get(i + 1).B) {
                prevMax = curMax;
            }
        }

        System.out.println(answer);
    }
}