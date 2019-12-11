import ru.aerocos.rocketparam.model.graphs.Stage;

public class TestStage {

    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.compute(2150, 116, 19, 2.6, 2786, 75000, 1, 22);
        stage.compute(371.5, 105, 19, 2.2, 2943, 12300, 2, 10);
        stage.compute(100, 90, 19, 1.4, 2953, 2900, 3, 0);
    }
}
