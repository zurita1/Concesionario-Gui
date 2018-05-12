package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import concecionarioDeCoches.Concesionario;
import concecionarioDeCoches.Fichero;
import concecionarioDeCoches.Gestion;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.InputEvent;

public class Principal extends JFrame {

	private JFrame frame;
	private GestionarGui gestion = new GestionarGui();
	private Alta alta = new Alta();
	private Baja baja = new Baja();
	private BuscarColor CocheColor = new BuscarColor();
	private BuscarMatricula CocheMatricula = new BuscarMatricula();
	private MostrarConcesionario mostrarConcesionario = new MostrarConcesionario();
	private JFileChooser fileChooser = new JFileChooser();

	private Fichero fichero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {

		setTitle("Concesionario coches");
		getContentPane().setLayout(null);
		setBounds(100, 100, 432, 300);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 432, 21);
		getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					Gestion.nuevo(Gestion.concesionario, (File) Gestion.fichero.getFile());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNuevo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".obj", "obj"));
				int returnValue = fileChooser.showDialog(getContentPane(), "Abrir Fichero");
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					try {
						Gestion.abrir(fileChooser.getSelectedFile());
					} catch (ClassNotFoundException | IOException e) {
						JOptionPane.showMessageDialog(getContentPane(), "Error a abrir el archivo");
					}

				}
			}
		});
		mnNewMenu.add(mntmAbrir);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if (Fichero.getFile() == null)
						try {
							Gestion.guardarComo();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					else
						try {
							Gestion.guardar((File) Fichero.getFile());
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
			}
		});
		mnNewMenu.add(mntmGuardar);

		JMenuItem mntmGuardarcomo = new JMenuItem("GuardarComo");
		mntmGuardarcomo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".obj", "obj"));
				int returnValue = fileChooser.showDialog(getContentPane(), "Guardar");
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					if (file.exists()) {
						int option = JOptionPane.showOptionDialog(getContentPane(),
								"Hay un archivo con el mismo nombre, ¿Desea sobreescribirlo?", "Guardar",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
								new String[] { "SI", "NO" }, null);
						if (option == 0) {
							Fichero.setFile(file);
							try {
								Gestion.guardar(file);
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					} else {
						Fichero.setFile(file);
						try {
							Gestion.guardar(file);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});

		mnNewMenu.add(mntmGuardarcomo);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnNewMenu.add(mntmSalir);

		JMenu mnCoche = new JMenu("Coche");
		menuBar.add(mnCoche);

		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAlta.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				alta.setVisible(true);
			}
		});
		mnCoche.add(mntmAlta);

		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mntmBaja.setSelected(true);
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baja.setVisible(true);
			}
		});
		mnCoche.add(mntmBaja);

		JMenuItem mntmMostrarConcesionario = new JMenuItem("Mostrar Concesionario");
		mntmMostrarConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Gestion.concesionario.isEmpty()) {
					mostrarConcesionario.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(getContentPane(), "¡¡ERROR!! el concesionario esta vacio");
				}

			}
		});
		mnCoche.add(mntmMostrarConcesionario);

		JMenu mnBuscar = new JMenu("Buscar");
		menuBar.add(mnBuscar);

		JMenuItem mntmCochesPorMatricula = new JMenuItem("Coches por matricula");
		mntmCochesPorMatricula.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mntmCochesPorMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CocheMatricula.setVisible(true);
			}
		});
		mnBuscar.add(mntmCochesPorMatricula);

		JMenuItem mntmCochesPorColor = new JMenuItem("Coches por color");
		mntmCochesPorColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mntmCochesPorColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CocheColor.setVisible(true);
			}
		});
		mnBuscar.add(mntmCochesPorColor);

		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mnAyuda.add(mntmAyuda);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de..");
		mnAyuda.add(mntmAcercaDe);
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Concesionario de Coches");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
