import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class RunnableArrayList implements Runnable {
    private ArrayList<String> a;
    private String num;
    private int sleep_time;


    RunnableArrayList(String num){
        this.a = new ArrayList<>();
        this.num = "[" + num + "]";
        this.sleep_time = 500;
    }

    void add(String data){
        a.add(data);
    }

    void findS() throws InterruptedException {
        String res = "";
        int count = 0;
        for(String s: a){
            if(s.charAt(0) == 's' || s.charAt(0) == 'S' ) {
                res = res + s + " ";
                System.out.println(num + "Found: " + s);
                count++;
                TimeUnit.MILLISECONDS.sleep(sleep_time);
            }
        }

        System.out.println("\nFound " + count + " Strings that begin with 's'!\n" + res + "\n");
    }

    void findMinMax() throws InterruptedException{
        String min = "__________________";
        String max = "";
        for(String s: a){
            if(isAlpha(s)) {
                if (s.length() > max.length()) {
                    max = s;
                    System.out.println(num + "Found new max: " + s);
                    TimeUnit.MILLISECONDS.sleep(sleep_time);
                } else if (s.length() < min.length()) {
                    min = s;
                    System.out.println(num + "Found new min: " + s);
                    TimeUnit.MILLISECONDS.sleep(sleep_time);
                }
            }

        }
        System.out.println("\nSmallest: " + min + "\nLargest: " + max + "\n");
    }

    void countNumbers() throws InterruptedException{
        int count = 0;
        for(String s: a){
            if(s.matches("^[0-9]*$|^[0-9]*,$")){
                System.out.println(num + "Found " + s);
                count++;
                TimeUnit.MILLISECONDS.sleep(sleep_time);
            }
        }
        System.out.println("\nFound " + count + " numbers!");
    }

    @Override
    public void run() {
        try {
            if(num.equals("[1]")){
                findS();
            } else if(num.equals("[2]")) {
                findMinMax();
            } else if(num.equals("[3]")) {
                countNumbers();
            }
            System.out.println("Thread " + num + " finished!");
        }catch (Exception e){}
    }

    private static boolean isAlpha(String s) {

        for(int i = 0; i < s.length(); i++){
            if(!Character.isLetter(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "RunnableArrayList{" +
                "a=" + a +
                '}';
    }
}
