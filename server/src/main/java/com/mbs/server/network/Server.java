package com.mbs.server.network;

import com.mbs.entidades.Pessoa;
import com.mbs.server.serializacao.Arquivo;
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
    private Arquivo<Pessoa> arquivo;

    public void start(int porta, JanelaPrincipal janelaPrincipal) {
        try {
            arquivo = new Arquivo(janelaPrincipal);
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
                janelaPrincipal.escreverLog("Recebido objeto no server");
                arquivo.serializar(pessoa);
            } catch (IOException | ClassNotFoundException e) {
                janelaPrincipal.escreverLog("Error: " + e.getMessage());
            }
        }
    }
}
