package interfaces;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

import entidades.RedEspias;
import excepciones.EspiaExcepcion;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class InterfazAgregarEspia {

	private InterfazMenu interfazMenu;
	private RedEspias redEspias = new RedEspias();

	private JFrame frame;

	private JTextArea inputEspia;
	private JLabel lblIngreseEspia;

	private JButton btnAgregarEspia;
	private JButton btnVolverMenu;
	
	private JLabel lblInfo;
	private JLabel lblError;

	public InterfazAgregarEspia() {
		InicializarFrame();
		btnAgregarEspia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!inputEspia.getText().isEmpty()) {
					String nombreEspia = inputEspia.getText();
					try {
						redEspias.agregarEspia(nombreEspia);
						System.out.println("Se agrego el espia con exito");
						limpiarInput();
						lblInfo.setVisible(true);
						lblError.setVisible(false);
					} catch (EspiaExcepcion eE) {
						lblError.setText("<html>" + eE.getMessage() + "</html>");
						lblError.setVisible(true);
						lblInfo.setVisible(false);
					} 
				} else {
					lblError.setText("Debe completar el campo");
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

	private void limpiarInput() {
		inputEspia.setText("");
	}

	
	public void mostrarVentana(RedEspias redEspias, InterfazMenu interfazMenu) {
//		System.out.println("asdas");
		this.interfazMenu = interfazMenu;
		this.redEspias = redEspias;
		frame.setVisible(true);
	}

	private void volverMenu() {
		frame.setVisible(false);
		interfazMenu.mostrarVentana(redEspias);
	}

	// Inicializacion de Variables
	public void InicializarFrame() {

		InitFrame();
		InitLabelIngreseEspia();
		InitInputEspia();
		InitButtonAgregar();
		inicializarBtnVolverMenu();
		inicializarMensajesInfo();
	}

	// Inicializacion del Frame.
	private void InitFrame() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.setBackground(Color.BLUE);
		frame.getContentPane().setBackground(new Color(0, 0, 51));
		frame.getContentPane().setLayout(null);
		frame.setBounds(200, 100, 680, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(false);
	}

	private void InitLabelIngreseEspia() {
		lblIngreseEspia = new JLabel("Ingrese el nombre de su esp\u00EDa:");
		lblIngreseEspia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIngreseEspia.setForeground(Color.WHITE);
		lblIngreseEspia.setBounds(192, 135, 328, 25);
		frame.getContentPane().add(lblIngreseEspia);
	}

	private void InitInputEspia() {
		inputEspia = new JTextArea();
		inputEspia.setMargin(new Insets(2, 15, 2, 2));
		inputEspia.setFont(new Font("Monospaced", Font.PLAIN, 20));
		inputEspia.setBounds(192, 202, 279, 31);
		frame.getContentPane().add(inputEspia);
	}

	private void InitButtonAgregar() {
		btnAgregarEspia = new JButton("Agregar");
		btnAgregarEspia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAgregarEspia.setBounds(273, 272, 115, 39);
		frame.getContentPane().add(btnAgregarEspia);
		frame.setBounds(200, 100, 680, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void inicializarBtnVolverMenu() {
		btnVolverMenu = new JButton("Menu");
		btnVolverMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVolverMenu.setBounds(273, 334, 115, 39);
		frame.getContentPane().add(btnVolverMenu);
	}
	
	private void inicializarMensajesInfo(){
		lblInfo = new JLabel("Se agrego con exito");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInfo.setForeground(Color.GREEN);
		lblInfo.setBounds(257, 398, 164, 23);
		frame.getContentPane().add(lblInfo);
		lblInfo.setVisible(false);
		
		lblError = new JLabel("fffff");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblError.setBounds(192, 48, 284, 44);
		frame.getContentPane().add(lblError);
		lblError.setVisible(false);
	}
}
