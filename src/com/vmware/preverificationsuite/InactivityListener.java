/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmware.preverificationsuite;

import java.awt.AWTEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 *
 * @author mrizwan
 */

public class InactivityListener implements ActionListener {

    private static final int SESSION_TIMEOUT = 60* 60* 1000; // 60 mins in milliseconds
    private final Timer invalidationTimer = new Timer(SESSION_TIMEOUT, this);
    private final JFrame frm = new JFrame();
    /**
     * 
     */
    public InactivityListener() {
        initUI();
    }

    private void initUI() {
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        invalidationTimer.setRepeats(false);
        invalidationTimer.restart();

        // register listener to get all mouse/key events
        final AWTEventListener l = new AWTEventListener() {

            @Override
            public void eventDispatched(AWTEvent event) {
                // if any input event invoked - restart the timer to prolong the session
                invalidationTimer.restart();
            }
        };
        Toolkit.getDefaultToolkit().addAWTEventListener(l, AWTEvent.KEY_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JLabel label = new JLabel("Your session has Expired. Please Launch Again");
        label.setFont(new Font("Tahoma", Font.PLAIN, 24));
        JOptionPane.showMessageDialog(frm, label,"Session Expired" , JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
}
