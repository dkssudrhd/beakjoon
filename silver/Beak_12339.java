package silver;
import java.io.*;
import java.util.*;

public class Beak_12339 {

    public static boolean checking(int number) {
        String str = Integer.toString(number);
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Integer> numberList = new ArrayList<>();
        int now = 1;
        while (now * now <= 1000) {
            if (checking(now * now ) && now * now != 676) {
                numberList.add(now*now);
            }
            now++;
        }
        int n = Integer.valueOf(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());

            int count = 0;
            for (int num : numberList) {
                if (a <= num && num <= b) {
                    count++;
                }
                if (num > b) {
                    break;
                }
            }
            sb.append("Case #").append((i + 1)).append(": ").append(count).append("\n");
        }

        System.out.print(sb);

    }
}