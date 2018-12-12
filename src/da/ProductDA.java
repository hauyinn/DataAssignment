/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import domain.Product;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author AL
 */
public class ProductDA {
    private String host = "jdbc:derby://localhost:1527/FlowerDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Product";
    private Connection conn;
    private PreparedStatement stmt;
    
    public ProductDA(){
    createConnection();
    }
    
    public void addRecord(Product p){
           
            try{
                    String insertStr="INSERT INTO "+tableName+" VALUES(?, ?, ?, ?, ? )";
                    stmt=conn.prepareStatement(insertStr);
                    stmt.setString(1, p.getProductname());
                    stmt.setString(2, p.getProductdesciption());
                    stmt.setInt(3, p.getQuantity());
                    stmt.setString(4,p.getProducttype());
                    stmt.setDouble(5, p.getProductprice());
                    stmt.executeUpdate();
                    
                }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            }
    }
    
    public List<Product> getAllRecord() {
            String queryStr = "SELECT * FROM " + tableName;
            List<Product> pList=new ArrayList<Product>();
            Product pRecord = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {                
                pRecord = new Product(rs.getString("ProductNAME"), rs.getString("PRODUCTDESCRIPTION"),rs.getInt("QUANTITY"), rs.getString("PRODUCTTYPE"),rs.getDouble("PRODUCTPRICE") );
                pList.add(pRecord);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return pList;
    }
    
              public Product getAllSelectedRecordViaProductName(String productName) {
            String queryStr = "SELECT * FROM " + tableName+" WHERE PRODUCTNAME = ? ";
            Product pRecord = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, productName);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {                
                pRecord = new Product(rs.getString("ProductNAME"), rs.getString("PRODUCTDESCRIPTION"),rs.getInt("QUANTITY"), rs.getString("PRODUCTTYPE"),rs.getDouble("PRODUCTPRICE") );
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "getAllSeletedRecord ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return pRecord;
    }
              
             public void updateRecord(Product updateProduct){
            try{                  
                    String updateStr="UPDATE "+ tableName +" SET PRODUCTDESCRIPTION = ?, QUANTITY = ?, PRODUCTPRICE = ?, PRODUCTTYPE = ? WHERE PRODUCTNAME = ? ";
                    stmt=conn.prepareStatement(updateStr);
                    stmt.setString(1, updateProduct.getProductdesciption());
                    stmt.setInt(2, updateProduct.getQuantity());
                    stmt.setDouble(3, updateProduct.getProductprice());
                    stmt.setString(4, updateProduct.getProducttype());
                    stmt.setString(5, updateProduct.getProductname());
                    stmt.executeUpdate();

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
             
                   public void deleteRecord(String productName){
            try{                  
                    String deleteStrForPP="DELETE FROM PROMOTIONPRODUCT WHERE PRODUCTNAME = ? ";
                    stmt=conn.prepareStatement(deleteStrForPP);
                    stmt.setString(1, productName);
                    stmt.executeUpdate();
                
                
                    String deleteStr="DELETE FROM "+ tableName +"  WHERE PRODUCTNAME = ? ";
                    stmt=conn.prepareStatement(deleteStr);
                    stmt.setString(1, productName);
                    stmt.executeUpdate();

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            }
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
