package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.Directorio;
import model.DirectorioTableModel;

public class CensoFrame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JButton btnAgregarPersona;
	private JButton btnAbrirFichero;
	private JButton btnGuardarFichero;
	private JTable tabla;

	private DirectorioTableModel dtm;
	

	/**
	 * Create the frame.
	 */
	public CensoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		dtm = new DirectorioTableModel();
		tabla = new JTable(dtm);
		tabla.setBorder(null);
		
		
		scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(0, 0, 800, 533);
		contentPane.add(scrollPane);
		
		panel_1 = new JPanel();
		panel_1.setBounds(5, 534, 790, 39);
		contentPane.add(panel_1);
		
		btnAgregarPersona = new JButton("Agregar Persona");
		btnAgregarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonaDialog pDialog = new PersonaDialog(dtm);
				dtm.getContext(pDialog);
				pDialog.setModal(true);
				pDialog.setVisible(true);
			}
		});
		panel_1.add(btnAgregarPersona);
		
		btnAbrirFichero = new JButton("Abrir Fichero");
		btnAbrirFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnAbrirFichero);
		
		btnGuardarFichero = new JButton("Guardar Fichero");
		panel_1.add(btnGuardarFichero);
	}
}
