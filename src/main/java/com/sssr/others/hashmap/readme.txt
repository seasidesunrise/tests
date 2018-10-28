java的hashmap

数组+单向链表的数据结构，jdk1.8以后增加了红黑树的机制，单链表长度大于8时，转换为红黑树，提高查询效率。

hashmap不支持并发操作，hashtable可以，并发的hashmap同时可以有ConcurrentHashMap（分阶段锁），以及Collections.synchronizedMap()，全局锁，效率较低。

hashmap默认大小是16，默认扩容因子是0.75，其长度永远是2的n次方，这样设计感觉是基于扩容方便。