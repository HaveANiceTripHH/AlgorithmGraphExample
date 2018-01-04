/**
 *  二分查找,
 *  查找在有序数组中某给定值的位置,
 *  算法复杂度为O(logn);
 */
@SuppressWarnings("unused")
public class BinarySearch implements AlgorithmInGraph {
    public void showAlgorithm() {
        int []  array = new int[100];
        for(int i=0;i<100;i++ ){
            array[i] = i;
        }

        printSearchResult(array,45);
        printSearchResult(array,105);
        printSearchResult(array,0);
        printSearchResult(array,99);

    }

    /**
     * @param sortedArray  已经排序好的数组
     * @param value         需要查询的值value
     * @return               返回值在有序数组中的索引,如果数组中不存在这个值,则返回-1;
     */
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

    private void printSearchResult(int [] array,int value){
        System.out.println("在0-99的有序数组中," + value+"的位置是: \t" + doBinarySearch(array,value));
    }
}
