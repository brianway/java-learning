# Java 8 新特性

阅读《Java 8 in Action》一书的简单整理

源码参考了 **java8/Java8InAction**:[https://github.com/java8/Java8InAction](https://github.com/java8/Java8InAction)

## lambda 表达式

- FilteringApples: 传递代码的例子,展示方法引用和 Lambda


## steam API

- Dish: 菜肴类,有一个静态属性的菜肴列表
- StreamBasic: 指令式和函数式分别挑选低热量食物名
- StreamOperation: 流操作(中间操作和终端操作)
- Laziness: 流操作-中间操作
- BuildingStreams: 构建流,从值序列,数组,文件来创建流。斐波拉切数列的几种生成方法


使用流

- Filtering: 筛选(谓词筛选：filter;筛选互异的元素：distinct;忽略头几个元素：limit;截短至指定长度：skip)
- Mapping: 映射
- Finding: 查找和匹配
- Reducing: 归约
- PuttingIntoPractice: 各种流操作的使用示例
- NumericStreams: 数值流(原始类型特化,数值范围)

用流收集数据

- Summarizing: 归约和汇总
- Reducing: 收集器的灵活性,以不同的方法执行相同的操作
- Grouping: 分组
- Partitioning: 分区
- GroupingTransactions: 分别使用指令式和函数式进行分组
- ToListCollector: 自定义 ToListCollector,以及进行自定义收集而不去实现 Collector
- PartitionPrimeNumbers: 将数字按质数和非质数分区;Collector 详解
- CollectorHarness: 比较收集器的性能


并行数据处理

- ParallelStreamsHarness: 测量流性能
- ParallelStreams: 并行流计算 1~n 的和,分别使用指令式,串行迭代流,并行迭代流,基本类型流,有副作用的流
- ForkJoinSumCalculator: 使用分支/合并框架执行并行求和
- WordCount: Spliterator: splitable iterator

## 高效 Java 8 编程

- StrategyMain: 策略模式
- TemplateMain: 模版方法
- ObserverMain: 观察者模式
- ChainOfResponsibilityMain: 责任链模式
- FactoryMain: 工厂模式
- Debugging: 查看栈跟踪
- Peek: 使用日志调试