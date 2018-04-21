package org.CopiasCertificadas.view.validate;


import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;

import java.util.List;

public class ValidationPublishVM {

    private List<ValidationMessagePublish> allMessages = null;

    
    public List<ValidationMessagePublish> getAllMessages() {
        return allMessages;
    }

    public void setAllMessages(List<ValidationMessagePublish> allMessages) {
        this.allMessages = allMessages;
    }
    
    @Init
    public void init(@ExecutionArgParam("vList") List<ValidationMessagePublish> vList) {
        setAllMessages(vList);
    }

}
