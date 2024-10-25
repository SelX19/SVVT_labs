import java.util.ArrayList;

public class Database {

    private ArrayList<String> db;

    public void connect(){
        db = new ArrayList<>();
    }

    public void insert(String s){
        db.add(s);
    }

    public String get(int i){
        return db.get(i);
    }

    public int count(){
        return db.size();
    }

    public void clear(){
        db.clear();
    }

    public void disconnect(){
        db=null;
    }
}
