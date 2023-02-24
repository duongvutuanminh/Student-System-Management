package screen;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import decor.RoundedBorder;
import jbdc_connection.JDBCClassUtils;
import jbdc_connection.JDBCSStudentUtils;
import jbdc_connection.JDBCStudentClassUtils;
import student_class.StudentClass;

public class UpdateStudentClassScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private StudentClass currentStudentClass;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblMidtermScore;
	private JTextField textField_3;
	private JLabel lblFinaltermScore;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private static Locale language;
	private static ResourceBundle resourceBundle;

	/**
	 * Launch the application. For testing purpose only.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UpdateStudentClassScreen frame = new UpdateStudentClassScreen(null, new Locale("vi", "VN"));
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public UpdateStudentClassScreen(StudentClass currentStudentClass, Locale interLocale) {
		language = interLocale;
		
		if (language.toString().equalsIgnoreCase("en_US")) {
			Locale.setDefault(new Locale("en", "US"));
		}
		else {
			Locale.setDefault(new Locale("vi", "VN"));
		}
		resourceBundle = ResourceBundle.getBundle("resource_bundle_configs/resource_bundle");
		
		
		this.currentStudentClass = currentStudentClass;
		setTitle(resourceBundle.getString("enrolment_update_student_of_class") + currentStudentClass.getClass_id());
		setIconImage(Toolkit.getDefaultToolkit().getImage(InsertScreen.class.getResource("/images/ant english.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel(resourceBundle.getString("class_row_name"));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(10, 11, 107, 20);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(127, 11, 182, 20);
		textField.setText(JDBCClassUtils.findByID(Integer.toString(currentStudentClass.getClass_id()), language).getClassName());
		textField.setEditable(false);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblStudentName = new JLabel(resourceBundle.getString("enrolment_row_student_name"));
		lblStudentName.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentName.setBounds(10, 48, 107, 20);
		contentPane.add(lblStudentName);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(127, 48, 182, 20);
		textField_1.setText(JDBCSStudentUtils.findByID(Integer.toString(currentStudentClass.getStudent_id())).getName());
		textField_1.setEditable(false);
		contentPane.add(textField_1);
		
		lblMidtermScore = new JLabel(resourceBundle.getString("enrolment_row_midterm_score"));
		lblMidtermScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblMidtermScore.setBounds(10, 79, 107, 20);
		contentPane.add(lblMidtermScore);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(127, 79, 182, 20);
		textField_3.setText(Integer.toString(currentStudentClass.getMidterm_test()));
		contentPane.add(textField_3);
		
		lblFinaltermScore = new JLabel(resourceBundle.getString("enrolment_row_finalterm_score"));
		lblFinaltermScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinaltermScore.setBounds(10, 110, 107, 20);
		contentPane.add(lblFinaltermScore);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(127, 110, 182, 20);
		textField_4.setText(Integer.toString(currentStudentClass.getFinalterm_test()));
		contentPane.add(textField_4);
		
		JButton btnInsertButton = new JButton(resourceBundle.getString("student_insert"));
		btnInsertButton.setBounds(354, 155, 192, 38);
		btnInsertButton.setBorder(new RoundedBorder(15));
		btnInsertButton.addMouseListener(new UpdateListener());
		contentPane.add(btnInsertButton);
		
		JLabel lblClassID = new JLabel(resourceBundle.getString("class_row_cid"));
		lblClassID.setHorizontalAlignment(SwingConstants.LEFT);
		lblClassID.setBounds(319, 11, 60, 20);
		contentPane.add(lblClassID);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setColumns(10);
		textField_5.setText(Integer.toString(currentStudentClass.getClass_id()));
		textField_5.setEditable(false);
		textField_5.setBounds(395, 11, 151, 20);
		contentPane.add(textField_5);
		
		JLabel lblStudentID = new JLabel(resourceBundle.getString("enrolment_row_student_id"));
		lblStudentID.setHorizontalAlignment(SwingConstants.LEFT);
		lblStudentID.setBounds(319, 48, 66, 20);
		contentPane.add(lblStudentID);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setColumns(10);
		textField_6.setBounds(395, 48, 151, 20);
		textField_6.setText(Integer.toString(currentStudentClass.getStudent_id()));
		textField_6.setEditable(false);
		contentPane.add(textField_6);
	}

	
	private class UpdateListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			
			int enrolmentID = currentStudentClass.getEnrolment_number();
			int classID = currentStudentClass.getClass_id();
			int studentID = currentStudentClass.getStudent_id();
			int midtermScore = -1;
			int finaltermScore = -1;
			try {
				midtermScore = Integer.parseInt(textField_3.getText().strip());
				finaltermScore = Integer.parseInt(textField_4.getText().strip());
			} catch (NumberFormatException e2) {
				
				JOptionPane.showMessageDialog(null, resourceBundle.getString("enrolment_update_mid_fin_int"),
                        resourceBundle.getString("error_label"), JOptionPane.ERROR_MESSAGE);
				e2.printStackTrace();
				return;
			} 
			try {
				StudentClass rosterRow = new StudentClass(enrolmentID, classID, studentID, midtermScore, finaltermScore);
				JDBCStudentClassUtils.update(rosterRow);
				dispose();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			
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
