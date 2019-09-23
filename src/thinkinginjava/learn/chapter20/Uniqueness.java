package thinkinginjava.learn.chapter20;


public @interface Uniqueness {
    Constrains constrains() default @Constrains(unique = true);

}
