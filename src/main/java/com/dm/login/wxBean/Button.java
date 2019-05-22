package com.dm.login.wxBean;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class Button {
    List<BasisButton> button = new ArrayList<>();
}
