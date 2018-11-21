/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

/**
 *
 * @author diegogustavo
 */
public class NameServer extends UnicastRemoteObject implements NameServerInt {

    protected Map<String, List<String>> filesPool;

    public NameServer(String address) throws RemoteException {
        super();
        try {
            filesPool = new HashMap< String, List<String>>();
        } catch (Exception e) {
            System.out.println(">>>>>> Error: " + e.getMessage());
        }
    }

    @Override
    public List<String> Names(String fileName) throws RemoteException {
        try {
            String reqPeer = getClientHost();
            System.out.println("Peticion de: " + reqPeer + "\n>>>> Peers que posean el archivo " + fileName);
        } catch (Exception e) {
            System.out.println(">>>>>> Error: " + e.getMessage());
        }
        if (filesPool.containsKey(fileName)) {
            System.out.println("Se encontró el archivo en " + filesPool.get(fileName).size() + " peers. Se ha enviado la informacion.");
            return filesPool.get(fileName);
        } else {
            System.out.println("Ningun peer tiene el archivo por el momento.");
            return new ArrayList<String>();
        }
    }

    @Override
    public void addFile(String fileName) throws RemoteException {
        try {
            String reqPeer = getClientHost();
            System.out.println("Mensaje de: " + reqPeer + "\n>>>> Poseo el archivo " + fileName);
            if (filesPool.containsKey(fileName)) {
                filesPool.get(fileName).add(reqPeer);
            } else {
                List<String> newList = new ArrayList<String>();
                newList.add(reqPeer);
                filesPool.put(fileName, newList);
            }
        } catch (Exception e) {
            System.out.println(">>>>>> Error: " + e.getMessage());
        }
    }

    @Override
    public List<String> getFiles() throws RemoteException {
        List<String> available = new ArrayList<String>();
        try {
            String reqPeer = getClientHost();
            System.out.println("Peticion de: " + reqPeer + "\n>>>> Ver todos los archivos. Se ha enviado la informacion");
            filesPool.entrySet().stream().map((entry) -> entry.getKey()).forEachOrdered((fileName) -> {
                available.add(fileName);
            });
        } catch (Exception e) {
            System.out.println(">>>>>> Error: " + e.getMessage());
        }
        return available;
    }
}
