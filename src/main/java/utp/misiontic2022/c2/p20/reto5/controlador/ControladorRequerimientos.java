package utp.misiontic2022.c2.p20.reto5.controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import utp.misiontic2022.c2.p20.reto5.modelo.dao.LiderDao;
import utp.misiontic2022.c2.p20.reto5.modelo.dao.NombreLiderDao;
import utp.misiontic2022.c2.p20.reto5.modelo.dao.SalarioProLiderDao;
import utp.misiontic2022.c2.p20.reto5.modelo.vo.Lider;
import utp.misiontic2022.c2.p20.reto5.modelo.vo.NombreLider;
import utp.misiontic2022.c2.p20.reto5.modelo.vo.SalarioProLider;

public class ControladorRequerimientos {
    // El controlador llama al Dao
    LiderDao lDao = new LiderDao();
    NombreLiderDao nDao = new NombreLiderDao();
    SalarioProLiderDao spDao = new SalarioProLiderDao();

    // Constructor
    public ControladorRequerimientos() {

    }

    public ArrayList<Lider> consultarRequerimiento1() throws SQLException {
        return lDao.requerimiento1();
    }

    public ArrayList<NombreLider> consultarRequerimiento2() throws SQLException {
        return nDao.requerimiento2();
    }

   public ArrayList<SalarioProLider> consultarRequerimiento3() throws SQLException {
        return spDao.requerimiento3();
    }
}
