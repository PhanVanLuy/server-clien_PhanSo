/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detai14;

import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class DeTai14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         frm_client client= new frm_client();
        client.setVisible(true);
        
        frm_server server;
        try {
            server = new frm_server();
            server.setVisible(true);
        } catch (SocketException ex) {
            Logger.getLogger(DeTai14.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
}
