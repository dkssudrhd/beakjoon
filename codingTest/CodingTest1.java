package codingTest;

import java.util.*;

/**
 remote_tasks 자택가능한 업무
 office_tasks 출근해야하는 업무
 employees -> 사원번호 소속 팀 번호 담당 업무

 팀마다 최소 한명은 출근
 모두 재택근무일때 사원 번호가 가장 빠른 사람이 출근

 */

/**
 num 사원번호
 home 재택여부
 */
class Employee{
    int num;
    boolean home;

    public int getNum(){
        return num;
    }

    public Employee(int num, boolean home){
        this.num = num;
        this.home = home;
    }
}

public class CodingTest1 {

    static List<Integer> answerList = new ArrayList<>();
    static List<Employee>[] teams;
    static int[] teamsHowMany;

    public int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        int[] answer = {};

        teams = new List[num_teams+1];
        teamsHowMany = new int[num_teams+1];

        for(int i=0; i<= num_teams; i++){
            teams[i] = new ArrayList<>();
        }
        Map<String, Boolean> taskMap = new HashMap<>();

        for(int i=0; i< office_tasks.length; i++){
            taskMap.put(office_tasks[i], false);
        }

        for(int i=0; i< remote_tasks.length; i++){
            taskMap.put(remote_tasks[i], true);
        }

        for(int i=0; i< employees.length; i++){
            String[] strSplit = employees[i].split(" ");
            int team = Integer.parseInt(strSplit[0]);

            boolean home = true;

            for(int j=1; j< strSplit.length; j++){
                if(!taskMap.get(strSplit[j])){
                    home = false;
                    break;
                }
            }
            if(home){
                teams[team].add(new Employee(i+1, home));
            }
            if(!home){
                teamsHowMany[team]++;
            }
        }

        for(int i=1; i<=num_teams; i++){
            boolean officeTaskUser = (teamsHowMany[i] != 0);

            System.out.println(teams[i].size());
            for(int j=0; j<=teams[i].size(); j++){
                if(officeTaskUser){
                    Employee emp = teams[i].get(j);
                    answerList.add(emp.getNum());
                }else{
                    officeTaskUser = true;
                }
            }
        }

        for(int i=0; i<answerList.size(); i++){
            System.out.print(answerList.get(i)+ " ");
        }
        int a =4;
        long b = (long) a;
        return answer;
    }

}