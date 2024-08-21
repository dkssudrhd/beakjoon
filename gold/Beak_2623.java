package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class PD {
    int id;
    int beforeSize = 0;
    List<Integer> afterId = new ArrayList<>();

    public PD(int id) {
        this.id = id;
    }

    public void addAfterId(int id) {
        afterId.add(id);
    }

    public void addBefore() {
        beforeSize++;
    }

    public void reduceBefore() {
        beforeSize--;
    }
}

public class Beak_2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, PD> pdHashMap = new HashMap<>();
        Queue<PD> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            PD pd = new PD(i);
            pdHashMap.put(i, pd);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int[] list = new int[Integer.parseInt(st.nextToken())];
            for (int j = 0; j < list.length; j++) {
                list[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j < list.length; j++) {
                PD now = pdHashMap.get(list[j]);
                PD before = pdHashMap.get(list[j - 1]);
                before.addAfterId(list[j]);
                now.addBefore();
            }
        }

        for (int i = 1; i <= n; i++) {
            PD pd = pdHashMap.get(i);
            if (pd.beforeSize == 0) {
                queue.add(pd);
            }
        }

        int processed = 0;
        while (!queue.isEmpty()) {
            PD pd = queue.poll();
            sb.append(pd.id).append("\n");
            processed++;

            for (int id : pd.afterId) {
                PD after = pdHashMap.get(id);
                after.reduceBefore();
                if (after.beforeSize == 0) {
                    queue.add(after);
                }
            }
        }

        if (processed != n) {
            System.out.println(0);
        } else {
            System.out.print(sb);
        }
    }
}
