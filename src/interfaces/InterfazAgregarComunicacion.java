package interfaces;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

import entidades.RedEspias;
import excepciones.ComunicacionExcepcion;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InterfazAgregarComunicacion {

	private InterfazMenu interfazMenu;
	private RedEspias redEspias = new RedEspias();

	private JFrame frame;
	

	private JLabel lblIngreseEspia;

	private JLabel lblEspiaEmisor;
	private JTextArea inputEspiaEmisor;

	private JLabel lblEspiaReceptor;
	private JTextArea inputEspiaReceptor;

	private JLabel lblRiesgo;
	private JTextArea inputRiesgo;

	private JButton btnAgregarComunicacion;
	private JButton btnVolverMenu;
	
	private JLabel lblInfo;
	private JLabel lblError;
	
	
	
	
	

	public InterfazAgregarComunicacion() {
		InicializarFrame();
		btnAgregarComunicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String espia1 = inputEspiaEmisor.getText().toUpperCase();
				String espia2 = inputEspiaReceptor.getText().toUpperCase();
				Double riesgo = Double.valueOf(inputRiesgo.getText().toUpperCase());
				
				try {
					redEspias.agregarComunicacion(espia1, espia2, riesgo);
					System.out.println("Se agrego la comunicacion con exito");
					limpiarInputs();
					lblInfo.setVisible(true);
					lblError.setVisible(false);
					
				}
				catch (ComunicacionExcepcion eE ) {
					lblError.setText("<html>" + eE.getMessage() + "</html>");
					lblError.setVisible(true);
					lblInfo.setVisible(false);
					
				}
			}
		});
		btnVolverMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				volverMenu();
			}
		});
	}

	public void mostrarVentana(RedEspias redEspias, InterfazMenu interfazMenu) {
//		System.out.println("123");
		this.redEspias = redEspias;
		this.interfazMenu = interfazMenu;
		
		
		// Si se va a selecionar de listas las opciones, se inicializa aca
		System.out.println(Arrays.toString(redEspias.arrEspias()));
		
		frame.setVisible(true);
		
		
	}

	private void volverMenu() {
		
		
		
		frame.setVisible(false);
		
		interfazMenu.mostrarVentana(redEspias);
		
	}

	// Inicializacion de Variables
	public void InicializarFrame() {
		
		

		InitFrame();
		InitLabelIngreseComunicacion();

		InitLabelEspiaEmisor();
		InitInputEspiaEmisor();
		

		InitLabelEspiaReceptor();
		InitInputEspiaReceptor();

		InitLabelRiesgo();
		InitInputRiesgo();

		InitButtonAgregarComunicacion();
		inicializarBtnVolverMenu();
		
		inicializarMensajesInfo();
	}
	
	
	private void limpiarInputs() {
		inputEspiaEmisor.setText("");
		inputEspiaReceptor.setText("");
		inputRiesgo.setText("");
	}

	// Inicializacion del Frame.
	private void InitFrame() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.setBackground(Color.BLUE);
		frame.getContentPane().setBackground(new Color(0, 0, 51));
		frame.getContentPane().setLayout(null);
		frame.setBounds(200, 100, 680, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(false);
	}

	private void InitLabelIngreseComunicacion() {
		lblIngreseEspia = new JLabel("Agrega la comunicacion entre espias:");
		lblIngreseEspia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIngreseEspia.setForeground(Color.WHITE);
		lblIngreseEspia.setBounds(158, 23, 382, 25);
		frame.getContentPane().add(lblIngreseEspia);
	}

	private void InitLabelEspiaEmisor() {
		lblEspiaEmisor = new JLabel("Espia emisor:");
		lblEspiaEmisor.setForeground(Color.WHITE);
		lblEspiaEmisor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEspiaEmisor.setBounds(136, 117, 120, 25);
		frame.getContentPane().add(lblEspiaEmisor);
	}

	private void InitInputEspiaEmisor() {
		inputEspiaEmisor = new JTextArea();
		inputEspiaEmisor.setMargin(new Insets(2, 15, 2, 2));
		inputEspiaEmisor.setFont(new Font("Monospaced", Font.PLAIN, 20));
		inputEspiaEmisor.setBounds(348, 114, 186, 31);
		frame.getContentPane().add(inputEspiaEmisor);
	}

	private void InitLabelEspiaReceptor() {
		lblEspiaReceptor = new JLabel("Espia receptor:");
		lblEspiaReceptor.setForeground(Color.WHITE);
		lblEspiaReceptor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEspiaReceptor.setBounds(136, 183, 145, 25);
		frame.getContentPane().add(lblEspiaReceptor);
	}

	private void InitInputEspiaReceptor() {
		inputEspiaReceptor = new JTextArea();
		inputEspiaReceptor.setMargin(new Insets(2, 15, 2, 2));
		inputEspiaReceptor.setFont(new Font("Monospaced", Font.PLAIN, 20));
		inputEspiaReceptor.setBounds(348, 180, 186, 31);
		frame.getContentPane().add(inputEspiaReceptor);
	}

	private void InitLabelRiesgo() {
		lblRiesgo = new JLabel("Riesgo comunicacion:");
		lblRiesgo.setForeground(Color.WHITE);
		lblRiesgo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRiesgo.setBounds(136, 273, 202, 25);
		frame.getContentPane().add(lblRiesgo);
	}

	private void InitInputRiesgo() {
		inputRiesgo = new JTextArea();
		inputRiesgo.setMargin(new Insets(2, 15, 2, 2));
		inputRiesgo.setFont(new Font("Monospaced", Font.PLAIN, 20));
		inputRiesgo.setBounds(348, 270, 186, 31);
		frame.getContentPane().add(inputRiesgo);
	}

	private void InitButtonAgregarComunicacion() {
		btnAgregarComunicacion = new JButton("Agregar");
		btnAgregarComunicacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAgregarComunicacion.setBounds(276, 342, 115, 39);
		frame.getContentPane().add(btnAgregarComunicacion);
	}

	private void inicializarBtnVolverMenu() {
		btnVolverMenu = new JButton("Menu");
		btnVolverMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVolverMenu.setBounds(276, 402, 115, 39);
		frame.getContentPane().add(btnVolverMenu);
		
		
		
		
	}
	
	private void inicializarMensajesInfo(){
		lblInfo = new JLabel("Se agrego con exito");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInfo.setForeground(Color.GREEN);
		lblInfo.setBounds(402, 352, 164, 23);
		frame.getContentPane().add(lblInfo);
		lblInfo.setVisible(false);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblError.setBounds(10, 48, 644, 44);
		frame.getContentPane().add(lblError);
		lblError.setVisible(false);
	}
}
