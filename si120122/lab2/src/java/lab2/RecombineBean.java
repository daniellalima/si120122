package lab2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("recombineBean")
@SessionScoped
public class RecombineBean implements Serializable {
    private String text = "";
    private List<String> methods;
    private String method, recombinedText;
    private Iterator<String> methodIterator = null;
    @Inject
    private TextListBean textListBean;

    public RecombineBean() {
        methods = new ArrayList<String>();
        methods.add("aleatoria sem repeticao");
        methods.add("aleatoria com repeticao");
        methods.add("inversa");
        method = "inversa";
    }

    public String getText() {
        if (text.equals("") && !textListBean.getTextList().getTexts().isEmpty())
            text = textListBean.getTextList().getTexts().get(0);
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getMethods() {
        return methods;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    
    public String getMethod() {
        return method;
    }

    public String getRecombinedText() {
        return recombinedText;
    }
    
    public String addLine() {
        if (methodIterator != null && methodIterator.hasNext())
            recombinedText += methodIterator.next() + "\n";
        return "";
    }

    public boolean getCantAddLine() {
        return methodIterator == null || !methodIterator.hasNext();
    }
    
    public List<String> splitText(String text) {
        ArrayList<String> result = new ArrayList<String>();
        String[] words = text.split(" ");
        
        for (int i = 0; i < words.length; i += 10) {
            String line = "";
            for (int j = 0; j < 10; j++)
                if (i+j < words.length) {
                    if (j > 0)
                        line += " ";
                    line += words[i+j];
                }
            result.add(line);
        }
        
        return result;
    }
    
    public String makePreview(String text) {
        String preview = "";
        String[] words = text.split(" ");
        
        for (int i = 0; i < 12; i++)
            if (i < words.length) {
                preview = preview + words[i] + " ";
            }
        
        return preview;
    }
    
    public String start() {
        recombinedText = "";
        
        Method methodObj;
        
        if (method.equals("aleatoria sem repeticao"))
            methodObj = new RandomMethod();
        else if (method.equals("aleatoria com repeticao"))
            methodObj = new RandomRepetitiveMethod();
        else
            methodObj = new ReverseMethod();
        
        methodIterator = methodObj.recombine(splitText(text));

        return "recombine2";
    }
}
