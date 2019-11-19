package ru.aerocos.rocketparam.model;

import ru.aerocos.rocketparam.repository.Parameters;

public class ParallBezPerel {

    public static Parameters compute(Parameters rep){
        return pickX(rep);
    }

    private static Parameters pickZ(Parameters rep){
        while ((rep.getVx() - rep.getW(0) * rep.getW(1) * (1 + rep.getA())
                / (rep.getW(1) + rep.getA() * rep.getW(0))
                * Math.log(rep.getZ(0)) - rep.getW(1) * Math.log(rep.getZ(1))) > 0){

            System.out.println(rep.getVx() - rep.getW(0) * rep.getW(1) * (1 + rep.getA())
                    / (rep.getW(1) + rep.getA() * rep.getW(0))
                    * Math.log(rep.getZ(0)) - rep.getW(1) * Math.log(rep.getZ(1)));
                rep.incrementZ();
        }
        return rep;
    }

    private static Parameters pickX(Parameters rep){
        rep = pickZ(rep);

        double x2 = (rep.getZ(0) - 1 - rep.getA()*rep.getW(0)/rep.getW(1)*(rep.getZ(0) - 1)
                / (rep.getS(0)/(rep.getS(0) - 1) - rep.getZ(0)*rep.getS(0)/(rep.getS(0) - 1) - 1 - rep.getA() * rep.getW(0)/rep.getW(1)))
                / (rep.getA() * rep.getW(0)/rep.getW(1)*(-rep.getZ(0)*rep.getS(1)/(rep.getS(1) - 1)) - rep.getS(1)/(rep.getS(1) - 1)
                / (rep.getS(0)/(rep.getS(0) - 0) - rep.getA()*rep.getS(0)/(rep.getS(0) - 1) - 1 + rep.getA()*rep.getW(0)/rep.getW(1)) -
                rep.getZ(0)*rep.getS(1)/(rep.getS(1) - 1) + rep.getZ(0));

        double x1 = (rep.getZ(0) - rep.getZ(0)*rep.getS(1)/(rep.getS(1) - 1)*x2 - rep.getS(1)/(rep.getS(1) - 1)*x2 - 1)
                / (rep.getS(0)/(rep.getS(0) - 1) - rep.getZ(0)*rep.getS(0)/(rep.getS(0) - 1) - 1 + rep.getA()*rep.getW(0)/rep.getW(1));

        System.out.println(rep.getZ(0) + " " + rep.getZ(1));
        System.out.println(x1 + " " + x2);
        rep.setX(x1, x2);
        return rep;
    }
}
