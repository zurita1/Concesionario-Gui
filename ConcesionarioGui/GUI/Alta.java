package GUI;

import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import concecionarioDeCoches.Color;
import concecionarioDeCoches.Concesionario;
import concecionarioDeCoches.Gestion;
import concecionarioDeCoches.Marca;
import concecionarioDeCoches.MatriculaNoValidaException;
import concecionarioDeCoches.Modelo;
import concecionarioDeCoches.cocheIdenticoException;
import concecionarioDeCoches.colorNullException;
import concecionarioDeCoches.modeloNullException;

public class Alta extends GestionarGui {


	/**
	 * Create the dialog.
	 */
	public Alta() {
		setTitle("ALTA\r\n");
		setBounds(100, 100, 450, 300);
		button.setVisible(false);
		button_1.setVisible(false);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Gestion.alta(textField.getText(), getColor(), (Modelo) comboBoxMo.getSelectedItem());
				} catch (colorNullException e1) {
					JOptionPane.showMessageDialog(getContentPane(), "　ERROR!! Introduce un color");
				} catch (modeloNullException e1) {
					JOptionPane.showMessageDialog(getContentPane(), "　ERROR!!Introduce un modelo");
				} catch (MatriculaNoValidaException e1) {
					JOptionPane.showMessageDialog(getContentPane(), "　ERROR!! Matricula no valida");
				} catch (cocheIdenticoException e1) {
					JOptionPane.showMessageDialog(getContentPane(), "　ERROR!! El coche ya existe");
				}

			}
		});

	}
}
