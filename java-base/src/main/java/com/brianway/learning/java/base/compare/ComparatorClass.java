package com.brianway.learning.java.base.compare;

import java.util.Comparator;

/**
 * Created by caoqiwen on 2017/11/8.
 * 实现comparator接口，可以对两个相同对象进行比较
 */

public class ComparatorClass implements Comparator<ComparableClass> {

    @Override
    public int compare(ComparableClass o1, ComparableClass o2) {
        if (o1.getStr().compareTo(o2.getStr())>0){
            return 1;
        }else if (o1.getStr().compareTo(o2.getStr())<0){
            return -1;
        }
        return 0;

    }

    public static  void  main(String []args){
        ComparatorClass comparatorClass=new ComparatorClass();
        ComparableClass a=new ComparableClass("d");
        ComparableClass b=new ComparableClass("b");
        ComparableClass c=new ComparableClass("c");
        ComparableClass d=new ComparableClass("d");
        System.out.println(comparatorClass.compare(a,b));
        System.out.println(comparatorClass.compare(b,c));
        System.out.println(comparatorClass.compare(c,d));
        System.out.println(comparatorClass.compare(d,a));

    }
}
