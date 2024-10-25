import java.util.ArrayList;

//Task3
public class Person {

    private int age;

    public Person (int age) {
        if(age<0){
            //Task7
            throw new IllegalArgumentException("A person’s age cannot be less than 0");
        }
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public boolean isAdult(){
        if(getAge()<18){
            return false;
        }
        return true;
    }

    public boolean canGoToSchool(){
        if(getAge()<6){
            return false;
        }
        return true;
    }
}
