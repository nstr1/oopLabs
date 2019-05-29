import java.io.Serializable;
import java.util.Comparator;

public class Applicant {
    private String registrationNumber;
    private String education;
    private String speciality;
    private String experience;
    private String dateOfDismissal;
    private String specialityWanted;
    private String workingConditions;
    private String minimumSalary;


    public Applicant(){}

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }


    public String getDateOfDismissal() {
        return dateOfDismissal;
    }

    public void setDateOfDismissal(String dateOfDismissal) {
        this.dateOfDismissal = dateOfDismissal;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSpecialityWanted() {
        return specialityWanted;
    }

    public void setSpecialityWanted(String specialityWanted) {
        this.specialityWanted = specialityWanted;
    }

    public String getWorkingConditions() {
        return workingConditions;
    }

    public void setWorkingConditions(String workingConditions) {
        this.workingConditions = workingConditions;
    }

    public String getMinimumSalary() {
        return minimumSalary;
    }

    public void setMinimumSalary(String minimumWage) {
        this.minimumSalary = minimumWage;
    }

    @Override
    public String toString() {
        return  "\nRegistration number: #" + registrationNumber +
                "\n-Work experience" +
                "\nLevel of education: " + education +
                "\nSpeciality: " + speciality +
                "\nDuration of work: " + experience +
                "\nDate of dismissal: " + dateOfDismissal +
                "\n\n-Demands for the job" +
                "\nSpeciality wanted: " + specialityWanted +
                "\nWorking conditions: " + workingConditions +
                "\nMinimum salary: $" + minimumSalary + "\n"
                ;
    }
}