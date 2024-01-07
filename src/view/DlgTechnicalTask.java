package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Font;

public class DlgTechnicalTask extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgTechnicalTask dialog = new DlgTechnicalTask();
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
	public DlgTechnicalTask() {
		setTitle("Technical task");
		setBounds(100, 100, 450, 575);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textPane.setText("ТЕХНІЧНЕ ЗАВДАННЯ\r\nна виконання РГР з дисципліни \"Об’єктно-орієнтоване програмування\"\r\nздобувача вищої освіти Бучина Д.А., групи ПІ-221\r\n\r\nТема роботи: Інформаційна система \"Деканат\".\r\nОчікувані технічні та експлуатаційні результати роботи:\r\nJava Eclipse проект з графічним інтерфейсом, який забезпечує роботу з інформацією про деканат (деканат, спеціальності, групи, студенти) згідно варіанту завдання 19.\r\nКорінь «деканат» має містити назву факультету, ім’я декана. \r\nРівень 1 - «спеціальність», зберігає інформацію про код спеціальності, назву, кількість студентів за спеціальністю.\r\nРівень 2 - «група», містить назву групи, ім’я куратора, кількість студентів у групі.\r\nРівень 3 «студент», містить ім’я студента, середній бал, дату народження.\r\nОкрім типових операцій введення даних, їх корегування, вилучення та перегляду, збереження мультиспискової структури у файл та відновлення з файлу, мають бути реалізовані такі специфічні операції:\r\n\tпошук студента, найстаршого за віком;\r\n\tпідрахунок та виведення на консоль загальної кількості студентів з середнім балом вище за 4 для кожної групи.\r\n\r\nПланова трудомісткість роботи: 1 кредит (30 годин).\r\n\r\nОбсяг текстової документації:\r\nПояснювальна записка до проекту об'ємом 20-25 сторінок друкованого тексту формату А4 і програмна документація на систему обсягом 15-25 сторінок друкованого тексту формату А4. Обсяги текстової інформації можуть бути скориговані в процесі роботи за погодженням з керівником.\r\n\r\nПлановий термін захисту роботи: 13-14 тижні семестру.\r\n\r\nВиконавець роботи:\t\tБучин Д.А.\r\n\t\t\r\nКерівник роботи:\t\tБивойно Т.П.\r\n\r\nДата видачі завдання: \"06\" вересня 2023.\r\n\r\nДата узгодження завдання: \"__\" ___________ 2023.");
		getContentPane().add(textPane, BorderLayout.NORTH);

	}

}
