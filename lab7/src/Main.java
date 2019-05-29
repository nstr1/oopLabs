import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static boolean regexCheck(String regex, String str)
    {
        Pattern checkRegex = Pattern.compile(regex);
        Matcher matcher = checkRegex.matcher(str);

        while (matcher.find()){
            if(matcher.group().length() != 0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ArrayList<Applicant> entries = new ArrayList<Applicant>();

        while (true) {
            System.out.println("\n---Please select an option---\n");
            System.out.println("1. Add a new applicant");
            System.out.println("2. View entries");
            System.out.println("3. Delete an entry");
            System.out.println("4. Perform a search");
            System.out.println("5. Sort");
            System.out.println("6. Exit the program\n");
            System.out.print(": ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    Applicant applicant = new Applicant();
                    scanner.nextLine();

                    System.out.println("Enter the applicants registration number: ");
                    System.out.print(": ");
                    applicant.setRegistrationNumber(scanner.nextLine());

                    System.out.println("Enter the applicants education level: ");
                    System.out.print(": ");
                    applicant.setEducation(scanner.nextLine());

                    System.out.println("\n-Working experience");
                    System.out.println("Enter the applicants speciality: ");
                    System.out.print(": ");
                    applicant.setSpeciality(scanner.nextLine());

                    System.out.println("Enter the applicants length of work ");
                    System.out.print(": ");
                    applicant.setExperience(scanner.nextLine());

                    System.out.println("Enter the applicants date of dismissal: ");
                    System.out.print(": ");
                    applicant.setDateOfDismissal(scanner.nextLine());

                    System.out.println("\n-Demands for the job");
                    System.out.println("Enter the applicants speciality: ");
                    System.out.print(": ");
                    applicant.setSpecialityWanted(scanner.nextLine());

                    System.out.println("Enter the applicants working conditions: ");
                    System.out.print(": ");
                    applicant.setWorkingConditions(scanner.nextLine());

                    System.out.println("Enter the applicants minimum salary: ");
                    System.out.print(": ");
                    applicant.setMinimumSalary(scanner.nextLine());

                    entries.add(applicant);
                    System.out.println("Added!");
                    break;

                case 2:
                    scanner.nextLine();
                    int i = 0;
                    for(Applicant a: entries){
                        System.out.println(++i + ":" + a.toString());
                    }
                    break;
                case 3:
                    scanner.nextLine();

                    System.out.println("Which element would you like to delete?\n");
                    System.out.println(":");

                    int pos = scanner.nextInt();
                    entries.remove(pos - 1);
                    System.out.println("Done!");

                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Enter an ID");
                    System.out.print(": ");
                    String search = scanner.nextLine();

                    for(Applicant a: entries){
                        if(a.getRegistrationNumber().equals(search)){
                            System.out.println("Found!\n" + a);
                        }
                    }
                    break;
                case 5:
                    scanner.nextLine();

                    System.out.println("\nSort by:\n" +
                            "1. Registration number\n" +
                            "2. Minimum salary");

                    int sort = scanner.nextInt();

                    switch (sort)
                    {
                        case 1:
                            IdComparator idComparator = new IdComparator();
                            Collections.sort(entries, idComparator);
                            break;
                        case 2:
                            SalaryComparator salaryComparator = new SalaryComparator();
                            Collections.sort(entries, salaryComparator);
                            break;
                    }

                    System.out.println(entries);
                    break;

                case 6:
                    System.out.println("Exiting");
                    System.exit(0);
            }
        }
    }
}
