/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bankser;

/**
 *
 * @author Sara Mousselmal
 */
public class Account {

   
    
    
    int Idclient;
    String name;
    double balence;
    
    

  public Account() {
    }

    public Account(int Idclient, String name, double balence) {
        this.Idclient = Idclient;
        this.name = name;
        this.balence = balence;
    }

 
    public int getIdclient() {
        return Idclient;
    }

    public String getName() {
        return name;
    }

    public double getBalence() {
        return balence;
    }

    public void setIdclient(int Idclient) {
        this.Idclient = Idclient;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalence(int balence) {
        this.balence = balence;
    }


}