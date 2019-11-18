import ru.aerocos.rocketparam.model.Mass;
import ru.aerocos.rocketparam.model.Posledovatelnoe;
import ru.aerocos.rocketparam.repository.Parameters;

public class TestZ {


    public static void main(String[] args) {
        Parameters rep = new Parameters();
        rep.setVx(9529).setS(10.9, 8.6).setW(3043, 4600).setZ(1.1, 1.1).setMp(4000).computeZX();
        if (Posledovatelnoe.compute(rep) < 0){
            System.out.println("it's ok");
        }

        System.out.println(rep.getX(0) + " " + rep.getX(1));
        rep = Mass.compute(rep);

        System.out.println(rep.getM0() + " " + rep.getMb() + " " + rep.getMk() + " " + rep.getMt());
    }
}
