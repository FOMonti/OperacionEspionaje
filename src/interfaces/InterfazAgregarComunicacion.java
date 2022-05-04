package interfaces;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class InterfazAgregarComunicacion {

	private JFrame frame;
	
	private JLabel lblIngreseEspia;
	
	private JLabel lblEspiaEmisor;
	private JTextArea inputEspiaEmisor;
	
	private JLabel lblEspiaReceptor;
	private JTextArea inputEspiaReceptor;
	
	private JLabel lblRiesgo;
	private JTextArea inputRiesgo;
	
	private JButton btnAgregarComunicacion;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazAgregarComunicacion window = new InterfazAgregarComunicacion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazAgregarComunicacion() {
		InicializarFrame();
		btnAgregarComunicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}

	//Inicializacion de Variables
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
		
		
		
	}
	
	
	
	// Inicializacion del Frame.
	private void InitFrame() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.setBackground(Color.BLUE);
		frame.getContentPane().setBackground(new Color(0, 0, 51));
		frame.getContentPane().setLayout(null);
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
		lblEspiaEmisor.setBounds(136, 94, 120, 25);
		frame.getContentPane().add(lblEspiaEmisor);
	}

	private void InitInputEspiaEmisor() {
		inputEspiaEmisor = new JTextArea();
		inputEspiaEmisor .setMargin(new Insets(2, 15, 2, 2));
		inputEspiaEmisor .setFont(new Font("Monospaced", Font.PLAIN, 20));
		inputEspiaEmisor .setBounds(348, 91, 186, 31);
		frame.getContentPane().add(inputEspiaEmisor );
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
	
	private void InitLabelRiesgo(){
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
		
		frame.setBounds(200, 100, 680, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
