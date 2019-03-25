import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CustomIterator implements Iterator<String> {
    private  ArrayList data;
    private int index = 0;

    CustomIterator(String[] data)
    {
        this.data = new ArrayList<String>(Arrays.asList(data));
    }

    @Override
    public boolean hasNext() {
        return (data.size() >= index + 1);
    }

    @Override
    public String next() {
        return (String) data.get(index++);
    }

    @Override
    public void remove() {
        data.remove(index++);
    }
}
