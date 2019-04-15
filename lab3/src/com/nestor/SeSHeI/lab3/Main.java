package com.nestor.SeSHeI.lab3;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Applicant> entries = new ArrayList<Applicant>();

        while (true)
        {
            System.out.println("\n---Please select an option---\n");
            System.out.println("1. Initialize a new applicant entry");
            System.out.println("2. Remove an entry");
            System.out.println("3. View entries");
            System.out.println("4. Entry menu");
            System.out.println("5. Write all entries to an XML");
            System.out.println("6. Retrieve entries from an XML");
            System.out.println("7. Exit the program\n");
            System.out.print(": ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            int index;

            switch (choice)
            {
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
                    applicant.setExperience(scanner.nextLine());

                    System.out.println("Enter the applicants length of work ");
                    System.out.print(": ");
                    applicant.setExperience(scanner.nextLine());

                    System.out.println("Enter the applicants date of dismissal: ");
                    System.out.print(": ");
                    applicant.setDateOfDismissal(scanner.nextLine());

                    System.out.println("\n-Demands for the job");
                    System.out.println("Enter the applicants speciality: ");
                    System.out.print(": ");
                    applicant.setSpeciality(scanner.nextLine());

                    System.out.println("Enter the applicants working conditions: ");
                    System.out.print(": ");
                    applicant.setWorkingConditions(scanner.nextLine());

                    System.out.println("Enter the applicants minimum salary: ");
                    System.out.print(": ");
                    applicant.setMinimumWage(scanner.nextLine());

                    entries.add(applicant);
                    System.out.println("Added!");
                    break;
                case 2:
                    index = 1;
                    for(Applicant a: entries)
                    {
                        System.out.println( index++ + ". " + a.getRegistrationNumber());
                    }
                    System.out.println("Which entry you would like to remove?\n");
                    System.out.print(": ");
                    entries.remove((scanner.nextInt()) - 1);
                    System.out.println("Removed!");
                    break;
                case 3:
                    index = 1;
                    for(Applicant a: entries)
                    {
                        System.out.println( index++ + ". " + a.getRegistrationNumber());
                    }
                    break;
                case 4:
                    index = 1;
                    for(Applicant a: entries)
                    {
                        System.out.println("\n" + index++ + ". \n" + a.toString());
                    }
                    break;
                case 5:
                    System.out.println("Encoding...");
                    try {
                        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("data.xml")));
                        encoder.writeObject(entries);
                        encoder.close();
                        System.out.println("\nDone!");
                    } catch (Exception e) {
                        System.out.println("File not found");
                    }
                    break;
                case 6:
                    System.out.println("Decoding...");
                    try {
                        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("data.xml")));
                        entries = (ArrayList)decoder.readObject();
                        decoder.close();
                        System.out.println("Done!");
                    } catch (Exception e) {
                        System.out.println("File not found");
                    }

                    break;
                case 7:
                    System.out.println("Extitng...");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}

