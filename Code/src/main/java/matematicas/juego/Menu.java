package matematicas.juego;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author Alfredo
 */
public class Menu extends JPanel{
    JLabel prin = new JLabel(); 
    Ventana v;
    JLabel nom = new JLabel("ALF",SwingConstants.CENTER), m1= new JLabel(),m2= new JLabel(),m3= new JLabel(),m4= new JLabel(),m5= new JLabel(),m6= new JLabel();
    JLabel etm1= new JLabel("<-- MUNDO 1 -->",SwingConstants.CENTER),etm2= new JLabel("<-- MUNDO 2 -->",SwingConstants.CENTER),etm3= new JLabel("<-- MUNDO 3 -->",SwingConstants.CENTER);
    JLabel etAV= new JLabel("AVENTURA",SwingConstants.CENTER),etCR= new JLabel("CONTRA RELOJ",SwingConstants.CENTER);
    JLabel sd = new JLabel("",SwingConstants.CENTER);
    JLabel titulo = new JLabel(">MATEMATICAS 3°<",SwingConstants.CENTER);
    JLabel adv=new JLabel("AVENTURA",SwingConstants.CENTER),cr=new JLabel("CONTRA RELOJ",SwingConstants.CENTER);
    JPanel perfil = new JPanel();
    String mat [][];
    String[] vec ={"Name","0","0","0","0","0","0"};
    String estAnt="Ferchis,1,1,1,1,1,1";
    int px, py;
    Border prueba = BorderFactory.createLineBorder(Color.black);
    LineBorder bor = new LineBorder(Color.CYAN, 5, true);
    int tm;
    Stack <String> bd = new Stack<String>();
    
    public void Menu(){setLayout(null);}
    
