package com.didispace.charpter11.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CustomRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println(" RequestListener tInitialized=======");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println(" requestListener destroyed=======");
    }
}
