package thinkinginjava.learn.chapter20;

import org.apache.taglibs.standard.tag.common.xml.XPathUtil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    public int id();

    public String description() default "no description";
}
