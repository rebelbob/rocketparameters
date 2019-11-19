import ru.aerocos.rocketparam.model.Mass;
import ru.aerocos.rocketparam.model.Posledovatelnoe;
import ru.aerocos.rocketparam.repository.Parameters;

public class TestZ {


    public static void main(String[] args) {
        Parameters rep = new Parameters();
        rep.setVx(9529).
                setS(10.9, 8.6).
                setW(3043, 4600).
                setZ(1.1, 1.1).
                setMp(12).
                setA(0.5).
                compute("parallbezpereliva");



        System.out.println(Mass.compute(rep).massToStr());
    }
}
