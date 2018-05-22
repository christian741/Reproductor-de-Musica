
package Reproductor;


import com.mpatric.mp3agic.ID3v2;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;



public class InterfaceGrafica extends javax.swing.JFrame {
    
    //Variables importantes que intervienen en el programa...........
    
    //Instanciamos la Clase Ecualizador Graphics para poder llamarla y poder usar sus metodos
    
    
    private Map ElementosMap;
    float []eculi = new float [9];
    int E0,E1,E2,E3,E4,E5,E6,E7,E8,E9;
    private Color c = Color.BLACK;
    private final Color c1= new Color(153,255,153);
    private final Color c2= new Color(255,255,204);
    private final String fuente1="Georgia";
    private final String fuente2="Segoe Print";
    private boolean mute=false;
    private boolean bloquear=false;
    private boolean repitaCancion=false;
    private boolean siguiente=false;
    private float balance=0.5f;
    private float volumenM;
    private float volumen=0.8f;
    
    private final BasicPlayer Audio = new BasicPlayer();
    FileNameExtensionFilter filtrado = new FileNameExtensionFilter("Solo Mp3","mp3","jpg");
    
    private String ruta = "C:\\Escritorio";
    private final JFileChooser abrirFile  = new JFileChooser(new File(ruta));
    
    private File archivo= null;
    private Tag tag;
    private  AudioFile audiofile = new AudioFile();
    
    private String agregaCanciones[]= new String[10];
    private final ArrayList<String> datos = new ArrayList<>();
    

    public InterfaceGrafica() {
        
        //Llamadas a metodos del programa...
        
        initComponents();
        
        E0=E1=E2=E3=E4=E5=E6=E7=E8=E9=0;
        SlidersChange();
        basic_playerlistener();
        jlistlistener();
        new EditorEtiquetas(jLabelTitulo,jLabelGenero,jLabelComentario,jLabelGrupo,jLabelFecha,jLabelAlbum,jListListaCanciones,datos);
        
        //setResizable(false); 
          
        new JLaTexto(fuente1, "Ruta: "+ruta, jLabelRuta, Color.WHITE, 15);       
     
        //Importa un mensaje emergente de ayuda a cada boton
        //informacion
      
        
//Importa iconos esteticos en dos posiciones a los botones
        new BotonesEscucha(jButtonReproducir,"Reproducir.png","ReproducirP.png");
        //Detener la cancion
        new BotonesEscucha(jButtonParar,"nombre.png","nombre.png");
        //Pausar La cancion
        new BotonesEscucha(jButtonPausar, "nombre.png", "nombre.png");
        //Siguiente cancion
        new BotonesEscucha(jButtonAvance, "nombre.png", "nombre.png");
        //Anterior cancion
        new BotonesEscucha(jButtonRetroceso, "nombre.png", "nombre.png");
        //Carpetas
        new BotonesEscucha(jButtonDirectorio, "nombre.png", "nombre.png");
       
        new BotonesEscucha(jButtonRepetir, "nombre.png", "RepetirP.png");
        //Silenciar Musica
        new BotonesEscucha(jButtonMute, "nombre.png", "nombre.png");
        
        
       
        jSliderControlVolumen.setEnabled(false);
        jSliderProgresoMp3.setEnabled(false); 
        
        
        
        
    }
    
