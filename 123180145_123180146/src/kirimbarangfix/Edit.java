
package kirimbarangfix;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Edit extends JFrame {
    Statement statement;
    ResultSet resultSet;
    JButton bPengirim, bPenerima, bBack;
    JLabel lid_kirim,lTittle;
    JTextField fid_kirim;
    int idm,idr;

    public Edit() {
        Font fJudul 	= new Font("Felix Titling", 0, 18);
        Font fglobal  = new Font("Times New Roman", 0, 14);
        
	lTittle = new JLabel("EDIT");
	lTittle.setFont(fJudul);
        lTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lTittle.setForeground(new Color(0,0,0));

	lid_kirim = new JLabel("ID ");
	lid_kirim.setForeground(new Color(0,0,0));
	lid_kirim.setFont(fglobal);
	fid_kirim = new JTextField();
	fid_kirim.setFont(fglobal);

	bBack = new JButton("Kembali");
	bBack.setFont(fglobal);
	bBack.setBackground(new Color(204,204,255));

	bPengirim = new JButton("Edit Pengirim");
	bPengirim.setFont(fglobal);
	bPengirim.setBackground(new Color(204,204,255));
        
	bPenerima = new JButton("Edit Penerima");
	bPenerima.setFont(fglobal);
	bPenerima.setBackground(new Color(204,204,255));

	setSize(430, 300);
	setDefaultCloseOperation(3);
	setVisible(true);
	setLayout((LayoutManager)null);

	setTitle("Edit Data");

        add(lTittle);
	add(lid_kirim);
	add(fid_kirim);
	add(bPengirim);
	add(bPenerima);
	add(bBack);

	getContentPane().setBackground(new Color(102,153,255));

        lTittle.setBounds(1,30,429,30);
	lid_kirim.setBounds(50, 70, 100, 25);
	fid_kirim.setBounds(100, 70, 100, 25);
	bPengirim.setBounds(55, 120, 150, 25);
	bPenerima.setBounds(225, 120, 150, 25);
	bBack.setBounds(165, 160, 100, 25);

	bBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new LihatData();
            }
        });
        bPengirim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    idm=Integer.parseInt(fid_kirim.getText());
		} catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Tipe Data Salah");
		}catch (Error ext){
                    JOptionPane.showMessageDialog(rootPane, "SALAH!!");
		}
                setVisible(false);
                new EditPengirim(idm);
            }
        });
        bPenerima.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    idm=Integer.parseInt(fid_kirim.getText());
		} catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Tipe Data Salah");
		}catch (Error ext){
                    JOptionPane.showMessageDialog(rootPane, "SALAH!!");
		}
                setVisible(false);
		new EditPenerima(idm);
            }
        });
    }

}