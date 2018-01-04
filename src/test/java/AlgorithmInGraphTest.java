import org.junit.Test;

import static org.junit.Assert.*;

public class AlgorithmInGraphTest {

    @Test
    public void showAlgorithm() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        AlgorithmInGraph algorithm = (AlgorithmInGraph) Class.forName("ChooseSort").newInstance();
        algorithm.showAlgorithm();


    }
}