import ru.aerocos.rocketparam.repository.MassParam;

public class TestZ {


    public static void main(String[] args) {
        MassParam rep = new MassParam();
        rep.setVx(9529).
                setS(10.9, 8.7).
                setW(3043, 4600).
                setMp(4).
                compute("posled");

        System.out.println(rep.getX(0)  + " " + rep.getX(1));
    }
}
