package Runing;

import Figers.*;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Run {
    /*
    * w klasie input beda zdefiniowane metody
    * input string int double inne */
    Input input = new Input();
    public void runing() {
        int wybor;
        while (true){
            Menu(); // menu programu
            wybor = input.inputInt(); // metoda do wczytania int
            switch (wybor){
                case 1 ->viewCircle();
                case 2 ->viewKwadrat();
                case 3 ->viewProstokat();
                case 4 ->viewSzescian();
                case 5 ->viewProstopadloscian();
                case 6 ->viewKula();
                case 7 ->viewStozek();
                //kolejen case
                case 8 ->Close();
                default -> defaultInstructioon();
            }//koniec switch
        }//koneic while
    }// koniec run




    private void defaultInstructioon() {
        System.out.println("Bledne dane, koniec programu");
        System.exit(0);
    }

    private void Close() {
        System.out.println("Czy na pewno chcesz wyjść? t || T");
        String znak = input.inputChar();
        String str1 = "t", str2 = "T";
        if (znak.equals(str1) || znak.equals(str2)) System.exit(0);
    }
    private void viewStozek() {
        Stozek stozek = new Stozek();
        System.out.println("Podaj nazwe figury: ");
        String name = input.inputString();
        System.out.println("Podaj promien podstawy: ");
        double r = input.inputDouble();
        System.out.println("Podaj wysokosc stozka: ");
        double h = input.inputDouble();
        System.out.println("Podaj dlugosc l: ");
        double l = input.inputDouble();
        stozek.setR(r);
        stozek.setH(h);
        stozek.setL(l);
        stozek.setName(name);
        stozek.view();
    }
    private void viewKula() {
        Kula kula = new Kula();
        System.out.println("Podaj nazwe figury");
        String name = input.inputString();
        System.out.println("Podaj promien kuli: ");
        double r = input.inputDouble();
        if(r<=0){
            System.out.println("podano nieprawidlowe dane");
        }
        kula.setName(name);
        kula.setR(r);
        kula.view();

    }
    private void viewProstopadloscian() {
        Prostopadloscian prostopadloscian = new Prostopadloscian();
        System.out.println("Podaj nazwe figury: ");
        String name = input.inputString();
        System.out.println("Podaj dlugosc boku A: ");
        double a = input.inputDouble();
        System.out.println("Podaj dlugosc boku B: ");
        double b = input.inputDouble();
        System.out.println("Podaj dlugosc boku C: ");
        double c = input.inputDouble();
        if(a<=0 || b<=0 || c<=0){
            System.out.println("podano bledne dane!");
        }
        prostopadloscian.setA(a);
        prostopadloscian.setB(b);
        prostopadloscian.setC(c);
        prostopadloscian.setName(name);
        prostopadloscian.view();
    }
    private void viewSzescian() {
        Szescian szescian = new Szescian();
        System.out.println("Podaj nazwe figury: ");
        String name = input.inputString();
        System.out.println("Podaj dlugosc krawedzi: ");
        double a = input.inputDouble();
        if(a<=0){
            System.out.println("Podano bledne dane!");
        }
        szescian.setA(a);
        szescian.setName(name);
        szescian.view();

    }
    private void viewProstokat() {
        Prostokat prostokat = new Prostokat();
        System.out.println("Podaj nazwe figury: ");
        String name = input.inputString();
        System.out.println("Podaj dlugosc boku A: ");
        double a = input.inputDouble();
        System.out.println("Podaj dlugosc boku B: ");
        double b = input.inputDouble();
        if(a<=0 || b<=0){
            System.out.println("podano bledne dane!");
        }
        prostokat.setA(a);
        prostokat.setB(b);
        prostokat.setName(name);
        prostokat.view();

    }
    private void viewKwadrat() {
        Kwadrat kwadrat = new Kwadrat();
        System.out.println("Podaj nazwe figury: ");
        String name = input.inputString();
        System.out.println("Podaj dlugosc boku: ");
        double a = input.inputDouble();
        if(a<=0){
            System.out.println("Podano nieprawidlowe dane!");
        }
        kwadrat.setName(name);
        kwadrat.setA(a);
        kwadrat.view();
    }
    private void viewCircle() {
        //utworzenie obiektu danej klasy
        /*
        * podanie nazy figury
        * podanie niezbędnych wartości
        * sprwadzenie czy podano poprana wartosc if lub abs
        * wywolanie metody view()*/
        Circle circle = new Circle();
        System.out.println("Podaj nazwe figury");
        String name = input.inputString();
        System.out.println("Podaj promien kola: ");
        double r = input.inputDouble();
        if(r<=0){
            System.out.println("podano nieprawidlowe dane");
        }
        circle.setName(name);
        circle.setR(r);
        circle.view();
    }

    private void Menu() {
        System.out.println("Kalkulator figur geometrycznych");
        System.out.println("1. Kolo\n"+
                "2. Kwadrat \n"+
                "3. Prostokat \n"+
                "4. Szescian \n"+
                "5. Prostopadloscian \n"+
                "6. Kula \n"+
                "7. Stozek \n"+
                "8. Wyjscie");
        System.out.println("\n\nWybierz opcje: ");
    }


}//koniec klasy
