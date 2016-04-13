/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettest;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author UUU
 */
public class InetAddressExample {
    public static void main(String args[]){
        
        try {
            // Get the network interfaces and associated addresses for this host
            Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
            if(interfaceList == null){
                System.out.println("--No interfaces found--");
            }
            else{
                while(interfaceList.hasMoreElements()){
                    NetworkInterface iface = interfaceList.nextElement();
                    System.out.println("Interafce " + iface.getName() +"(" + iface.getDisplayName() +"):");
                    Enumeration<InetAddress> addrList = iface.getInetAddresses();
                    
                    if(!addrList.hasMoreElements()){
                        System.out.println("\t(No address for this interface.)");
                    }
                    while(addrList.hasMoreElements()){
                        InetAddress address = addrList.nextElement();
                        System.out.println("\tAddress " +
                                (address instanceof Inet4Address ? "(v4)":
                                        (address instanceof Inet6Address ? "(v6)" : "(?)")));
                        System.out.println(": " + address.getHostAddress());
                    }
                }
            }
        } catch (SocketException ex) {
            Logger.getLogger(InetAddressExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(String host : args){
            try{
                System.out.println(host + ":");
                InetAddress[] addressList = InetAddress.getAllByName(host);
                for(InetAddress addr : addressList){
                    System.out.println("\t" + addr.getHostName() + "/" + addr.getHostAddress());
                    
                }
                
            }
            catch(UnknownHostException e){
                System.out.println("\tUnable to find address for " + host);
            }
        }
    }
}
