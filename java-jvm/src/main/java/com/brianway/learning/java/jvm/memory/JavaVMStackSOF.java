package com.brianway.learning.java.jvm.memory;

/**
 * Created by brian on 17/3/1.
 * 虚拟机栈和本地方法栈 OOM 测试
 * VM Args: -Xss256k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();

        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }

}

/*
stack length:1862
Exception in thread "main" java.lang.StackOverflowError
	at com.brianway.learning.java.jvm.memory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:12)
	at com.brianway.learning.java.jvm.memory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
	at com.brianway.learning.java.jvm.memory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
	at com.brianway.learning.java.jvm.memory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
	at com.brianway.learning.java.jvm.memory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
	at com.brianway.learning.java.jvm.memory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
	at com.brianway.learning.java.jvm.memory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
	at com.brianway.learning.java.jvm.memory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
	at com.brianway.learning.java.jvm.memory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
	at com.brianway.learning.java.jvm.memory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
	at com.brianway.learning.java.jvm.memory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
	at com.brianway.learning.java.jvm.memory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)

	.....



Process finished with exit code 1
 */