import java.util.Comparator;

public class SalaryComparator implements Comparator<Applicant> {

    @Override
    public int compare(Applicant a1, Applicant a2) {
        int s1 = Integer.parseInt(a1.getMinimumSalary());
        int s2 = Integer.parseInt(a2.getMinimumSalary());

        return s1 -s2;
    }
}
