package utp.misiontic2022.c2.p20.reto5.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import utp.misiontic2022.c2.p20.reto5.controlador.ControladorRequerimientos;
import utp.misiontic2022.c2.p20.reto5.modelo.vo.Lider;
import utp.misiontic2022.c2.p20.reto5.modelo.vo.NombreLider;
import utp.misiontic2022.c2.p20.reto5.modelo.vo.SalarioProLider;

//GUI
public class FrmConsultasBtg extends JFrame {

    // Definición de Objetos y caracteristicas
    private ControladorRequerimientos controller;

    //Atributos de la interfaz
    private JTable tabla;
    private JRadioButton radio1, radio2, radio3;
    private ButtonGroup grupoBotones;
    private JButton btnConsultar, btnLimpiar, btnCerrar;
	private JPanel panel, panelPEnd, panelPStart;
	private JTabbedPane tbd;
    // Constructor
    public FrmConsultasBtg() {
        controller = new ControladorRequerimientos();

        initUI();
        setLocationRelativeTo(null);
    }
    
    // Inicializamos Componentes
    private void initUI() {
        setTitle("Reto 5 - Grupo 20");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // ancho x altura
        setSize(500, 300);
        setResizable(false);
        // Incializamos el JTabbedPane y el Layout
        tbd = new JTabbedPane();
        getContentPane().add(tbd, BorderLayout.CENTER);
        setResizable(false);
        // Incializamos los JPanel
        panel = new JPanel();
        panelPEnd = new JPanel();
        panelPStart = new JPanel();
        panel.setLayout(new BorderLayout());
        tbd.addTab("Requerimientos Reto 5", panel);
        tbd.setFont(new Font ("Arial", Font.BOLD,14));
        // Incializamos el ButtonGroup
        grupoBotones = new ButtonGroup();

	    // Propiedades de los controles
        radio1 = new JRadioButton("Requerimiento 1");
        radio1.setFont(new Font ("Arial Bold", Font.PLAIN,13));
        radio1.setToolTipText("Segundo Apellido Lider sea 'Ortiz");
        panelPStart.add(radio1);


        radio2 = new JRadioButton("Requerimiento 2");
        radio2.setFont(new Font ("Arial Bold", Font.PLAIN,12));
        radio2.setToolTipText("Transformar Nombre Lideres");
        panelPStart.add(radio2);
        grupoBotones.add(radio2);

        radio3 = new JRadioButton("Requerimiento 3");
        radio3.setFont(new Font ("Arial Bold", Font.PLAIN,12));
        radio3.setToolTipText("Suma salarios de los lideress");
        panelPStart.add(radio3);
        grupoBotones.add(radio3);
        
        btnConsultar = new JButton("Consultar");
        btnLimpiar = new JButton("Limpiar");
        btnCerrar=new JButton("Cerrar");

        // Se asigna a cada Botón, el manejador de eventos
        btnConsultar.addActionListener(b -> seleccionConsulta());
        btnLimpiar.addActionListener(l -> limpiarTabla());
        btnCerrar.addActionListener(c -> cerrarAplicacion());
        
        // Se carga los panels	
        panelPEnd.add(btnConsultar);
        panelPEnd.add(btnLimpiar);
        panelPEnd.add(btnCerrar);
        panel.setBorder(BorderFactory.createRaisedSoftBevelBorder()); 
        panel.add(panelPStart, BorderLayout.PAGE_START);
        panel.add(panelPEnd, BorderLayout.PAGE_END);
	
        // Inicializamos el JTable
        tabla = new JTable();
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
    }

    // Implemento el Procedimento para inicializar el requerimiento 1
    private void consultarLiderSegundoApellido() {
        try {
            var lista = controller.consultarRequerimiento1();
            var tableModel = new LiderTableModel();
            tableModel.setData(lista);

            tabla.setModel(tableModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    // Implemento la Función de consulta, para el requerimiento 1
    private class LiderTableModel extends AbstractTableModel {
        private List<Lider> data;

        public void setData(List<Lider> data) {
            this.data = data;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return String.class;
                default:
                    return String.class;
            }
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Nombre";
                case 1:
                    return "Primer apellido";
                case 2:
                    return "Segundo apellido";
                case 3:
                    return "Salario";
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var project = data.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return project.getNombre();
                case 1:
                    return project.getPrimer_Apellido();
                case 2:
                    return project.getSegundo_Apellido();
                case 3:
                    return project.getSalario();
            }
            return null;
        }
    }


    // Implemento el Procedimento para inicializar el requerimiento 2
    private void consultarNombreLider() {
        try {
            var lista = controller.consultarRequerimiento2();
            var tableModel = new NombreLiderTableModel();
            tableModel.setData(lista);

            tabla.setModel(tableModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    // Implemento la Función de consulta, para el requerimiento 2
    private class NombreLiderTableModel extends AbstractTableModel {
        private List<NombreLider> data;

        public void setData(List<NombreLider> data) {
            this.data = data;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return String.class;
                default:
                    return String.class;
            }
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Nombre";
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var project = data.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return project.getNombre();
            }
            return null;
        }
    }

    // Implemento el Procedimento para inicializar el requerimiento 3
    private void consultarSalarioProLider() {
        try {
            var lista = controller.consultarRequerimiento3();
            var tableModel = new SalarioProLiderTableModel();
            tableModel.setData(lista);

            tabla.setModel(tableModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    // Implemento la Función de consulta, para el requerimiento 3    
    private class SalarioProLiderTableModel extends AbstractTableModel {
        private List<SalarioProLider> data;

        public void setData(List<SalarioProLider> data) {
            this.data = data;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 1:
                    return double.class;
                default:
                    return String.class;
            }
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Cargo";
                case 1:
                    return "Salario promedio";
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var project = data.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return project.getCargo();
                case 1:
                    return project.getProSalario();
            }
            return null;
        }

    }

// Implemento el Procedimento para la selección del botón
    public void seleccionConsulta() {
        if (!radio1.isSelected() && !radio2.isSelected() && !radio3.isSelected()){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una opción", "Advertencia", 
                        JOptionPane.WARNING_MESSAGE);
        }
        if (radio1.isSelected()) {
            consultarLiderSegundoApellido();
        }
        if (radio2.isSelected()) {
            consultarNombreLider();
        }
        if (radio3.isSelected()) {
            consultarSalarioProLider();
        }
    }
    
    // Implemento el Procedimento para limpiar la tabla
    public void limpiarTabla() {
        if (!radio1.isSelected() && !radio2.isSelected() && !radio3.isSelected()){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una opción", "Advertencia", 
                        JOptionPane.WARNING_MESSAGE);
        }
        else{
            var tableModel = new LimpiarTableModel();
            tabla.setModel(tableModel);
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
            grupoBotones.clearSelection();
        } 
    }

    // Implemento la Función para limpiar la tabla
    private class LimpiarTableModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return 0;
        }

        @Override
        public int getColumnCount() {
            return 0;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return null;
        }

    }

    // Implemento el Procedimento para Cerrar la Aplicación
    public void cerrarAplicacion(){
		int opcion=JOptionPane.showConfirmDialog(null, "¿Estás seguro que quiere cerrar la aplicación?",
                    "Confirmación de cierre", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (opcion == JOptionPane.YES_OPTION) {
			   System.exit(0);
		}
	}
}