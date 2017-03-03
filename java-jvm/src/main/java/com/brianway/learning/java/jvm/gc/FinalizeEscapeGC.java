package com.brianway.learning.java.jvm.gc;

/**
 * Created by brian on 17/3/3.
 * 对象可以在被 GC 时自我拯救
 * 这种自救的机会只有一次,因为一个对象的 finalize() 方法最多只会被系统自动调用一次
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();

        // finalize 优先级低,暂停 0.5 秒以等待
        Thread.sleep(500);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i ma dead :(");
        }

        //与上面完全相同,缺失败
        SAVE_HOOK = null;
        System.gc();

        // finalize 优先级低,暂停 0.5 秒以等待
        Thread.sleep(500);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i ma dead :(");
        }

    }
}

/*
finalize method executed
yes, i am still alive :)
no, i ma dead :(
 */