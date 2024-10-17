package codingTest;

import java.util.*;

class CodingTest3 {
    static int max=0;

    public void jump(String reference, String track, int start, int min) {
        int finish = track.length();

        if(start == finish){
            max = min;
            return;
        }
        List<Integer> canList = new ArrayList<>();

        for (int i = start+1; i < finish; i++) {
            String subTrack = track.substring(start, i);

            if (reference.contains(subTrack)) {
                canList.add(i+1);
            } else{
                break;
            }
        }

        for(int i=canList.size()-1; i>=0; i--){
            int nowMin = canList.get(i) - start;
            if(max >= nowMin){
                return;
            }else{
                jump(reference, track, canList.get(i), nowMin);
            }
        }

    }

    public int solution(String reference, String track) {

        jump(reference, track, 0, Integer.MAX_VALUE);

        return max;


    }
}