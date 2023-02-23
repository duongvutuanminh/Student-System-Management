package screen;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import jbdc_connection.JDBCSStudentUtils;
import student.Student;

public class UpdateScreen extends JFrame {
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
	private Student updateStud;
	private int id;
	private Locale language;
	private ResourceBundle resourceBundle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateScreen frame = new UpdateScreen(new Student(), new Locale("vi", "VN"));
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
	public UpdateScreen(Student stud, Locale interLocale) {
		language = interLocale;
		if (language.toString().equalsIgnoreCase("en_US")) {
			Locale.setDefault(new Locale("en", "US"));
		}
		else {
			Locale.setDefault(new Locale("vi", "VN"));
		}
		resourceBundle = ResourceBundle.getBundle("resource_bundle_configs/resource_bundle");
		
		id = stud.getId();
		setTitle(resourceBundle.getString("student_update_screen_title"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(InsertScreen.class.getResource("/images/ant english.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel(resourceBundle.getString("student_insert_name_field"));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(10, 11, 100, 20);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(120, 11, 192, 20);
		textField.setText(stud.getName());
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblGender = new JLabel(resourceBundle.getString("student_insert_gender_field"));
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setBounds(10, 48, 100, 20);
		contentPane.add(lblGender);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(120, 48, 192, 20);
		textField_1.setText((stud.getGender() == 0) ? resourceBundle.getString("student_gender_male") : resourceBundle.getString("student_gender_female"));
		contentPane.add(textField_1);
		
		lblYOB = new JLabel(resourceBundle.getString("student_insert_yob_field"));
		lblYOB.setHorizontalAlignment(SwingConstants.CENTER);
		lblYOB.setBounds(10, 79, 100, 20);
		contentPane.add(lblYOB);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(120, 79, 192, 20);
		textField_2.setText(Integer.toString(stud.getYob()));
		contentPane.add(textField_2);
		
		lblContactNumber = new JLabel(resourceBundle.getString("student_insert_contactNo_field"));
		lblContactNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactNumber.setBounds(10, 110, 100, 20);
		contentPane.add(lblContactNumber);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(120, 110, 192, 20);
		textField_3.setText(stud.getContactNumber());
		contentPane.add(textField_3);
		
		lblEnglishName = new JLabel(resourceBundle.getString("student_insert_englishName_field"));
		lblEnglishName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnglishName.setBounds(10, 141, 100, 20);
		contentPane.add(lblEnglishName);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(120, 141, 192, 20);
		textField_4.setText(stud.getEnglishName());
		contentPane.add(textField_4);
		
		lblParentName = new JLabel(resourceBundle.getString("student_insert_parentName_field"));
		lblParentName.setHorizontalAlignment(SwingConstants.CENTER);
		lblParentName.setBounds(10, 172, 100, 20);
		contentPane.add(lblParentName);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setColumns(10);
		textField_5.setBounds(120, 172, 192, 20);
		textField_5.setText(stud.getParentName());
		contentPane.add(textField_5);
		
		lblParentNumber = new JLabel(resourceBundle.getString("student_insert_parentNumber_field"));
		lblParentNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblParentNumber.setBounds(10, 203, 100, 20);
		contentPane.add(lblParentNumber);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setColumns(10);
		textField_6.setBounds(120, 203, 192, 20);
		textField_6.setText(stud.getParentNumber());
		contentPane.add(textField_6);
		
		JButton btnInsertButton = new JButton(resourceBundle.getString("student_update"));
		btnInsertButton.setBounds(354, 185, 192, 38);
		btnInsertButton.addMouseListener(new UpdateListener());
		contentPane.add(btnInsertButton);
		
		JLabel updateLbl = new JLabel(resourceBundle.getString("student_update_lbl") + " " + stud.getId());
		updateLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateLbl.setBounds(354, 82, 192, 17);
		contentPane.add(updateLbl);
	}
	
	private class UpdateListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			try {
				updateStud = new Student(id, textField.getText(), (textField_1.getText().strip().equals(resourceBundle.getString("student_gender_male"))) ? 0 : 1, 
						Integer.parseInt(textField_2.getText()), textField_3.getText(), textField_4.getText(),
						textField_5.getText(), textField_6.getText());
				JDBCSStudentUtils.Update(updateStud);
				dispose();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
			
		}
	}
}
