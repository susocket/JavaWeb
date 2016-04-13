/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wrox;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author UUU
 */
@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionIdListener{
    
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(this.date() + ": Session " + se.getSession().getId() + " created.");
        SessionRegistry.addSession(se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(this.date() + ": Session " + se.getSession().getId() + " destroyed.");
        SessionRegistry.removeSession(se.getSession());
    }

    @Override
    public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
        System.out.println( this.date() + ": Session ID" + oldSessionId + " changed to " + event.getSession().getId());
        SessionRegistry.updateSessionId(event.getSession(), oldSessionId);
    }
    
    private String date(){
        return this.formatter.format(new Date());
    }
}
