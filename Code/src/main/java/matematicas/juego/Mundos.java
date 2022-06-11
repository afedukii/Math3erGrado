/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matematicas.juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class Mundos extends JPanel{
    JLabel fondo = new JLabel();
    JButton atras,b1,b2,b3;
    ActionListener oyente;
    Mundo m1;
    Mundo m2;
    Mundo m3;
    Ventana v;
    Mundos m;
    int px,py;
    String modo;
    public void Mundos(int width, int height,Ventana v,Mundo m1,Mundo m2,Mundo m3){
        setLayout(null);
        
        fondo.setBounds(0, 0, width,height);//FONDO
        add(fondo);
        
        px=width;
        py=height;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.v=v;
        this.m=this;
        
        Componentes();
    }
    
    public void Modo(String modo){
        this.modo=modo;
    }
    
    public void Componentes(){
        ImageIcon img = new ImageIcon("Mundos\\Mundos.jpeg");
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(),Image.SCALE_DEFAULT));
        fondo.setIcon(icono);
        //t.repaint();
        
        //BOTONES
        atras=new JButton("<");
        atras.setForeground(Color.CYAN);
        atras.setContentAreaFilled(false);
        atras.setBounds((int)(px*0.01),(int)(py*0.01),(int)(px*0.05),(int)(py*0.05));
        atras.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(atras.getHeight()*0.8) ));
        fondo.add(atras);
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                setVisible(false);
                v.menu.CargaDatos();
                v.menu.setVisible(true);
                v.getContentPane().add(v.menu);
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };atras.addActionListener(oyente);
        
        
        b1=new JButton("Mundo 1");
        b1.setForeground(Color.YELLOW);
        b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setBounds((int)(px*0.08),(int)(py*0.6),(int)(px*0.1),(int)(py*0.05));
        b1.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(b1.getHeight()*0.5) ));
        fondo.add(b1);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                setVisible(false);
                if(modo.equals("CR")){
                    m1.mj.setComponentes(1);
                    m1.mj.setVisible(true);
                    m1.m.v.getContentPane().add(m1.mj);
                }
                else{//AVENTURA
                m1.setVisible(true);
                v.getContentPane().add(m1);
                }
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };b1.addActionListener(oyente);
        
        
        b2=new JButton("Mundo 2");
        b2.setForeground(Color.RED);
        b2.setOpaque(false);
        b2.setContentAreaFilled(false);
        b2.setBounds((int)(px*0.45),(int)(py*0.6),(int)(px*0.1),(int)(py*0.05));
        b2.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(b2.getHeight()*0.5) ));
        fondo.add(b2);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                setVisible(false);
                if(modo.equals("CR")){
                    m2.mj.setComponentes(1);
                    m2.mj.setVisible(true);
                    m2.m.v.getContentPane().add(m2.mj);
                }
                else{//AVENTURA
                m2.setVisible(true);
                v.getContentPane().add(m2);
                }
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };b2.addActionListener(oyente);
        
        
        b3=new JButton("Mundo 3");
        b3.setForeground(Color.WHITE);
        b3.setOpaque(false);
        b3.setContentAreaFilled(false);
        b3.setBounds((int)(px*0.82),(int)(py*0.6),(int)(px*0.1),(int)(py*0.05));
        b3.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(b3.getHeight()*0.5) ));
        fondo.add(b3);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                setVisible(false);
                if(modo.equals("CR")){
                    m3.mj.setComponentes(1);
                    m3.mj.setVisible(true);
                    m3.m.v.getContentPane().add(m3.mj);
                }
                else{//AVENTURA
                m3.setVisible(true);
                v.getContentPane().add(m3);
                }
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };b3.addActionListener(oyente);
    }
}
