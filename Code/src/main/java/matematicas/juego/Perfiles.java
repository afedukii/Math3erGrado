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
public class Perfiles extends JPanel{
    JLabel prin = new JLabel();
    Ventana v;
    JLabel profiles = new JLabel("SELECCIÓN DE PERFILES",SwingConstants.CENTER);
    JLabel p1 = new JLabel("VACIO"), p2 = new JLabel("VACIO"), p3 = new JLabel("VACIO");   
    JLabel p4 = new JLabel("VACIO"), p5 = new JLabel("VACIO");
    JLabel medallas[] = new JLabel[30];
    JLabel left = new JLabel("<",SwingConstants.CENTER),right = new JLabel(">",SwingConstants.CENTER), ayuda = new JLabel("?",SwingConstants.CENTER);
    JLabel ng = new JLabel("+",SwingConstants.CENTER);
    JTextArea txtAyuda = new JTextArea();
    JPanel panel1 = new JPanel(), panel2 = new JPanel(), panel3 = new JPanel();
    JPanel panel4 = new JPanel(), panel5 = new JPanel();
    JPanel panelAyuda = new JPanel(); JPanel inName = new JPanel();
    JLabel nina = new JLabel(); JLabel nino = new JLabel();
    JLabel b1 = new JLabel(""), b2 = new JLabel(""), b3 = new JLabel("");   
    JLabel b4 = new JLabel(""), b5 = new JLabel("");
    JLabel insclic = new JLabel("<¡Clic en el AQUÍ para avanzar!>",SwingConstants.CENTER);
    JLabel crear = new JLabel("CREAR",SwingConstants.CENTER);
    JTextField inputName = new JTextField();
    Border prueba = BorderFactory.createLineBorder(Color.black);
    LineBorder bor = new LineBorder(Color.CYAN, 5, true);
    Stack<String> data = new Stack<String>();
    public String vacioD="VACIO,0,0,0,0,0,0";
    public int [] banderasP = new int[5];
    public String [][] paginas;
    public int entero, residuo,tpags,pagActual;
    public int px,py,tm,c=0;
    
    
    /*Stack de nombres, Stack de medallas (6 Stacks o 1 Stack)*/
    
