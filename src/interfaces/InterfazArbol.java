package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import entidades.RedEspias;
import excepciones.EspiaExcepcion;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class InterfazArbol {
	
	private InterfazMenu interfazMenu;
	private RedEspias redEspias = new RedEspias();

	private JFrame frame;
	private JLabel titulo;
	private JButton btnVolverMenu;

	public InterfazArbol() {
		inicializarFrame();
		
		btnVolverMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				volverMenu();
			}
		});
	}

	
	/**
	 * Launch the application.
	 */
	
	public void mostrarVentana(RedEspias redEspias, InterfazMenu interfazMenu) {
		this.interfazMenu = interfazMenu;
		this.redEspias = redEspias;
		frame.setVisible(true);
	}

	private void volverMenu() {
		frame.setVisible(false);
		interfazMenu.mostrarVentana(redEspias);
	}
	
	public void inicializarFrame() {
		initFrame();
		initLabelTitulo();
		initBtnVolverMenu();
	}
	
	private void initFrame() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.setBackground(Color.BLUE);
		frame.getContentPane().setBackground(new Color(0, 0, 51));
		frame.getContentPane().setLayout(null);
		frame.setBounds(200, 100, 680, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(false);
	}
	
	private void initLabelTitulo() {
		titulo = new JLabel("Arbol Generador Minimo");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo.setForeground(Color.WHITE);
		titulo.setBounds(222, 35, 328, 25);
		frame.getContentPane().add(titulo);
	}
	
	private void initBtnVolverMenu() {
		btnVolverMenu = new JButton("Menu");
		btnVolverMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVolverMenu.setBounds(276, 402, 115, 39);
		frame.getContentPane().add(btnVolverMenu);

	}

	/**
	 * Create the frame.
	 */
	
}