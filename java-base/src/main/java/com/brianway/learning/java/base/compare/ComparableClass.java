package com.brianway.learning.java.base.compare;

/**
 * Created by caoqiwen on 2017/11/8.
 * 比较器，实现Comparable接口，可以用来与自己比较
 */
public class ComparableClass  implements  Comparable<ComparableClass>{
    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    private  String str;
    public ComparableClass(String str){
        this.str=str;
    }
    @Override
    public int compareTo(ComparableClass o) {
        if (this.str.compareTo(o.getStr())>0){
                  return 1;
        }else if (this.str.compareTo(o.getStr())<0){
            return -1;
        }
        return 0;
      //  return 0;
    }

    public static void main(String [] args){
        ComparableClass a=new ComparableClass("c");
        ComparableClass b=new ComparableClass("b");
        ComparableClass c=new ComparableClass("d");
        ComparableClass d=new ComparableClass("c");
        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(c));
        System.out.println(c.compareTo(d));
        System.out.println(d.compareTo(a));

    }
}
