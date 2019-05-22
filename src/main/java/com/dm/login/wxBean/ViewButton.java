package com.dm.login.wxBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ViewButton extends BasisButton{
    private String type = "view";
    private String url;

    public ViewButton(String name,String url){
        super(name);
        this.url = url;
    }

}
