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

public String runCommand(String[] processPath,String Path, String classname, String apkname){
        
        try {
            //adb shell am instrument -w -r   -e debug false -e class
            ProcessBuilder pb0 = new ProcessBuilder(processPath[0],processPath[1],Path+"/AdbFiles/adb shell am instrument -w -r -e debug false -e class "+classname+" "+apkname);
            Process pc0;
        
            pc0 = pb0.start();
//            pc0.waitFor();
            BufferedReader reader = new BufferedReader(
            new InputStreamReader(pc0.getInputStream()));

            BufferedReader error = new BufferedReader(
            new InputStreamReader(pc0.getErrorStream()));

            int read;
            char[] buffer = new char[4096];
            StringBuilder output = new StringBuilder();
            while ((read = reader.read(buffer)) > 0) {
            output.append(buffer, 0, read);
            }reader.close();

            StringBuilder err = new StringBuilder();
            while ((read = error.read(buffer)) > 0) {
                err.append(buffer, 0, read);
            }error.close();

// Waits for the command to finish.
            pc0.waitFor();
            if(((output.toString()).contains("FAILURES")||(output.toString()).contains("INSTRUMENTATION_FAILED")||(output.toString()).contains("Unable to find instrumentation"))){
                return (output.toString());
            }else{
            return ("Pass");
            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(PreVerificationSuite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Error";
    }
}
