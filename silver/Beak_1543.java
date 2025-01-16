package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String word = br.readLine();

        int size = word.length();

        int sum = 0;
        for(int i = 0; i <= s.length() - size; i++) {
            if(word.equals(s.substring(i, i + size))) {
                sum++;
                i += size -1;
            }
        }
        System.out.println(sum);
    }

}
