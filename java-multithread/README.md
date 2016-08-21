# 多线程模块

知识点的文字梳理请参考这篇文章:[java多线程核心技术梳理](http://blog.csdn.net/h3243212/article/details/51180173)

下面对该模块的几个部分作说明:

## meet

该部分是一些简单的基础知识的展示

- [printMain.java](src/main/java/com/brianway/learning/java/multithread/meet/printMain.java):打印当前线程名称
- [Run.java](src/main/java/com/brianway/learning/java/multithread/meet/Run.java):非线程安全的数据共享
- [Run2_StartVsRun.java](src/main/java/com/brianway/learning/java/multithread/meet/Run2_StartVsRun.java):run()和start()的区别
- [Run3_getName.java](src/main/java/com/brianway/learning/java/multithread/meet/Run3_getName.java):this.getName()！=Thread.currentThread().getName()，这是两个概念
- [Run4_isAlive01.java](src/main/java/com/brianway/learning/java/multithread/meet/Run4_isAlive01.java):isAlive()
- [Run5_isAlive02.java](src/main/java/com/brianway/learning/java/multithread/meet/Run5_isAlive02.java):isAlive()
- [Run6_StartVsRun02.java](src/main/java/com/brianway/learning/java/multithread/meet/Run6_StartVsRun02.java):run()同步执行,start()异步执行
- [Run7_interrupt01.java](src/main/java/com/brianway/learning/java/multithread/meet/Run7_interrupt01.java):停止线程
- [Run8_interrupted01.java](src/main/java/com/brianway/learning/java/multithread/meet/Run8_interrupted01.java):判断线程是否停止状态,测试当前线程是否已经中断
- [Run9_interrupted02.java](src/main/java/com/brianway/learning/java/multithread/meet/Run9_interrupted02.java):线程的中断状态由interrupted()清除
- [Run10_isInterrupted.java](src/main/java/com/brianway/learning/java/multithread/meet/Run10_isInterrupted.java):isInterrupted()，不清除状态标记
- [Run11_sleepAndinterrupt01.java](src/main/java/com/brianway/learning/java/multithread/meet/Run11_sleepAndinterrupt01.java):睡眠中停止，先进入的sleep,再interrupt()
- [Run12_sleepAndinterrupt02.java](src/main/java/com/brianway/learning/java/multithread/meet/Run12_sleepAndinterrupt02.java):先interrupt(),再进入sleep(),直接进异常
- [Run13_suspendAndresume01.java](src/main/java/com/brianway/learning/java/multithread/meet/Run13_suspendAndresume01.java):暂停线程,suspend()与resume()
- [Run14_suspendAndresume02.java](src/main/java/com/brianway/learning/java/multithread/meet/Run14_suspendAndresume02.java):suspend()与resume()的缺点：独占
- [Run15_suspendAndresume03.java](src/main/java/com/brianway/learning/java/multithread/meet/Run15_suspendAndresume03.java):suspend()独占锁问题,println()
- [Run16_yield.java](src/main/java/com/brianway/learning/java/multithread/meet/Run16_yield.java):测试yield()
- [Run17_priority01.java](src/main/java/com/brianway/learning/java/multithread/meet/Run17_priority01.java):线程优先级的继承性
- [Run18_priority02.java](src/main/java/com/brianway/learning/java/multithread/meet/Run18_priority02.java):优先级具有规则性
