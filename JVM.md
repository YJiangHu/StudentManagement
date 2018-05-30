###1. JVM运行时内存区


 ![JVM运行时内存区](https://img-blog.csdn.net/20180530205418318?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0NTX2Zsb3dlcjQ5NQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
	 
	 

 - 线程共享内存区：

   - Method Area: 方法区
   - Heap: 堆区
   - 运行时常量池（方法区的一部分）
 - 线程私有内存区
  - Java Stack: Java栈（虚拟机栈）
  - Native Method Stack: 本地方法栈
  - Program Counter Register: 程序计数器
  
下面将对每一片内存区一一进行介绍。


###2. 线程共享内存区
 1. Java 堆区
      

   - 定义: 
	   Java堆区是一块用于`存储对象实例`的内存区，同时也是GC（垃圾回收器）执行垃圾回收的重点区域（所以GC极有可能会在大内存的使用和回收上成为性能瓶颈）。
	   
   -  特点：
   Java堆区在`JVM启动时`被创建，并且在实际的内存空间中可以`不连续`。
   
 - JVM中Java对象的划分 : 
	 在介绍分代收集算法之前，我们先来了解下存储在JVM中Java对象的划分。
	 
	  - 第一类：生命周期较短的瞬时对象。这类对象的创建和消亡都非常迅速
	  - 第二类：生命周期非常长的对象。这类对象在某些极端情况下能与JVM生命周期保持一致
	  
  - 分代收集算法 
	  由于存在
	  ![这里写图片描述](https://img-blog.csdn.net/20180530215101917?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0NTX2Zsb3dlcjQ5NQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
	 	 

	