    public void Perfiles(){setLayout(null);}
    public void Componentes(int width, int height,Ventana v){
        prin.setBounds(0, 0, width,height);
        add(prin);
        this.px=width; this.py=height;
        this.v = v;
        for(int i=0;i<30;i++)
            medallas[i]=new JLabel();
        perfiles();
        leerDatos();
    }
    public void leerDatos(){
        try{
            File ar = new File("data.txt");
            FileReader fr = new FileReader(ar);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while( (linea=br.readLine()) != null )
                data.push(linea);
            br.close();
        }catch(Exception e){;};
        cargaDatosAPantalla();
        if(tpags==1){right.setEnabled(false);left.setEnabled(false);}
    }
    public void cargaDatosAPantalla(){
        if(data.size()>5){right.setEnabled(true);}else{right.setEnabled(false);}
        entero = (data.size())/5;
        residuo = data.size()%5;
        tpags = entero;
        if(residuo == 0){paginas = new String[5][tpags];}
        else{tpags++;paginas = new String[5][tpags];}
        int lim = data.size(),c=0;
        paginas[0][0]="vacio";
        for(int j=0;j<tpags;j++){
            for(int i=0;i<5;i++){
                paginas[i][j]="vacio";
            }
        }
        for(int j=0;j<tpags;j++){//columnas == cantidad de paginas
            if(residuo != 0 && j==(tpags-1)){
                for(int i=0; i<residuo;i++){
                    paginas[i][j] = data.get(c);
                    c++;
                }
            }else{
                paginas[0][j] = data.get(c);
                paginas[1][j] = data.get(c+1);
                paginas[2][j] = data.get(c+2);
                paginas[3][j] = data.get(c+3);
                paginas[4][j] = data.get(c+4);
            }
            c+=5;
        }
        cargaPag(0);
        left.setEnabled(false);
        right.setEnabled(true);
        //modifica
    }
    public void cargaPag(int p){
        pagActual = p;
        String [] cad;
        for(int i=0;i<5;i++){
            cad = paginas[i][p].split(",");
            switch(i){
                case 0:
                    if(!paginas[i][p].equals("vacio")){
                        p1.setText(cad[0]);
                        modificaMedallas(cad,i);
                    }else{
                        b1.setEnabled(false);
                        p1.setText("VACIO");
                        cad = vacioD.split(",");
                        modificaMedallas(cad,i);
                    }
                break;
                case 1:
                    if(!paginas[i][p].equals("vacio")){
                        p2.setText(cad[0]);
                        modificaMedallas(cad,i);
                    }else{
                        b2.setEnabled(false);
                        p2.setText("VACIO");
                        cad = vacioD.split(",");
                        modificaMedallas(cad,i);
                    }
                break;
                case 2:
                    if(!paginas[i][p].equals("vacio")){
                        p3.setText(cad[0]);
                        modificaMedallas(cad,i);
                    }else{
                        b3.setEnabled(false);
                        p3.setText("VACIO");
                        cad = vacioD.split(",");
                        modificaMedallas(cad,i);
                    }
                break;
                case 3:
                    if(!paginas[i][p].equals("vacio")){
                        p4.setText(cad[0]);
                        modificaMedallas(cad,i);
                    }else{
                        b4.setEnabled(false);
                        p4.setText("VACIO");
                        cad = vacioD.split(",");
                        modificaMedallas(cad,i);
                    }
                break;
                case 4:
                    if(!paginas[i][p].equals("vacio")){
                        p5.setText(cad[0]);
                        modificaMedallas(cad,i);
                    }else{
                        b5.setEnabled(false);
                        p5.setText("VACIO");
                        cad = vacioD.split(",");
                        modificaMedallas(cad,i);
                    }
                break;
            }
        }
    }
    public void modificaMedallas(String [] cad,int i){
        ImageIcon [] meds = new ImageIcon[7];
        meds[0] = new ImageIcon("Medallas\\AP1.png");
        meds[1] = new ImageIcon("Medallas\\AP2.png");
        meds[2] = new ImageIcon("Medallas\\AP3.png");
        meds[3] = new ImageIcon("Medallas\\CR1.png");
        meds[4] = new ImageIcon("Medallas\\CR2.png");
        meds[5] = new ImageIcon("Medallas\\CR3.png");
        meds[6] = new ImageIcon("Medallas\\nani.png");
        
        switch(i){
            case 0:
                if(!cad[1].equals("0")){
                    if(cad[1].equals("1")){
                        Icon f = new ImageIcon(meds[0].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[0].setIcon(f);
                    }
                    if(cad[1].equals("2")){
                        Icon f = new ImageIcon(meds[1].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[0].setIcon(f);
                    }
                    if(cad[1].equals("3")){
                        Icon f = new ImageIcon(meds[2].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[0].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[0].setIcon(f);
                }
                if(!cad[2].equals("0")){
                    if(cad[2].equals("1")){
                        Icon f = new ImageIcon(meds[0].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[1].setIcon(f);
                    }
                    if(cad[2].equals("2")){
                        Icon f = new ImageIcon(meds[1].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[1].setIcon(f);
                    }
                    if(cad[2].equals("3")){
                        Icon f = new ImageIcon(meds[2].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[1].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[1].setIcon(f);
                }
                if(!cad[3].equals("0")){
                    if(cad[3].equals("1")){
                        Icon f = new ImageIcon(meds[0].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[2].setIcon(f);
                    }
                    if(cad[3].equals("2")){
                        Icon f = new ImageIcon(meds[1].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[2].setIcon(f);
                    }
                    if(cad[3].equals("3")){
                        Icon f = new ImageIcon(meds[2].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[2].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[2].setIcon(f);
                }
                if(!cad[4].equals("0")){
                    if(cad[4].equals("1")){
                        Icon f = new ImageIcon(meds[3].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[3].setIcon(f);
                    }
                    if(cad[4].equals("2")){
                        Icon f = new ImageIcon(meds[4].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[3].setIcon(f);
                    }
                    if(cad[4].equals("3")){
                        Icon f = new ImageIcon(meds[5].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[3].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[3].setIcon(f);
                }
                if(!cad[5].equals("0")){
                    if(cad[5].equals("1")){
                        Icon f = new ImageIcon(meds[3].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[4].setIcon(f);
                    }
                    if(cad[5].equals("2")){
                        Icon f = new ImageIcon(meds[4].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[4].setIcon(f);
                    }
                    if(cad[5].equals("3")){
                        Icon f = new ImageIcon(meds[5].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[4].setIcon(f);
                    }
                }else{
                Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[4].setIcon(f);
                }
                if(!cad[6].equals("0")){
                    if(cad[6].equals("1")){
                        Icon f = new ImageIcon(meds[3].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[5].setIcon(f);
                   }
                    if(cad[6].equals("2")){
                        Icon f = new ImageIcon(meds[4].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[5].setIcon(f);
                    }
                    if(cad[6].equals("3")){
                        Icon f = new ImageIcon(meds[5].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[5].setIcon(f);
                    }
                }else{
                Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[5].setIcon(f);
                }
            break;
            case 1:
                if(!cad[1].equals("0")){
                    if(cad[1].equals("1")){
                        Icon f = new ImageIcon(meds[0].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[6].setIcon(f);
                    }
                    if(cad[1].equals("2")){
                        Icon f = new ImageIcon(meds[1].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[6].setIcon(f);
                    }
                    if(cad[1].equals("3")){
                        Icon f = new ImageIcon(meds[2].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[6].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[6].setIcon(f);
                }
                if(!cad[2].equals("0")){
                    if(cad[2].equals("1")){
                        Icon f = new ImageIcon(meds[0].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[7].setIcon(f);
                    }
                    if(cad[2].equals("2")){
                        Icon f = new ImageIcon(meds[1].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[7].setIcon(f);
                    }
                    if(cad[2].equals("3")){
                        Icon f = new ImageIcon(meds[2].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[7].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[7].setIcon(f);
                }
                if(!cad[3].equals("0")){
                    if(cad[3].equals("1")){
                        Icon f = new ImageIcon(meds[0].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[8].setIcon(f);
                    }
                    if(cad[3].equals("2")){
                        Icon f = new ImageIcon(meds[1].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[8].setIcon(f);
                    }
                    if(cad[3].equals("3")){
                        Icon f = new ImageIcon(meds[2].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[8].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[8].setIcon(f);
                }
                if(!cad[4].equals("0")){
                    if(cad[4].equals("1")){
                        Icon f = new ImageIcon(meds[3].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[9].setIcon(f);
                    }
                    if(cad[4].equals("2")){
                        Icon f = new ImageIcon(meds[4].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[9].setIcon(f);
                    }
                    if(cad[4].equals("3")){
                        Icon f = new ImageIcon(meds[5].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[9].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[9].setIcon(f);
                }
                if(!cad[5].equals("0")){
                    if(cad[5].equals("1")){
                        Icon f = new ImageIcon(meds[3].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[10].setIcon(f);
                    }
                    if(cad[5].equals("2")){
                        Icon f = new ImageIcon(meds[4].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[10].setIcon(f);
                    }
                    if(cad[5].equals("3")){
                        Icon f = new ImageIcon(meds[5].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[10].setIcon(f);
                    }
                }else{
                Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[10].setIcon(f);
                }
                if(!cad[6].equals("0")){
                    if(cad[6].equals("1")){
                        Icon f = new ImageIcon(meds[3].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[11].setIcon(f);
                   }
                    if(cad[6].equals("2")){
                        Icon f = new ImageIcon(meds[4].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[11].setIcon(f);
                    }
                    if(cad[6].equals("3")){
                        Icon f = new ImageIcon(meds[5].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[11].setIcon(f);
                    }
                }else{
                Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[11].setIcon(f);
                }
            break;
            case 2:
                if(!cad[1].equals("0")){
                    if(cad[1].equals("1")){
                        Icon f = new ImageIcon(meds[0].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[12].setIcon(f);
                    }
                    if(cad[1].equals("2")){
                        Icon f = new ImageIcon(meds[1].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[12].setIcon(f);
                    }
                    if(cad[1].equals("3")){
                        Icon f = new ImageIcon(meds[2].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[12].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[12].setIcon(f);
                }
                if(!cad[2].equals("0")){
                    if(cad[2].equals("1")){
                        Icon f = new ImageIcon(meds[0].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[13].setIcon(f);
                    }
                    if(cad[2].equals("2")){
                        Icon f = new ImageIcon(meds[1].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[13].setIcon(f);
                    }
                    if(cad[2].equals("3")){
                        Icon f = new ImageIcon(meds[2].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[13].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[13].setIcon(f);
                }
                if(!cad[3].equals("0")){
                    if(cad[3].equals("1")){
                        Icon f = new ImageIcon(meds[0].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[14].setIcon(f);
                    }
                    if(cad[3].equals("2")){
                        Icon f = new ImageIcon(meds[1].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[14].setIcon(f);
                    }
                    if(cad[3].equals("3")){
                        Icon f = new ImageIcon(meds[2].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[14].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[14].setIcon(f);
                }
                if(!cad[4].equals("0")){
                    if(cad[4].equals("1")){
                        Icon f = new ImageIcon(meds[3].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[15].setIcon(f);
                    }
                    if(cad[4].equals("2")){
                        Icon f = new ImageIcon(meds[4].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[15].setIcon(f);
                    }
                    if(cad[4].equals("3")){
                        Icon f = new ImageIcon(meds[5].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[15].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[15].setIcon(f);
                }
                if(!cad[5].equals("0")){
                    if(cad[5].equals("1")){
                        Icon f = new ImageIcon(meds[3].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[16].setIcon(f);
                    }
                    if(cad[5].equals("2")){
                        Icon f = new ImageIcon(meds[4].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[16].setIcon(f);
                    }
                    if(cad[5].equals("3")){
                        Icon f = new ImageIcon(meds[5].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[16].setIcon(f);
                    }
                }else{
                Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[16].setIcon(f);
                }
                if(!cad[6].equals("0")){
                    if(cad[6].equals("1")){
                        Icon f = new ImageIcon(meds[3].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[17].setIcon(f);
                   }
                    if(cad[6].equals("2")){
                        Icon f = new ImageIcon(meds[4].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[17].setIcon(f);
                    }
                    if(cad[6].equals("3")){
                        Icon f = new ImageIcon(meds[5].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[17].setIcon(f);
                    }
                }else{
                Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[17].setIcon(f);
                }
            break;
            case 3:
                if(!cad[1].equals("0")){
                    if(cad[1].equals("1")){
                        Icon f = new ImageIcon(meds[0].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[18].setIcon(f);
                    }
                    if(cad[1].equals("2")){
                        Icon f = new ImageIcon(meds[1].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[18].setIcon(f);
                    }
                    if(cad[1].equals("3")){
                        Icon f = new ImageIcon(meds[2].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[18].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[18].setIcon(f);
                }
                if(!cad[2].equals("0")){
                    if(cad[2].equals("1")){
                        Icon f = new ImageIcon(meds[0].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[19].setIcon(f);
                    }
                    if(cad[2].equals("2")){
                        Icon f = new ImageIcon(meds[1].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[19].setIcon(f);
                    }
                    if(cad[2].equals("3")){
                        Icon f = new ImageIcon(meds[2].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[19].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[19].setIcon(f);
                }
                if(!cad[3].equals("0")){
                    if(cad[3].equals("1")){
                        Icon f = new ImageIcon(meds[0].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[20].setIcon(f);
                    }
                    if(cad[3].equals("2")){
                        Icon f = new ImageIcon(meds[1].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[20].setIcon(f);
                    }
                    if(cad[3].equals("3")){
                        Icon f = new ImageIcon(meds[2].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[20].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[20].setIcon(f);
                }
                if(!cad[4].equals("0")){
                    if(cad[4].equals("1")){
                        Icon f = new ImageIcon(meds[3].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[21].setIcon(f);
                    }
                    if(cad[4].equals("2")){
                        Icon f = new ImageIcon(meds[4].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[21].setIcon(f);
                    }
                    if(cad[4].equals("3")){
                        Icon f = new ImageIcon(meds[5].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[21].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[21].setIcon(f);
                }
                if(!cad[5].equals("0")){
                    if(cad[5].equals("1")){
                        Icon f = new ImageIcon(meds[3].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[22].setIcon(f);
                    }
                    if(cad[5].equals("2")){
                        Icon f = new ImageIcon(meds[4].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[22].setIcon(f);
                    }
                    if(cad[5].equals("3")){
                        Icon f = new ImageIcon(meds[5].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[22].setIcon(f);
                    }
                }else{
                Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[22].setIcon(f);
                }
                if(!cad[6].equals("0")){
                    if(cad[6].equals("1")){
                        Icon f = new ImageIcon(meds[3].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[23].setIcon(f);
                   }
                    if(cad[6].equals("2")){
                        Icon f = new ImageIcon(meds[4].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[23].setIcon(f);
                    }
                    if(cad[6].equals("3")){
                        Icon f = new ImageIcon(meds[5].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[23].setIcon(f);
                    }
                }else{
                Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[23].setIcon(f);
                }
            break;
            case 4:
                if(!cad[1].equals("0")){
                    if(cad[1].equals("1")){
                        Icon f = new ImageIcon(meds[0].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[24].setIcon(f);
                    }
                    if(cad[1].equals("2")){
                        Icon f = new ImageIcon(meds[1].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[24].setIcon(f);
                    }
                    if(cad[1].equals("3")){
                        Icon f = new ImageIcon(meds[2].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[24].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[24].setIcon(f);
                }
                if(!cad[2].equals("0")){
                    if(cad[2].equals("1")){
                        Icon f = new ImageIcon(meds[0].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[25].setIcon(f);
                    }
                    if(cad[2].equals("2")){
                        Icon f = new ImageIcon(meds[1].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[25].setIcon(f);
                    }
                    if(cad[2].equals("3")){
                        Icon f = new ImageIcon(meds[2].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[25].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[25].setIcon(f);
                }
                if(!cad[3].equals("0")){
                    if(cad[3].equals("1")){
                        Icon f = new ImageIcon(meds[0].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[26].setIcon(f);
                    }
                    if(cad[3].equals("2")){
                        Icon f = new ImageIcon(meds[1].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[26].setIcon(f);
                    }
                    if(cad[3].equals("3")){
                        Icon f = new ImageIcon(meds[2].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[26].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[26].setIcon(f);
                }
                if(!cad[4].equals("0")){
                    if(cad[4].equals("1")){
                        Icon f = new ImageIcon(meds[3].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[27].setIcon(f);
                    }
                    if(cad[4].equals("2")){
                        Icon f = new ImageIcon(meds[4].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[27].setIcon(f);
                    }
                    if(cad[4].equals("3")){
                        Icon f = new ImageIcon(meds[5].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                        medallas[27].setIcon(f);
                    }
                }else{
                    Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[27].setIcon(f);
                }
                if(!cad[5].equals("0")){
                    if(cad[5].equals("1")){
                        Icon f = new ImageIcon(meds[3].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[28].setIcon(f);
                    }
                    if(cad[5].equals("2")){
                        Icon f = new ImageIcon(meds[4].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[28].setIcon(f);
                    }
                    if(cad[5].equals("3")){
                        Icon f = new ImageIcon(meds[5].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[28].setIcon(f);
                    }
                }else{
                Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[28].setIcon(f);
                }
                if(!cad[6].equals("0")){
                    if(cad[6].equals("1")){
                        Icon f = new ImageIcon(meds[3].getImage().getScaledInstance((tm),tm,Image.SCALE_DEFAULT));
                    medallas[29].setIcon(f);
                   }
                    if(cad[6].equals("2")){
                        Icon f = new ImageIcon(meds[4].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[29].setIcon(f);
                    }
                    if(cad[6].equals("3")){
                        Icon f = new ImageIcon(meds[5].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[29].setIcon(f);
                    }
                }else{
                Icon f = new ImageIcon(meds[6].getImage().getScaledInstance(tm,tm,Image.SCALE_DEFAULT));
                    medallas[29].setIcon(f);
                }
            break;
        }
    }
    public void perfiles(){
        ImageIcon fondo = new ImageIcon("Mundos\\Mundos.jpeg");
        Icon icono = new ImageIcon(fondo.getImage().getScaledInstance(prin.getWidth(),prin.getHeight(),Image.SCALE_DEFAULT));
        prin.setIcon(icono);
        prin.repaint();
        tituloPantalla();
        paneles();
        //botonesControl();
    }
    public void tituloPantalla(){
        //profiles.setBorder(prueba);
        profiles.setBounds((int)(px*0.3),(int)(py*0.02), (int)(px*0.4),(int)(py*0.08));
        profiles.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(profiles.getHeight()*0.5) ));
        profiles.setForeground(Color.white);
        prin.add(profiles);
    }
    public void paneles(){
        iniciaPaneles();
        iniciaDefault();
    }
    public void iniciaDefault(){
        p1.setText("VACIO");p2.setText("VACIO");p3.setText("VACIO");
        p4.setText("VACIO");p5.setText("VACIO");
        panelAyuda.setVisible(false); inName.setVisible(false);
        nino.setVisible(false); nina.setVisible(false);
    }
    public void iniciaPaneles(){
        panel1.setBounds((int)(px*0.3), (int)(py*0.15), (int)(px*0.4), (int)(py*0.13));
        panel1.setBackground(new Color(59,131,185));
        
        panel2.setBounds((int)(px*0.3), (int)(py*0.3), (int)(px*0.4), (int)(py*0.13));
        panel2.setBackground(new Color(59,131,185));
        
        panel3.setBounds((int)(px*0.3), (int)(py*0.45), (int)(px*0.4), (int)(py*0.13));
        panel3.setBackground(new Color(59,131,185));
        
        panel4.setBounds((int)(px*0.3), (int)(py*0.6), (int)(px*0.4), (int)(py*0.13));
        panel4.setBackground(new Color(59,131,185));
        
        panel5.setBounds((int)(px*0.3), (int)(py*0.75), (int)(px*0.4), (int)(py*0.13));
        panel5.setBackground(new Color(59,131,185));
        
        tm = (int)(panel1.getHeight()*0.4);
        elementosDePaneles();
        //               (horizontal)(vertical)
        //panel de texto de ayuda/instrucciones
        panelAyuda.setLayout(null);
        panelAyuda.add(txtAyuda);
        panelAyuda.setBounds((int)(px*0.3), (int)(py*0.3), (int)(px*0.4), (int)(py*0.4));
        
        txtAyuda.setBounds((int)(panelAyuda.getWidth()*0.01),(int)(panelAyuda.getHeight()*0.02), (int)(panelAyuda.getWidth()*0.98), (int)(panelAyuda.getHeight()*0.97));
        txtAyuda.setFont(new Font("Comic Sans MS", Font.BOLD, (int)(txtAyuda.getHeight()*0.104) ));
        txtAyuda.setOpaque(false);
        txtAyuda.setEditable(false);
        String textoAyuda = "Quetzalli: Para cargar tu partida, haz clic en cualquier\nparte donde veas tu nombre."+
                            "\n\nAzcoat: Si no ves tu nombre, puede que no se encuentre\nen ésta página, intenta moverte con las flechas que hay\ndebajo."+
                            "\n\nQuetzalli: Si eres nuevo, haz clic en el botón que dice:\n                 >>>NG<<< (NUEVO JUGADOR)";
        
        insclic.setLayout(null);
        insclic.setForeground(Color.WHITE);
        insclic.setBounds((int)(px*0.4), (int)(py*0.71), (int)(px*0.2), (int)(py*0.05));
        insclic.setFont(new Font("Comic Sans MS", Font.PLAIN,(int)(insclic.getHeight()*0.45)));
        insclic.setBorder(bor);
        insclic.setBackground(new Color(59,131,189));
        insclic.setOpaque(true);
        insclic.setVisible(false);
        prin.add(insclic);
        
        
        prin.add(panelAyuda);
        
        panelAyuda.setBackground(Color.CYAN);
        panelAyuda.setBorder(new LineBorder(new Color(59,131,185),5,true));
        
        //panel de creacion de nuevo perfil
        inName.setLayout(null);
        inName.setBounds((int)(px*0.3), (int)(py*0.3), (int)(px*0.4), (int)(py*0.2));
        inName.setBackground(Color.CYAN);
        inName.setBorder(new LineBorder(new Color(59,131,185),5,true));
        JLabel tname = new JLabel("INGRESE NOMBRE:",SwingConstants.CENTER); 
        inName.add(tname); inName.add(inputName); inName.add(crear);
        tname.setBounds((int)(inName.getWidth()*0.3), (int)(inName.getHeight()*0.05), (int)(inName.getWidth()*0.4), (int)(inName.getHeight()*0.3));
        tname.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(tname.getHeight()*0.45)));
        inputName.setBounds((int)(inName.getWidth()*0.2), (int)(inName.getHeight()*0.45), (int)(inName.getWidth()*0.6), (int)(inName.getHeight()*0.2));
        crear.setBounds((int)(inName.getWidth()*0.35), (int)(inName.getHeight()*0.75), (int)(inName.getWidth()*0.3), (int)(inName.getHeight()*0.15));
        crear.setFont(new Font("Comic Sans MS", Font.BOLD,(int)(crear.getHeight()*0.45))); 
        crear.setBackground(new Color(59,131,189));
        crear.setBorder(new LineBorder(new Color(59,131,185),5,true));
        
        prin.add(inName);
        
        acciones();
        
        prin.add(panel1);   prin.add(panel2);
        prin.add(panel3);   prin.add(panel4);
        prin.add(panel5);
        
        botonesControl();
        
        //panel de personaje
        prin.add(nina); prin.add(nino);
        nina.setBounds((int)(px*0.775), (int)(py*0.11), (int)(px*0.21), (int)(py*0.8));
        nino.setBounds((int)(px*0.025), (int)(py*0.11), (int)(px*0.2), (int)(py*0.8));
        //nina.setBorder(prueba); nino.setBorder(prueba);
        //Asignar fotos de nino y nina
        ImageIcon inina = new ImageIcon("Personajes\\1 aa.png"), inino = new ImageIcon("Personajes\\2 aa.png");
        Icon iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
        Icon iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
        nina.setIcon(iconoA);
        nino.setIcon(iconoB);
    }
    public void elementosDePaneles(){
        panel1.setLayout(null); panel2.setLayout(null); panel3.setLayout(null);
        panel4.setLayout(null); panel5.setLayout(null);
        
        panel1.add(p1); panel2.add(p2); panel3.add(p3);
        panel4.add(p4); panel5.add(p5);
        panel1.setBorder(bor);panel2.setBorder(bor);panel3.setBorder(bor);
        panel4.setBorder(bor);panel5.setBorder(bor);
        //medallas panel 1, pos[0..5]  //medallas panel 2, pos[6..11]
        //medallas panel 3, pos[12..17]//medallas panel 4, pos[18..23]
        //medallas panel 5, pos[24..29]
        for(int i=0;i<6;i++){panel1.add(medallas[i]);}
        for(int i=6;i<12;i++){panel2.add(medallas[i]);}
        for(int i=12;i<18;i++){panel3.add(medallas[i]);}
        for(int i=18;i<24;i++){panel4.add(medallas[i]);}
        for(int i=24;i<30;i++){panel5.add(medallas[i]);}
        //Location de M1's
        for(int i=0;i<30;i+=6){medallas[i].setBounds((int)(panel1.getWidth()*0.7),(int)(panel1.getHeight()*0.05),tm,tm);}
        //Location de M2's
        for(int i=1;i<30;i+=6){medallas[i].setBounds((int)(panel1.getWidth()*0.8),(int)(panel1.getHeight()*0.05), tm, tm);}
        //Location de M3's
        for(int i=2;i<30;i+=6){medallas[i].setBounds((int)(panel1.getWidth()*0.9),(int)(panel1.getHeight()*0.05), tm, tm);}
        //Location de M4's
        for(int i=3;i<30;i+=6){medallas[i].setBounds((int)(panel1.getWidth()*0.7),(int)(panel1.getHeight()*0.55), tm, tm);}
        //Location de M5's
        for(int i=4;i<30;i+=6){medallas[i].setBounds((int)(panel1.getWidth()*0.8),(int)(panel1.getHeight()*0.55), tm, tm);}
        //Location de M6's
        for(int i=5;i<30;i+=6){medallas[i].setBounds((int)(panel1.getWidth()*0.9),(int)(panel1.getHeight()*0.55), tm, tm);}
        
        //for(int i=0;i<30;i++){medallas[i].setBorder(prueba);}
        p1.setBounds((int)(panel1.getWidth()*0.1),(int)(panel1.getHeight()*0.25),(int)(panel1.getWidth()*0.6),(int)(panel1.getHeight()*0.5));
        p2.setBounds((int)(panel1.getWidth()*0.1),(int)(panel1.getHeight()*0.25),(int)(panel1.getWidth()*0.6),(int)(panel1.getHeight()*0.5));
        p3.setBounds((int)(panel1.getWidth()*0.1),(int)(panel1.getHeight()*0.25),(int)(panel1.getWidth()*0.6),(int)(panel1.getHeight()*0.5));
        p4.setBounds((int)(panel1.getWidth()*0.1),(int)(panel1.getHeight()*0.25),(int)(panel1.getWidth()*0.6),(int)(panel1.getHeight()*0.5));
        p5.setBounds((int)(panel1.getWidth()*0.1),(int)(panel1.getHeight()*0.25),(int)(panel1.getWidth()*0.6),(int)(panel1.getHeight()*0.5));
        //p1.setBorder(prueba);   p2.setBorder(prueba);   p3.setBorder(prueba);
        //p4.setBorder(prueba);   p5.setBorder(prueba);
        p1.setFont(new Font("Comic Sans MS", Font.PLAIN,(int)(p1.getHeight()*0.45) ));
        p2.setFont(new Font("Comic Sans MS", Font.PLAIN,(int)(p2.getHeight()*0.45) ));
        p3.setFont(new Font("Comic Sans MS", Font.PLAIN,(int)(p3.getHeight()*0.45) ));
        p4.setFont(new Font("Comic Sans MS", Font.PLAIN,(int)(p4.getHeight()*0.45) ));
        p5.setFont(new Font("Comic Sans MS", Font.PLAIN,(int)(p5.getHeight()*0.45) ));
        
        b1.setBounds((int)(panel1.getWidth()*0.03),(int)(panel1.getHeight()*0.37),(int)(panel1.getWidth()*0.05),(int)(panel1.getWidth()*0.05));
        b2.setBounds((int)(panel1.getWidth()*0.03),(int)(panel1.getHeight()*0.37),(int)(panel1.getWidth()*0.05),(int)(panel1.getWidth()*0.05));
        b3.setBounds((int)(panel1.getWidth()*0.03),(int)(panel1.getHeight()*0.37),(int)(panel1.getWidth()*0.05),(int)(panel1.getWidth()*0.05));
        b4.setBounds((int)(panel1.getWidth()*0.03),(int)(panel1.getHeight()*0.37),(int)(panel1.getWidth()*0.05),(int)(panel1.getWidth()*0.05));
        b5.setBounds((int)(panel1.getWidth()*0.03),(int)(panel1.getHeight()*0.37),(int)(panel1.getWidth()*0.05),(int)(panel1.getWidth()*0.05));
        int sB = (int)(panel1.getWidth()*0.05);
        //añadir icono de basura
        ImageIcon t = new ImageIcon("Iconos\\iTrash.png");
        Icon iT = new ImageIcon(t.getImage().getScaledInstance(sB,sB,Image.SCALE_DEFAULT));
        b1.setIcon(iT);b2.setIcon(iT);b3.setIcon(iT);b4.setIcon(iT);b5.setIcon(iT);
        panel1.add(b1); panel2.add(b2); panel3.add(b3);
        panel4.add(b4); panel5.add(b5);
    }
    public void botonesControl(){
        prin.add(right); prin.add(left); prin.add(ayuda); prin.add(ng);
        left.setBounds((int)(px*0.25), (int)(py*0.49), (int)(py*0.05), (int)(py*0.05));
        right.setBounds((int)(px*0.72), (int)(py*0.49), (int)(py*0.05), (int)(py*0.05));
        ayuda.setBounds((int)(px*0.05), (int)(py*0.05), (int)(py*0.05), (int)(py*0.05));
        ng.setBounds((int)(px*0.1), (int)(py*0.05), (int)(py*0.05), (int)(py*0.05));
        ng.setBackground(new Color(59,131,185));
        ng.setForeground(Color.WHITE);
        ayuda.setBackground(new Color(59,131,185));
        ayuda.setForeground(Color.WHITE);
        left.setBackground(new Color(59,131,185));
        left.setForeground(Color.WHITE);
        right.setBackground(new Color(59,131,185));
        right.setForeground(Color.WHITE);
        ng.setFont(new Font("Comic Sans MS", Font.PLAIN,(int)(ng.getHeight()*0.45) ));
        ayuda.setFont(new Font("Comic Sans MS", Font.PLAIN,(int)(ayuda.getHeight()*0.45) ));
        left.setFont(new Font("Comic Sans MS", Font.PLAIN,(int)(left.getHeight()*0.45) ));
        right.setFont(new Font("Comic Sans MS", Font.PLAIN,(int)(right.getHeight()*0.45) ));
        ayuda.setBackground(new Color(59,131,185));
        right.setBorder(bor);left.setBorder(bor);
        ayuda.setBorder(bor);ng.setBorder(bor);
        ng.setOpaque(true);ayuda.setOpaque(true);
        right.setOpaque(true);left.setOpaque(true);
    }
    public void acciones(){
        panel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                //Preguntas por pagActual, esta variable es la posicion [][pagActual] de la matriz
                //Y en caso de panel 1 accedes a la cadena [0][pagActual] de la matriz
                //JOptionPane.showMessageDialog(v,"PANEL 1");
                    String pa = paginas[0][pagActual];
                    String[] vec;
                    vec= pa.split(",");
                    v.menu.vec = vec;
                    v.menu.estAnt = pa;
                    v.menu.bd=data;
                    v.menu.CargaDatos();
                    setVisible(false);
                    v.menu.setVisible(true);
                    v.getContentPane().add(v.menu);
            }
        });
        panel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                    String pa = paginas[1][pagActual];
                    String[] vec;
                    vec= pa.split(",");
                    v.menu.vec = vec;
                    v.menu.estAnt = pa;
                    v.menu.bd=data;
                    v.menu.CargaDatos();
                    setVisible(false);
                    v.menu.setVisible(true);
                    v.getContentPane().add(v.menu);
            }
        });
        panel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                    String pa = paginas[2][pagActual];
                    String[] vec;
                    vec= pa.split(",");
                    v.menu.vec = vec;
                    v.menu.estAnt = pa;
                    v.menu.bd=data;
                    v.menu.CargaDatos();
                    setVisible(false);
                    v.menu.setVisible(true);
                    v.getContentPane().add(v.menu);
            }
        });
        panel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                    String pa = paginas[3][pagActual];
                    String[] vec;
                    vec= pa.split(",");
                    v.menu.vec = vec;
                    v.menu.estAnt = pa;
                    v.menu.bd=data;
                    v.menu.CargaDatos();
                    setVisible(false);
                    v.menu.setVisible(true);
                    v.getContentPane().add(v.menu);
            }
        });
        panel5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                    String pa = paginas[4][pagActual];
                    String[] vec;
                    vec= pa.split(",");
                    v.menu.vec = vec;
                    v.menu.estAnt = pa;
                    v.menu.bd=data;
                    v.menu.CargaDatos();
                    setVisible(false);
                    v.menu.setVisible(true);
                    v.getContentPane().add(v.menu);
            }
        });
        right.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(right.isEnabled()){
                    //JOptionPane.showMessageDialog(v,"ADELANTE");
                    cargaPag(pagActual+1);
                    //caso extremos de paginas
                    if(pagActual == (tpags-1)){
                        right.setEnabled(false);
                        left.setEnabled(true);
                    }
                    //caso especial (solo dos paginas)
                    if(tpags==2){
                        right.setEnabled(false);
                        left.setEnabled(true);
                    }
                    //caso con posibilidad de moverse hacia atras y hacia adelante
                    if(pagActual > 0 && pagActual < (tpags-1)){
                        right.setEnabled(true);
                        left.setEnabled(true);
                    }
                }
            }
        });
        left.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                if(left.isEnabled()){
                    //JOptionPane.showMessageDialog(v,"ATRAS");
                    cargaPag(pagActual-1);
                    //caso extremos de paginas
                    if(pagActual == 0){
                        left.setEnabled(false);
                        right.setEnabled(true);
                    }
                    //caso especial (solo dos paginas)
                    if(tpags==2){
                        left.setEnabled(false);
                        right.setEnabled(true);
                    }
                    //caso con posibilidad de moverse hacia atras y hacia adelante
                    if(pagActual > 0 && pagActual < (tpags-1)){
                        right.setEnabled(true);
                        left.setEnabled(true);
                    }
                }
            }
        });
        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int index = data.indexOf(paginas[0][pagActual]);
                data.remove(index);
                try{
                    File ar = new File("data.txt");
                    FileWriter fw = new FileWriter(ar);
                    BufferedWriter bw = new BufferedWriter(fw);
                    String linea;
                    for(int i=0;i<data.size();i++){bw.write(data.get(i)+"\n");}
                    bw.close();
                }catch(IOException ex){;}
                cargaDatosAPantalla();
                if(tpags==1){right.setEnabled(false);left.setEnabled(false);}
            }
        });
        b2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int index = data.indexOf(paginas[1][pagActual]);
                data.remove(index);
                try{
                    File ar = new File("data.txt");
                    FileWriter fw = new FileWriter(ar);
                    BufferedWriter bw = new BufferedWriter(fw);
                    String linea;
                    for(int i=0;i<data.size();i++){bw.write(data.get(i)+"\n");}
                    bw.close();
                }catch(IOException ex){;}
                cargaDatosAPantalla();
                if(tpags==1){right.setEnabled(false);left.setEnabled(false);}
            }
        });
        b3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int index = data.indexOf(paginas[2][pagActual]);
                data.remove(index);
                try{
                    File ar = new File("data.txt");
                    FileWriter fw = new FileWriter(ar);
                    BufferedWriter bw = new BufferedWriter(fw);
                    String linea;
                    for(int i=0;i<data.size();i++){bw.write(data.get(i)+"\n");}
                    bw.close();
                }catch(IOException ex){;}
                cargaDatosAPantalla();
                if(tpags==1){right.setEnabled(false);left.setEnabled(false);}
            }
        });
        b4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int index = data.indexOf(paginas[3][pagActual]);
                data.remove(index);
                try{
                    File ar = new File("data.txt");
                    FileWriter fw = new FileWriter(ar);
                    BufferedWriter bw = new BufferedWriter(fw);
                    String linea;
                    for(int i=0;i<data.size();i++){bw.write(data.get(i)+"\n");}
                    bw.close();
                }catch(IOException ex){;}
                cargaDatosAPantalla();
                if(tpags==1){right.setEnabled(false);left.setEnabled(false);}
            }
        });
        b5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int index = data.indexOf(paginas[4][pagActual]);
                data.remove(index);
                try{
                    File ar = new File("data.txt");
                    FileWriter fw = new FileWriter(ar);
                    BufferedWriter bw = new BufferedWriter(fw);
                    String linea;
                    for(int i=0;i<data.size();i++){bw.write(data.get(i)+"\n");}
                    bw.close();
                }catch(IOException ex){;}
                cargaDatosAPantalla();
                if(tpags==1){right.setEnabled(false);left.setEnabled(false);}
            }
        });
        ayuda.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    panel1.setVisible(false);
                    panel2.setVisible(false);
                    panel3.setVisible(false);
                    panel4.setVisible(false);
                    panel5.setVisible(false);
                    left.setVisible(false);
                    right.setVisible(false);
                    panelAyuda.setVisible(true);
                    insclic.setVisible(true);
                    ImageIcon inina = new ImageIcon("Personajes\\1 aa.png"), inino = new ImageIcon("Personajes\\2 ac.png");
                        Icon iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                        Icon iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                        nina.setIcon(iconoA);
                        nino.setIcon(iconoB);
                        txtAyuda.setText("\n\n Para cargar tu partida, haz clic en\n    cualquier parte donde veas tu\n                 nombre.");
                        c++;
                    nino.setVisible(true); nina.setVisible(true);
            }
        });
        insclic.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                switch(c){
                    case 1: 
                        ImageIcon inina = new ImageIcon("Personajes\\1 ac.png"), inino = new ImageIcon("Personajes\\2 aa.png");
                        Icon iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                        Icon iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                        nina.setIcon(iconoA);
                        nino.setIcon(iconoB);
                        txtAyuda.setText("\n Si no ves tu nombre, puede que no\n     se encuentre en esta página,\n  intenta moverte con las flechas\n            que hay debajo.");
                        c++;
                        break;
                    case 2: 
                        inina = new ImageIcon("Personajes\\1 ca.png"); inino = new ImageIcon("Personajes\\2 cc.png");
                        iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                        iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                        nina.setIcon(iconoA);
                        nino.setIcon(iconoB);
                        txtAyuda.setText("\n              Si eres nuevo,\n     haz clic en el botón que dice:\n                >>>+<<<\n          (NUEVO JUGADOR)");
                        c++;
                        break;
                    case 3: 
                        inina = new ImageIcon("Personajes\\1 ac.png"); inino = new ImageIcon("Personajes\\2 aa.png");
                        iconoA = new ImageIcon(inina.getImage().getScaledInstance((int)(px*0.21), (int)(py*0.8),Image.SCALE_DEFAULT));
                        iconoB = new ImageIcon(inino.getImage().getScaledInstance((int)(px*0.2), (int)(py*0.8),Image.SCALE_DEFAULT));
                        nina.setIcon(iconoA);
                        nino.setIcon(iconoB);
                        txtAyuda.setText("\n     !Después de crear tu perfil,\n  muevete con las flechas de abajo\npara encontrar tu perfil y comenzar\n                 a jugar!");
                        c++;
                        break;
                    case 4: 
                        panel1.setVisible(true);
                        panel2.setVisible(true);
                        panel3.setVisible(true);
                        panel4.setVisible(true);
                        panel5.setVisible(true);
                        left.setVisible(true);
                        right.setVisible(true);
                        panelAyuda.setVisible(false);
                        insclic.setVisible(false);
                        nino.setVisible(false); nina.setVisible(false);
                        c=0;
                        break;
                }
            }
        });
        ng.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                panel1.setVisible(false);
                panel2.setVisible(false);
                panel3.setVisible(false);
                panel4.setVisible(false);
                panel5.setVisible(false);
                left.setVisible(false);
                right.setVisible(false);
                inName.setVisible(true);
                inputName.setText("");
            }
        });
        crear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                guardaInfo();
                panel1.setVisible(true);
                panel2.setVisible(true);
                panel3.setVisible(true);
                panel4.setVisible(true);
                panel5.setVisible(true);
                left.setVisible(true);
                right.setVisible(true);
                inName.setVisible(false);
            }
        });
    }
    public void guardaInfo(){
        try{
            File ar = new File("data.txt");
            FileWriter fw = new FileWriter(ar);
            BufferedWriter bw = new BufferedWriter(fw);
            String linea = inputName.getText()+",0,0,0,0,0,0";
            data.push(linea);
            for(int i=0;i<data.size();i++){bw.write(data.get(i)+"\n");}
            bw.close();
        }catch(IOException e){;}
        inName.setVisible(false);
        cargaDatosAPantalla();
    }
}