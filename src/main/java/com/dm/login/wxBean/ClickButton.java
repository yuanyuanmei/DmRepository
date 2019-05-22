package com.dm.login.wxBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ClickButton extends BasisButton{

    private String type = "click";

    private String key;

    public ClickButton(String name,String key){
        super(name);
        this.key = key;
    }
}
