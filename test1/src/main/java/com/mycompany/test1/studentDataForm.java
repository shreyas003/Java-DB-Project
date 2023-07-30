/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Lenovo
 */
public class studentDataForm extends javax.swing.JFrame {

    /**
     * Creates new form studentDataForm
     */
    public studentDataForm() {
        initComponents();
        show_student();
    }
    
    public ArrayList<Student> studentList(){
        ArrayList<Student> studentList = new ArrayList<>();
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://DESKTOP-NRCT8RH\\SQLEXPRESS;databaseName=dbProject;integratedSecurity=true"; 
            Connection con = DriverManager.getConnection(connectionUrl);
            
            String query = "SELECT * FROM Students";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Student student;
            
            while(rs.next()){
                //errors may occur here. check while testing. note: constraints have been added in sql db. might interfere with inserts.
                student = new Student(rs.getString("[Student ID]"), rs.getString("Name"), rs.getString("[Date of Birth]"), rs.getString("Branch"), rs.getString("[Phone number]"), rs.getString("[Email ID]"));
                studentList.add(student);
            }

        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return studentList;
    }
    
    public void show_student(){
        ArrayList<Student> list = studentList();
        DefaultTableModel model = (DefaultTableModel)jTable_students.getModel();
        Object[] row = new Object[6];
        
        for(int i=0; i<list.size(); i++){
            row[0]=list.get(i).getStudentID();
            row[1]=list.get(i).getName();
            row[2]=list.get(i).getDob();
            row[3]=list.get(i).getBranch();
            row[4]=list.get(i).getPhoneNumber();
            row[5]=list.get(i).getEmailId();
            model.addRow(row);
        }
        
    }
    
