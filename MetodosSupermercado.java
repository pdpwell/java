/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_final;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Gilberto Toledo
 */
public class METODOS {

    //Para ler em .txt.
    public static String Read(String Caminho) {
        String conteudo = "";
        try {
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while (linha != null) {
                    conteudo += linha + "\n";
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }

    //Para escrever em .txt.
    public static boolean WritePERMANENTE(String Caminho, String Texto) {
        try {
            FileWriter arq = new FileWriter(Caminho, true);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(Texto);
            gravarArq.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //Apargar um .txt.
    public static boolean APAGADOR_DE_TXT(String Caminho, String Texto) {
        try {
            FileWriter arq = new FileWriter(Caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(Texto);
            gravarArq.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

   //Pegar data e hora.
    public static String DATA(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

        String Data = sdf.format(new Date());

        return Data;
    }

    // Para deletar uma linha com determinada palavra.
    public static void Delete(String Caminho, String Deletar) {
        String conteudo = "";

        try {
            FileReader fr = new FileReader(Caminho);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();
            ArrayList<String> salvar = new ArrayList();

            while (linha != null) {
                if (linha.contains(Deletar) == false) {
                    salvar.add(linha);
                }

                linha = br.readLine();
            }

            br.close();
            fr.close();
            FileWriter fw2 = new FileWriter(Caminho, true);
            fw2.close();

            FileWriter fw = new FileWriter(Caminho);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < salvar.size(); i++) {
                bw.write(salvar.get(i));
                bw.newLine();
            }
            bw.close();
            fw.close();

        } catch (IOException ex) {

        }
    }

    //Para copiar de um txt para outro.
    public static void COPIAR(String Original, String Copia)
            throws IOException {

        File arquivoOrigem = new File(Original);
        FileReader fis = new FileReader(arquivoOrigem);
        BufferedReader bufferedReader = new BufferedReader(fis);
        StringBuilder buffer = new StringBuilder();
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            buffer.append(line).append("\r\n");
        }
        fis.close();
        bufferedReader.close();
        File arquivoDestino = new File(Copia);
        FileWriter writer = new FileWriter(arquivoDestino, true);
        writer.write(buffer.toString());
        writer.flush();
        writer.close();
    }

    //Buscar um nome em uma txt.
    public static String BUSCA(String endereco, String id) throws IOException {
        try (BufferedReader buffeRead = new BufferedReader(new FileReader(endereco))) {
            String linha = "";
            while (true) {
                linha = buffeRead.readLine();
                if (linha != null) {
                    String busca = linha.split("@")[0];
                    if (busca.equals(id)) {
                        return linha;
                    }
                } else {
                    break;
                }
            }
        }
        return "";
    }
  
}
