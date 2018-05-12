package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import concecionarioDeCoches.Coche;
import concecionarioDeCoches.Color;
import concecionarioDeCoches.ColorNulo;
import concecionarioDeCoches.Concesionario;
import concecionarioDeCoches.Gestion;
import concecionarioDeCoches.IndiceErroneoException;
import concecionarioDeCoches.Modelo;
import concecionarioDeCoches.NoExisteCocheColor;
import concecionarioDeCoches.cocheIdenticoException;
import concecionarioDeCoches.colorNullException;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ListIterator;
import java.awt.event.ActionEvent;
import concecionarioDeCoches.Marca;
import concecionarioDeCoches.MatriculaNoValidaException;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.sound.midi.SysexMessage;
import javax.swing.ButtonGroup;

public class GestionarGui extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JTextField textField;
	Color color;
	Modelo modelo;
	Marca marca;
	static String matricula;
	JRadioButton rdbtnRojo;
	JRadioButton rdbtnPlata;
	JRadioButton rdbtnAzul;
	JComboBox<Modelo> comboBoxMo;
	JButton okButton;
	JLabel lblMarca_1;
	JComboBox<Marca> comboBoxMarca;
	JLabel lblColor;
	JLabel lblMatricula;
	JLabel lblMarca;
	JButton cancelButton;
	JButton button;
	JButton button_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	Concesionario concesionario = Gestion.concesionario;
	BuscarColor buscarColor;
	ListIterator<Coche> coches;
	Coche coche;
	// /**
	// * Launch the application.
	// */
	// public static void main(String[] args) {
	// try {
	// GestionarGui dialog = new GestionarGui();
	// dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	// dialog.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * Create the dialog.
	 */
	public GestionarGui() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblMarca = new JLabel("Modelo");
		lblMarca.setBounds(66, 112, 46, 14);
		contentPanel.add(lblMarca);
		{
			comboBoxMo = new JComboBox<Modelo>();

			comboBoxMo.setToolTipText("Coches");
			comboBoxMo.setBounds(174, 108, 118, 22);
			contentPanel.add(comboBoxMo);
		}

		rdbtnRojo = new JRadioButton("ROJO");
		buttonGroup.add(rdbtnRojo);

		rdbtnRojo.setBounds(78, 178, 109, 23);
		contentPanel.add(rdbtnRojo);

		rdbtnPlata = new JRadioButton("PLATA");
		buttonGroup.add(rdbtnPlata);

		rdbtnPlata.setBounds(185, 178, 97, 23);
		contentPanel.add(rdbtnPlata);

		rdbtnAzul = new JRadioButton("AZUL\r\n");
		buttonGroup.add(rdbtnAzul);

		rdbtnAzul.setBounds(284, 178, 109, 23);
		contentPanel.add(rdbtnAzul);

		lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(52, 24, 86, 14);
		contentPanel.add(lblMatricula);

		textField = new JTextField();

		textField.setBounds(192, 21, 127, 20);
		contentPanel.add(textField);
		textField.setColumns(10);

		lblColor = new JLabel("Color");
		lblColor.setBounds(52, 157, 46, 14);
		contentPanel.add(lblColor);

		lblMarca_1 = new JLabel("Marca");
		lblMarca_1.setBounds(66, 80, 46, 14);
		contentPanel.add(lblMarca_1);

		comboBoxMarca = new JComboBox<Marca>();
		comboBoxMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxMo.setModel(new DefaultComboBoxModel(getModelos((Marca) comboBoxMarca.getSelectedItem())));
			}
		});
		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

			}
		});

		comboBoxMarca.setModel(new DefaultComboBoxModel<Marca>(Marca.values()));

		comboBoxMarca.setBounds(174, 72, 118, 22);
		contentPanel.add(comboBoxMarca);

		button = new JButton("<");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cocheAnterior();
				} catch (NoExisteCocheColor e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (cocheIdenticoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (colorNullException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		button.setBounds(40, 208, 55, 23);
		contentPanel.add(button);

		button_1 = new JButton(">");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cocheSiguiente();
				} catch (NoExisteCocheColor e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (cocheIdenticoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (colorNullException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		button_1.setBounds(132, 208, 55, 23);
		contentPanel.add(button_1);

		// comboBoxMo.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("A\u00D1ADIR");
				

				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("SALIR\r\n");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						limpiar();
					}
				});

				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);

			}

		}

	}

	public void limpiar() {
		comboBoxMo.setSelectedItem(false);
		comboBoxMarca.setSelectedItem(false);
		rdbtnAzul.setSelected(false);
		rdbtnPlata.setSelected(false);
		rdbtnRojo.setSelected(false);
		textField.setText("");
	}

	public void cocheSiguiente() throws NoExisteCocheColor, cocheIdenticoException, colorNullException {
		if (coches.hasNext()) {
			coche = (Coche) coches.next();
			mostrarCoche(coche);
		}
	}

	public void cocheAnterior() throws NoExisteCocheColor, cocheIdenticoException, colorNullException {
		if (coches.hasPrevious()) {
			coche = (Coche) coches.previous();
			mostrarCoche(coche);
		}
	}

	public void comprobarBotones() throws NoExisteCocheColor, cocheIdenticoException, colorNullException {
		if (!coches.hasNext()) {
			button_1.setEnabled(false);
		}
		else
			button_1.setEnabled(true);
		
		if (!coches.hasPrevious()) {
			button.setEnabled(false);
		}
		else
			button.setEnabled(true);

	}

	public void mostrarCoche(Coche coche) throws NoExisteCocheColor, cocheIdenticoException, colorNullException {
		textField.setText(coche.getMatricula());
		comboBoxMo.setSelectedItem(coche.getModelo());
		comboBoxMarca.setSelectedItem(coche.getModelo().getMarca());
		comprobarBotones();
		if (coche.getColor() == Color.AZUL) {
			rdbtnAzul.setSelected(true);
			rdbtnPlata.setSelected(false);
			rdbtnRojo.setSelected(false);

		} else if (coche.getColor() == Color.PLATA) {
			rdbtnAzul.setSelected(false);
			rdbtnPlata.setSelected(true);
			rdbtnRojo.setSelected(false);

		} else {// if (coche.getColor() == Color.ROJO) {
			rdbtnAzul.setSelected(false);
			rdbtnPlata.setSelected(false);
			rdbtnRojo.setSelected(true);
			
		}
	}

	public Color getColor() throws colorNullException {
		if (rdbtnAzul.isSelected())
			return Color.AZUL;
		if (rdbtnPlata.isSelected())
			return Color.PLATA;
		if (rdbtnRojo.isSelected())
			return Color.ROJO;
		else
			throw new colorNullException("HOla cavesa");
	}

	public Object[] getModelos(Marca selectedItem) {
		ArrayList<Modelo> arrayListModelos = new ArrayList<Modelo>();
		for (Modelo modelo : Modelo.values()) {
			if (modelo.getMarca() == selectedItem)
				arrayListModelos.add(modelo);
		}
		return arrayListModelos.toArray();
	}
}
