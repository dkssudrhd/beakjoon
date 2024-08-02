package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak_10971 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] array = new int[n][n];

		for(int i=0;i<n;i++){
			String str = br.readLine();
			String[] strSplit = str.split(" ");
			for(int j=0;j<n;j++){
				array[i][j] = Integer.parseInt(strSplit[j]);
			}
		}


	}
}
