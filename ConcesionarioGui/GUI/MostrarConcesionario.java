package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import concecionarioDeCoches.NoExisteCocheColor;
import concecionarioDeCoches.cocheIdenticoException;
import concecionarioDeCoches.colorNullException;

public class MostrarConcesionario extends GestionarGui {

	/**
	 * Create the dialog.
	 */
	public MostrarConcesionario() {
		setTitle("Coches que hay en el concesionario");
		setBounds(100, 100, 450, 300);
		comboBoxMo.setEnabled(false);
		comboBoxMarca.setEnabled(false);
		lblMarca_1.setEnabled(false);
		lblMarca.setEnabled(false);
		textField.setEnabled(false);
		lblMatricula.setEnabled(false);
		rdbtnRojo.setEnabled(false);
		rdbtnPlata.setEnabled(false);
		rdbtnAzul.setEnabled(false);

		okButton.setText("Mostrar");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					coches=concesionario.listIterator();
					coche=coches.next();
					try {
						mostrarCoche(coche);
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

	}
}
