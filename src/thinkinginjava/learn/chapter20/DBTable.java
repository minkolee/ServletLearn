package thinkinginjava.learn.chapter20;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.TYPE)   //表示作用于类
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {

    public String name() default "";

}
