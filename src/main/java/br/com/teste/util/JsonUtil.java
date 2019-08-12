package br.com.teste.util;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonUtil {

    public static String lerJsonFile() {
        try {
            FileReader arq = new FileReader("dados-iniciais.json");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            StringBuilder jsonFile = new StringBuilder();
            while (linha != null) {
                System.out.printf("%s\n", linha);
                jsonFile.append(linha + "\n");

                linha = lerArq.readLine();
            }

            arq.close();
            return jsonFile.toString();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
            return null;
        }
    }

    public static void writeJsonFile(Object obj) {
        Gson gson = new Gson();

        // converte objetos Java para JSON e retorna JSON como String
        String stringSson = gson.toJson(obj);

        try {
            //Escreve Json convertido em arquivo chamado "file.json"
            FileWriter writer = new FileWriter("dados-iniciais.json");
            writer.write(stringSson);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(stringSson);
    }

}
