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
import javax.swing.*;

/**
 *
 * @author david
 */
public class Mundo extends JPanel{
    JLabel fondo = new JLabel();
    JButton atras;
    JButton b[] = new JButton[5];
    ActionListener oyente;
    Mundos m;
    String name;
    MJs mj;
    int px,py;
    int calif[] = new int[5];
    int califCR[] = new int[2];
    
    public void Mundo(int width, int height,Mundos m, String name){
        setLayout(null);
        
        fondo.setBounds(0, 0, width,height);
        add(fondo);
        
        px=width;
        py=height;
        this.name=name;
        this.m=m;
        mj = new MJs();
        mj.MJs(m.v.getWidth(), m.v.getHeight(), this);
        
        Componentes();
        this.setVisible(false);
    }
    
    public void Componentes(){
        ImageIcon img = new ImageIcon(name);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(),Image.SCALE_DEFAULT));
        fondo.setIcon(icono);
        fondo.repaint();
        
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
                m.setVisible(true);
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };atras.addActionListener(oyente);
        
        ImageIcon estacion = new ImageIcon("Estacion\\Estacion.png");
        Icon es = new ImageIcon(estacion.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        
        b[0]=new JButton();
        b[0].setContentAreaFilled(false);
        b[0].setBounds((int)(px*0.275),(int)(py*0.7),(int)(px*0.05),(int)(py*0.05));
        fondo.add(b[0]);
        
        oyente = new ActionListener(){  
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                setVisible(false);
                mj.setComponentes(1);
                mj.setVisible(true);
                m.v.getContentPane().add(mj);
                
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };b[0].addActionListener(oyente);
        
        estacion = new ImageIcon("Estacion\\EstacionB.png");
        es = new ImageIcon(estacion.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        
        b[1]=new JButton();
        b[1].setContentAreaFilled(false);
        b[1].setBounds((int)(px*0.375),(int)(py*0.75),(int)(px*0.05),(int)(py*0.05));
        fondo.add(b[1]);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                setVisible(false);
                mj.setComponentes(2);
                mj.setVisible(true);
                m.v.getContentPane().add(mj);
                
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };b[1].addActionListener(oyente);
        
        
        b[2]=new JButton();
        b[2].setContentAreaFilled(false);
        b[2].setBounds((int)(px*0.475),(int)(py*0.8),(int)(px*0.05),(int)(py*0.05));
        fondo.add(b[2]);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                setVisible(false);
                mj.setComponentes(3);
                mj.setVisible(true);
                m.v.getContentPane().add(mj);
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };b[2].addActionListener(oyente);
        
        
        b[3]=new JButton();
        b[3].setContentAreaFilled(false);
        b[3].setBounds((int)(px*0.575),(int)(py*0.75),(int)(px*0.05),(int)(py*0.05));
        fondo.add(b[3]);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                setVisible(false);
                mj.setComponentes(4);
                mj.setVisible(true);
                m.v.getContentPane().add(mj);
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };b[3].addActionListener(oyente);
        
        
        b[4]=new JButton();
        b[4].setContentAreaFilled(false);
        b[4].setBounds((int)(px*0.675),(int)(py*0.7),(int)(px*0.05),(int)(py*0.05));
        fondo.add(b[4]);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                setVisible(false);
                mj.setComponentes(5);
                mj.setVisible(true);
                m.v.getContentPane().add(mj);
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };b[4].addActionListener(oyente);
        cargarNiveles();
    }
    
    public void cargarNiveles(){
        ImageIcon estacion = new ImageIcon("Estacion\\Estacion.png");
        Icon es = new ImageIcon(estacion.getImage().getScaledInstance(b[0].getWidth(),b[0].getHeight(),Image.SCALE_DEFAULT));
        
        estacion = new ImageIcon("Estacion\\EstacionB.png");
        Icon esB = new ImageIcon(estacion.getImage().getScaledInstance(b[0].getWidth(),b[0].getHeight(),Image.SCALE_DEFAULT));
        
        b[0].setIcon(es);
        int califTotal=0;
        for (int i = 1; i < 5; i++) {
            if(calif[i-1]>6){
                b[i].setIcon(es);
                b[i].setEnabled(true);
            }
            else{
                b[i].setIcon(esB);
                b[i].setEnabled(false);
            }
            califTotal = califTotal + calif[i];
        }
        switch(name){
            case "Mundos\\mundo1.jpg":
                if(califTotal>24)
                    m.v.menu.vec[1] = "1";
                if(califTotal>32)
                    m.v.menu.vec[1] = "2";
                if(califTotal==40)
                    m.v.menu.vec[1] = "3";
                break;
            case "Mundos\\mundo2.jpg":
                if(califTotal>24)
                    m.v.menu.vec[2] = "1";
                if(califTotal>32)
                    m.v.menu.vec[2] = "2";
                if(califTotal==40)
                    m.v.menu.vec[2] = "3";
                break;
            case "Mundos\\mundo3.jpg":
                if(califTotal>24)
                    m.v.menu.vec[3] = "1";
                if(califTotal>32)
                    m.v.menu.vec[3] = "2";
                if(califTotal==40)
                    m.v.menu.vec[3] = "3";
                break;
        }
    }
    
    public void califCR(int med){
        switch(name){
            case "Mundos\\mundo1.jpg":
                if(med==1)
                    m.v.menu.vec[4] = "1";
                if(med==2)
                    m.v.menu.vec[4] = "2";
                if(med==3)
                    m.v.menu.vec[4] = "3";
                break;
            case "Mundos\\mundo2.jpg":
                if(med==1)
                    m.v.menu.vec[5] = "1";
                if(med==2)
                    m.v.menu.vec[5] = "2";
                if(med==3)
                    m.v.menu.vec[5] = "3";
                break;
            case "Mundos\\mundo3.jpg":
                if(med==1)
                    m.v.menu.vec[6] = "1";
                if(med==2)
                    m.v.menu.vec[6] = "2";
                if(med==3)
                    m.v.menu.vec[6] = "3";
                break;
        }
    }
}
