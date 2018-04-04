/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmware.preverificationsuite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mrizwan
 */
public class adbCommand {
    StringBuilder error;
    StringBuilder output;
    
    adbCommand(){
        error = new StringBuilder();
        output = new StringBuilder();
    }
      
public adbCommand runcommand(ProcessBuilder pb){
    
    adbCommand result= new adbCommand();
    
    try {
            Process pc;
            pc = pb.start();
//            pc0.waitFor();
            BufferedReader reader = new BufferedReader(
            new InputStreamReader(pc.getInputStream()));

            BufferedReader error = new BufferedReader(
            new InputStreamReader(pc.getErrorStream()));

            int read;
            char[] buffer = new char[4096];
            
            while ((read = reader.read(buffer)) > 0) {
            result.output.append(buffer, 0, read);
            }reader.close();

            
            while ((read = error.read(buffer)) > 0) {
                result.error.append(buffer, 0, read);
            }error.close();

// Waits for the command to finish.
            pc.waitFor();

            return result;
       
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(PreVerificationSuite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

}
}
