package screen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;

public class InsertScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblYOB;
	private JTextField textField_2;
	private JLabel lblContactNumber;
	private JTextField textField_3;
	private JLabel lblEnglishName;
	private JTextField textField_4;
	private JLabel lblParentName;
	private JTextField textField_5;
	private JLabel lblParentNumber;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertScreen frame = new InsertScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InsertScreen() {
		setTitle("Insert Student");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InsertScreen.class.getResource("/images/ant english.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name (required)");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(10, 11, 100, 20);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(120, 11, 192, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setBounds(10, 48, 100, 20);
		contentPane.add(lblGender);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(120, 48, 192, 20);
		contentPane.add(textField_1);
		
		lblYOB = new JLabel("YOB");
		lblYOB.setHorizontalAlignment(SwingConstants.CENTER);
		lblYOB.setBounds(10, 79, 100, 20);
		contentPane.add(lblYOB);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(120, 79, 192, 20);
		contentPane.add(textField_2);
		
		lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactNumber.setBounds(10, 110, 100, 20);
		contentPane.add(lblContactNumber);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(120, 110, 192, 20);
		contentPane.add(textField_3);
		
		lblEnglishName = new JLabel("English Name");
		lblEnglishName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnglishName.setBounds(10, 141, 100, 20);
		contentPane.add(lblEnglishName);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(120, 141, 192, 20);
		contentPane.add(textField_4);
		
		lblParentName = new JLabel("Parent Name");
		lblParentName.setHorizontalAlignment(SwingConstants.CENTER);
		lblParentName.setBounds(10, 172, 100, 20);
		contentPane.add(lblParentName);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setColumns(10);
		textField_5.setBounds(120, 172, 192, 20);
		contentPane.add(textField_5);
		
		lblParentNumber = new JLabel("Parent Number");
		lblParentNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblParentNumber.setBounds(10, 203, 100, 20);
		contentPane.add(lblParentNumber);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setColumns(10);
		textField_6.setBounds(120, 203, 192, 20);
		contentPane.add(textField_6);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.setBounds(354, 185, 192, 38);
		contentPane.add(btnNewButton);
	}
}
