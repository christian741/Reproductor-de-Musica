/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosPersona;

import ModeloAlbum.Albums;
import ModeloAlbum.MetodosAlbum;
import ModeloCancion.Cancion;
import ModeloCancion.MetodosCancion;
import ModeloCompra.Compra;
import ModeloCompra.MetodosCompra;
import Principal.Login;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Principal.JFZonaUsuario;
import Principal.Usuario;

/**
 *
 * @author Familia Díaz Rendón
 */
public class TiendaJP extends javax.swing.JPanel {
    public ArrayList<Cancion> lista_canciones = MetodosCancion.obtenerTodos();
    public ArrayList<Albums> lista_albunes = MetodosAlbum.obtenerTodos();
    private int indice=0;
    private int indice2=0;
    private JButton buttons[]= new JButton[100];
    private JButton boton2[]= new JButton[100];
    private Compra com;
    
  

    
   
   
    /**
     * Creates new form TiendaJP
     */
    public TiendaJP() {
       
        initComponents();
       
        
        
    
        for(Albums a : lista_albunes){
             JLabel label =new JLabel("Nombre Album: "+a.getNombre());
             label.setFont( new Font("TimesRoman",Font.BOLD,14));
            label.setHorizontalAlignment(JLabel.CENTER);
            
              jPanel1.add(label);
              
              Image img = Toolkit.getDefaultToolkit().getImage(a.getImagen());
              ImageIcon icono = new ImageIcon(img);
              JLabel label7 = new JLabel("Imagen : "+icono);
              jPanel1.add(label7);
              
              JLabel label8 = new JLabel("Genero:  "+a.getGenero());
              jPanel1.add(label8);
              JLabel label9 = new JLabel("Artista:  "+a.getArtista());
              jPanel1.add(label9);
              
              
              
              //-----------------------------------
              
              for(Cancion c : lista_canciones){

              if(c.getNombreAlbum().equals(a.getNombre())){
                  JLabel label2 =new JLabel("Nombre Cancion: "+c.getCancion());
                  
                  jPanel1.add(label2);
                  
                  
              }
    
              }
              buttons[indice]= new JButton("Comprar");
              jPanel1.add(buttons[indice]);
              ManejadorDeEventos manejador1 = new ManejadorDeEventos();
	      buttons[indice].setActionCommand("Comprar");
              buttons[indice].addActionListener(manejador1);
              indice++;
             
             
        }
        for(Cancion c : lista_canciones){
            JLabel label3 =new JLabel("Nombre Cancion: "+c.getCancion());
            label3.setFont( new Font("TimesRoman",Font.BOLD,14));
            label3.setHorizontalAlignment(JLabel.CENTER);
              
            jPanel2.add(label3);
            JLabel label4 =new JLabel("Nombre Album Perteneciente: "+c.getNombreAlbum());
            jPanel2.add(label4);
            
            JLabel label10 =new JLabel("Minutos : "+c.getMinutos());
            jPanel2.add(label10);
            
            JLabel label11 =new JLabel("Segundos : "+c.getSegundos());
            jPanel2.add(label11);
            
             boton2[indice2]= new JButton("Comprar");
             jPanel2.add(boton2[indice2]);
             ManejadorDeEventos2 manejador2 = new ManejadorDeEventos2();
	     boton2[indice2].setActionCommand("Comprar");
             boton2[indice2].addActionListener(manejador2);
            
              indice2++;

        }
        
    }
   
    private class ManejadorDeEventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
                     for(Albums c : lista_albunes){ 
	                switch(e.getActionCommand()){
                           case "Comprar":
                         
                           com = Compra.crear(0,Login.usuario.getDocumento(),Login.usuario.getNombre(),"",c.getNombre());
                           MetodosCompra.crear(com);
                           break;
                          
                        }
                }
			
			
		}
		
	}
    private class ManejadorDeEventos2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
                        for(Cancion c : lista_canciones){  
                            
                           switch(e.getActionCommand()){
                           case "Comprar":
                          
                           com = Compra.crear(0,Login.usuario.getDocumento(),Login.usuario.getNombre(),"",c.getCancion());
                           MetodosCompra.crear(com);
                           break;
                          
                        }
                            
                        }
                          
			
			
		}
		
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
        jPanel1 = new javax.swing.JPanel();
        jLabelAlbum = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setLayout(new java.awt.GridLayout(20, 3));
        jScrollPane1.setViewportView(jPanel1);

        jLabelAlbum.setText("ALBUMS");

        jPanel2.setLayout(new java.awt.GridLayout(20, 3));
        jScrollPane2.setViewportView(jPanel2);

        jLabel1.setText("CANCIONES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabelAlbum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(166, 166, 166))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAlbum)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAlbum;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
