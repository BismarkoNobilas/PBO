package kirimbarangfix;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class EditPengirim  extends JFrame {
    
    ResultSet resultSet;
    JLabel lTittle, lJudul1, lJudul2, lJudul3, lnm_pengirim, lasal, lhp_pengirim, lnm_penerima, ltujuan, lhp_penerima, lalamat, ljenkim, ljenbar, lberat;
    JList sasal;
    Statement statement, statement2;
    String nm_pengirim, asal, hp_pengirim, nm_penerima, tujuan, hp_penerima, alamat, jenkim, jenbar,  berat;
    int abdata,abdata2, abdata3, abdata4, harkim, harbar, harjak, hartot, idk, abdata5;
    String[] datas = new String[12];
    JTextField fnm_pengirim, fhp_pengirim, fnm_penerima, fhp_penerima, falamat;
    JButton bSave, bBack;
    javax.swing.JComboBox<String> fasal, ftujuan, fjenkim, fjenbar, fberat;
    
    public EditPengirim(int id)
    {			 
        idk=id;
        Koneksi koneksi = new Koneksi();
        try {
            statement = koneksi.getConnection().createStatement();
            String sql = "SELECT * FROM kirim k JOIN pengirim m ON k.id_pengirim=m.id_pengirim WHERE id_kirim='" + idk + "'";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                datas[0] = resultSet.getString("id_pengirim");
            }
            statement.close();

        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(rootPane, "Data Gagal Ditampilkan" + sqlError);
        } catch (ClassNotFoundException classError) {
            JOptionPane.showMessageDialog(rootPane, "Driver tidak ditemukan !!");
        }
        		 
        Font fJudul 	= new Font("Felix Titling", 0, 18);
        Font fJudul2 	= new Font("Bell MT", 0, 16);
	Font fglobal  = new Font("Times New Roman", 0, 14);
	setTitle("EDIT DATA");
	lTittle = new JLabel("EDIT DATA");
	lTittle.setFont(fJudul);
        lTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lTittle.setForeground(new Color(0,0,0));
        
	lJudul1 = new JLabel("Data Pengirim : ");
	lJudul1.setFont(fJudul2);
	lJudul1.setForeground(new Color(0,0,0));

	lnm_pengirim = new JLabel("Nama Pengirim");
	lnm_pengirim.setFont(fglobal);
	lnm_pengirim.setForeground(new Color(0,0,0));

	fnm_pengirim = new JTextField();
	fnm_pengirim.setFont(fglobal);

	lhp_pengirim = new JLabel("No Telp");
	lhp_pengirim.setFont(fglobal);
	lhp_pengirim.setForeground(new Color(0,0,0));

	fhp_pengirim = new JTextField();
	fhp_pengirim.setFont(fglobal);
                      
	bSave = new JButton("Simpan");
	bSave.setFont(fglobal);
	bSave.setBackground(new Color(204,204,255));

	bBack = new JButton("Kembali");
	bBack.setFont(fglobal);
	bBack.setBackground(new Color(204,204,255));
        
	getContentPane().setBackground(new Color(102,153,255));

        
	setLayout(null);
	add(lTittle);
        
        add(lJudul1);                        
	add(lnm_pengirim);
	add(fnm_pengirim);
                              
	add(lhp_pengirim);
	add(fhp_pengirim);

	add(bBack);
        add(bSave);
                             
        lTittle.setBounds(1,30,474,30);
	lJudul1.setBounds(30, 70, 150, 30);
	lnm_pengirim.setBounds(40, 110, 120, 30);
	fnm_pengirim.setBounds(155, 110, 270, 30);
                                
	lhp_pengirim.setBounds(40, 150, 150, 30);
	fhp_pengirim.setBounds(155, 150, 270, 30);

	bSave.setBounds(117, 210, 110, 30);
	bBack.setBounds(247, 210, 110,30);

	setSize(475, 310);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);


	bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		try {
                    idk=Integer.parseInt(datas[0]);
                    nm_pengirim = fnm_pengirim.getText();
                    hp_pengirim = fhp_pengirim.getText();
                    Data data = new Data(nm_pengirim, hp_pengirim);
                    Koneksi koneksi = new Koneksi();
                    try {
                        statement = koneksi.getConnection().createStatement();
                        statement.executeUpdate("UPDATE pengirim SET nm_pengirim='" + data.getnm_pengirim() + "', hp_pengirim='" + data.gethp_pengirim() + "' WHERE id_pengirim=" + idk + " ");
                        JOptionPane.showMessageDialog(rootPane, "Data Berhasil Disimpan");
                        statement.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        java.util.logging.Logger.getLogger(TambahData.class.getName()).log(Level.SEVERE, null, ex);
                    }
		} catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Tipe Data Salah");
		}catch (Error ext){
                    JOptionPane.showMessageDialog(rootPane, "SALAH!!");
		}
                setVisible(false);
		new Menu();
            }
	});
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Edit();
            }
        });
    }
}


