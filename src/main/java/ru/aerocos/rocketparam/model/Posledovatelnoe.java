package ru.aerocos.rocketparam.model;

import ru.aerocos.rocketparam.repository.Parameters;

public class Posledovatelnoe {

    public static Parameters compute(Parameters rep){
        return pickX(rep);
    }

    private static Parameters pickZ(Parameters rep){
        while (rep.getVx() - rep.getW(0) * Math.log(rep.getZ(0)) - rep.getW(1) * Math.log(rep.getZ(1)) > 0){
                rep.incrementZ();
        }
        return rep;
    }

    private static Parameters pickX(Parameters rep){
        rep = pickZ(rep);

        rep.setX((rep.getZ(0) - 1) / ((rep.getS(0)/(rep.getS(0) -1) - rep.getZ(0) * rep.getS(0)/(rep.getS(0) - 1) + rep.getZ(0))),
                ((rep.getZ(0) + rep.getS(0)/(rep.getS(0) - 1) * rep.getZ(0) * (rep.getZ(0) - 1) - 1) / (rep.getS(1)/(rep.getS(1) - 1) * (1 - rep.getZ(0)) + 2 * rep.getZ(0))));
        return rep;
    }
}
