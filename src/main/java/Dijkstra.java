import SupportData.GraphSearchUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 迪杰斯特拉算法
 * 对于带权值的有向无环图,迪杰斯特拉算法能够计算出从给定的起点到终点最短的路径
 * 做法如下:
 * 维护一个包含从起点到所有节点的权值的数据组;
 * 依次从这个数据组中取出权值最小的节点作为基准,遍历这个基准节点所有相连通的节点,比较起点通过这个节点到另外的节点(起点到这个节点的权值+这个节点到其他节点的权值)和当前数据组中起点到另外节点的值的大小;
 * 如果通过这个节点到另外节点的权值更小的话,那么就更新数据组中的值.
 * 依次更新,直到终点是数据组中未做基准点而且权值最小的点.
 * 原理:因为是有向图并且无环,作为基准的点,当时的权值都是起点到这些节点最小的时候.
 * 书中解释:找出途中最便宜的节点,并且确保没有到该节点的更便宜的路径.
 *
 *
 */
public class Dijkstra implements AlgorithmInGraph {

    public void showAlgorithm() {

        int [][] graph = new int [5][5];
        //不可达
        for(int i = 0;i<5;i++){
            for(int j = 0;j<5;j++){
                graph[i][j] = i == j? 0:-1;
            }
        }

        graph[0][1] = 9;
        graph[0][2] = 2;
        graph[0][3] = 3;
        graph[1][3] = 4;
        graph[2][4] = 4;
        graph[3][2] = 2;
        graph[3][4] = 1;

        GraphSearchUtil.printGraph(graph);
        List<Integer> nodes = doDijkstra(graph,1,0);
        if(nodes != null) {
            System.out.println(Arrays.toString(nodes.toArray()));
        }else{
            System.out.println("当前条件起点到终点不可达");
        }

    }


    /**
     * 传入一个图的数据的二维数组,图需要是有向图,并且不能有环的存在
     * 传入起始节点和终结节点
     * 返回节点的list,就是从起点到终点算出来权值最短的路径的节点
     * @param graph
     * @param start
     * @param end
     * @return
     */
    private List<Integer> doDijkstra(int [][] graph,int start,int end) {

        int length = graph.length;
        int[] minimumValue = new int[length];

        //表示当前不可达
        for (int i = 0; i < length; i++) {
            minimumValue[i] = Integer.MAX_VALUE;
        }


        int[] minmimumNode = new int[length];
        for(int i=0;i<length;i++){
            minmimumNode[i] = -1;
        }

        List<Integer> examinedNode = new ArrayList<Integer>();

        //存放当前最小值的节点
        minimumValue[start] = 0;
        minmimumNode[start] = start;



        int currentNode = start;

        int index = 0;
        boolean continueSeach = true;
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

        //不可达
        if(minmimumNode[end] == -1){
            return null;
        }else{

            System.out.println(Arrays.toString(minmimumNode));
            List<Integer> reversResult = new ArrayList<Integer>();
            int node = end;
            while(node != start){
                reversResult.add(minmimumNode[node]);
                node = minmimumNode[node];
            }

            List<Integer> result = new ArrayList<Integer>();
            for(int i = reversResult.size() - 1;i>=0;i--){
                result.add(reversResult.get(i));
            }
            return  result;
        }
    }
}
