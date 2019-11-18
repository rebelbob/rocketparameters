package ru.aerocos.rocketparam.model;

import ru.aerocos.rocketparam.repository.Parameters;

public class Posledovatelnoe {

    public static double compute(Parameters rep){

        double m = Math.log((1 + rep.getS(0)/(rep.getS(0) - 1) * rep.getX(0)) /
                (1 + rep.getS(0)/(rep.getS(0) - 1) * rep.getX(0) - rep.getX(0)));

        double n = Math.log((1 + rep.getS(0)/(rep.getS(0) - 1) * rep.getX(0) + rep.getS(1)/(rep.getS(1) - 1) * rep.getX(1)) /
                (1 + rep.getS(0)/(rep.getS(0) - 1) * rep.getX(0) - rep.getX(1) + rep.getS(1)/(rep.getS(1) - 1) * rep.getX(1) - rep.getX(1)));
        return rep.getVx() - rep.getW(0) * m -
                rep.getW(1) * n;
    }
}
