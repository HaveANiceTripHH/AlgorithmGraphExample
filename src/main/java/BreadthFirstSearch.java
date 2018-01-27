import SupportData.GraphSearchUtil;

import java.util.*;

/**
 * 广度优先搜索;
 * 图的搜索算法,对每个节点:搜索其子节点(相连节点),如果该节点被搜索过,那么就跳过,否则加入到搜索节点队列;当前节点完成后,从队列中选择
 * 第一个节点继续搜索.直到队列中不再有节点.
 *
 */
@SuppressWarnings("unused")
public class BreadthFirstSearch implements AlgorithmInGraph{

    public void showAlgorithm() {
        int [][] graph = GraphSearchUtil.generateGraph(5);
        System.out.println("当前生成的图为:");
        GraphSearchUtil.printGraph(graph);
        List<Integer> orders = search(graph);
        System.out.println("广度优先搜索的节点依次为(从0节点开始搜索):");
        System.out.println(Arrays.toString(orders.toArray()));
    }

    public List<Integer> search(int [][] graph){
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
    }
}
