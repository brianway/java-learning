package com.brianway.learning.java.base.clone;

/**
 * Created by caoqiwen on 2017/11/9.
 * java的克隆实例
 * 包含浅拷贝和深拷贝：
 * 1、浅拷贝只拷贝对象的地址，对于引用类型来说拷贝的是地址，如果改一个会对另一个拷贝的对象进行修改。
 *2、深拷贝只需要对该对象进行改变就行。
 *
 */
public class CloneClass implements  Cloneable{

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    private String str;


    public CloneClass(String str){
        this.str=str;
        System.out.println("clone has begined");
    }


    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    public static  void main(String []args) throws CloneNotSupportedException {
      //  System.out.println("11");
        CloneClass cloneClass=new CloneClass("test");
        CloneClass cloneClass1=(CloneClass)cloneClass.clone();
        cloneClass.setStr("22");
        System.out.println(cloneClass.getClass()==cloneClass1.getClass());
        System.out.println("so0.equals(so1)?" + (cloneClass.equals(cloneClass1)));
     //   System.out.println(cloneClass1.getStr());

    }
}
