import ru.aerocos.rocketparam.model.graphs.Stage;

public class TestStage {

    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.compute(2150, 116, 19, 2.6, 2786, 75000, 1);
        stage.compute(371.5, 105, 19, 2.2, 2943, 12300, 2);
    }
}
