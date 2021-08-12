package exmple;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
/**
 * 设计一个文件导出注解， 用于给导出excel文件时，使用注解 给每个字段取别名
 */
public @interface Export {
    String alias();
}
