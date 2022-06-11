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
public class Reglas extends JPanel{
    JLabel prin = new JLabel();
    Ventana v;
    int px, py;
    Border prueba = BorderFactory.createLineBorder(Color.black);
    Stack<String> guion = new Stack<String>();
    JLabel nino=new JLabel(), nina=new JLabel(), ins=new JLabel();
    JTextArea texto = new JTextArea();
    int c=0;
    LineBorder bor = new LineBorder(Color.CYAN, 5, true);
    
    public void RulesAndChs(){setLayout(null);}
    
    public void Componentes(int px, int py, Ventana v){
        this.px=px; this.py=py; this.v=v;
        prin.setBounds(0,0,px,py); add(prin);
        cargaFondo();
        guion.push("\n\n¡Hola!, me llamo Quetzalli, mi nombre\nsignifica \"pluma brillante\" o también\n                \"mujer hermosa\".");
        guion.push("\n\n¡Hola!, me llamo Suré, mi nombre significa\n   \"aquel que tiene corazón\" o también\n                   \"persona amable\".");
        guion.push("\n\n   Ambos seremos tus guías durante tu\naventura para aprender las asombrosas\n                     Matemáticas.");
        guion.push("Primero debemos conocer las reglas de este\njuego:");
        guion.push("\n1.- Cada que inicies un nivel, debes terminarlo,\ny guardar tu progreso de otro modo, ¡tu \navance se perderá!\n");
        guion.push("2.- Para desbloquear el siguiente nivel, debes\naprobar el nivel anterior con el mínimo de\npuntaje.\n");
        guion.push("3.- Puedes repasar niveles anteriores, pero tu\n  puntuación no se modificará a menos que sea\n    mejor que la puntuación que tenías antes.\n");
        guion.push("\n4.- Puedes pedir ayuda a algún adulto si es\n necesario, o también a nosotros, tus guías, en\n   caso de que se te dificulte algún ejercicio.\n");
        guion.push("\n\n              Tendrás dos modos de juego:\n\n                  Aventura y Contra Reloj");
        guion.push("\n                             Aventura\n\n           Pasarás por distintas estaciones.\n                Se te explicará la teoría y\n        la forma de resolver los minijuegos.");
        guion.push("\n                           Contra Reloj\n\n           Resolverás los mismos ejercicios\n                   que en modo Aventura\n             pero esta vez más complicados.");
        guion.push("\n                           Contra Reloj\n\n                       Para pasar de nivel\n          deberás responder correctamente\n                    TODOS los ejercicios\n                en el menor tiempo posible.");
        guion.push("\n                           Contra Reloj\n\n             Cada mundo tendra diferentes\n                          tiempos a batir:");
        guion.push("\n                           Contra Reloj\n\n          Mundo 1: 480, 420 y 360 segundos.\n           Mundo 2: 130, 120 y 60 segundos.\n           Mundo 3: 130, 120 y 60 segundos.");
        guion.push("\n                   Aventura y Contra Reloj\n\n                   Si ganas en los mundos,\n                      serás recompensado.");
        guion.push("\n\nUna vez dicho esto, sin más preámbulo,\n           ¡comencemos con el juego!");

        cargaElementos();
    }
    public void cargaFondo(){
        ImageIcon fondo = new ImageIcon("Mundos\\Mundos.jpeg");
        Icon icono = new ImageIcon(fondo.getImage().getScaledInstance(prin.getWidth(),prin.getHeight(),Image.SCALE_DEFAULT));
        prin.setIcon(icono);
        prin.repaint();
    }
    
