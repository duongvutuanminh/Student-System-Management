package screen;

import java.awt.Font;
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

import classroom.Classroom;
import decor.RoundedBorder;
import jbdc_connection.JDBCClassUtils;

public class UpdateClassScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private int id;
	private JLabel lblDay1;
	private JLabel lblDay2;
	private Locale language;
	private static ResourceBundle resourceBundle;

	/**
	 * Launch the application. For testing purpose only.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UpdateClassScreen frame = new UpdateClassScreen(new Classroom(), new Locale("vi", "VN"));
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
	public UpdateClassScreen(Classroom cla, Locale interLocale) {
		language = interLocale;
		if (language.toString().equalsIgnoreCase("en_US")) {
			Locale.setDefault(new Locale("en", "US"));
		}
		else {
			Locale.setDefault(new Locale("vi", "VN"));
		}
		resourceBundle = ResourceBundle.getBundle("resource_bundle_configs/resource_bundle");

		id = cla.getCid();
		setTitle(resourceBundle.getString("class_update_title"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(InsertScreen.class.getResource("/images/ant english.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel(resourceBundle.getString("class_row_name"));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(10, 11, 100, 20);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(120, 11, 192, 20);
		textField.setText(cla.getClassName());
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lbTeacherID = new JLabel(resourceBundle.getString("class_row_teacherName"));
		lbTeacherID.setHorizontalAlignment(SwingConstants.CENTER);
		lbTeacherID.setBounds(10, 48, 100, 20);
		contentPane.add(lbTeacherID);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(120, 48, 192, 20);
		textField_1.setText(Integer.toString(cla.getTid()));
		contentPane.add(textField_1);
		
		lblDay1 = new JLabel(resourceBundle.getString("class_row_teachday1"));
		lblDay1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay1.setBounds(10, 79, 100, 20);
		contentPane.add(lblDay1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(120, 79, 192, 20);
		textField_2.setText(getDayName(cla.getDay1()));
		contentPane.add(textField_2);
		
		lblDay2 = new JLabel(resourceBundle.getString("class_row_teachday2"));
		lblDay2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay2.setBounds(10, 79, 100, 20);
		contentPane.add(lblDay2);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(120, 110, 192, 20);
		textField_3.setText(getDayName(cla.getDay2()));
		contentPane.add(textField_3);
		
		JButton btnInsertButton = new JButton(resourceBundle.getString("student_update"));
		btnInsertButton.setBounds(354, 185, 192, 38);
		btnInsertButton.addMouseListener(new UpdateListener());
		btnInsertButton.setBorder(new RoundedBorder(15));
		contentPane.add(btnInsertButton);
		
		JLabel updateLbl = new JLabel(resourceBundle.getString("class_update_lbl") + " " + cla.getCid());
		updateLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateLbl.setBounds(354, 82, 192, 17);
		contentPane.add(updateLbl);
	}
	
	
	public static String getDayName(int day) {
        String dayName = "";
        switch (day-1) {
            case 1: dayName = resourceBundle.getString("class_day_2"); break;
            case 2: dayName = resourceBundle.getString("class_day_3"); break;
            case 3: dayName = resourceBundle.getString("class_day_4"); break;
            case 4: dayName = resourceBundle.getString("class_day_5"); break;
            case 5: dayName = resourceBundle.getString("class_day_6"); break;
            case 6: dayName = resourceBundle.getString("class_day_7"); break;
            case 7: dayName = resourceBundle.getString("class_day_8"); break;
            default:dayName = resourceBundle.getString("class_not_valid");
        }

        return dayName;
    }
	
	private class UpdateListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			String className = textField.getText().strip();
			int teacherID = 0;
			try {
				teacherID = Integer.parseInt(textField_1.getText().strip());
			} catch (Exception er) {
				er.printStackTrace();
				JOptionPane.showMessageDialog(null, resourceBundle.getString("class_insert_tid_must_be_int"), 
						resourceBundle.getString("error_label"), JOptionPane.ERROR_MESSAGE);
			}
			String day1 = textField_3.getText().strip();
			String day2 = textField_4.getText().strip();
			if (className.length() == 0 || teacherID == 0) {
				JOptionPane.showMessageDialog(null, resourceBundle.getString("class_insert_filled_fields"), 
						resourceBundle.getString("error_label"), JOptionPane.ERROR_MESSAGE);
			}
			else {
				Classroom newClass;
				try {
					newClass = new Classroom(id, className, teacherID, changeDaytoInt(day1), changeDaytoInt(day2));
					JDBCClassUtils.update(newClass);
					dispose();
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, resourceBundle.getString("class_enter_wrong_day"), 
							resourceBundle.getString("error_label"), JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		}
		
		public int changeDaytoInt(String day) throws Exception {
			int result = 0;
			switch (day.toLowerCase()) {
				case "monday": result = 2; break;
				case "tuesday": result = 3; break;
				case "wednesday": result = 4; break;
				case "thursday": result = 5; break;
				case "friday": result = 6; break;
				case "saturday": result = 7; break;
				case "sunday": result = 8; break;
				case "thu 2": result = 2; break;
				case "thu 3": result = 3; break;
				case "thu 4": result = 4; break;
				case "thu 5": result = 5; break;
				case "thu 6": result = 6; break;
				case "thu 7": result = 7; break;
				case "chu nhat": result = 8; break;
			}
			if (result == 0) {
				throw new Exception(resourceBundle.getString("class_not_valid"));
			}
			return result;
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
