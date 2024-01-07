package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.AnyData;
import model.DeansOffice;
import model.Student;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgStudent extends JDialog implements IDlg {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldAvgScore;
	private JTextField textFieldBirthDate;
	private JButton okButton;
	private JButton cancelButton;
	
	private AnyData object;
	private DateTimeFormatter dtf =
			DateTimeFormatter.ofPattern("dd-MM-yyyy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgStudent dialog = new DlgStudent();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgStudent() {
		setTitle("Student");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblNewLabel = new JLabel("Name");
			contentPanel.add(lblNewLabel);
		}
		{
			textFieldName = new JTextField();
			contentPanel.add(textFieldName);
			textFieldName.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Average score");
			contentPanel.add(lblNewLabel_1);
		}
		{
			textFieldAvgScore = new JTextField();
			contentPanel.add(textFieldAvgScore);
			textFieldAvgScore.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Birth date");
			contentPanel.add(lblNewLabel_2);
		}
		{
			textFieldBirthDate = new JTextField();
			contentPanel.add(textFieldBirthDate);
			textFieldBirthDate.setColumns(10);
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
		Student stud = (Student) obj;
		textFieldName.setText(stud.getName());
		textFieldAvgScore.setText(
				Float.toString(stud.getAvgScore()));
		textFieldBirthDate.setText(
				stud.getBirthDate().format(dtf));
	}

	@Override
	public void clear() {
		textFieldName.setText("");
		textFieldAvgScore.setText("");
		LocalDate d = LocalDate.now();
		textFieldBirthDate.setText(d.format(dtf));
	}

	@Override
	public AnyData getObject() {
		return object;
	}
	
	private void onOk() {
		String name = textFieldName.getText();
		float avgScore =
			Float.parseFloat(textFieldAvgScore.getText());
		LocalDate birthDate =
			LocalDate.parse(textFieldBirthDate.getText(),
					dtf);
		object = new Student(name, avgScore, birthDate);
		setVisible(false);
	}
	
	private void onCancel() {
		object = null;
		setVisible(false);
	}
}
