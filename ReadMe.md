# 《算法图解》中涉及的算法的总结及java实现

## 二分查找：  
**算法目的：** 查找在有序数组中某给定值的位置    
**算法原理：** 当数组中元素有序排列时，通过比较数组中间位置的值和****给定值****的大小，  
可以确定给定值在由中央位置分割而成的两个数组的哪一个部分，依次切割就能找到给定值的位置；  
**算法复杂度：** O（logn）    
**算法难点：**  
  需要确定循环的边界条件。  
**算法实现：**  
```$xslt
 private int doBinarySearch(int [] sortedArray,int value){
        int right = sortedArray.length - 1;
        int left = 0;
        int middle;
        //这里=号容易被忽略
        while(right>= left){
            middle = (left+right)/2;
            if(sortedArray[middle] == value){
                return middle;
            }
            else if(sortedArray[middle] < value){
                left = middle+1;
            }
            else{
                right = middle-1;
            }
        }
        return -1;
    }
```

## 选择排序
**算法目的：** 将数组正确排序  
**算法原理：** 依次选择最小（大）的值放到对应的位置  
**算法复杂度：** O（n^2）  
**算法难点：**：无  
**算法实现：**  
```$xslt
    private void sort(int [] array){
            for(int i = 0;i<array.length;i++){
                int min = array[i];
                int index = i;
                for(int j = i;j<array.length;j++){
                    if(min > array[j]){
                        min = array[j];
                        index = j;
                    }
                }
                if(i != index){
                    int temp = array[i];
                    array[i] = array[index];
                    array[index] = temp;
                }
            }
        }
```

## 快速排序--分治
**算法目的：** 将数组正确排序  
**算法原理：** 准一个基准值(一般选择数组中第一个值),将数组分成两部分,前一部分比基准值小,后一部分比基准值大.
然后将分割后的两个数组继续按这个方式分割,一直到子数组只剩下一个值,那么所有子数组都是排序好的,最后汇总起来也是排序好的数组  
**算法复杂度：** O（n^2）  
**算法难点：**：无  
**算法实现：**  

```
private void quickSort(int [] array,int start,int end){
        if(start >= end){
            return;
        }
        int left = start;
        int right = end;
        int value = array[start];
        while(left < right){
            while(array[right] > value && left < right)
                right--;
            array[left] = array[right];
            while(array[left] < value && left < right)
                left++;
            array[right] = array[left];
        }
        array[left] = value;
        quickSort(array,left+1,end);
        quickSort(array,start,left-1);

    }
```

## 广度优先搜索--图算法 最短路径
**算法目的：** 遍历图中节点的一种方法,可以找到两节点的最短路径  
**算法原理：** 图的搜索算法,对每个节点:搜索其子节点(相连节点),如果该节点被搜索过,那么就跳过,否则加入到搜索节点队列;当前节点完成后,从队列中选择
第一个节点继续搜索.直到队列中不再有节点.  
**算法复杂度：**   
**算法难点：**：无  
**算法实现：** 
```
        int point_num = graph[0].length;

        List<Integer> result = new ArrayList<Integer>();

        Queue<Integer> queue = new LinkedList<Integer>();
        List<Integer> searchedList = new ArrayList<Integer>();    //已经查找过的点
        queue.offer(0);
        searchedList.add(0);

        int index = 0;

        while(!queue.isEmpty()){
            Integer currentPoint = queue.poll();
            result.add(currentPoint);
            for(int i = 0;i<graph[currentPoint].length;i++){
                if(!searchedList.contains(i) && graph[currentPoint][i] == 1){
                    queue.offer(i);
                    searchedList.add(i);
                }
            }

        }
        return result;
```

## 迪杰斯特拉算法
**算法目的：** 在有向无环的带权值的图中,找出权值最短的路径  
**算法原理：** 因为是有向图并且无环,作为基准的点,当时的权值都是起点到这些节点最小的时候.    
**算法难点：**：无  
**算法实现：** 
```
        while (continueSeach) {
                    continueSeach = false;
                    for (int i = 0; i < length; i++) {
                        if (graph[currentNode][i] < 0) {
                            continue;
                        }
                        if (graph[currentNode][i] + minimumValue[currentNode] < minimumValue[i]) {
                            minimumValue[i] = graph[currentNode][i] + minimumValue[currentNode];
                            minmimumNode[i] = currentNode;
                        }
                    }
                    //已经检查过的节点
                    examinedNode.add(currentNode);
        
                    //从当前节点中选择一个最小的节点值
                    int minmum = Integer.MAX_VALUE;
                    for (int i = 0; i < length; i++) {
                        if (!examinedNode.contains(i) && minimumValue[i] < minmum) {
                            currentNode = i;
                            minmum = minimumValue[i];
                            continueSeach = true;
                        }
                    }
                }
```

## 背包问题--贪心算法
**算法目的：** 对于一个固定重量的背包,装入一组重量和大小固定的物品,物品可以只放入部分,可以求出如何放置得出的值最大  
**算法原理：** 物品可拆分,只要依次装入单位价值最大的物品即可.贪心算法的原理是每次的操作都是最优的,只有一个操作.    
**算法实现：** 
```
        while(i<weighs.length){
                    if(currentWeight + weighs[i] < maxWeight){
                        currentWeight += weighs[i];
                        maxValue += value[i];
        
                    }else {
                        maxValue += value[i] ** (maxWeight - currentWeight) / weighs[i];
                        break;
                    }
                    i++;
                }
```

## 01背包--动态规划
**算法目的：** 对于一个固定重量的背包,装入一组重量和大小固定的物品,物品只能完整放入或者不放入,可以求出如何放置得出的值最大    
**算法原理：** 物品不可拆分,所以不能使用贪心算法,因为如果当次放入单位价值最大的物品可能导致后面整体价值最大的物品无法房屋.  
如果较大问题的最优解包含了较小问题的最优解,那么就可以使用动态规划来做.  
动态规划问题的核心是当前问题的最优解包含在小规模的最优解中，或者说大规模问题可以由小规模问题推导出来，也就是状态转移； 
具体到0，1背包；状态转移为：对于第i件物品，在背包容量限定为weight的情况下，其最大价值在放这件物品与不放这件物品之间选择一个： 
a：如果放的话，那么价值为当前背包容量减去该物品重量后能放置物品的最高价值与当前物品的价值累加；就是数组中a[i-1][weight-weighs[i]]  
b: 如果不放的话，那么价值就应该是当前背包容量下不考虑这个物品，也就是上个物品在该背包容量的最大价值：也就是数组中a[i-1][weight]  
a与b的最大值就是当前规模的最优值    
**算法实现：** 
```
        for(int i=0;i<weighs.length;i++){
                    for(int j=0;j<maxWeight;j++){
                        //初始化
                        if(i==0){
                            if(j >= weighs[0]){
                                currentState[i][j] = value[0];
                            }
                        }else if(j >= weighs[i] ){
                            if(currentState[i-1][j-weighs[i]]+value[i] > currentState[i-1][j]){
                                currentState[i][j] = currentState[i-1][j-weighs[i]]+value[i];
                            }else{
                                currentState[i][j] = currentState[i-1][j];
                            }
                        }
                        else{
                            currentState[i][j] = currentState[i-1][j];
                        }
                        if(maxResult < currentState[i][j]){
                            maxResult = currentState[i][j];
                        }
                    }
                }
```
 
