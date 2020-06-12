package hd.view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import hd.biz.SearchBIZ;

public class Menu1 extends JFrame {
	

	private JPanel contentPane;
	   private JTextField textField;
	   private JTable table;

	   /**
	    * Launch the application.
	    */
	   public static void main(String[] args) {
	      EventQueue.invokeLater(new Runnable() {
	         public void run() {
	            try {
	               Menu1 frame = new Menu1();
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
	   public Menu1() {
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setIconImage(Toolkit.getDefaultToolkit().getImage(Menu1.class.getResource("/hd/view/HeartDart.png")));
	      setTitle("\u2665Heart Dart\u2665 - Search");
	      setBounds(100, 100, 481, 319);
	      contentPane = new JPanel();
	      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	      setContentPane(contentPane);
	      contentPane.setLayout(null);
	      
	      
	      
	      JPanel p = new JPanel();
	      p.setBounds(0, 235, 463, 37);
	      p.setBackground(new Color(205, 92, 92));
	      contentPane.add(p);
	      
	      JComboBox combo = new JComboBox(new Object[]{});
	      combo.setBackground(Color.WHITE);
	      combo.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 17));
	      combo.setModel(new DefaultComboBoxModel(new String[] {"  \uC804\uCCB4", "  \uD68C\uC0AC\uBA85 ", "  \uCF54\uB4DC", "  \uC5C5\uC885"}));
	      p.add(combo);
	      
	      textField = new JTextField(20);
	      p.add(textField);
	      
	           
	      JPanel panel = new JPanel();
	      panel.setBackground(Color.DARK_GRAY);
	      panel.setBounds(0, 0, 463, 30);
	      contentPane.add(panel);
	      panel.setLayout(null);
	      
	      Choice choice = new Choice();
	      choice.setBounds(299, 3, 52, 24);
	      panel.add(choice);
	      
	      Label label = new Label("\uBD84\uAE30 :");
	      label.setAlignment(Label.CENTER);
	      label.setForeground(new Color(255, 255, 255));
	      label.setFont(new Font("Dialog", Font.BOLD, 15));
	      label.setBounds(243, 3, 52, 25);
	      panel.add(label);
	      
	      Label label_1 = new Label("\uB144\uB3C4 :");
	      label_1.setForeground(Color.WHITE);
	      label_1.setFont(new Font("Dialog", Font.BOLD, 15));
	      label_1.setAlignment(Label.CENTER);
	      label_1.setBounds(123, 4, 53, 25);
	      panel.add(label_1);
	      
	      Choice choice_1 = new Choice();
	      choice_1.setBounds(181, 3, 52, 24);
	      panel.add(choice_1);
	      
	      Label label_2 = new Label("*\uAE30\uAC04\uC120\uD0DD*");
	      label_2.setFont(new Font("Dialog", Font.BOLD, 15));
	      label_2.setForeground(new Color(255, 255, 255));
	      label_2.setAlignment(Label.CENTER);
	      label_2.setBounds(18, 4, 92, 25);
	      panel.add(label_2);
	      
	      Button button = new Button("Next");
	      button.setBackground(new Color(255, 255, 255));
	      button.setForeground(new Color(205, 92, 92));
	      button.setBounds(366, 3, 87, 25);
	      panel.add(button);
	      
	      JScrollPane scrollPane = new JScrollPane();
	      scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	      scrollPane.setBounds(0, 31, 463, 206);
	      contentPane.add(scrollPane);
	      
	      String[] name = {"회사명", "업종명", "종목코드"};
	      DefaultTableModel dt = new DefaultTableModel(name, 0){
	    	  public boolean isCellEditable(int i, int c){
	              return false;
	             }
	      };
	      
	      table = new JTable(dt);
	      scrollPane.setViewportView(table);

	      // 회사 테이블을 첫 화면에 띄우기 
	      // 화면에 모든 회사 목록 띄우기 -> BIZ호출
	      SearchBIZ.userSelectAll(dt);
	      
	      if (dt.getRowCount() > 0)
	         table.setRowSelectionInterval(0, 0);
	      
	      // 유저 조건 서치
		JButton serach = new JButton("\uAC80\uC0C9");
		p.add(serach);
		serach.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switch (combo.getSelectedItem().toString().trim()) {
				case "전체" :
					new SearchBIZ().userSearchAll(dt, textField.getText());
					break;
				case "회사명" :
					new SearchBIZ().userSearch(dt, "com_name",textField.getText());
					break;
				case "코드" :
					new SearchBIZ().userSearch(dt, "com_code",textField.getText());
					break;
				case "업종" :
					new SearchBIZ().userSearch(dt, "industry_name",textField.getText());
					break;
				}
			}
		});
	      
	   }
}
