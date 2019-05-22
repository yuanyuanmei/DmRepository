package com.dm.login.wxBean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SubButton extends BasisButton{
    private List<BasisButton> sub_button = new ArrayList<>();

    public SubButton(String name){
        super(name);
    }
}
