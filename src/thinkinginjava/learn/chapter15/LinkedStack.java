package thinkinginjava.learn.chapter15;

public class LinkedStack<T> {

    //静态内部类, 不需要绑定在外部对象上, 同时无需访问LinkedStack的成员变量, 所以就用静态内部类了
    private static class Node<U> {
        U item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    //设置一个固定的结束节点, 两个都是null
    private Node<T> top = new Node<T>();

    //这个不错, 将当前top当成新节点的next, 再将top指向新节点
    public void push(T t) {
        top = new Node<>(t, top);
    }
}
