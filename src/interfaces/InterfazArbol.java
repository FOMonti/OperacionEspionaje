package interfaces;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import entidades.RedEspias;
import excepciones.ComunicacionExcepcion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;

import entidades.Grafo;

public class InterfazArbol {

	private InterfazMenu interfazMenu;
	private DefaultTableModel model = new DefaultTableModel();
	private RedEspias redEspias;
	private Grafo<String, Double> arbol;

	private JFrame frame;
	private JLabel titulo;
	private JButton btnVolverMenu;

	private JButton btnPrim;
	private JButton btnKruskal;
	private JTable tabla;
	private JLabel labelTiempo;
	private JLabel labelError;

	public InterfazArbol() {
		inicializarFrame();

		btnPrim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarPrim();
			}
		});

		btnKruskal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarKruskal();
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
		this.interfazMenu = interfazMenu;
		this.redEspias = redEspias;
		frame.setVisible(true);
	}

	private void volverMenu() {
		frame.setVisible(false);
		interfazMenu.mostrarVentana(redEspias);
	}

	private void mostrarPrim() {
		try {
			arbol = redEspias.prim();
			labelTiempo.setText("Tiempo: " + redEspias.getTiempoPrim() + " (Prim)");
			llenarTabla();
			labelError.setVisible(false);
		} catch (ComunicacionExcepcion e) {
			labelError.setText(e.getMessage());
			labelError.setVisible(true);
		}
	}

	private void mostrarKruskal() {
		try {
			arbol = redEspias.kruskal();
			labelTiempo.setText("Tiempo: " + redEspias.getTiempoKruskal() + " (Kruskal)");
			llenarTabla();
			labelError.setVisible(false);
		} catch (ComunicacionExcepcion e) {
			labelError.setText(e.getMessage());
			labelError.setVisible(true);
		}
	}

	public void inicializarFrame() {
		initFrame();
		initLabelTitulo();
		initBtnPrim();
		initBtnKruskal();
		initLabelTiempo();
		initLabelError();
		initTabla();
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
		titulo.setBounds(222, 35, 226, 25);
		frame.getContentPane().add(titulo);
	}

	private void initBtnPrim() {
		btnPrim = new JButton("Prim");
		btnPrim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPrim.setBounds(209, 71, 89, 23);
		frame.getContentPane().add(btnPrim);
	}

	private void initBtnKruskal() {
		btnKruskal = new JButton("Kruskal");
		btnKruskal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnKruskal.setBounds(359, 71, 89, 23);
		frame.getContentPane().add(btnKruskal);
	}

	private void initLabelTiempo() {
		labelTiempo = new JLabel("");
		labelTiempo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTiempo.setForeground(Color.GREEN);
		labelTiempo.setBounds(10, 11, 191, 33);
		frame.getContentPane().add(labelTiempo);
	}

	private void initLabelError() {
		labelError = new JLabel("");
		labelError.setHorizontalAlignment(SwingConstants.CENTER);
		labelError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelError.setForeground(Color.RED);
		labelError.setBounds(66, 105, 524, 25);
		frame.getContentPane().add(labelError);
	}

	private void initTabla() {
		this.tabla = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 141, 563, 250);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(tabla);
		this.tabla.setModel(model);
	}

	private void initBtnVolverMenu() {
		btnVolverMenu = new JButton("Menu");
		btnVolverMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVolverMenu.setBounds(276, 402, 115, 39);
		frame.getContentPane().add(btnVolverMenu);
	}

	private void llenarTabla() throws ComunicacionExcepcion {
		model = new DefaultTableModel();
		model.addColumn("Vertice");
		this.tabla.setModel(model);
		for (int i = 0; i < arbol.maxVecinos(); i++) {
			model.addColumn("Vecino >> Riesgo");
		}
		for (String vertice : arbol.vertices()) {
			Vector<String> row = new Vector<String>(arbol.maxVecinos() + 1);
			row.add(vertice);
			for (String vecino : arbol.vecinos(vertice)) {
				row.add(vecino + " >> " + redEspias.riesgo(vertice, vecino));
			}
			model.addRow(row);
		}
	}
}