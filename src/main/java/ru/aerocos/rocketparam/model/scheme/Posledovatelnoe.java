package ru.aerocos.rocketparam.model.scheme;

import ru.aerocos.rocketparam.repository.Parameters;

public class Posledovatelnoe {

    public static Parameters compute(Parameters param){
        double x1 = 20;
        double x2 = 20;
        double s1division = param.getS(0) / (param.getS(0) - 1);
        double s2division = param.getS(1) / (param.getS(1) - 1);



        for (float i = 1; i < 200; i++){
            for (float j = 1; j < 200; j++){
                float floatI = i / 10;
                float floatJ = j / 10;
                if (pickUpX(floatI, floatJ, param.getVx(), s1division, s2division, param.getW(0), param.getW(1)) <= 0) {
                    if (x1 + x2 > (i + j) / 10) {
                        x1 = floatI;
                        x2 = floatJ;
                    }
                }
            }

        }

        return param.setX(x1, x2);
    }

    public static double pickUpX(double x1, double x2, double Vx, double s1division, double s2division, double w1, double w2){
        double p1 = 1 + s1division * x1 + s2division * x2;
        double p2 = 1 + s2division * x2;
        return   Vx - w1 * Math.log(p1 / (p1 - x1)) - w2 * Math.log(p2 / (p2 - x2));
    }
}
