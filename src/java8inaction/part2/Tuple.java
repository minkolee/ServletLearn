package java8inaction.part2;

import java.util.Objects;

public class Tuple<T> {

    private final T first;
    private final T last;

    public Tuple(T first, T last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        } else{
            return (((Tuple) obj).first == this.first && ((Tuple) obj).last == this.last)||(((Tuple) obj).first == this.last && ((Tuple) obj).last == this.first);
        }
    }

    public static void main(String[] args) {

        Tuple<Integer> t1 = new Tuple<>(10, 4);
        Tuple<Integer> t2 = new Tuple<>(4, 10);
        System.out.println(t1.equals(t2));
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }
}
