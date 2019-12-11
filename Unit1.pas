unit Unit1;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls, Math, TeEngine, Series, ExtCtrls, TeeProcs, Chart;

type
  TForm1 = class(TForm)
    Label1: TLabel;
    Edit1: TEdit;
    Edit2: TEdit;
    Label2: TLabel;
    Edit3: TEdit;
    Label3: TLabel;
    Button1: TButton;
    Label5: TLabel;
    Edit4: TEdit;
    Edit5: TEdit;
    Chart1: TChart;
    Series1: TLineSeries;
    Edit6: TEdit;
    Chart2: TChart;
    Series2: TLineSeries;
    mmo1: TMemo;
    Edit7: TEdit;
    Edit8: TEdit;
    Series3: TLineSeries;
    Edit9: TEdit;
    Edit10: TEdit;
    Edit11: TEdit;
    Edit12: TEdit;
    Series4: TLineSeries;
    Label6: TLabel;
    Label7: TLabel;
    Label8: TLabel;
    Series5: TLineSeries;
    Series6: TLineSeries;
    Chart3: TChart;
    LineSeries1: TLineSeries;
    LineSeries2: TLineSeries;
    LineSeries3: TLineSeries;
    Label9: TLabel;
    Edit13: TEdit;
    Edit14: TEdit;
    Edit15: TEdit;
    Label10: TLabel;
    Label4: TLabel;
    Edit16: TEdit;
    Label11: TLabel;
    Edit17: TEdit;
    Label12: TLabel;
    procedure Button1Click(Sender: TObject);

  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;


implementation

{$R *.dfm}

