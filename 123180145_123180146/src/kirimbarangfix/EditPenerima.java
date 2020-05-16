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


public class EditPenerima  extends JFrame {
    
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
    
    public EditPenerima(int id)
    {			 
        idk=id;
        
        Koneksi koneksi = new Koneksi();
        try {
            statement = koneksi.getConnection().createStatement();
            String sql = "SELECT * FROM kirim k JOIN penerima r ON k.id_penerima=r.id_penerima WHERE id_kirim='" + idk + "'";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                datas[0] = resultSet.getString("id_penerima");
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
        
	lJudul2 = new JLabel("Data Penerima : ");
	lJudul2.setFont(fJudul2);
	lJudul2.setForeground(new Color(0,0,0));

	lnm_penerima = new JLabel("Nama Penerima");
	lnm_penerima.setFont(fglobal);
	lnm_penerima.setForeground(new Color(0,0,0));

	fnm_penerima = new JTextField();
	fnm_penerima.setFont(fglobal);

	lalamat = new JLabel("Alamat");
	lalamat.setFont(fglobal);
	lalamat.setForeground(new Color(0,0,0));

	falamat = new JTextField();
	falamat.setFont(fglobal);

	lhp_penerima = new JLabel("No Telp");
	lhp_penerima.setFont(fglobal);
	lhp_penerima.setForeground(new Color(0,0,0));

	fhp_penerima = new JTextField();
	fhp_penerima.setFont(fglobal);

	bSave = new JButton("Simpan");
	bSave.setFont(fglobal);
	bSave.setBackground(new Color(204,204,255));

	bBack = new JButton("Kembali");
	bBack.setFont(fglobal);
	bBack.setBackground(new Color(204,204,255));
        
	getContentPane().setBackground(new Color(102,153,255));

        
	setLayout(null);
	add(lTittle);
        
        add(lJudul2);
	add(lnm_penerima);
	add(fnm_penerima);
        
	add(lalamat);
	add(falamat);
                                
	add(lhp_penerima);
	add(fhp_penerima);
        
	add(bBack);
        add(bSave);
                             
        lTittle.setBounds(1,30,474,30);
	lJudul2.setBounds(30, 70, 150, 30);
	lnm_penerima.setBounds(40, 110, 120, 30);
	fnm_penerima.setBounds(155, 110, 270, 30);
                                
	lalamat.setBounds(40, 150, 120, 30);
	falamat.setBounds(155, 150, 270, 30);
        
	lhp_penerima.setBounds(40, 190, 120, 30);
	fhp_penerima.setBounds(155, 190, 270, 30);
        
	bSave.setBounds(117, 240, 110, 30);
	bBack.setBounds(247, 240, 110,30);

	setSize(475, 340);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);


	bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		try {
                    idk=Integer.parseInt(datas[0]);
                    nm_penerima = fnm_penerima.getText();
                    alamat = falamat.getText();
                    hp_penerima = fhp_penerima.getText();
                    Data data = new Data(nm_penerima, hp_penerima, alamat);
                    Koneksi koneksi = new Koneksi();
                    try {
                        statement = koneksi.getConnection().createStatement();
                        statement.executeUpdate("UPDATE penerima SET nm_penerima='" + data.getnm_penerima() + "', alamat='"+data.getalamat()+"',hp_penerima='" + data.gethp_penerima() + "' WHERE id_penerima=" + idk + " ");
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


