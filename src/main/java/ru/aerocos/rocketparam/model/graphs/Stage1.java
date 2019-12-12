package ru.aerocos.rocketparam.model.graphs;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Stage1 {

    private double t = 0; // начальное время
    private double x = 0; // начальная координата x
    private double y = 0; //начальная координата y
    private double Vx = 0; //начальная скорость x
    private double Vy = 0; //начальная скорость y
    private double V = 0; //начальная скорость
    private double tetta; //начальный угол наклона траектории
    private double tettaK; // конечный угол наклона траектории первой ступени
    private double SMid; //площадь миделя ступени
    private double skorNapor = 0; // начальный скоростной напор
    private double dt = 1; //шаг интегрирования
    private double g = 9.8; //ускорение свободного падения
    private double T0 = 288.15; //стандартная температура на уровне моря
    private double L = -0.0065; //среднее значение вертикальной компоненты градиента температур
    private double p0 = 101325; //стандартное атмосферное давление на уровне моря
    private double molM = 0.0289644; // молярная масса сухого воздуха
    private double R = 8.31447; //универсальная газовая постоянная
    private double betta; //угол полураствора конуса
    private double Cx; //коэффициент лобового сопротивления
    private double Cy;
    private double plotnVozd = 1.225; //начальная плотность воздуха
    private double P; // сила тяги ступени
    private double tk; // время работы ступени
    private double D; // диаметр ступени
    private double ms; //секундный массовый расход ступени
    private double m0; //начальная масса ступени
    private double tPrev; //время полета предыдущей ступени(если есть)
    private double tettaPrev; //угол наклона траектории предыдущей ступени (если есть)
    private double fi; //угол тангажа
    private double Rz = 6371400;
    private double V1 = 7910;

    private double m; //масса ракеты в данный момент времени
    private double Xa;
    private double Ya;
    private double dVx;
    private double dVy;
    private double dx;
    private double dy;
    private double T;
    private double p;
    private double Vkr;
    private double a;
    private double tr;
    private double tStage = 0;

    public void setP(double p) {
        P = p * 1000;
    }

    public void setTk(double tk) {
        this.tk = tk;
    }

    public void setBetta(double betta) {
        this.betta = betta * Math.PI / 180;
    }

    public void setSMid(double D){
        SMid = Math.PI * D * D / 4;
    }

    public void setMs(double w){
        ms = P / w;
    }

    public void setM(double m0){
        this.m0 = m0;
    }

    List<Integer> speed = new ArrayList<>();
    List<Integer> hight = new ArrayList<>();
    List<Integer> alphaList = new ArrayList<>();
    List<Integer> tettaList = new ArrayList<>();
    List<Integer> fiList = new ArrayList<>();
    List<Integer> mass = new ArrayList<>();
    List<Integer> time = new ArrayList<>();

    public void setParam(double P, double tk, double betta, double D, double w, double m){
        setP(P);
        setTk(tk);
        setBetta(betta);
        setSMid(D);
        setMs(w);
        setM(m);
        Cx = 2 * this.betta * this.betta;
    }

    private void getTetta(){
        if (V < 50) {
            fi = 90 * Math.PI / 180;
            tetta = 90 * Math.PI / 180;
            tr = t;
        }else {
            g = 1;
            fi = tettaK + (Math.PI / 2 - tettaK) / Math.pow(tStage - tr, 2) * Math.pow(tStage - t, 2);
            //System.out.println(tettaK + " " + tk + " " + tStage + " " + t);
            Vkr = V1 * Math.sqrt(Rz / (Rz + y));
            tetta += (P * Math.sin(a) + Ya) / (m * V) - g * Math.cos(tetta) * (1 - V * V / (Vkr * Vkr)) / V;
            a = fi - tetta;
        }
    }

    public void step(){
        t = t + dt;
        m = m0 - ms * (t - tStage + tk);
        Xa = Cx * skorNapor * SMid;
        Cy = 3 * a;
        Ya = Cy * skorNapor * SMid;
        V += (P * Math.cos(a) - Xa) / m - Math.sin(tetta) * g;
        dx = V * Math.cos(tetta) * dt;
        dy = V * Math.sin(tetta) * dt;
        x = x + dx * dt;
        y = y + dy * dt;
        T = T0 + L * y;
        p = p0 * Math.pow(0.87, y);
        plotnVozd = p * molM / (R * T);
        skorNapor = plotnVozd * V * V / 2;

        mass.add((int)m);
        speed.add((int)V);
        alphaList.add((int)(a * 180 / Math.PI));
        tettaList.add((int)(tetta * 180 / Math.PI));
        fiList.add((int)(fi * 180 / Math.PI));
        hight.add((int)y);
        time.add((int)t);


//        System.out.println(tetta * 180 / Math.PI + " " +  a * 180 / Math.PI + " " + fi * 180 / Math.PI + " " + V + " " + y + " " + m);
    }

    public void compute(double P, double tk, double betta, double D, double w, double m, int tettaK){
        setParam(P, tk, betta, D, w, m);
        this.tettaK = tettaK * Math.PI / 180;
        tStage += tk;
        while (t < tStage){
            getTetta();
            step();
        }

        tPrev = tk;
        tettaPrev = this.tettaK;

//        System.out.println("---------------------" +
//                "\n" +
//                "-------------------");
//        System.out.println(tettaK + " " + tk + " " + tStage + " " + t);
    }

    public List<Integer> getSpeed() {
        return speed;
    }

    public List<Integer> getHight() {
        return hight;
    }

    public List<Integer> getAlphaList() {
        return alphaList;
    }

    public List<Integer> getTettaList() {
        return tettaList;
    }

    public List<Integer> getFiList() {
        return fiList;
    }

    public List<Integer> getMass() {
        return mass;
    }

    public List<Integer> getTime() {
        return time;
    }
}
