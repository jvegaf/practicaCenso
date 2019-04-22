package UI;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.DirectorioTableModel;
import model.TipoOpcion;

public class CensoFrame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tabla;

	private DirectorioTableModel dtm;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmAbrirFichero;
	private JMenuItem mntmGuardarFichero;
	private JMenu mnImportar;
	private JMenuItem mntmImportarXml;
	private JMenu mnExportar;
	private JMenuItem mntmExportarXml;
	private JMenuItem mntmExportarHtml;
	private JMenuItem mntmExportarCsv;
	private JMenu mnEditar;
	private JMenuItem mntmAgregarPersona;
	private JMenuItem mntmBuscar;
	private JMenuItem mntmGuardarComo;
	private JMenuItem mntmModificar;
	private JMenuItem mntmBorrar;
	private JMenuItem mntmAbrirReciente;
	private JMenuItem mntmSalir;
	private File fichero;

	/**
	 * Create the frame.
	 */
	public CensoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmAbrirFichero = new JMenuItem("Abrir");
		mntmAbrirFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File fich = selectFichero();
				if (fich!= null) {
					try {
						getData(fich);
						fichero = fich;
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		mnArchivo.add(mntmAbrirFichero);
		
		mntmGuardarFichero = new JMenuItem("Guardar");
		mntmGuardarFichero.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fichero == null) {
					fichero = selectParaGuardar();
				}
				try {
					dtm.guardaEnFichero(fichero);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		mntmAbrirReciente = new JMenuItem("Abrir reciente");
		mnArchivo.add(mntmAbrirReciente);
		mnArchivo.add(mntmGuardarFichero);
		
		mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fichero = selectParaGuardar();
				try {
					dtm.guardaEnFichero(fichero);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		mnArchivo.add(mntmGuardarComo);
		
		mnImportar = new JMenu("Importar");
		mnArchivo.add(mnImportar);
		
		mntmImportarXml = new JMenuItem("Importar XML");
		mntmImportarXml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importarXML();
			}
		});
		mnImportar.add(mntmImportarXml);
		
		mnExportar = new JMenu("Exportar");
		mnArchivo.add(mnExportar);
		
		mntmExportarXml = new JMenuItem("Exportar XML");
		mnExportar.add(mntmExportarXml);
		
		mntmExportarHtml = new JMenuItem("Exportar HTML");
		mnExportar.add(mntmExportarHtml);
		
		mntmExportarCsv = new JMenuItem("Exportar CSV");
		mnExportar.add(mntmExportarCsv);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnArchivo.add(mntmSalir);
		
		mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		
		mntmAgregarPersona = new JMenuItem("Agregar");
		mntmAgregarPersona.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PersonaDialog dialog = new PersonaDialog(dtm, TipoOpcion.AGREGAR);
				dialog.setModalityType(ModalityType.APPLICATION_MODAL);
				dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		} );
		mnEditar.add(mntmAgregarPersona);
		
		mntmBuscar = new JMenuItem("Buscar");
		mnEditar.add(mntmBuscar);
		
		mntmModificar = new JMenuItem("Modificar");
		mnEditar.add(mntmModificar);
		
		mntmBorrar = new JMenuItem("Borrar");
		mnEditar.add(mntmBorrar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		dtm = new DirectorioTableModel();
		
		
		tabla = new JTable(dtm);
		tabla.setBorder(null);
		tabla.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				JTable table = (JTable)mouseEvent.getSource();
				Point point = mouseEvent.getPoint();
				int row = table.rowAtPoint(point);
				if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
					PersonaDialog dialog = new PersonaDialog(dtm, TipoOpcion.MODIFICAR);
					dialog.showPersona(dtm.getPersona(row));
					dialog.setModalityType(ModalityType.APPLICATION_MODAL);
					dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
			}
		});
		scrollPane = new JScrollPane(tabla);
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}


	protected void importarXML() {
		File ficheroXML = selectFichero();
		if(ficheroXML != null) {
			dtm.importarXML(ficheroXML);
		}
		
	}
	
	protected File selectParaGuardar() {
		JFileChooser jfc = new JFileChooser();
		int sel = jfc.showSaveDialog(mnArchivo);
		if (sel == JFileChooser.APPROVE_OPTION) {
			return jfc.getSelectedFile();
		}
		return null;
	}


	protected File selectFichero() {
		JFileChooser jfc = new JFileChooser();
		int sel = jfc.showOpenDialog(mnArchivo);
		if(sel == JFileChooser.APPROVE_OPTION) {
			return jfc.getSelectedFile();
		}
		return null;
	}
	
	protected void getData(File fichero) throws IOException {		
		dtm.getDataDeFichero(fichero);
	}
}
