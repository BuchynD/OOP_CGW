package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.AnyData;
import model.Group;
import model.Specialty;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgGroup extends JDialog implements IDlg {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldCuratorName;
	private JTextField textFieldCountStudGroup;
	
	private AnyData object;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgGroup dialog = new DlgGroup();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgGroup() {
		setTitle("Group");
		setModal(true);
		setBounds(100, 100, 450, 300);
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
			JLabel lblNewLabel = new JLabel("Curator name");
			contentPanel.add(lblNewLabel);
		}
		{
			textFieldCuratorName = new JTextField();
			contentPanel.add(textFieldCuratorName);
			textFieldCuratorName.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Count of students");
			contentPanel.add(lblNewLabel_1);
		}
		{
			textFieldCountStudGroup = new JTextField();
			contentPanel.add(textFieldCountStudGroup);
			textFieldCountStudGroup.setColumns(10);
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
		Group grp = (Group) obj;
		textFieldName.setText(grp.getName());
		textFieldCuratorName.setText(grp.getCuratorName());
		textFieldCountStudGroup.setText(
				Integer.toString(grp.getCountStud()));
	}
	
	@Override
	public void clear() {
		textFieldName.setText("");
		textFieldCuratorName.setText("");
		textFieldCountStudGroup.setText("");
	}
	
	@Override
	public AnyData getObject() {
		return object;
	}
	
	private void onOk() {
		String name = textFieldName.getText();
		String curatorName = textFieldCuratorName.getText();
		int countStud = Integer.parseInt(
				textFieldCountStudGroup.getText());
		object = new Group(name, curatorName, countStud);
		setVisible(false);
	}
	
	private void onCancel() {
		object = null;
		setVisible(false);
	}
	public JButton getOkButton() {
		return okButton;
	}
	public JButton getCancelButton() {
		return cancelButton;
	}
}