    @SuppressWarnings("unchecked") 
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuEmergente = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListListaCanciones = new javax.swing.JList<>();
        jButtonRepetir = new javax.swing.JButton();
        jSliderControlVolumen = new javax.swing.JSlider();
        jLabelRuta = new javax.swing.JLabel();
        jLabelCancion = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelGenero = new javax.swing.JLabel();
        jLabelTamano = new javax.swing.JLabel();
        jLabelTiempo = new javax.swing.JLabel();
        jLabelGrupo = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jLabelComentario = new javax.swing.JLabel();
        jLabelAlbum = new javax.swing.JLabel();
        jLabelFRate = new javax.swing.JLabel();
        jLabelBitrate = new javax.swing.JLabel();
        jLabelPista = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jLabelTranscurrido = new javax.swing.JLabel();
        jLabelVolumen = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();
        jLabelImagen = new javax.swing.JLabel();
        jButtonLimpiarLista = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonAvance = new javax.swing.JButton();
        jButtonRetroceso = new javax.swing.JButton();
        jButtonPausar = new javax.swing.JButton();
        jButtonParar = new javax.swing.JButton();
        jButtonReproducir = new javax.swing.JButton();
        jButtonDirectorio = new javax.swing.JButton();
        jButtonMute = new javax.swing.JButton();
        jLabelTemaFondo = new javax.swing.JLabel();
        jLabelRuta1 = new javax.swing.JLabel();
        jSliderProgresoMp3 = new javax.swing.JSlider();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenuItem2.setText("Eliminar Cancion ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        MenuEmergente.add(jMenuItem2);

        jMenuItem3.setText("Añadir Cancion");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        MenuEmergente.add(jMenuItem3);

        jMenuItem4.setText("Siguiente Cancion");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        MenuEmergente.add(jMenuItem4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jListListaCanciones.setBackground(new java.awt.Color(204, 204, 204));
        jListListaCanciones.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jListListaCanciones.setForeground(new java.awt.Color(255, 255, 255));
        jListListaCanciones.setComponentPopupMenu(MenuEmergente);
        jListListaCanciones.setFocusable(false);
        jListListaCanciones.setSelectionBackground(new java.awt.Color(204, 255, 255));
        jScrollPane1.setViewportView(jListListaCanciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 310, 240));

        jButtonRepetir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reproductor/botones/RepetirP.png"))); // NOI18N
        jButtonRepetir.setBorderPainted(false);
        jButtonRepetir.setContentAreaFilled(false);
        jButtonRepetir.setFocusable(false);
        jButtonRepetir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRepetirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRepetir, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 50, 40));

        jSliderControlVolumen.setBackground(new java.awt.Color(255, 255, 255));
        jSliderControlVolumen.setForeground(new java.awt.Color(255, 255, 255));
        jSliderControlVolumen.setValue(80);
        jSliderControlVolumen.setEnabled(false);
        jSliderControlVolumen.setOpaque(false);
        jPanel1.add(jSliderControlVolumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 570, 320, 20));

        jLabelRuta.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabelRuta.setText("Ruta:");
        jPanel1.add(jLabelRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 260, 30));

        jLabelCancion.setFont(new java.awt.Font("Georgia", 1, 15)); // NOI18N
        jLabelCancion.setText("Cancion:");
        jPanel1.add(jLabelCancion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, -1, -1));

        jLabelTitulo.setFont(new java.awt.Font("Georgia", 1, 15)); // NOI18N
        jLabelTitulo.setText("Titulo:");
        jPanel1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, -1));

        jLabelGenero.setFont(new java.awt.Font("Georgia", 1, 15)); // NOI18N
        jLabelGenero.setText("Genero:");
        jPanel1.add(jLabelGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));

        jLabelTamano.setFont(new java.awt.Font("Georgia", 1, 15)); // NOI18N
        jLabelTamano.setText("Peso:");
        jPanel1.add(jLabelTamano, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, -1, -1));

        jLabelTiempo.setFont(new java.awt.Font("Georgia", 1, 15)); // NOI18N
        jLabelTiempo.setText("Duracion:");
        jPanel1.add(jLabelTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, -1, -1));
        jLabelTiempo.getAccessibleContext().setAccessibleName("jLabelTiempo");

        jLabelGrupo.setFont(new java.awt.Font("Georgia", 1, 15)); // NOI18N
        jLabelGrupo.setText("Grupo:");
        jPanel1.add(jLabelGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, -1, -1));

        jLabelFecha.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabelFecha.setText("Fecha:");
        jPanel1.add(jLabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, -1, -1));

        jLabelComentario.setFont(new java.awt.Font("Georgia", 1, 15)); // NOI18N
        jLabelComentario.setText("Comentario:");
        jPanel1.add(jLabelComentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, -1, -1));

        jLabelAlbum.setFont(new java.awt.Font("Georgia", 1, 15)); // NOI18N
        jLabelAlbum.setText("Album:");
        jPanel1.add(jLabelAlbum, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, -1, -1));

        jLabelFRate.setFont(new java.awt.Font("Georgia", 1, 15)); // NOI18N
        jLabelFRate.setText("Velocidad Muestreo:");
        jPanel1.add(jLabelFRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, -1, -1));

        jLabelBitrate.setFont(new java.awt.Font("Georgia", 1, 15)); // NOI18N
        jLabelBitrate.setText("Tasa de bits:");
        jPanel1.add(jLabelBitrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, -1, -1));

        jLabelPista.setFont(new java.awt.Font("Georgia", 1, 15)); // NOI18N
        jLabelPista.setText("Pista:");
        jPanel1.add(jLabelPista, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 80, -1));

        jLabelTotal.setFont(new java.awt.Font("Georgia", 1, 15)); // NOI18N
        jLabelTotal.setText("Total:");
        jPanel1.add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 300, -1, -1));

        jLabelTranscurrido.setFont(new java.awt.Font("Georgia", 1, 15)); // NOI18N
        jLabelTranscurrido.setText("Transcurrido:");
        jPanel1.add(jLabelTranscurrido, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, -1, -1));

        jLabelVolumen.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabelVolumen.setText("Volumen: 80");
        jPanel1.add(jLabelVolumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 530, 140, -1));

        jLabelFondo.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jPanel1.add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, 660));
        jPanel1.add(jLabelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 320, 170));

        jButtonLimpiarLista.setBackground(new java.awt.Color(0, 0, 0));
        jButtonLimpiarLista.setText("ELIMINAR LISTA DE CANCIONES");
        jButtonLimpiarLista.setBorderPainted(false);
        jButtonLimpiarLista.setContentAreaFilled(false);
        jButtonLimpiarLista.setFocusable(false);
        jButtonLimpiarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarListaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonLimpiarLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 300, 40));

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButtonAvance.setText("Siguiente");
        jButtonAvance.setBorderPainted(false);
        jButtonAvance.setContentAreaFilled(false);
        jButtonAvance.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonAvance.setFocusable(false);
        jButtonAvance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAvanceActionPerformed(evt);
            }
        });

        jButtonRetroceso.setText("Anterior");
        jButtonRetroceso.setBorderPainted(false);
        jButtonRetroceso.setContentAreaFilled(false);
        jButtonRetroceso.setFocusable(false);
        jButtonRetroceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetrocesoActionPerformed(evt);
            }
        });

        jButtonPausar.setText("Pause");
        jButtonPausar.setBorderPainted(false);
        jButtonPausar.setContentAreaFilled(false);
        jButtonPausar.setFocusable(false);
        jButtonPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPausarActionPerformed(evt);
            }
        });

        jButtonParar.setText("Stop");
        jButtonParar.setBorderPainted(false);
        jButtonParar.setContentAreaFilled(false);
        jButtonParar.setFocusable(false);
        jButtonParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPararActionPerformed(evt);
            }
        });

        jButtonReproducir.setText("Play");
        jButtonReproducir.setBorderPainted(false);
        jButtonReproducir.setContentAreaFilled(false);
        jButtonReproducir.setFocusable(false);
        jButtonReproducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReproducirActionPerformed(evt);
            }
        });

        jButtonDirectorio.setText("Carpeta");
        jButtonDirectorio.setBorderPainted(false);
        jButtonDirectorio.setContentAreaFilled(false);
        jButtonDirectorio.setFocusable(false);
        jButtonDirectorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDirectorioActionPerformed(evt);
            }
        });

        jButtonMute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reproductor/botones/MuteP.png"))); // NOI18N
        jButtonMute.setText("Repetir");
        jButtonMute.setBorderPainted(false);
        jButtonMute.setContentAreaFilled(false);
        jButtonMute.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonMute.setFocusable(false);
        jButtonMute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMuteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonDirectorio, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonMute, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonRetroceso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonReproducir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPausar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonParar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAvance)))
                .addGap(58, 58, 58))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAvance, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRetroceso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPausar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonParar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReproducir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDirectorio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMute, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 34, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 360, 130));

        jLabelTemaFondo.setMinimumSize(new java.awt.Dimension(720, 480));
        jPanel1.add(jLabelTemaFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-230, -200, 830, 630));

        jLabelRuta1.setFont(new java.awt.Font("Georgia", 1, 15)); // NOI18N
        jLabelRuta1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRuta1.setText("Ruta:");
        jPanel1.add(jLabelRuta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, -1));

        jSliderProgresoMp3.setBackground(new java.awt.Color(255, 255, 255));
        jSliderProgresoMp3.setForeground(new java.awt.Color(255, 255, 255));
        jSliderProgresoMp3.setValue(0);
        jSliderProgresoMp3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSliderProgresoMp3.setOpaque(false);
        jPanel1.add(jSliderProgresoMp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 480, 330, 20));
        jSliderProgresoMp3.getAccessibleContext().setAccessibleName("");
        jSliderProgresoMp3.getAccessibleContext().setAccessibleParent(jPanel1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReproducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReproducirActionPerformed
      
       int indice = jListListaCanciones.getSelectedIndex();
       
       if (archivo!=null & Audio.getStatus()!=0 & indice!=-1){
           //System.out.println(Audio.getSleepTime());
           String ReproduceCancion = datos.get(indice);
           //System.out.println(ReproduceCancion);
           archivo = new File(ReproduceCancion);
          
           jSliderControlVolumen.setEnabled(true);
           jSliderProgresoMp3.setEnabled(true);
           
           CaratulaCancion(archivo.toString());
           try {
               
               Audio.open(new File(ReproduceCancion));
               Audio.play();
               Audio.setGain(volumen);
               Audio.setPan(balance);
               int pista = jListListaCanciones.getAnchorSelectionIndex()+1;
               new JLaTexto(fuente1, "Pista: "+ pista, jLabelPista, Color.WHITE, 15);
           
           } catch (BasicPlayerException ex) {
               JOptionPane.showMessageDialog(this, ex + "\n  la informacion de imagen de la cancion excede el pixelado admitido por la libreria ");
               

               try {
                   
                   Audio.stop();
                   
                   String RutaCancion = datos.get(indice);
                   AudioFile file = AudioFileIO.read(new File(RutaCancion));
                   Tag tager = file.getTag();
                   tager.deleteField(FieldKey.COVER_ART);
                   tager.deleteArtworkField();
                   AudioFileIO.write(file);
                   InputStream inputStream = new FileInputStream(ruta);
                   OutputStream outputStream =  new FileOutputStream("Audio.mp3");
                   
                   byte[] buf = new byte[1024];
                   int len;

                   while ((len = inputStream.read(buf)) > 0) {
                     outputStream.write(buf, 0, len);
                    }
                   inputStream.close();
                   outputStream.close();
                   
              
                    System.out.println();
                    System.out.println("El contenido de caratula mp3 es demasiado grande, Eliminela."); 
                   
                } 
               catch (IOException ex1) {System.out.println(ex1);} 
               catch (TagException ex1) {System.out.println(ex1);} 
               catch (ReadOnlyFileException ex1) {System.out.println(ex1);} 
               catch (InvalidAudioFrameException ex1) {System.out.println(ex1);} 
               catch (CannotWriteException ex1) {System.out.println(ex1);} 
               catch (CannotReadException ex1) {System.out.println(ex1);} 
               catch (BasicPlayerException ex1) {System.out.println(ex1);}  
               
               
               
       }         
    }//GEN-LAST:event_jButtonReproducirActionPerformed
    
    }
    
    private void jButtonPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPararActionPerformed
        
        if (Audio.getStatus()==0){
            try {
                
                bloquear=true;
                Audio.stop();
                bloquear=false;
  
            } catch (BasicPlayerException ex) {           }
            
            Reducir();
        }
    }//GEN-LAST:event_jButtonPararActionPerformed

    private void jButtonPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPausarActionPerformed
        
        if (Audio.getStatus()==1){
            try {
                Audio.resume();
            } catch (BasicPlayerException ex) {
                Logger.getLogger(InterfaceGrafica.class.getName()).log(Level.SEVERE, null, ex);
            }       
        }else  if (Audio.getStatus()==0){
            try {
                Audio.pause();
                Reducir();
            } catch (BasicPlayerException ex) {
                Logger.getLogger(InterfaceGrafica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jButtonPausarActionPerformed

    private void jButtonAvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAvanceActionPerformed
   
        if (jListListaCanciones.getSelectedIndex()+1!=agregaCanciones.length){
            bloquear=true;
            Comprovacion(1);
            bloquear=false;
        }
          
    }//GEN-LAST:event_jButtonAvanceActionPerformed

    private void jButtonRetrocesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetrocesoActionPerformed
         
        if (jListListaCanciones.getSelectedIndex()!=0){
            bloquear=true;
            Comprovacion(-1);
            bloquear=false;
        }
        
    }//GEN-LAST:event_jButtonRetrocesoActionPerformed

    private void jButtonDirectorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDirectorioActionPerformed

        
        
        abrirFile.setDialogTitle("Ruta Absoluta Busqueda:");
        abrirFile.setFileFilter(filtrado);
        abrirFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        
        if (abrirFile.showOpenDialog(jPanel1)==0){
            File file = new File(""+abrirFile.getSelectedFile());        
            
            String argumento = file.getName();//Obtenemos el nombre del archivo...
            argumento=argumento.substring(argumento.length()-3,argumento.length());//Obtenemos los tres ultimos caracteres de la cadena de nombre...
            
            //Evaluamos la condicion de que el archivo al que hacemos referencia exista....
            //Evaluamos la condicion de que el archivo que hacemos referencia sea de extension mp3...
            if (file.exists()& argumento.equals("mp3")){
                
                archivo = abrirFile.getSelectedFile();//Obtenemos la ruta del archivo..
                                 
                try {
                    audiofile = AudioFileIO.read(archivo);
                    tag =  audiofile.getTag();
     
                } catch (CannotReadException | IOException | TagException | 
                        ReadOnlyFileException | InvalidAudioFrameException ex) {
                    System.out.println("Error no hay archivo el argumento es "+archivo);
                }                     
                ruta = abrirFile.getCurrentDirectory().toString();
                new JLaTexto(fuente1, "Ruta: "+ ruta,jLabelRuta , Color.WHITE, 15);
              
                datos.add(archivo.toString());
                
                agregaCanciones = new String[datos.size()];
              
                int x=0;
                for (String cancion:datos){
                    File introduce = new File(cancion);
                    agregaCanciones[x] = introduce.getName();
                    x++;
                }
                jListListaCanciones.setListData(agregaCanciones);
                JLaEtiquetas(archivo);
            }   
            
        }   
        
    }//GEN-LAST:event_jButtonDirectorioActionPerformed
