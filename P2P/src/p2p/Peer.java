/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;

/**
 *
 * @author diegogustavo
 */
public class Peer extends UnicastRemoteObject implements PeerInt {

    public Peer(String address) throws RemoteException {
        super();
        try {
            System.out.println("Agregando objeto " + address);
        } catch (Exception e) {
            System.out.println(">>>>>> Error: " + e.getMessage());
        }
    }

    @Override
    public byte[] retrieveFile(String fileName) throws RemoteException {
        byte[] content = new byte[0];
        try {
            String filePath = System.getProperty("user.dir");
            filePath+="/"+fileName;
            File newFile = new File(filePath);
            content = new byte[(int)newFile.length()];
            FileInputStream fileInput = new FileInputStream(newFile);
            fileInput.read(content);
        } catch (Exception e) {
            System.out.println(">>>>>> Error: " + e.getMessage());
        }
        return content;
    }

}
