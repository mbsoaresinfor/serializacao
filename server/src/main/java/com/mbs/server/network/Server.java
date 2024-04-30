package com.mbs.server.network;

import com.mbs.entidades.Pessoa;
import com.mbs.server.serializacao.Serializador;
import com.mbs.server.ui.JanelaPrincipal;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author marcelo
 */
public class Server {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectInputStream in;
    private Serializador serializador;

    public void start(int porta, JanelaPrincipal janelaPrincipal) {
        try {
            serializador = new Serializador(janelaPrincipal);
            serverSocket = new ServerSocket(porta);
            janelaPrincipal.escreverLog("Server iniciado na porta: " + porta);
        } catch (IOException e) {
            janelaPrincipal.escreverLog("Error: " + e.getMessage());
        }

        while (true) {
            try {
                clientSocket = serverSocket.accept();
                in = new ObjectInputStream(clientSocket.getInputStream());
                // deserializacao do objeto
                Pessoa pessoa = (Pessoa) in.readObject();
                janelaPrincipal.escrever("Recebido objeto no server",pessoa);
                serializador.serializar(pessoa);
            } catch (IOException | ClassNotFoundException e) {
                janelaPrincipal.escreverLog("Error: " + e.getMessage());
            }
        }
    }
}
