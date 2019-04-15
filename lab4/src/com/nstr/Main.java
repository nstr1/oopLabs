package com.nstr;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(new Locale("uk", "UA"));


        boolean auto = false;
        for(String s: args)
        {
            if("-auto".equals(s))
            {
                auto = true;
            }
        }


        GenericLinkedList list = new GenericLinkedList<Applicant>();

        if(auto)
        {
            System.out.println("\n[a]The program will run in auto mode\n");
            System.out.println("[a]Data will acquired from a file and printed out\n");

            try {
                FileInputStream f = new FileInputStream("/home/nstr/IdeaProjects/OOP_labs/lab4/src/com/nstr/standard.ser");
                ObjectInputStream in = new ObjectInputStream(f);

                list = (GenericLinkedList) in.readObject();
                f.close();
            } catch (Exception e) {
                System.out.println("Cannot deserialize");
            }

            System.out.println(list);

        } else {

            Scanner scanner = new Scanner(System.in);
            int choice;

            while (true) {
                System.out.println("\n---Please select an option---\n");
                System.out.println("1. Create and fill a new container");
                System.out.println("2. Remove a container");
                System.out.println("3. List containers");
                System.out.println("4. Serialize all containers");
                System.out.println("5. Deserialize containers from a file");
                System.out.println("6. Exit the program\n");
                System.out.print(": ");

                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Applicant applicant = new Applicant();
                        scanner.nextLine();

                        System.out.println("Enter the applicants registration number:");
                        System.out.print(": ");
                        applicant.setRegistrationNumber(scanner.nextLine());

                        System.out.println("Enter the applicants education level: ");
                        System.out.print(": ");
                        applicant.setEducation(scanner.nextLine());

                        System.out.println("\n--Working experience--");
                        System.out.println("Enter the applicants speciality: ");
                        System.out.print(": ");
                        applicant.setSpeciality(scanner.nextLine());

                        System.out.println("Enter the applicants length of work ");
                        System.out.print(": ");
                        applicant.setExperience(scanner.nextLine());

                        System.out.println("Enter the applicants date of dismissal: ");
                        System.out.print(": ");
                        applicant.setDateOfDismissal(scanner.nextLine());

                        System.out.println("\n--Demands for the job--");
                        System.out.println("Enter the applicants speciality: ");
                        System.out.print(": ");
                        applicant.setSpecialityWanted(scanner.nextLine());

                        System.out.println("Enter the applicants working conditions: ");
                        System.out.print(": ");
                        applicant.setWorkingConditions(scanner.nextLine());

                        System.out.println("Enter the applicants minimum salary: ");
                        System.out.print(": ");
                        applicant.setMinimumWage(scanner.nextLine());

                        list.add(applicant);
                        System.out.println("Added!");
                        break;
                    case 2:
                        try {
                            scanner.nextLine();
                            System.out.println("Which entry would you like to delete?");
                            System.out.print(": ");
                            choice = scanner.nextInt();
                            list.delete(choice);
                            System.out.println("Done!");
                        } catch (NullPointerException e) {
                            System.out.println("Cannot do that");
                        }
                        break;
                    case 3:
                        System.out.println(list);
                        break;
                    case 4:
                        scanner.nextLine();
                        System.out.println("Choose a serialization protocol:");
                        System.out.println("1. Standard");
                        System.out.println("2. Write to XML\n");
                        System.out.print(": ");
                        choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                try {
                                    FileOutputStream f = new FileOutputStream("/home/nstr/IdeaProjects/OOP_labs/lab4/src/com/nstr/standard.ser");
                                    ObjectOutputStream out = new ObjectOutputStream(f);
                                    out.writeObject(list);
                                    out.close();
                                    f.close();
                                    System.out.println("Done!");
                                } catch (Exception e) {
                                    System.out.println("Cannot serialize");
                                }

                                break;
                            case 2:
                                try {
                                    FileOutputStream f = new FileOutputStream("/home/nstr/IdeaProjects/OOP_labs/lab4/src/com/nstr/XML.xml");
                                    BufferedOutputStream out = new BufferedOutputStream(f);
                                    XMLEncoder encoder = new XMLEncoder(out);
                                    encoder.writeObject(list);
                                    encoder.close();
                                    System.out.println("Done!");
                                } catch (Exception e) {
                                    System.out.println("Cannot serialize");
                                }
                                break;
                        }
                        break;
                    case 5:
                        scanner.nextLine();
                        System.out.println("Choose a deserialization protocol:");
                        System.out.println("1. Standard");
                        System.out.println("2. Get from XML\n");
                        System.out.print(": ");
                        choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                try {
                                    FileInputStream f = new FileInputStream("/home/nstr/IdeaProjects/OOP_labs/lab4/src/com/nstr/standard.ser");
                                    ObjectInputStream in = new ObjectInputStream(f);

                                    list = (GenericLinkedList) in.readObject();
                                    f.close();
                                } catch (Exception e) {
                                    System.out.println("Cannot deserialize");
                                }
                                break;
                            case 2:
                                try {
                                    FileInputStream f = new FileInputStream("/home/nstr/IdeaProjects/OOP_labs/lab4/src/com/nstr/XML.xml");
                                    BufferedInputStream in = new BufferedInputStream(f);
                                    XMLDecoder decoder = new XMLDecoder(in);

                                    list = (GenericLinkedList) decoder.readObject();
                                    decoder.close();
                                } catch (Exception e) {
                                    System.out.println("Cannot deserialize");
                                }
                                break;
                        }
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Please select a valid option");
                }
            }
        }
    }
}
