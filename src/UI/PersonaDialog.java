package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.DirectorioTableModel;
import model.TipoOpcion;
import model.Persona;
import javax.swing.JButton;

public class PersonaDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5547429223011237733L;
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
	 * @param opcion 
	 * @param dir 
	 */
	@SuppressWarnings("incomplete-switch")
	public PersonaDialog(DirectorioTableModel dtm, TipoOpcion opcion) {
		this.dtm = dtm;
		setBounds(300, 300, 569, 300);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JLabel lblCodigo = new JLabel("Codigo");
				lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
				panel.add(lblCodigo);
			}
			{
				textFieldCodigo = new JTextField();
				panel.add(textFieldCodigo);
				textFieldCodigo.setColumns(10);
			}
			{
				JLabel lblNombre = new JLabel("Nombre");
				lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
				panel.add(lblNombre);
			}
			{
				textFieldNombre = new JTextField();
				textFieldNombre.setColumns(10);
				panel.add(textFieldNombre);
			}
			{
				JLabel lblEdad = new JLabel("Edad");
				lblEdad.setHorizontalAlignment(SwingConstants.RIGHT);
				panel.add(lblEdad);
			}
			{
				textFieldEdad = new JTextField();
				textFieldEdad.setColumns(10);
				panel.add(textFieldEdad);
			}
			{
				JLabel lblDireccion = new JLabel("Direccion");
				lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
				panel.add(lblDireccion);
			}
			{
				textFieldDireccion = new JTextField();
				textFieldDireccion.setColumns(10);
				panel.add(textFieldDireccion);
			}
			{
				JLabel lblCodigoPostal = new JLabel("Codigo Postal");
				lblCodigoPostal.setHorizontalAlignment(SwingConstants.RIGHT);
				panel.add(lblCodigoPostal);
			}
			{
				textFieldCPostal = new JTextField();
				panel.add(textFieldCPostal);
				textFieldCPostal.setColumns(10);
			}
			{
				JLabel lblPoblacin = new JLabel("Población");
				lblPoblacin.setHorizontalAlignment(SwingConstants.RIGHT);
				panel.add(lblPoblacin);
			}
			{
				textFieldPoblacion = new JTextField();
				textFieldPoblacion.setColumns(10);
				panel.add(textFieldPoblacion);
			}
			{
				JLabel lblProvincia = new JLabel("Provincia");
				lblProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
				panel.add(lblProvincia);
			}
			{
				textFieldProvincia = new JTextField();
				textFieldProvincia.setColumns(10);
				panel.add(textFieldProvincia);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				panel.add(btnCancelar);
			}
			{
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						agregarPersona();
					}
				});
				panel.add(btnAceptar);
			}
			switch (opcion) {
				case AGREGAR:
					textFieldCodigo.setEnabled(false);
					break;
			}
		}
	}
	
	protected void agregarPersona() {
		dtm.agregarPersona(textFieldNombre.getText(), Integer.valueOf(textFieldEdad.getText()), 
				textFieldDireccion.getText(), textFieldCPostal.getText(), 
				textFieldPoblacion.getText(), textFieldProvincia.getText());
		/* dtm.fireTableDataChanged(); */
		this.setVisible(false);
	}

	private void limpiaFormulario() {
		textFieldCodigo.setText("");
		textFieldDireccion.setText("");
		textFieldEdad.setText("");
		textFieldNombre.setText("");
		textFieldPoblacion.setText("");
		textFieldProvincia.setText("");
	}

	public void showPersona(Persona p) {
		limpiaFormulario();
		textFieldCodigo.setText(String.valueOf(p.getCodigo()));
		textFieldNombre.setText(p.getNombre());
		textFieldEdad.setText(String.valueOf(p.getEdad()));
		textFieldDireccion.setText(p.getDireccion());
		textFieldCPostal.setText(p.getCodigoPostal());
		textFieldPoblacion.setText(p.getPoblacion());
		textFieldProvincia.setText(p.getProvincia());
		
	}
}
