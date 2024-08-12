package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Person{
    int size;
    List<Person> beforePerson = new ArrayList<Person>();
    boolean status = true;

    Person(int size){
        this.size = size;
    }

    public void beforePersonAdd(Person p){
        beforePerson.add(p);
    }

    public void choice(){
        if(!status){
            return;
        }
        for(Person p : beforePerson){
            p.choice();
        }
        System.out.print(size + " ");
        status = false;

    }
}

public class Beak_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        List<Person> personList = new ArrayList<>();
        for(int i=1; i<=n; i++){
            personList.add(new Person(i));
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            personList.get(b-1).beforePersonAdd(personList.get(a-1));
        }
        for(Person p : personList){
            p.choice();
        }
    }

}
