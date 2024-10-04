package kakao;
import java.util.*;

public class Kakao_2021_3 {
    class People{
        String language;
        String position;
        String senior;
        String food;
        int point;

        public People(String language, String position, String senior, String food, int point){
            this.language = language;
            this.position = position;
            this.senior = senior;
            this.food = food;
            this.point = point;
        }

        public boolean allChecking(People checking){
            if(!sameChecking(checking.language, language)){
                return false;
            } else if(!sameChecking(checking.position, position)){
                return false;
            } else if(!sameChecking(checking.senior, senior)){
                return false;
            } else if(!sameChecking(checking.food, food)){
                return false;
            } else if(checking.point > point){
                return false;
            } else{
                return true;
            }
        }

        private boolean sameChecking(String sample, String checkingStr){    //샘플과 데이터를 비교
            if(sample.equals("-")){
                return true;
            } else if(sample.equals(checkingStr)){
                return true;
            } else{
                return false;
            }
        }

    }

    class Solution {
        static List<People> peopleList = new ArrayList<>();

        public int[] solution(String[] info, String[] query) {

            int[] answer = new int[query.length];
            int answerCount = 0;

            for(String str : info){ // 정보 넣기
                String[] information = str.split(" ");
                peopleList.add(new People(information[0], information[1], information[2], information[3], Integer.parseInt(information[4])));

            }

            for(String str : query){                          //query처리
                String[] information = str.split(" and ");    // and로 나누기
                int count=0;                                  // 정답 카운트

                String foodPoint = information[3];
                String[] split = foodPoint.split(" ");

                People queryPeople = new People(information[0].trim(), information[1].trim(), information[2].trim(), split[0].trim(), Integer.parseInt(split[1].trim()));
                for(People now : peopleList){
                    if(now.allChecking(queryPeople)){
                        count++;
                    }
                }
                answer[answerCount++] = count;
            }

            return answer;
        }
    }
}


