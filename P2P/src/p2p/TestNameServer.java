/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

import java.rmi.RemoteException;

/**
 *
 * @author diegogustavo
 */
public class TestNameServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
         NameServer newWorker = new NameServer("rmi://127.0.0.1/NameServer");   
        }
        catch (RemoteException e){
            System.out.println(">>>>>> Error: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
}
