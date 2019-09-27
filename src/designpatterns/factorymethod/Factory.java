package designpatterns.factorymethod;

public abstract class Factory {
    //这个类本身就使用了模板模式, 两个抽象方法需要子类实现, 然后规定了操作流程
    //其中一个方法用于创建一个Product类型的对象
    public final Product create(String name) {
        Product p = createProduct(name);
        registerProduct(p);
        return p;
    }

    protected abstract Product createProduct(String name);

    protected abstract void registerProduct(Product product);
}
