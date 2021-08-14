import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        Set<Integer> set =new HashSet<Integer>();
        map.put(1,set);
        set.add(2);
        set.add(3);
        for(Integer v : map.get(1)){
            System.out.println(v);
        }

    }
}
