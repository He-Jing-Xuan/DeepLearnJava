@MyAnnotation()
public class People {
    String name;
    private String age;

    public People(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public People() {
    }

    public void eat(){
        System.out.println(" 人在吃东西");
    }

    public void walk(){
        System.out.println("行走");
    }

    @Override
    public String toString() {
        return "name:"+name;
    }
}
