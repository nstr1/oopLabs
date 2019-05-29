package skrr;

import java.util.Comparator;

public class IdComparator implements Comparator<Applicant> {

    @Override
    public int compare(Applicant a1, Applicant a2) {
        int id1 = Integer.parseInt(a1.getRegistrationNumber());
        int id2 = Integer.parseInt(a2.getRegistrationNumber());

        return id1 - id2;
    }
}
