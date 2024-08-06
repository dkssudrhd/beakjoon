package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beak_10942 {
	static boolean[][] answer;

	public static void checking(int[] array, int n){
		List<Integer> list1 = new ArrayList<>();
		for(int i=1;i<=n;i++){
			answer[i][i] = true;
			list1.add(i);
		}
		int k = 1;
		while(!list1.isEmpty() || k<=n/2){
			List<Integer> next_list1 = new ArrayList<>();
			for(int number : list1){
				if(number>k && number+k <n+1 && array[number-k] == array[number+k]){
					next_list1.add(number);
					answer[number-k][number+k] = true;
				}
			}
			list1 = next_list1;
			k++;
		}

		List<Integer> list2 = new ArrayList<>();

		for(int i=1;i<n;i++){
			if(array[i]==array[i+1]){
				answer[i][i+1] = true;
				list2.add(i);
			}
		}
		k = 1;
		while(!list2.isEmpty() || k<=n/2){
			List<Integer> next_list2 = new ArrayList<>();
			for(int number : list2){
				if(number>k && number+k <n && array[number-k] == array[number+k+1]){
					next_list2.add(number);
					answer[number-k][number+k+1] = true;
				}
			}
			list2 = next_list2;
			k++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n+1];
		answer = new boolean[n+1][n+1];

		String numbers = br.readLine();
		StringTokenizer st = new StringTokenizer(numbers);

		for (int i = 1; i <= n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		checking(array, n);

		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(answer[a][b]){
				sb.append(1).append("\n");
			}else{
				sb.append(0).append("\n");
			}
		}
		System.out.print(sb);

	}

}
