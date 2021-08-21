package utp.misiontic2022.c2.p20.reto5.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p20.reto5.modelo.vo.Lider;
import utp.misiontic2022.c2.p20.reto5.util.JDBCUtilities;

public class LiderDao {
    // Aquí se contruye la función
    Connection conexion;

    public ArrayList<Lider> requerimiento1() throws SQLException {
        /* Se utiliza PreparedStament, cuando se usan interrogantes. Cuando no se usan se utiliza Statement
           String sql = "insert into libros (ISBN, titulo, año_publicacion) values (?,?,?)";
           PreparedStatement pstmt = null;
           pstmt = conexion.prepareStatement(sql);*/
        ArrayList<Lider> lista = new ArrayList<>();
        Statement stm = null;
        ResultSet rs = null; // toma la lista de la consulta
        conexion = JDBCUtilities.getConnection();
        
        try {
            String sql= "SELECT Nombre, Primer_Apellido, Segundo_Apellido, Salario FROM Lider WHERE Segundo_Apellido = 'Ortiz'";
        
            stm = conexion.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                // Se crea lider de la clase Lider.java
                Lider lider = new Lider();
                lider.setNombre(rs.getString(1));
                lider.setPrimer_Apellido(rs.getString(2));
                lider.setSegundo_Apellido(rs.getString(3));
                lider.setSalario(rs.getInt(4));
                lista.add(lider);
            } 
			rs.close();
			stm.close();

		}catch(SQLException e){
            System.err.println("Error consultando lideres cuyo segundo nombre es igual a 'Ortiz': "+e);
        } finally {
            if (conexion!= null) {
                conexion.close();
            }
        }
        return lista;    
    }
}