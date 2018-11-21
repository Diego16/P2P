/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

import java.util.List;

/**
 *
 * @author diegogustavo
 */
public interface NameServerInt extends java.rmi.Remote {

    public List<String> Names(String fileName) throws java.rmi.RemoteException;

    public void addFile(String fileName) throws java.rmi.RemoteException;

    public List<String> getFiles() throws java.rmi.RemoteException;
}
