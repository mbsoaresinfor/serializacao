package com.mbs.server.serializacao;

import com.mbs.server.ui.JanelaPrincipal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author marcelo
 * @param <T>
 */
public class Arquivo<T> {

    private JanelaPrincipal janelaPrincipal;
    
    public Arquivo(JanelaPrincipal janelaPrincipal){
        this.janelaPrincipal = janelaPrincipal;
    }
    
    public void serializar(T type) {
        try {
            String nomeArquivo = criarNomeArquivo();
            FileOutputStream fOut = new FileOutputStream(nomeArquivo);
            try (ObjectOutputStream oOut = new ObjectOutputStream(fOut)) {
                oOut.writeObject(type);
            }
            janelaPrincipal.escreverLog("Objeto serializado no arquivo: " + nomeArquivo);            
        } catch (IOException e) {
             janelaPrincipal.escreverLog("Error: " + e.getMessage());
        }

    }

    private String criarNomeArquivo() {
        String pattern = "HH_mm_ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        String nomeArquivo = new StringBuffer("arquivo_serializado_").append(date).append(".txt").toString();
        return nomeArquivo;
    }

    public T deserializar(String nomeArquivo) throws Exception {
        try {
            FileInputStream in = new FileInputStream(new File(nomeArquivo));
            ObjectInputStream input = new ObjectInputStream(in);
             janelaPrincipal.escreverLog("Objeto deserializado no arquivo: " + nomeArquivo);
            return (T) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
             janelaPrincipal.escreverLog("Error: " + e.getMessage());
        }
        return null;
    }
}
