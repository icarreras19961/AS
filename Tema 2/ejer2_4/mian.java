package ejer2_4;

import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class mian {
    public static void main(String[] args) {
        String ruta = "./datos.txt";

        // creador(ruta);

        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Producto(1, "IvanCarrer", 25.62, false, 'A'));
        productos.add(new Producto(2, "PacoPonsss", 23.62, true, 'A'));
        productos.add(new Producto(4, "Sarandonga", 28.62, false, 'A'));
        productos.add(new Producto(3, "Macarrones", 26.62, false, 'A'));
        productos.add(new Producto(5, "Espaguetis", 21.62, false, 'A'));

        try (RandomAccessFile acceso = new RandomAccessFile(ruta, "rw")) {

            for (Producto producto : productos) {
                acceso.writeInt(producto.getId());

                StringBuffer nombre = new StringBuffer(producto.getNombre());
                nombre.setLength(10);

                acceso.writeChars(nombre.toString());
                acceso.writeDouble(producto.getPrecio());
                acceso.writeBoolean(producto.isDescuento());
                acceso.writeChar(producto.getTipo());

            }

            acceso.seek(35);

            System.out.println(acceso.readInt());

            String nombre = "";
            for (int i = 0; i < 10; i++) {
                nombre += acceso.readChar();
            }
            System.out.println(nombre);
            System.out.println(acceso.readDouble());
            System.out.println(acceso.readBoolean());
            System.out.println(acceso.readChar());

        } catch (Exception e) {
            System.err.println("No se ha leido correctamente " + e);
        }
    }

    public static void creador(String ruta) {
        File fichero = new File(ruta);
        try {
            if (fichero.createNewFile()) {
                System.out.println("El fichero se ha creado correctamente");
            }

        } catch (Exception e) {
            System.err.println("Ha habido un problema creando el fichero " + e);
        }
    }
}
