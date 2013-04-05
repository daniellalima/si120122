package lab2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReverseMethod implements Method {
    @Override
    public Iterator<String> recombine(List<String> phrases) {
        ArrayList<String> resultList = new ArrayList<String>();
        for (int i = phrases.size()-1; i >= 0; i--)
            resultList.add(phrases.get(i));
        return resultList.iterator();
    }
}
