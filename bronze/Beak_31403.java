package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak_31403 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str_a = br.readLine();
		String str_b = br.readLine();
		String str_c = br.readLine();

		int int_a = Integer.parseInt(str_a);
		int int_b = Integer.parseInt(str_b);
		int int_c = Integer.parseInt(str_c);

		int int_ab = Integer.parseInt(str_a+str_b);
		System.out.println(int_a + int_b - int_c);
		System.out.println(int_ab - int_c);
	}
}
