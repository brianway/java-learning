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



## communication

- [example1](src/main/java/com/brianway/learning/java/multithread/communication/example1)
    - [Run1_TwoThreadTransData.java](src/main/java/com/brianway/learning/java/multithread/communication/example1/Run1_TwoThreadTransData.java):不使用等待/通知机制实现线程间通
- [example2](src/main/java/com/brianway/learning/java/multithread/communication/example2)
    - [Run2_noObjectLock.java](src/main/java/com/brianway/learning/java/multithread/communication/example2/Run2_noObjectLock.java):没有“对象监视器”，调用 `wait()` 方法出现运行时异常
    - [Run2_notify.java](src/main/java/com/brianway/learning/java/multithread/communication/example2/Run2_notify.java):`notify` 实现通知,`notify` 调用后，并不会立即释放对象锁，而是退出 `synchronized` 代码块后
    - [Run2_sleep.java](src/main/java/com/brianway/learning/java/multithread/communication/example2/Run2_sleep.java):测试 `sleep()` 期间其他线程是否执行
    - [Run2_wait.java](src/main/java/com/brianway/learning/java/multithread/communication/example2/Run2_wait.java):`wait()` 永远阻塞
- [example3](src/main/java/com/brianway/learning/java/multithread/communication/example3)
    - [Run3_notifyAll.java](src/main/java/com/brianway/learning/java/multithread/communication/example3/Run3_notifyAll.java):唤醒多个线程
    - [Run3_notifyMany.java](src/main/java/com/brianway/learning/java/multithread/communication/example3/Run3_notifyMany.java):通知多个线程
    - [Run3_notifyOne.java](src/main/java/com/brianway/learning/java/multithread/communication/example3/Run3_notifyOne.java):通知一个线程
- [example4](src/main/java/com/brianway/learning/java/multithread/communication/example4)
    - [Run4_waitHasParam.java](src/main/java/com/brianway/learning/java/multithread/communication/example4/Run4_waitHasParam.java):`wait(long)` 使用，超时自动唤醒
    - [Run4_waitHasParam2.java](src/main/java/com/brianway/learning/java/multithread/communication/example4/Run4_waitHasParam2.java):`wait(long)` 使用，时间限制内由其他线程唤醒
- [example5](src/main/java/com/brianway/learning/java/multithread/communication/example5)
    - [Run5_notify.java](src/main/java/com/brianway/learning/java/multithread/communication/example5/Run5_notify.java):`notify` 正常通知
    - [Run5_notifyEarly.java](src/main/java/com/brianway/learning/java/multithread/communication/example5/Run5_notifyEarly.java):`notify` 通知过早
- [example6](src/main/java/com/brianway/learning/java/multithread/communication/example6)
    - [Run6_waitOld.java](src/main/java/com/brianway/learning/java/multithread/communication/example6/Run6_waitOld.java):`wait` 等待条件变化
- [example7](src/main/java/com/brianway/learning/java/multithread/communication/example7)
    - [Run7_ProducerAndConsumer_One.java](src/main/java/com/brianway/learning/java/multithread/communication/example7/Run7_ProducerAndConsumer_One.java):生产者/消费者模式,一生产一消费
- [example8](src/main/java/com/brianway/learning/java/multithread/communication/example8)
    - [Run8_allWait.java](src/main/java/com/brianway/learning/java/multithread/communication/example8/Run8_allWait.java):多生产与多消费，假死
- [example9](src/main/java/com/brianway/learning/java/multithread/communication/example9)
    - [Run9_oneP_manyC.java](src/main/java/com/brianway/learning/java/multithread/communication/example9/Run9_oneP_manyC.java):一生产与多消费
    - [Run9_oneP_oneC.java](src/main/java/com/brianway/learning/java/multithread/communication/example9/Run9_oneP_oneC.java):一生产与一消费
- [example10](src/main/java/com/brianway/learning/java/multithread/communication/example10)
    - [Run10_oneP_manyC.java](src/main/java/com/brianway/learning/java/multithread/communication/example10/Run10_oneP_manyC.java):一生产与多消费
