package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak_1562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][][] list = new long[n+1][10][1<<10];
        long mod = 1000000000;

        for(int i=1; i<10; i++){
            list[1][i][1<<i] = 1;
        }

        for(int i=2; i<=n; i++){
            for(int j=0; j<10; j++){
                for(int k=0; k < (1<<10); k++){
                    int now = k | (1<<j);
                    if(j==0){
                        list[i][j][now] += list[i-1][j+1][k]%mod;
                    } else if(j == 9){
                        list[i][j][now] += list[i-1][j-1][k]%mod;
                    } else{
                        list[i][j][now] += list[i-1][j+1][k]%mod + list[i-1][j-1][k]%mod;
                    }
                    list[i][j][now] %= mod;
                }
            }
        }
        long sum = 0;
        for(int i=0; i<10; i++){
            sum += list[n][i][(1<<10)-1]%mod;
            sum %= mod;
        }
        System.out.println(sum);
        br.close();
    }
}
