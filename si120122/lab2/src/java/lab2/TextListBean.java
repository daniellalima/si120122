package lab2;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("textList")
@SessionScoped
public class TextListBean implements Serializable {
    private TextList textList;
    
    public TextListBean() {
        textList = new TextList();
        
        textList.addText("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20");
        textList.addText("a b c d e f g h i j k l m n o p q");
    }

    public TextList getTextList() {
        return textList;
    }
}