- [example11](src/main/java/com/brianway/learning/java/multithread/communication/example11)
    - [Run11_manyP_manyC.java](src/main/java/com/brianway/learning/java/multithread/communication/example11/Run11_manyP_manyC.java):多生产与多消费
    - [Run11_manyP_oneC.java](src/main/java/com/brianway/learning/java/multithread/communication/example11/Run11_manyP_oneC.java):多生产与一消费
    - [Run11_oneP_manyC.java](src/main/java/com/brianway/learning/java/multithread/communication/example11/Run11_oneP_manyC.java):一生产与多消费
- [example12](src/main/java/com/brianway/learning/java/multithread/communication/example12)
    - [Run12_pipeInputOutput.java](src/main/java/com/brianway/learning/java/multithread/communication/example12/Run12_pipeInputOutput.java):通过管道进行线程间通信：字节流
- [example13](src/main/java/com/brianway/learning/java/multithread/communication/example13)
    - [Run13_wait_notify_insert.java](src/main/java/com/brianway/learning/java/multithread/communication/example13/Run13_wait_notify_insert.java):等待/通知，交叉执行
- [example14](src/main/java/com/brianway/learning/java/multithread/communication/example14)
    - [Run14_join.java](src/main/java/com/brianway/learning/java/multithread/communication/example14/Run14_join.java):`join` 示例
    - [Run14_joinExption.java](src/main/java/com/brianway/learning/java/multithread/communication/example14/Run14_joinExption.java):`join` 的异常
    - [Run14_joinLong.java](src/main/java/com/brianway/learning/java/multithread/communication/example14/Run14_joinLong.java):`join(long)` 设定等待的时间,`join(long)` 和 `sleep(long)` 运行效果并无区别，但对同步的处理不同
- [example15](src/main/java/com/brianway/learning/java/multithread/communication/example15)
    - [Run15_join_sleep.java](src/main/java/com/brianway/learning/java/multithread/communication/example15/Run15_join_sleep.java):`join(long)` 和 `sleep(long)` 的区别,`sleep(long)` 方法不释放锁
    - [Run15_join_sleep_2.java](src/main/java/com/brianway/learning/java/multithread/communication/example15/Run15_join_sleep_2.java):`join(long)` 和 `sleep(long)` 的区别,`join(long)` 释放锁
    - [Run15_joinMore.java](src/main/java/com/brianway/learning/java/multithread/communication/example15/Run15_joinMore.java):方法 `join` 后面的代码提前运行
- [example16](src/main/java/com/brianway/learning/java/multithread/communication/example16)
    - [Run16_InheritableThreadLocalExt.java](src/main/java/com/brianway/learning/java/multithread/communication/example16/Run16_InheritableThreadLocalExt.java):类 `InheritableThreadLocal` 使用，值继承，子线程从父线程取得值
    - [Run16_InheritableThreadLocalExt2.java](src/main/java/com/brianway/learning/java/multithread/communication/example16/Run16_InheritableThreadLocalExt2.java):类 `InheritableThreadLocal` 使用，值继承再更改
    - [Run16_ThreadLocal.java](src/main/java/com/brianway/learning/java/multithread/communication/example16/Run16_ThreadLocal.java):验证线程变量的隔离性
  

## lock

- [example1](src/main/java/com/brianway/learning/java/multithread/lock/example1)
    - [Run1_UseConditionWaitNotify.java](src/main/java/com/brianway/learning/java/multithread/lock/example1/Run1_UseConditionWaitNotify.java):使用 Condition 实现等待通知,Condition 对象的 `await()`方法，线程`WAITING`
    - [Run1_UseConditionWaitNotifyError.java](src/main/java/com/brianway/learning/java/multithread/lock/example1/Run1_UseConditionWaitNotifyError.java):`IllegalMonitorStateException`，监视器出错
    - [Run1_UseConditionWaitNotifyOk.java](src/main/java/com/brianway/learning/java/multithread/lock/example1/Run1_UseConditionWaitNotifyOk.java):正确使用Condition实现等待通知
- [example2](src/main/java/com/brianway/learning/java/multithread/lock/example2)
    - [Run2_MustUseMoreCondition.java](src/main/java/com/brianway/learning/java/multithread/lock/example2/Run2_MustUseMoreCondition.java):使用多个 condition 实现通知部分线程
