package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.AnyData;
import model.DeansOffice;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import java.awt.TextField;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDeansOffice extends JDialog implements IDlg{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldDeanName;
	private JButton okButton;
	private JButton cancelButton;
	
	private AnyData object;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDeansOffice dialog = new DlgDeansOffice();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDeansOffice() {
		setModal(true);
		setTitle("Dean's office");
		setBounds(100, 100, 390, 155);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblName = new JLabel("Name");
			contentPanel.add(lblName);
		}
		{
			textFieldName = new JTextField();
			textFieldName.setName("");
			textFieldName.setBorder(UIManager.getBorder("TextField.border"));
			textFieldName.setToolTipText("Name");
			textFieldName.setText("Name");
			contentPanel.add(textFieldName);
			textFieldName.setColumns(10);
		}
		{
			JLabel lblDeanName = new JLabel("Dean's name");
			contentPanel.add(lblDeanName);
		}
		{
			textFieldDeanName = new JTextField();
			textFieldDeanName.setText("Dean's name");
			contentPanel.add(textFieldDeanName);
			textFieldDeanName.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onOk();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onCancel();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JButton getOkButton() {
		return okButton;
	}
	public JButton getCancelButton() {
		return cancelButton;
	}
	
	@Override
	public void setEditable(boolean b) {
		for (Component c : contentPanel.getComponents()) {
			c.setEnabled(b);
		}
		
		okButton.setVisible(b);
		if (b)
			cancelButton.setText("Cancel");
		else
			cancelButton.setText("Exit");
	}

	@Override
	public void setData(AnyData obj) {
		DeansOffice deanO = (DeansOffice) obj;
		textFieldName.setText(deanO.getName());
		textFieldDeanName.setText(deanO.getDeanName());
	}

	@Override
	public void clear() {
		textFieldName.setText("");
		textFieldDeanName.setText("");
	}

	@Override
	public AnyData getObject() {
		return object;
	}
	
	private void onOk() {
		String name = textFieldName.getText();
		String deanName = textFieldDeanName.getText();
		object = new DeansOffice(name, deanName);
		setVisible(false);
	}
	
	private void onCancel() {
		object = null;
		setVisible(false);
	}
}