procedure TForm1.Button1Click(Sender: TObject);
var  Xa,SkorNapor,Smid1,Smid2,Smid3,Diam1,Diam2,Diam3,betta,Cx,Plotnost,Davl,R,MolM,Davl0,L,T0,Temper,M01,M02,M03,MRN,P1,P2,P3,I1,I2,I3,dt,Ms1,Ms2,Ms3,M,t,g,x,y,Vx,Vy,dVx,dVy,dx,dy,tett,t1k,t2k,t3k,tett1k,tett2k,tett3k,V,tp:Real;
begin
 Form1.Series1.Clear;
 Form1.Series2.Clear;
 Form1.Series3.Clear;
 Form1.Series4.Clear;
 Form1.Series5.Clear;
 Form1.Series6.Clear;
 Form1.LineSeries1.Clear;
 Form1.LineSeries2.Clear;
 Form1.LineSeries3.Clear;
 mmo1.Clear;

 dt:=0.1; // шаг интегрирования
 g:=9.8; //ускорение свободного падения
 MRN:=StrToFloat(Edit16.Text);  // Стартовая масса РН
 T0:=288.15; //стандартная температура на уровне моря
 L:=-0.0065; //среднее значение вертикальной компоненты градиента температур
 Davl0:=101325; // стандартное атмосферное давление на уровне моря
 MolM:=0.0289644; // молярная масса сухого воздуха
 R:=8.31447; //универсальная газовая постоянная
 betta:=StrToFloat(Edit17.Text)*pi/180; //угол полураствора конуса
 Cx:=2*betta*betta; //коэффициент лобового сопротивления
 Plotnost:=1.225; //начальная плотность воздуха

 // ПЕРВАЯ СТУПЕНЬ

 P1:=StrToFloat(Edit1.Text)*1000;  // сила тяги первой ступени
 I1:=StrToFloat(Edit2.Text);  // удельный импульс
 M01:=StrToFloat(Edit3.Text);  // начальная масса ступени
 t1k:=StrToFloat(Edit4.Text);   // время работы первой ступени
 Diam1:=StrToFloat(Edit13.Text); // диаметр ступени

 Ms1:=P1/I1; //секундный массовый расход первой ступени
 t:=0; // начальное время
 x:=0; // начальная координата x
 y:=0; //начальная координата y
 Vx:=0; // начальная скорость x
 Vy:=0; // начальная скорость y
 V:=0; // начальная скорость
 tett:=90*pi/180; // начальный угол наклона траектории
 tett1k:=pi/2*11/45; // конечный угол наклона траектории первой ступени
 Smid1:=pi*Diam1*Diam1/4; //площадь миделя ступени
 SkorNapor:=Plotnost*V*V/2;  // начальный скоростной напор
 M:=MRN;
 repeat
  t:=t+dt; // текущее время
  M:=MRN-Ms1*t; // текущая масса
  //M:=M-Ms1*dt;
  Xa:=Cx*SkorNapor*Smid1;  //текущее лобовое сопротивление
  dVx:=(P1-Xa)*cos(tett)/M;
  dVy:=((P1-Xa)*sin(tett)-M*g)/M;
  Vx:=Vx+dVx*dt;
  Vy:=Vy+dVy*dt;
  V:=Sqrt(Vx*Vx+Vy*Vy);
  dx:=Vx*dt;
  dy:=Vy*dt;
  x:=x+dx*dt;
  y:=y+dy*dt;
  Temper:=T0+L*y;    // текущая температура
  //Davl:=Davl0*exp(-MolM*g*y/R*Temper);     // текущее давление
  Davl:=Davl0*power(0.87,y);
  Plotnost:=Davl*MolM/(R*Temper);    // текущая плотность воздуха
  SkorNapor:=Plotnost*V*V/2;  // текущий скоростной напор
  Form1.Series1.AddXY(t,y);
  Form1.Series2.AddXY(t,V);
  Form1.LineSeries1.AddXY(t,tett*180/pi);
  mmo1.Lines.Add(FloatToStrF(t,ffFixed,4,1)+'   '+FloatToStrF(tett*180/pi,ffFixed,4,2)+'    '+FloatToStrF(y,ffFixed,6,2)+'  '+FloatToStrF(V,ffFixed,4,2)+'  '+FloatToStrF(M,ffFixed,0,2)+'  '+FloatToStrF(Davl,ffFixed,2,1)+'  '+FloatToStrF(Temper,ffFixed,0,2)+'   '+FloatToStrF(Plotnost,ffFixed,0,2)+'   '+FloatToStrF(SkorNapor,ffFixed,0,2)+'        '+FloatToStrF(Xa,ffFixed,0,2));
 until V>50;
 tp:=t;
 repeat
  t:=t+dt; // текущее время
  M:=MRN-Ms1*t; // текущая масса
  //M:=M-Ms1*dt;
  Xa:=Cx*SkorNapor*Smid1;  //текущее лобовое сопротивление
  dVx:=(P1-Xa)*cos(tett)/M;
  dVy:=((P1-Xa)*sin(tett)-M*g)/M;
  Vx:=Vx+dVx*dt;
  Vy:=Vy+dVy*dt;
  V:=Sqrt(Vx*Vx+Vy*Vy);
  dx:=Vx*dt;
  dy:=Vy*dt;
  x:=x+dx*dt;
  y:=y+dy*dt;
  Temper:=T0+L*y;    // текущая температура
  //Davl:=Davl0*exp(-MolM*g*y/R*Temper);     // текущее давление
  Davl:=Davl0*power(0.87,y);
  Plotnost:=Davl*MolM/(R*Temper);    // текущая плотность воздуха
  SkorNapor:=Plotnost*V*V/2;  // текущий скоростной напор
  Form1.Series1.AddXY(t,y);
  tett:=(pi/2-tett1k)/(sqr(t1k-tp))*sqr(t1k-t)+tett1k;
  Form1.Series2.AddXY(t,V);
  Form1.LineSeries1.AddXY(t,tett*180/pi);
  mmo1.Lines.Add(FloatToStrF(t,ffFixed,4,1)+'   '+FloatToStrF(tett*180/pi,ffFixed,4,2)+'    '+FloatToStrF(y,ffFixed,6,2)+'  '+FloatToStrF(V,ffFixed,4,2)+'  '+FloatToStrF(M,ffFixed,0,2)+'  '+FloatToStrF(Davl,ffFixed,2,1)+'  '+FloatToStrF(Temper,ffFixed,0,2)+'   '+FloatToStrF(Plotnost,ffFixed,0,2)+'   '+FloatToStrF(SkorNapor,ffFixed,0,2)+'        '+FloatToStrF(Xa,ffFixed,0,2));
 until t>t1k;

  //  ВТОРАЯ СТУПЕНЬ

 P2:=StrToFloat(Edit5.Text)*1000;  // сила тяги второй ступени
 I2:=StrToFloat(Edit6.Text);  // удельный импульс
 M02:=StrToFloat(Edit7.Text);  // начальная масса
 t2k:=StrToFloat(Edit8.Text);   // время работы второй ступени
 Diam2:=StrToFloat(Edit14.Text); // диаметр ступени

 Ms2:=P2/I2; //секундный массовый расход второй ступени
 tett2k:=pi/2*5/45;  // конечный угол наклона второй ступени
 Smid2:=pi*Diam2*Diam2/4; //площадь миделя ступени

 repeat
  t:=t+dt; // текущее время
  M:=MRN-M01-Ms2*(t-t1k); // текущая масса
  //M:=M-Ms2*dt;
  Xa:=Cx*SkorNapor*Smid2;  //текущее лобовое сопротивление
  dVx:=(P2-Xa)*cos(tett)/M;
  dVy:=((P2-Xa)*sin(tett)-M*g)/M;
  Vx:=Vx+dVx*dt;
  Vy:=Vy+dVy*dt;
  V:=Sqrt(Vx*Vx+Vy*Vy);
  dx:=Vx*dt;
  dy:=Vy*dt;
  x:=x+dx*dt;
  y:=y+dy*dt;
  Temper:=T0+L*y;    // текущая температура
 // Davl:=Davl0*exp(-MolM*g*y/R*Temper);     // текущее давление
  Davl:=Davl0*power(0.87,y);
  Plotnost:=Davl*MolM/(R*Temper);    // текущая плотность воздуха
  SkorNapor:=Plotnost*V*V/2;  // текущий скоростной напор
  Form1.Series3.AddXY(t,y);
  tett:=tett1k-(t-t1k)/(t1k+t2k-t1k)*(tett1k-tett2k);
  Form1.Series5.AddXY(t,V);
  Form1.LineSeries2.AddXY(t,tett*180/pi);
  mmo1.Lines.Add(FloatToStrF(t,ffFixed,4,1)+'   '+FloatToStrF(tett*180/pi,ffFixed,4,2)+'    '+FloatToStrF(y,ffFixed,6,2)+'  '+FloatToStrF(V,ffFixed,4,2)+'  '+FloatToStrF(M,ffFixed,0,2)+'  '+FloatToStrF(Davl,ffFixed,2,1)+'  '+FloatToStrF(Temper,ffFixed,0,2)+'   '+FloatToStrF(Plotnost,ffFixed,0,2)+'   '+FloatToStrF(SkorNapor,ffFixed,0,2)+'        '+FloatToStrF(Xa,ffFixed,0,2));
  until t>t1k+t2k;

 //  ТРЕТЬЯ СТУПЕНЬ

 P3:=StrToFloat(Edit9.Text)*1000;  // сила тяги третьей ступени
 I3:=StrToFloat(Edit10.Text);  // удельный импульс
 M03:=StrToFloat(Edit11.Text);  // начальная масса
 t3k:=StrToFloat(Edit12.Text);   // время работы третьей ступени
 Diam3:=StrToFloat(Edit15.Text); // диаметр ступени

 Ms3:=P3/I3; //секундный массовый расход третьей ступени
 tett3k:=0;  // конечный угол наклона третьей ступени
 Smid3:=pi*Diam3*Diam3/4; //площадь миделя ступени

 repeat
  t:=t+dt; // текущее время
  M:=MRN-M01-M02-Ms3*(t-t1k-t2k); // текущая масса
  //M:=M-Ms3*dt;
  Xa:=Cx*SkorNapor*Smid3;  //текущее лобовое сопротивление
  dVx:=(P3-Xa)*cos(tett)/M;
  dVy:=((P3-Xa)*sin(tett)-M*g)/M;
  Vx:=Vx+dVx*dt;
  Vy:=Vy+dVy*dt;
  V:=Sqrt(Vx*Vx+Vy*Vy);
  dx:=Vx*dt;
  dy:=Vy*dt;
  x:=x+dx*dt;
  y:=y+dy*dt;
  Temper:=T0+L*y;    // текущая температура
  //Davl:=Davl0*exp(-MolM*g*y/R*Temper);     // текущее давление
  Davl:=Davl0*power(0.87,y);
  Plotnost:=Davl*MolM/(R*Temper);    // текущая плотность воздуха
  SkorNapor:=Plotnost*V*V/2;  // текущий скоростной напор
  Form1.Series4.AddXY(t,y);
  tett:=tett2k-(t-t1k-t2k)/(t1k+t2k+t3k-t1k-t2k)*(tett2k-tett3k);
  Form1.Series6.AddXY(t,V);
  Form1.LineSeries3.AddXY(t,tett*180/pi);
  mmo1.Lines.Add(FloatToStrF(t,ffFixed,4,1)+'   '+FloatToStrF(tett*180/pi,ffFixed,4,2)+'    '+FloatToStrF(y,ffFixed,6,2)+'  '+FloatToStrF(V,ffFixed,4,2)+'  '+FloatToStrF(M,ffFixed,0,2)+'  '+FloatToStrF(Davl,ffFixed,2,1)+'  '+FloatToStrF(Temper,ffFixed,0,2)+'   '+FloatToStrF(Plotnost,ffFixed,0,2)+'   '+FloatToStrF(SkorNapor,ffFixed,0,2)+'        '+FloatToStrF(Xa,ffFixed,0,2));
 until t>t1k+t2k+t3k;


end;


end.
