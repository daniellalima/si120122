package lab2;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("text")
@SessionScoped
public class TextBean implements Serializable {

    private String value = "";
    @Inject
    private TextListBean textListBean;

    public String getValue() {
        return value;
    }

    private void setValue(String value) {
        this.value = value;
    }

    public String register() {
        textListBean.getTextList().addText(value);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Texto adicionado!"));
        return "index";
    }
}
