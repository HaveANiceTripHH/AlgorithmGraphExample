import org.junit.Test;

import static org.junit.Assert.*;

public class GraphSearchUtilTest {

    @Test
    public void generateGraph() {
        int [][] graph = GraphSearchUtil.generateGraph(5);
        GraphSearchUtil.printGraph(graph);
    }
}