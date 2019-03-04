import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {

        boolean debug = false;
        if(args.length > 0)
        {
            for (int i = 0; i < args.length; i++) {
                if(args[i].equals("-h"))
                {
                    System.out.println("This program will split your text into three categories:");
                    System.out.println("1) Lines that begin with a vowel\n" +
                            "2) Lines that begin with a consonant\n" +
                            "3) Lines that do not begin with a letter\n");
                    System.out.println("Then you will be shown the shortest line in each of these categories and it's size\n");

                    System.out.println("To enter debugging mode run the program with the '-d' flag\n");
                } else if(args[i].equals("-d")) {
                    System.out.println("\n[d]Program will run in debugging mode\n");
                    debug = true;
                }
            }

        }


            while(true) {

            System.out.println("\n-------Choose an option-------\n" +
                    "1) Change the data\n" +
                    "2) View the data\n" +
                    "3) Execute the operation\n" +
                    "4) Exit the program\n");


            int choice;
            Scanner userInput = new Scanner(System.in);
            do {
                System.out.print("> ");
                choice = userInput.nextInt();
            } while (choice < 0 || choice > 4);

                switch (choice) {
                    case 1:
                        System.out.println("Erase all data(1) or append(2)?");

                        int choice2;
                        Scanner userInput2 = new Scanner(System.in);
                        choice2 = userInput2.nextInt();

                        if(choice2 == 1){
                            try {
                                PrintWriter writer = new PrintWriter("/home/nstr/IdeaProjects/OOP_labs/lab1/src/data.txt");
                                writer.print("");
                                writer.close();
                            } catch(Exception e) {
                                System.out.println("File not found");
                            }
                        }

                            System.out.print("Enter your text:\n ");
                            String cont= "y";
                            while(cont.equals("y")){
                                Scanner scan = new Scanner(System.in);
                                String input = scan.nextLine();
                                try {
                                    FileWriter fw = new FileWriter("/home/nstr/IdeaProjects/OOP_labs/lab1/src/data.txt",true);
                                    fw.write(input + "\n");
                                    fw.close();
                                } catch (Exception e) {
                                    System.out.println("File not found");
                                }

                                System.out.println("Continue(y/n)");
                                Scanner input2 = new Scanner(System.in);
                                cont = input2.nextLine();
                        }

                        break;
                    case 2:
                        try {
                            Scanner scanner = new Scanner(new File("/home/nstr/IdeaProjects/OOP_labs/lab1/src/data.txt"));
                            while (scanner.hasNextLine()) {
                                System.out.println(scanner.nextLine());
                            }
                            scanner.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found. Exiting...");
                            System.exit(0);
                        }
                        continue;
                    case 3:
                        try {
                            Scanner scanner = new Scanner(new File("/home/nstr/IdeaProjects/OOP_labs/lab1/src/data.txt"));
                            TextSplit text = new TextSplit();
                            text.split(scanner);
                            if(debug == true){
                                System.out.println("[d]Split text:");
                                text.print();
                                System.out.println();
                            }
                            text.findShortest();
                            scanner.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found. Exiting...");
                            System.exit(0);
                        }
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        System.exit(0);
                }
            }

        }

    }


