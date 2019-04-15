import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n---Multithreading demo---\n");
        System.out.println("In this demo three string containers will be created from a text file\n" +
                            "Firstly, they will be run sequentially, and then simultaneously\n");

        Scanner s = new Scanner(System.in);
        try {
            s = new Scanner(new File("/home/nstr/IdeaProjects/OOP_labs/lab6/src/text.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found\n" +
                                "Exiting...");
            System.exit(0);
        }

        Scanner in = new Scanner(System.in);
        s.useDelimiter("\\s|\n");

        RunnableArrayList a1 = new RunnableArrayList("1");
        RunnableArrayList a2 = new RunnableArrayList("2");
        RunnableArrayList a3 = new RunnableArrayList("3");

        //filling each container
        while (s.hasNext()){
            if(s.hasNext()){ a1.add(s.next()); }
            if(s.hasNext()){ a2.add(s.next()); }
            if(s.hasNext()){ a3.add(s.next()); }
        }
        s.close();

        System.out.println("Actions for each thread:\n" +
                            "1. Find all the Strings which start with 's'(ignore uppercase)\n" +
                            "2. Find the smallest and the largest Strings\n" +
                            "3. Count all the numbers\n");

        loop:
        while (true)
        {
            System.out.println("1. Start\n");
            int choice = in.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Starting...");
                    break loop;
                }
            }


        double startTimeOrder = System.nanoTime();

        try {
            a1.findS();
            a2.findMinMax();
            a3.countNumbers();
        } catch (Exception e) {}

        double endTimeOrder = System.nanoTime();
        double orderDuration = (endTimeOrder - startTimeOrder) / 1000000000;

        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(a2);
        Thread t3 = new Thread(a3);

        double startTimeSim = System.nanoTime();
        try {
            t1.start();
            t2.start();
            t3.start();

            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {}
        double endTimeSim = System.nanoTime();
        double simDuration = (endTimeSim - startTimeSim) / 1000000000;

        System.out.println("\n---Results---\n");
        System.out.println("+-------+--------------+--------------+\n" +
                           "|       |  sequential  | simultaneous |\n" +
                           "+-------+--------------+--------------+\n" +
                           "| time: | " + orderDuration +" | " +  simDuration + "  |\n" +
                           "+-------+--------------+--------------+");
        System.out.println("\nSimultaneous execution is " + orderDuration/simDuration + " times more effective than sequential");
    }

}

