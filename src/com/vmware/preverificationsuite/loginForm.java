/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmware.preverificationsuite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author mrizwan
 */
public class loginForm extends javax.swing.JFrame {

        /**
     * Creates new form loginForm
     */
    public loginForm() {
        initComponents();
        setLocationRelativeTo(null) ;
        addWindowListener(new WindowAdapter() {  
            @Override
            public void windowClosing(WindowEvent e) {  
                System.exit(0);  
            }  
        });
                
        addWindowListener(new WindowAdapter() {  
            @Override
            public void windowClosing(WindowEvent e) {  
                System.exit(0);  
            }  
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PreVerificationSuite().dispose();
                System.exit(0);
            }
        });//To change body of generated methods, choose Tools | Templates.
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        urlLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        urlTextField = new javax.swing.JTextField();
        passwordText = new javax.swing.JPasswordField();
        userName = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pre-Verification Suite Login");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Enter the Credentials to Login");

        urlLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        urlLabel.setText("URL");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("User Name");

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        passwordLabel.setText("Password");

        urlTextField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        passwordText.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        userName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        loginButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cancelButton.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(urlLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(urlTextField)
                            .addComponent(userName)
                            .addComponent(passwordText)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urlLabel)
                    .addComponent(urlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordLabel)
                    .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginButton)
                    .addComponent(cancelButton))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        Executor executor = java.util.concurrent.Executors.newSingleThreadExecutor();
                executor.execute(new Runnable(){
                @Override
                public void run(){
                    logindetails.clear();
                    loginButton.setText("Logging In....");
                    urlTextField.setEnabled(false);
                    userName.setEnabled(false);
                    loginButton.setEnabled(false);
                    passwordText.setEnabled(false);
                    cancelButton.setEnabled(false);
                    /*Saving all the user details in ArrayList as below
                    0th:URL, 1st:GroupID, 2nd:username, 3rd:password, 4th:tenantCode */
                    String url = urlTextField.getText();
                    if(!url.startsWith("https://")){
                        url = "https://"+url;
                    }
                    logindetails.add(0,url);//Saving URl at 0th index
                    logindetails.add(1,"");
                    logindetails.add(2,userName.getText());//Saving Username at 1st index
                    logindetails.add(3,String.valueOf(passwordText.getPassword()));//Saving password at 1st index
                    String body = "{\"userName\":\""+logindetails.get(2)+"\",\"password\":\""+logindetails.get(3)+"\"}";    
                    try { 
                        //Getting GroupID and Tenant Code 
                        int urlResponse =checkAdmin(logindetails.get(0),body);
                        switch (urlResponse) {
                            case 200:
                                JSONParsingGroupIDandTenantCode(jsonResponse);
                                //Getting GroupName
                                JSONParsingGroupName(makeHttpRequest(logindetails.get(0)));
                                new PreVerificationSuite(logindetails).setVisible(true);
                                setVisible(false);
                                break;
                            case 500:
                            case 400:
                            case 401:
                                JOptionPane.showMessageDialog(null, "Invalid username or password", "Error: " , JOptionPane.ERROR_MESSAGE);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Server not reachable. Please Enter Valid URL", "Error: " , JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                        loginButton.setText("Login");     
                        urlTextField.setEnabled(true);
                        userName.setEnabled(true);
                        passwordText.setEnabled(true);
                        loginButton.setEnabled(true);
                        cancelButton.setEnabled(true);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Error: " , JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
                }    
               }
        });
    }//GEN-LAST:event_loginButtonActionPerformed
         
    private int checkAdmin(String Url,String body) throws IOException {
        String responseBody = null;
        int response =0;
        URL requestURL = new URL(Url+"/api/system/admins/session");
        StringBuilder requestBodyBuilder = new StringBuilder();
        String requestBody = requestBodyBuilder.toString();

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setReadTimeout(20000 /* milliseconds */);
            urlConnection.setConnectTimeout(30000 /* milliseconds */);
            urlConnection.setRequestProperty("Content-Length", "" + Integer.toString(requestBody.getBytes().length));
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
                OutputStream os = urlConnection.getOutputStream();
                os.write(body.getBytes());
                os.flush();
                try (DataOutputStream sendData = new DataOutputStream(urlConnection.getOutputStream())) {
                   sendData.writeBytes(requestBody);
                    sendData.flush();
                  } catch (IOException ex) {
                    Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            response =  urlConnection.getResponseCode();   
            if (response == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } 
        } catch (IOException e) {
            Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, e);
            return response;
        }
        finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return response;
    }
    
    private String makeHttpRequest(String URL) throws IOException {
        String authString = logindetails.get(2)+":"+logindetails.get(3);  
        byte[] authEncBytes = Base64.getEncoder().encode(authString.getBytes());
	String authStringEnc = new String(authEncBytes);
        String responseBody = null;
		      
        URL requestURL = new URL(URL+"/api/system/groups/"+logindetails.get(1));
        StringBuilder requestBodyBuilder = new StringBuilder();
        String requestBody = requestBodyBuilder.toString();

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setReadTimeout(20000 /* milliseconds */);
            urlConnection.setConnectTimeout(30000 /* milliseconds */);
            urlConnection.setRequestProperty("Content-Length", "" + Integer.toString(requestBody.getBytes().length));
            urlConnection.setRequestProperty("Authorization", "Basic " +authStringEnc);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("aw-tenant-code", logindetails.get(4));
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } 
        } catch (IOException e) {
            
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }
    
    private void JSONParsingGroupIDandTenantCode(String json){
        try {
            JSONObject baseJsonResponse = new JSONObject(json);
            logindetails.set(1,String.valueOf(baseJsonResponse.getInt("organizationGroupId")));
            JSONObject tenantObject =baseJsonResponse.getJSONObject("adminInfo");
            logindetails.add(4,tenantObject.getString("tenantKey"));             
        } catch (JSONException ex) {
            Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void JSONParsingGroupName(String json){
        try {
            JSONObject baseJsonResponse = new JSONObject(json);
            logindetails.set(1,baseJsonResponse.getString("GroupId"));
        } catch (JSONException ex) {
            Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginForm().setVisible(true);
            }
        });
    }
    
    ArrayList<String> logindetails = new ArrayList<String>();
    String jsonResponse = "";

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JLabel urlLabel;
    private javax.swing.JTextField urlTextField;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
