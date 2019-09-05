package thinkinginjava.learn.chapter09;

public class Factories {
}


interface Service {
    void method1();

    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Implemention1 implements Service {
    Implemention1() {

    }

    @Override
    public void method1() {
        System.out.println("imp1 method1");
    }

    @Override
    public void method2() {
        System.out.println("imp1 method2");
    }
}

class Implemention2 implements Service {
    Implemention2() {

    }

    @Override
    public void method1() {
        System.out.println("imp2 method1");
    }

    @Override
    public void method2() {
        System.out.println("imp2 method2");
    }
}

class Implemention1Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Implemention1();
    }
}

class Implemention2Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Implemention2();
    }
}