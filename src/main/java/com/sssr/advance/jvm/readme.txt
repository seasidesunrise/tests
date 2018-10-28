jvm的堆、栈是怎么划分的

这样定义一行代码：
int[] arr =  {1,2,3};

请描述一下，数据是在堆还是栈里面？

参考回答：数组在heap的eden区里面，引用在栈里面？

Java JVM heap区域分为新生代和老年代，原来的持久代在jdk8以后被挪到了method Area。
其中新生代包括eden区以及Suvivor区，默认为8：1：1。

gc算法有引用计数、分代，cms，G1等。

stw怎么消除，minor和major gc都会产生stw，减少stw的频率，以及每次stw的时间，是优化的目标。

oom发生时，看是再哪一个地方产生的oom，一般堆栈会给出具体在哪一个区发生的oom。