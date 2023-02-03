package screen;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import decor.RoundedBorder;
import jbdc_connection.JDBCConnection;
import jbdc_connection.JDBCUtils;
import student.Student;

public class StudentScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable studentTable;
	private JTextField nameInput;
	private JTextField idInput;
	private JTextField telInput;
	
	
	/**
	 * just for testing purposes
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentScreen frame = new StudentScreen();
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
	public StudentScreen() {
		//Check the connection with the database
		JDBCConnection.test();
		
		setTitle("ANT Management System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentScreen.class.getResource("/images/ant english.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Rockwell", Font.PLAIN, 15));
		UIManager.put("Menu.font", new Font("sans-serif", Font.PLAIN, 18));
		setJMenuBar(menuBar);
		
		JMenu studentBtn = new JMenu("Student");
		menuBar.add(studentBtn);
		
		JMenu classBtn = new JMenu("Class");
		menuBar.add(classBtn);
		
		JMenu exitBtn = new JMenu("Exit");
		menuBar.add(exitBtn);
		
		JMenuItem menuSorting = new JMenuItem("Student Management System");
		studentBtn.add(menuSorting);
		
		JMenuItem menuHelp = new JMenuItem("Help");
		studentBtn.add(menuHelp);
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Management System");
		lblNewLabel.setForeground(new Color(244, 164, 96));
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 34));
		lblNewLabel.setBounds(10, 0, 434, 56);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 45, 850, 574);
		contentPane.add(scrollPane);
		
		studentTable = new JTable();
		studentTable.setCellSelectionEnabled(true);
		studentTable.setBackground(new Color(255, 255, 255));
		studentTable.setBorder(new CompoundBorder());
		studentTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				/**
				 * Column model
				 * 0,   1,       2,           3, 			  4, 			5,                6, 			  7
				 */
				"ID", "Name", "Gender", "Year of Birth", "English Name","Phone number", "Parent Name", "Parent Number"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		studentTable.getColumnModel().getColumn(0).setPreferredWidth(54);
		studentTable.getColumnModel().getColumn(1).setPreferredWidth(139);
		studentTable.getColumnModel().getColumn(3).setPreferredWidth(88);
		studentTable.getColumnModel().getColumn(4).setPreferredWidth(80);
		studentTable.getColumnModel().getColumn(5).setPreferredWidth(86);
		studentTable.getColumnModel().getColumn(6).setPreferredWidth(114);
		studentTable.getColumnModel().getColumn(7).setPreferredWidth(86);
		scrollPane.setViewportView(studentTable);
		
		// centering the text in some columns
		TableColumn[] colArr = {studentTable.getColumnModel().getColumn(0),
								studentTable.getColumnModel().getColumn(2),
								studentTable.getColumnModel().getColumn(3),
								studentTable.getColumnModel().getColumn(4),
								studentTable.getColumnModel().getColumn(5),
								studentTable.getColumnModel().getColumn(7),
		};
		
		// creating the Centering properties
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();  
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		for (TableColumn col : colArr) {
	        col.setCellRenderer(dtcr);
		}
		
		//show data
		showData(JDBCUtils.findAll());
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Rockwell", Font.PLAIN, 15));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(889, 119, 61, 27);
		contentPane.add(nameLabel);
		
		nameInput = new JTextField();
		nameInput.setBounds(960, 121, 218, 27);
		contentPane.add(nameInput);
		nameInput.setColumns(10);
		
		JButton findBtn = new JButton("FIND WITH INFOs");
		findBtn.addMouseListener(new findStudentListener());
		findBtn.setBounds(960, 256, 218, 40);
		findBtn.setBorder(new RoundedBorder(15));
		contentPane.add(findBtn);
		
		JButton saveBtn = new JButton("SAVE");
		saveBtn.setBounds(960, 477, 218, 40);
		saveBtn.setBorder(new RoundedBorder(15));
		contentPane.add(saveBtn);
		
		JButton deleteBtn = new JButton("DELETE");
		deleteBtn.setBounds(960, 579, 218, 40);
		deleteBtn.setBorder(new RoundedBorder(15));
		contentPane.add(deleteBtn);
		
		JButton refreshBtn = new JButton("");
		refreshBtn.addMouseListener(new refreshListener());
		refreshBtn.setIcon(new ImageIcon(StudentScreen.class.getResource("/images/Button-Refresh-icon.png")));
		refreshBtn.setBounds(870, 44, 71, 40);
		refreshBtn.setBorder(new RoundedBorder(15));
		contentPane.add(refreshBtn);
		
		JButton updateBtn = new JButton("UPDATE");
		updateBtn.setBounds(960, 528, 218, 40);
		updateBtn.setBorder(new RoundedBorder(15));
		contentPane.add(updateBtn);
		
		idInput = new JTextField();
		idInput.setColumns(10);
		idInput.setBounds(960, 159, 218, 27);
		contentPane.add(idInput);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setFont(new Font("Rockwell", Font.PLAIN, 15));
		idLabel.setBounds(889, 157, 61, 27);
		contentPane.add(idLabel);
		
		JLabel telLabel = new JLabel("Tel.");
		telLabel.setHorizontalAlignment(SwingConstants.CENTER);
		telLabel.setFont(new Font("Rockwell", Font.PLAIN, 15));
		telLabel.setBounds(889, 195, 61, 27);
		contentPane.add(telLabel);
		
		telInput = new JTextField();
		telInput.setColumns(10);
		telInput.setBounds(960, 197, 218, 27);
		contentPane.add(telInput);
	}
	
	
	public void showData(List<Student> studentList) {
		DefaultTableModel tableModel = (DefaultTableModel) studentTable.getModel();
		tableModel.setRowCount(0);
		studentList.forEach((student) -> {
			String gender = (student.getGender() == 0) ? "Male" : "Female";
			tableModel.addRow(new Object[] {
					student.getId(),
					student.getName(),
					gender,
					student.getYob(),
					student.getEnglishName(),
					student.getContactNumber(),
					student.getParentName(),
					student.getParentNumber()
			});
		});
	}
	
	
	private class refreshListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getButton() == MouseEvent.BUTTON1) { 
				try {
					showData(JDBCUtils.findAll());
				} catch (Exception error) {
					// TODO: handle exception
					error.printStackTrace();
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	private class findStudentListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e){
			// TODO Auto-generated method stub
			if (e.getButton() == MouseEvent.BUTTON1) {
				try {
					String nameInText = nameInput.getText().strip();
					int idInText = 0;
					if (idInput.getText().strip() != "") {
						idInText =  Integer.valueOf(idInput.getText().strip());
					}
					String telInText = telInput.getText().strip();
					if (nameInText == "" && idInText == 0 && telInText == "") {
						throw new EmptyFieldWarning();
					}
					else {
						showData(JDBCUtils.findStudents(nameInText, idInText, telInText));
					}
				} catch (Exception error) {
					// TODO: handle exception
					
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class EmptyFieldWarning extends Exception {
		private static final long serialVersionUID = 1L;

		public EmptyFieldWarning() {
			 JFrame f=new JFrame();  
			 JOptionPane.showMessageDialog(f,"You need to fill out at least 1 field: name, id or telephone number!");  
			 
		}
	}
}