    public boolean val_Fields(){
        return (IdEmptyLabel.getText().contentEquals("") && NameEmptyLabel.getText().contentEquals("") && emailValLabel.getText().contentEquals("") && phoneValLabel.getText().contentEquals(""));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        studentId = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        dob = new javax.swing.JTextField();
        branch = new javax.swing.JTextField();
        phoneNumber = new javax.swing.JTextField();
        emailId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_students = new javax.swing.JTable();
        insertBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        IdEmptyLabel = new javax.swing.JLabel();
        NameEmptyLabel = new javax.swing.JLabel();
        emailValLabel = new javax.swing.JLabel();
        phoneValLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Student ID :");

        jLabel2.setText("Name :");

        jLabel3.setText("Date of Birth :");

        jLabel4.setText("Branch :");

        jLabel5.setText("Phone number :");

        jLabel6.setText("Email ID :");

        studentId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                studentIdKeyReleased(evt);
            }
        });

        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameKeyReleased(evt);
            }
        });

        phoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phoneNumberKeyReleased(evt);
            }
        });

        emailId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailIdKeyReleased(evt);
            }
        });

        jTable_students.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Name", "Date of Birth", "Branch", "Phone number", "Email ID"
            }
        ));
        jTable_students.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_studentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_students);

        insertBtn.setText("Insert");
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        backBtn.setText("Back");

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        jLabel7.setText("Search :");

        IdEmptyLabel.setForeground(new java.awt.Color(255, 51, 51));

        NameEmptyLabel.setForeground(new java.awt.Color(255, 51, 51));

        emailValLabel.setForeground(new java.awt.Color(255, 0, 0));

        phoneValLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(insertBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel6))
                            .addComponent(jLabel5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(dob)
                            .addComponent(branch)
                            .addComponent(phoneNumber)
                            .addComponent(emailId)
                            .addComponent(studentId)
                            .addComponent(search)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phoneValLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailValLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NameEmptyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IdEmptyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(studentId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(IdEmptyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(2, 2, 2)
                .addComponent(NameEmptyLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phoneValLabel)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(emailId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(emailValLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertBtn)
                    .addComponent(updateBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(deleteBtn))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_studentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_studentsMouseClicked
        // TODO add your handling code here:
        int i = jTable_students.getSelectedRow();
        TableModel model = jTable_students.getModel();
        studentId.setText(model.getValueAt(i, 0).toString());
        name.setText(model.getValueAt(i, 1).toString());
        dob.setText(model.getValueAt(i, 2).toString());
        branch.setText(model.getValueAt(i, 3).toString());
        phoneNumber.setText(model.getValueAt(i, 4).toString());
        emailId.setText(model.getValueAt(i, 5).toString());
    }//GEN-LAST:event_jTable_studentsMouseClicked

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        // TODO add your handling code here:
        // add data validation for phone number and email and student id. refer below templates.
        /*
        -> for checking if empty do textField.gettext.trim.isempty() to chekc if empty. add a label to say field empty.
        -> use key released on the text field to set label to nothing, due to text now present
        
        -> for checking if given text is  phone number. do textField.trim.length == 10
        -> for checking if numbers are entered use 
            String text = this.getText();
                try {
                    double d = Double.parseDouble(text); 
                    // or Integer.parseInt(text), etc.
                    // OK, valid number.
                } 
                catch (NumberFormatException nfe) {
                        // Not a number.
                        set label to say please enter a valid number.
                }
        
        -> for checking vaild email do textField.getText().Contains("@") and contains(".com (or) .in (or) .net [etc]")
        */
        
        /*
        IMPORTANT: INSTEAD OF ADDING VALIDATION IN THE FUNCTION MAKE IT AT KEYRELEASED EVENT  OF THE RESPECTIVE FIELD
        
        WHEN FUNCTIONS CALLED MAKE AN IF CONDITION CHECKING IF LABELS ARE EMPTY OR NOT. IF LABELS NOT EMPTY DISPLAY ERROR MESSAGE
        IF LABELS ARE EMPTY PROCEED TO TRY CATCH EXECUTION
        
        CURRENTLY THIS IS THE BEST COURSE OF ACTION I CAN PERCIEVE. 
        */
        
        
        if(val_Fields()){
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String connectionUrl = "jdbc:sqlserver://DESKTOP-NRCT8RH\\SQLEXPRESS;databaseName=dbProject;integratedSecurity=true"; 
                Connection con = DriverManager.getConnection(connectionUrl);

                String query = "insert into students([Student ID], Name, [Date of Birth], Branch, [Phone number], [Email ID])values(?,?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, studentId.getText());
                pst.setString(2, name.getText());
                pst.setString(3, dob.getText());
                pst.setString(4, branch.getText());
                pst.setString(5, phoneNumber.getText());
                pst.setString(6, emailId.getText());

                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel)jTable_students.getModel();
                model.setRowCount(0);
                show_student();
                JOptionPane.showMessageDialog(null,"Inserted successfully");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Please make sure there are no errors and try again!");
        }
    }//GEN-LAST:event_insertBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        if(val_Fields()){
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String connectionUrl = "jdbc:sqlserver://DESKTOP-NRCT8RH\\SQLEXPRESS;databaseName=dbProject;integratedSecurity=true"; 
                Connection con = DriverManager.getConnection(connectionUrl);

                int row = jTable_students.getSelectedRow();
                String value = (jTable_students.getModel().getValueAt(row, 0).toString());
                //errors may happen here. also should we keep student id editable?
                String query = "UPDATE students SET Name=?, Date of Birth=?, Branch=?, Phone number=?, Email ID=? WHERE Student ID ="+value;

                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, studentId.getText());
                pst.setString(2, name.getText());
                pst.setString(3, dob.getText());
                pst.setString(4, branch.getText());
                pst.setString(5, phoneNumber.getText());
                pst.setString(6, emailId.getText());

                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel)jTable_students.getModel();
                model.setRowCount(0);
                show_student();
                JOptionPane.showMessageDialog(null,"Updated successfully");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Please make sure there are no errors and try again!");
        } 
        
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete?","Delete",JOptionPane.YES_NO_OPTION);
        if(opt==0){
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String connectionUrl = "jdbc:sqlserver://DESKTOP-NRCT8RH\\SQLEXPRESS;databaseName=dbProject;integratedSecurity=true"; 
                Connection con = DriverManager.getConnection(connectionUrl);
            
                int row = jTable_students.getSelectedRow();
                String value = (jTable_students.getModel().getValueAt(row, 0).toString());
            
                String query = "DELETE * FROM Students where [Student ID]="+value;
                PreparedStatement pst = con.prepareStatement(query);
                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel)jTable_students.getModel();
                model.setRowCount(0);
                show_student();
                JOptionPane.showMessageDialog(null,"Deleted successfully!");
            
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        // TODO add your handling code here:
        try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String connectionUrl = "jdbc:sqlserver://DESKTOP-NRCT8RH\\SQLEXPRESS;databaseName=dbProject;integratedSecurity=true"; 
                Connection con = DriverManager.getConnection(connectionUrl);
                
                String query = "Select from Students where sno = ?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, search.getText());
                ResultSet rs = pst.executeQuery();
                
                if(rs.next()){
                    
                    String sID = rs.getString("[StudentID]");
                    studentId.setText(sID);
                    
                    String sName = rs.getString("Name");
                    name.setText(sName);
                    
                    String sDob = rs.getString("[Date of Birth]");
                    dob.setText(sDob);
                    
                    String sBranch = rs.getString("Branch");
                    branch.setText(sBranch);
                    
                    String sPhone = rs.getString("[Phone number]");
                    name.setText(sPhone);
                    
                    String sEmail = rs.getString("[Email ID]");
                    name.setText(sEmail);
                    
                }
        }
        catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
    }//GEN-LAST:event_searchKeyReleased

    private void studentIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentIdKeyReleased
        // TODO add your handling code here:
        if(studentId.getText().trim().isEmpty()){
            IdEmptyLabel.setText("Student ID cannot be empty");
        }
        else{
            IdEmptyLabel.setText("");
        }
    }//GEN-LAST:event_studentIdKeyReleased

    private void nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyReleased
        // TODO add your handling code here:
        if(name.getText().trim().isEmpty()){
            NameEmptyLabel.setText("Name cannot be empty");
        }
        else{
            NameEmptyLabel.setText("");
        }
    }//GEN-LAST:event_nameKeyReleased

    private void emailIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailIdKeyReleased
        // TODO add your handling code here:
        if( !(emailId.getText().contains("@")) || !(emailId.getText().contains(".com")) || !(emailId.getText().trim().contains(" "))){
                emailValLabel.setText("Enter valid Email ID");
        }
        else{
            emailValLabel.setText("");
        }
    }//GEN-LAST:event_emailIdKeyReleased

    private void phoneNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberKeyReleased
        // TODO add your handling code here:
        String text = phoneNumber.getText();
                try {
                    double d = Double.parseDouble(text); 
                    // or Integer.parseInt(text), etc.
                    // OK, valid number.
                    if(text.length()==10){
                       phoneValLabel.setText("");
                    }
                    else{
                        phoneValLabel.setText("Please enter valid number");
                    }
                } 
                catch (NumberFormatException nfe) {
                        // Not a number.
                    phoneValLabel.setText("Please enter valid phone number");
                }
        
    }//GEN-LAST:event_phoneNumberKeyReleased

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
            java.util.logging.Logger.getLogger(studentDataForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentDataForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentDataForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentDataForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentDataForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IdEmptyLabel;
    private javax.swing.JLabel NameEmptyLabel;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField branch;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField dob;
    private javax.swing.JTextField emailId;
    private javax.swing.JLabel emailValLabel;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_students;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phoneNumber;
    private javax.swing.JLabel phoneValLabel;
    private javax.swing.JTextField search;
    private javax.swing.JTextField studentId;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
