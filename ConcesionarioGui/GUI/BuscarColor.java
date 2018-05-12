package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import concecionarioDeCoches.Coche;
import concecionarioDeCoches.Color;
import concecionarioDeCoches.Gestion;
import concecionarioDeCoches.NoExisteCocheColor;
import concecionarioDeCoches.cocheIdenticoException;
import concecionarioDeCoches.colorNullException;

public class BuscarColor extends GestionarGui {

	/**
	 * Create the dialog.
	 */
	

	public BuscarColor() {
		setTitle("Coches por color");
		setBounds(100, 100, 450, 300);
		comboBoxMo.setEnabled(false);
		comboBoxMarca.setEnabled(false);
		lblMarca_1.setEnabled(false);
		lblMarca.setEnabled(false);
		textField.setEnabled(false);
		lblMatricula.setEnabled(false);

		

		
		
		okButton.setText("BUSCAR");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					
						try {
							coches= Gestion.buscarCocheColores(getColor()).listIterator();
							coche=coches.next();
							mostrarCoche(coche);
						} catch (NoExisteCocheColor e) {
							JOptionPane.showMessageDialog(getContentPane(),
								    "¡¡ERROR!! EL coche no existe");
						} catch (cocheIdenticoException e) {
							JOptionPane.showMessageDialog(getContentPane(),
								    "¡¡ERROR!! El coche ya existe");
						} catch (colorNullException e) {
							JOptionPane.showMessageDialog(getContentPane(),
								    "¡¡ERROR!! Color vacio");
						}
					
				
			}
		});
	}
	
}
