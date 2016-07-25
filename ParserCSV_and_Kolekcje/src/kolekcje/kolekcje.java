package kolekcje;

import com.opencsv.CSVWriter;

import java.io.*;
import java.util.*;

/**
 * Created by jamin on 21.11.2015.
 */
public class kolekcje {
    static String[] names = {"Kasia", "Zosia", "Magda","Adam","Oleg"};
    static int length = 500000;
    static ArrayList<Customer> customersarr = new ArrayList<>();
    static LinkedList<Customer> customerslink = new LinkedList<>();
    static HashSet <Customer> customerhashset = new HashSet<>();
    static LinkedHashSet<Customer> customerLinkHashSet = new LinkedHashSet<>();
    static TreeSet<String> StringTreeSet = new TreeSet<>();

    static List<String> zapis = new ArrayList<String>();
    public static void start() throws IOException {
        //add

        AddToZapis("Length: ", length);
        AddToZapis("ArrayList",kolekcje.add(customersarr));
        AddToZapis("LinkedList",kolekcje.add(customerslink));
        AddToZapis("HashSet",kolekcje.add(customerhashset));
        AddToZapis("LinkedHashSet",kolekcje.add(customerLinkHashSet));
        AddToZapis("TreeSet",kolekcje.add(StringTreeSet));

        AddToZapis("ArrayList",kolekcje.remove(customersarr));
        AddToZapis("LinkedList",kolekcje.remove(customerslink));
        AddToZapis("HashSet",kolekcje.remove(customerhashset));
        AddToZapis("LinkedHashSet",kolekcje.remove(customerLinkHashSet));
        AddToZapis("TreeSet",kolekcje.remove(StringTreeSet));


        AddToZapis("ArrayList",kolekcje.sort(customersarr));
        AddToZapis("LinkedList",kolekcje.sort(customerslink));
        AddToZapis("HashSet",kolekcje.sort(customerhashset));
        AddToZapis("LinkedHashSet",kolekcje.sort(customerLinkHashSet));
        AddToZapis("TreeSet",kolekcje.sort(StringTreeSet));
            Zapis();


    }

private static void AddToZapis(String Status,long time){
    zapis.add(Status +" : "+time+".ms \n");
    System.out.printf(Status +" : "+time+".ms \n");
}
private static void Zapis() throws IOException {
    Writer writer = null;

    try {

        writer = new FileWriter("wynik_list_test.txt");
        writer.write(zapis.toString());

    } catch (IOException e) {

        System.err.println("Error writing the file : ");
        e.printStackTrace();

    } finally {

        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {

                System.err.println("Error closing the file : ");
                e.printStackTrace();
            }
        }

    }
}
//----------------------------ADD----------------------------------------------
    private static long add(ArrayList<Customer> arr) {
        int i = 0;
        long start = System.currentTimeMillis();
        while (i < length) {
            arr.add(new Customer(names[new Random().nextInt(4)], new Random().nextInt(50000)));
            i++;
        }
        long end = System.currentTimeMillis();
        long traceTime = end-start;
        return traceTime;
    }
    private static long add(LinkedList<Customer> arr) {
        int i = 0;
        long start = System.currentTimeMillis();
        while (i < length) {
            arr.add(new Customer(names[new Random().nextInt(4)], new Random().nextInt(50000)));
            i++;
        }
        long end = System.currentTimeMillis();
        long traceTime = end-start;
        return traceTime;
    }
    private static long add(HashSet<Customer> arr) {
        int i = 0;
        long start = System.currentTimeMillis();
        while (i < length) {
            arr.add(new Customer(names[new Random().nextInt(4)], new Random().nextInt(50000)));
            i++;
        }
        long end = System.currentTimeMillis();
        long traceTime = end-start;
        return traceTime;
    }
    private static long add(LinkedHashSet<Customer> arr) {
        int i = 0;
        long start = System.currentTimeMillis();
        while (i < length) {
            arr.add(new Customer(names[new Random().nextInt(4)], new Random().nextInt(50000)));
            i++;
        }
        long end = System.currentTimeMillis();
        long traceTime = end-start;
        return traceTime;
    }
    private static long add(TreeSet<String> arr) {
        int i = 0;
        long start = System.currentTimeMillis();
        while (i < length) {
            arr.add(String.valueOf(new Random().nextInt(50000)));
            i++;
        }
        long end = System.currentTimeMillis();
        long traceTime = end-start;
        return traceTime;
    }

//----------------------remove-----------------------------
private static long remove(ArrayList<Customer> arr) {
    int i = 0;
    long start = System.currentTimeMillis();
    while (i < length) {
        arr.remove(0);
        i++;
    }
    long end = System.currentTimeMillis();
    long traceTime = end-start;
    return traceTime;
}
    private static long remove(LinkedList<Customer> arr) {
        int i = 0;
        long start = System.currentTimeMillis();
        while (i < length) {
            arr.remove(0);
            i++;
        }
        long end = System.currentTimeMillis();
        long traceTime = end-start;
        return traceTime;
    }
    private static long remove(HashSet<Customer> arr) {
        int i = 0;
        long start = System.currentTimeMillis();
        while (i < length) {
            arr.remove(0);
            i++;
        }
        long end = System.currentTimeMillis();
        long traceTime = end-start;
        return traceTime;
    }
    private static long remove(LinkedHashSet<Customer> arr) {
        int i = 0;
        long start = System.currentTimeMillis();
        while (i < length) {
            arr.remove(0);
            i++;
        }
        long end = System.currentTimeMillis();
        long traceTime = end-start;
        return traceTime;
    }
    private static long remove(TreeSet<String > arr) {
        int i = 0;
        long start = System.currentTimeMillis();
        while (i < length) {
            arr.remove(String.valueOf(new Random().nextInt(50000)));
            i++;
        }
        long end = System.currentTimeMillis();
        long traceTime = end-start;
        return traceTime;
    }
//-----------------------Sort----------------------------------
private static long sort(ArrayList<Customer> arr) {
    int i = 0;
    long start = System.currentTimeMillis();
    while (i < length) {
        arr.sort((o1, o2) -> 0);
        i++;
    }
    long end = System.currentTimeMillis();
    long traceTime = end - start;
    return traceTime;
}
    private static long sort(LinkedList<Customer> arr) {
        int i = 0;
        long start = System.currentTimeMillis();
        while (i < length) {
            arr.sort((o1, o2) -> 0);
            i++;
        }
        long end = System.currentTimeMillis();
        long traceTime = end - start;
        return traceTime;
    }
    private static long sort(HashSet<Customer> arr) {
        return 0;
    }
    private static long sort(LinkedHashSet<Customer> arr) {
        return 0;
    }
    private static long sort(TreeSet<String> arr) {
        return 0;
    }
}
