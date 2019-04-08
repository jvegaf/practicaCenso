package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Directorio;
import model.DirectorioTableModel;
import model.Persona;

public class PersonaDialog extends JDialog {
	private JTextField textFieldCodigo;
	private JTextField textFieldNombre;
	private JTextField textFieldEdad;
	private JTextField textFieldDireccion;
	private JTextField textFieldPoblacion;
	private JTextField textFieldProvincia;
	private JTextField textFieldCPostal;
	private DirectorioTableModel dtm;

	/**
	 * Create the dialog.
	 * @param dir 
	 */
	public PersonaDialog(DirectorioTableModel dtm) {
		this.dtm = dtm;
		setBounds(300, 300, 569, 300);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.EAST);
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JButton btnAlta = new JButton("Alta");
				btnAlta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						agregarPersona(dtm, textFieldNombre.getText(), textFieldEdad.getText(), textFieldDireccion.getText(), textFieldCPostal.getText(),textFieldPoblacion.getText(), textFieldProvincia.getText());
					}
				});
				panel.add(btnAlta);
			}
			{
				JButton btnBaja = new JButton("Baja");
				panel.add(btnBaja);
			}
			{
				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						buscar();
					}
				});
				panel.add(btnBuscar);
			}
			{
				JButton btnLimpiar = new JButton("Limpiar");
				btnLimpiar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						limpiaFormulario();
					}
				});
				panel.add(btnLimpiar);
			}
			{
				JButton btnModificar = new JButton("Modificar");
				panel.add(btnModificar);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.SOUTH);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton button = new JButton("|<");
				panel.add(button);
			}
			{
				JButton button = new JButton("<");
				panel.add(button);
			}
			{
				JButton button = new JButton(">");
				panel.add(button);
			}
			{
				JButton button = new JButton(">|");
				panel.add(button);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JLabel lblCodigo = new JLabel("Codigo");
				panel.add(lblCodigo);
			}
			{
				textFieldCodigo = new JTextField();
				panel.add(textFieldCodigo);
				textFieldCodigo.setColumns(10);
			}
			{
				JLabel lblNombre = new JLabel("Nombre");
				panel.add(lblNombre);
			}
			{
				textFieldNombre = new JTextField();
				textFieldNombre.setColumns(10);
				panel.add(textFieldNombre);
			}
			{
				JLabel lblEdad = new JLabel("Edad");
				panel.add(lblEdad);
			}
			{
				textFieldEdad = new JTextField();
				textFieldEdad.setColumns(10);
				panel.add(textFieldEdad);
			}
			{
				JLabel lblDireccion = new JLabel("Direccion");
				panel.add(lblDireccion);
			}
			{
				textFieldDireccion = new JTextField();
				textFieldDireccion.setColumns(10);
				panel.add(textFieldDireccion);
			}
			{
				JLabel lblCodigoPostal = new JLabel("Codigo Postal");
				panel.add(lblCodigoPostal);
			}
			{
				textFieldCPostal = new JTextField();
				panel.add(textFieldCPostal);
				textFieldCPostal.setColumns(10);
			}
			{
				JLabel lblPoblacin = new JLabel("Población");
				panel.add(lblPoblacin);
			}
			{
				textFieldPoblacion = new JTextField();
				textFieldPoblacion.setColumns(10);
				panel.add(textFieldPoblacion);
			}
			{
				JLabel lblProvincia = new JLabel("Provincia");
				panel.add(lblProvincia);
			}
			{
				textFieldProvincia = new JTextField();
				textFieldProvincia.setColumns(10);
				panel.add(textFieldProvincia);
			}
		}
	}
	
	private void limpiaFormulario() {
		textFieldCodigo.setText("");
		textFieldDireccion.setText("");
		textFieldEdad.setText("");
		textFieldNombre.setText("");
		textFieldPoblacion.setText("");
		textFieldProvincia.setText("");
	}
	
	private void agregarPersona(DirectorioTableModel dtm, String nom, String edad, String dir, String codPos, String pob, String prov) {
		int ed = Integer.parseInt(edad);
		int cp = Integer.parseInt(codPos);
		dtm.agregarPersona(nom, ed, dir, cp, pob, prov);
		dtm.fireTableDataChanged();
		this.dispose();
	}
	
	//TODO 
	private void buscar(){
		HashMap<String, String> datos = new HashMap<>();
		
		datos.put("codigo", textFieldCodigo.getText());
		datos.put("nombre", textFieldNombre.getText());
		datos.put("edad", textFieldEdad.getText());
		datos.put("direccion", textFieldDireccion.getText());
		datos.put("codigoPostal", textFieldCPostal.getText());
		datos.put("poblacion", textFieldPoblacion.getText());
		datos.put("provincia", textFieldProvincia.getText());
	
		dtm.busca(datos);
	}

	public void showPersona(Persona p) {
		limpiaFormulario();
		textFieldCodigo.setText(String.valueOf(p.getCodigo()));
		textFieldNombre.setText(p.getNombre());
		textFieldEdad.setText(String.valueOf(p.getEdad()));
		textFieldDireccion.setText(p.getDireccion());
		textFieldCPostal.setText(String.valueOf(p.getCodigoPostal()));
		textFieldPoblacion.setText(p.getPoblacion());
		textFieldProvincia.setText(p.getProvincia());
		
	}
}
