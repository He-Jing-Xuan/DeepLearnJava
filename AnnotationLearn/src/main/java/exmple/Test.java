package exmple;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) {
        //通过反射 打印 excel的字段和别名
        Field [] fields = Excel.class.getDeclaredFields();
        for(Field field :fields){
            System.out.println(field.getName() +":"+(field.getAnnotation(Export.class).alias()));
        }
    }
}
