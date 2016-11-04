import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Bag {
    public static void main(String args[]) {
        ArrayList<String> bag = new ArrayList<String>();

        bag.add("a");
        bag.add("a");
        bag.add("b");
        bag.add("c");
        bag.add("d");
        bag.add("e");

        bag.remove(1);

        int n=bag.indexOf("e");
        System.out.println("e的位置是 "+ n);

        boolean p=bag.isEmpty();
        if(p){
            System.out.println("空");
        }
        else{
            System.out.println("不为空");
        }

        bag.set(1,"f");

        for (int i = 0; i < bag.size(); i++) {
            System.out.println(bag.get(i));
        }
    }
}