    public void cargaElementos(){
        //IMAGENES DE CHS
        prin.add(nina); prin.add(nino);
        nina.setBounds((int)(px*0.775), (int)(py*0.11), (int)(px*0.21), (int)(py*0.8));
        nino.setBounds((int)(px*0.025), (int)(py*0.11), (int)(px*0.2), (int)(py*0.8));
        //nina.setBorder(prueba); nino.setBorder(prueba);
        ImageIcon inina = new ImageIcon("Personajes\\1 cc.png"), inino = new ImageIcon("Personajes\\2 aa.png");
        Icon iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
        Icon iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
        nina.setIcon(iconoA);
        nino.setIcon(iconoB);
        
        //AREA DE TEXTO
        JPanel txt = new JPanel();
        txt.setBorder(bor);
        txt.setBackground(new Color(59,131,189));
        txt.setBounds((int)(px*0.3), (int)(py*0.3), (int)(px*0.4), (int)(py*0.4));
        txt.setLayout(null);
        texto.setBounds((int)(txt.getWidth()*0.01),(int)(txt.getHeight()*0.02), (int)(txt.getWidth()*0.98), (int)(txt.getHeight()*0.97));
        //texto.setBorder(prueba);
        texto.setEditable(false);
        texto.setOpaque(false);
        texto.setFont(new Font("Comic Sans MS", Font.PLAIN,(int)(txt.getHeight()*0.104)));
        texto.setText(guion.get(0));
        texto.setForeground(Color.WHITE);
        txt.add(texto);
        
        //INSTRUCCION PARA AVANZAR
        JLabel insclic = new JLabel("<¡Clic en el AQUÍ para avanzar!>",SwingConstants.CENTER);
        insclic.setLayout(null);
        insclic.setForeground(Color.WHITE);
        insclic.setBounds((int)(px*0.4), (int)(py*0.71), (int)(px*0.2), (int)(py*0.05));
        insclic.setFont(new Font("Comic Sans MS", Font.PLAIN,(int)(insclic.getHeight()*0.45)));
        insclic.setBorder(bor);
        insclic.setBackground(new Color(59,131,189));
        insclic.setOpaque(true);
        prin.add(insclic);
        
        insclic.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                switch(c){
                    case 0: 
                        ImageIcon inina = new ImageIcon("Personajes\\1 aa.png"), inino = new ImageIcon("Personajes\\2 ac.png");
                        Icon iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                        Icon iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                        nina.setIcon(iconoA);
                        nino.setIcon(iconoB);
                        texto.setFont(new Font("Comic Sans MS", Font.PLAIN,(int)(txt.getHeight()*0.091)));
                        texto.setText(guion.get(1));
                        c++;
                        break;
                    case 1: 
                        inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                        iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                        iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                        nina.setIcon(iconoA);
                        nino.setIcon(iconoB);
                        texto.setFont(new Font("Comic Sans MS", Font.PLAIN,(int)(txt.getHeight()*0.095)));
                        texto.setText(guion.get(2));
                        c++;
                        break;
                    case 2: 
                        inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 cc.png");
                        iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                        iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                        nina.setIcon(iconoA);
                        nino.setIcon(iconoB);
                        texto.setFont(new Font("Comic Sans MS", Font.PLAIN,(int)(txt.getHeight()*0.0825)));
                        texto.setText(guion.get(3));
                        c++;
                        break;
                    case 3: 
                        inina = new ImageIcon("Personajes\\1 cc.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                        iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                        iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                        nina.setIcon(iconoA);
                        nino.setIcon(iconoB);
                        texto.setText(guion.get(3)+guion.get(4));
                        c++;
                        break;
                    case 4: 
                        inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                        iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                        iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                        nina.setIcon(iconoA);
                        nino.setIcon(iconoB);
                        texto.setText(guion.get(3)+guion.get(4)+guion.get(5));
                        c++;
                        break;
                    case 5:
                        inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                        iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                        iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                        nina.setIcon(iconoA);
                        nino.setIcon(iconoB);
                        texto.setText(guion.get(6));
                        c++;
                        break;
                    case 6: inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                        iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                        iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                        nina.setIcon(iconoA);
                        nino.setIcon(iconoB);
                        texto.setText(guion.get(6)+guion.get(7));
                        c++;
                        break;
                    case 7: inina = new ImageIcon("Personajes\\1 cc.png"); inino = new ImageIcon("Personajes\\2 ca.png");
                        iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                        iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                        nina.setIcon(iconoA);
                        nino.setIcon(iconoB);
                        texto.setText(guion.get(8));
                        c++;
                        break;
                    case 8: inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                        iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                        iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                        nina.setIcon(iconoA);
                        nino.setIcon(iconoB);
                        texto.setText(guion.get(9));
                        c++;
                        break;
                    case 9: inina = new ImageIcon("Personajes\\1 cc.png"); inino = new ImageIcon("Personajes\\2 ca.png");
                        iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                        iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                        nina.setIcon(iconoA);
                        nino.setIcon(iconoB);
                        texto.setText(guion.get(10));
                        c++;
                        break;
                    case 10: inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                        iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                        iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                        nina.setIcon(iconoA);
                        nino.setIcon(iconoB);
                        texto.setText(guion.get(11));
                        c++;
                        break;
                    case 11: inina = new ImageIcon("Personajes\\1 cc.png"); inino = new ImageIcon("Personajes\\2 ca.png");
                        iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                        iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                        nina.setIcon(iconoA);
                        nino.setIcon(iconoB);
                        texto.setText(guion.get(12));
                        c++;
                        break;
                    case 12: inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 ac.png");
                        iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                        iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                        nina.setIcon(iconoA);
                        nino.setIcon(iconoB);
                        texto.setText(guion.get(13));
                        c++;
                        break;
                    case 13: inina = new ImageIcon("Personajes\\1 cc.png"); inino = new ImageIcon("Personajes\\2 ca.png");
                        iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                        iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                        nina.setIcon(iconoA);
                        nino.setIcon(iconoB);
                        texto.setText(guion.get(14));
                        c++;
                        break;
                    case 14: inina = new ImageIcon("Personajes\\1 aa.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                        iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                        iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                        nina.setIcon(iconoA);
                        nino.setIcon(iconoB);
                        texto.setFont(new Font("Comic Sans MS", Font.PLAIN,(int)(txt.getHeight()*0.1)));
                        texto.setText(guion.get(15));
                        insclic.setText("<¡Clic en el AQUÍ para iniciar!>");
                        c++;
                        break;
                    case 15: 
                        setVisible(false);
                        v.perfiles.setVisible(true);
                        v.getContentPane().add(v.perfiles);
                        break;
                }
            }
        });
        prin.add(txt);
    }
}
