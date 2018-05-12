package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import concecionarioDeCoches.Coche;
import concecionarioDeCoches.Gestion;
import concecionarioDeCoches.IndiceErroneoException;
import concecionarioDeCoches.MatriculaNoValidaException;
import concecionarioDeCoches.NoExisteCocheColor;
import concecionarioDeCoches.cocheIdenticoException;
import concecionarioDeCoches.colorNullException;

public class BuscarMatricula extends GestionarGui {

	/**
	 * Create the dialog.
	 */
	public BuscarMatricula() {
		setTitle("Coches por matricula");
		setBounds(100, 100, 450, 300);
		comboBoxMo.setEnabled(false);
		comboBoxMarca.setEnabled(false);
		lblMarca_1.setEnabled(false);
		lblMarca.setEnabled(false);
		rdbtnRojo.setEnabled(false);
		rdbtnPlata.setEnabled(false);
		rdbtnAzul.setEnabled(false);
		lblColor.setEnabled(false);
		button.setVisible(false);
		button_1.setVisible(false);

		okButton.setText("BUSCAR");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}

			/**
			 * 
			 */
			private void buscar() {
				
					// Coche coche=Gestion.getCoche(textField.getText());
					try {
						coche=Gestion.getCoche(textField.getText());
						mostrarCoche(coche);
					} catch (NoExisteCocheColor e) {
						JOptionPane.showMessageDialog(getContentPane(),
							    "　ERROR!! No existe ese color");
					} catch (cocheIdenticoException e) {
						JOptionPane.showMessageDialog(getContentPane(),
							    "　ERROR!! EL coche ya existe");
					} catch (colorNullException e) {
						JOptionPane.showMessageDialog(getContentPane(),
							    "　ERROR!!No has elegido color");
					} catch (MatriculaNoValidaException e) {
						JOptionPane.showMessageDialog(getContentPane(),
							    "　ERROR!! Matricula no valids");
					} catch (IndiceErroneoException e) {
						JOptionPane.showMessageDialog(getContentPane(),
							    "　ERROR!!");
					}

			}
		});

	}

}
