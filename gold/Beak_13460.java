package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class XY{
    int x;
    int y;

    void setX(int x){
        this.x = x;
    }

    void setY(int y){
        this.y = y;
    }

    public XY(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Board{
    XY readBall;
    XY blueBall;

    public Board(XY readBall, XY blueBall){
        this.readBall = readBall;
        this.blueBall = blueBall;
    }
}

public class Beak_13460 {
    static XY hole;
    static char[][] array;
    static boolean finished = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        array = new char[n][m];

        XY redBall = new XY(0, 0);
        XY blueBall = new XY(n, 0);
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                array[i][j] = line.charAt(j);
                if(array[i][j] == 'R'){
                    redBall = new XY(i, j);
                    array[i][j] = '.';
                } else if(array[i][j] == 'B'){
                    blueBall = new XY(i, j);
                    array[i][j] = '.';
                } else if(array[i][j] == 'O'){
                    hole = new XY(i, j);
                }
            }
        }
        int count=0;

        List<Board> nowList = new ArrayList<>();
        nowList.add(new Board(redBall, blueBall));

        while(!finished && count < 10){
            count++;
            List<Board> nextList = new ArrayList<>();

            for(Board b : nowList){
                XY redRightXY = new XY(b.readBall.x, b.readBall.y);
                XY blueRightXY = new XY(b.blueBall.x, b.blueBall.y);

                if(!rightAll(redRightXY, blueRightXY)){
                    nextList.add(new Board(redRightXY, blueRightXY));
                }

                XY redLeftXY = new XY(b.readBall.x, b.readBall.y);
                XY blueLeftXY = new XY(b.blueBall.x, b.blueBall.y);
                if(!leftAll(redLeftXY, blueLeftXY)){
                    nextList.add(new Board(redLeftXY, blueLeftXY));
                }

                XY redUpXY = new XY(b.readBall.x, b.readBall.y);
                XY blueUpXY = new XY(b.blueBall.x, b.blueBall.y);
                if(!upAll(redUpXY, blueUpXY)){
                    nextList.add(new Board(redUpXY, blueUpXY));
                }

                XY redDownXY = new XY(b.readBall.x, b.readBall.y);
                XY blueDownXY = new XY(b.blueBall.x, b.blueBall.y);
                if(!downAll(redDownXY, blueDownXY)){
                    nextList.add(new Board(redDownXY, blueDownXY));
                }
                if(finished){
                    break;
                }
            }

            nowList = nextList;
        }
        if(finished){
            System.out.println(count);
        } else{
            System.out.println("-1");
        }
    }

    static boolean rightAll(XY nowRed, XY nowBlue){
        boolean red;
        boolean blue;

        if(nowRed.y < nowBlue.y){
            blue = right(nowBlue, nowRed);
            red = right(nowRed, nowBlue);
        }else{
            red = right(nowRed, nowBlue);
            blue = right(nowBlue, nowRed);
        }
        if(red && !blue){
            finished = true;
        }
        return blue;
    }
    static boolean right(XY nowBall, XY differentBall) {
        int x = nowBall.x;
        int y = nowBall.y;
        while(array[x][y+1] != '#' && !(differentBall.y == y+1 && x == differentBall.x) ){
            y++;
            if(array[x][y] =='O'){
                nowBall.setY(++y);
                return true;
            }
        }
        nowBall.setY(y);

        return false;
    }

    static boolean leftAll(XY nowRed, XY nowBlue){
        boolean red;
        boolean blue;

        if(nowRed.y < nowBlue.y){
            red = left(nowRed, nowBlue);
            blue = left(nowBlue, nowRed);
        }else{
            blue = left(nowBlue, nowRed);
            red = left(nowRed, nowBlue);
        }

        if(red && !blue){
            finished = true;
        }
        return blue;

    }
    static boolean left(XY nowBall, XY differentBall) {
        int x = nowBall.x;
        int y = nowBall.y;
        while(array[x][y-1] != '#' && !(differentBall.y == y-1 && x == differentBall.x) ){
            y--;
            if(array[x][y] =='O'){
                nowBall.setY(--y);
                return true;
            }
        }
        nowBall.setY(y);
        return false;
    }

    static boolean downAll(XY nowRed, XY nowBlue){
        boolean red;
        boolean blue;

        if(nowRed.x < nowBlue.x){
            blue = down(nowBlue, nowRed);
            red = down(nowRed, nowBlue);
        }else{
            red = down(nowRed, nowBlue);
            blue = down(nowBlue, nowRed);
        }

        if(red && !blue){
            finished = true;
        }
        return blue;
    }
    static boolean down(XY nowBall, XY differentBall){
        int x = nowBall.x;
        int y = nowBall.y;
        while(array[x+1][y] != '#' && !(differentBall.x == x+1 && y == differentBall.y) ){
            x++;
            if(array[x][y] =='O'){
                nowBall.setX(++x);
                return true;
            }
        }
        nowBall.setX(x);
        return false;
    }

    static boolean upAll(XY nowRed, XY nowBlue){
        boolean red;
        boolean blue;

        if(nowRed.x < nowBlue.x){
            red = up(nowRed, nowBlue);
            blue = up(nowBlue, nowRed);
        } else{
            blue = up(nowBlue, nowRed);
            red = up(nowRed, nowBlue);
        }

        if(red && !blue){
            finished = true;
        }
        return blue;
    }
    static boolean up(XY nowBall, XY differentBall){
        int x = nowBall.x;
        int y = nowBall.y;
        while(array[x-1][y] != '#' && !(differentBall.x == x-1 && y == differentBall.y) ){
            x--;
            if(array[x][y] =='O'){
                nowBall.setX(--x);
                return true;
            }
        }
        nowBall.setX(x);
        return false;
    }
}

