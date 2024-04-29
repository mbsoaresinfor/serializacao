/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mbs.server;

import com.mbs.server.network.Server;
import com.mbs.server.ui.JanelaPrincipal;
import java.io.IOException;

/**
 *
 * @author marcelo
 */
public class MainServer {

    private static final int  PORTA_SERVER = 2500;
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
        janelaPrincipal.setVisible(true);
        Server server = new Server();        
        server.start(PORTA_SERVER, janelaPrincipal);
        
    }
}
