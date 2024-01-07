package view;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Canvas;
import java.awt.Label;

public class DlgClassDiagram extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgClassDiagram dialog = new DlgClassDiagram();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgClassDiagram() {
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new
File("resources/Класи РГР етап 2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					e.getMessage(),
					"Image Open Error",
					JOptionPane.ERROR_MESSAGE);
		}
		ImageIcon icon = new ImageIcon(myPicture);
		JLabel picLabel = new JLabel(icon);
		
		setTitle("Class diagram");
		setBounds(100, 100, icon.getIconWidth() + 100, 
				icon.getIconHeight() + 100);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		GridBagConstraints gbc_picLabel =
				new GridBagConstraints();
		gbc_picLabel.gridx = 0;
		gbc_picLabel.gridy = 0;
		getContentPane().add(picLabel, gbc_picLabel);
	}
}
