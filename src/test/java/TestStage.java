import ru.aerocos.rocketparam.model.graphs.Stage;
import ru.aerocos.rocketparam.model.graphs.Stage1;

public class TestStage {

    public static void main(String[] args) {
        Stage1 stage1 = new Stage1();
        stage1.compute(2150, 100, 19, 2.6, 2786, 75000 + 12300 + 2900, 22);
        stage1.compute(371.5, 90, 19, 2.2, 2943, 12300 + 2900, 10);
        stage1.compute(100, 80, 19, 1.4, 2953, 2900, 0);

//        Stage stage = new Stage();
//        stage.compute(2150, 116, 19, 2.6, 2786, 75000, 1, 22);
//        stage.compute(371.5, 105, 19, 2.2, 2943, 12300, 2, 10);
//        stage.compute(100, 90, 19, 1.4, 2953, 2900, 3, 0);
    }
}
