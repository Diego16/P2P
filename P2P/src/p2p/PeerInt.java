/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

/**
 *
 * @author diegogustavo
 */
public interface PeerInt extends java.rmi.Remote {

    public byte[] retrieveFile(String fileName) throws java.rmi.RemoteException;

}
