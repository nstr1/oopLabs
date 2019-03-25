import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class Container implements Iterable<String>, Serializable{
    private String[] data;
    private int len = 0;

    Container(int size){
        if(size > 0){
            data = new String[1];
        } else {
            System.out.println("Please enter a valid size");
        }
    }

    public String toString(){
        StringBuilder line = new StringBuilder();
        for(int i = 0; i  < len; i++) {
            line.append(data[i]);
            line.append(" ");
        }
        return new String(line);
    }

    void add(String string){
        data[len++] = string;
        data = Arrays.copyOf(data, data.length + 1);
    }

    void clear(){
        for(int i = 0; i < len; i++){
            data[i] = null;
        }
        len = 0;
    }

    boolean remove(String string) {
        for (int i = 0; i < len; i++) {
            if (string.equals(data[i])) {
                len--;
                if (len - i >= 0) System.arraycopy(data, i + 1, data, i, len - i);
                data[len] = null;
                return true;
            }
        }
        return false;
    }

    Object[] toArray(){
        String[] tmp = new String[data.length];
        System.arraycopy(data, 0, tmp, 0, len);
        return tmp;
    }

    int size(){
        return  len;
    }

    boolean contains(String string)
    {
        for(int i = 0; i < len; i++){
            if(data[i].equals(string))
            {
                return true;
            }
        }
        return false;
    }

    void serialize(String filename, Container c)
    {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try
        {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(c);

            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    Container deserialize(String filename) {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            Container c = (Container) in.readObject();
            in.close();
            return c;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    void find(String s) {
        for (int i = 0; i < len; i++) {
            if (s.equals(data[i])) {
                System.out.println("Found at [" + i + "]");
            }
        }
    }

    void sort() {
        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data.length - i-1; j++)
                if (data[i].compareTo(data[j]) > 0)
                {
                    String temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
    }

    void compare(int in1, int in2) {
        if(data[in1].compareTo(data[in2]) > 0){
            System.out.println("[" + data[in1] + "] is smaller than [" + data[in2] + "]");
        } else if (data[in1].compareTo(data[in2]) < 0) {
            System.out.println("[" + data[in1] + "] is greater than [" + data[in2] + "]");
        } else {
            System.out.println("They are equal");
        }

    }
    @Override
    public Iterator<String> iterator() {
        return new CustomIterator(data);
    }
}
