package run;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import java.awt.SystemColor;

public class GUI{
	JFrame frm;
	private JTextField txtEnKey;
	private JTextField txtDeKey;

	public GUI(){
		initialize();
	}

	private void initialize(){
		frm = new JFrame();
		frm.setTitle("Group 4 - algorithm AES128");
		frm.setBounds(100, 100, 659, 641);
		frm.setLocationRelativeTo(null);
		frm.setResizable(false);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.getContentPane().setLayout(null);

		JPanel pEncryption = new JPanel();
		pEncryption.setBorder(new TitledBorder(null, "ENCRYPTION", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pEncryption.setBounds(10, 10, 624, 283);
		frm.getContentPane().add(pEncryption);
		pEncryption.setLayout(null);

		JLabel lblPlaintextEn = new JLabel("Plaintext:");
		lblPlaintextEn.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblPlaintextEn.setBounds(10, 25, 83, 13);
		pEncryption.add(lblPlaintextEn);

		JTextArea txtEncrypt = new JTextArea();
		txtEncrypt.setBorder(BorderFactory.createEtchedBorder());
		txtEncrypt.setLineWrap(true);
		txtEncrypt.setWrapStyleWord(true);
		txtEncrypt.setBounds(10, 44, 230, 194);
		pEncryption.add(txtEncrypt);

		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.setBorder(BorderFactory.createRaisedBevelBorder());
		btnEncrypt.setForeground(new Color(255, 69, 0));
		btnEncrypt.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEncrypt.setBounds(260, 103, 96, 26);
		pEncryption.add(btnEncrypt);

		JLabel lblKeyEn = new JLabel("Key Value");
		lblKeyEn.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblKeyEn.setForeground(Color.BLACK);
		lblKeyEn.setBounds(278, 41, 128, 13);
		pEncryption.add(lblKeyEn);

		txtEnKey = new JTextField();
		addPlaceholder(txtEnKey, "*Maximun 16 characters");
		txtEnKey.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtEnKey.setBounds(250, 58, 116, 33);
		pEncryption.add(txtEnKey);
		txtEnKey.setColumns(10);

		JLabel lblResult = new JLabel("Result:");
		lblResult.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblResult.setBounds(376, 25, 64, 13);
		pEncryption.add(lblResult);

		JTextArea txtEnRe = new JTextArea();
		txtEnRe.setEditable(false);
		txtEnRe.setBackground(SystemColor.control);
		txtEnRe.setBorder(BorderFactory.createEtchedBorder());
		txtEnRe.setLineWrap(true);
		txtEnRe.setWrapStyleWord(true);
		txtEnRe.setBounds(376, 44, 230, 194);
		pEncryption.add(txtEnRe);

		JLabel lblMessEn = new JLabel("");
		lblMessEn.setFont(new Font("SansSerif", Font.ITALIC, 10));
		lblMessEn.setBounds(10, 247, 363, 26);
		pEncryption.add(lblMessEn);
		lblMessEn.setVerticalAlignment(SwingConstants.TOP);

		JButton btnCopEnKey = new JButton("Copy Key");
		btnCopEnKey.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCopEnKey.setBounds(260, 139, 96, 26);
		pEncryption.add(btnCopEnKey);

		JButton btnCopEnRe = new JButton("Copy Result");
		btnCopEnRe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCopEnRe.setBounds(260, 175, 96, 26);
		pEncryption.add(btnCopEnRe);

		JButton btnClear1 = new JButton("Clear");
		btnClear1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnClear1.setBounds(260, 212, 96, 26);
		pEncryption.add(btnClear1);

		JPanel pDecryption = new JPanel();
		pDecryption.setBorder(new TitledBorder(null, "DECRYPTION", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pDecryption.setForeground(new Color(0, 0, 0));
		pDecryption.setLayout(null);
		pDecryption.setBounds(10, 307, 624, 287);
		frm.getContentPane().add(pDecryption);

		JLabel lblPlaintextDe = new JLabel("Plaintext:");
		lblPlaintextDe.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblPlaintextDe.setBounds(10, 25, 61, 13);
		pDecryption.add(lblPlaintextDe);

		JTextArea txtDecypt = new JTextArea();
		txtDecypt.setBorder(BorderFactory.createEtchedBorder());
		txtDecypt.setWrapStyleWord(true);
		txtDecypt.setLineWrap(true);
		txtDecypt.setBounds(10, 44, 230, 196);
		pDecryption.add(txtDecypt);

		JButton btnCopDeKey = new JButton("Copy Key");
		btnCopDeKey.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCopDeKey.setBounds(260, 141, 96, 26);
		pDecryption.add(btnCopDeKey);

		JLabel lblKeyDe = new JLabel("Key Value");
		lblKeyDe.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblKeyDe.setForeground(Color.BLACK);
		lblKeyDe.setBounds(282, 44, 128, 13);
		pDecryption.add(lblKeyDe);

		txtDeKey = new JTextField();
		addPlaceholder(txtDeKey, "*Maximun 16 characters");
		txtDeKey.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtDeKey.setColumns(10);
		txtDeKey.setBounds(250, 63, 116, 33);
		pDecryption.add(txtDeKey);

		JLabel lblResult_1 = new JLabel("Result:");
		lblResult_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblResult_1.setBounds(387, 25, 45, 13);
		pDecryption.add(lblResult_1);

		JTextArea txtDeRe = new JTextArea();
		txtDeRe.setBackground(SystemColor.control);
		txtDeRe.setEditable(false);
		txtDeRe.setBorder(BorderFactory.createEtchedBorder());
		txtDeRe.setWrapStyleWord(true);
		txtDeRe.setLineWrap(true);
		txtDeRe.setBounds(376, 44, 230, 196);
		pDecryption.add(txtDeRe);

		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.setBorder(BorderFactory.createRaisedBevelBorder());
		btnDecrypt.setForeground(new Color(0, 139, 139));
		btnDecrypt.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDecrypt.setBounds(260, 107, 96, 26);
		pDecryption.add(btnDecrypt);

		JButton btnCopDeRe = new JButton("Copy Result");
		btnCopDeRe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCopDeRe.setBounds(260, 178, 96, 26);
		pDecryption.add(btnCopDeRe);

		JLabel lblMessDe = new JLabel("");
		lblMessDe.setVerticalAlignment(SwingConstants.TOP);
		lblMessDe.setFont(new Font("SansSerif", Font.ITALIC, 10));
		lblMessDe.setBounds(10, 250, 363, 26);
		pDecryption.add(lblMessDe);

		JButton btnClear2 = new JButton("Clear");
		btnClear2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnClear2.setBounds(260, 214, 96, 26);
		pDecryption.add(btnClear2);
		btnDecrypt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			}
		});

		btnEncrypt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){
				String key = txtEnKey.getText().trim();
				String value = txtEncrypt.getText().trim();

				if(key.equals("") || value.equals("")){
					lblMessEn.setText("");
					lblMessDe.setText("");
					JOptionPane.showMessageDialog(null, "The plaintext or key value must be not null");
				}else if (key.length() > 16) 
					JOptionPane.showMessageDialog(null, " The length of the key is greater than 16");
				else{
					EncryptAES128 aesEncrypt128 = new EncryptAES128();
					String result = aesEncrypt128.encryptAES128(value, key);
					txtEnRe.setText(result);
					lblMessEn.setText("");
					lblMessDe.setText("");
					lblMessEn.setText("Encrypted!");
				}

			}
		});
		btnDecrypt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){
				String key = txtDeKey.getText().trim();
				String value = txtDecypt.getText().trim();

				if(key.equals("") || value.equals("")){
					lblMessEn.setText("");
					lblMessDe.setText("");
					JOptionPane.showMessageDialog(null, "The plaintext or key value must be not null");
				}else{
					try{
						DecryptAES128 aesDecrypt128 = new DecryptAES128();
						String result = aesDecrypt128.decryptAES128(value, key);
						txtDeRe.setText(result);
						lblMessEn.setText("");
						lblMessDe.setText("");
						lblMessDe.setText("Decrypted!");
					} catch(Exception e1){
						JOptionPane.showMessageDialog(null, "The plaintext or key value is not available");
					}

				}
			}
		});

		btnCopEnKey.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String key = txtEnKey.getText().trim();
				String placeHolder = "*Maximun 16 characters";
				if (key.equals("") || key.equals(placeHolder)) {
					lblMessEn.setText("");
					lblMessDe.setText("");
					JOptionPane.showMessageDialog(null, "The key value is null");
				}else{
					String textToCopy = txtEnKey.getText();
					StringSelection stringSelection = new StringSelection(textToCopy);
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(stringSelection, null);
					txtDeKey.setText("");
					txtDeKey.setForeground(Color.black);
					txtDeKey.setText(textToCopy);
					lblMessEn.setText("");
					lblMessDe.setText("");
					lblMessEn.setText("Copied!");
				}

			}
		});

		btnCopDeKey.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String key = txtDeKey.getText().trim();
				String placeHolder = "*Maximun 16 characters";
				if(key.equals("") || key.equals(placeHolder)){
					lblMessEn.setText("");
					lblMessDe.setText("");
					JOptionPane.showMessageDialog(null, "The key value is null");
				}else{
					String textToCopy = txtDeKey.getText();
					StringSelection stringSelection = new StringSelection(textToCopy);
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(stringSelection, null);
					txtEnKey.setText("");
					txtEnKey.setForeground(Color.black);
					txtEnKey.setText(textToCopy);
					lblMessEn.setText("");
					lblMessDe.setText("");
					lblMessDe.setText("Copied!");
				}

			}
		});

		btnCopEnRe.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String result = txtEnRe.getText().trim();
				if (result.equals("")) {
					lblMessEn.setText("");
					lblMessDe.setText("");
					JOptionPane.showMessageDialog(null, "The result value is null");
				}else{
					String textToCopy = txtEnRe.getText();
					StringSelection stringSelection = new StringSelection(textToCopy);
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(stringSelection, null);
					txtDecypt.setText("");
					txtDecypt.setText(textToCopy);
					lblMessEn.setText("");
					lblMessDe.setText("");
					lblMessEn.setText("Copied!");
				}

			}
		});

		btnCopDeRe.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String result = txtDeRe.getText().trim();
				if(result.equals("")) {
					lblMessEn.setText("");
					lblMessDe.setText("");
					JOptionPane.showMessageDialog(null, "The result value is null");
				} else{
					String textToCopy = txtDeRe.getText();
					StringSelection stringSelection = new StringSelection(textToCopy);
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(stringSelection, null);
					txtEncrypt.setText("");
					txtEncrypt.setText(textToCopy);
					lblMessEn.setText("");
					lblMessDe.setText("");
					lblMessDe.setText("Copied!");
				}

			}
		});

		btnClear1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtEncrypt.setText("");
				txtEnKey.setText("");
				txtEnRe.setText("");
				addPlaceholder(txtEnKey, "*Maximun 16 characters");

				lblMessEn.setText("");
				lblMessDe.setText("");
				lblMessEn.setText("Cleared!");
			}
		});

		btnClear2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtDecypt.setText("");
				txtDeKey.setText("");
				txtDeRe.setText("");

				addPlaceholder(txtDeKey, "*Maximun 16 characters");
				lblMessDe.setText("");
				lblMessEn.setText("");
				lblMessDe.setText("Cleared!");
			}
		});
	}

	// hàm thêm placeholder
	public static void addPlaceholder(JTextField text, String placeholder){
		text.setForeground(Color.lightGray);
		text.setText(placeholder);
		text.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e){
				if (text.getText().equals(placeholder)){
					text.setText("");
					text.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e){
				if (text.getText().isEmpty()) {
					text.setForeground(Color.lightGray);
					text.setText(placeholder);
				}
			}
		});
	}

}
