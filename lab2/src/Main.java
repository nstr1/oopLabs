import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        ArrayList<Container> list = new ArrayList<>();

        while(true)
        {
            System.out.println("\n---Please select an option---\n");
            System.out.println("1. Create and fill a new container");
            System.out.println("2. Open list of containers");
            System.out.println("3. Quit the program");
            System.out.println();
            System.out.print("> ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter the length of this container:");
                    int len = scanner.nextInt();
                    Container container = new Container(len);

                    System.out.println("Container created!");
                    System.out.println("Enter your data:");
                    scanner.nextLine();
                    for(int i = 0; i < len; i++){
                        container.add(scanner.nextLine());
                    }
                    list.add(container);
                    System.out.println("Container added to the list!\n");
                    break;
                case 2:
                    for(int i = 0; i < list.size(); i++){
                        System.out.println("("+ i +") container[" + (list.get(i)).size() + "]");
                    }
                    System.out.println();
                    System.out.println("Choose a container to open its menu");
                    System.out.print("> ");
                    int containerIndex = scanner.nextInt();

                    System.out.println("Opened (" + choice + ")\n");
                    System.out.println("---Please select an option---\n");
                    System.out.println("1. Add an element");
                    System.out.println("2. Search and remove an element");
                    System.out.println("3. Print as a String");
                    System.out.println("4. Clear the container");
                    System.out.println("5. Get the container as an array and iterate through");
                    System.out.println("6. Get size");
                    System.out.println("7. Check if the container contains a string");
                    System.out.println("8. Iterate through (while)");
                    System.out.println("9. Iterate through (for each)");
                    System.out.println("10. Serialize this container");
                    System.out.println("11. Deserialize a container");
                    System.out.println("12. Search for a string");
                    System.out.println("13. Sort (length)");
                    System.out.println("14. Compare elements");
                    System.out.println("15. Return to the menu");
                    System.out.print("\n> ");

                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Enter your data:\n");
                            System.out.print(">");
                            scanner.nextLine();
                            (list.get(containerIndex)).add(scanner.nextLine());
                            System.out.println("Added!");
                            break;
                        case 2:
                            System.out.println("Enter a string which you would like to remove");
                            System.out.print("> ");
                            scanner.nextLine();
                            (list.get(containerIndex)).remove(scanner.nextLine());
                            break;
                        case 3:
                            System.out.println((list.get(containerIndex)).toString());
                            break;
                        case 4:
                            (list.get(containerIndex)).clear();
                            System.out.println("Clear!");
                            break;
                        case 5:
                            scanner.nextLine();
                            for (Object o : (list.get(containerIndex)).toArray()) {
                                System.out.println(o);
                            }
                            break;
                        case 6:
                            scanner.nextLine();
                            System.out.println(list.get(containerIndex).size());
                        case 7:
                            System.out.println("Enter the string that you would like to search for: ");
                            System.out.print("> ");
                            scanner.nextLine();
                            System.out.println(list.get(containerIndex).contains(scanner.nextLine()));
                        case 8:
                            CustomIterator i = (CustomIterator)(list.get(containerIndex).iterator());
                            while (i.hasNext())
                            {
                                System.out.println((i.next()));
                            }
                            break;
                        case 9:
                            for(String s: list.get(containerIndex))
                            {
                                System.out.println(s);
                            }
                            break;
                        case 10:
                            System.out.println("Enter the name of the file to which you want to save this container: ");
                            System.out.print("> ");
                            scanner.nextLine();
                            (list.get(containerIndex)).serialize(scanner.nextLine(), list.get(containerIndex));
                            System.out.println("Saved!");
                            break;
                        case 11:
                            System.out.println("Enter the name of the file from which you want to retrieve a container: ");
                            System.out.print("> ");
                            scanner.nextLine();
                            System.out.println((list.get(containerIndex)).deserialize(scanner.nextLine()));
                            break;
                        case 12:
                            System.out.println("Enter a string which you would like to search for: ");
                            System.out.print("> ");
                            scanner.nextLine();
                            (list.get(containerIndex)).find(scanner.nextLine());
                            break;
                        case 13:
                            (list.get(containerIndex)).sort();
                            System.out.println("Sorted!");
                            break;
                        case 14:
                            System.out.println("Enter indexes oftwo elements which you would like to compare: ");
                            scanner.nextLine();
                            System.out.print("[1]: ");
                            int first = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("[2]: ");
                            int second = scanner.nextInt();
                            (list.get(containerIndex)).compare(first, second);
                            break;
                            case 15:
                            System.out.println();
                            break;

                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}
