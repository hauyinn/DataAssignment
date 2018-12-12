/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import domain.Customer;
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
 * @author ASUS
 */
public class addCredit extends javax.swing.JFrame {
 private String user = "nbuser";
    private String password = "nbuser";
   
    /**
     * Creates new form addCredit
     */
    public addCredit() {
        initComponents();
          show_customer();
         
    }
    
public ArrayList<Customer> customerList(){
    ArrayList<Customer> customerList = new ArrayList<>();
    try{
        String host = "jdbc:derby://localhost:1527/customer";
        Connection conn = DriverManager.getConnection(host,user, password);
        String query1 = "SELECT * FROM customer";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query1);
        Customer customer;
        
        while(rs.next()){
        customer = new Customer(rs.getString("customer_id"),rs.getString("customer_name"), rs.getString("Contact_no"),rs.getString("customer_company"),rs.getString("customer_type"),rs.getInt("credit_limit"));
        customerList.add(customer);
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    return customerList;
    }

 public void show_customer(){
     
    ArrayList<Customer> list = customerList();
    DefaultTableModel model = (DefaultTableModel)cust_table.getModel();
    Object[] row = new Object[7];
    for(int i =0 ; i<list.size(); i++){
        if(list.get(i).getCustomerType().equalsIgnoreCase("corporate") && list.get(i).getCreditLimit()<3000){
    row[0]=list.get(i).getCustomerId();
    row[1]=list.get(i).getCustomerName();
    row[2]=list.get(i).getContactNo();
    row[3]=list.get(i).getCustomerCompany();
    row[4]=list.get(i).getCustomerType();
    row[5]=list.get(i).getCreditLimit();
    model.addRow(row);
    }
    }
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cust_name = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cust_table = new javax.swing.JTable();
        cust_contact = new javax.swing.JTextField();
        cust_company = new javax.swing.JTextField();
        cust_id = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        credit_limit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Contact No");

        jLabel8.setText("Example");

        jLabel4.setText("Company name (if corparate)");

        jLabel9.setText("Allen Yong");

        cust_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cust_nameActionPerformed(evt);
            }
        });

        update.setText("Pay");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jLabel1.setText("Credit Limit");

        cust_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Contact No ", "Company", "Type", "Credit Limit"
            }
        ));
        cust_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cust_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cust_table);

        cust_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cust_idActionPerformed(evt);
            }
        });

        jLabel6.setText("Customer ID");

        jLabel2.setText("Customer Name");

        credit_limit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                credit_limitActionPerformed(evt);
            }
        });

        jLabel7.setText("016-2311231");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cust_id)
                            .addComponent(cust_name)
                            .addComponent(cust_contact)
                            .addComponent(cust_company, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(credit_limit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(464, 464, 464)
                        .addComponent(update)))
                .addContainerGap(361, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel8)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cust_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cust_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cust_contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cust_company, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(credit_limit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(update)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cust_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cust_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cust_nameActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        
        try{
            credit_limit.setText("3000");
            String host = "jdbc:derby://localhost:1527/customer";
            Connection conn = DriverManager.getConnection(host,user, password);
            int row = cust_table.getSelectedRow();
            String value = (cust_table.getModel().getValueAt(row,0).toString());
            String query = "UPDATE customer SET customer_id=?, customer_name=?, contact_no=?, customer_company=?, credit_limit=? where customer_id=?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, cust_id.getText());
            pst.setString(2, cust_name.getText());
            pst.setString(3, cust_contact.getText());
            pst.setString(4, cust_company.getText());
            int a=Integer.parseInt(credit_limit.getText());
            pst.setInt(5, a);
         
            pst.setString(6, cust_id.getText());

            if(cust_id.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter an ID!");
            }else if(cust_name.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter Name!");
            }else if(cust_contact.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter Contact Number!");
            
            }else    {
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Customer Paid");
                DefaultTableModel model = (DefaultTableModel)cust_table.getModel();
                model.setRowCount(0);
                show_customer();
                addCredit f3 = new addCredit();
                f3.setVisible(true);
                dispose();
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void cust_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cust_tableMouseClicked
        int i = cust_table.getSelectedRow();
        TableModel model = cust_table.getModel();
        cust_id.setText(model.getValueAt(i, 0).toString());
        cust_name.setText(model.getValueAt(i, 1).toString());
        cust_contact.setText(model.getValueAt(i, 2).toString());
        cust_company.setText(model.getValueAt(i, 3).toString());
        credit_limit.setText(model.getValueAt(i, 5).toString());
        cust_id.setEditable(false);
        cust_name.setEditable(false);
        cust_contact.setEditable(false);
        cust_company.setEditable(false);
        credit_limit.setEditable(false);
    }//GEN-LAST:event_cust_tableMouseClicked

    private void cust_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cust_idActionPerformed
         
// TODO add your handling code here:
    }//GEN-LAST:event_cust_idActionPerformed

    private void credit_limitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_credit_limitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_credit_limitActionPerformed

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
            java.util.logging.Logger.getLogger(addCredit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addCredit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addCredit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addCredit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addCredit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField credit_limit;
    private javax.swing.JTextField cust_company;
    private javax.swing.JTextField cust_contact;
    private javax.swing.JTextField cust_id;
    private javax.swing.JTextField cust_name;
    private javax.swing.JTable cust_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}