package ru.aerocos.rocketparam.repository;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Parameters {

    private double mp;
    private double m0;
    private double Vx;
    private ArrayList<Double> s;
    private ArrayList<Double> z;
    private ArrayList<Double> x;
    private ArrayList<Double> w;
    private ArrayList<Double> mt;
    private ArrayList<Double> mb;
    private ArrayList<Double> mk;

    public Parameters setVx(double Vx){
        this.Vx = Vx;
        return this;
    }

    public Parameters setM0(double m0){
        this.m0 = m0;
        return this;
    }

    public Parameters setMp(double mp){
        this.mp = mp;
        return this;
    }

    public Parameters setS(double... s){
        this.s = new ArrayList<>();
        for (double si : s){
            this.s.add(si);
        }

        return this;
    }

    public Parameters setZ(double... z){
        this.z = new ArrayList<>();
        for (double zi : z){
            this.z.add(zi);
        }

        return this;
    }

    public Parameters setX(double... x){
        this.x = new ArrayList<>();
        for (double xi : x){
            this.x.add(xi);
        }

        return this;
    }

    public Parameters setW(double... w){
        this.w = new ArrayList<>();
        for (double wi : w){
            this.w.add(wi);
        }

        return this;
    }

    public Parameters setMt(double... mt){
        this.mt = new ArrayList<>();
        for (double mti : mt){
            this.mt.add(mti);
        }

        return this;
    }

    public Parameters setMb(double... mb){
        this.mb = new ArrayList<>();
        for (double mbi : mb){
            this.mb.add(mbi);
        }

        return this;
    }

    public Parameters setMk(double... mk){
        this.mk = new ArrayList<>();
        for (double mki : mk){
            this.mk.add(mki);
        }

        return this;
    }

    private void pickZ(){
        while (Vx - w.get(0) * Math.log(z.get(0)) - w.get(1) * Math.log(z.get(1)) > 0){
            for (int i = 0; i < z.size(); i++) {
                z.set(i, z.get(i) + 0.1);
            }
        }
    }

    private void pickX(){
        x = new ArrayList<>();
        x.add((z.get(0) - 1) / ((s.get(0)/(s.get(0) -1) - z.get(0) * s.get(0)/(s.get(0) - 1) + z.get(0))));
        x.add ((z.get(1) + s.get(0)/(s.get(0) - 1) * z.get(0) * (z.get(1) - 1) - 1) / (s.get(1)/(s.get(1) - 1) * (1 - z.get(1)) + 2 * z.get(1)));
    }

    public void computeZX(){
        pickZ();
        pickX();
    }

    public double getZ(int i) {
        return z.get(i);
    }

    public double getX(int i) {
        return x.get(i);
    }

    public double getS(int i) {
        return s.get(i);
    }

    public double getVx() {
        return Vx;
    }

    public double getW(int i) {
        return w.get(i);
    }

    public double getMp() {
        return mp;
    }

    public double getMt(int i){
        return mt.get(i);
    }

    public double getMb(int i){
        return mb.get(i);
    }

    public ArrayList<Double> getMb(){
        return mb;
    }

    public ArrayList<Double> getMk(){
        return mk;
    }

    public ArrayList<Double> getMt(){
        return mt;
    }

    public double getMk(int i){
        return mk.get(i);
    }

    public double getM0() {
        return m0;
    }

    public String massToStr(){
        return new DecimalFormat("#0.00").format(mb.get(0)) + "," +
                new DecimalFormat("#0.00").format(mb.get(1)) + "," +
                new DecimalFormat("#0.00").format(mt.get(0)) + "," +
                new DecimalFormat("#0.00").format(mt.get(1)) + "," +
                new DecimalFormat("#0.00").format(mk.get(0)) + "," +
                new DecimalFormat("#0.00").format(mk.get(1)) + "," +
                new DecimalFormat("#0.00").format(m0);
    }
}
