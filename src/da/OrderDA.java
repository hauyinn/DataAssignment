/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;
import Domain.Orderdetail;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yong
 */
public class OrderDA {
    private String host = "jdbc:derby://localhost:1527/orderdetail";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "ORDERDETAILS";
    private Connection conn;
    private PreparedStatement stmt;
    
     public OrderDA() {
        createConnection();
    }
     
      public Orderdetail getRecord(String DETAILID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE DETAILID = ?";
        Orderdetail orderRecord = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, DETAILID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                orderRecord = new Orderdetail(rs.getString("DETAILID"), rs.getString("ORDERID"), rs.getString("CUSTOMERID"), rs.getString("CUSTOMERNAME"), rs.getString("FLOWERTYPE"), rs.getString("ORDERDATE"), rs.getString("DELIVERYDATE"),rs.getString("PICKUPDATE"), rs.getInt("QUANTITY"), rs.getDouble("PRICE"), rs.getString("ADDRESS"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return orderRecord;
    }
      
         public void addRecord(Orderdetail addOrder){
           
            try{
                    String insertStr="INSERT INTO "+tableName+" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    stmt=conn.prepareStatement(insertStr);
                    stmt.setString(1, addOrder.getDetailid());
                    stmt.setString(2, addOrder.getOrderid());
                    stmt.setString(3, addOrder.getCustomerid());
                    stmt.setString(4, addOrder.getCustomername());
                    stmt.setString(5, addOrder.getFlowertype());
                    stmt.setString(6, addOrder.getOrderdate());
                    stmt.setString(7, addOrder.getDeliverydate());
                    stmt.setString(8, addOrder.getPickupdate());
                    stmt.setInt(9, addOrder.getQuantity());
                    stmt.setDouble(10, addOrder.getPrice());
                    stmt.setString(11, addOrder.getAddress());
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "New Order Added!");
                                      
                }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            }
    }
         
          public List<Orderdetail> getAllRecord(){
   
        String queryStr = "SELECT * FROM " + tableName;
        List<Orderdetail> orderList= new ArrayList<Orderdetail>();
        Orderdetail OrderR = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
               OrderR = new Orderdetail(rs.getString("DETAILID"), rs.getString("ORDERID"), rs.getString("CUSTOMERID"), rs.getString("CUSTOMERNAME"), rs.getString("FLOWERTYPE"), rs.getString("ORDERDATE"), rs.getString("DELIVERYDATE"), rs.getString("PICKUPDATE"), rs.getInt("QUANTITY"), rs.getDouble("PRICE"), rs.getString("ADDRESS"));
               orderList.add(OrderR);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return orderList;
    }
         
      
      private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }


}
