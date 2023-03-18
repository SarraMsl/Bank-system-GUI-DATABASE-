/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bankser;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sara Mousselmal
 */
class implementRmi extends UnicastRemoteObject implements interface_rmi{
    public implementRmi ()throws RemoteException{
        super();
    }
    @Override
    public void Withdraw(int clientID, double amount) throws RemoteException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bank","root","");
            Statement st=(Statement) con.createStatement();
            String sql= "update account set balance = balance + "+ amount+" WHERE id ='"+clientID+"'";
            st.executeUpdate(sql);
            
           // int b1 = Integer.parseInt(balance.setText());
           // String sql= "insert into transaction(type,balance01,from,to) values('"withdraw"',"+b1+",'"+clientID+"',"NULL")";
           // st.executeUpdate(sql);
          
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(implementRmi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(implementRmi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Depose(int clientID, double amount) throws RemoteException {
          try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bank","root","");
            Statement st=(Statement) con.createStatement();
            String sql= "update account set balance = balance - "+ amount+" WHERE id ='"+clientID+"'";
            st.executeUpdate(sql);
           // String sql= "insert into transaction(type,balance,from,to) values('"Depose"',"+balance+",'"+clientID+"',"NULL")";
        //  st.executeUpdate(sql);
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(implementRmi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(implementRmi.class.getName()).log(Level.SEVERE, null, ex);
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Create_account(String name, double balance) throws RemoteException {
          try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bank","root","");
            Statement st=(Statement) con.createStatement();
            String sql= "insert into account (name, balance)values( '"+ name+"',"+balance+")";
            st.executeUpdate(sql);
          
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(implementRmi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(implementRmi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Transfer(int fromID, int toID, double amount) throws RemoteException {
             try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bank","root","");
            Statement st=(Statement) con.createStatement();
            String sql= "update account set balance = balance + "+ amount+" WHERE id ='"+toID+"'";
            st.executeUpdate(sql);
            
            sql= "update account set balance = balance - "+ amount+" WHERE id ='"+fromID+"'";
            st.executeUpdate(sql);
            
      //      String sql= "insert into transaction(type,balance,from,to)values('"Depose"',"+balance+",'"+fromID+"',"toID")";
        //    st.executeUpdate(sql);
          
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(implementRmi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(implementRmi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    
}
