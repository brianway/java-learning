# Java 8 新特性

阅读《Java 8 in Action》一书的简单整理

源码参考了 **java8/Java8InAction**:[https://github.com/java8/Java8InAction](https://github.com/java8/Java8InAction)

## lambda 表达式

- FilteringApples: 传递代码的例子,展示方法引用和 Lambda


## steam API

- Dish: 菜肴类,有一个静态属性的菜肴列表
- StreamBasic: 指令式和函数式分别挑选低热量食物名
- StreamOperation: 流操作(中间操作和终端操作)

使用流

- Filtering: 筛选(谓词筛选：filter;筛选互异的元素：distinct;忽略头几个元素：limit;截短至指定长度：skip)
- Mapping: 映射
- PuttingIntoPractice: 各种流操作的使用示例
