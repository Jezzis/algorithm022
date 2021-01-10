# 学习笔记

## 简单
- 时间复杂度的理解
  [时间复杂度与大O记号](https://blog.csdn.net/qq_33655521/article/details/84104776)
- -写一个关于 HashMap 的小总结。
说明：对于不熟悉 Java 语言的同学，此项作业可选做。
    1. 查找时效
    > 时间复杂度O(1)
    
    2. Hash算法
    - 算法公式
    <pre>
    假设 n=3
    i=0 -> h = 31 * 0 + val[0]
    i=1 -> h = 31 * (31 * 0 + val[0]) + val[1]
    i=2 -> h = 31 * (31 * (31 * 0 + val[0]) + val[1]) + val[2]
    h = 31*31*31*0 + 31*31*val[0] + 31*val[1] + val[2]
    h = 31^(n-1)*val[0] + 31^(n-2)*val[1] + val[2]</pre>
    - 优势
    > 选择质数作为乘子，会大大降低hash冲突的概率。质数的值越大，hash冲突率越低<br/>
    31参与乘法运算，可以被 JVM 优化，31 * i = (i << 5) - i<br/>
    使用 101 计算 hash code 容易导致整型溢出，导致计算精度丢失<br/>

    3. Hash冲突
    > 开放地址, 拉链法, 再Hash, 公共溢出 <p/>
    Tips: Java使用拉链法解决冲突, jdk1.8 在拉链长度>8时, 采用红黑树替代链表, 提高查询效率
    
    4. Hash扩容
    > 当线性表剩余容量 <25%时触发扩容, 扩容将容量翻倍
    
    5. 线程安全
    > HashMap 非线程安全
    
- 有效的字母异位词（亚马逊、Facebook、谷歌在半年内面试中考过）
[IsAnagram](../src/main/java/practice/map/IsAnagram.java)
- 两数之和（近半年内，亚马逊考查此题达到 216 次、字节跳动 147 次、谷歌 104 次，Facebook、苹果、微软、腾讯也在近半年内面试常考）
[TwoSum](../src/main/java/practice/map/TwoSum.java)
- N 叉树的前序遍历（亚马逊在半年内面试中考过）
[NAryTreePreOrderTraversal](../src/main/java/practice/tree/NAryTreePreOrderTraversal.java)
- HeapSort ：[自学](https://www.geeksforgeeks.org/heap-sort/)

## 中等
- 字母异位词分组（亚马逊在半年内面试中常考）
[GroupAnagrams](../src/main/java/practice/map/GroupAnagrams.java)
- 二叉树的中序遍历（亚马逊、字节跳动、微软在半年内面试中考过）
[BinaryTreeInorderTraversal](../src/main/java/practice/tree/BinaryTreeInorderTraversal.java)
- 二叉树的前序遍历（字节跳动、谷歌、腾讯在半年内面试中考过）
[BinaryTreePreorderTraversal](../src/main/java/practice/tree/BinaryTreePreorderTraversal.java)
- N 叉树的层序遍历（亚马逊在半年内面试中考过）
[BinaryTreePreorderTraversal](../src/main/java/practice/tree/BinaryTreePreorderTraversal.java)
- 丑数（字节跳动在半年内面试中考过）
[UglyNumber2](../src/main/java/practice/heap/UglyNumber2.java)
- 前 K 个高频元素（亚马逊在半年内面试中常考）
[TopKFrequent](../src/main/java/practice/heap/TopKFrequent.java)
