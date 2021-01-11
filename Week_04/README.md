# 学习笔记
## 例题
- 零钱兑换
  [CoinChange](../src/main/java/practice/greedy/CoinChange.java)
- 柠檬水找零（亚马逊在半年内面试中考过）
  [LemonadeChange](../src/main/java/practice/greedy/LemonadeChange.java)
- 买卖股票的最佳时机 II （亚马逊、字节跳动、微软在半年内面试中考过）
  [StockProblem2](../src/main/java/practice/greedy/StockProblem2.java)
- 分发饼干（亚马逊在半年内面试中考过）
  [FindContentChildren](../src/main/java/practice/greedy/FindContentChildren.java)
- 模拟行走机器人
  [WalkingRobot](../src/main/java/practice/greedy/WalkingRobot.java)
- 二分查找  
  使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方<br/>
  说明：同学们可以将自己的思路、代码写在第 4 周的学习总结中<br/>
  原来的二分逻辑由于数组是递增的，只需要判定mid就可以确定二分段(规约);<br/>
  该题有点巧妙，虽然场景上数组不是严格递增的，但却是部分递增, 依然可以二分，只是判定的逻辑多一层: 
  - 1) 判定哪边是单调的 (left < right 肯定单调)
  - 2) 判定target是否在单调那一边 (在单调段, 设边界为left, right; 必有 left < target < right)
  
  这两层逻辑我们通过边界: left, mid, right这三个值可以判定出来，从而可以二分
  
  
## 中等
- 单词接龙（亚马逊在半年内面试常考）
  [* LadderLength](../src/main/java/practice/graph/LadderLength.java)
- 岛屿数量（近半年内，亚马逊在面试中考查此题达到 350 次）
  [NumberOfIslands](../src/main/java/practice/graph/NumberOfIslands.java)
- 扫雷游戏（亚马逊、Facebook 在半年内面试中考过）
- 跳跃游戏 （亚马逊、华为、Facebook 在半年内面试中考过）
  [* JumpGame](../src/main/java/practice/greedy/JumpGame.java)
- 搜索旋转排序数组（Facebook、字节跳动、亚马逊在半年内面试常考）
  [SearchInRotatedSortedArray](../src/main/java/practice/search/SearchInRotatedSortedArray.java)
- 搜索二维矩阵（亚马逊、微软、Facebook 在半年内面试中考过）
  [SearchMatrix](../src/main/java/practice/search/SearchMatrix.java)
- 寻找旋转排序数组中的最小值（亚马逊、微软、字节跳动在半年内面试中考过）
  [SearchMinInRotatedSortedArray](../src/main/java/practice/search/SearchMinInRotatedSortedArray.java)

## 困难
- 单词接龙 II （微软、亚马逊、Facebook 在半年内面试中考过）
  [* LadderLength2](../src/main/java/practice/graph/LadderLength2.java)
- 跳跃游戏 II （亚马逊、华为、字节跳动在半年内面试中考过）
  [* JumpGame2](../src/main/java/practice/greedy/JumpGame2.java)

## 训练场练习（选做）
学有余力的同学，可以挑战以下【训练场】模拟面试真题：
- 追赶朋友
- 分数统计
- 包裹容量问题
- IP 还原问题
- 任务处理问题
- 饥饿的老鼠