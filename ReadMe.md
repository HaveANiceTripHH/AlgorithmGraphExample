# 《算法图解》中涉及的算法的总结及java实现

## 二分查找：
*算法目的：* 查找在有序数组中某给定值的位置  
*算法原理：* 当数组中元素有序排列时，通过比较数组中间位置的值和**给定值**的大小，
可以确定给定值在由中央位置分割而成的两个数组的哪一个部分，依次切割就能找到给定值的位置；
*算法复杂度：* O（logn）  
*算法难点：*
  需要确定循环的边界条件。
*算法实现：*
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
*算法目的：* 将数组正确排序
*算法原理：* 依次选择最小（大）的值放到对应的位置
*算法复杂度：* O（n^2）  
*算法难点：*：无
*算法实现：*
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

## 快速排序
*算法目的：* 将数组正确排序
*算法原理：* 准一个基准值(一般选择数组中第一个值),将数组分成两部分,前一部分比基准值小,后一部分比基准值大.
然后将分割后的两个数组继续按这个方式分割,一直到子数组只剩下一个值,那么所有子数组都是排序好的,最后汇总起来也是排序好的数组
*算法复杂度：* O（n^2）  
*算法难点：*：无
*算法实现：*
```$xslt
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


  
 
