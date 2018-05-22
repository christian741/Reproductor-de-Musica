/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosPersona;

import ModeloCompra.Compra;
import ModeloCompra.MetodosCompra;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Familia Díaz Rendón
 */
public class CancionesCompradas extends javax.swing.JPanel {
     private DefaultTableModel table_model_personas;
    public ArrayList<Compra> lista_personas = MetodosCompra.obtenerTodos();
   
    /**
     * Creates new form CancionesCompradas
     */
    public CancionesCompradas() {
        initComponents();
        configComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_canciones = new javax.swing.JTable();

        tabla_canciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla_canciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
     private void configComponents() {
        
        
        DefaultTableModel table_model_personas = new DefaultTableModel();
        table_model_personas.addColumn("id");
        table_model_personas.addColumn("Documento");
        table_model_personas.addColumn("Nombre");
        table_model_personas.addColumn("Cancion");
        table_model_personas.addColumn("Album");
        
        tabla_canciones.setModel(table_model_personas);
        this.setTableModel(table_model_personas);
        this.refreshTableModel();
    }
    public void setTableModel(DefaultTableModel table_model_personas){
        this.table_model_personas = table_model_personas;
    }
    
    
    
    public void refreshTableModel()
    {
        
       while (table_model_personas.getRowCount() > 0) {
            table_model_personas.removeRow(0);
        }
       
         for(Compra p : lista_personas){
            
            Object[] data = {p.getId(),Integer.toString(p.getDocumento()), p.getNombre(),p.getCancion(),p.getAlbum()};
            table_model_personas.addRow(data);
         }
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_canciones;
    // End of variables declaration//GEN-END:variables
}
