package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Q9 {
    
    public static void main(String[] args) {
        ArrayList2<String> list = new ArrayList2<>(Arrays.asList("aaa", "bbb", "abc"));
        list.forEachIf(System.out::println, e -> e.startsWith("a"));

        //既存のCollectionを実装するクラスを継承して、Collection2インターフェースを実装するようにすると機能追加できる。

    }
    private static class ArrayList2<E> extends ArrayList<E> implements Collection2<E>{

        public ArrayList2(int initialCapacity) {
            super(initialCapacity);
        }

        public ArrayList2() {
            super();
        }

        public ArrayList2(Collection<? extends E> c) {
            super(c);
        }
        
    }

    private static interface Collection2<T> extends Collection<T> {
        default void forEachIf(Consumer<T> action, Predicate<T> filter){
            this.stream().filter(filter).forEach(action);
        }

    }
}
