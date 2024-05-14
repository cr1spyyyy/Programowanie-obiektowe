import java.util.*;
import java.lang.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        List<String> names = new ArrayList<>();
//        List<String> names1 = new LinkedList<>();
//
//        names.isEmpty();
//        names.add("jan");
//        names.add("jan2");
//        names.add("jan3");
//        names.add("jan4");
//        System.out.printf("lista imion: "+ names);
//        names.remove(3);
//        System.out.printf("lista imion: "+names);
//        System.out.printf("lista imion: "+names.get(0));
//        for(int i=0; i<names.size();i++){
//            System.out.println("");
//        }
//        for(String item : names)
//            System.out.println(item);
//
//        names1.add("jan");
//
//        Set<String> uniqueNames = new HashSet<>();
//        Set<String> uniqueNames1 = new LinkedHashSet<>();
//        Set<String> uniqueNames2 = new TreeSet<>();
//
//        uniqueNames.add("anna");
//        uniqueNames.add("marek");
//        uniqueNames.add("heniek");
//        uniqueNames.add("anna");
//        System.out.println("zbior unikalnych imion: "+uniqueNames);
//        uniqueNames.remove("marek");
//        System.out.println("zbior aktualnych imion"+uniqueNames);
//
//        HashMap<String, Integer> age = new HashMap<>();
//
//        age.put("Anna", 15);
//        age.put("jan", 125);
//        age.put("marek", 34);
//
//        System.out.println("wiek osob: "+ age);
//        System.out.println("wiek anny: "+age.get("Anna"));
//
//        //klucze
//        for(String name : age.keySet())
//            System.out.println(age);
//        //wartosci
//        for(Integer name : age.values())
//            System.out.println(age);
//        //klucze i wartosc
//        for(Map.Entry<String, Integer> entry : age.entrySet())
//            System.out.println("Imie "+entry.getKey()+"Wiek: "+entry.getValue());
    //zadanie1();
      //  zadanie2();

    }
    public static void zadanie3(){
        informacje uczestnik = new informacje();

    }

    public static void zadanie2(){
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> pary = new HashMap<>();

        System.out.println("Podaj imiona par:(przerwij wpisujac '-'");
        while (true){
            String input1 =scanner.nextLine();
            String input2 =scanner.nextLine();

            if(input1.equals("-") || input2.equals("-"))
                break;



            pary.put(input1,input2);
        }
        System.out.println("Podaj jedno z wczesniej podanych imion");
        String imie = scanner.nextLine();
        System.out.println("wybrana para: "+ pary.get(imie));
    }
    public static void zadanie1(){
        Scanner scanner = new Scanner(System.in);
        Set<String> names = new HashSet<>();

        System.out.println("Podaj imie: (jezeli chcesz zakonczyc wpisz '-')");
        while (true){
            String input = scanner.nextLine();
            if(input.equals("-"))
                break;

            names.add(input);
        }
        System.out.println("liczba unikalnych imion" + names.size());
    }
}