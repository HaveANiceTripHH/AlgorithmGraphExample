import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Integer> nodes = doDijkstra(graph,0,4);
        System.out.println(Arrays.toString(nodes.toArray()));
    }

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