    public void Componentes(int px, int py, Ventana v){
        this.px=px; this.py=py; this.v=v;
        prin.setBounds(0,0,px,py); add(prin);
        CargaFondo();
        CargaElementos();
        CargaDatos();
//        bd.push("Alfredo,1,1,1,1,1,1");
//        bd.push("David,1,1,1,1,1,1");
//        bd.push("Rogelio,1,1,1,1,1,1");
//        bd.push("Ferchis,1,1,1,1,1,1");
    }
    public void CargaFondo(){
        ImageIcon fondo = new ImageIcon("Mundos\\Mundos.jpeg");
        Icon icono = new ImageIcon(fondo.getImage().getScaledInstance(prin.getWidth(),prin.getHeight(),Image.SCALE_DEFAULT));
        prin.setIcon(icono);
        prin.repaint();
    }
    public void CargaElementos(){
        titulo.setBounds((int)(px*0.33),(int)(py*0.15),(int)(px*0.34),(int)(py*0.1));
        titulo.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(titulo.getHeight()*0.5) ));
        prin.add(titulo);
        titulo.setBorder(bor);
        adv.setBounds((int)(px*0.3425),(int)(py*0.26),(int)(px*0.14),(int)(py*0.05));
        adv.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(adv.getHeight()*0.5) ));
        prin.add(adv);
        adv.setBorder(bor);
        cr.setBounds((int)(px*0.5175),(int)(py*0.26),(int)(px*0.14),(int)(py*0.05));
        cr.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(cr.getHeight()*0.5) ));
        prin.add(cr);
        cr.setBorder(bor);
        titulo.setForeground(Color.white);
        adv.setForeground(Color.red);
        cr.setForeground(Color.yellow);
        perfil.setBounds((int)(px*0.33),(int)(py*0.35),(int)(px*0.34),(int)(py*0.45));
        perfil.setLayout(null);
        perfil.setBorder(bor);
        perfil.setBackground(new Color(59,131,185));
        prin.add(perfil);
        nom.setBounds((int)(perfil.getWidth()*0.01),(int)(perfil.getHeight()*0.02), (int)(perfil.getWidth()*0.98), (int)(perfil.getHeight()*0.07));
        //nom.setBorder(prueba);
        nom.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(nom.getHeight()*0.5)));
        nom.setForeground(Color.WHITE);
        perfil.add(nom);
        etAV.setBounds((int)(perfil.getWidth()*0.01),(int)(perfil.getHeight()*0.1), (int)(perfil.getWidth()*0.49), (int)(perfil.getHeight()*0.07));
        //etAV.setBorder(prueba);
        etAV.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(nom.getHeight()*0.5)));
        etAV.setForeground(Color.WHITE);
        perfil.add(etAV);
        etCR.setBounds((int)(perfil.getWidth()*0.5),(int)(perfil.getHeight()*0.1), (int)(perfil.getWidth()*0.49), (int)(perfil.getHeight()*0.07));
        //etCR.setBorder(prueba);
        etCR.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(nom.getHeight()*0.5)));
        etCR.setForeground(Color.WHITE);
        perfil.add(etCR);
        etm1.setBounds((int)(perfil.getWidth()*0.375),(int)(perfil.getHeight()*0.26), (int)(perfil.getWidth()*0.25), (int)(perfil.getHeight()*0.07));
        //etm1.setBorder(prueba);
        etm1.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(nom.getHeight()*0.5)));
        etm1.setForeground(Color.WHITE);
        perfil.add(etm1);
        etm2.setBounds((int)(perfil.getWidth()*0.375),(int)(perfil.getHeight()*0.535), (int)(perfil.getWidth()*0.25), (int)(perfil.getHeight()*0.07));
        //etm2.setBorder(prueba);
        etm2.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(nom.getHeight()*0.5)));
        etm2.setForeground(Color.WHITE);
        perfil.add(etm2);
        etm3.setBounds((int)(perfil.getWidth()*0.375),(int)(perfil.getHeight()*0.81), (int)(perfil.getWidth()*0.25), (int)(perfil.getHeight()*0.07));
        //etm3.setBorder(prueba);
        etm3.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(nom.getHeight()*0.5)));
        etm3.setForeground(Color.WHITE);
        perfil.add(etm3);
        m1.setBounds((int)(perfil.getWidth()*0.18),(int)(perfil.getHeight()*0.2), (int)(perfil.getWidth()*0.15),  (int)(perfil.getWidth()*0.15));
        //m1.setBorder(prueba);
        m1.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(nom.getHeight()*0.5)));
        m1.setForeground(Color.WHITE);
        perfil.add(m1);
        m2.setBounds((int)(perfil.getWidth()*0.18),(int)(perfil.getHeight()*0.475), (int)(perfil.getWidth()*0.15),  (int)(perfil.getWidth()*0.15));
        //m2.setBorder(prueba);
        m2.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(nom.getHeight()*0.5)));
        m2.setForeground(Color.WHITE);
        perfil.add(m2);
        m3.setBounds((int)(perfil.getWidth()*0.18),(int)(perfil.getHeight()*0.75), (int)(perfil.getWidth()*0.15),  (int)(perfil.getWidth()*0.15));
        //m3.setBorder(prueba);
        m3.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(nom.getHeight()*0.5)));
        m3.setForeground(Color.WHITE);
        perfil.add(m3);
        m4.setBounds((int)(perfil.getWidth()*0.67),(int)(perfil.getHeight()*0.2), (int)(perfil.getWidth()*0.15),  (int)(perfil.getWidth()*0.15));
        //m4.setBorder(prueba);
        m4.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(nom.getHeight()*0.5)));
        m4.setForeground(Color.WHITE);
        perfil.add(m4);
        m5.setBounds((int)(perfil.getWidth()*0.67),(int)(perfil.getHeight()*0.475), (int)(perfil.getWidth()*0.15),  (int)(perfil.getWidth()*0.15));
        //m5.setBorder(prueba);
        m5.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(nom.getHeight()*0.5)));
        m5.setForeground(Color.WHITE);
        perfil.add(m5);
        m6.setBounds((int)(perfil.getWidth()*0.67),(int)(perfil.getHeight()*0.75), (int)(perfil.getWidth()*0.15),  (int)(perfil.getWidth()*0.15));
        //m6.setBorder(prueba);
        m6.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(nom.getHeight()*0.5)));
        m6.setForeground(Color.WHITE);
        perfil.add(m6);
        tm = (int)(perfil.getWidth()*0.15);
        sd.setBounds((int)(perfil.getWidth()*0.93),(int)(perfil.getHeight()*0.91),(int)(perfil.getWidth()*0.05),(int)(perfil.getWidth()*0.05));
        //sd.setBorder(prueba);
        int sIm = (int)(perfil.getWidth()*0.05);
        //añadir icono de guardado
        ImageIcon t = new ImageIcon("Iconos\\iSave.png");
        Icon iT = new ImageIcon(t.getImage().getScaledInstance(sIm,sIm,Image.SCALE_DEFAULT));
        sd.setIcon(iT);
        perfil.add(sd);
        acciones();
    }
    public void acciones(){
        adv.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                setVisible(false);
                v.m.setVisible(true);
                v.m.Modo("Aventura");
                v.getContentPane().add(v.m);
            }
        });
        cr.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                setVisible(false);
                v.m.setVisible(true);
                v.m.Modo("CR");
                v.getContentPane().add(v.m);
            }
        });
        sd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                guardaDatos();
            }
        });

    }
    public void CargaDatos(){
        ImageIcon [] meds = new ImageIcon[7];
        meds[0] = new ImageIcon("Medallas\\AP1.png");
        meds[1] = new ImageIcon("Medallas\\AP2.png");
        meds[2] = new ImageIcon("Medallas\\AP3.png");
        meds[3] = new ImageIcon("Medallas\\CR1.png");
        meds[4] = new ImageIcon("Medallas\\CR2.png");
        meds[5] = new ImageIcon("Medallas\\CR3.png");
        meds[6] = new ImageIcon("Medallas\\nani.png");
        
        nom.setText(vec[0]);
        if(!vec[1].equals("0")){
            if(vec[1].equals("1")){
                Icon f = new ImageIcon(meds[0].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                m1.setIcon(f);
            }
            if(vec[1].equals("2")){
                Icon f = new ImageIcon(meds[1].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                m1.setIcon(f);
            }
            if(vec[1].equals("3")){
                Icon f = new ImageIcon(meds[2].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                m1.setIcon(f);
            }
        }else{
            Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
            m1.setIcon(f);
        }
        if(!vec[2].equals("0")){
            if(vec[2].equals("1")){
                Icon f = new ImageIcon(meds[0].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                m2.setIcon(f);
            }
            if(vec[2].equals("2")){
                Icon f = new ImageIcon(meds[1].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                m2.setIcon(f);
            }
            if(vec[2].equals("3")){
                Icon f = new ImageIcon(meds[2].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                m2.setIcon(f);
            }
        }else{
            Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
            m2.setIcon(f);
        }
        if(!vec[3].equals("0")){
            if(vec[3].equals("1")){
                Icon f = new ImageIcon(meds[0].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                m3.setIcon(f);
            }
            if(vec[3].equals("2")){
                Icon f = new ImageIcon(meds[1].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                m3.setIcon(f);
            }
            if(vec[3].equals("3")){
                Icon f = new ImageIcon(meds[2].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                m3.setIcon(f);
            }
        }else{
            Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
            m3.setIcon(f);
        }
        if(!vec[4].equals("0")){
            if(vec[4].equals("1")){
                Icon f = new ImageIcon(meds[3].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                m4.setIcon(f);
            }
            if(vec[4].equals("2")){
                Icon f = new ImageIcon(meds[4].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                m4.setIcon(f);
            }
            if(vec[4].equals("3")){
                Icon f = new ImageIcon(meds[5].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                m4.setIcon(f);
            }
        }else{
            Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
            m4.setIcon(f);
        }
        if(!vec[5].equals("0")){
            if(vec[5].equals("1")){
                Icon f = new ImageIcon(meds[3].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                m5.setIcon(f);
            }
            if(vec[5].equals("2")){
                Icon f = new ImageIcon(meds[4].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                m5.setIcon(f);
            }
            if(vec[5].equals("3")){
                Icon f = new ImageIcon(meds[5].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                m5.setIcon(f);
            }
        }else{
            Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
            m5.setIcon(f);
        }
        if(!vec[6].equals("0")){
            if(vec[6].equals("1")){
                Icon f = new ImageIcon(meds[3].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                m6.setIcon(f);
            }
            if(vec[6].equals("2")){
                Icon f = new ImageIcon(meds[4].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                m6.setIcon(f);
            }
            if(vec[6].equals("3")){
                Icon f = new ImageIcon(meds[5].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                m6.setIcon(f);
            }
        }else{
            Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
            m6.setIcon(f);
        }
    }
    public void guardaDatos(){
        int c = bd.indexOf(estAnt);//busca en el stack
        bd.set(c,vec[0]+","+vec[1]+","+vec[2]+","+vec[3]+","+vec[4]+","+vec[5]+","+vec[6]);//modifica el progreso nuevo
        estAnt=bd.get(c);//el estado anterior se modifica con el actual
        //recorrido para guardar en txt
        try{
            File ar = new File("data.txt");
            FileWriter fw = new FileWriter(ar);
            BufferedWriter bw = new BufferedWriter(fw);
            String linea;
            for(int i=0;i<bd.size();i++){bw.write(bd.get(i)+"\n");}
            bw.close();
        }catch(IOException e){;}
        JOptionPane.showMessageDialog(null,"PROGRESO GUARDADO :)");
    }
}