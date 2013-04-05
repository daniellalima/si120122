package lab2;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class TextList {
    private List<String> texts;

    public TextList() {
        texts = new ArrayList<String>();
    }

    public List<String> getTexts() {
        return texts;
    }
    
    public void addText(String text) {
        texts.add(0, text);
    }
}
