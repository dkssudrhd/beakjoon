package silver;

import java.io.*;

public class Beak_18787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String a = br.readLine();
        String b = br.readLine();

        boolean change = false;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if(!change)
                    count++;
                change = true;

            }else{
                change = false;
            }
        }
        System.out.print(count);

    }

}