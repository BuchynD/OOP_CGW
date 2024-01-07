package view;

import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

import model.AnyData;
import model.DeansOffice;
import model.Group;
import model.Specialty;
import model.Student;

import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.Enumeration;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainWindow {

	private JFrame frame;
	private JTree tree;
	private DlgTechnicalTask dlgTechnicalTask =
			new DlgTechnicalTask();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				onWindowOpened();
			}
		});
		frame.setTitle("РГР \"Деканат\"");
		frame.setBounds(100, 100, 286, 290);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{122, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		
		tree = new JTree();
		tree.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() != KeyEvent.VK_ENTER)
					return;
				DefaultMutableTreeNode node = getSelectedNode();
				if (node == null)
					return;
				AnyData data = (AnyData) node.getUserObject();
				IDlg dlg = data.getDialog();
				dlg.showObject(data, false);
				dlg.dispose();
			}
		});
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onShow(e);
			}
		});
		scrollPane.setViewportView(tree);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {91};
		gbl_panel.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onAdd();
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 0;
		panel.add(btnAdd, gbc_btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onRemove();
			}
		});
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.insets = new Insets(0, 0, 5, 0);
		gbc_btnRemove.gridx = 0;
		gbc_btnRemove.gridy = 1;
		panel.add(btnRemove, gbc_btnRemove);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onEdit();
			}
		});
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdit.gridx = 0;
		gbc_btnEdit.gridy = 2;
		panel.add(btnEdit, gbc_btnEdit);
		
		JButton btnStore = new JButton("Store");
		btnStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onStore();
			}
		});
		GridBagConstraints gbc_btnStore = new GridBagConstraints();
		gbc_btnStore.insets = new Insets(0, 0, 5, 0);
		gbc_btnStore.gridx = 0;
		gbc_btnStore.gridy = 3;
		panel.add(btnStore, gbc_btnStore);
		
		JButton btnRestore = new JButton("Restore");
		btnRestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onRestore();
			}
		});
		GridBagConstraints gbc_btnRestore = new GridBagConstraints();
		gbc_btnRestore.insets = new Insets(0, 0, 5, 0);
		gbc_btnRestore.gridx = 0;
		gbc_btnRestore.gridy = 4;
		panel.add(btnRestore, gbc_btnRestore);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(btnCalculate, popupMenu);
		
		JMenuItem mntmOldestStudent = new JMenuItem("Oldest student");
		mntmOldestStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onSearch();
			}
		});
		popupMenu.add(mntmOldestStudent);
		
		JMenuItem mntmNumberOfExcellentStudents = new JMenuItem("Number of excellent students in each group");
		mntmNumberOfExcellentStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onCalculate();
			}
		});
		popupMenu.add(mntmNumberOfExcellentStudents);
		GridBagConstraints gbc_btnCalculate = new GridBagConstraints();
		gbc_btnCalculate.gridx = 0;
		gbc_btnCalculate.gridy = 5;
		panel.add(btnCalculate, gbc_btnCalculate);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmTechnicalTask = new JMenuItem("Technical task");
		mntmTechnicalTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlgTechnicalTask.setVisible(true);
			}
		});
		mntmTechnicalTask.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dlgTechnicalTask.setVisible(true);
			}
		});
		mnAbout.add(mntmTechnicalTask);
		
		JMenuItem mntmClassDiagram = new JMenuItem("Class diagram");
		mntmClassDiagram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgClassDiagram dlgClassDiagram =
						new DlgClassDiagram();
				dlgClassDiagram.setVisible(true);
			}
		});
		mnAbout.add(mntmClassDiagram);
	}

	public JTree getTree() {
		return tree;
	}
	
	private DefaultMutableTreeNode getSelectedNode() {
		Object selectNode =
				tree.getLastSelectedPathComponent();
		if (selectNode == null) {
			JOptionPane.showMessageDialog(tree,
					"Node was not selected",
					frame.getTitle(),
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return (DefaultMutableTreeNode) selectNode;
	}
	
	private void expandAll() {
		for (int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
	}
	
	private void selectNode(DefaultMutableTreeNode node) {
		int n = 0;
		DefaultMutableTreeNode root =
				(DefaultMutableTreeNode)
				tree.getModel().getRoot();
		Enumeration<TreeNode> enm =
				root.children();
		while (enm.hasMoreElements()) {
			DefaultMutableTreeNode nod =
				(DefaultMutableTreeNode) enm.nextElement();
			if (nod == node) {
				tree.setSelectionRow(n);
				return;
			}
			n++;
		}
	}
	
	private void onShow(MouseEvent e) {
		if (e.getClickCount() != 3 ||
				e.getButton() != MouseEvent.BUTTON3)
			return;
		DefaultMutableTreeNode node = getSelectedNode();
		if (node == null)
			return;
		AnyData data = (AnyData) node.getUserObject();
		IDlg dlg = data.getDialog();
		dlg.showObject(data, false);
		dlg.dispose();
	}
	
	protected void onAdd() {
		DefaultMutableTreeNode parent = getSelectedNode();
		if (parent == null)
			return;
		AnyData parentData =
				(AnyData) parent.getUserObject();
		IDlg dlg = parentData.getSonDialog();
		if (dlg == null)
			return;
		dlg.showObject(null, true);
		AnyData obj = dlg.getObject();
		dlg.dispose();
		if (obj == null)
			return;
		DefaultMutableTreeNode newSon =
				new DefaultMutableTreeNode(obj);
		parent.add(newSon);
		tree.updateUI();
		expandAll();
	}
	
	private void onStore() {
		if (tree.getModel() == null)
			return;
		JFileChooser fileChooser =
			new JFileChooser("Серіалізація моделі дерева");
		fileChooser.showSaveDialog(frame);
		try {
			File f = fileChooser.getSelectedFile();
			String fName = f.getAbsolutePath();
			FileOutputStream fileStream =
					new FileOutputStream(fName);
			ObjectOutputStream out =
					new ObjectOutputStream(fileStream);
			
			out.writeObject(tree.getModel());
			out.close();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(tree,
					"Помилка відкриття файлу",
					"Збереження дерева у файлі",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
	
	private void onRestore() {
		FileDialog fileDialog = new FileDialog(frame);
		fileDialog.setMode(FileDialog.LOAD);
		fileDialog.setVisible(true);
		String dr = fileDialog.getDirectory();
		String fn = fileDialog.getFile();
		if (dr == null || fn == null)
			return;
		String fName = dr + fn;
		try {
			ObjectInputStream in =
					new ObjectInputStream(
							new FileInputStream(fName));
			TreeModel model = (TreeModel) in.readObject();
			tree.setModel(model);
			in.close();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(tree,
					"Помилка десеріалізації дерева",
					"Десеріалізація",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		expandAll();
	}
	
	protected TreeModel getStartModel() throws Exception {
		DeansOffice d = new DeansOffice("NNI EIT",
				"Ivanets S.A.");
		Specialty sp = new Specialty("121",
				"Software engineering", 200);
		Group g = new Group("PI-221",
				"Trunova O.V.", 30);
		Student st = new Student("Buchyn D.A.", 4.5f,
				LocalDate.of(2004, Month.OCTOBER, 31));
		DefaultMutableTreeNode root =
				new DefaultMutableTreeNode(d);
		DefaultMutableTreeNode spNod =
				new DefaultMutableTreeNode(sp);
		DefaultMutableTreeNode gNod =
				new DefaultMutableTreeNode(g);
		DefaultMutableTreeNode stNod =
				new DefaultMutableTreeNode(st);
		root.add(spNod);
		spNod.add(gNod);
		gNod.add(stNod);
		return (new JTree(root)).getModel();
	}
	
	protected void onWindowOpened() {
		try {
			tree.setModel(getStartModel());
			expandAll();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	protected void onRemove() {
		DefaultMutableTreeNode node = getSelectedNode();
		if (node == null)
			return;
		if (node.isRoot())
			tree.setModel(null);
		node.removeFromParent();
		tree.setSelectionPath(null);
		tree.updateUI();
	}
	
	protected void onEdit() {
		DefaultMutableTreeNode node = getSelectedNode();
		if (node == null)
			return;
		AnyData data = (AnyData) node.getUserObject();
		IDlg dlg = data.getDialog();
		dlg.showObject(data, true);
		AnyData obj = dlg.getObject();
		dlg.dispose();
		if (obj == null)
			return;
		node.setUserObject(obj);
		tree.updateUI();
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
//				if (e.isPopupTrigger()) {
					showMenu(e);
			}
//			public void mouseReleased(MouseEvent e) {
//				if (e.isPopupTrigger()) {
//					showMenu(e);
//				}
//			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	protected void onSearch() {
		DefaultMutableTreeNode node = getSelectedNode();
		if (node == null)
			return;
		LocalDate earliestBirthday = LocalDate.now();
		DefaultMutableTreeNode oldest = null;
		Enumeration<TreeNode> enm =
				node.postorderEnumeration();
		while (enm.hasMoreElements()) {
			DefaultMutableTreeNode currentNode =
				(DefaultMutableTreeNode) enm.nextElement();
			Object data = currentNode.getUserObject();
			if (!(data instanceof Student))
				continue;
			LocalDate currentBirthDate =
					((Student)data).getBirthDate();
			if (currentBirthDate.isBefore(
					earliestBirthday)) {
				earliestBirthday = currentBirthDate;
				oldest = currentNode;
			}
		}
		System.out.println(oldest);
		selectNode(oldest);
//		((AnyData) oldest.getUserObject())
//		.showDialog(false);
	}
	
	private void onCalculate() {
		DefaultMutableTreeNode root =
		(DefaultMutableTreeNode) tree.getModel().getRoot();
		Enumeration<TreeNode> enmSpec =
				root.children();
		while (enmSpec.hasMoreElements()) {
			DefaultMutableTreeNode spec =
			(DefaultMutableTreeNode) enmSpec.nextElement();
			System.out.println("Specialty " + spec + ":");
			Enumeration<TreeNode> enmGrp =
					spec.children();
			while (enmGrp.hasMoreElements()) {
				DefaultMutableTreeNode grp =
					(DefaultMutableTreeNode)
					enmGrp.nextElement();
				int nExcellent = 0;
				Enumeration<TreeNode>
				enmStud = grp.children();
				while (enmStud.hasMoreElements()) {
					DefaultMutableTreeNode stud =
					(DefaultMutableTreeNode)
					enmStud.nextElement();
					Object data = stud.getUserObject();
					if (((Student)data).getAvgScore() > 4) {
						nExcellent++;
					}
				}
				System.out.println(grp + " has " +
				nExcellent + " excellent students");
			}
		}
	}
}
