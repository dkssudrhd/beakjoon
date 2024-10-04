package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Kakao_2021_1 {
    public String level1(String new_id){
        new_id.toLowerCase();
        String answer = "";
        new_id.substring(0,1);
        int start =0;
        while(new_id.charAt(start) =='.'){
            start++;
        }
        for(int i=0; i < new_id.length(); i++){
            if(new_id.charAt(i) <= 'A' && new_id.charAt(i) <= 'Z'){
                answer += new_id.toLowerCase();
            }
            answer += new_id.charAt(i);
        }
        HashMap<String, String> map = new HashMap<>();
        PriorityQueue<Integer> t = new PriorityQueue<>();
        t.clear();

        String[] answer1 = {};
        List<String> answer2 = new ArrayList<>();
        answer1 = (String[]) answer2.toArray();
        return new_id;
    }
}
