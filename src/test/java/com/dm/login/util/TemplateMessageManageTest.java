package com.dm.login.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class TemplateMessageManageTest {
    @Test
    public void set(){
        TemplateMessageManage.set();
    }

    @Test
    public void get() {
        TemplateMessageManage.get();
    }

    @Test
    public void send() {
        TemplateMessageManage.send();
    }
}