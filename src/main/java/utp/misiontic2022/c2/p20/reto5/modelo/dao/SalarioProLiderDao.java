package utp.misiontic2022.c2.p20.reto5.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p20.reto5.modelo.vo.SalarioProLider;
import utp.misiontic2022.c2.p20.reto5.util.JDBCUtilities;

public class SalarioProLiderDao {
    // Aquí se contruye la función
    Connection conexion;
        
    public ArrayList<SalarioProLider> requerimiento3() throws SQLException {
        ArrayList<SalarioProLider> lista = new ArrayList<>();
		Statement stm = null;
        ResultSet rs = null; // toma la lista de la consulta
		conexion = JDBCUtilities.getConnection();
                
        try {
			String sql= "SELECT Cargo, avg(Salario) FROM Lider GROUP BY Cargo HAVING AVG(Salario) > 500000";
        
			stm = conexion.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				// Se crea lider de la clase SalarioProLider.java        
				SalarioProLider lider = new SalarioProLider();
				lider.setCargo(rs.getString(1));
				lider.setProSalario(rs.getDouble(2));
				lista.add(lider);
			}
			rs.close();
			stm.close();

		} catch(SQLException e){
            System.err.println("Error consultando Suma Salario de los lideres: "+e);
        } 
		finally {
             if (conexion!= null) {
                conexion.close();
            }
        }
		return lista;
    }
}