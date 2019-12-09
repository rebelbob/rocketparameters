package ru.aerocos.rocketparam.model.scheme;

import ru.aerocos.rocketparam.repository.MassParam;

public class TrehstupPaket {
    public static MassParam compute(MassParam param){
        double x1 = 20;
        double x2 = 20;
        double x3 = 20;
        double s1division = param.getS(0) / (param.getS(0) - 1);
        double s2division = param.getS(1) / (param.getS(1) - 1);
        double s3division = param.getS(2) / (param.getS(2) - 1);

        for (float i = 1; i < 200; i++){
            for (float j = 1; j < 200; j++) {
                for (float k = 1; k < 200; k++) {
                    float floatI = i / 10;
                    float floatJ = j / 10;
                    float floatK = k / 10;
                    if (pickUpX(floatI, floatJ, floatK, param.getVx(), s1division, s2division, s3division, param.getW(0), param.getW(1), param.getW(2), param.getA()) <= 0) {
                        if (x1 + x2 + x3 > floatI + floatJ + floatK) {
                            x1 = floatI;
                            x2 = floatJ;
                            x3 = floatK;
                        }
                    }
                }
            }
        }

        return param.setX(x1, x2, x3);
    }

    public static double pickUpX(double x1, double x2, double x3, double Vx, double s1division, double s2division, double s3division, double w1, double w2, double w3, double a){
        double p1 = 1 + s1division * x1 + s2division * x2 + s3division * x3;
        double p2 = 1 + s2division * x2 + s3division * x3;
        double p3 = 1 + s3division * x3;
        return   Vx - (w1 * w2 * (1 + a) / (w2 + a * w1)) * Math.log(p1 / (p1 - x1)) - w2 * Math.log(p2 / (p2 - x2)) - w3 * Math.log(p3 / (p3 - x3));
    }
}
