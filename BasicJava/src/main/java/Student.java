public class Student {
    private String name;
    private Integer age;
    {
        name = "小贺";
        age = 24;
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Student student =new Student("小谢",23);
    }
}
