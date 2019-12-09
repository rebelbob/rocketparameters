package ru.aerocos.rocketparam.model.graphs;

public class FirstStage {

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
    private double L = 0.0065; //среднее значение вертикальной компоненты градиента температур
    private double p0 = 101325; //стандартное атмосферное давление на уровне моря
    private double molM = 0.0289644; // молярная масса сухого воздуха
    private double R = 8.31447; //универсальная газовая постоянная
    private double betta; //угол полураствора конуса
    private double Cx = 2 * betta * betta; //коэффициент лобового сопротивления
    private double plotnVozd = 1.225; //начальная плотность воздуха
    private double P; // сила тяги ступени
    private double tk; // время работы ступени
    private double D; // диаметр ступени
    private double ms; //секундный массовый расход ступени

    private double m; //масса ракеты в данный момент времени
    private double Xa;
    private double dVx;
    private double dVy;
    private double dx;
    private double dy;
    private double T;
    private double p;
    private double tr;

    public void setP(double p) {
        P = p;
    }

    public void setTk(double tk) {
        this.tk = tk;
    }

    public void setD(double d) {
        D = d;
    }

    public void setBetta(double betta) {
        this.betta = betta;
    }

    public void setSMid(double D){
        SMid = Math.PI * D * D / 4;
    }

    public void setMs(double w){
        ms = P / w;
    }

    private void getTetta(){
        if (V < 50){
            tetta = 90 * Math.PI / 180;
            tettaK = Math.PI / 2 * 10 / 45;
            tr = t;
        } else if (t > tk){
            tetta = (Math.PI / 2) / Math.pow(tk - tr, 2) * Math.pow(tk - t, 2) + tettaK;
        }
    }

    public void compute(){
        t = t + dt;
        m = m - ms * t;
        Xa = Cx * skorNapor * SMid;
        dVx = (P - Xa) * Math.cos(tetta) / m;
        dVy = ((P - Xa) * Math.sin(tetta) - m * g) / m;
        Vx = Vx + dVx * dt;
        Vy = Vy + dVy * dt;
        V = Math.sqrt(Vx * Vx + Vy * Vy);
        dx = Vx * dt;
        dy = Vy * dt;
        x = x + dx * dt;
        y = y + dy * dt;
        T = T0 + L * y;
        p = p0 * Math.pow(0.87, y);
        plotnVozd = p * molM / (R * T);
        skorNapor = plotnVozd * V * V / 2;
        getTetta();
    }
}
