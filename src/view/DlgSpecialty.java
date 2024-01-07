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
import model.Specialty;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgSpecialty extends JDialog implements IDlg{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldSpecCode;
	private JTextField textFieldCountStud;
	private JButton okButton;
	private JButton cancelButton;
	
	private AnyData object;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgSpecialty dialog = new DlgSpecialty();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgSpecialty() {
		setModal(true);
		setTitle("Specialty");
		setBounds(100, 100, 450, 218);
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
			contentPanel.add(textFieldName);
			textFieldName.setColumns(10);
		}
		{
			JLabel lblSpecCode = new JLabel("Specialty code");
			contentPanel.add(lblSpecCode);
		}
		{
			textFieldSpecCode = new JTextField();
			contentPanel.add(textFieldSpecCode);
			textFieldSpecCode.setColumns(10);
		}
		{
			JLabel lblCountStudSpec = new JLabel("Count of students");
			contentPanel.add(lblCountStudSpec);
		}
		{
			textFieldCountStud = new JTextField();
			contentPanel.add(textFieldCountStud);
			textFieldCountStud.setColumns(10);
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
		Specialty spec = (Specialty) obj;
		textFieldName.setText(spec.getName());
		textFieldSpecCode.setText(spec.getSpecCode());
		textFieldCountStud.setText(
				Integer.toString(spec.getCountStud()));
	}
	
	@Override
	public void clear() {
		textFieldName.setText("");
		textFieldSpecCode.setText("");
		textFieldCountStud.setText("");
	}
	
	@Override
	public AnyData getObject() {
		return object;
	}
	
	private void onOk() {
		String name = textFieldName.getText();
		String specCode = textFieldSpecCode.getText();
		int countStud = Integer.parseInt(
				textFieldCountStud.getText());
		object = new Specialty(name, specCode, countStud);
		setVisible(false);
	}
	
	private void onCancel() {
		object = null;
		setVisible(false);
	}
}
