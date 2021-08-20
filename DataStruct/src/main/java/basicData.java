import java.util.concurrent.Executors;

public class basicData {
    public static void main(String[] as) {
        String s = "嘻嘻";
        ClassLoader classLoader = basicData.class.getClassLoader();
        System.out.println(classLoader);

    }
}
