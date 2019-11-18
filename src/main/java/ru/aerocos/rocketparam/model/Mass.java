package ru.aerocos.rocketparam.model;

import ru.aerocos.rocketparam.repository.Parameters;

import java.util.ArrayList;

public class Mass {
    private static double computeMt(double x, double mp){
        return mp * x;
    }

    private static double computeMb(double mt, double s){
        return s * mt / (s - 1);
    }

    private static double computeMk(double mb, double mt){
        return mb - mt;
    }

    private static double computeM0(double mp, ArrayList<Double> mb){
        double m0 = mp;
        for (double mbi : mb){
            m0 += mbi;
        }
        return m0;
    }

    public static Parameters compute(Parameters rep){
        rep.setMt(computeMt(rep.getX(0), rep.getMp()), computeMt(rep.getX(1), rep.getMp()));

        rep.setMb(computeMb(rep.getMt(0), rep.getS(0)), computeMb(rep.getMt(1), rep.getS(1)));

        rep.setMk(computeMk(rep.getMb(0), rep.getMt(0)), computeMk(rep.getMb(1), rep.getMt(1)));

        rep.setM0(computeM0(rep.getMp(), rep.getMb()));

        return rep;
    }
}
