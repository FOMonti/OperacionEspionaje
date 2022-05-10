package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import entidades.RedEspias;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazMenu {

	private InterfazAgregarEspia interfazAgregarEspia;
	private InterfazAgregarComunicacion interfazAgregarComunicacion;
	private InterfazArbol interfazArbol = new InterfazArbol();
	private RedEspias redEspias = new RedEspias();
	private JFrame frameMenu;

	private JLabel lblTituloInicio;

	private JButton btnAgregarEspia;
	private JButton btnAgregarComunicacion;
	private JButton btnArbolGeneradorMinimo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazMenu window = new InterfazMenu();
					window.frameMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InterfazMenu() {
		interfazAgregarEspia = new InterfazAgregarEspia();
		interfazAgregarComunicacion = new InterfazAgregarComunicacion();
		initialize();
		frameMenu.setVisible(true);
		btnAgregarEspia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVentanaAgregarEspia();
			}
		});
		btnAgregarComunicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVentanaAgregarComunicacion();
			}
		});
		btnArbolGeneradorMinimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVentanaArbol();
			}
		});
	}

	private void initialize() {
		inicializarFrame();
		btnAgregarEspia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVentanaAgregarEspia();
			}
		});
		btnAgregarComunicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVentanaAgregarComunicacion();
			}
		});
		btnArbolGeneradorMinimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVentanaArbol();
			}
		});
	}

	public void mostrarVentana(RedEspias redEspias) {
		this.redEspias = redEspias;
		frameMenu.setVisible(true);
	}

	private void mostrarVentanaAgregarEspia() {
		frameMenu.setVisible(false);
		interfazAgregarEspia.mostrarVentana(redEspias);
	}

	private void mostrarVentanaAgregarComunicacion() {
		frameMenu.setVisible(false);
		interfazAgregarComunicacion.mostrarVentana(redEspias);
	}

	public void mostrarVentanaArbol() {
		frameMenu.setVisible(false);
		interfazArbol.mostrarVentana(redEspias, this);
	}

	// Inicializacion de Variables:
	private void inicializarFrame() {
		inicializarFrameMenu();
		inicializarLabelTituloInicio();
		inicializarBtnAgregarEspia();
		inicializarBtnAgregarComunicacion();
		inicializarBtnArbolGeneradorMInimo();
	}

	private void inicializarFrameMenu() {
		frameMenu = new JFrame();
		frameMenu.setResizable(false);
		frameMenu.getContentPane().setEnabled(false);
		frameMenu.setTitle("Menu");
		frameMenu.setForeground(new Color(0, 0, 0));
		frameMenu.setBackground(Color.BLUE);
		frameMenu.getContentPane().setBackground(new Color(0, 0, 51));
		frameMenu.getContentPane().setLayout(null);
		frameMenu.setBounds(200, 100, 680, 500);
		frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMenu.setLocationRelativeTo(null);
	}

	private void inicializarLabelTituloInicio() {
		lblTituloInicio = new JLabel("MENU");
		lblTituloInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloInicio.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTituloInicio.setForeground(new Color(255, 255, 255));
		lblTituloInicio.setBounds(261, 64, 130, 66);
		frameMenu.getContentPane().add(lblTituloInicio);
	}

	private void inicializarBtnAgregarEspia() {
		btnAgregarEspia = new JButton("Agregar Espia");
		btnAgregarEspia.setBackground(Color.DARK_GRAY);
		btnAgregarEspia.setForeground(Color.BLUE);
		btnAgregarEspia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAgregarEspia.setBounds(197, 141, 250, 50);
		frameMenu.getContentPane().add(btnAgregarEspia);
	}

	private void inicializarBtnAgregarComunicacion() {
		btnAgregarComunicacion = new JButton("Agregar Comunicacion");
		btnAgregarComunicacion.setForeground(Color.BLUE);
		btnAgregarComunicacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAgregarComunicacion.setBackground(Color.DARK_GRAY);
		btnAgregarComunicacion.setBounds(197, 216, 250, 50);
		frameMenu.getContentPane().add(btnAgregarComunicacion);
	}

	private void inicializarBtnArbolGeneradorMInimo() {
		btnArbolGeneradorMinimo = new JButton("Arbol Generador minmo");
		btnArbolGeneradorMinimo.setForeground(Color.BLUE);
		btnArbolGeneradorMinimo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnArbolGeneradorMinimo.setBackground(Color.DARK_GRAY);
		btnArbolGeneradorMinimo.setBounds(197, 292, 250, 50);
		frameMenu.getContentPane().add(btnArbolGeneradorMinimo);
	}
}
