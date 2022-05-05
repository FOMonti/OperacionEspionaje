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

public class InterfazAgregarEspia {

	private JFrame frame;
	private JTextArea inputEspia;
	private JLabel lblIngreseEspia;

	private JButton btnAgregarEspia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazAgregarEspia window = new InterfazAgregarEspia();
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
	public InterfazAgregarEspia() {
		InicializarFrame();
		btnAgregarEspia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	// Inicializacion de Variables
	public void InicializarFrame() {

		InitFrame();
		InitLabelIngreseEspia();
		InitInputEspia();
		InitButtonAgregar();

	}

	// Inicializacion del Frame.
	private void InitFrame() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.setBackground(Color.BLUE);
		frame.getContentPane().setBackground(new Color(0, 0, 51));
		frame.getContentPane().setLayout(null);
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
}