- [example3](src/main/java/com/brianway/learning/java/multithread/lock/example3)
    - [Run3_ConditionManyToMany.java](src/main/java/com/brianway/learning/java/multithread/lock/example3/Run3_ConditionManyToMany.java):实现生产者/消费者模式，多对多交替打印
- [example4](src/main/java/com/brianway/learning/java/multithread/lock/example4)
    - [Run4_Fair.java](src/main/java/com/brianway/learning/java/multithread/lock/example4/Run4_Fair.java):公平锁测试,打印结果呈有序状态
    - [Run4_notFair.java](src/main/java/com/brianway/learning/java/multithread/lock/example4/Run4_notFair.java):非公平锁测试,打印结果乱序，先启动的线程不一定先获得锁
- [example5](src/main/java/com/brianway/learning/java/multithread/lock/example5)
    - [Run5_getHoldCount.java](src/main/java/com/brianway/learning/java/multithread/lock/example5/Run5_getHoldCount.java):测试方法 `int getHoldCount()` 
    - [Run5_getQueueLength.java](src/main/java/com/brianway/learning/java/multithread/lock/example5/Run5_getQueueLength.java):测试方法 `int getQueueLength()` 
    - [Run5_getWaitQueueLength.java](src/main/java/com/brianway/learning/java/multithread/lock/example5/Run5_getWaitQueueLength.java):测试方法 `int getWaitQueueLength(Condition condition)`
- [example6](src/main/java/com/brianway/learning/java/multithread/lock/example6)
    - [Run6_hasQueueThread.java](src/main/java/com/brianway/learning/java/multithread/lock/example6/Run6_hasQueueThread.java):测试方法 `boolean hasQueueThread(Thread thread)` 和 `boolean hasQueueThreads()`
    - [Run6_hasWaiters.java](src/main/java/com/brianway/learning/java/multithread/lock/example6/Run6_hasWaiters.java):测试方法 `boolean hasWaiters(Condition)` 
- [example7](src/main/java/com/brianway/learning/java/multithread/lock/example7)
    - [Run7_isFair.java](src/main/java/com/brianway/learning/java/multithread/lock/example7/Run7_isFair.java):测试方法 `boolean isFair()`
    - [Run7_isHeldByCurrentThread.java](src/main/java/com/brianway/learning/java/multithread/lock/example7/Run7_isHeldByCurrentThread.java):测试方法 `boolean isHeldByCurrentThread()`
    - [Run7_isLocked.java](src/main/java/com/brianway/learning/java/multithread/lock/example7/Run7_isLocked.java):测试方法 `boolean isLocked()`
- [example8](src/main/java/com/brianway/learning/java/multithread/lock/example8)
    - [Run8_lockInterruptibly1.java](src/main/java/com/brianway/learning/java/multithread/lock/example8/Run8_lockInterruptibly1.java):测试方法 `void lockInterruptibly()`
    - [Run8_lockInterruptibly2.java](src/main/java/com/brianway/learning/java/multithread/lock/example8/Run8_lockInterruptibly2.java):测试方法 `void lockInterruptibly()`
    - [Run8_tryLock.java](src/main/java/com/brianway/learning/java/multithread/lock/example8/Run8_tryLock.java):测试方法 `boolean tryLock()`
    - [Run8_tryLock_param.java](src/main/java/com/brianway/learning/java/multithread/lock/example8/Run8_tryLock_param.java):测试方法 `boolean tryLock(long timeout,TimeUnit unit)`
- [example9](src/main/java/com/brianway/learning/java/multithread/lock/example9)
    - [Run9_awaitUniterruptibly1.java](src/main/java/com/brianway/learning/java/multithread/lock/example9/Run9_awaitUniterruptibly1.java):测试方法 `awaitUniterruptibly()`
    - [Run9_awaitUniterruptibly2.java](src/main/java/com/brianway/learning/java/multithread/lock/example9/Run9_awaitUniterruptibly2.java):测试方法 `awaitUniterruptibly()`
    - [Run9_awaitUntil1.java](src/main/java/com/brianway/learning/java/multithread/lock/example9/Run9_awaitUntil1.java):测试方法 `awaitUntil()`
    - [Run9_awaitUntil2.java](src/main/java/com/brianway/learning/java/multithread/lock/example9/Run9_awaitUntil2.java):测试方法 `awaitUntil()`
