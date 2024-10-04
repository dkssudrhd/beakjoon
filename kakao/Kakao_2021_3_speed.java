package kakao;

import java.util.*;

public class Kakao_2021_3_speed {
    class People {
        String language;
        String backend;
        String senior;
        String chicken;
        int point;

        public People(String language, String backend, String senior, String chicken, int point) {
            this.language = language;
            this.backend = backend;
            this.senior = senior;
            this.chicken = chicken;
            this.point = point;
        }

        // 조합을 반환하는 메서드
        public List<String> toStringList() {
            List<String> list = new ArrayList<>();
            list.add(language + " and " + backend + " and " + senior + " and " + chicken);
            list.add("-" + " and " + backend + " and " + senior + " and " + chicken);
            list.add(language + " and " + "-" + " and " + senior + " and " + chicken);
            list.add(language + " and " + backend + " and " + "-" + " and " + chicken);
            list.add(language + " and " + backend + " and " + senior + " and " + "-");
            list.add("-" + " and " + "-" + " and " + senior + " and " + chicken);
            list.add("-" + " and " + backend + " and " + "-" + " and " + chicken);
            list.add("-" + " and " + backend + " and " + senior + " and " + "-");
            list.add(language + " and " + "-" + " and " + "-" + " and " + chicken);
            list.add(language + " and " + "-" + " and " + senior + " and " + "-");
            list.add(language + " and " + backend + " and " + "-" + " and " + "-");
            list.add("-" + " and " + "-" + " and " + "-" + " and " + chicken);
            list.add("-" + " and " + "-" + " and " + senior + " and " + "-");
            list.add("-" + " and " + backend + " and " + "-" + " and " + "-");
            list.add(language + " and " + "-" + " and " + "-" + " and " + "-");
            list.add("-" + " and " + "-" + " and " + "-" + " and " + "-");
            return list;
        }
    }

    class Solution {
        public int[] solution(String[] info, String[] query) {
            int[] answer = new int[query.length];
            Map<String, List<Integer>> map = new HashMap<>();

            // 정보를 넣을 때 모든 조합을 생성해 map에 넣음
            for (String str : info) {
                String[] information = str.split(" ");
                People people = new People(information[0], information[1], information[2], information[3], Integer.parseInt(information[4]));

                for (String peopleList : people.toStringList()) {
                    map.computeIfAbsent(peopleList, k -> new ArrayList<>()).add(people.point);
                }
            }

            // 각 리스트를 정렬 (이진 탐색을 위해)
            for (List<Integer> points : map.values()) {
                Collections.sort(points);
            }

            // 쿼리 처리
            int idx = 0;
            for (String q : query) {
                String[] splitQuery = q.replace(" and ", " ").split(" ");
                String queryKey = String.join(" and ", Arrays.copyOf(splitQuery, splitQuery.length - 1));
                int queryPoint = Integer.parseInt(splitQuery[splitQuery.length - 1]);

                if (map.containsKey(queryKey)) {
                    List<Integer> points = map.get(queryKey);

                    // 이진 탐색으로 queryPoint 이상의 값이 있는 첫 인덱스를 찾음
                    int low = 0, high = points.size();
                    while (low < high) {
                        int mid = (low + high) / 2;
                        if (points.get(mid) >= queryPoint) {
                            high = mid;
                        } else {
                            low = mid + 1;
                        }
                    }

                    // queryPoint 이상의 개수를 카운트
                    answer[idx] = points.size() - low;
                } else {
                    answer[idx] = 0;
                }
                idx++;
            }

            return answer;
        }
    }
}
