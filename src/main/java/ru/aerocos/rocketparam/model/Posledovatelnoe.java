package ru.aerocos.rocketparam.model;

import ru.aerocos.rocketparam.repository.Parameters;

public class Posledovatelnoe {

    public static Parameters compute(Parameters param){
        double x1 = 20;
        double x2 = 20;
        double stup1S = param.getS(0) / (param.getS(0) - 1);
        double stup2S = param.getS(1) / (param.getS(1) - 1);



        for (double i = 1; i < 20; i += 0.1){
            for (double j = 1; j < 20; j += 0.1){
                if (pickUpX(i, j, param.getVx(), stup1S, stup2S, param.getW(0), param.getW(1)) <= 0){
                    if (x1 > i && x2 > j){
                        x1 = i;
                        x2 = j;
                    } else if (x1 > i && x2 < j){
                        if ((x2 - j) < (x1 - i)){
                            x1 = i;
                            x2 = j;
                        }
                    } else if (x1 < i && x2 > j){
                        if ((x2 - j) > (x1 - i)){
                            x1 = i;
                            x2 = j;
                        }
                    }
                }
            }
        }

        return param.setX(x1, x2);
    }

    public static double pickUpX(double x1, double x2, double Vx, double stup1S, double stup2S, double w1, double w2){
        double stup1 = 1 + stup1S * x1;
        double stup2 = 1 + stup1S * x1 + stup2S * x2;
        double ss1 = stup1 / (stup1 - x1);
        double ss2 = stup2 / (stup2 - x2);
        double res = Vx - w1 * Math.log(ss1) - w2 * Math.log(ss2);
        return res;
    }
}
