import java.util.*;
import java.io.*;

public class Beak_12919{

    public static String s, t;
    public static int finish = 0;

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();
        checking(s);
        System.out.print(finish);
    }

    public static void checking(String nowStr) {
        if(t.equals(nowStr)) {
            finish = 1;
            return;
        } else if(t.length() <= nowStr.length()) {
            return;
        }
        if(finish ==0) {
            String nextStr1 = nowStr + "A";
            if(doubleChecking(nextStr1))
                checking(nextStr1);
            String nextStr2 = nowStr + "B";
            nextStr2 = reverse(nextStr2);
            if(doubleChecking(nextStr2))
                checking(nextStr2);
        }
    }

    public static boolean doubleChecking(String str) {
        return t.contains(str) || t.contains(reverse(str));
    }

    public static String reverse(String nowStr) {
        return new StringBuilder(nowStr).reverse().toString();
    }
}
