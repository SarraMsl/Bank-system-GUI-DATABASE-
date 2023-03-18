package bankser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Sara Mousselmal
 */
public interface interface_rmi  extends Remote{
   public void Withdraw (int clientID,double amount)throws  RemoteException;
   public void Depose(int clientID,double amount)throws RemoteException;
   public void Create_account(String name, double balance)throws RemoteException;
   public void Transfer(int fromID, int toID, double amount)throws RemoteException;

   
}
