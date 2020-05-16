
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
import javax.swing.JList;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class HasilData extends JFrame
{
    ResultSet resultSet;
    JLabel lTittle, lJudul1, lJudul2, lJudul3, lnm_pengirim, lasal, lhp_pengirim, lnm_penerima, ltujuan, lhp_penerima, lalamat, ljenkim, ljenbar, lberat, fasal, ftujuan, fjenkim, fjenbar, fberat, fnm_pengirim, fhp_pengirim, fnm_penerima, fhp_penerima, falamat, ltotal, ftotal;
    JButton bOk;
    JList sasal;
    Statement statement, statement2;
    String nm_pengirim, asal, hp_pengirim, nm_penerima, tujuan, hp_penerima, alamat, jenkim, jenbar,  berat;
    int abdata,abdata2, abdata3, abdata4, harkim, harbar, harjak, hartot, idk;
    String[] datas = new String[12];
    
    public HasilData(int id)
    {			 
        idk=id;
        
        Koneksi koneksi = new Koneksi();
        try {
            statement = koneksi.getConnection().createStatement();
            String sql = "SELECT k.jeniskirim, k.jenisbarang, k.berat, k.total, m.nm_pengirim, m.asal, m.hp_pengirim, r.nm_penerima, r.tujuan, r.alamat, r.hp_penerima FROM kirim k JOIN pengirim m ON k.id_pengirim=m.id_pengirim JOIN penerima r ON k.id_penerima=r.id_penerima WHERE id_kirim='" + idk + "'";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                datas[0] = resultSet.getString("jeniskirim");
                datas[1] = resultSet.getString("jenisbarang");
                datas[2] = resultSet.getString("berat");
                datas[3] = resultSet.getString("total");
                datas[4] = resultSet.getString("nm_pengirim");
                datas[5] = resultSet.getString("asal");
                datas[6] = resultSet.getString("hp_pengirim");
                datas[7] = resultSet.getString("nm_penerima");
                datas[8] = resultSet.getString("tujuan");
                datas[9] = resultSet.getString("alamat");
                datas[10] = resultSet.getString("hp_penerima");
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
	setTitle("INPUT DATA");
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
        
	fnm_pengirim = new JLabel(datas[4]);
	fnm_pengirim.setFont(fglobal);
	fnm_pengirim.setForeground(new Color(0,0,0));

	lasal = new JLabel("Provinsi Asal");
	lasal.setFont(fglobal);
	lasal.setForeground(new Color(0,0,0));
                                
	fasal = new JLabel(datas[5]);
	fasal.setFont(fglobal);
	fasal.setForeground(new Color(0,0,0));

	lhp_pengirim = new JLabel("No Telp");
	lhp_pengirim.setFont(fglobal);
	lhp_pengirim.setForeground(new Color(0,0,0));

	fhp_pengirim = new JLabel(datas[6]);
	fhp_pengirim.setFont(fglobal);
	fhp_pengirim.setForeground(new Color(0,0,0));
        
	lJudul2 = new JLabel("Data Penerima : ");
	lJudul2.setFont(fJudul2);
	lJudul2.setForeground(new Color(0,0,0));

	lnm_penerima = new JLabel("Nama Penerima");
	lnm_penerima.setFont(fglobal);
	lnm_penerima.setForeground(new Color(0,0,0));
        
	fnm_penerima = new JLabel(datas[7]);
	fnm_penerima.setFont(fglobal);
	fnm_penerima.setForeground(new Color(0,0,0));

	ltujuan = new JLabel("Provinsi Tujuan");
	ltujuan.setFont(fglobal);
	ltujuan.setForeground(new Color(0,0,0));
        
	ftujuan = new JLabel(datas[8]);
	ftujuan.setFont(fglobal);
	ftujuan.setForeground(new Color(0,0,0));
                
	lalamat = new JLabel("Alamat");
	lalamat.setFont(fglobal);
	lalamat.setForeground(new Color(0,0,0));
        
	falamat = new JLabel(datas[9]);
	falamat.setFont(fglobal);
	falamat.setForeground(new Color(0,0,0));

	lhp_penerima = new JLabel("No Telp");
	lhp_penerima.setFont(fglobal);
	lhp_penerima.setForeground(new Color(0,0,0));

	fhp_penerima = new JLabel(datas[10]);
	fhp_penerima.setFont(fglobal);
	fhp_penerima.setForeground(new Color(0,0,0));
        
	bOk = new JButton("Ok");
	bOk.setFont(fglobal);
	bOk.setBackground(new Color(204,204,255));
        
	lJudul3 = new JLabel("Data Barang : ");
	lJudul3.setFont(fJudul2);
	lJudul3.setForeground(new Color(0,0,0));

	ljenkim = new JLabel("Jenis Kirim");
	ljenkim.setFont(fglobal);
	ljenkim.setForeground(new Color(0,0,0));

	fjenkim = new JLabel(datas[0]);
	fjenkim.setFont(fglobal);
	fjenkim.setForeground(new Color(0,0,0));

	ljenbar = new JLabel("Jenis Barang");
	ljenbar.setFont(fglobal);
	ljenbar.setForeground(new Color(0,0,0));

	fjenbar = new JLabel(datas[1]);
	fjenbar.setFont(fglobal);
	fjenbar.setForeground(new Color(0,0,0));

	lberat = new JLabel("Berat Barang");
	lberat.setFont(fglobal);
	lberat.setForeground(new Color(0,0,0));

	fberat = new JLabel(datas[2]);
	fberat.setFont(fglobal);
	fberat.setForeground(new Color(0,0,0));
                                
	ltotal = new JLabel("Total Harga");
	ltotal.setFont(fglobal);
	ltotal.setForeground(new Color(0,0,0));

	ftotal = new JLabel(datas[3]);
	ftotal.setFont(fglobal);
	ftotal.setForeground(new Color(0,0,0));
                                
	getContentPane().setBackground(new Color(102,153,255));

        
	setLayout(null);
	add(lTittle);
        
        add(lJudul1);                        
	add(lnm_pengirim);
	add(fnm_pengirim);
                                
	add(lasal);
        add(fasal);
                                
	add(lhp_pengirim);
	add(fhp_pengirim);

        add(lJudul2);
	add(lnm_penerima);
	add(fnm_penerima);
                                
	add(ltujuan);
        add(ftujuan);
                                
	add(lalamat);
	add(falamat);
                                
	add(lhp_penerima);
	add(fhp_penerima);
        
        add(lJudul3);
        add(ljenkim);
        add(fjenkim);
        
        add(ljenbar);
        add(fjenbar);
        
        add(lberat);
        add(fberat);
        
        add(ltotal);
        add(ftotal);
        
	add(bOk);
                                  
        lTittle.setBounds(1,30,474,30);
        
	lJudul1.setBounds(30, 70, 150, 30);
	lnm_pengirim.setBounds(40, 110, 120, 30);
	fnm_pengirim.setBounds(155, 110, 270, 30);
                                
	lasal.setBounds(40, 150, 120, 30);
	fasal.setBounds(155, 150, 270, 25);
                                
	lhp_pengirim.setBounds(40, 190, 150, 30);
	fhp_pengirim.setBounds(155, 190, 270, 30);

	lJudul2.setBounds(30, 240, 150, 30);
	lnm_penerima.setBounds(40, 280, 120, 30);
	fnm_penerima.setBounds(155, 280, 270, 30);
                                
	ltujuan.setBounds(40, 320, 120, 30);
	ftujuan.setBounds(155, 320, 270, 30);
                                
	lalamat.setBounds(40, 360, 120, 30);
	falamat.setBounds(155, 360, 270, 30);
        
	lhp_penerima.setBounds(40, 400, 120, 30);
	fhp_penerima.setBounds(155, 400, 270, 30);
        
	lJudul3.setBounds(30, 450, 150, 30);
	ljenkim.setBounds(40, 490, 120, 30);
	fjenkim.setBounds(155, 490, 270, 30);
        
	ljenbar.setBounds(40, 530, 120, 30);
	fjenbar.setBounds(155, 530, 270, 30);
        
	lberat.setBounds(40, 570, 120, 30);
	fberat.setBounds(155, 570, 270, 30);

	ltotal.setBounds(40, 610, 120, 30);
	ftotal.setBounds(155, 610, 270, 30);

	bOk.setBounds(183, 700, 110, 30);

	setSize(475, 800);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);


	bOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Menu();
            }
	});
    }

}
