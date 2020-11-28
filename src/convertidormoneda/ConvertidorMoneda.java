package convertidormoneda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConvertidorMoneda extends JFrame implements ActionListener,KeyListener
{
    JButton btnconvertir;
    JComboBox cmborigen,cmbidorigen,cmbdestino,cmbiddestino;
    JTextField txtcantidad,txttotal;
    double cdol=24.2139,vdol=24.3834,cdoeu=1.1963,vdoeu=1.1965,ceul=27.2406,veul=29.9916;
    DecimalFormat dosdig=new DecimalFormat("0.00");
    String total="0.00";
    
    ConvertidorMoneda(){
        super("Login");
        getContentPane().setLayout(null);
        
        //Titulo
        JLabel titulo=new JLabel("Convertidor de monedas UTH");
	titulo.setBounds(60,10,200,30);
	getContentPane().add(titulo);
        //-----------------------------------------------------
        
        JLabel labelorigen=new JLabel("Moneda Origen");
	labelorigen.setBounds(50,50,120,30);
	getContentPane().add(labelorigen);
	cmborigen = new JComboBox();
	cmborigen.setBounds(50,80,120,20);
        getContentPane().add(cmborigen);
        cmborigen.addActionListener(this);
        
        JLabel labeldestino=new JLabel("Convertir Moneda a");
	labeldestino.setBounds(50,110,120,30);
	getContentPane().add(labeldestino);
	cmbdestino = new JComboBox();
	cmbdestino.setBounds(50,140,120,20);
	getContentPane().add(cmbdestino);
        cmbdestino.addActionListener(this);
        
        validarmoneda();
        
        JLabel labelcantidad=new JLabel("Cantidad:");
	labelcantidad.setBounds(50,170,120,30);
	getContentPane().add(labelcantidad);
	txtcantidad = new JTextField();
	txtcantidad.setBounds(50,200,120,20);
        txtcantidad.addKeyListener(this);
        txtcantidad.addActionListener(this);
	getContentPane().add(txtcantidad);
        
        JLabel labeltotal=new JLabel("Total:");
	labeltotal.setBounds(50,230,120,30);
	getContentPane().add(labeltotal);
        
        txttotal = new JTextField(total);
	txttotal.setBounds(90,230,120,30);
        txttotal.setEditable(false);
	getContentPane().add(txttotal);
        
        setSize(300,350);
	setLocationRelativeTo(null);
	setVisible(true);
	setResizable(false);
    }
    
    public void validarmoneda(){
        String[] nmoneda={"Lempira","Dolar","Euro"};
        cmborigen.addItem("Elegir Moneda");
        cmbdestino.addItem("Elegir Moneda");
        for(int i=0; i<=(nmoneda.length-1);i++){
            cmborigen.addItem(nmoneda[i]);
            cmbdestino.addItem(nmoneda[i]);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){}
    @Override
    public void keyTyped(KeyEvent e){
        if(e.getSource()==txtcantidad){
            char c = e.getKeyChar();
            if(Character.isLetter(c)){e.consume();}
            else{}
        }
    }
    @Override
    public void keyPressed(KeyEvent e){}
    @Override
    public void keyReleased(KeyEvent e){
        if(e.getSource()==txtcantidad){
            if(txtcantidad.getText().isEmpty()){
                txttotal.setText("0.00");
                txtcantidad.setText("0");
            }
            //Lempira a Dolar
            if(cmborigen.getSelectedItem().toString()=="Lempira" && cmbdestino.getSelectedItem().toString()=="Dolar"){
                double cant= (Double.parseDouble(txtcantidad.getText()))/vdol;
                txttotal.setText(dosdig.format(cant));
            }
            //Dolar a Lempira
            if(cmborigen.getSelectedItem().toString()=="Dolar" && cmbdestino.getSelectedItem().toString()=="Lempira"){
                double cant= (Double.parseDouble(txtcantidad.getText()))*cdol;
                txttotal.setText(dosdig.format(cant));
            }
            //Lempira a Euro
            if(cmborigen.getSelectedItem().toString()=="Lempira" && cmbdestino.getSelectedItem().toString()=="Euro"){
                double cant= (Double.parseDouble(txtcantidad.getText()))/veul;
                txttotal.setText(dosdig.format(cant));
            }
            //Euro a Lempira
            if(cmborigen.getSelectedItem().toString()=="Euro" && cmbdestino.getSelectedItem().toString()=="Lempira"){
                double cant= (Double.parseDouble(txtcantidad.getText()))*ceul;
                txttotal.setText(dosdig.format(cant));
            }
            //Dolar a Euro
            if(cmborigen.getSelectedItem().toString()=="Dolar" && cmbdestino.getSelectedItem().toString()=="Euro"){
                double cant= (Double.parseDouble(txtcantidad.getText()))/vdoeu;
                txttotal.setText(dosdig.format(cant));
            }
            //Euro a Dolar
            if(cmborigen.getSelectedItem().toString()=="Euro" && cmbdestino.getSelectedItem().toString()=="Dolar"){
                double cant= (Double.parseDouble(txtcantidad.getText()))*cdoeu;
                txttotal.setText(dosdig.format(cant));
            }
    	}
    }    
}