- [example10](src/main/java/com/brianway/learning/java/multithread/lock/example10)
    - [Run10_condition.java](src/main/java/com/brianway/learning/java/multithread/lock/example10/Run10_condition.java):Condition 实现顺序打印
    - [Run10_ReadWriteLockBegin1.java](src/main/java/com/brianway/learning/java/multithread/lock/example10/Run10_ReadWriteLockBegin1.java):类 `ReentrantReadWriteLock` 的使用：读读共享
    - [Run10_ReadWriteLockBegin2.java](src/main/java/com/brianway/learning/java/multithread/lock/example10/Run10_ReadWriteLockBegin2.java):类 `ReentrantReadWriteLock` 的使用：写写互斥
    - [Run10_ReadWriteLockBegin3.java](src/main/java/com/brianway/learning/java/multithread/lock/example10/Run10_ReadWriteLockBegin3.java):类 `ReentrantReadWriteLock` 的使用：读写互斥


## timer

- [example1](src/main/java/com/brianway/learning/java/multithread/timer/example1):`schedule(TimerTask task, Date time)` 测试
    - [Run1_timer1.java](src/main/java/com/brianway/learning/java/multithread/timer/example1/Run1_timer1.java):在未来执行的效果,Timer 的构造方法会新启一个线程，且非守护线程
    - [Run1_timer2.java](src/main/java/com/brianway/learning/java/multithread/timer/example1/Run1_timer2.java):在未来执行的效果,Timer 的构造方法会新启一个守护线程,迅速结束，task任务未被执行
    - [Run1_timer3.java](src/main/java/com/brianway/learning/java/multithread/timer/example1/Run1_timer3.java):提前运行的效果
    - [Run1_timer4.java](src/main/java/com/brianway/learning/java/multithread/timer/example1/Run1_timer4.java):多个 TimerTask 任务及延时
    - [Run1_timer5.java](src/main/java/com/brianway/learning/java/multithread/timer/example1/Run1_timer5.java):多个TimerTask任务及延时,队列的方式，一个一个被顺序执行，前面一个耗时长则后面的任务被延后
- [example2](src/main/java/com/brianway/learning/java/multithread/timer/example2):`schedule(TimerTask task, long delay, long period)` 测试
    - [Run2_period1.java](src/main/java/com/brianway/learning/java/multithread/timer/example2/Run2_period1.java):在未来执行的效果
    - [Run2_period2.java](src/main/java/com/brianway/learning/java/multithread/timer/example2/Run2_period2.java):提前运行的效果
    - [Run2_period3.java](src/main/java/com/brianway/learning/java/multithread/timer/example2/Run2_period3.java):任务执行时间被延时
- [example3](src/main/java/com/brianway/learning/java/multithread/timer/example3)
    - [Run3_cancel1.java](src/main/java/com/brianway/learning/java/multithread/timer/example3/Run3_cancel1.java):`TimerTask` 类的 `cancel()` 方法,将自身从任务队列移除，其他任务不受影响
    - [Run3_cancel2.java](src/main/java/com/brianway/learning/java/multithread/timer/example3/Run3_cancel2.java):`Timer` 类的 `cancel()`方法,全部任务被清除，且进程被销毁
    - [Run3_cancel3.java](src/main/java/com/brianway/learning/java/multithread/timer/example3/Run3_cancel3.java):`Timer` 类的 `cancel()`方法,有时不一定会停止计划任务
