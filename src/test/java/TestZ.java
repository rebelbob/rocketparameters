import ru.aerocos.rocketparam.model.Posledovatelnoe;

public class TestZ {


    public static void main(String[] args) {
        Posledovatelnoe pos = new Posledovatelnoe(9529, 3043, 4600, 10.9, 8.6);
        pos.pickZ12();
        System.out.println(pos.getZ1() + " " + pos.getZ2());
        pos.pickX12();
        System.out.println(pos.getX1() + " " + pos.getX2());
        System.out.println(pos.compute());
    }
}
