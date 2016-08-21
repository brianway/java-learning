# 多线程模块

知识点的文字梳理请参考这篇文章:[java多线程核心技术梳理](http://blog.csdn.net/h3243212/article/details/51180173)

下面对该模块的几个包作说明:

## meet

该部分是一些简单的基础知识的展示

- [printMain.java](src/main/java/com/brianway/learning/java/multithread/meet/printMain.java):打印当前线程名称
- [Run.java](src/main/java/com/brianway/learning/java/multithread/meet/Run.java):非线程安全的数据共享
- [Run2_StartVsRun.java](src/main/java/com/brianway/learning/java/multithread/meet/Run2_StartVsRun.java):`run()` 和 `start()` 的区别
- [Run3_getName.java](src/main/java/com/brianway/learning/java/multithread/meet/Run3_getName.java):`this.getName()！=Thread.currentThread().getName()`，这是两个概念
- [Run4_isAlive01.java](src/main/java/com/brianway/learning/java/multithread/meet/Run4_isAlive01.java):`isAlive()`
- [Run5_isAlive02.java](src/main/java/com/brianway/learning/java/multithread/meet/Run5_isAlive02.java):`isAlive()`
- [Run6_StartVsRun02.java](src/main/java/com/brianway/learning/java/multithread/meet/Run6_StartVsRun02.java):`run()` 同步执行,`start()` 异步执行
- [Run7_interrupt01.java](src/main/java/com/brianway/learning/java/multithread/meet/Run7_interrupt01.java):停止线程
- [Run8_interrupted01.java](src/main/java/com/brianway/learning/java/multithread/meet/Run8_interrupted01.java):判断线程是否停止状态,测试当前线程是否已经中断
- [Run9_interrupted02.java](src/main/java/com/brianway/learning/java/multithread/meet/Run9_interrupted02.java):线程的中断状态由 `interrupted()` 清除
- [Run10_isInterrupted.java](src/main/java/com/brianway/learning/java/multithread/meet/Run10_isInterrupted.java):`isInterrupted()`，不清除状态标记
- [Run11_sleepAndinterrupt01.java](src/main/java/com/brianway/learning/java/multithread/meet/Run11_sleepAndinterrupt01.java):睡眠中停止，先进入的 `sleep()`,再 `interrupt()`
- [Run12_sleepAndinterrupt02.java](src/main/java/com/brianway/learning/java/multithread/meet/Run12_sleepAndinterrupt02.java):先 `interrupt()`,再进入 `sleep()`,直接进异常
- [Run13_suspendAndresume01.java](src/main/java/com/brianway/learning/java/multithread/meet/Run13_suspendAndresume01.java):暂停线程,`suspend()` 与 `resume()`
- [Run14_suspendAndresume02.java](src/main/java/com/brianway/learning/java/multithread/meet/Run14_suspendAndresume02.java):`suspend()` 与 `resume()` 的缺点：独占
- [Run15_suspendAndresume03.java](src/main/java/com/brianway/learning/java/multithread/meet/Run15_suspendAndresume03.java):`suspend()` 独占锁问题,`println()`
- [Run16_yield.java](src/main/java/com/brianway/learning/java/multithread/meet/Run16_yield.java):测试 `yield()`
- [Run17_priority01.java](src/main/java/com/brianway/learning/java/multithread/meet/Run17_priority01.java):线程优先级的继承性
- [Run18_priority02.java](src/main/java/com/brianway/learning/java/multithread/meet/Run18_priority02.java):优先级具有规则性

## synchronize

- [example1](src/main/java/com/brianway/learning/java/multithread/synchronize/example1)
    - [Run1_local.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example1/Run1_local.java):方法内局部变量则不存在“非线程安全”问题
- [example2](src/main/java/com/brianway/learning/java/multithread/synchronize/example2)
    - [Run2_private01.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example2/Run2_private01.java):实例变量非线程安全
    - [Run2_twoObject.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example2/Run2_twoObject.java):多个对象多个锁
- [example3](src/main/java/com/brianway/learning/java/multithread/synchronize/example3)
    - [Run3_synchronized01.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example3/Run3_synchronized01.java):`synchronized` 方法与锁对象
- [example4](src/main/java/com/brianway/learning/java/multithread/synchronize/example4)
    - [Run4_synchronized01.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example4/Run4_synchronized01.java):两个线程访问同一个对象的不同方法,线程 B 可异步调用非 `synchronized` 类型方法
- [example5](src/main/java/com/brianway/learning/java/multithread/synchronize/example5)
    - [Run5_lockRein.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example5/Run5_lockRein.java):`synchronized` 锁重入，支持继承
- [example6](src/main/java/com/brianway/learning/java/multithread/synchronize/example6)
    - [Run6_exception.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example6/Run6_exception.java):出现异常，锁自动释放
- [example7](src/main/java/com/brianway/learning/java/multithread/synchronize/example7)
    - [Run7_synNotExtends.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example7/Run7_synNotExtends.java):同步不具继承性
- [example8](src/main/java/com/brianway/learning/java/multithread/synchronize/example8)
    - [Run8_synchronized01.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example8/Run8_synchronized01.java):`synchronized` 方法的弊端
    - [Run8_synchronized02.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example8/Run8_synchronized02.java):同步代码块解决同步方法的弊端
- [example9](src/main/java/com/brianway/learning/java/multithread/synchronize/example9)
    - [Run9_synchronized01.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example9/Run9_synchronized01.java):当多个线程同时执行`synchronized(x){}`同步代码块时呈现效果
    - [Run9_synchronized01_twoObjects.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example9/Run9_synchronized01_twoObjects.java):不同的“对象监视器”
    - [Run9_synchronized02.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example9/Run9_synchronized02.java):当其他线程执行 x 对象中 `synchronized` 同步方法时呈同步效果
    - [Run9_synchronized03.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example9/Run9_synchronized03.java):当其他线程执行 x 对象里面的`synchronized(this)`代码块时，也呈现同步效果
- [example10](src/main/java/com/brianway/learning/java/multithread/synchronize/example10)
    - [Run10_synBlockMoreObjectOneLock.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example10/Run10_synBlockMoreObjectOneLock.java):验证同步 `synchronized(class)` 代码块的作用
    - [Run10_synMoreObjectStaticOneLock.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example10/Run10_synMoreObjectStaticOneLock.java):Class 锁可以对类的所有对象实例起作用
    - [Run10_synTwoLock.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example10/Run10_synTwoLock.java):验证 `synchronized` 关键字加载 `static` 静态方法和加到非静态方法不是同一个锁
- [example11](src/main/java/com/brianway/learning/java/multithread/synchronize/example11)
    - [Run11_StringAndSyn.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example11/Run11_StringAndSyn.java):String 作为锁对象,常量池->同一锁
    - [Run11_StringAndSyn2.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example11/Run11_StringAndSyn2.java):不使用 String 作为锁对象
- [example12](src/main/java/com/brianway/learning/java/multithread/synchronize/example12)
    - [Run12_deadLock.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example12/Run12_deadLock.java):死锁测试,jstack命令
- [example13](src/main/java/com/brianway/learning/java/multithread/synchronize/example13)
    - [Run13_inner01.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example13/Run13_inner01.java):内置类和同步测试1
    - [Run13_inner02.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example13/Run13_inner02.java):内置类与同步测试2
- [example14](src/main/java/com/brianway/learning/java/multithread/synchronize/example14)
    - [Run14_setNewStringTwoLock.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example14/Run14_setNewStringTwoLock.java):锁对象改变
- [example15](src/main/java/com/brianway/learning/java/multithread/synchronize/example15)
    - [Run15_synchronized.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example15/Run15_synchronized.java):`synchronized` 代码块有 `volatile` 同步的功能
    - [Run15_volatile.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example15/Run15_volatile.java):不使用 `volatile` 关键字,JVM 配置 `-server`
- [example16](src/main/java/com/brianway/learning/java/multithread/synchronize/example16)
    - [Run16_volatile.java](src/main/java/com/brianway/learning/java/multithread/synchronize/example16/Run16_volatile.java):`volatile` 非原子的特性
