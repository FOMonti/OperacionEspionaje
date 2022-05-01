package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;

public class Interfaz {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema de Red De Espias (ULTRASECRETO)");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(311, 34, 454, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Agregar Espia:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(61, 121, 117, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(165, 167, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(88, 158, 67, 35);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Agregar Comunicacion de Espias:");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(61, 265, 260, 35);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nombre del espia emisor:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(88, 302, 192, 35);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(290, 311, 86, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(300, 351, 86, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Riesgo:");
		lblNewLabel_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_3.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1_1_3.setBounds(88, 377, 67, 35);
		frame.getContentPane().add(lblNewLabel_1_1_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(165, 386, 86, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nombre del espia receptor:");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(88, 342, 204, 35);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblListaDeEspias = new JLabel("Lista de Espias Actuales:");
		lblListaDeEspias.setForeground(Color.WHITE);
		lblListaDeEspias.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblListaDeEspias.setBounds(720, 119, 249, 35);
		frame.getContentPane().add(lblListaDeEspias);
		
		JButton btnNewButton = new JButton("Agregar Comunicacion");
		btnNewButton.setBounds(132, 441, 204, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAgregarEspia = new JButton("Agregar Espia");
		btnAgregarEspia.setBounds(269, 166, 107, 23);
		frame.getContentPane().add(btnAgregarEspia);
		frame.setBounds(100, 100, 1101, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
