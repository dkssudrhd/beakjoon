//
// 정답
//import java.util.*;
//import java.io.*;
//
//public class Main{
//    public static int ans, r, d;
//    public static int[] num;
//
//    public static void main(String[] args) throws IOException {
//        //System.setIn(new FileInputStream("src/input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        num = new int[7];
//        for(int i = 1; i <= 6; i++) {
//            num[i] = Integer.parseInt(br.readLine());
//        }
//
//        // 그리디적 접근 - 큰 정사각형부터 넣기
//        // 1. 6x6은 판 하나 차지
//        ans += num[6];
//
//        // 2. 5x5
//        // => 5x5 1개 + 1x1 11개
//        ans += num[5];
//        num[1] -= num[5]*11;
//
//        // 3. 4x4
//        // => 4x4 1개 + 2x2 5개
//        // => 4x4 1개 + 1x1 20개
//        // 4x4 1개를 채우고 남은 면적 20에서 2x2와 1x1 섞어도 O
//        ans += num[4];
//        for(int i = 0; i < num[4]; i++) {
//            r = 20;
//            while(r > 0) {
//                if(num[2] > 0) {
//                    r = r-4;
//                    num[2]--;
//                }else if(num[1] > 0) {
//                    r = r-1;
//                    num[1]--;
//                }else {
//                    r = 0;
//                }
//            }
//        }
//        // 4. 3x3
//        // => 3x3 4개
//        // => 3x3 3개 + 2x2 1개 + 1x1 5개
//        // => 3x3 2개 + 2x2 3개 + 1x1 6개
//        // => 3x3 1개 + 2x2 5개 + 1x1 7개
//        // 3x3을 채우고 남은 면적에서 2x2와 1x1 섞어도 O
//
//        // 3x3이 4개이상이면 판 최대한 채움
//        while(num[3]/4 > 0) {
//            num[3] = num[3]-4;
//            ans++;
//        }
//
//        // 3x3 판으로 6x6판들을 채웠을때 남은영역의 개수를 구하기
//        if(num[3] == 3) {
//            ans ++;
//            r = 9;
//            d = 1;
//        }else if(num[3] == 2) {
//            ans ++;
//            r = 18;
//            d = 3;
//        }else if(num[3] == 1) {
//            ans ++;
//            r = 27;
//            d = 5;
//        }else {
//            r = 0;
//            d = 0;
//        }
//
//        // 남은 영역만큼 2x2와 1x1로 채우기
//        if(r > 0) {
//            while(d > 0) {
//                if(num[2] > 0) {
//                    d--;
//                    r = r-4;
//                    num[2]--;
//                }else {
//                    d = 0;
//                }
//            }
//
//            while(r > 0) {
//                if(num[1] > 0) {
//                    r --;
//                    num[1]--;
//                }else {
//                    r = 0;
//                }
//            }
//        }
//
//        // 5. 남은 2x2와 1x1로 맵채우기
//        r = 0;
//        while(num[2] > 0 || num[1] > 0) {
//            if(r == 0) {
//                ans++;
//                r = 36;
//            }else {
//                if(num[2] > 0) {
//                    r = r-4;
//                    num[2]--;
//                }else {
//                    r = r-1;
//                    num[1] --;
//                }
//            }
//        }
//
//        bw.write(ans+"\n");
//        bw.flush();
//    }
//}
//





package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak_2590 {
    static int[] board = new int[7];
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 각 종류의 색종이 입력 받기
        for (int i = 1; i <= 6; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }

        // 6번 색종이 처리 (한 장당 판 1개 소모)
        sum += board[6];

        // 5번 색종이 처리 (남은 공간은 1번 색종이로 채움)
        sum += board[5];
        board[1] = Math.max(0, board[1] - board[5] * 11);

        // 4번 색종이 처리 (남은 공간은 2번, 1번 색종이로 채움)
        sum += board[4];
        int remainingSpace = board[4] * 5; // 4번 색종이 1장당 남는 2x2 공간의 개수
        if (board[2] >= remainingSpace) {
            board[2] -= remainingSpace;
        } else {
            remainingSpace -= board[2];
            board[2] = 0;
            board[1] = Math.max(0, board[1] - remainingSpace * 4);
        }

        // 3번 색종이 처리
        sum += (board[3] + 3) / 4; // 3번 색종이 4장당 판 1개
        int remaining3x3 = board[3] % 4;

        int leftoverSpace=0;
        int needed2x2=0;
        if(remaining3x3 == 1) {
            leftoverSpace = 27;
            needed2x2 = 5;

        }else if(remaining3x3 == 2) {
            leftoverSpace = 18;
            needed2x2 = 3;

            board[1] = Math.max(0, board[1] - leftoverSpace);
        }else if(remaining3x3 == 3) {
            leftoverSpace = 9;
            needed2x2 = 1;
        }
        if (board[2] >= needed2x2) {
            board[2] -= needed2x2;
            leftoverSpace -= needed2x2 * 4;
        } else {
            leftoverSpace -= board[2] * 4;
            board[2] = 0;
        }
        board[1] = Math.max(0, board[1] - leftoverSpace);


        // 2번 색종이 처리
        sum += (board[2] + 8) / 9; // 2번 색종이 9장당 판 1개
        int remaining2x2 = board[2] % 9;
        if (remaining2x2 > 0) {
            leftoverSpace = 36 - (remaining2x2 * 4); // 남은 공간 크기
            board[1] = Math.max(0, board[1] - leftoverSpace);
        }

        // 1번 색종이 처리
        if (board[1] > 0) {
            sum += (board[1] + 35) / 36; // 1번 색종이 36장당 판 1개
        }

        // 결과 출력
        System.out.println(sum);
    }
}