package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import concecionarioDeCoches.CocheNoExisteException;
import concecionarioDeCoches.Gestion;
import concecionarioDeCoches.MatriculaNoValidaException;

public class Baja extends GestionarGui {

	/**
	 * Create the dialog.
	 */
	public Baja() {
		setTitle("Baja");
		setBounds(100, 100, 450, 300);
		comboBoxMo.setVisible(false);
		comboBoxMarca.setVisible(false);
		rdbtnRojo.setVisible(false);
		rdbtnPlata.setVisible(false);
		rdbtnAzul.setVisible(false);
		lblMarca_1.setVisible(false);
		lblColor.setVisible(false);
		lblMarca.setVisible(false);
		button.setVisible(false);
		button_1.setVisible(false);

		okButton.setText("ELIMINAR");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Gestion.baja(textField.getText());
					JOptionPane.showMessageDialog(getContentPane(), "Coche eliminado con exito");
				} catch (MatriculaNoValidaException e1) {
					JOptionPane.showMessageDialog(getContentPane(),
						    "¡¡ERROR!! Matricula no valids");
				} catch (CocheNoExisteException e1) {
					JOptionPane.showMessageDialog(getContentPane(),
						    "¡¡ERROR!! El coche no existe");
				}
			}
		});
	}
}