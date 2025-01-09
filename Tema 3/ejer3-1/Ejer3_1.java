import java.sql.*;

public class Ejer3_1 {

    public static void main(String[] args) {

        try {
            // Creacion de la conexion

            String urlBaseDades = "jdbc:mysql://localhost:3306/test";
            String usuari = "root";
            String password = "";

            Connection con = DriverManager.getConnection(urlBaseDades, usuari, password);
            Statement myStatement = con.createStatement();//Este lo he tenido que crear por el update            

            PreparedStatement stmt = con.prepareStatement("select * from clientes WHERE nombre=?");

            // Establecer parametros de consulta
            stmt.setString(1, "NADALES");
            // Ejecutar y recoger consulta
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

            }
            rs.close();

            // El update
            String stmt2 = "UPDATE clientes SET dinero=5000 WHERE nombre='NADALES'";
            myStatement.executeUpdate(stmt2);

            // Vista del Update
            PreparedStatement stmt2_1 = con.prepareStatement("select * from clientes WHERE nombre=?");
            stmt2_1.setString(1, "NADALES");
            ResultSet rs2 = stmt2_1.executeQuery();
            while (rs2.next()) {
                System.out.println(rs2.getString(1) + " " + rs2.getString(2) + " " + rs2.getString(3));
            }
            rs2.close();
            

            // EL delete
            PreparedStatement stmt3 = con.prepareStatement("DELETE FROM clientes WHERE nombre='NADALES'");
            stmt3.executeUpdate();

            // Una vista del valor borrado (la aparece nada)
            PreparedStatement stmt3_1 = con.prepareStatement("select * from clientes WHERE nombre='NADALES'");
            ResultSet rs3 = stmt3_1.executeQuery();
            while (rs3.next()) {
                System.out.println(rs3.getString(1) + " " + rs3.getString(2) + " " + rs3.getString(3));
            }
            rs3.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}