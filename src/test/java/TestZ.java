import ru.aerocos.rocketparam.model.Mass;
import ru.aerocos.rocketparam.model.Posledovatelnoe;
import ru.aerocos.rocketparam.repository.Parameters;

public class TestZ {


    public static void main(String[] args) {
        Parameters rep = new Parameters();
        rep.setVx(9529).
                setS(10.9, 8.6).
                setW(3043, 4600).
                setMp(24).
                compute("posled");

        System.out.println(Mass.compute(rep).massToStr2());
        System.out.println(rep.getX(0)  + " " + rep.getX(1));
    }
}
