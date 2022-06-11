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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.*;

/**
 *
 * @author david
 */
public class MJs extends JPanel{
    JLabel fondo = new JLabel();
    JButton b1,b2,b3;
    ActionListener oyente;
    Mundo mx;
    int px,py;
    long tiempoInicio, tiempoFin;
    double ttot;//CR
    String cad="";
    public void MJs(int width, int height, Mundo mx){
        setLayout(null);
        
        
        px=width;
        py=height;
        this.mx=mx;
        
        setVisible(false);
    }
    public void setComponentes(int level){
        fondo.setBounds(0, 0, px,py);
        add(fondo);
        
        setVisible(true);
        ImageIcon img = new ImageIcon(mx.name);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(),Image.SCALE_DEFAULT));
        fondo.setIcon(icono);
        System.out.println(mx.name);
        //limpiarObjetos();
        switch(mx.name){
            case "Mundos\\mundo1.jpg":
                switch(mx.m.modo){
                    case "Aventura":
                        switch(level){
                            case 1:
                                M1L1();
                                break;
                            case 2:
                                M1L2();
                                break;
                            case 3:
                                M1L3();
                                break;
                            case 4:
                                M1L4();
                                break;
                            case 5:
                                M1L5();
                                break;
                        }
                        break;
                    case "CR"://DEBE REGRESAR A MUNDOS Y NO A MUNDO
                        switch(level){
                            case 1:
                                M1CR1();
                                break;
                            case 2:
                                M1CR2();
                                break;
                        }
                        break;
                }
                break;
            case "Mundos\\mundo2.jpg":
                switch(mx.m.modo){
                    case "Aventura":
                        switch(level){
                            case 1:
                                M2L1();
                                break;
                            case 2:
                                M2L2();
                                break;
                            case 3:
                                M2L3();
                                break;
                            case 4:
                                M2L4();
                                break;
                            case 5:
                                M2L5();
                                break;
                        }
                        break;
                    case "CR":
                        switch(level){
                            case 1:
                                M2CR1();
                                break;
                            case 2:
                                M2CR2();
                                break;
                        }
                        break;
                }
                break;
            case "Mundos\\mundo3.jpg":
                switch(mx.m.modo){
                    case "Aventura":
                        switch(level){
                            case 1:
                                M3L1();
                                break;
                            case 2:
                                M3L2();
                                break;
                            case 3:
                                M3L3();
                                break;
                            case 4:
                                M3L4();
                                break;
                            case 5:
                                M3L5();
                                break;
                        }
                        break;
                    case "CR":
                        switch(level){
                            case 1:
                                M3CR1();
                                break;
                            case 2:
                                M3CR2();
                                break;
                        }
                        break;
                }
                break;
        }
    }
    
    private void num(JTextArea a){
        a.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c))
                    e.consume();
            }
        });
    }
    
    private void num2DIG(JTextArea a){
        a.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c) || a.getText().length()>1)
                    e.consume();
            }
        });
    }
    
    private void sign(JTextArea a){
        a.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!(c == '<' || c == '>' || c == '=') || a.getText().length()>0)
                    e.consume();
            }
        });
    }
    
    private boolean repetido(int den[], int num[], int i){
        for (int j = 0; j < i; j++) {
            if(den[i]==den[j] && num[i]==num[j])
                return true;
        }
        return false;
    }
    
    private boolean repetido(int num[], int i){
        for (int j = 0; j < i; j++) {
            if(num[i]==num[j])
                return true;
        }
        return false;
    }
    
    private int operacion(String cad){
        String[] a;
        if(cad.contains("-")){
            a = cad.split("-");
            return Integer.parseInt(a[0])-Integer.parseInt(a[1]);
        }
        a = cad.split("\\+");
        return Integer.parseInt(a[0])+Integer.parseInt(a[1]);
    }
    
    //OBJETOS INTRODUCCION
    //Personajes
    JLabel nino, nina,ejemplo;
    ImageIcon inina,inino,ej;
    Icon iconoA,iconoB,iconoC;
    //Panel de texto
    JPanel txt;
    JTextArea texto;
    //Boton de avanzar
    JLabel nxt;
    //EstiloBorde
    LineBorder bor = new LineBorder(Color.CYAN, 5, true);
    //Contadores y Banderas
    int c,mA;
    
    public void limpiarObjetos(){
        txt = new JPanel();
        texto.setText("");
        c=0;
    }
    
    public void escondeIntro(){
        nino.setVisible(false);nina.setVisible(false);
        txt.setVisible(false);nxt.setVisible(false);
    }
    
    public void iniciaIntro(int id){
        //InicioVariables
        nino=new JLabel(); nina=new JLabel(); ejemplo=new JLabel();
        txt = new JPanel();
        texto = new JTextArea();
        nxt=new JLabel("<¡Clic en el AQUÍ para avanzar!>",SwingConstants.CENTER);
        
        //Adds
        fondo.add(nino);fondo.add(nina);
        fondo.add(txt);fondo.add(nxt);
        //InicioPersonajes
        nina.setBounds((int)(px*0.775), (int)(py*0.11), (int)(px*0.21), (int)(py*0.8));
        nino.setBounds((int)(px*0.025), (int)(py*0.11), (int)(px*0.2), (int)(py*0.8));
        inina = new ImageIcon("Personajes\\1 cc.png");inino = new ImageIcon("Personajes\\2 aa.png");
        iconoA= new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
        iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
        nina.setIcon(iconoA);nino.setIcon(iconoB);
        
        //InicioPanel
        txt.setLayout(null);
        txt.setBounds((int)(px*0.3), (int)(py*0.3), (int)(px*0.4), (int)(py*0.4));
        txt.setBackground(new Color(59,131,189));
        txt.setBorder(bor);
        //ImagenEjemplo
        ejemplo.setBounds((int)(txt.getWidth()*0.03),(int)(txt.getHeight()*0.03),(int)(txt.getWidth()*0.6),(int)(txt.getHeight()*0.94));
        ejemplo.setVisible(false);
        txt.add(ejemplo);
        //AreaDeTextoPanel
        txt.add(texto);
        texto.setBounds((int)(txt.getWidth()*0.01),(int)(txt.getHeight()*0.02), (int)(txt.getWidth()*0.98), (int)(txt.getHeight()*0.97));
        texto.setEditable(false);
        texto.setOpaque(false);
        texto.setFont(new Font("Comic Sans MS", Font.PLAIN,(int)(txt.getHeight()*0.104)));
        texto.setForeground(Color.WHITE);
        //texto.setText("");
        //InicioBoton
        nxt.setBounds((int)(px*0.4), (int)(py*0.71), (int)(px*0.2), (int)(py*0.05));
        nxt.setBackground(new Color(59,131,189));
        nxt.setLayout(null);
        nxt.setOpaque(true);
        nxt.setBorder(bor);
        nxt.setFont(new Font("Comic Sans MS", Font.PLAIN,(int)(nxt.getHeight()*0.45)));
        nxt.setForeground(Color.WHITE);
        //InicioContadorBandera
        c=0;mA=id;
        //InicioPrimerDato
        switch(id){
            case 1:
                texto.setText("\n\n                         ¡HOLA!\n        Bienvenido al primer mundo.");
            break;
            case 2:
                texto.setText("\n\n                         ¡HOLA!\n       Bienvenido al segundo mundo.");
            break;
            case 3:
                texto.setText("\n\n                         ¡HOLA!\n        Bienvenido al tercer mundo.");
            break;
            case 4://M1L2//M1L4
                texto.setText("\n                         ¡HOLA!\nParece que este ejercicio se complicó.\n     Descuida, no todo siempre sale\n                     a la primera.\n              Repasemos un poco...");
            break;
            case 5://M1L3//M1L5
                texto.setText("\n                         ¡HEY!\n        La dificultad va en aumento.\n         Unas veces se gana y otras\n                     se aprende.\n             Repasemos de nuevo...");
            break;
            case 6://M2L2//M2L4
                texto.setText("\n              ¡HOLA DE NUEVO!\n       Tal vez el tema no sea fácil,\n            pero merecerá la pena.\n              Repasemos un poco...");
            break;
            case 7://M2L3//M2L5
                texto.setText("\n              ¡HOLA DE NUEVO!\n       Tal vez el tema no sea fácil,\n            pero merecerá la pena.\n              Repasemos un poco...");
            break;
            case 8://M3L2//M3L4
                texto.setText("\n                  ¡HOLA, HOLA!\n  Este tema fue más difícil, ¿cierto?\n        Recuerda que de los errores\n                     se aprende.\n          Repasemos nuevamente...");
            break;
            case 9://M3L3//M3L5
                texto.setText("\n           ¡HOLA NUEVAMENTE!\n  No te preocupes si te equivocaste.\n      Incluso un experto alguna vez\n                fue principiante.\n            Demos un repaso más!");
            break;
            case 10: case 17: case 21://SIN MEDALLA
                texto.setText("\n\n                         ¡HEY!\n     Parece que no te fue muy bien.");
            break;
            case 11://BRONCE
                texto.setText("\n\n                        ¡HOLA!\n     No te fue nada mal en este nivel.");
            break;
            case 12://PLATA
                texto.setText("\n\n                        ¡HOLA!\n Parece que estas agarrando el ritmo.");
            break;
            case 13://ORO
                texto.setText("\n\n              ¡HEY, HEY, HEYYY!\n      Parece que dominaste el tema.");
            break;
            case 14: case 18://ESMERALDA
                texto.setText("\n                        ¡HOLA!\n Parece que necesitar practicar más.\n    Puedes volver a revisar la teoría\n             en el modo Aventura.");
            break;
            case 15: case 19://DIAMANTE
                texto.setText("\n\n                        ¡HOLA!\n              Vas mejorando pero\n        aun puedes hacerlo mejor!");
            break;
            case 16: case 20://ZAFIRO
                texto.setText("\n\n              ¡HEY, HEY, HEYYY!\n       ¡Parece que no tenemos nada\n             más que enseñarte!");
            break;
            default:break;
        }
        c++;
        //Hace Visibles
        nino.setVisible(true);nina.setVisible(true);
        txt.setVisible(true);nxt.setVisible(true);
        creaEventoNXT();
    }
    
    public void creaEventoNXT(){
        nxt.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println(c);
                switch(mA){
                    case 1:
                        switch(c){
                            /*case 0:
                                texto.setText("\n\n                       ¡HOLA!\n        Bienvenido al primer mundo.");
                                c=1;
                            break;*/
                            case 1:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n Cada mundo tiene su propia temática\n       y un tema el cual aprenderás    \n       a través de diversas pruebas.");
                            break;
                            case 2:
                                inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n      La temática de este mundo es\n           El volcán 'Popocatépetl'\n     Ubicado en el estado de Puebla.");
                            break;
                            case 3:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 cc.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("\n     Cuenta la leyenda que su nombre\nrepresenta a un gran guerrero fuerte\n       y apuesto que vivió en tiempos\n                   prehispánicos.");
                            break;
                            case 4:
                                inina = new ImageIcon("Personajes\\1 cc.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("\n Este hombre anhelaba terminar una\n    guerra para poder volver junto a\n       su amada, una princesa llamada\n                    Iztaccíhuatl.");
                            break;
                            case 5:
                                inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("\n\n  Aunque regresó victorioso, recibió\n     la mala noticia de que su amada\n                 había fallecido.");
                            break;
                            case 6:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("\n\n     Para honrar el gran amor que se\n  tenían, ordenó construir una tumba.");
                            break;
                            case 7:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("\n      Tomó a su amada en brazos y la\n   recostó en dicho lugar, para luego\n        arrodillarse, sosteniendo una\n antorcha para velar su sueño eterno.");
                            break;
                            case 8:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("\n    Con el tiempo, la nieve cubrió sus\n  cuerpos, que se convirtieron en dos\n            enormes volcanes y que\n         permanecerían inmutables\n       hasta el final de los tiempos.");
                            break;
                            case 9:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("\n\n    Como sabrás, muchos lugares de\n            nuestro estado tienen\n        una gran historia por detrás.");
                            break;
                            case 10:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("\n    Puedes preguntar a tus padres o\n        tutores para conocer más de\n                    esta historia.\n       Ahora nos enfocaremos en el\n                    tema actual:");
                            break;
                            case 11:
                                inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 cc.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("\n             El siguiente tema es:\n                'Multiplicaciones'\n       Las Multiplicaciones son muy\n       importantes en la actualidad.");
                            break;
                            case 12:
                                inina = new ImageIcon("Personajes\\1 cc.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("\n\n   Multiplicar es lo mismo que sumar\n     varias veces el mismo número.");
                            break;
                            case 13:
                                inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("\n                    Por ejemplo:\n             2 x 3 es lo mismo que\n      sumar el número 2 tres veces:\n           2 + 2 + 2 que resultaría 6.");
                            break;
                            case 14:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("\n     Tenemos una propiedad llamada\n           'Propiedad Conmutativa'\n       que nos dice que al multiplicar,\n                 da igual el orden.");
                            break;
                            case 15:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 cc.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("\n                    Por ejemplo:\n             2 x 3 es lo mismo 3 x 2,\nesto es, sumar el número 3 dos veces:\n                3 + 3 es igual a 6.");
                            break;
                            case 16:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 ca.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("         Una forma para solucionar\n      multiplicaciones de dos dígitos,\n    utilizaremos la siguiente forma:\n                            10\n                         x 12\n                         ------");
                            break;
                            case 17:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                txt.setBounds((int)(px*0.3), (int)(py*0.3), (int)(px*0.4), (int)(py*0.41));
                                texto.setBounds((int)(txt.getWidth()*0.01),(int)(txt.getHeight()*0.02), (int)(txt.getWidth()*0.98), (int)(txt.getHeight()*0.96));
                                texto.setText("                            10\n                         x 12\n                         ------\n                            20  (1)\n                          10   (2)\n(1)Multiplicar 2 por 10\n(2)Un dígito a la izquierda,1 por 10\n");
                            break;
                            case 18:
                                txt.setBounds((int)(px*0.3), (int)(py*0.3), (int)(px*0.4), (int)(py*0.4));
                                texto.setBounds((int)(txt.getWidth()*0.01),(int)(txt.getHeight()*0.02), (int)(txt.getWidth()*0.98), (int)(txt.getHeight()*0.97));
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("                            20\n                          10\n     Sumamos los dígitos en vertical\n            y de dercha a izquierda,\n     si no hay número solo te quedas\n                con el que tienes:");
                            break;
                            case 19:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("                            20\n                          10\n                         ------\n(0+1)(2+0)(0+0)\nDando como resultado: 120");
                            break;
                            case 20:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 ca.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("\n\n              Con esta explicación,\n             ahora puedes realizar\n          los siguientes ejercicios:");
                            break;
                            case 21:
                                inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 cc.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("\n  Tendremos dos tipos de ejercicios:\n         El primero será un tablero,\n   en el cual se te mostrará una lista\n       de operaciones y tu deberás\n             responder cada una.");
                            break;
                            case 22:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("                    Por ejemplo:\n                      2 x 7 = ?\n                      9 x 5 = ?\n                      2 x 5 = ?\n Donde deberás encontrar el número\n                      faltante.");
                            break;
                            case 23:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText(" El segundo ejercicio será un cuadro.\n\n                    X    9    7    5\n"+
                                "                    8    ?    ?    ?\n                    4    ?    ?    ?\n                    2    ?    ?    ?"); 
                            break;
                            case 24:
                                inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("\n     Los números que se encuentran\n             en vertical y horizontal\n              son los números que\n"+
                                "          deberás multiplicar para\n              obtener el resultado."); 
                            break;
                            case 25:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("\n\n                Sin más que decir...\n      Comenzemos con los ejercicios!!!"); 
                            break;
                            case 26:
                                escondeIntro();
                                mx.calif[0]=10;
                                setVisible(false);
                                mx.setVisible(true);
                                mx.cargarNiveles();
                            break;
                        }
                        c++;
                    break;
                    case 2:
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n     La temática de este mundo es:\n       La Villa Iluminada de Atlixco");
                            break;
                            case 2:
                                inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n  La Villa Iluminada de Atlixco es un\n    espectáculo de luz y color que se\n      ha convertido en una tradición.");
                            break;
                            case 3:
                                inina = new ImageIcon("Personajes\\1 cc.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n       La cual se ha arraigado en el\n       imaginario de sus pobladores\n                    y visitantes.");
                            break;
                            case 4:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n Desde 2011, se transforma el pueblo\n      mágico en una Villa Iluminada\n            durante 40 días al año.");
                            break;
                            case 5:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\nPuedes pedirle a tus padres o tutores\n            que te lleven de paseo.\n      Comienza el 12 de noviembre\n               aproximadamente!");
                            break;
                            case 6:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n        Nuestro siguiente tema es:\n                    'Fracciones'");
                            break;
                            case 7:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 ca.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n   Una fracción es un número que se\n        obtiene al dividir un entero\n                en partes iguales.");
                            break;
                            case 8:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 cc.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n                    Por ejemplo:\n  Si dividimos un círculo en 4 partes,\n         podemos tomar 1, 2, 3 o 4\n            partes de este círculo.");
                            break;
                            case 9:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n         En las fracciones tenemos\n    dos números que la representan:");
                            break;
                            case 10:
                                inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n        El número de arriba se llama\n    Numerador que indica las partes\n             elegidas de la figura.");
                            break;
                            case 11:
                                inina = new ImageIcon("Personajes\\1 cc.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n        El número de abajo se llama\n  Denominador que indica en cuántas\n       partes esta dividida la figura,\n         y debe ser distinto a cero.");
                            break;
                            case 12:
                                inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("                    Por ejemplo:\n                  1  Numerador\n                 ---\n                  2  Denominador\n   Es decir que se esta tomando una\n               mitad de la figura.");
                            break;
                            case 13:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n       Para este mundo tendremos\n           dos tipos de ejercicios:");
                            break;
                            case 14:
                                inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n   El primero mostrará unas figuras\n      y deberás indicar el numerador\n        o el denomiador de la parte\n              pintada de la figura.");
                            break;
                            case 15:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 ca.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("                            1/4\n\n                                Observamos que\n"+
                                        "                                se está tomando\n                                un cuarto de\n"+
                                        "                                la figura."); 
                                ej = new ImageIcon("Figuras\\1-4.png");
                                iconoC = new ImageIcon(ej.getImage().getScaledInstance((int)(txt.getWidth()*0.5), (int)(txt.getHeight()*0.94),Image.SCALE_DEFAULT));
                                ejemplo.setIcon(iconoC);
                                ejemplo.setVisible(true);
                            break;
                            case 16:
                                ejemplo.setVisible(false);
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\nEl segundo ejercicio es indicar tanto\nnumerador como denominador pero en\nlugar de una figura, sobre una recta:");
                            break;
                            case 17:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n  Una vez conocida esta información,\n        ¡vamos a por los ejercicios!");
                                
                            break;
                            case 18:
                                escondeIntro();
                                mx.calif[0]=10;
                                setVisible(false);
                                mx.setVisible(true);
                                mx.cargarNiveles();
                            break;
                        }
                        c++;
                    break;
                    case 3:
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n      La temática de este mundo es:\n                 Africam Safari");
                            break;
                            case 2:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("    Africam Safari es un parque de     \n     conservación de vida silvestre\n       mexicano ubicado a 16.5 km\n      de la ciudad de Puebla, donde\n  los animales deambulan en libertad\n         controlada y en cautiverio.");
                            break;
                            case 3:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 ca.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n     Además, exhibe más de 2,500\n         animales de 350 especies\n           distribuidas en diversos\nambientes de acuerdo a cada especie.");
                            break;
                            case 4:
                                inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n   Pide a tus padres que te lleven de\n     paseo al Safari. ¿A quién no le\n        gustaría ver animales reales\n          que solo vemos en libros?\n             Porque a nosotros sí!");
                            break;
                            case 5:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n\n    El último tema es: 'Desigualdades'");
                            break;
                            case 6:
                                inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 cc.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n   Las desigualdades son la forma de\n    relacionar dos valores distintos.");
                            break;
                            case 7:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n                    Por ejemplo:\n   Decimos que 100 es mayor que 50\n        ó que 50 es menor que 100.");
                            break;
                            case 8:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\nPara indicar esta relación, utilizamos\n                    dos símbolos:\n                    > 'Mayor que'\n                    < 'Menor que'");
                            break;
                            case 9:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n  Para escribir dichos símbolos en el\n    teclado, basta con encontrar la\n          tecla con estos símbolos.");
                            break;
                            case 10:
                                inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\nPara escribir el símbolo < (menor que)\nsolo presionamos esa tecla.\nPara escribir el símbolo > (mayor que),\npresionamos primero la tecla Shift y\nluego la tecla del símbolo.");
                            break;
                            case 11:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 ca.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\nPara este tema preparamos dos tipos\n    de ejercicios similares entre sí:");
                            break;
                            case 12:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 cc.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\nAmbos muestran una lista de números\n   a la izquierda y otra a la derecha.");
                            break;
                            case 13:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n     En el primer tipo de ejercicio,\n      deberás colocar el símbolo que\n          relacione correctamente el\n      número de la izquierda con el\n                   de la derecha:");
                            break;
                            case 14:
                                inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 cc.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n                    Por ejemplo:\n                     100  <  200\n                       50  >  20\n     Enfocándonos en el número de la\n    izquierda, 100 es menor que 200.");
                            break;
                            case 15:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n     Para el segundo tipo de ejercicio\nmantendremos la dinámica del primer\n     tipo, solo que ésta vez debemos\n     resolver una suma o resta antes\n                   de responder:");
                            break;
                            case 16:
                                inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("                    Por ejemplo:\n               100+50  ?  70-10\nLa suma de 100+50 es igual a 150\n      Y la resta 70-10 es igual a 60\n"+
                                        " Estos dos últimos resultados deben\ncompararse, siendo 150 mayor que 60.");
                            break;
                            case 17:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n     Con esta explicación, podemos\n comenzar a resolver los ejercicios!!!");
                            break;
                            case 18:
                                escondeIntro();
                                mx.calif[0]=10;
                                setVisible(false);
                                mx.setVisible(true);
                                mx.cargarNiveles();
                            break;
                        }
                        c++;
                    break;
                    case 4:
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("               Utilizando la forma:\n                            20\n                        x 10\n                         ------\n     debes resolver la multiplicación\ny colocar el resultado donde se indica.");
                            break;
                            case 2:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("          Por ejemplo: 10 x 12 = ?\n    Multiplicamos 2 por 10 y 1 por 10\n              los colocamos como:\n                            20\n                          10\n            y sumamos en vertical:");
                            break;
                            case 3:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("                            20\n                          10\n                         ------\n(0+1)(2+0)(0+0)\nY el resultado lo colocamos en donde\n           se indica:  10 x 12 = 120");
                            break;
                            case 4:
                                escondeIntro();
                                setVisible(false);
                                mx.setVisible(true);
                                mx.cargarNiveles();
                            break;
                        }
                        c++;
                    break;
                    case 5:
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("               Utilizando la forma\n                            20\n                        x 10\n                         ------\n     debes resolver la multiplicación\ny colocar el resultado donde se indica.");
                            break;
                            case 2:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("           Por ejemplo: 10 x 13\n\n                    X    13    7    5\n"+
                                "                    10    ?    ?    ?\n                    4    ?    ?    ?\n                    2    ?    ?    ?"); 
                            break;
                            case 3:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("                      10 x 13 = ?\n    Multiplicamos 3 por 10 y 1 por 10\n              los colocamos como:\n                            30\n                          10\n            y sumamos en vertical:");
                            break;
                            case 4:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("                            30\n                          10\n                         ------\n(0+1)(3+0)(0+0)\nY el resultado lo colocamos en donde\n           se indica:  10 x 13 = 130");
                            break;
                            case 5:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);
                                nino.setIcon(iconoB);
                                texto.setText("           Por ejemplo: 10 x 13\n\n                    X    13    7    5\n"+
                                "                    10  130    ?    ?\n                    4    ?    ?    ?\n                    2    ?    ?    ?"); 
                            break;
                            case 6:
                                escondeIntro();
                                setVisible(false);
                                mx.setVisible(true);
                                mx.cargarNiveles();
                            break;
                        }
                        c++;
                    break;
                    case 6:
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n  Si dividimos un círculo en 4 partes,\n   podemos tomar 1, 2, 3 o 4 partes\n                  de este círculo.");
                            break;
                            case 2:
                                inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("                            1/4\n\n                                Observamos que\n"+
                                        "                                se está tomando\n                                un cuarto de\n"+
                                        "                                la figura."); 
                                ej = new ImageIcon("Figuras\\1-4.png");
                                iconoC = new ImageIcon(ej.getImage().getScaledInstance((int)(txt.getWidth()*0.5), (int)(txt.getHeight()*0.94),Image.SCALE_DEFAULT));
                                ejemplo.setIcon(iconoC);
                                ejemplo.setVisible(true);
                            break;
                            case 3:
                                ejemplo.setVisible(false);
                                escondeIntro();
                                setVisible(false);
                                mx.setVisible(true);
                                mx.cargarNiveles();
                            break;
                        }
                        c++;
                    break;
                    case 7:
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n  Si dividimos una recta en 4 partes,\n   podemos tomar 1, 2, 3 o 4 partes\n                   de esta recta.");
                            break;
                            case 2:
                                ejemplo.setVisible(false);
                                inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n\n Lo que debes hacer es indicar tanto\nnumerador como denominador pero en\nlugar de una figura, sobre una recta.");
                            break;
                            case 3:
                                escondeIntro();
                                setVisible(false);
                                mx.setVisible(true);
                                mx.cargarNiveles();
                            break;
                        }
                        c++;
                    break;
                    case 8:
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n      Para indicar la relación de dos\n   números, utilizamos dos símbolos:\n                  >    'Mayor que'\n                  <    'Menor que'");
                            break;
                            case 2:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n        En el este tipo de ejercicio\n      deberás colocar el símbolo que\n  relacione correctamente el número\n  de la izquierda con el de la derecha.");
                            break;
                            case 3:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("                    Por ejemplo:\n                     100  <  200\n                      50  >  20\n    Enfocándonos en el número de la\n                     izquierda.\n            100 es menor que 200.");
                            break;
                            case 4:
                                escondeIntro();
                                setVisible(false);
                                mx.setVisible(true);
                                mx.cargarNiveles();
                            break;
                        }
                        c++;
                    break;
                    case 9:
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("\n      Para el este tipo de ejercicio\nmantendremos la dinámica del primer\n    tipo, solo que ésta vez debemos\n  resolver una suma o resta antes de\n                      responder:");
                            break;
                            case 2:
                                inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("       Por ejemplo: 100+50  >  70-10\n Haciendo la suma 100+50 igual a 150\n         Y la resta 70-10 igual a 60\n"+
                                        " Estos dos últimos resultados son los\n  que debemos relacionar, siendo 150\n                   mayor que 60.");
                            break;
                            case 3:
                                escondeIntro();
                                setVisible(false);
                                mx.setVisible(true);
                                mx.cargarNiveles();
                            break;
                        }
                        c++;
                    break;
                    case 10:
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("                            De momento,\n\n                                Solo te podemos\n"+
                                        "                                dar esta medalla.\n\n                            Sigue practicando."); 
                                ej = new ImageIcon("Medallas\\nani.png");
                                iconoC = new ImageIcon(ej.getImage().getScaledInstance((int)(txt.getWidth()*0.5), (int)(txt.getHeight()*0.94),Image.SCALE_DEFAULT));
                                ejemplo.setIcon(iconoC);
                                ejemplo.setVisible(true);
                            break;
                            case 2:
                                ejemplo.setVisible(false);
                                escondeIntro();
                                setVisible(false);
                                mx.setVisible(true);
                                mx.cargarNiveles();
                            break;
                        }
                        c++;
                    break;
                    case 11:
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("                           Medalla de BRONCE\n\n                                Esta medalla\n"+
                                        "                                demuestra que\n                                has aprendido.\n                              ¡sigue así!"); 
                                ej = new ImageIcon("Medallas\\AP1.png");
                                iconoC = new ImageIcon(ej.getImage().getScaledInstance((int)(txt.getWidth()*0.5), (int)(txt.getHeight()*0.94),Image.SCALE_DEFAULT));
                                ejemplo.setIcon(iconoC);
                                ejemplo.setVisible(true);
                            break;
                            case 2:
                                ejemplo.setVisible(false);
                                escondeIntro();
                                setVisible(false);
                                mx.setVisible(true);
                                mx.cargarNiveles();
                            break;
                        }
                        c++;
                    break;
                    case 12:
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("                            Medalla de PLATA\n\n                                Esta medalla\n"+
                                        "                                demuestra que\n                                has progresado.\n                               ¡Puedes mejorar!"); 
                                ej = new ImageIcon("Medallas\\AP2.png");
                                iconoC = new ImageIcon(ej.getImage().getScaledInstance((int)(txt.getWidth()*0.5), (int)(txt.getHeight()*0.94),Image.SCALE_DEFAULT));
                                ejemplo.setIcon(iconoC);
                                ejemplo.setVisible(true);
                            break;
                            case 2:
                                ejemplo.setVisible(false);
                                escondeIntro();
                                setVisible(false);
                                mx.setVisible(true);
                                mx.cargarNiveles();
                            break;
                        }
                        c++;
                    break;
                    case 13:
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("                            Medalla de ORO\n                                Esta medalla\n"+
                                        "                                demuestra que\n                                has aprendido\n                                muy bien el tema.\n                              ¡Sigue mejorando!"); 
                                ej = new ImageIcon("Medallas\\AP3.png");
                                iconoC = new ImageIcon(ej.getImage().getScaledInstance((int)(txt.getWidth()*0.5), (int)(txt.getHeight()*0.94),Image.SCALE_DEFAULT));
                                ejemplo.setIcon(iconoC);
                                ejemplo.setVisible(true);
                            break;
                            case 2:
                                ejemplo.setVisible(false);
                                escondeIntro();
                                setVisible(false);
                                mx.setVisible(true);
                                mx.cargarNiveles();
                            break;
                        }
                        c++;
                    break;
                    case 14://M1
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                ttot = (((tiempoInicio-tiempoFin)/1e6)/1000);
                                texto.setText("     Tu tiempo fue de: "+(int)(-ttot)+" segundos.\n"+
                                        "\n  Debes contestar TODO correcto y"+
                                        "\n       hacer menos de 420 segundos\n     para obtener una medalla mejor.");
                            break;
                            case 2:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                txt.setBounds((int)(px*0.3), (int)(py*0.3), (int)(px*0.4), (int)(py*0.41));
                                ejemplo.setBounds((int)(txt.getWidth()*0.03),(int)(txt.getHeight()*0.03),(int)(txt.getWidth()*0.6),(int)(txt.getHeight()*0.94));
                                texto.setBounds((int)(txt.getWidth()*0.01),(int)(txt.getHeight()*0.02), (int)(txt.getWidth()*0.98), (int)(txt.getHeight()*0.97));
                                texto.setText("                                   Medalla de\n                                 ESMERALDA\n                                Esta medalla\n"+
                                        "                                demuestra que\n                                puedes resolver\n                                ejercicios a una\n                                velocidad normal."); 
                                ej = new ImageIcon("Medallas\\CR1.png");
                                iconoC = new ImageIcon(ej.getImage().getScaledInstance((int)(txt.getWidth()*0.5), (int)(txt.getHeight()*0.94),Image.SCALE_DEFAULT));
                                ejemplo.setIcon(iconoC);
                                ejemplo.setVisible(true);
                            break;
                            case 3:
                                ejemplo.setVisible(false);
                                escondeIntro();
                                setVisible(false);
                                mx.setVisible(true);
                                mx.califCR(1);
                                mx.m.setVisible(true);
                            break;
                        }
                        c++;
                    break;
                    case 15://M1
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                ttot = (((tiempoInicio-tiempoFin)/1e6)/1000);
                                texto.setText("     Tu tiempo fue de: "+(int)(-ttot)+" segundos.\n"+
                                        "\n  Debes contestar TODO correcto y"+
                                        "\n       hacer menos de 360 segundos\n     para obtener una medalla mejor.");
                            break;
                            case 2:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                txt.setBounds((int)(px*0.3), (int)(py*0.3), (int)(px*0.4), (int)(py*0.41));
                                ejemplo.setBounds((int)(txt.getWidth()*0.03),(int)(txt.getHeight()*0.03),(int)(txt.getWidth()*0.6),(int)(txt.getHeight()*0.94));
                                texto.setBounds((int)(txt.getWidth()*0.01),(int)(txt.getHeight()*0.02), (int)(txt.getWidth()*0.98), (int)(txt.getHeight()*0.97));
                                texto.setText("                                  Medalla de\n                                 DIAMANTE\n                                Esta medalla\n"+
                                        "                                demuestra que\n                                has aumentado\n                             tu velocidad para\n                        resolver los ejercicios."); 
                                ej = new ImageIcon("Medallas\\CR2.png");
                                iconoC = new ImageIcon(ej.getImage().getScaledInstance((int)(txt.getWidth()*0.5), (int)(txt.getHeight()*0.94),Image.SCALE_DEFAULT));
                                ejemplo.setIcon(iconoC);
                                ejemplo.setVisible(true);
                            break;
                            case 3:
                                ejemplo.setVisible(false);
                                escondeIntro();
                                setVisible(false);
                                mx.setVisible(true);
                                mx.califCR(2);
                                mx.m.setVisible(true);
                            break;
                        }
                        c++;
                    break;
                    case 16://M1
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                ttot = (((tiempoInicio-tiempoFin)/1e6)/1000);
                                texto.setText("\n\n     Tu tiempo fue de: "+(int)(-ttot)+" segundos.\n"+
                                        "     !Hiciste menos de 360 segundos!");
                            break;
                            case 2:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("                           Medalla de ZAFIRO\n\n                                Esta medalla\n"+
                                        "                                demuestra que\n                                has dominado por\n                               completo el tema."); 
                                ej = new ImageIcon("Medallas\\CR3.png");
                                iconoC = new ImageIcon(ej.getImage().getScaledInstance((int)(txt.getWidth()*0.5), (int)(txt.getHeight()*0.94),Image.SCALE_DEFAULT));
                                ejemplo.setIcon(iconoC);
                                ejemplo.setVisible(true);
                                
                            break;
                            case 3:
                                ejemplo.setVisible(false);
                                escondeIntro();
                                setVisible(false);
                                mx.setVisible(true);
                                mx.califCR(3);
                                mx.m.setVisible(true);
                            break;
                        }
                        c++;
                    break;
                    case 17:
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                ttot = (((tiempoInicio-tiempoFin)/1e6)/1000);
                                texto.setText("     Tu tiempo fue de: "+(int)(-ttot)+" segundos."+
                                        "\n           Pero no respondiste bien\n                  a los problemas."+
                                        "\n  Debes contestar TODO correcto y"+
                                        "\n       hacer menos de 480 segundos\n     para obtener una medalla mejor.");
                            break;
                            case 2:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("                            De momento,\n\n                                Solo te podemos\n"+
                                        "                                dar esta medalla.\n\n                            Sigue practicando."); 
                                ej = new ImageIcon("Medallas\\nani.png");
                                iconoC = new ImageIcon(ej.getImage().getScaledInstance((int)(txt.getWidth()*0.5), (int)(txt.getHeight()*0.94),Image.SCALE_DEFAULT));
                                ejemplo.setIcon(iconoC);
                                ejemplo.setVisible(true);
                            break;
                            case 3:
                                tiempoInicio = 0; tiempoFin = 0;
                                ejemplo.setVisible(false);
                                escondeIntro();
                                setVisible(false);
                                mx.setVisible(true);
                                mx.califCR(0);
                                mx.m.setVisible(true);
                            break;
                        }
                        c++;
                    break;
                    case 18://M1
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                ttot = (((tiempoInicio-tiempoFin)/1e6)/1000);
                                texto.setText("     Tu tiempo fue de: "+(int)(-ttot)+" segundos.\n"+
                                        "\n  Debes contestar TODO correcto y"+
                                        "\n       hacer menos de 120 segundos\n     para obtener una medalla mejor.");
                            break;
                            case 2:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                txt.setBounds((int)(px*0.3), (int)(py*0.3), (int)(px*0.4), (int)(py*0.41));
                                ejemplo.setBounds((int)(txt.getWidth()*0.03),(int)(txt.getHeight()*0.03),(int)(txt.getWidth()*0.6),(int)(txt.getHeight()*0.94));
                                texto.setBounds((int)(txt.getWidth()*0.01),(int)(txt.getHeight()*0.02), (int)(txt.getWidth()*0.98), (int)(txt.getHeight()*0.97));
                                texto.setText("                                   Medalla de\n                                 ESMERALDA\n                                Esta medalla\n"+
                                        "                                demuestra que\n                                puedes resolver\n                                ejercicios a una\n                                velocidad normal."); 
                                ej = new ImageIcon("Medallas\\CR1.png");
                                iconoC = new ImageIcon(ej.getImage().getScaledInstance((int)(txt.getWidth()*0.5), (int)(txt.getHeight()*0.94),Image.SCALE_DEFAULT));
                                ejemplo.setIcon(iconoC);
                                ejemplo.setVisible(true);
                            break;
                            case 3:
                                ejemplo.setVisible(false);
                                escondeIntro();
                                setVisible(false);
                                mx.setVisible(true);
                                mx.califCR(1);
                                mx.m.setVisible(true);
                            break;
                        }
                        c++;
                    break;
                    case 19://M1
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                ttot = (((tiempoInicio-tiempoFin)/1e6)/1000);
                                texto.setText("     Tu tiempo fue de: "+(int)(-ttot)+" segundos.\n"+
                                        "\n  Debes contestar TODO correcto y"+
                                        "\n       hacer menos de 60 segundos\n     para obtener una medalla mejor.");
                            break;
                            case 2:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                txt.setBounds((int)(px*0.3), (int)(py*0.3), (int)(px*0.4), (int)(py*0.41));
                                ejemplo.setBounds((int)(txt.getWidth()*0.03),(int)(txt.getHeight()*0.03),(int)(txt.getWidth()*0.6),(int)(txt.getHeight()*0.94));
                                texto.setBounds((int)(txt.getWidth()*0.01),(int)(txt.getHeight()*0.02), (int)(txt.getWidth()*0.98), (int)(txt.getHeight()*0.97));
                                texto.setText("                                  Medalla de\n                                 DIAMANTE\n                                Esta medalla\n"+
                                        "                                demuestra que\n                                has aumentado\n                             tu velocidad para\n                        resolver los ejercicios."); 
                                ej = new ImageIcon("Medallas\\CR2.png");
                                iconoC = new ImageIcon(ej.getImage().getScaledInstance((int)(txt.getWidth()*0.5), (int)(txt.getHeight()*0.94),Image.SCALE_DEFAULT));
                                ejemplo.setIcon(iconoC);
                                ejemplo.setVisible(true);
                            break;
                            case 3:
                                ejemplo.setVisible(false);
                                escondeIntro();
                                setVisible(false);
                                mx.setVisible(true);
                                mx.califCR(2);
                                mx.m.setVisible(true);
                            break;
                        }
                        c++;
                    break;
                    case 20://M1
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                ttot = (((tiempoInicio-tiempoFin)/1e6)/1000);
                                texto.setText("\n\n     Tu tiempo fue de: "+(int)(-ttot)+" segundos.\n"+
                                        "      !Hiciste menos de 60 segundos!");
                            break;
                            case 2:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("                           Medalla de ZAFIRO\n\n                                Esta medalla\n"+
                                        "                                demuestra que\n                                has dominado por\n                               completo el tema."); 
                                ej = new ImageIcon("Medallas\\CR3.png");
                                iconoC = new ImageIcon(ej.getImage().getScaledInstance((int)(txt.getWidth()*0.5), (int)(txt.getHeight()*0.94),Image.SCALE_DEFAULT));
                                ejemplo.setIcon(iconoC);
                                ejemplo.setVisible(true);
                                
                            break;
                            case 3:
                                ejemplo.setVisible(false);
                                escondeIntro();
                                setVisible(false);
                                mx.setVisible(true);
                                mx.califCR(3);
                                mx.m.setVisible(true);
                            break;
                        }
                        c++;
                    break;
                    case 21:
                        switch(c){
                            case 1:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                ttot = (((tiempoInicio-tiempoFin)/1e6)/1000);
                                texto.setText("     Tu tiempo fue de: "+(int)(-ttot)+" segundos."+
                                        "\n           Pero no respondiste bien\n                  a los problemas."+
                                        "\n  Debes contestar TODO correcto y"+
                                        "\n       hacer menos de 130 segundos\n     para obtener una medalla mejor.");
                            break;
                            case 2:
                                inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                                iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                                iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                                nina.setIcon(iconoA);nino.setIcon(iconoB);
                                texto.setText("                            De momento,\n\n                                Solo te podemos\n"+
                                        "                                dar esta medalla.\n\n                            Sigue practicando."); 
                                ej = new ImageIcon("Medallas\\nani.png");
                                iconoC = new ImageIcon(ej.getImage().getScaledInstance((int)(txt.getWidth()*0.5), (int)(txt.getHeight()*0.94),Image.SCALE_DEFAULT));
                                ejemplo.setIcon(iconoC);
                                ejemplo.setVisible(true);
                            break;
                            case 3:
                                tiempoInicio = 0; tiempoFin = 0;
                                ejemplo.setVisible(false);
                                escondeIntro();
                                setVisible(false);
                                mx.setVisible(true);
                                mx.califCR(0);
                                mx.m.setVisible(true);
                            break;
                        }
                        c++;
                    break;
                }
            }
        });
    }
    JLabel cero=new JLabel("0"),uno=new JLabel("1"),dos=new JLabel("2");
    JLabel ceros=new JLabel("0"),unos=new JLabel("1"),doss=new JLabel("2");
    
    public void M1L1(){
        iniciaIntro(1);
        System.out.println("M1L1");
        mx.calif[0]=10;
    }
    
    public void M1L2(){
        int nums[] = new int[20];
        JLabel op[] = new JLabel[10];
        JTextArea[] R = new JTextArea[10];
        
        for (int i = 0; i < 20; i++) {
            nums[i] = (int) Math.floor(Math.random()*(15-1+1)+1);//NUMS ENTRE 1 Y 15
        }
        
        for (int i = 0; i < 10; i++) {
            op[i] = new JLabel(nums[i] + " X " + nums[i+10] + "=");
            op[i].setForeground(Color.BLUE);
            op[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            op[i].setBounds((int)(px*0.35),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.3),      (int)(py*0.08));
            fondo.add(op[i]);
            
            R[i] = new JTextArea();
            R[i].setForeground(Color.red);
            R[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            R[i].setOpaque(false);
            R[i].setBounds((int)(px*0.65),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            num(R[i]);
            fondo.add(R[i]);
        }
        
        JButton enviar = new JButton("ENVIAR");
        enviar.setForeground(Color.CYAN);
        enviar.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.02) ));
        enviar.setContentAreaFilled(false);
        enviar.setBounds((int)(px*0.91),(int)(py*0.91),(int)(px*0.08),(int)(py*0.05));
        fondo.add(enviar);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                if(enviar.getText().equals("ENVIAR")){
                    int calif=0;
                    for (int i = 0; i < 10; i++) {
                        if ( R[i].getText().equals(nums[i]*nums[i+10]+"") ) {
                            R[i].setEditable(false);
                            R[i].setForeground(Color.GREEN);
                            calif++;
                        }
                    }
                    //AQUI GUARDAMOS EL VALOR DE LA CALIFCICACION
                    mx.calif[1]=calif;
                    //MOTIVACION
                    if(calif<10){
                        for(int h=0;h<10;h++){
                            op[h].setVisible(false);
                        }
                        for(int h=0;h<10;h++){
                            R[h].setVisible(false);
                        }
                        iniciaIntro(4);
                    }
                    //CAMBIAR A UN BOTON DE TERMINO DE JUEGO
                    enviar.setText("CERRAR");
                    mx.cargarNiveles();
                    mx.mj = new MJs();
                    mx.mj.MJs(px, py, mx);              //BUG INMINENTE XD
                }
                else{
                    // AQUI PUEDE SER
                    setVisible(false);
                    mx.setVisible(true);
                    
                }
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };enviar.addActionListener(oyente);
        
    }
    
    public void M1L3(){
        
        JLabel a[] = new JLabel[3];
        JLabel b[] = new JLabel[3];
        JTextArea[][] R = new JTextArea[3][3];
        
        for (int i = 0; i < 3; i++) {
            
            a[i] = new JLabel( (int) Math.floor(Math.random()*(15-1+1)+1) +"" );
            a[i].setForeground(Color.BLUE);
            a[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            a[i].setBounds((int)((px*0.43)+i*(px*0.12)),      (int)(py*0.1),
                            (int)(px*0.1),      (int)(py*0.08));
            fondo.add(a[i]);
            
            b[i] = new JLabel( (int) Math.floor(Math.random()*(15-1+1)+1) +"" );
            b[i].setForeground(Color.yellow);
            b[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            b[i].setBounds((int)(px*0.35),      (int)((py*0.18)+i*(py*0.12)),
                            (int)(px*0.1),      (int)(py*0.08));
            fondo.add(b[i]);
            
            for (int j = 0; j < 3; j++) {
                R[i][j] = new JTextArea();
                R[i][j].setForeground(Color.red);
                R[i][j].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                R[i][j].setOpaque(false);
                R[i][j].setBounds((int)((px*0.43)+i*(px*0.12)),      (int)((py*0.18)+j*(py*0.12)),
                            (int)(px*0.1),      (int)(py*0.08));
                num(R[i][j]);
                fondo.add(R[i][j]);
            }
        }
        
        JButton enviar = new JButton("ENVIAR");
        enviar.setForeground(Color.CYAN);
        enviar.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.02) ));
        enviar.setContentAreaFilled(false);
        enviar.setBounds((int)(px*0.91),(int)(py*0.91),(int)(px*0.08),(int)(py*0.05));
        fondo.add(enviar);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                if(enviar.getText().equals("ENVIAR")){
                    int calif=1;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if ( R[i][j].getText().equals(Integer.parseInt(a[i].getText())*Integer.parseInt(b[j].getText())+"") ) {
                                R[i][j].setEditable(false);
                                R[i][j].setForeground(Color.GREEN);
                                calif++;
                            }
                        }
                    }
                    //AQUI GUARDAMOS EL VALOR DE LA CALIFCICACION
                    mx.calif[2]=calif;
                    //MOTIVACION
                    if(calif<10){
                        for(int h=0;h<3;h++){
                            a[h].setVisible(false);
                            b[h].setVisible(false);
                        }
                        for(int h=0;h<3;h++){
                            for(int g=0;g<3;g++){
                                R[h][g].setVisible(false);
                            }
                        }
                        iniciaIntro(5);
                    }
                    //CAMBIAR A UN BOTON DE TERMINO DE JUEGO
                    enviar.setText("CERRAR");
                    mx.cargarNiveles();
                    mx.mj = new MJs();
                    mx.mj.MJs(px, py, mx);              //BUG INMINENTE XD
                }
                else{
                    setVisible(false);
                    mx.setVisible(true);
                }
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };enviar.addActionListener(oyente);
        
    }
    
    public void M1L4(){
        int nums[] = new int[20];
        JLabel op[] = new JLabel[10];
        JTextArea[] R = new JTextArea[10];
        
        for (int i = 0; i < 20; i++) {
            nums[i] = (int) Math.floor(Math.random()*(30-15+1)+15);//NUMS ENTRE 1 Y 15
        }
        
        for (int i = 0; i < 10; i++) {
            op[i] = new JLabel(nums[i] + " X " + nums[i+10] + "=");
            op[i].setForeground(Color.BLUE);
            op[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            op[i].setBounds((int)(px*0.35),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.3),      (int)(py*0.08));
            fondo.add(op[i]);
            //RESPUESTAS
            R[i] = new JTextArea();
            R[i].setForeground(Color.red);
            R[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            R[i].setOpaque(false);
            R[i].setBounds((int)(px*0.65),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            num(R[i]);
            fondo.add(R[i]);
        }
        
        JButton enviar = new JButton("ENVIAR");
        enviar.setForeground(Color.CYAN);
        enviar.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.02) ));
        enviar.setContentAreaFilled(false);
        enviar.setBounds((int)(px*0.91),(int)(py*0.91),(int)(px*0.08),(int)(py*0.05));
        fondo.add(enviar);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                if(enviar.getText().equals("ENVIAR")){
                    int calif=0;
                    for (int i = 0; i < 10; i++) {
                        if ( R[i].getText().equals(nums[i]*nums[i+10]+"") ) {
                            R[i].setEditable(false);
                            R[i].setForeground(Color.GREEN);
                            calif++;
                        }
                    }
                    //AQUI GUARDAMOS EL VALOR DE LA CALIFCICACION
                    mx.calif[3]=calif;
                    //MOTIVACION
                    if(calif<10){
                        for(int h=0;h<10;h++){
                            op[h].setVisible(false);
                        }
                        for(int h=0;h<10;h++){
                            R[h].setVisible(false);
                        }
                        iniciaIntro(4);
                    }
                    //CAMBIAR A UN BOTON DE TERMINO DE JUEGO
                    enviar.setText("CERRAR");
                    mx.cargarNiveles();
                    mx.mj = new MJs();
                    mx.mj.MJs(px, py, mx);              //BUG INMINENTE XD
                }
                else{
                    setVisible(false);
                    mx.setVisible(true);
                }
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };enviar.addActionListener(oyente);
    }
    
    public void M1L5(){
        
        JLabel a[] = new JLabel[3];
        JLabel b[] = new JLabel[3];
        JTextArea[][] R = new JTextArea[3][3];
        
        for (int i = 0; i < 3; i++) {
            
            a[i] = new JLabel( (int) Math.floor(Math.random()*(30-15+1)+15) +"" );
            a[i].setForeground(Color.BLUE);
            a[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            a[i].setBounds((int)((px*0.43)+i*(px*0.12)),      (int)(py*0.1),
                            (int)(px*0.1),      (int)(py*0.08));
            fondo.add(a[i]);
            
            b[i] = new JLabel( (int) Math.floor(Math.random()*(30-15+1)+15) +"" );
            b[i].setForeground(Color.yellow);
            b[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            b[i].setBounds((int)(px*0.35),      (int)((py*0.18)+i*(py*0.12)),
                            (int)(px*0.1),      (int)(py*0.08));
            fondo.add(b[i]);
            
            for (int j = 0; j < 3; j++) {
                R[i][j] = new JTextArea();
                R[i][j].setForeground(Color.red);
                R[i][j].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                R[i][j].setOpaque(false);
                R[i][j].setBounds((int)((px*0.43)+i*(px*0.12)),      (int)((py*0.18)+j*(py*0.12)),
                            (int)(px*0.1),      (int)(py*0.08));
                num(R[i][j]);
                fondo.add(R[i][j]);
            }
        }
        
        JButton enviar = new JButton("ENVIAR");
        enviar.setForeground(Color.CYAN);
        enviar.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.02) ));
        enviar.setContentAreaFilled(false);
        enviar.setBounds((int)(px*0.91),(int)(py*0.91),(int)(px*0.08),(int)(py*0.05));
        fondo.add(enviar);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                if(enviar.getText().equals("ENVIAR")){
                    int calif=1;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if ( R[i][j].getText().equals(Integer.parseInt(a[i].getText())*Integer.parseInt(b[j].getText())+"") ) {
                                R[i][j].setEditable(false);
                                R[i][j].setForeground(Color.GREEN);
                                calif++;
                            }
                        }
                    }
                    //AQUI GUARDAMOS EL VALOR DE LA CALIFCICACION
                    mx.calif[4]=calif;
                    //MOTIVACION
                    if(calif<10){
                        for(int h=0;h<3;h++){
                            a[h].setVisible(false);
                            b[h].setVisible(false);
                        }
                        for(int h=0;h<3;h++){
                            for(int g=0;g<3;g++){
                                R[h][g].setVisible(false);
                            }
                        }
                        iniciaIntro(5);
                    }
                    for(int h=0;h<3;h++){
                            a[h].setVisible(false);
                            b[h].setVisible(false);
                    }
                    for(int h=0;h<3;h++){
                        for(int g=0;g<3;g++){
                            R[h][g].setVisible(false);
                        }
                    }
                    int prom=0;
                    for(int i=1;i<5;i++){
                        prom = prom + mx.calif[i];
                    }
                    System.out.println(prom);
                    if(prom<24){
                        iniciaIntro(10);
                    }else{
                        if(prom>24)//BRONCE
                            iniciaIntro(11);
                        if(prom>32)//PLATA
                            iniciaIntro(12);
                        if(prom==40)//ORO
                            iniciaIntro(13);
                    }
                    //CAMBIAR A UN BOTON DE TERMINO DE JUEGO
                    
                    mx.cargarNiveles();
                    mx.mj = new MJs();
                    mx.mj.MJs(px, py, mx);              //BUG INMINENTE XD
                }
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };enviar.addActionListener(oyente);
        
    }
    
    public void M2L1(){
        iniciaIntro(2);
        System.out.println("M2L1");
        mx.calif[0]=10;
    }
    
    public void M2L2(){
        JLabel a[] = new JLabel[10];
        JLabel b[] = new JLabel[10];
        JTextArea[] R = new JTextArea[10];
        
        int num[] = new int[10];
        int den[] = new int[10];
        
        for (int i = 0; i < 10; i++) {
            do{
                den[i] = (int) Math.floor(Math.random()*(5-2+1)+2);
                num[i] = (int) Math.floor(Math.random()*(den[i]-1+1)+1);
            }while( repetido(den, num, i) );
            
            //IMG
            ImageIcon img = new ImageIcon( "Figuras\\"+num[i]+"-"+den[i]+".png");
            a[i] = new JLabel();
            if(i<5)
                a[i].setBounds((int)(px*0.20),      (int)((py*0.1)+i*(py*0.08)),
                                (int)(px*0.08),      (int)(py*0.08));
            else
                a[i].setBounds((int)(px*0.70),      (int)((py*0.1)+i*(py*0.08)),
                                (int)(px*0.08),      (int)(py*0.08));
            Icon icono = new ImageIcon(img.getImage().getScaledInstance(a[i].getWidth(),a[i].getHeight(),Image.SCALE_DEFAULT));
            a[i].setIcon(icono);
            a[i].setVisible(true);
            fondo.add(a[i]);
            
            //MUN B
            if(i<5)
                b[i] = new JLabel("/"+den[i]);
            else
                b[i] = new JLabel(""+num[i]+"/");
            b[i].setForeground(Color.WHITE);
            b[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            if(i<5)
                b[i].setBounds((int)(px*0.75),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            else
                b[i].setBounds((int)(px*0.20),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            
            fondo.add(b[i]);
            
            //RESPUESTA
            R[i] = new JTextArea("?");
            R[i].setForeground(Color.YELLOW);
            R[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            R[i].setOpaque(false);
            if(i<5)
                R[i].setBounds((int)(px*0.70),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            else
                R[i].setBounds((int)(px*0.25),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            num(R[i]);
            fondo.add(R[i]);
        }
        
        JButton enviar = new JButton("ENVIAR");
        enviar.setForeground(Color.CYAN);
        enviar.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.02) ));
        enviar.setContentAreaFilled(false);
        enviar.setBounds((int)(px*0.91),(int)(py*0.91),(int)(px*0.08),(int)(py*0.05));
        fondo.add(enviar);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                if(enviar.getText().equals("ENVIAR")){
                    int calif=0;
                    for (int i = 0; i < 10; i++) {
                        if(i<5){
                            if( R[i].getText().equals(num[i]+"") ){
                                R[i].setEditable(false);
                                R[i].setForeground(Color.green);
                                calif++;
                            }
                        }
                        else{
                            if( R[i].getText().equals(den[i]+"") ){
                                R[i].setEditable(false);
                                R[i].setForeground(Color.green);
                                calif++;
                            }
                        }
                    }
                    //AQUI GUARDAMOS EL VALOR DE LA CALIFCICACION
                    mx.calif[1]=calif;
                    //MOTIVACION
                    if(calif<10){
                        for(int h=0;h<10;h++){
                            a[h].setVisible(false);
                            b[h].setVisible(false);
                            R[h].setVisible(false);
                        }
                        iniciaIntro(6);
                    }
                    //CAMBIAR A UN BOTON DE TERMINO DE JUEGO
                    enviar.setText("CERRAR");
                    mx.cargarNiveles();
                    mx.mj = new MJs();
                    mx.mj.MJs(px, py, mx);              //BUG INMINENTE XD
                }
                else{
                    setVisible(false);
                    mx.setVisible(true);
                }
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };enviar.addActionListener(oyente);
    }

    public void M2L3(){
        //LINEA A
        JLabel lineaA = new JLabel();
        
        lineaA.setBounds((int)(px*0.05),  (int)(py*0.2),  (int)(px*0.9), (int)(py*0.1));
        ImageIcon img = new ImageIcon( "Rectas\\RECTA.png");
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(lineaA.getWidth(),lineaA.getHeight(),Image.SCALE_DEFAULT));
        lineaA.setIcon(icono);
        lineaA.setVisible(true);
        fondo.add(lineaA);
        //LINEA B
        JLabel lineaB = new JLabel();
        lineaB.setBounds((int)(px*0.05),  (int)(py*0.7),  (int)(px*0.9), (int)(py*0.1));
        lineaB.setIcon(icono);
        lineaB.setVisible(true);
        fondo.add(lineaB);
        
        //A
        int denA = (int) Math.floor(Math.random()*(6-3+1)+3);
        JLabel A[] = new JLabel[denA+denA+1];
        for (int i = 0; i < A.length; i++) {
            //MARCAS
            A[i] = new JLabel();
            A[i].setBounds((int)((px*0.0)+(i*(lineaA.getWidth()/(A.length-1)))),  (int)(py*0.2),  (int)(px*0.1), (int)(py*0.1));
            ImageIcon img2 = new ImageIcon("Rectas\\lineaV.png");
            Icon icono2 = new ImageIcon(img2.getImage().getScaledInstance(A[i].getWidth(),A[i].getHeight(),Image.SCALE_DEFAULT));
            A[i].setIcon(icono2);
            A[i].setVisible(true);
            fondo.add(A[i]);
            //UNIDADES
            if(i==0){
                ceros = new JLabel("0");
                ceros.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                ceros.setBounds((int)((px*0.04)+(i*(lineaA.getWidth()/(A.length-1)))),  (int)(py*0.3),  (int)(px*0.1), (int)(py*0.1));
                ceros.setForeground(Color.WHITE);
                ceros.setVisible(true);
                fondo.add(ceros);
            }
            if(i==denA){
                unos = new JLabel("1");
                unos.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                unos.setBounds((int)((px*0.04)+(i*(lineaA.getWidth()/(A.length-1)))),  (int)(py*0.3),  (int)(px*0.1), (int)(py*0.1));
                unos.setForeground(Color.WHITE);
                unos.setVisible(true);
                fondo.add(unos);
            }
            if(i==denA+denA){
                doss = new JLabel("2");
                doss.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                doss.setBounds((int)((px*0.04)+(i*(lineaA.getWidth()/(A.length-1)))),  (int)(py*0.3),  (int)(px*0.1), (int)(py*0.1));
                doss.setForeground(Color.WHITE);
                doss.setVisible(true);
                fondo.add(doss);
            }
        }
        //B
        int denB;
        do{
            denB = (int) Math.floor(Math.random()*(6-3+1)+3);
        }while(denB==denA);
        JLabel B[] = new JLabel[denB+denB+1];
        for (int i = 0; i < B.length; i++) {
            //MARCAS
            B[i] = new JLabel();
            B[i].setBounds((int)((px*0.0)+(i*(lineaB.getWidth()/(B.length-1)))),  (int)(py*0.7),  (int)(px*0.1), (int)(py*0.1));
            ImageIcon img2 = new ImageIcon("Rectas\\lineaV.png");
            Icon icono2 = new ImageIcon(img2.getImage().getScaledInstance(B[i].getWidth(),B[i].getHeight(),Image.SCALE_DEFAULT));
            B[i].setIcon(icono2);
            B[i].setVisible(true);
            fondo.add(B[i]);
            //UNIDADES
            if(i==0){
                cero = new JLabel("0");
                cero.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                cero.setBounds((int)((px*0.04)+(i*(lineaB.getWidth()/(B.length-1)))),  (int)(py*0.8),  (int)(px*0.1), (int)(py*0.1));
                cero.setForeground(Color.WHITE);
                cero.setVisible(true);
                fondo.add(cero);
            }
            if(i==denB){
                uno = new JLabel("1");
                uno.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                uno.setBounds((int)((px*0.04)+(i*(lineaB.getWidth()/(B.length-1)))),  (int)(py*0.8),  (int)(px*0.1), (int)(py*0.1));
                uno.setForeground(Color.WHITE);
                uno.setVisible(true);
                fondo.add(uno);
            }
            if(i==denB+denB){
                dos = new JLabel("2");
                dos.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                dos.setBounds((int)((px*0.04)+(i*(lineaB.getWidth()/(B.length-1)))),  (int)(py*0.8),  (int)(px*0.1), (int)(py*0.1));
                dos.setForeground(Color.WHITE);
                dos.setVisible(true);
                fondo.add(dos);
            }
        }
        
        int numA[] = new int[5];
        JTextArea eA[] = new JTextArea[5];
        JTextArea rA[] = new JTextArea[5];
        int numB[] = new int[5];
        JTextArea eB[] = new JTextArea[5];
        JTextArea rB[] = new JTextArea[5];
        for (int i = 0; i < 5; i++) {
            //EJERCICIOS A
            do{
                numA[i] = (int) Math.floor(Math.random()*((denA+denA)-1+1)+1);
            }while( repetido(numA, i) );
            //Etiquetas A
            eA[i] = new JTextArea("- \n"+denA);
            eA[i].setForeground(Color.WHITE);
            eA[i].setEditable(false);
            eA[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.04) ));
            eA[i].setOpaque(false);
            eA[i].setBounds((int)((px*0.04)+(numA[i]*(lineaA.getWidth()/(A.length-1)))),  (int)(py*0.08),  
                            (int)(px*0.05),      (int)(py*0.1));
            fondo.add(eA[i]);
            //RESPUESTAS A
            rA[i] = new JTextArea((char)(65+i)+"");
            rA[i].setForeground(Color.YELLOW);
            rA[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.04) ));
            rA[i].setOpaque(false);
            rA[i].setBounds((int)((px*0.04)+(numA[i]*(lineaA.getWidth()/(A.length-1)))),      (int)((py*.05)),
                            (int)(px*0.05),      (int)(py*0.05));
            num2DIG(rA[i]);
            fondo.add(rA[i]);
            
            //EJERCICIOS B
            do{
                numB[i] = (int) Math.floor(Math.random()*((denB+denB)-1+1)+1);
            }while( repetido(numB, i) );
            //Etiquetas B
            eB[i] = new JTextArea("- \n"+denB);
            eB[i].setForeground(Color.WHITE);
            eB[i].setEditable(false);
            eB[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.04) ));
            eB[i].setOpaque(false);
            eB[i].setBounds((int)((px*0.04)+(numB[i]*(lineaB.getWidth()/(B.length-1)))),  (int)(py*0.58),  
                            (int)(px*0.05), (int)(py*0.1));
            fondo.add(eB[i]);
            //RESPUESTAS B
            rB[i] = new JTextArea((char)(65+i)+"");
            rB[i].setForeground(Color.YELLOW);
            rB[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.04) ));
            rB[i].setOpaque(false);
            rB[i].setBounds((int)((px*0.04)+(numB[i]*(lineaB.getWidth()/(B.length-1)))),      (int)((py*.55)),
                            (int)(px*0.05),      (int)(py*0.05));
            num2DIG(rB[i]);
            fondo.add(rB[i]);
        }

        
        JButton enviar = new JButton("ENVIAR");
        enviar.setForeground(Color.CYAN);
        enviar.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.02) ));
        enviar.setContentAreaFilled(false);
        enviar.setBounds((int)(px*0.91),(int)(py*0.91),(int)(px*0.08),(int)(py*0.05));
        fondo.add(enviar);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                if(enviar.getText().equals("ENVIAR")){
                    int calif=0;
                    for (int i = 0; i < 5; i++) {
                        if( rA[i].getText().equals(numA[i]+"") ){
                            rA[i].setEditable(false);
                            rA[i].setForeground(Color.green);
                            calif++;
                        }
                        if( rB[i].getText().equals(numB[i]+"") ){
                            rB[i].setEditable(false);
                            rB[i].setForeground(Color.green);
                            calif++;
                        }
                    }
                    //AQUI GUARDAMOS EL VALOR DE LA CALIFCICACION
                    mx.calif[2]=calif;
                    //MOTIVACION
                    if(calif<10){
                        for(int h=0;h<A.length;h++){
                            A[h].setVisible(false);
                        }
                        for(int h=0;h<B.length;h++){
                            B[h].setVisible(false);
                        }
                        for(int h=0;h<5;h++){
                            eA[h].setVisible(false);
                            rA[h].setVisible(false);
                            eB[h].setVisible(false);
                            rB[h].setVisible(false);
                        }
                        lineaA.setVisible(false);
                        lineaB.setVisible(false);
                        cero.setVisible(false);
                        uno.setVisible(false);
                        dos.setVisible(false);
                        ceros.setVisible(false);
                        unos.setVisible(false);
                        doss.setVisible(false);
                        iniciaIntro(7);
                    }
                    //CAMBIAR A UN BOTON DE TERMINO DE JUEGO
                    enviar.setText("CERRAR");
                    mx.cargarNiveles();
                    mx.mj = new MJs();
                    mx.mj.MJs(px, py, mx);              //BUG INMINENTE XD
                }
                else{
                    setVisible(false);
                    mx.setVisible(true);
                }
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };enviar.addActionListener(oyente);
    }
    
    public void M2L4(){
        JLabel a[] = new JLabel[10];
        JLabel b[] = new JLabel[10];
        JTextArea[] R = new JTextArea[10];
        int num[] = new int[10];
        int den[] = new int[10];
        
        for (int i = 0; i < 10; i++) {
            do{
                den[i] = (int) Math.floor(Math.random()*(10-6+1)+6);
                num[i] = (int) Math.floor(Math.random()*(den[i]-1+1)+1);
            }while( repetido(den, num, i) );
            
            //IMG
            ImageIcon img = new ImageIcon( "Figuras\\"+num[i]+"-"+den[i]+".png");
            a[i] = new JLabel();
            if(i<5)
                a[i].setBounds((int)(px*0.20),      (int)((py*0.1)+i*(py*0.08)),
                                (int)(px*0.08),      (int)(py*0.08));
            else
                a[i].setBounds((int)(px*0.70),      (int)((py*0.1)+i*(py*0.08)),
                                (int)(px*0.08),      (int)(py*0.08));
            Icon icono = new ImageIcon(img.getImage().getScaledInstance(a[i].getWidth(),a[i].getHeight(),Image.SCALE_DEFAULT));
            a[i].setIcon(icono);
            a[i].setVisible(true);
            fondo.add(a[i]);
            
            //MUN B
            if(i<5)
                b[i] = new JLabel("/"+den[i]);
            else
                b[i] = new JLabel(""+num[i]+"/");
            b[i].setForeground(Color.WHITE);
            b[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            if(i<5)
                b[i].setBounds((int)(px*0.75),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            else
                b[i].setBounds((int)(px*0.20),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            
            fondo.add(b[i]);
            
            //RESPUESTA
            R[i] = new JTextArea("?");
            R[i].setForeground(Color.YELLOW);
            R[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            R[i].setOpaque(false);
            if(i<5)
                R[i].setBounds((int)(px*0.70),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            else
                R[i].setBounds((int)(px*0.30),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            num(R[i]);
            fondo.add(R[i]);
        }
        
        JButton enviar = new JButton("ENVIAR");
        enviar.setForeground(Color.CYAN);
        enviar.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.02) ));
        enviar.setContentAreaFilled(false);
        enviar.setBounds((int)(px*0.91),(int)(py*0.91),(int)(px*0.08),(int)(py*0.05));
        fondo.add(enviar);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                if(enviar.getText().equals("ENVIAR")){
                    int calif=0;
                    for (int i = 0; i < 10; i++) {
                        R[i].setEditable(false);
                        if(i<5){
                            if( R[i].getText().equals(num[i]+"") ){
                                R[i].setForeground(Color.green);
                                calif++;
                            }
                        }
                        else{
                            if( R[i].getText().equals(den[i]+"") ){
                                R[i].setForeground(Color.green);
                                calif++;
                            }
                        }
                    }
                    //AQUI GUARDAMOS EL VALOR DE LA CALIFCICACION
                    mx.calif[3]=calif;
                    //MOTIVACION
                    if(calif<10){
                        for(int h=0;h<10;h++){
                            a[h].setVisible(false);
                            b[h].setVisible(false);
                            R[h].setVisible(false);
                        }
                        iniciaIntro(6);
                    }
                    //CAMBIAR A UN BOTON DE TERMINO DE JUEGO
                    enviar.setText("CERRAR");
                    mx.cargarNiveles();
                    mx.mj = new MJs();
                    mx.mj.MJs(px, py, mx);              //BUG INMINENTE XD
                }
                else{
                    setVisible(false);
                    mx.setVisible(true);
                }
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };enviar.addActionListener(oyente);
    }
    
    public void M2L5(){
        //LINEA A
        JLabel lineaA = new JLabel();
        lineaA.setBounds((int)(px*0.05),  (int)(py*0.2),  (int)(px*0.9), (int)(py*0.1));
        ImageIcon img = new ImageIcon( "Rectas\\RECTA.png");
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(lineaA.getWidth(),lineaA.getHeight(),Image.SCALE_DEFAULT));
        lineaA.setIcon(icono);
        lineaA.setVisible(true);
        fondo.add(lineaA);
        //LINEA B
        JLabel lineaB = new JLabel();
        lineaB.setBounds((int)(px*0.05),  (int)(py*0.7),  (int)(px*0.9), (int)(py*0.1));
        lineaB.setIcon(icono);
        lineaB.setVisible(true);
        fondo.add(lineaB);
        
        //A
        int denA = (int) Math.floor(Math.random()*(10-7+1)+7);
        JLabel A[] = new JLabel[denA+denA+1];
        for (int i = 0; i < A.length; i++) {
            //MARCAS
            A[i] = new JLabel();
            A[i].setBounds((int)((px*0.0)+(i*(lineaA.getWidth()/(A.length-1)))),  (int)(py*0.2),  (int)(px*0.1), (int)(py*0.1));
            ImageIcon img2 = new ImageIcon("Rectas\\lineaV.png");
            Icon icono2 = new ImageIcon(img2.getImage().getScaledInstance(A[i].getWidth(),A[i].getHeight(),Image.SCALE_DEFAULT));
            A[i].setIcon(icono2);
            A[i].setVisible(true);
            fondo.add(A[i]);
            //UNIDADES
            if(i==0){
                ceros = new JLabel("0");
                ceros.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                ceros.setBounds((int)((px*0.04)+(i*(lineaA.getWidth()/(A.length-1)))),  (int)(py*0.3),  (int)(px*0.1), (int)(py*0.1));
                ceros.setForeground(Color.WHITE);
                ceros.setVisible(true);
                fondo.add(ceros);
            }
            if(i==denA){
                unos = new JLabel("1");
                unos.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                unos.setBounds((int)((px*0.04)+(i*(lineaA.getWidth()/(A.length-1)))),  (int)(py*0.3),  (int)(px*0.1), (int)(py*0.1));
                unos.setForeground(Color.WHITE);
                unos.setVisible(true);
                fondo.add(unos);
            }
            if(i==denA+denA){
                doss = new JLabel("2");
                doss.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                doss.setBounds((int)((px*0.04)+(i*(lineaA.getWidth()/(A.length-1)))),  (int)(py*0.3),  (int)(px*0.1), (int)(py*0.1));
                doss.setForeground(Color.WHITE);
                doss.setVisible(true);
                fondo.add(doss);
            }
        }
        //B
        int denB;
        do{
            denB = (int) Math.floor(Math.random()*(10-7+1)+7);
        }while(denB == denA);
        JLabel B[] = new JLabel[denB+denB+1];
        for (int i = 0; i < B.length; i++) {
            //MARCAS
            B[i] = new JLabel();
            B[i].setBounds((int)((px*0.0)+(i*(lineaB.getWidth()/(B.length-1)))),  (int)(py*0.7),  (int)(px*0.1), (int)(py*0.1));
            ImageIcon img2 = new ImageIcon("Rectas\\lineaV.png");
            Icon icono2 = new ImageIcon(img2.getImage().getScaledInstance(B[i].getWidth(),B[i].getHeight(),Image.SCALE_DEFAULT));
            B[i].setIcon(icono2);
            B[i].setVisible(true);
            fondo.add(B[i]);
            //UNIDADES
            if(i==0){
                cero = new JLabel("0");
                cero.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                cero.setBounds((int)((px*0.04)+(i*(lineaB.getWidth()/(B.length-1)))),  (int)(py*0.8),  (int)(px*0.1), (int)(py*0.1));
                cero.setForeground(Color.WHITE);
                cero.setVisible(true);
                fondo.add(cero);
            }
            if(i==denB){
                uno = new JLabel("1");
                uno.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                uno.setBounds((int)((px*0.04)+(i*(lineaB.getWidth()/(B.length-1)))),  (int)(py*0.8),  (int)(px*0.1), (int)(py*0.1));
                uno.setForeground(Color.WHITE);
                uno.setVisible(true);
                fondo.add(uno);
            }
            if(i==denB+denB){
                dos = new JLabel("2");
                dos.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                dos.setBounds((int)((px*0.04)+(i*(lineaB.getWidth()/(B.length-1)))),  (int)(py*0.8),  (int)(px*0.1), (int)(py*0.1));
                dos.setForeground(Color.WHITE);
                dos.setVisible(true);
                fondo.add(dos);
            }
        }
        
        int numA[] = new int[5];
        JTextArea eA[] = new JTextArea[5];
        JTextArea rA[] = new JTextArea[5];
        int numB[] = new int[5];
        JTextArea eB[] = new JTextArea[5];
        JTextArea rB[] = new JTextArea[5];
        for (int i = 0; i < 5; i++) {
            //EJERCICIOS A
            do{
                numA[i] = (int) Math.floor(Math.random()*((denA+denA)-1+1)+1);
            }while( repetido(numA, i) );
            //Etiquetas A
            eA[i] = new JTextArea("- \n"+denA);
            eA[i].setForeground(Color.WHITE);
            eA[i].setEditable(false);
            eA[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.04) ));
            eA[i].setOpaque(false);
            eA[i].setBounds((int)((px*0.04)+(numA[i]*(lineaA.getWidth()/(A.length-1)))),  (int)(py*0.07),  
                            (int)(px*0.05),      (int)(py*0.1));
            fondo.add(eA[i]);
            //RESPUESTAS A
            rA[i] = new JTextArea((char)(65+i)+"");
            rA[i].setForeground(Color.YELLOW);
            rA[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.04) ));
            rA[i].setOpaque(false);
            rA[i].setBounds((int)((px*0.04)+(numA[i]*(lineaA.getWidth()/(A.length-1)))),      (int)((py*.04)),
                            (int)(px*0.05),      (int)(py*0.05));
            num2DIG(rA[i]);
            fondo.add(rA[i]);
            
            //EJERCICIOS B
            do{
                numB[i] = (int) Math.floor(Math.random()*((denB+denB)-1+1)+1);
            }while( repetido(numB, i) );
            //Etiquetas B
            eB[i] = new JTextArea("- \n"+denB);
            eB[i].setForeground(Color.WHITE);
            eB[i].setEditable(false);
            eB[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.04) ));
            eB[i].setOpaque(false);
            eB[i].setBounds((int)((px*0.04)+(numB[i]*(lineaB.getWidth()/(B.length-1)))),  (int)(py*0.57),  
                            (int)(px*0.05), (int)(py*0.1));
            fondo.add(eB[i]);
            //RESPUESTAS B
            rB[i] = new JTextArea((char)(65+i)+"");
            rB[i].setForeground(Color.YELLOW);
            rB[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.04) ));
            rB[i].setOpaque(false);
            rB[i].setBounds((int)((px*0.04)+(numB[i]*(lineaB.getWidth()/(B.length-1)))),      (int)((py*.54)),
                            (int)(px*0.05),      (int)(py*0.05));
            num2DIG(rB[i]);
            fondo.add(rB[i]);
        }

        
        JButton enviar = new JButton("ENVIAR");
        enviar.setForeground(Color.CYAN);
        enviar.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.02) ));
        enviar.setContentAreaFilled(false);
        enviar.setBounds((int)(px*0.91),(int)(py*0.91),(int)(px*0.08),(int)(py*0.05));
        fondo.add(enviar);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                if(enviar.getText().equals("ENVIAR")){
                    int calif=0;
                    for (int i = 0; i < 5; i++) {
                        if( rA[i].getText().equals(numA[i]+"") ){
                            rA[i].setEditable(false);
                            rA[i].setForeground(Color.green);
                            calif++;
                        }
                        if( rB[i].getText().equals(numB[i]+"") ){
                            rB[i].setEditable(false);
                            rB[i].setForeground(Color.green);
                            calif++;
                        }
                    }
                    //AQUI GUARDAMOS EL VALOR DE LA CALIFCICACION
                    mx.calif[4]=calif;
                    //MOTIVACION
                    if(calif<10){
                        for(int h=0;h<A.length;h++){
                            A[h].setVisible(false);
                        }
                        for(int h=0;h<B.length;h++){
                            B[h].setVisible(false);
                        }
                        for(int h=0;h<5;h++){
                            eA[h].setVisible(false);
                            rA[h].setVisible(false);
                            eB[h].setVisible(false);
                            rB[h].setVisible(false);
                        }
                        lineaA.setVisible(false);
                        lineaB.setVisible(false);
                        cero.setVisible(false);
                        uno.setVisible(false);
                        dos.setVisible(false);
                        ceros.setVisible(false);
                        unos.setVisible(false);
                        doss.setVisible(false);
                        iniciaIntro(7);
                    }
                    for(int h=0;h<A.length;h++){
                            A[h].setVisible(false);
                        }
                        for(int h=0;h<B.length;h++){
                            B[h].setVisible(false);
                        }
                        for(int h=0;h<5;h++){
                            eA[h].setVisible(false);
                            rA[h].setVisible(false);
                            eB[h].setVisible(false);
                            rB[h].setVisible(false);
                        }
                        lineaA.setVisible(false);
                        lineaB.setVisible(false);
                        cero.setVisible(false);
                        uno.setVisible(false);
                        dos.setVisible(false);
                        ceros.setVisible(false);
                        unos.setVisible(false);
                        doss.setVisible(false);
                    int prom=0;
                    for(int i=1;i<5;i++){
                        prom = prom + mx.calif[i];
                    }
                    System.out.println(prom);
                    if(prom<24){
                        iniciaIntro(10);
                    }else{
                        if(prom>24)//BRONCE
                            iniciaIntro(11);
                        if(prom>32)//PLATA
                            iniciaIntro(12);
                        if(prom==40)//ORO
                            iniciaIntro(13);
                    }
                    //CAMBIAR A UN BOTON DE TERMINO DE JUEGO
                    enviar.setText("CERRAR");
                    mx.cargarNiveles();
                    mx.mj = new MJs();
                    mx.mj.MJs(px, py, mx);              //BUG INMINENTE XD
                }
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };enviar.addActionListener(oyente);
    }
    
    public void M3L1(){
        iniciaIntro(3);
        System.out.println("M3L1");
        mx.calif[0]=10;
    }
    
    public void M3L2(){
        JLabel a[] = new JLabel[10];
        JLabel b[] = new JLabel[10];
        JTextArea[] R = new JTextArea[10];
        
        for (int i = 0; i < 10; i++) {
            //NUM A
            a[i] = new JLabel( (int) Math.floor(Math.random()*(1000-1+1)+1) +"" );
            a[i].setForeground(Color.WHITE);
            a[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            a[i].setBounds((int)(px*0.35),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            fondo.add(a[i]);
            //MUN B
            b[i] = new JLabel( (int) Math.floor(Math.random()*(1000-1+1)+1) +"" );
            b[i].setForeground(Color.WHITE);
            b[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            b[i].setBounds((int)(px*0.55),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            fondo.add(b[i]);
            //RESPUESTA
            R[i] = new JTextArea();
            R[i].setForeground(Color.blue);
            R[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            R[i].setOpaque(false);
            R[i].setBounds((int)(px*0.45),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            sign(R[i]);
            fondo.add(R[i]);
        }
        
        JButton enviar = new JButton("ENVIAR");
        enviar.setForeground(Color.CYAN);
        enviar.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.02) ));
        enviar.setContentAreaFilled(false);
        enviar.setBounds((int)(px*0.91),(int)(py*0.91),(int)(px*0.08),(int)(py*0.05));
        fondo.add(enviar);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                if(enviar.getText().equals("ENVIAR")){
                    int calif=0;
                    for (int i = 0; i < 10; i++) {
                        String signo;
                        if ( Integer.parseInt(a[i].getText()) > Integer.parseInt(b[i].getText()) ) {//nums[i]*nums[i+10] == Integer.parseInt(R[i].getText()
                            signo=">";
                        }
                        else{
                            if( Integer.parseInt(a[i].getText()) == Integer.parseInt(b[i].getText()) ){
                                signo="=";
                            }
                            else{
                                signo="<";
                            }
                        }
                        //Comprobación de respuesta correcta
                        if(R[i].getText().equals(signo)){
                            R[i].setEditable(false);
                            R[i].setForeground(Color.GREEN);
                            calif++;
                        }
                    }
                    //AQUI GUARDAMOS EL VALOR DE LA CALIFCICACION
                    mx.calif[1]=calif;
                    //MOTIVACION
                    if(calif<10){
                        for(int h=0;h<10;h++){
                            a[h].setVisible(false);
                            b[h].setVisible(false);
                            R[h].setVisible(false);
                        }
                        iniciaIntro(8);
                    }
                    //CAMBIAR A UN BOTON DE TERMINO DE JUEGO
                    enviar.setText("CERRAR");
                    mx.cargarNiveles();
                    mx.mj = new MJs();
                    mx.mj.MJs(px, py, mx);              //BUG INMINENTE XD
                }
                else{
                    setVisible(false);
                    mx.setVisible(true);
                }
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };enviar.addActionListener(oyente);
    }
    
    public void M3L3(){
        JLabel a[] = new JLabel[10];
        JLabel b[] = new JLabel[10];
        JTextArea[] R = new JTextArea[10];
        
        for (int i = 0; i < 10; i++) {
            //NUM A
            if( (int) Math.floor(Math.random()*(2-1+1)+1) == 1){
                int may = (int) Math.floor(Math.random()*(250-1+1)+1);
                a[i] = new JLabel(  may+"-"+ (int) Math.floor(Math.random()*(may-1+1)+1) );
            }
            else
                a[i] = new JLabel( (int) Math.floor(Math.random()*(250-1+1)+1) +"+"+ (int) Math.floor(Math.random()*(250-1+1)+1) );
            a[i].setForeground(Color.WHITE);
            a[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            a[i].setBounds((int)(px*0.2),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.3),      (int)(py*0.08));
            fondo.add(a[i]);
            //MUN B
            if( (int) Math.floor(Math.random()*(2-1+1)+1) == 1){
                int may = (int) Math.floor(Math.random()*(250-1+1)+1);
                b[i] = new JLabel(  may+"-"+ (int) Math.floor(Math.random()*(may-1+1)+1) );
            }
            else
                b[i] = new JLabel( (int) Math.floor(Math.random()*(250-1+1)+1) +"+"+ (int) Math.floor(Math.random()*(250-1+1)+1) );
            b[i].setForeground(Color.WHITE);
            b[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            b[i].setBounds((int)(px*0.6),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.3),      (int)(py*0.08));
            fondo.add(b[i]);
            //RESPUESTA
            R[i] = new JTextArea();
            R[i].setForeground(Color.blue);
            R[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            R[i].setOpaque(false);
            R[i].setBounds((int)(px*0.475),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            sign(R[i]);
            fondo.add(R[i]);
        }
        
        JButton enviar = new JButton("ENVIAR");
        enviar.setForeground(Color.CYAN);
        enviar.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.02) ));
        enviar.setContentAreaFilled(false);
        enviar.setBounds((int)(px*0.91),(int)(py*0.91),(int)(px*0.08),(int)(py*0.05));
        fondo.add(enviar);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                if(enviar.getText().equals("ENVIAR")){
                    int calif=0;
                    for (int i = 0; i < 10; i++) {
                        String signo;
                        if ( operacion(a[i].getText()) > operacion(b[i].getText()) ) {//nums[i]*nums[i+10] == Integer.parseInt(R[i].getText()
                            signo=">";
                        }
                        else{
                            if( operacion(a[i].getText()) == operacion(b[i].getText()) ){
                                signo="=";
                            }
                            else{
                                signo="<";
                            }
                        }
                        //Comprobación de respuesta correcta
                        if(R[i].getText().equals(signo)){
                            R[i].setEditable(false);
                            R[i].setForeground(Color.GREEN);
                            calif++;
                        }
                    }
                    //AQUI GUARDAMOS EL VALOR DE LA CALIFCICACION
                    mx.calif[2]=calif;
                    //MOTIVACION
                    if(calif<10){
                        for(int h=0;h<10;h++){
                            a[h].setVisible(false);
                            b[h].setVisible(false);
                            R[h].setVisible(false);
                        }
                        iniciaIntro(9);
                    }
                    //CAMBIAR A UN BOTON DE TERMINO DE JUEGO
                    enviar.setText("CERRAR");
                    mx.cargarNiveles();
                    mx.mj = new MJs();
                    mx.mj.MJs(px, py, mx);              //BUG INMINENTE XD
                }
                else{
                    setVisible(false);
                    mx.setVisible(true);
                }
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };enviar.addActionListener(oyente);
    }
    
    public void M3L4(){
        JLabel a[] = new JLabel[10];
        JLabel b[] = new JLabel[10];
        JTextArea[] R = new JTextArea[10];
        
        for (int i = 0; i < 10; i++) {
            //NUM A
            if( (int) Math.floor(Math.random()*(2-1+1)+1) == 1){
                int may = (int) Math.floor(Math.random()*(500-1+1)+1);
                a[i] = new JLabel(  may+"-"+ (int) Math.floor(Math.random()*(may-1+1)+1) );
            }
            else
                a[i] = new JLabel( (int) Math.floor(Math.random()*(500-1+1)+1) +"+"+ (int) Math.floor(Math.random()*(500-1+1)+1) );
            a[i].setForeground(Color.WHITE);
            a[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            a[i].setBounds((int)(px*0.2),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.3),      (int)(py*0.08));
            fondo.add(a[i]);
            //MUN B
            if( (int) Math.floor(Math.random()*(2-1+1)+1) == 1){
                int may = (int) Math.floor(Math.random()*(500-1+1)+1);
                b[i] = new JLabel(  may+"-"+ (int) Math.floor(Math.random()*(may-1+1)+1) );
            }
            else
                b[i] = new JLabel( (int) Math.floor(Math.random()*(500-1+1)+1) +"+"+ (int) Math.floor(Math.random()*(500-1+1)+1) );
            b[i].setForeground(Color.WHITE);
            b[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            b[i].setBounds((int)(px*0.6),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.3),      (int)(py*0.08));
            fondo.add(b[i]);
            //RESPUESTA
            R[i] = new JTextArea();
            R[i].setForeground(Color.blue);
            R[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            R[i].setOpaque(false);
            R[i].setBounds((int)(px*0.475),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            sign(R[i]);
            fondo.add(R[i]);
        }
        
        JButton enviar = new JButton("ENVIAR");
        enviar.setForeground(Color.CYAN);
        enviar.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.02) ));
        enviar.setContentAreaFilled(false);
        enviar.setBounds((int)(px*0.91),(int)(py*0.91),(int)(px*0.08),(int)(py*0.05));
        fondo.add(enviar);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                if(enviar.getText().equals("ENVIAR")){
                    int calif=0;
                    for (int i = 0; i < 10; i++) {
                        String signo;
                        if ( operacion(a[i].getText()) > operacion(b[i].getText()) ) {//nums[i]*nums[i+10] == Integer.parseInt(R[i].getText()
                            signo=">";
                        }
                        else{
                            if( operacion(a[i].getText()) == operacion(b[i].getText()) ){
                                signo="=";
                            }
                            else{
                                signo="<";
                            }
                        }
                        //Comprobación de respuesta correcta
                        if(R[i].getText().equals(signo)){
                            R[i].setEditable(false);
                            R[i].setForeground(Color.GREEN);
                            calif++;
                        }
                    }
                    //AQUI GUARDAMOS EL VALOR DE LA CALIFCICACION
                    mx.calif[3]=calif;
                    //MOTIVACION
                    if(calif<10){
                        for(int h=0;h<10;h++){
                            a[h].setVisible(false);
                            b[h].setVisible(false);
                            R[h].setVisible(false);
                        }
                        iniciaIntro(8);
                    }
                    //CAMBIAR A UN BOTON DE TERMINO DE JUEGO
                    enviar.setText("CERRAR");
                    mx.cargarNiveles();
                    mx.mj = new MJs();
                    mx.mj.MJs(px, py, mx);              //BUG INMINENTE XD
                }
                else{
                    setVisible(false);
                    mx.setVisible(true);
                }
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };enviar.addActionListener(oyente);
    }
    
    public void M3L5(){
        JLabel a[] = new JLabel[10];
        JLabel b[] = new JLabel[10];
        JTextArea[] R = new JTextArea[10];
        
        for (int i = 0; i < 10; i++) {
            //NUM A
            if( (int) Math.floor(Math.random()*(2-1+1)+1) == 1){
                int may = (int) Math.floor(Math.random()*(500-250+1)+250);
                a[i] = new JLabel(  may+"-"+ (int) Math.floor(Math.random()*(may-250+1)+250) );
            }
            else
                a[i] = new JLabel( (int) Math.floor(Math.random()*(500-250+1)+250) +"+"+ (int) Math.floor(Math.random()*(500-250+1)+250) );
            a[i].setForeground(Color.WHITE);
            a[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            a[i].setBounds((int)(px*0.2),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.3),      (int)(py*0.08));
            fondo.add(a[i]);
            //MUN B
            if( (int) Math.floor(Math.random()*(2-1+1)+1) == 1){
                int may = (int) Math.floor(Math.random()*(500-250+1)+250);
                b[i] = new JLabel(  may+"-"+ (int) Math.floor(Math.random()*(may-250+1)+250) );
            }
            else
                b[i] = new JLabel( (int) Math.floor(Math.random()*(500-250+1)+250) +"+"+ (int) Math.floor(Math.random()*(500-250+1)+250) );
            b[i].setForeground(Color.WHITE);
            b[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            b[i].setBounds((int)(px*0.6),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.3),      (int)(py*0.08));
            fondo.add(b[i]);
            //RESPUESTA
            R[i] = new JTextArea();
            R[i].setForeground(Color.blue);
            R[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            R[i].setOpaque(false);
            R[i].setBounds((int)(px*0.475),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            sign(R[i]);
            fondo.add(R[i]);
        }
        
        JButton enviar = new JButton("ENVIAR");
        enviar.setForeground(Color.CYAN);
        enviar.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.02) ));
        enviar.setContentAreaFilled(false);
        enviar.setBounds((int)(px*0.91),(int)(py*0.91),(int)(px*0.08),(int)(py*0.05));
        fondo.add(enviar);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                if(enviar.getText().equals("ENVIAR")){
                    int calif=0;
                    for (int i = 0; i < 10; i++) {
                        String signo;
                        if ( operacion(a[i].getText()) > operacion(b[i].getText()) ) {//nums[i]*nums[i+10] == Integer.parseInt(R[i].getText()
                            signo=">";
                        }
                        else{
                            if( operacion(a[i].getText()) == operacion(b[i].getText()) ){
                                signo="=";
                            }
                            else{
                                signo="<";
                            }
                        }
                        //Comprobación de respuesta correcta
                        if(R[i].getText().equals(signo)){
                            R[i].setEditable(false);
                            R[i].setForeground(Color.GREEN);
                            calif++;
                        }
                    }
                    //AQUI GUARDAMOS EL VALOR DE LA CALIFCICACION
                    mx.calif[4]=calif;
                    //MOTIVACION
                    if(calif<10){
                        for(int h=0;h<10;h++){
                            a[h].setVisible(false);
                            b[h].setVisible(false);
                            R[h].setVisible(false);
                        }
                        iniciaIntro(9);
                    }
                    for(int h=0;h<10;h++){
                            a[h].setVisible(false);
                            b[h].setVisible(false);
                            R[h].setVisible(false);
                        }
                    int prom=0;
                    for(int i=1;i<5;i++){
                        prom = prom + mx.calif[i];
                    }
                    System.out.println(prom);
                    if(prom<24){
                        iniciaIntro(10);
                    }else{
                        if(prom>24)//BRONCE
                            iniciaIntro(11);
                        if(prom>32)//PLATA
                            iniciaIntro(12);
                        if(prom==40)//ORO
                            iniciaIntro(13);
                    }
                    //CAMBIAR A UN BOTON DE TERMINO DE JUEGO
                    enviar.setText("CERRAR");
                    mx.cargarNiveles();
                    mx.mj = new MJs();
                    mx.mj.MJs(px, py, mx);              //BUG INMINENTE XD
                }
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };enviar.addActionListener(oyente);
    }
    
    
    
    public void M1CR1(){
        tiempoInicio = System.nanoTime();
        int nums[] = new int[20];
        JLabel op[] = new JLabel[10];
        JTextArea[] R = new JTextArea[10];
        
        for (int i = 0; i < 20; i++) {
            nums[i] = (int) Math.floor(Math.random()*(30-1+1)+1);//NUMS ENTRE 1 Y 30
        }
        
        for (int i = 0; i < 10; i++) {
            op[i] = new JLabel(nums[i] + " X " + nums[i+10] + "=");
            op[i].setForeground(Color.BLUE);
            op[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            op[i].setBounds((int)(px*0.35),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.3),      (int)(py*0.08));
            fondo.add(op[i]);
            //RESPUESTAS
            R[i] = new JTextArea();
            R[i].setForeground(Color.red);
            R[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            R[i].setOpaque(false);
            R[i].setBounds((int)(px*0.65),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            num(R[i]);
            fondo.add(R[i]);
        }
        
        JButton enviar = new JButton("SIGUIENTE");
        enviar.setForeground(Color.CYAN);
        enviar.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.02) ));
        enviar.setContentAreaFilled(false);
        enviar.setBounds((int)(px*0.91),(int)(py*0.91),(int)(px*0.08),(int)(py*0.05));
        fondo.add(enviar);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                    int calif=0;
                    for (int i = 0; i < 10; i++) {
                        if ( R[i].getText().equals(nums[i]*nums[i+10]+"") ) {
                            R[i].setEditable(false);
                            R[i].setForeground(Color.GREEN);
                            calif++;
                        }
                    }
                    //AQUI GUARDAMOS EL VALOR DE LA CALIFCICACION
                    mx.califCR[0]=calif;
                    //CAMBIAR A UN BOTON DE TERMINO DE JUEGO
                    mx.mj.fondo.removeAll();
                    mx.mj.setComponentes(2);
                    mx.m.v.getContentPane().add(mx.mj);
                    
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };enviar.addActionListener(oyente);
    }
    
    public void M1CR2(){
        JLabel a[] = new JLabel[3];
        JLabel b[] = new JLabel[3];
        JTextArea[][] R = new JTextArea[3][3];
        
        for (int i = 0; i < 3; i++) {
            
            a[i] = new JLabel( (int) Math.floor(Math.random()*(30-1+1)+1) +"" );
            a[i].setForeground(Color.BLUE);
            a[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            a[i].setBounds((int)((px*0.43)+i*(px*0.12)),      (int)(py*0.1),
                            (int)(px*0.1),      (int)(py*0.08));
            fondo.add(a[i]);
            
            b[i] = new JLabel( (int) Math.floor(Math.random()*(30-1+1)+1) +"" );
            b[i].setForeground(Color.yellow);
            b[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            b[i].setBounds((int)(px*0.35),      (int)((py*0.18)+i*(py*0.12)),
                            (int)(px*0.1),      (int)(py*0.08));
            fondo.add(b[i]);
            
            for (int j = 0; j < 3; j++) {
                R[i][j] = new JTextArea();
                R[i][j].setForeground(Color.red);
                R[i][j].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                R[i][j].setOpaque(false);
                R[i][j].setBounds((int)((px*0.43)+i*(px*0.12)),      (int)((py*0.18)+j*(py*0.12)),
                            (int)(px*0.1),      (int)(py*0.08));
                num(R[i][j]);
                fondo.add(R[i][j]);
            }
        }
        
        JButton enviar = new JButton("ENVIAR");
        enviar.setForeground(Color.CYAN);
        enviar.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.02) ));
        enviar.setContentAreaFilled(false);
        enviar.setBounds((int)(px*0.91),(int)(py*0.91),(int)(px*0.08),(int)(py*0.05));
        fondo.add(enviar);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                if(enviar.getText().equals("ENVIAR")){
                    tiempoFin = System.nanoTime();
                    System.out.println("Duración: " + ((tiempoInicio-tiempoFin)/1e6)/1000 + " s");
                    int calif=1;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if ( R[i][j].getText().equals(Integer.parseInt(a[i].getText())*Integer.parseInt(b[j].getText())+"") ) {
                                R[i][j].setEditable(false);
                                R[i][j].setEditable(false);
                                R[i][j].setForeground(Color.GREEN);
                                calif++;
                            }
                        }
                    }
                    //AQUI GUARDAMOS EL VALOR DE LA CALIFCICACION
                    mx.califCR[1]=calif;
                    //DAR MEDALLA O NO
                    for(int h=0;h<3;h++){
                        a[h].setVisible(false);
                        b[h].setVisible(false);
                    }
                    for(int h=0;h<3;h++){
                        for(int g=0;g<3;g++){
                            R[h][g].setVisible(false);
                        }
                    }
                    if((mx.califCR[0]+mx.califCR[1])==20){
                        if((-(((tiempoInicio-tiempoFin)/1e6)/1000))<360 ){//MENOS DE 6 MIN
                            iniciaIntro(16);
                        }
                        if((-(((tiempoInicio-tiempoFin)/1e6)/1000))>=360 && ((-(((tiempoInicio-tiempoFin)/1e6)/1000))<420) ){//MENOS DE 7 MIN
                            iniciaIntro(15);
                        }
                        if((-(((tiempoInicio-tiempoFin)/1e6)/1000))>=360 && ((-(((tiempoInicio-tiempoFin)/1e6)/1000))<=480)){//MENOS DE 8 MIN
                            iniciaIntro(14);
                        }
                        if((-(((tiempoInicio-tiempoFin)/1e6)/1000))>480){
                            iniciaIntro(17);
                        }
                    }else{
                        iniciaIntro(17);
                    }
                    enviar.setText("CERRAR");
                    mx.cargarNiveles();
                    mx.mj = new MJs();
                    mx.mj.MJs(px, py, mx);              //BUG INMINENTE XD
                }else{
                    setVisible(false);
                    mx.m.setVisible(true);
                }
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };enviar.addActionListener(oyente);
    }
    
    public void M2CR1(){
        tiempoInicio = System.nanoTime();
        JLabel a[] = new JLabel[10];
        JLabel b[] = new JLabel[10];
        JTextArea[] R = new JTextArea[10];
        int num[] = new int[10];
        int den[] = new int[10];
        
        for (int i = 0; i < 10; i++) {
            do{
                den[i] = (int) Math.floor(Math.random()*(10-2+1)+2);
                num[i] = (int) Math.floor(Math.random()*(den[i]-1+1)+1);
            }while( repetido(den, num, i) );
            
            //IMG
            ImageIcon img = new ImageIcon( "Figuras\\"+num[i]+"-"+den[i]+".png");
            a[i] = new JLabel();
            if(i<5)
                a[i].setBounds((int)(px*0.20),      (int)((py*0.1)+i*(py*0.08)),
                                (int)(px*0.08),      (int)(py*0.08));
            else
                a[i].setBounds((int)(px*0.70),      (int)((py*0.1)+i*(py*0.08)),
                                (int)(px*0.08),      (int)(py*0.08));
            Icon icono = new ImageIcon(img.getImage().getScaledInstance(a[i].getWidth(),a[i].getHeight(),Image.SCALE_DEFAULT));
            a[i].setIcon(icono);
            a[i].setVisible(true);
            fondo.add(a[i]);
            
            //MUN B
            if(i<5)
                b[i] = new JLabel("/"+den[i]);
            else
                b[i] = new JLabel(""+num[i]+"/");
            b[i].setForeground(Color.WHITE);
            b[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            if(i<5)
                b[i].setBounds((int)(px*0.75),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            else
                b[i].setBounds((int)(px*0.20),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            
            fondo.add(b[i]);
            
            //RESPUESTA
            R[i] = new JTextArea("?");
            R[i].setForeground(Color.YELLOW);
            R[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            R[i].setOpaque(false);
            if(i<5)
                R[i].setBounds((int)(px*0.70),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            else
                R[i].setBounds((int)(px*0.30),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            num(R[i]);
            fondo.add(R[i]);
        }
        
        JButton enviar = new JButton("ENVIAR");
        enviar.setForeground(Color.CYAN);
        enviar.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.02) ));
        enviar.setContentAreaFilled(false);
        enviar.setBounds((int)(px*0.91),(int)(py*0.91),(int)(px*0.08),(int)(py*0.05));
        fondo.add(enviar);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                    int calif=0;
                    for (int i = 0; i < 10; i++) {
                        R[i].setEditable(false);
                        if(i<5){
                            if( R[i].getText().equals(num[i]+"") ){
                                R[i].setForeground(Color.green);
                                calif++;
                            }
                        }
                        else{
                            if( R[i].getText().equals(den[i]+"") ){
                                R[i].setForeground(Color.green);
                                calif++;
                            }
                        }
                    }
                    System.out.println("ca "+calif);
                    //AQUI GUARDAMOS EL VALOR DE LA CALIFCICACION
                    mx.califCR[0]=calif;
                    //CAMBIAR A UN BOTON DE TERMINO DE JUEGO
                    mx.mj.fondo.removeAll();
                    mx.mj.setComponentes(2);
                    mx.m.v.getContentPane().add(mx.mj);
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };enviar.addActionListener(oyente);
    }
    
    public void M2CR2(){
        //LINEA A
        JLabel lineaA = new JLabel();
        lineaA.setBounds((int)(px*0.05),  (int)(py*0.2),  (int)(px*0.9), (int)(py*0.1));
        ImageIcon img = new ImageIcon( "Rectas\\RECTA.png");
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(lineaA.getWidth(),lineaA.getHeight(),Image.SCALE_DEFAULT));
        lineaA.setIcon(icono);
        lineaA.setVisible(true);
        fondo.add(lineaA);
        //LINEA B
        JLabel lineaB = new JLabel();
        lineaB.setBounds((int)(px*0.05),  (int)(py*0.7),  (int)(px*0.9), (int)(py*0.1));
        lineaB.setIcon(icono);
        lineaB.setVisible(true);
        fondo.add(lineaB);
        
        //A
        int denA = (int) Math.floor(Math.random()*(10-3+1)+3);
        JLabel A[] = new JLabel[denA+denA+1];
        for (int i = 0; i < A.length; i++) {
            //MARCAS
            A[i] = new JLabel();
            A[i].setBounds((int)((px*0.0)+(i*(lineaA.getWidth()/(A.length-1)))),  (int)(py*0.2),  (int)(px*0.1), (int)(py*0.1));
            ImageIcon img2 = new ImageIcon("Rectas\\lineaV.png");
            Icon icono2 = new ImageIcon(img2.getImage().getScaledInstance(A[i].getWidth(),A[i].getHeight(),Image.SCALE_DEFAULT));
            A[i].setIcon(icono2);
            A[i].setVisible(true);
            fondo.add(A[i]);
            //UNIDADES
            if(i==0){
                ceros = new JLabel("0");
                ceros.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                ceros.setBounds((int)((px*0.04)+(i*(lineaA.getWidth()/(A.length-1)))),  (int)(py*0.3),  (int)(px*0.1), (int)(py*0.1));
                ceros.setForeground(Color.WHITE);
                ceros.setVisible(true);
                fondo.add(ceros);
            }
            if(i==denA){
                unos = new JLabel("1");
                unos.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                unos.setBounds((int)((px*0.04)+(i*(lineaA.getWidth()/(A.length-1)))),  (int)(py*0.3),  (int)(px*0.1), (int)(py*0.1));
                unos.setForeground(Color.WHITE);
                unos.setVisible(true);
                fondo.add(unos);
            }
            if(i==denA+denA){
                doss = new JLabel("2");
                doss.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                doss.setBounds((int)((px*0.04)+(i*(lineaA.getWidth()/(A.length-1)))),  (int)(py*0.3),  (int)(px*0.1), (int)(py*0.1));
                doss.setForeground(Color.WHITE);
                doss.setVisible(true);
                fondo.add(doss);
            }
        }
        //B
        int denB;
        do{
            denB = (int) Math.floor(Math.random()*(10-3+1)+3);
        }while(denB == denA);
        JLabel B[] = new JLabel[denB+denB+1];
        for (int i = 0; i < B.length; i++) {
            //MARCAS
            B[i] = new JLabel();
            B[i].setBounds((int)((px*0.0)+(i*(lineaB.getWidth()/(B.length-1)))),  (int)(py*0.7),  (int)(px*0.1), (int)(py*0.1));
            ImageIcon img2 = new ImageIcon("Rectas\\lineaV.png");
            Icon icono2 = new ImageIcon(img2.getImage().getScaledInstance(B[i].getWidth(),B[i].getHeight(),Image.SCALE_DEFAULT));
            B[i].setIcon(icono2);
            B[i].setVisible(true);
            fondo.add(B[i]);
            //UNIDADES
            if(i==0){
                cero = new JLabel("0");
                cero.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                cero.setBounds((int)((px*0.04)+(i*(lineaB.getWidth()/(B.length-1)))),  (int)(py*0.8),  (int)(px*0.1), (int)(py*0.1));
                cero.setForeground(Color.WHITE);
                cero.setVisible(true);
                fondo.add(cero);
            }
            if(i==denB){
                uno = new JLabel("1");
                uno.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                uno.setBounds((int)((px*0.04)+(i*(lineaB.getWidth()/(B.length-1)))),  (int)(py*0.8),  (int)(px*0.1), (int)(py*0.1));
                uno.setForeground(Color.WHITE);
                uno.setVisible(true);
                fondo.add(uno);
            }
            if(i==denB+denB){
                dos = new JLabel("2");
                dos.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
                dos.setBounds((int)((px*0.04)+(i*(lineaB.getWidth()/(B.length-1)))),  (int)(py*0.8),  (int)(px*0.1), (int)(py*0.1));
                dos.setForeground(Color.WHITE);
                dos.setVisible(true);
                fondo.add(dos);
            }
        }
        
        int numA[] = new int[5];
        JTextArea eA[] = new JTextArea[5];
        JTextArea rA[] = new JTextArea[5];
        int numB[] = new int[5];
        JTextArea eB[] = new JTextArea[5];
        JTextArea rB[] = new JTextArea[5];
        for (int i = 0; i < 5; i++) {
            //EJERCICIOS A
            do{
                numA[i] = (int) Math.floor(Math.random()*((denA+denA)-1+1)+1);
            }while( repetido(numA, i) );
            //Etiquetas A
            eA[i] = new JTextArea("- \n"+denA);
            eA[i].setForeground(Color.WHITE);
            eA[i].setEditable(false);
            eA[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.04) ));
            eA[i].setOpaque(false);
            eA[i].setBounds((int)((px*0.04)+(numA[i]*(lineaA.getWidth()/(A.length-1)))),  (int)(py*0.07),  
                            (int)(px*0.05),      (int)(py*0.1));
            fondo.add(eA[i]);
            //RESPUESTAS A
            rA[i] = new JTextArea((char)(65+i)+"");
            rA[i].setForeground(Color.YELLOW);
            rA[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.04) ));
            rA[i].setOpaque(false);
            rA[i].setBounds((int)((px*0.04)+(numA[i]*(lineaA.getWidth()/(A.length-1)))),      (int)((py*.04)),
                            (int)(px*0.05),      (int)(py*0.05));
            num2DIG(rA[i]);
            fondo.add(rA[i]);
            
            //EJERCICIOS B
            do{
                numB[i] = (int) Math.floor(Math.random()*((denB+denB)-1+1)+1);
            }while( repetido(numB, i) );
            //Etiquetas B
            eB[i] = new JTextArea("- \n"+denB);
            eB[i].setForeground(Color.WHITE);
            eB[i].setEditable(false);
            eB[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.04) ));
            eB[i].setOpaque(false);
            eB[i].setBounds((int)((px*0.04)+(numB[i]*(lineaB.getWidth()/(B.length-1)))),  (int)(py*0.57),  
                            (int)(px*0.05), (int)(py*0.1));
            fondo.add(eB[i]);
            //RESPUESTAS B
            rB[i] = new JTextArea((char)(65+i)+"");
            rB[i].setForeground(Color.YELLOW);
            rB[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.04) ));
            rB[i].setOpaque(false);
            rB[i].setBounds((int)((px*0.04)+(numB[i]*(lineaB.getWidth()/(B.length-1)))),      (int)((py*.54)),
                            (int)(px*0.05),      (int)(py*0.05));
            num2DIG(rB[i]);
            fondo.add(rB[i]);
        }

        
        JButton enviar = new JButton("ENVIAR");
        enviar.setForeground(Color.CYAN);
        enviar.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.02) ));
        enviar.setContentAreaFilled(false);
        enviar.setBounds((int)(px*0.91),(int)(py*0.91),(int)(px*0.08),(int)(py*0.05));
        fondo.add(enviar);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                if(enviar.getText().equals("ENVIAR")){
                    tiempoFin = System.nanoTime();
                    int calif=0;
                    for (int i = 0; i < 5; i++) {
                        if( rA[i].getText().equals(numA[i]+"") ){
                            rA[i].setEditable(false);
                            rA[i].setForeground(Color.green);
                            calif++;
                        }
                        if( rB[i].getText().equals(numB[i]+"") ){
                            rB[i].setEditable(false);
                            rB[i].setForeground(Color.green);
                            calif++;
                        }
                    }
                    //AQUI GUARDAMOS EL VALOR DE LA CALIFCICACION
                    mx.califCR[1]=calif;
                    //DAR MEDALLA O NO
                    for(int h=0;h<A.length;h++){
                        A[h].setVisible(false);
                    }
                    for(int h=0;h<B.length;h++){
                        B[h].setVisible(false);
                    }
                    for(int h=0;h<5;h++){
                        eA[h].setVisible(false);
                        rA[h].setVisible(false);
                        eB[h].setVisible(false);
                        rB[h].setVisible(false);
                    }
                    lineaA.setVisible(false);
                    lineaB.setVisible(false);
                    cero.setVisible(false);
                    uno.setVisible(false);
                    dos.setVisible(false);
                    ceros.setVisible(false);
                    unos.setVisible(false);
                    doss.setVisible(false);
                    if((mx.califCR[0]+mx.califCR[1])==20){
                        if((-(((tiempoInicio-tiempoFin)/1e6)/1000))<60 ){//MENOS DE 1 MIN
                            iniciaIntro(20);
                        }
                        if((-((((tiempoInicio-tiempoFin)/1e6)/1000))>=60) && ((-(((tiempoInicio-tiempoFin)/1e6)/1000))<120) ){
                            iniciaIntro(19);
                        }
                        if((-((((tiempoInicio-tiempoFin)/1e6)/1000))>=120) && ((-(((tiempoInicio-tiempoFin)/1e6)/1000))<=130)){
                            iniciaIntro(18);
                        }
                        if((-(((tiempoInicio-tiempoFin)/1e6)/1000))>130){
                            iniciaIntro(21);
                        }
                    }else{
                        iniciaIntro(21);
                    }
                    enviar.setText("CERRAR");
                    mx.cargarNiveles();
                    mx.mj = new MJs();
                    mx.mj.MJs(px, py, mx);              //BUG INMINENTE XD
                }
                else{
                    setVisible(false);
                    mx.m.setVisible(true);
                }
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };enviar.addActionListener(oyente);
    }
    
    public void M3CR1(){
        tiempoInicio = System.nanoTime();
        JLabel a[] = new JLabel[10];
        JLabel b[] = new JLabel[10];
        JTextArea[] R = new JTextArea[10];
        
        for (int i = 0; i < 10; i++) {
            //NUM A
            if( (int) Math.floor(Math.random()*(2-1+1)+1) == 1){
                int may = (int) Math.floor(Math.random()*(500-1+1)+1);
                a[i] = new JLabel(  may+"-"+ (int) Math.floor(Math.random()*(may-1+1)+1) );
            }
            else
                a[i] = new JLabel( (int) Math.floor(Math.random()*(500-1+1)+1) +"+"+ (int) Math.floor(Math.random()*(500-1+1)+1) );
            a[i].setForeground(Color.WHITE);
            a[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            a[i].setBounds((int)(px*0.2),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.3),      (int)(py*0.08));
            fondo.add(a[i]);
            //MUN B
            if( (int) Math.floor(Math.random()*(2-1+1)+1) == 1){
                int may = (int) Math.floor(Math.random()*(500-1+1)+1);
                b[i] = new JLabel(  may+"-"+ (int) Math.floor(Math.random()*(may-1+1)+1) );
            }
            else
                b[i] = new JLabel( (int) Math.floor(Math.random()*(500-1+1)+1) +"+"+ (int) Math.floor(Math.random()*(500-1+1)+1) );
            b[i].setForeground(Color.WHITE);
            b[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            b[i].setBounds((int)(px*0.6),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.3),      (int)(py*0.08));
            fondo.add(b[i]);
            //RESPUESTA
            R[i] = new JTextArea();
            R[i].setForeground(Color.YELLOW);
            R[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            R[i].setOpaque(false);
            R[i].setBounds((int)(px*0.475),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            sign(R[i]);
            fondo.add(R[i]);
        }
        
        JButton enviar = new JButton("SIGUIENTE");
        enviar.setForeground(Color.CYAN);
        enviar.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.02) ));
        enviar.setContentAreaFilled(false);
        enviar.setBounds((int)(px*0.91),(int)(py*0.91),(int)(px*0.08),(int)(py*0.05));
        fondo.add(enviar);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                    int calif=0;
                    for (int i = 0; i < 10; i++) {
                        String signo;
                        if ( operacion(a[i].getText()) > operacion(b[i].getText()) ) {//nums[i]*nums[i+10] == Integer.parseInt(R[i].getText()
                            signo=">";
                        }
                        else{
                            if( operacion(a[i].getText()) == operacion(b[i].getText()) ){
                                signo="=";
                            }
                            else{
                                signo="<";
                            }
                        }
                        //Comprobación de respuesta correcta
                        if(R[i].getText().equals(signo)){
                            R[i].setEditable(false);
                            R[i].setForeground(Color.GREEN);
                            calif++;
                        }
                    }
                    //AQUI GUARDAMOS EL VALOR DE LA CALIFCICACION
                    mx.califCR[0]=calif;
                    
                    //CAMBIAR A UN BOTON DE TERMINO DE JUEGO
                    mx.mj.fondo.removeAll();
                    mx.mj.setComponentes(2);
                    mx.m.v.getContentPane().add(mx.mj);
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };enviar.addActionListener(oyente);
    }
    
    public void M3CR2(){
        JLabel a[] = new JLabel[10];
        JLabel b[] = new JLabel[10];
        JTextArea[] R = new JTextArea[10];
        
        for (int i = 0; i < 10; i++) {
            //NUM A
            if( (int) Math.floor(Math.random()*(2-1+1)+1) == 1){
                int may = (int) Math.floor(Math.random()*(500-250+1)+250);
                a[i] = new JLabel(  may+"-"+ (int) Math.floor(Math.random()*(may-250+1)+250) );
            }
            else
                a[i] = new JLabel( (int) Math.floor(Math.random()*(500-250+1)+250) +"+"+ (int) Math.floor(Math.random()*(500-250+1)+250) );
            a[i].setForeground(Color.WHITE);
            a[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            a[i].setBounds((int)(px*0.2),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.3),      (int)(py*0.08));
            fondo.add(a[i]);
            //MUN B
            if( (int) Math.floor(Math.random()*(2-1+1)+1) == 1){
                int may = (int) Math.floor(Math.random()*(500-250+1)+250);
                b[i] = new JLabel(  may+"-"+ (int) Math.floor(Math.random()*(may-250+1)+250) );
            }
            else
                b[i] = new JLabel( (int) Math.floor(Math.random()*(500-250+1)+250) +"+"+ (int) Math.floor(Math.random()*(500-250+1)+250) );
            b[i].setForeground(Color.WHITE);
            b[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            b[i].setBounds((int)(px*0.6),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.3),      (int)(py*0.08));
            fondo.add(b[i]);
            //RESPUESTA
            R[i] = new JTextArea();
            R[i].setForeground(Color.YELLOW);
            R[i].setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.07) ));
            R[i].setOpaque(false);
            R[i].setBounds((int)(px*0.475),      (int)((py*0.1)+i*(py*0.08)),
                            (int)(px*0.1),      (int)(py*0.08));
            sign(R[i]);
            fondo.add(R[i]);
        }
        
        JButton enviar = new JButton("ENVIAR");
        enviar.setForeground(Color.CYAN);
        enviar.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(py*0.02) ));
        enviar.setContentAreaFilled(false);
        enviar.setBounds((int)(px*0.91),(int)(py*0.91),(int)(px*0.08),(int)(py*0.05));
        fondo.add(enviar);
        
        oyente = new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                if(enviar.getText().equals("ENVIAR")){
                    tiempoFin = System.nanoTime();
                    int calif=0;
                    for (int i = 0; i < 10; i++) {
                        String signo;
                        if ( operacion(a[i].getText()) > operacion(b[i].getText()) ) {//nums[i]*nums[i+10] == Integer.parseInt(R[i].getText()
                            signo=">";
                        }
                        else{
                            if( operacion(a[i].getText()) == operacion(b[i].getText()) ){
                                signo="=";
                            }
                            else{
                                signo="<";
                            }
                        }
                        //Comprobación de respuesta correcta
                        if(R[i].getText().equals(signo)){
                            R[i].setEditable(false);
                            R[i].setForeground(Color.GREEN);
                            calif++;
                        }
                    }
                    //AQUI GUARDAMOS EL VALOR DE LA CALIFCICACION
                    mx.califCR[1]=calif;
                    //DAR MEDALLA O NO
                    for(int h=0;h<10;h++){
                        a[h].setVisible(false);
                        b[h].setVisible(false);
                        R[h].setVisible(false);
                    }
                    if((mx.califCR[0]+mx.califCR[1])==20){
                        if((-(((tiempoInicio-tiempoFin)/1e6)/1000))<60 ){//MENOS DE 1 MIN
                            iniciaIntro(20);
                        }
                        if((-(((tiempoInicio-tiempoFin)/1e6)/1000))>=60 && ((-(((tiempoInicio-tiempoFin)/1e6)/1000))<120) ){//MENOS DE 120 s
                            iniciaIntro(19);
                        }
                        if((-(((tiempoInicio-tiempoFin)/1e6)/1000))>=120 && ((-(((tiempoInicio-tiempoFin)/1e6)/1000))<=130)){//MENOS DE 130 s
                            iniciaIntro(18);
                        }
                        if((-((((tiempoInicio-tiempoFin)/1e6)/1000))>130)){
                            iniciaIntro(21);
                        }
                    }else{
                        iniciaIntro(21);
                    }
                    enviar.setText("CERRAR");
                    mx.cargarNiveles();
                    mx.mj = new MJs();
                    mx.mj.MJs(px, py, mx);              //BUG INMINENTE XD
                }
                else{
                    setVisible(false);
                    mx.m.setVisible(true);
                }
            }catch(Exception e){
                System.out.println("Excepcion:"+e.getMessage());
            }
            }
        };enviar.addActionListener(oyente);
    }
}