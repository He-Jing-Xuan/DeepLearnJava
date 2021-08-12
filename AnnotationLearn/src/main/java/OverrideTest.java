public class OverrideTest {
    public static void main(String[] args) {
        //判断是否使用了注解
        boolean isAt = People.class.isAnnotationPresent(MyAnnotation.class);
        if(isAt){
            // 拿到注解  通过反射拿到注解
            MyAnnotation myAnnotation = People.class.getAnnotation(MyAnnotation.class);
            //输出注解的值
            System.out.println(myAnnotation.value());
        }
        People student = new People();
        student.eat();
        student.walk();
        System.out.println(student.name);
    }

}
