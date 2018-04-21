package org.CopiasCertificadas.view.validate;
import java.util.HashMap;
import java.util.List;
import org.zkoss.zk.ui.Executions;


public class showWindow {
    public static void ShowValidation( List<ValidationMessagePublish> vList) {
    	
        final HashMap<String, Object> map = new HashMap<String, Object>();
        
        map.put("vList", vList);
        
        Executions.createComponents("/copias/validate/validate.zul", null, map);
        
    }
}