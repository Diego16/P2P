/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author diegogustavo
 */
public class Controler extends Thread {

    protected String info;
    protected String fileName;

    public Controler(String info, String fileName) {
        this.info = info;
        this.fileName = fileName;
        this.start();
    }

    @Override
    public void run() {
        try {
            NameServer aDNS = (NameServer) Naming.lookup("rmi://10.151.100.159/NameServer");
            List<String> addresses = aDNS.Names(info);
            downloadFile(addresses,info);
        } catch (Exception e) {
            System.out.println(">>>>>> Error: " + e.getMessage());
        }
    }

    public synchronized void downloadFile (List<String> addresses, String info) {
        // TODO code application logic here
        int randAddress;
        
    }

}
