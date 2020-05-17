# <center>java异常</center>

## 一、why？

###  在java中为什么要使用异常机制

​		在c中程序出现错误是会有约定形成的处理方式，例如return -1等，它没有办法可以强制程序在出现问题时停止在某条路经上运行下去，异常机制本身不属于语言的部分，错误处理代码和程序本身在一块，导致编程时在异常处理上会花费很多时间。

  	  java中的错误和异常处理属于语言本身的部分，通过编译器强制执行，异常处理程序和一场出现的地方分离，使代码更清晰。

​    	异常最重要的方面之一就是如果发生问题，他们将不允许程序沿着其正常的路径继续走下去。异常允许我们强制程序停止运行，并告诉我们出现了什么问题，或者强制程序处理问题，并返回到稳定状态。

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image002.jpg)

## 二、what?

### java异常出现、抛出、处理的过程

​		当代码中出现无法处理或者不知道如何处理的地方时，需要抛出异常，此时，java会在堆上new异常对象，当前执行路径被终止，并从当前环境弹出异常对象的引用，此时，异常处理机制接管程序，找到合适的地方即异常处理程序继续执行程序，它的任务就是将任务从错误状态中恢复，使程序要么换一种方式运行，要么继续运行下去。

#### 1.捕获异常与异常处理程序

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image004.jpg)

#### 2.被检查异常（IOException）与异常声明throws

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image006.jpg)

#### 3.创建自定义异常

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image008.jpg)

#### 4.使用finally清理

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image010.jpg)

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image012.jpg)

### java标准异常

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image014.png)

###### Error：

​		用来表示编译时和系统错误，一般不用关注

###### Exception：

   	 RuntimeException(运行时异常、非受查异常)：编译时不会检测运行时会自动检测，一旦    出现运行时异常，那么一定是编写者的错误，如数组越界，空指针等。

  	  IOException(受查异常)：编译器时检查，一旦出现受查异常，要么捕获处理，要么throws    声明异常交由调用者处理。