- [example4](src/main/java/com/brianway/learning/java/multithread/timer/example4)
    - [Run4_schedule1.java](src/main/java/com/brianway/learning/java/multithread/timer/example4/Run4_schedule1.java):`schedule(TimerTask task, long delay)` 方法
    - [Run4_schedule2.java](src/main/java/com/brianway/learning/java/multithread/timer/example4/Run4_schedule2.java):`schedule(TimerTask task, long delay, long period)` 方法
    - [Run4_schedule3.java](src/main/java/com/brianway/learning/java/multithread/timer/example4/Run4_schedule3.java):`schedule(TimerTask task, Date firstTime, long period)` 方法
    - [Run4_schedule4.java](src/main/java/com/brianway/learning/java/multithread/timer/example4/Run4_schedule4.java):`schedule(TimerTask task, long delay, long period)` 方法
    - [Run4_schedule5.java](src/main/java/com/brianway/learning/java/multithread/timer/example4/Run4_schedule5.java):`schedule(TimerTask task, Date firstTime, long period)` 方法
    - [Run4_schedule6.java](src/main/java/com/brianway/learning/java/multithread/timer/example4/Run4_schedule6.java):`schedule(TimerTask task, long delay, long period)` 方法
    - [Run4_schedule_vs_scheduleAtFixedRate_1.java](src/main/java/com/brianway/learning/java/multithread/timer/example4/Run4_schedule_vs_scheduleAtFixedRate_1.java):schedule 不具有追赶执行性
    - [Run4_schedule_vs_scheduleAtFixedRate_2.java](src/main/java/com/brianway/learning/java/multithread/timer/example4/Run4_schedule_vs_scheduleAtFixedRate_2.java):scheduleAtFixedRate 具有追赶执行性
    - [Run4_scheduleAtFixedRate1.java](src/main/java/com/brianway/learning/java/multithread/timer/example4/Run4_scheduleAtFixedRate1.java):`scheduleAtFixedRate(TimerTask task, Date firstTime,long period)` 方法
    - [Run4_scheduleAtFixedRate2.java](src/main/java/com/brianway/learning/java/multithread/timer/example4/Run4_scheduleAtFixedRate2.java):`scheduleAtFixedRate(TimerTask task, long delay, long period)` 方法
    - [Run4_scheduleAtFixedRate3.java](src/main/java/com/brianway/learning/java/multithread/timer/example4/Run4_scheduleAtFixedRate3.java):`scheduleAtFixedRate(TimerTask task, Date firstTime, long period)` 方法
    - [Run4_scheduleAtFixedRate4.java](src/main/java/com/brianway/learning/java/multithread/timer/example4/Run4_scheduleAtFixedRate4.java):`scheduleAtFixedRate(TimerTask task, long delay, long period)` 方法


## singleton


- [example1](src/main/java/com/brianway/learning/java/multithread/singleton/example1)
    - [Run1_singleton0.java](src/main/java/com/brianway/learning/java/multithread/singleton/example1/Run1_singleton0.java):立即加载/“饿汉模式”
    - [Run1_singleton1.java](src/main/java/com/brianway/learning/java/multithread/singleton/example1/Run1_singleton1.java):延迟加载/“懒汉模式”(会出问题)
    - [Run1_singleton2.java](src/main/java/com/brianway/learning/java/multithread/singleton/example1/Run1_singleton2.java):延迟加载/“懒汉模式”缺点展示
- [example2](src/main/java/com/brianway/learning/java/multithread/singleton/example2):延迟加载/“懒汉模式”解决方案
    - [Run2_singleton1.java](src/main/java/com/brianway/learning/java/multithread/singleton/example2/Run2_singleton1.java):声明 `synchronized` 关键字，整个方法上锁
    - [Run2_singleton2.java](src/main/java/com/brianway/learning/java/multithread/singleton/example2/Run2_singleton2.java):声明 `synchronized` 关键字，同步代码块
    - [Run2_singleton3.java](src/main/java/com/brianway/learning/java/multithread/singleton/example2/Run2_singleton3.java):声明 `synchronized` 关键字，部分代码上锁
    - [Run2_singleton4.java](src/main/java/com/brianway/learning/java/multithread/singleton/example2/Run2_singleton4.java):DCL 双检查锁机制
- [example3](src/main/java/com/brianway/learning/java/multithread/singleton/example3)
    - [Run3_singleton1.java](src/main/java/com/brianway/learning/java/multithread/singleton/example3/Run3_singleton1.java):使用静态内置类实现单例模式
    - [Run3_singleton2.java](src/main/java/com/brianway/learning/java/multithread/singleton/example3/Run3_singleton2.java):序列化与反序列化的单例模式实现
    - [Run3_singleton3.java](src/main/java/com/brianway/learning/java/multithread/singleton/example3/Run3_singleton3.java):使用 `static` 代码块实现单例模式
    - [Run3_singleton4.java](src/main/java/com/brianway/learning/java/multithread/singleton/example3/Run3_singleton4.java):使用 `enum` 枚举数据类型实现单例模式
    - [Run3_singleton5.java](src/main/java/com/brianway/learning/java/multithread/singleton/example3/Run3_singleton5.java):使用 `enum` 枚举数据类型实现单例模式


