package org.CopiasCertificadas.view.validate;

public class ValidationMessagePublish {
    private String message;

    public ValidationMessagePublish(String message)
    {
        this.message= message;
    }

    public ValidationMessagePublish()
    {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}