package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;

public class Interfaz {

	private JFrame frame;

	private JLabel lblTitulo;
	private JLabel lblAgregar;
	private JLabel lblNombre;
	private JLabel lblAgregarComunicacion;
	private JLabel lblNombreEspia;
	private JLabel lblRisgo;
	private JLabel lblNombreEspiaReceptor;
	private JLabel lblListaDeEspias;

	private JTextField textNombre;
	private JTextField textFieldEspiaEmisor;
	private JTextField textFieldEspiaReceptor;
	private JTextField textFieldRiesgo;

	private JButton btnAgregarComunicacion;
	private JButton btnAgregarEspia;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interfaz() {
		initialize();
	}

	private void initialize() {
		inicializarFrame();

	}

	private void inicializarFrame() {
		inicializrFrameSistema();

		inicializarLblTitulo();

		inicializarLblAgregar();

		inicializarTextFielNombre();

		inicializarLblNombre();

		inicializarLblAgregarComuinicacion();

		inicializarLblNombreEspia();

		inicializarTextFieldEspiaEmisor();

		inicializarTextFieldEspiaReceptor();

		inicializarLblRiesgo();

		inicializarTextFieldRiesgo();

		inicializarLblNombreEspiaReceptor();

		inicializarLblListaEspias();

		inicializarBtnAgregarComunicacion();

		inicializarBtnAgregarEspia();
	}

	private void inicializarBtnAgregarEspia() {
		btnAgregarEspia = new JButton("Agregar Espia");
		btnAgregarEspia.setBounds(269, 166, 107, 23);
		frame.getContentPane().add(btnAgregarEspia);
		frame.setBounds(100, 100, 1101, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void inicializarBtnAgregarComunicacion() {
		btnAgregarComunicacion = new JButton("Agregar Comunicacion");
		btnAgregarComunicacion.setBounds(132, 441, 204, 23);
		frame.getContentPane().add(btnAgregarComunicacion);

	}

	private void inicializarLblListaEspias() {
		lblListaDeEspias = new JLabel("Lista de Espias Actuales:");
		lblListaDeEspias.setBounds(720, 119, 249, 35);
		lblListaDeEspias.setForeground(Color.WHITE);
		lblListaDeEspias.setFont(new Font("Verdana", Font.PLAIN, 20));
		frame.getContentPane().add(lblListaDeEspias);
	}

	private void inicializarLblNombreEspiaReceptor() {
		lblNombreEspiaReceptor = new JLabel("Nombre del espia receptor:");
		lblNombreEspiaReceptor.setBounds(88, 342, 204, 35);
		lblNombreEspiaReceptor.setForeground(Color.WHITE);
		lblNombreEspiaReceptor.setFont(new Font("Verdana", Font.PLAIN, 15));
		frame.getContentPane().add(lblNombreEspiaReceptor);
	}

	private void inicializarTextFieldRiesgo() {
		textFieldRiesgo = new JTextField();
		textFieldRiesgo.setBounds(165, 386, 86, 20);
		textFieldRiesgo.setColumns(10);
		frame.getContentPane().add(textFieldRiesgo);
	}

	private void inicializarTextFieldEspiaReceptor() {
		textFieldEspiaReceptor = new JTextField();
		textFieldEspiaReceptor.setBounds(300, 351, 86, 20);
		textFieldEspiaReceptor.setColumns(10);
		frame.getContentPane().add(textFieldEspiaReceptor);
	}

	private void inicializarLblRiesgo() {
		lblRisgo = new JLabel("Riesgo:");
		lblRisgo.setBounds(88, 377, 67, 35);
		lblRisgo.setForeground(Color.WHITE);
		lblRisgo.setFont(new Font("Verdana", Font.PLAIN, 15));
		frame.getContentPane().add(lblRisgo);
	}

	private void inicializarTextFieldEspiaEmisor() {
		textFieldEspiaEmisor = new JTextField();
		textFieldEspiaEmisor.setBounds(290, 311, 86, 20);
		textFieldEspiaEmisor.setColumns(10);
		frame.getContentPane().add(textFieldEspiaEmisor);
	}

	private void inicializarLblNombreEspia() {
		lblNombreEspia = new JLabel("Nombre del espia emisor:");
		lblNombreEspia.setBounds(88, 302, 192, 35);
		lblNombreEspia.setForeground(Color.WHITE);
		lblNombreEspia.setFont(new Font("Verdana", Font.PLAIN, 15));
		frame.getContentPane().add(lblNombreEspia);
	}

	private void inicializarLblAgregarComuinicacion() {
		lblAgregarComunicacion = new JLabel("Agregar Comunicacion de Espias:");
		lblAgregarComunicacion.setBounds(61, 265, 260, 35);
		lblAgregarComunicacion.setForeground(Color.WHITE);
		lblAgregarComunicacion.setFont(new Font("Verdana", Font.PLAIN, 15));
		frame.getContentPane().add(lblAgregarComunicacion);
	}

	private void inicializarLblNombre() {
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(88, 158, 67, 35);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 15));
		frame.getContentPane().add(lblNombre);
	}

	private void inicializarTextFielNombre() {
		textNombre = new JTextField();
		textNombre.setBounds(165, 167, 86, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
	}

	private void inicializarLblAgregar() {
		lblAgregar = new JLabel("Agregar Espia:");
		lblAgregar.setBounds(61, 121, 117, 35);
		lblAgregar.setForeground(Color.WHITE);
		lblAgregar.setFont(new Font("Verdana", Font.PLAIN, 15));
		frame.getContentPane().add(lblAgregar);
	}

	private void inicializarLblTitulo() {
		frame.getContentPane().setLayout(null);
		lblTitulo = new JLabel("Sistema de Red De Espias (ULTRASECRETO)");
		lblTitulo.setBounds(311, 34, 454, 35);
		lblTitulo.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblTitulo.setForeground(Color.WHITE);
		frame.getContentPane().add(lblTitulo);
	}

	private void inicializrFrameSistema() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setEnabled(false);
		frame.setTitle("SISTEMA DE ESPIAS");
		frame.setForeground(new Color(0, 0, 0));
		frame.setBackground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(200, 100, 680, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
