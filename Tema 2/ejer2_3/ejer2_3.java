package ejer2_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ejer2_3 {
    public static void main(String[] args) throws IOException {
        String ruta = "./fichero/lorem.txt";
        BufferedReader reader = new BufferedReader(new FileReader(ruta));

        String line;
        int linea = 0;
        int columna = 0;
        int aparece = 0;
        String palabra = "magna";
        while ((line = reader.readLine()) != null) {
            String[] datos = line.split(" ");

            linea++;
            columna = 0;
            for (String item : datos) {
                columna++;

                // System.out.println((item.equals(palabra)) + " " + item);
                if (item.equals(palabra)) {
                    aparece++;
                    System.out.println("La palabra " + palabra + " esta en la columna: " +
                            columna + " linea: " + linea
                            + " y aparece: " + aparece + " en el texto");
                }

            }

        }

        reader.close();
    }
}
