package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Beak_1099 {

    static List<Map<Character, Integer>> maps = new ArrayList<>();
    static int n;
    static int min = Integer.MAX_VALUE;
    static List<String> wordList = new ArrayList<>();

    public static Map<Character, Integer> madeHashMap(String word){
        Map<Character, Integer> map = new HashMap<>();
        System.out.println(word);
        for(char c : word.toCharArray()){
            System.out.println(" " + c);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    // 불포함 0, 일치 1, 초과 2
    public static int include(Map<Character, Integer> checked, Map<Character, Integer> sample) {
        boolean same = true;
        for(char c : checked.keySet()){
            System.out.println("checked c: " + checked.get(c) +" sample: " +  sample.getOrDefault(c, 0));
            if(checked.get(c) > sample.getOrDefault(c, 0)){
                return 0;
            } else if(checked.get(c) < sample.getOrDefault(c, 0)) {
                same = false;
            }
        }
        if(checked.size() != sample.size()){
            same = false;
        }
        if(same) {
            return 1;
        }else{
            return 2;
        }
    }

    public static void playing(String str, int count){
        if(str.isEmpty()){
            if(min > count){
                min = count;
            }
            return;
        }

        List<Map<Character, Integer>> nowList = new ArrayList<>();

        char c = str.charAt(0);

        for(Map<Character, Integer> map : maps){
            if(map.containsKey(c)){
                nowList.add(map);
            }
        }

        String nowStr = c +"";
        System.out.println("nowStr : " + nowStr);
        for(int i = 1; i < str.length() && !nowList.isEmpty(); i++){

            nowStr += str.charAt(i);

            List<Map<Character, Integer>> nextList = new ArrayList<>();
            int j=0;
            for(Map<Character, Integer> map : nowList){
                Map<Character, Integer> newMap = madeHashMap(nowStr);
                int result = include(newMap, map);
                System.out.println("c : " + c + " +nowStr : " + nowStr + " result : " + result);

                if(result == 1){
                    int addCount = counting(nowStr, wordList.get(j));
                    playing(str.substring(i), count + addCount);
                    System.out.println("일치 : "+ str.substring(i));
                } else if(result == 2){
                    nextList.add(newMap);
                }
                j++;
            }
            nowList = nextList;
        }

    }

    //순서 바꿀 떄 카운팅
    public static int counting(String checked, String sample){
        int count=0;
        for(int i=0; i<checked.length(); i++){
            if(checked.charAt(i) != sample.charAt(i)){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String word = br.readLine();
            wordList.add(word);
            Map<Character, Integer> map = madeHashMap(word);
            maps.add(map);
        }
        playing(str, 0);

        if(min == Integer.MAX_VALUE){
            System.out.println("-1");
        }else{
            System.out.println(min);
        }
    }
}
