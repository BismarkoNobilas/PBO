
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


public class HapusData extends JFrame {
    Statement statement;
    ResultSet resultSet;
    JButton bHapus, bBack;
    JLabel lid_kirim,lTittle;
    JTextField fid_kirim;
    int idm,idr;

    public HapusData() {
        Font fJudul 	= new Font("Felix Titling", 0, 18);
        Font fglobal  = new Font("Times New Roman", 0, 14);
        
	lTittle = new JLabel("HAPUS DATA");
	lTittle.setFont(fJudul);
        lTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lTittle.setForeground(new Color(0,0,0));

	lid_kirim = new JLabel("ID ");
	lid_kirim.setForeground(new Color(0,0,0));
	fid_kirim = new JTextField();

	bBack = new JButton("Kembali");
	bBack.setFont(fglobal);
	bBack.setBackground(new Color(204,204,255));

	bHapus = new JButton("Hapus");
	bHapus.setFont(fglobal);
	bHapus.setBackground(new Color(204,204,255));

	setSize(430, 240);
	setDefaultCloseOperation(3);
	setVisible(true);
	setLayout((LayoutManager)null);

	setTitle("Hapus Data");

        add(lTittle);
	add(lid_kirim);
	add(fid_kirim);
	add(bHapus);
	add(bBack);

	getContentPane().setBackground(new Color(102,153,255));

        lTittle.setBounds(1,30,429,30);
	lid_kirim.setBounds(50, 80, 100, 25);
	fid_kirim.setBounds(100, 80, 100, 25);
	bBack.setBounds(105, 140, 100, 25);
	bHapus.setBounds(225, 140, 100, 25);

	bBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Menu();
            }
        });
	bHapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Koneksi koneksi = new Koneksi();
                try {
                    statement = koneksi.getConnection().createStatement();
                    String sql = "SELECT * FROM kirim WHERE id_kirim='" + fid_kirim.getText() + "'";
                    resultSet = statement.executeQuery(sql);
                    while (resultSet.next()){
                        idm= resultSet.getInt("id_pengirim");
                        idr= Integer.parseInt(resultSet.getString("id_penerima"));
                    }
                    statement.executeUpdate("DELETE FROM kirim WHERE id_kirim='" + fid_kirim.getText() + "'");
                    statement.executeUpdate("DELETE FROM pengirim WHERE id_pengirim='" + idm + "'");
                    statement.executeUpdate("DELETE FROM penerima WHERE id_penerima='" + idr + "'");
                    JOptionPane.showMessageDialog((Component)null, "Data berhasil di Hapus!", "Hasil", 1);
                    statement.close();
                } catch (SQLException var3) {
                    JOptionPane.showMessageDialog((Component)null, "Data Gagal di Hapus!", "Hasil", 0);
                } catch (ClassNotFoundException var4) {
                    JOptionPane.showMessageDialog((Component)null, "Driver Tidak Ditemukan!", "Hasil", 0);
                }
                setVisible(false);
                new Menu();
            }
        });
    }

}