/**
 * 
 * @param jButtonRepetirActionPerformed
 * Boton de repetir las canciones
 */
    private void jButtonRepetirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRepetirActionPerformed
        
        if (!siguiente){
            
            if(repitaCancion){
                new BotonesEscucha(jButtonRepetir, "nombre.png", "nombre.png");
               
                repitaCancion=false;
                System.out.println(repitaCancion);
            
             }else {
                new BotonesEscucha(jButtonRepetir,"nombre.png","nombre.png");
               
                repitaCancion=true;
                System.out.println(repitaCancion);
            }
        }
        
        
    }//GEN-LAST:event_jButtonRepetirActionPerformed
/**
 * 
 * @param jButtonMuteActionPerformed
 * Boton de silenciar el volumen =0;
 */
    private void jButtonMuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMuteActionPerformed
        
        if (archivo!=null){
           if(mute){
               volumen = volumenM;
               jSliderControlVolumen.setValue((int)(volumen*100)); 
               new BotonesEscucha(jButtonMute, "nombre.png", "nombre.png");
                     
               mute=false;
               System.out.println(mute);
            
             }else {
               volumenM=volumen;
               volumen=0f;
               jSliderControlVolumen.setValue(0); 
               new BotonesEscucha(jButtonMute,"nombre.png","nombre.png");
              
               mute=true;
               System.out.println(mute);
            }
            
            
        }   
    }//GEN-LAST:event_jButtonMuteActionPerformed

    
    
    
    /**
     * 
     * @param jButtonLimpiarListaActionPerformed
     * eliminar todas las canciones en la lista de musica
     */
    
    
    private void jButtonLimpiarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarListaActionPerformed
        // TODO add your handling code here:
        datos.clear();
        agregaCanciones = new String[datos.size()];
        jListListaCanciones.setListData(agregaCanciones);
       
        
    }//GEN-LAST:event_jButtonLimpiarListaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        int indice = jListListaCanciones.getSelectedIndex();
        
        if (agregaCanciones[0]!=null && indice!=-1 ){
            
            datos.remove(indice);
            agregaCanciones = new String[datos.size()];
            int x=0;
             for (String anade:datos){
                 File file = new File(anade);		
                 agregaCanciones[x]=file.getName();	
                 x++;      
             }      
             jListListaCanciones.setListData(agregaCanciones);
            
        }
     
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
       jButtonDirectorio.doClick();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        
        jButtonAvance.doClick();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    
    //Metodos Para el programa-----------------------------------------------------------------
    
    public void jlistlistener(){
        
        jListListaCanciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(jListListaCanciones.getAnchorSelectionIndex());
                
                int indice = jListListaCanciones.getSelectedIndex();

                 if (indice!=-1){
                    String ReproduceCancion = datos.get(indice);
       
                    File file = new File(ReproduceCancion);
                    try {
                    audiofile = AudioFileIO.read(file);                   
                    tag=audiofile.getTag();

                    } catch (CannotReadException | IOException | TagException | NullPointerException |
                        ReadOnlyFileException | InvalidAudioFrameException ex) {System.out.println("Error.. " + ex); }
                    
                    //Hace la llamada al metodo encargado de rellenar los JLbels....
                    JLaEtiquetas(file);
                    CaratulaCancion(file.toString());
                    if (e.getClickCount()==2){
                        try {
                            bloquear=true;
                            Audio.stop();
                            bloquear=false;
                        } catch (BasicPlayerException ex) {System.out.println("Error... " + ex);}
                        jButtonReproducir.doClick();
                        if (Audio.getStatus()==2){
                            jButtonReproducir.doClick();
                        }
                    }
                 }
            } 
        });
    }
    
    public void CaratulaCancion(String rut){    //Este metodo se encarga de leer las ediquetas del mp3 y obtener la imagen de la cancion mp3.
        Image img = null;        
        try { 
            Mp3File Mp3A = new Mp3File(rut);
            if (Mp3A.hasId3v2Tag()){
                ID3v2 idTag = Mp3A.getId3v2Tag();
                //idTag.clearFrameSet(ID3v24Tag.ID_IMAGE);  
                byte[] datosImagen = idTag.getAlbumImage();               
                img = ImageIO.read(new ByteArrayInputStream(datosImagen));
            }
            else {  //En el caso de que el mp3 no contenga imagen (establecemos una imagen por defecto..)
                img = ImageIO.read(getClass().getResource("fondos/NoMusic.png"));					        
            }
        } 
        catch (IllegalArgumentException | IOException ex1){System.out.printf("No Expecificas ruta"); }
        catch (NullPointerException e1) {System.out.println("No hay caratula en el mp3");
         
        try {
            //En el caso de que el mp3 no contenga imagen y lance una excepcion...(establecemos una imagen por defecto..)
            img = ImageIO.read(getClass().getResource("fondos/NoMusic.png"));
        } 
        catch (IOException e) {}
        } 
        catch (UnsupportedTagException | InvalidDataException e) {}
        //Este codigo nos ayudara a reajustar la imagen a nuestro JLabel para que este se redimensione.....
        int ancho = img.getWidth(null);
        int alto = img.getHeight(null);       
        if (ancho>390){
            ancho=390;
        } 
        if (alto>270){
            alto=270;
        }
        
        img = img.getScaledInstance(ancho, alto,0);
        jLabelImagen.setIcon(new ImageIcon(img));
        

    }
    
    public void Reducir(){      //Este metodo se encarga de crear un efecto de cerrado de sonido (las barras del equalizador disminuyen progresivamente)
        Thread cerrar = new Thread(new Runnable() {
                @Override
                public void run() {
                    
                    for (int x=130;x>0;x--){
                    
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException ex) {    }
                }
                
                }
            });
            
            cerrar.start();
    }
    
    public void CalculoSecundero(String milisegundos,String texto,JLabel label){
        float horas,mint;
        float segundostotal =  Integer.parseInt(milisegundos)/1000000;//Almacenamos y pasamos a segundos los microsegundos obtenenidos.

        horas = (int)segundostotal/3600;		//Conversion de segundostotal a horas.
        mint = (int)segundostotal/60-horas *60;		//Conversion de segundostotal a minutos.
        segundostotal= segundostotal-mint*60-horas*3600;//Conversion de segundostotal a segundos.

        String secundero = (int)horas + ":" +(int) mint +":"+ (int)segundostotal;//Creamos una variable String para almacenar el tiempo total horas, minutos, segundos.              

        new JLaTexto(fuente1, texto+secundero, label, c2, 15);
    }
    
    public void basic_playerlistener(){
        Audio.addBasicPlayerListener(new BasicPlayerListener() {
            @Override//Este metodo se cumple cuando abrimos la cancion...
            public void opened(Object o, Map map) {
               //System.out.println(map);
               
               //LLamamos al metodo para que nos imprima el tiempo de duracion de la cancion....
               CalculoSecundero(map.get("duration").toString(), "Duracion: ", jLabelTiempo);
               
               new JLaTexto(fuente1, "Tasa de bits: "+map.get("bitrate"), jLabelBitrate, c, 15);
               new JLaTexto(fuente1, "Velocidad Muestreo: "+map.get("mp3.frequency.hz"), jLabelFRate, c, 15);

               jSliderProgresoMp3.setMaximum(Integer.parseInt(map.get("mp3.length.bytes").toString()));
               jSliderProgresoMp3.setMinimum(0);
            }

            @Override//Este metodo se cumple cuando la cancion esta en progreso....
            public void progress(int i, long l, byte[] bytes, Map propiedades) {				
                 
                ElementosMap= propiedades;
                
                eculi = (float[]) ElementosMap.get("mp3.equalizer");
                
                eculi[0] = E0;
                eculi[1] = E1;
                eculi[2] = E2;
                eculi[3] = E3;
                eculi[4] = E4;
                eculi[5] = E5;
                eculi[6] = E6;
                eculi[7] = E7;
                eculi[8] = E8;
                eculi[9] = E9;
                
                //Hay que añadir estas lineas de codigo para el equalizador funcione
                //Aqui hacemos la llamada a la clase Ecualizador_Ghapics que instanciamos previamente
                try{
                   
                }catch(ArrayIndexOutOfBoundsException e){System.out.println("Error"+e);}
                
                //LLamamos al este metodo que nos calcula el tiempo trancurrido...
                CalculoSecundero(propiedades.get("mp3.position.microseconds").toString(), "Transcurrido: ", jLabelTranscurrido);

                Object bytesTranscurrido =  propiedades.get("mp3.position.byte");
                bytesTranscurrido= Integer.parseInt(bytesTranscurrido.toString());               
                jSliderProgresoMp3.setValue((int)bytesTranscurrido);                     
            }

            @Override
            public void stateUpdated(BasicPlayerEvent bpe) {
                    
                if (!bloquear){
                    if (Audio.getStatus()==2 & repitaCancion){
                        jButtonReproducir.doClick();
                    }
                    if (jListListaCanciones.getSelectedIndex()+1!=agregaCanciones.length){
                        if (Audio.getStatus()==2 & siguiente){
                            int pista = jListListaCanciones.getAnchorSelectionIndex();                            
                            jListListaCanciones.setSelectedIndex(pista+1);
                            repaint();
                            jButtonReproducir.doClick();
                        }
                    }
                }                
            }

            @Override
            public void setController(BasicController bc) {
                
            }
        });
        
    }
    
    public void SlidersChange(){
        
        jSliderProgresoMp3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    Audio.pause();
                } catch (BasicPlayerException ex) {
                    Logger.getLogger(InterfaceGrafica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    jSliderProgresoMp3.setValue(jSliderProgresoMp3.getValue());
                    Audio.resume();
                    Audio.seek(jSliderProgresoMp3.getValue());
                    Audio.setGain(volumen);
                    Audio.setPan(balance);
                    
                } catch (BasicPlayerException ex) {
                    Logger.getLogger(InterfaceGrafica.class.getName()).log(Level.SEVERE, null, ex); }
            }
        });
        
        jSliderControlVolumen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                
                if (Audio.getStatus()!=-1){
                   try {
                       volumen = jSliderControlVolumen.getValue()/100f;
                       Audio.setGain(volumen);
                       new JLaTexto(fuente2, "Volum: " + volumen,jLabelVolumen , c1, 15);
                    
                   } catch (BasicPlayerException ex) {
                    Logger.getLogger(InterfaceGrafica.class.getName()).log(Level.SEVERE, null, ex); }
                }
            } 
        });
        
      
    }
       
    public void Comprovacion(int opera){
        //Audio.getStatus() valor -1 al empezar... 
        //valor 0 cuando se reproduce..
        //valor 1 cuando esta pausado..
        //valor 2 cuando detienes la cancion...
        
        int indice = jListListaCanciones.getSelectedIndex();        
        if (archivo!=null & indice!=-1 & Audio.getStatus()==0){
            //El metodo getAnchotSelectionIndex obtenemos el numero de posicion en el que se encuentra el JList...
            int pista = jListListaCanciones.getAnchorSelectionIndex();
            jListListaCanciones.setSelectedIndex(pista+opera);
            try {
                Audio.stop();
            } catch (BasicPlayerException ex) {
                Logger.getLogger(InterfaceGrafica.class.getName()).log(Level.SEVERE, null, ex);
            }
            jButtonReproducir.doClick();
        }
    }
    
    public void JLaEtiquetas(File file){
        
            new JLaTexto(fuente1, "Total: "+datos.size(), jLabelTotal, Color.WHITE, 15);
            new JLaTexto(fuente1, "Cancion: "+file.getName(), jLabelCancion, c, 15);
            new JLaTexto(fuente1, "Peso: "+file.length()+" bits",jLabelTamano,c, 15);
          try {  
            new JLaTexto(fuente1, "Titulo: "+tag.getFirst(FieldKey.TITLE), jLabelTitulo, c, 15);     
            new JLaTexto(fuente1, "Genero: "+tag.getFirst(FieldKey.GENRE), jLabelGenero, c, 15);
            new JLaTexto(fuente1, "Grupo: "+tag.getFirst(FieldKey.ARTIST), jLabelGrupo, c, 15);
            new JLaTexto(fuente1, "Fecha: "+tag.getFirst(FieldKey.YEAR), jLabelFecha, c, 15);
            new JLaTexto(fuente1, "Album: "+tag.getFirst(FieldKey.ALBUM), jLabelAlbum, c, 15);
            new JLaTexto(fuente1, "Comentario: "+tag.getFirst(FieldKey.COMMENT), jLabelComentario, c, 15);
            
        } catch (NullPointerException e) { System.out.print("Error en las etiquetas, el tag es igual a "+ tag);
        c = new Color(58,68,72);
        new JLaTexto(fuente1, "Titulo: ", jLabelTitulo, c, 15);     
        new JLaTexto(fuente1, "Genero: ", jLabelGenero, c, 15);
        new JLaTexto(fuente1, "Grupo: ", jLabelGrupo, c, 15);
        new JLaTexto(fuente1, "Fecha: ", jLabelFecha, c, 15);
        new JLaTexto(fuente1, "Album: ", jLabelAlbum, c, 15);
        new JLaTexto(fuente1, "Comentario: ", jLabelComentario, c, 15);
        c = Color.BLACK;
        }
  
    }
    
    

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceGrafica().setVisible(true);
            }
        });
    }
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuEmergente;
    private javax.swing.JButton jButtonAvance;
    private javax.swing.JButton jButtonDirectorio;
    private javax.swing.JButton jButtonLimpiarLista;
    private javax.swing.JButton jButtonMute;
    private javax.swing.JButton jButtonParar;
    private javax.swing.JButton jButtonPausar;
    private javax.swing.JButton jButtonRepetir;
    private javax.swing.JButton jButtonReproducir;
    private javax.swing.JButton jButtonRetroceso;
    private javax.swing.JLabel jLabelAlbum;
    private javax.swing.JLabel jLabelBitrate;
    private javax.swing.JLabel jLabelCancion;
    private javax.swing.JLabel jLabelComentario;
    private javax.swing.JLabel jLabelFRate;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelGrupo;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelPista;
    private javax.swing.JLabel jLabelRuta;
    private javax.swing.JLabel jLabelRuta1;
    private javax.swing.JLabel jLabelTamano;
    private javax.swing.JLabel jLabelTemaFondo;
    private javax.swing.JLabel jLabelTiempo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelTranscurrido;
    private javax.swing.JLabel jLabelVolumen;
    private javax.swing.JList<String> jListListaCanciones;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSliderControlVolumen;
    private javax.swing.JSlider jSliderProgresoMp3;
    // End of variables declaration//GEN-END:variables


}
