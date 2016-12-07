package com.brianway.learning.java.base.generics;//: generics/FactoryConstraint.java

/**
 * 显式工厂
 */
public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.Factory());
    }
}

interface FactoryI<T> {
    T create();
}

class Foo2<T> {
    private T x;

    public <F extends FactoryI<T>> Foo2(F factory) {
        x = factory.create();
    }

}

class IntegerFactory implements FactoryI<Integer> {
    public Integer create() {
        return 0;
    }
}

class Widget {
    public static class Factory implements FactoryI<Widget> {
        public Widget create() {
            return new Widget();
        }
    }
}
///:~
