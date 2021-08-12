import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解提供数据用来解释程序代码，注解对程序的运行效果没有直接的影响
 * 作用：提供信息给编译器：编译器利用注解来探测错误的警告信息
 *  编译阶段时的处理： 软件工具利用注解来生成代码
 *  运行时的处理：某些注解可以在程序运行的时候接受代码的提取
 *
 * 注解不会自己生效，需要我们自己去提取注解的值。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "嘿嘿";
}
