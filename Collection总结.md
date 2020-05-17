# <center>java容器</center>

## why？

#### 1.为什么使用容器：

​	保存对象

#### 2.java数组与容器的区别

​    java中可以存放对象（引用）的方式有两种：数组和容器

​    数组是存放对象的最有效方式

​    数组缺点：定长、不具备特定数据结构的特点，满足不了很多场合的应用

## what？

#### java容器体系

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image001.png)

##### 1.List 有序,可重复

###### ArrayList

优点: 底层数据结构是数组，查询快时间复杂度o（1），增删慢时间复杂度o（n）。

缺点: 线程不安全，效率高

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image003.jpg)

###### LinkedList

优点: 底层数据结构是链表，查询慢o（n），增删快o(1)。

缺点: 线程不安全，效率高

可作为实现栈、队列或双端队列的方法

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image005.jpg)

 

###### 用LinkedList模拟实现Stack

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image007.jpg)

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image009.jpg)

##### 2.Set 无序,唯一

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image011.jpg)

###### HashSet

底层数据结构是哈希表。(无序,唯一)

如何来保证元素唯一性?

1.依赖两个方法：hashCode()和equals()

LinkedHashSet

底层数据结构是链表和哈希表。(FIFO插入有序,唯一)

LinkedHashSet的主要功能用于保证FIFO即有序的集合(先进先出)

1.由链表保证元素有序

2.由哈希表保证元素唯一

###### TreeSet

底层数据结构是红黑树。(唯一，有序)

1. 如何保证元素排序的呢?

自然排序

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image013.jpg)

比较器排序

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image015.jpg)

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image017.jpg)

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image019.jpg)

2.如何保证元素唯一性的呢?

根据比较的返回值是否是0来决定

TreeSet的主要功能用于排序

HashSet只是通用的存储数据的集合

##### 3.queue 先进先出

​	在并发编程中可以将一个对象从一个任务传输到另一个任务，LinkedList提供Queue的支持

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image021.jpg)

##### 4.map

​    存放一组成对的“键值对”对象，通过key来查找value，主要有get和set方法，拥有将对象映射到其它对象的能力，例如Session的存储结构是Map，mybatis中的mapper也是Map。

​    Map：基于线性表的实现，搜索时会比较慢

​    HashMap：基于散列表的实现，可以通过构造器设置容量和负载因子，可以调整容器性能。

​    LinkedHashMap：类似于HashMap，但是迭代遍历时，取得键值对时使按照插入顺序或者  LRU次序，比HashMap慢一点，但迭代访问时更快。

TreeMap：基于红黑树的实现，查看键或者键值对时会排序，特点是得到的值是经过排序的。

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image023.jpg)

###### HashMap测试

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image025.jpg)

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image027.jpg)