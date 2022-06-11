/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matematicas.juego;

import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.*;

/**
 *
 * @author david
 */
public class Ventana extends JFrame{
    
    Reglas reglas = new Reglas();
    Perfiles perfiles = new Perfiles();
    Menu menu = new Menu();
    
    Mundos m = new Mundos();
    Mundo m1 = new Mundo();
    Mundo m2 = new Mundo();
    Mundo m3 = new Mundo();
    
    public Ventana(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //Inicialización de VENTANA
        setTitle("MATEMATICAS 3° Grado");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(screenSize);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Icono
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image lcono_pantalla = toolkit.getImage("Iconos/icono.png");
        setIconImage(lcono_pantalla);
        
        //PANELES
        reglas.Componentes(this.getWidth(), this.getHeight(), this);
        
        
        perfiles.Componentes(this.getWidth(), this.getHeight(), this);
        
        
        menu.Componentes(this.getWidth(), this.getHeight(), this);
        
        //Paneles de mundos
        
        m.Mundos(this.getWidth(), this.getHeight(),this,m1,m2,m3);
        m1.Mundo(this.getWidth(), this.getHeight(),m,"Mundos\\mundo1.jpg");
        m2.Mundo(this.getWidth(), this.getHeight(),m,"Mundos\\mundo2.jpg");
        m3.Mundo(this.getWidth(), this.getHeight(),m,"Mundos\\mundo3.jpg");
        
        this.getContentPane().add(reglas);
        //this.getContentPane().add(m1);
        
    }
}
