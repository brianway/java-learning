package com.brianway.learning.java.jvm.dynamictype;

import static java.lang.invoke.MethodHandles.lookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

/**
 * Created by brian on 17/3/20.
 * 使用 MethodHandle 来访问祖类方法
 * TODO 为什么打印出来的是 "i am father" 而不是 "i am grandfather"?
 * 参考:
 * https://www.zhihu.com/question/57379777
 * https://www.zhihu.com/question/40427344/answer/86545388
 */
public class GrandFatherCaller {
    class GrandFather {
        void thinking() {
            System.out.println("i am grandfather");
        }
    }

    class Father extends GrandFather {
        void thinking() {
            System.out.println("i am father");
        }
    }

    class Son extends Father {
        void thinking() {
            try {
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle mh = lookup().findSpecial(
                        GrandFather.class, "thinking", mt, Son.class);
                mh.invoke(this);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        (new GrandFatherCaller().new Son()).thinking();
    }
}
