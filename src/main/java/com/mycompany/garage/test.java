/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.garage;
import java.util.Scanner;
/**
 *
 * @author alex
 */
public class test {
    
}

class garage {
final static int max=15;
public static void main (String args []) {
Scanner in=new Scanner(System.in);
String mar;//marca
char db;//diesel o benzina
int cil,year,par4;
char ch,scelta;
int i,j=0;
V T[] = new V[max]; //istanziazione del vettore
do{
   System.out.print("m,a,f?:");ch=in.next().charAt(0);
   System.out.print("marca:");mar=in.next();    System.out.print("anno:");year=in.nextInt();    System.out.print("cilindrata:");cil=in.nextInt();
   switch(ch){
      case 'a':{
      System.out.print("porte:"); par4=in.nextInt();       System.out.print("diesel o benzina?(d/b):");
      db=in.next().charAt(0);
      A a = new A(j,mar,year, cil, par4,db);
      T[j]=a;}break;
      case 'f':{
      System.out.print("carico:"); par4=in.nextInt();
      F f = new F(j,mar,year, cil, par4);
      T[j]=f;}break;
      case 'm':{
      System.out.print("tempi:"); par4=in.nextInt();
      F f = new F(j,mar,year, cil, par4);
      T[j]=f;}break;
      default:System.out.println("scelta non valida");
   }//fine switch
   j++;
   for(i=0;i < j;i++)System.out.println(T[i]);
   System.out.print("continui?(s/n):");
   scelta=in.next().charAt(0);
}while(scelta!='n' && j < max);//fine do-while
System.out.print("indice mezzo da cercare:"); i=in.nextInt();
if(i < j && i>=0)System.out.println(T[i]);
else System.out.println("elemento non presente");
}//fine main
}// fine classe garage

class V {
protected int id;
protected String marca;
protected int anno,cyl;
V(int j,String s, int a, int c){id=j;marca=s;anno=a;cyl=c;}
}//fine classe V

class A extends V {
private int porte;
private char alimentazione;
A(int j,String s, int a, int c,int p, char d) {
super(j,s,a,c); porte=p; alimentazione=d;
}
public int getid() {return id;}
public String getm() {return marca;}
public int geta() {return anno;}
public int getc() {return cyl;}
public int getp() {return porte;}
public char getd() {return alimentazione;}
public String toString() {
String st=getid()+"] "+getm()+" "+geta()+" "+getc()+" "+getp()+" "+getd();
return st;
}
}//fine classe A
class F extends V {
private int carico;
F(int j,String s, int a, int c,int ca) {super(j,s,a,c);carico=ca;}
public int getid() {return id;}
public String getm() {return marca;}
public int geta() {return anno;}
public int getc() {return cyl;}
public int getca() {return carico;}
public String toString() {
String st=getid()+"] "+getm()+" "+geta()+" "+getc()+" "+getca();
return st; }
}//fine classe F
class M extends V {
private int tempi;
M(int j,String s, int a, int c,int t) {super(j,s,a,c);tempi=t;}
public int getid() {return id;}
public String getm() {return marca;}
public int geta() {return anno;}
public int getc() {return cyl;}
public int gett() {return tempi;}
public String toString() {
String st=getid()+"] "+getm()+" "+geta()+" "+getc()+" "+gett();
return st;
}
}//fine classe M