package lab2;

import java.util.Iterator;
import java.util.List;

public class RandomRepetitiveMethod implements Method {

    @Override
    public Iterator<String> recombine(final List<String> phrases) {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public String next() {
                return phrases.get((int)Math.floor(Math.random() * phrases.size()));
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