## supplement

- [example1](src/main/java/com/brianway/learning/java/multithread/supplement/example1)
    - [Run1_state1.java](src/main/java/com/brianway/learning/java/multithread/supplement/example1/Run1_state1.java):验证 `NEW,RUNNABLE`,`TERMINATED`
    - [Run1_state2.java](src/main/java/com/brianway/learning/java/multithread/supplement/example1/Run1_state2.java):验证 `TIMED_WAITING`
    - [Run1_state3.java](src/main/java/com/brianway/learning/java/multithread/supplement/example1/Run1_state3.java):验证 `BLOCKED`
- [example2](src/main/java/com/brianway/learning/java/multithread/supplement/example2)
    - [Run2_autoAddGroup.java](src/main/java/com/brianway/learning/java/multithread/supplement/example2/Run2_autoAddGroup.java):线程组自动归属特性
    - [Run2_getGroupParent.java](src/main/java/com/brianway/learning/java/multithread/supplement/example2/Run2_getGroupParent.java):获取根线程组,JVM 根线程组就是 system
    - [Run2_groupAddThread.java](src/main/java/com/brianway/learning/java/multithread/supplement/example2/Run2_groupAddThread.java)线程对象关联线程组，一级关联
    - [Run2_groupAddThreadMoreLevel.java](src/main/java/com/brianway/learning/java/multithread/supplement/example2/Run2_groupAddThreadMoreLevel.java):线程对象关联线程组,多级关联
    - [Run2_threadRunSyn.java](src/main/java/com/brianway/learning/java/multithread/supplement/example2/Run2_threadRunSyn.java):使线程具有有序性
- [example3](src/main/java/com/brianway/learning/java/multithread/supplement/example3)
    - [Run3_formatError.java](src/main/java/com/brianway/learning/java/multithread/supplement/example3/Run3_formatError.java):`SimpleDateFormat` 类非线程安全
    - [Run3_formatOK1.java](src/main/java/com/brianway/learning/java/multithread/supplement/example3/Run3_formatOK1.java):`SimpleDateFormat` 类非线程安全，解决异常方法一
    - [Run3_formatOK2.java](src/main/java/com/brianway/learning/java/multithread/supplement/example3/Run3_formatOK2.java):`SimpleDateFormat` 类非线程安全，解决异常方法二
- [example4](src/main/java/com/brianway/learning/java/multithread/supplement/example4)
    - [Run4_threadCreateException.java](src/main/java/com/brianway/learning/java/multithread/supplement/example4/Run4_threadCreateException.java):线程中出现异常
    - [Run4_threadCreateException2.java](src/main/java/com/brianway/learning/java/multithread/supplement/example4/Run4_threadCreateException2.java):线程中出现异常，捕捉
    - [Run4_threadCreateException3.java](src/main/java/com/brianway/learning/java/multithread/supplement/example4/Run4_threadCreateException3.java):线程中出现异常，捕捉
- [example5](src/main/java/com/brianway/learning/java/multithread/supplement/example5)
    - [Run5_threadGroup1.java](src/main/java/com/brianway/learning/java/multithread/supplement/example5/Run5_threadGroup1.java):线程组内处理异常
    - [Run5_threadGroup2.java](src/main/java/com/brianway/learning/java/multithread/supplement/example5/Run5_threadGroup2.java):线程组内处理异常
- [example6](src/main/java/com/brianway/learning/java/multithread/supplement/example6)
    - [Run6_threadExceptionMove1.java](src/main/java/com/brianway/learning/java/multithread/supplement/example6/Run6_threadExceptionMove1.java)
    - [Run6_threadExceptionMove2.java](src/main/java/com/brianway/learning/java/multithread/supplement/example6/Run6_threadExceptionMove2.java)
   