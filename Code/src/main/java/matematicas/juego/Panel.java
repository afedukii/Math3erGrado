package matematicas.juego;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Panel extends JPanel{
    JLabel fondo = new JLabel();
    JButton b1,b2,b3;
    ActionListener oyente;
    public void Panel(){
        setLayout(null);
        
    }
    public void Componentes(int width, int height){
        fondo.setBounds(0, 0, width,height);
        add(fondo);
        
        Componentes();
    }
    
    public void Componentes(){
        ImageIcon img = new ImageIcon("popocatepetl.jpg");
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(),Image.SCALE_DEFAULT));
        fondo.setIcon(icono);
        //t.repaint();
        
        ImageIcon estacion = new ImageIcon("Estacion-Libre.png");
        Icon es = new ImageIcon(estacion.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        b1=new JButton();
        //b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setIcon(es);
        b1.setBounds(100,500,50,50);
        fondo.add(b1);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };b1.addActionListener(oyente);
    }
}