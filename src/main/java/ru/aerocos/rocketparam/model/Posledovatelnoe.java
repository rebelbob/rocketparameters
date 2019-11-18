package ru.aerocos.rocketparam.model;

public class Posledovatelnoe {

    private double s1, s2;
    private double Vx;
    private double z1, z2;
    private double x1, x2;
    private double w1, w2;

    public Posledovatelnoe(double Vx, double s1, double s2, double w1, double w2){
        this.w1 = w1;
        this.w2 = w2;
        this.Vx = Vx;
        this.s1 = s1;
        this.s2 = s2;
        z1 = 1.1; z2 = 1.1;
    }

    private void pickZ12(){
        while (Vx - w1 * Math.log(z1) - w2 * Math.log(z2) > 0){
            z1 += 0.1;
            z2 += 0.1;
        }
    }

    private void pickX12(){
        x1 = (z1 - 1) / ((s1/(s1 -1) - z1 * s1/(s1 - 1) + z1));
        x2 = (z2 + s1/(s1 - 1) * z1 * (z2 - 1) - 1) / (s2/(s2 - 1) * (1 - z2) + 2 * z2);
    }

    public double compute(){
        pickZ12();
        pickX12();
        double m = Math.log((1 + s1/(s1 - 1) * x1) / (1 + s1/(s1 - 1) * x1 - x1));
        double n = Math.log((1 + s1/(s1 - 1) * x1 + s2/(s2 - 1) * x2) / (1 + s1/(s1 - 1) * x1 - x2 + s2/(s2 - 1) * x2 - x2));
        System.out.println(m + " " + n);
        return Vx - w1 * m -
                w2 * n;
    }


    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getZ1() {
        return z1;
    }

    public double getZ2() {
        return z2;
    }
}
