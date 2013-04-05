package lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RandomMethod implements Method {
    @Override
    public Iterator<String> recombine(List<String> phrases) {
        ArrayList<String> result = new ArrayList<String>(phrases);
        Collections.shuffle(result);
        return result.iterator();
    }
}
