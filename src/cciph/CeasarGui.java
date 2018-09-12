package cciph;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class CeasarGui {

	private JFrame frmCeasarsCipher;
	private JTextField txtKey;



	/**
	 * Create the application.
	 */
	public CeasarGui(Cipher cip) {
		initialize(cip);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Cipher cip) {
		
		frmCeasarsCipher = new JFrame();
		frmCeasarsCipher.setTitle("Ceasar's Cipher - Encrypt/Decrypt");
		frmCeasarsCipher.setResizable(false);
		frmCeasarsCipher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCeasarsCipher.setForeground(Color.DARK_GRAY);
		frmCeasarsCipher.getContentPane().setForeground(Color.WHITE);
		frmCeasarsCipher.setBounds(100, 100, 756, 451);
		frmCeasarsCipher.getContentPane().setLayout(null);
		
		txtKey = new JTextField();
		txtKey.setToolTipText("Enter encryption key, or leave blank to let me guess!");
		txtKey.setBounds(333, 198, 86, 20);
		frmCeasarsCipher.getContentPane().add(txtKey);
		txtKey.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Encrypted Text");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(429, 11, 309, 27);
		frmCeasarsCipher.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Decrypted Text");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 309, 27);
		frmCeasarsCipher.getContentPane().add(lblNewLabel_1);
		
		JTextPane txtPnDe = new JTextPane();
		JScrollPane jsp1 = new JScrollPane(txtPnDe);
		jsp1.setBounds(10, 49, 310, 356);
		frmCeasarsCipher.getContentPane().add(jsp1);
		
		JTextPane txtPnEn = new JTextPane();
		JScrollPane jsp2= new JScrollPane(txtPnEn);
		jsp2.setBounds(429, 49, 309, 356);
		frmCeasarsCipher.getContentPane().add(jsp2);
		
		JButton btnNewButton_1 = new JButton("Encrypt");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = txtPnDe.getText().toLowerCase();
				try {
					int key = Integer.parseInt(txtKey.getText()) % 26;
					txtPnEn.setText(cip.cipher(txt, key));
				}catch(NumberFormatException e1) {
				    JOptionPane.showMessageDialog(null, "You need to enter a valid integer key value to encrypt.", "Error",
                            JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton_1.setBounds(330, 163, 89, 23);
		frmCeasarsCipher.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Decrypt");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = txtPnEn.getText();
				try {
					int key = Integer.parseInt(txtKey.getText().toLowerCase()) % 26;
					txtPnDe.setText(cip.decipher(txt, key));
				} catch (NumberFormatException e1) {
					txtPnDe.setText(cip.freqDecipher(txt));
				}
			}
		});
		btnNewButton_2.setBounds(330, 231, 89, 23);
		frmCeasarsCipher.getContentPane().add(btnNewButton_2);
		frmCeasarsCipher.setVisible(true);
	}
}
