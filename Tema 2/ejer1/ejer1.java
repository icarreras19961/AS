package ejer1;

import java.io.File;

public class ejer1 {

    public static void main(String[] args) {
        // La ruta del fuchero o directorio
        String ruta = "./ejer1/pruebas";
        if (args.length >= 1) {
            ruta = args[0];
        }

        File fich = new File(ruta);
        // Analiza si existe o no
        if (!fich.exists()) {
            System.out.println("No existe el fichero o directorio (" + ruta + ").");
        } else {

            System.out.println(ruta + " es un directorio.\nContenido: ");
            File[] ficheros = fich.listFiles();
            // Analiza si es un directorio o un fichero
            for (File file : ficheros) {
                // Estructura = "condicion" ? {"x"} else {"-"}
                String canread = file.canRead() ? "x" : "-";
                //La linea de arriba es equivalente
                //  if (file.canRead()) {
                // canread = "x";
                // }
                String canwrite = file.canWrite() ? "x" : "-";
                // if (file.canWrite()) {
                // canwrite = "x";
                // }
                String canexecute = file.canExecute() ? "x" : "-";
                // if (file.canExecute()) {
                // canexecute = "x";
                // }

                String textoDescr = file.isDirectory() ? "/" : file.isFile() ? "_" : "?";
                // Lista el contenido
                System.out.println("(" + textoDescr + ") " + file.getName() + "\n\tTamaño: " + file.length()
                        + " bites\n\tPermisos: " + canread + canwrite + canexecute+"\n");
            }

        }
    }
}