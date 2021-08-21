package utp.misiontic2022.c2.p20.reto5.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p20.reto5.modelo.vo.NombreLider;
import utp.misiontic2022.c2.p20.reto5.util.JDBCUtilities;

public class NombreLiderDao {
    // Aquí se contruye la función
    Connection conexion;

    public ArrayList<NombreLider> requerimiento2() throws SQLException {
		ArrayList<NombreLider> lista = new ArrayList<>();
        Statement stm = null;
        ResultSet rs = null; // toma la lista de la consulta
		conexion = JDBCUtilities.getConnection();
            
		try {
			String sql= "SELECT LOWER(SUBSTR(Nombre,1,1)) || UPPER(SUBSTR(Nombre,2,LENGTH(Nombre))) FROM Lider";
        
			stm = conexion.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				// Se crea lider de la clase NombreLider.java
				NombreLider lider = new NombreLider();
				lider.setNombre(rs.getString(1));
				lista.add(lider);
			}
			rs.close();
			stm.close();
			
		} catch(SQLException e){
            System.err.println("Error consultando Tranformar Nombre Lider: "+e);
        } finally {
            if (conexion!= null) {
                conexion.close();
            }
        }
		return lista;
    }        
}
