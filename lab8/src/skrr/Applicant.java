package skrr;

import java.io.Serializable;

public class Applicant implements Serializable {
    public String registrationNumber;
    public String education;
    public String speciality;
    public String experience;
    public String dateOfDismissal;
    public String specialityWanted;
    public String workingConditions;
    public String minimumSalary;


    public Applicant(){}

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getEducation() {
        return education;
    }

    void setEducation(String education) {
        this.education = education;
    }

    public String getDateOfDismissal() {
        return dateOfDismissal;
    }

    void setDateOfDismissal(String dateOfDismissal) {
        this.dateOfDismissal = dateOfDismissal;
    }

    public String getSpeciality() {
        return speciality;
    }

    void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getExperience() {
        return experience;
    }

    void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSpecialityWanted() {
        return specialityWanted;
    }

    void setSpecialityWanted(String specialityWanted) {
        this.specialityWanted = specialityWanted;
    }

    public String getWorkingConditions() {
        return workingConditions;
    }

    void setWorkingConditions(String workingConditions) {
        this.workingConditions = workingConditions;
    }

    public String getMinimumSalary() {
        return minimumSalary;
    }

    void setMinimumSalary(String minimumWage) {
        this.minimumSalary = minimumWage;
    }

    @Override
    public String toString() {
        return  "\nRegistration number: #" + registrationNumber +
                "\n\n-Work experience-\n" +
                "\nLevel of education: " + education +
                "\nSpeciality: " + speciality +
                "\nDuration of work: " + experience +
                "\nDate of dismissal: " + dateOfDismissal +
                "\n\n-Demands for the job-\n" +
                "\nSpeciality wanted: " + specialityWanted +
                "\nWorking conditions: " + workingConditions +
                "\nMinimum salary: $" + minimumSalary + "\n\n"
                ;
    }
}