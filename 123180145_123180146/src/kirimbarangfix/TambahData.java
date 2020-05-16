package kirimbarangfix;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.sql.ResultSet;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class TambahData extends JFrame {
    ResultSet resultSet;
    JLabel lTittle, lJudul1, lJudul2, lJudul3, lnm_pengirim, lasal, lhp_pengirim, lnm_penerima, ltujuan, lhp_penerima, lalamat, ljenkim, ljenbar, lberat;
    JTextField fnm_pengirim, fhp_pengirim, fnm_penerima, fhp_penerima, falamat;
    JButton bSave, bBack;
    JList sasal;
    javax.swing.JComboBox<String> fasal, ftujuan, fjenkim, fjenbar, fberat;
    Statement statement, statement2;
    String nm_pengirim, asal, hp_pengirim, nm_penerima, tujuan, hp_penerima, alamat, jenkim, jenbar,  berat;
    int abdata,abdata2, abdata3, abdata4, harkim, harbar, harjak, hartot, abdata5;

    public TambahData()
    {			 
        Font fJudul 	= new Font("Felix Titling", 0, 18);
        Font fJudul2 	= new Font("Bell MT", 0, 16);
	Font fglobal  = new Font("Times New Roman", 0, 14);
	setTitle("INPUT DATA");
	lTittle = new JLabel("INPUT DATA");
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

	lasal = new JLabel("Provinsi Asal");
	lasal.setFont(fglobal);
	lasal.setForeground(new Color(0,0,0));
                                
        fasal = new javax.swing.JComboBox<>();
        fasal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DKI Jakarta", "Jawa Tengah", "Yogyakarta"}));
	fasal.setFont(fglobal);

	lhp_pengirim = new JLabel("No Telp");
	lhp_pengirim.setFont(fglobal);
	lhp_pengirim.setForeground(new Color(0,0,0));

	fhp_pengirim = new JTextField();
	fhp_pengirim.setFont(fglobal);
        
	lJudul2 = new JLabel("Data Penerima : ");
	lJudul2.setFont(fJudul2);
	lJudul2.setForeground(new Color(0,0,0));

	lnm_penerima = new JLabel("Nama Penerima");
	lnm_penerima.setFont(fglobal);
	lnm_penerima.setForeground(new Color(0,0,0));

	fnm_penerima = new JTextField();
	fnm_penerima.setFont(fglobal);

	ltujuan = new JLabel("Provinsi Tujuan");
	ltujuan.setFont(fglobal);
	ltujuan.setForeground(new Color(0,0,0));

        ftujuan = new javax.swing.JComboBox<>();
        ftujuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banten", "DKI Jakarta", "Jawa Barat", "Jawa Tengah", "Yogyakarta","Jawa Timur"}));
	ftujuan.setFont(fglobal);
                                
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
        
	lJudul3 = new JLabel("Data Barang : ");
	lJudul3.setFont(fJudul2);
	lJudul3.setForeground(new Color(0,0,0));

	ljenkim = new JLabel("Jenis Kirim");
	ljenkim.setFont(fglobal);
	ljenkim.setForeground(new Color(0,0,0));

        fjenkim = new javax.swing.JComboBox<>();
        fjenkim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Biasa", "Express"}));
	fjenkim.setFont(fglobal);

	ljenbar = new JLabel("Jenis Barang");
	ljenbar.setFont(fglobal);
	ljenbar.setForeground(new Color(0,0,0));

        fjenbar = new javax.swing.JComboBox<>();
        fjenbar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Biasa", "Mudah Pecah", "Jangan Terbalik", "Mudah Pecah dan Jangan Terbalik", "Penting"}));
	fjenbar.setFont(fglobal);

	lberat = new JLabel("Berat Barang");
	lberat.setFont(fglobal);
	lberat.setForeground(new Color(0,0,0));

        fberat = new javax.swing.JComboBox<>();
        fberat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25"}));
	fberat.setFont(fglobal);
                                
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
        
	add(bSave);
	add(bBack);
                                
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

	bSave.setBounds(117, 650, 110, 30);
	bBack.setBounds(247, 650, 110,30);

	setSize(475, 750);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);


	bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Menu();
            }
	});

	bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		try {
                    nm_pengirim = fnm_pengirim.getText();
                    asal = fasal.getSelectedItem().toString();
                    hp_pengirim = fhp_pengirim.getText();
                    nm_penerima = fnm_penerima.getText();
                    tujuan = ftujuan.getSelectedItem().toString();
                    alamat = falamat.getText();
                    hp_penerima = fhp_penerima.getText();
                    jenkim = fjenkim.getSelectedItem().toString();
                    jenbar = fjenbar.getSelectedItem().toString();
                    berat = fberat.getSelectedItem().toString();
                    Data data = new Data(nm_pengirim, asal, hp_pengirim, nm_penerima, tujuan, hp_penerima, alamat, jenkim, jenbar, berat);
                    if(jenkim=="Express")
                    {
                        harkim=2;
                    }
                    else
                    {
                        harkim=1;
                    }
                    if(jenbar=="Biasa")
                    {
                        harbar=100;
                    }
                    else if(jenbar=="Mudah Pecah")
                    {
                        harbar=110;
                    }
                    else if(jenbar=="Jangan Terbalik")
                    {
                        harbar=120;
                    }
                    else if(jenbar=="Penting")
                    {
                        harbar=115;
                    }
                    else
                    {
                        harbar=130;
                    }
                    Koneksi koneksi = new Koneksi();
                    try {
                        statement = koneksi.getConnection().createStatement();
                        statement.executeUpdate("INSERT INTO pengirim(nm_pengirim,asal,hp_pengirim) VALUES( '" + data.getnm_pengirim() + "','" + data.getasal() + "','" + data.gethp_pengirim() + "')");
			statement.executeUpdate("INSERT INTO penerima(nm_penerima,tujuan,alamat,hp_penerima) VALUES( '" + data.getnm_penerima() + "','" + data.gettujuan() + "','" + data.getalamat() + "','" + data.gethp_penerima() + "')");
			statement.close();
                        statement2 = koneksi.getConnection().createStatement();
                        String sql = "SELECT * FROM pengirim WHERE nm_pengirim='"+data.getnm_pengirim()+"' and hp_pengirim='" + data.gethp_pengirim() + "'";
                        resultSet = statement2.executeQuery(sql);
                        while (resultSet.next()){
                            abdata= resultSet.getInt("id_pengirim");
                        }
                        String sql2 = "SELECT * FROM penerima WHERE nm_penerima='"+data.getnm_penerima()+"' and hp_penerima='" + data.gethp_penerima() + "'";
                        resultSet = statement2.executeQuery(sql2);
                        while (resultSet.next()){
                            abdata2= Integer.parseInt(resultSet.getString("id_penerima"));
                        }
                        String sql3 = "SELECT * FROM biaya WHERE asal='" + data.getasal() + "' and tujuan='" + data.gettujuan() + "'";
                        resultSet = statement2.executeQuery(sql3);
                        while (resultSet.next()){
                            abdata3= Integer.parseInt(resultSet.getString("id_biaya"));
                            abdata4= Integer.parseInt(resultSet.getString("biaya"));
                        }
                        hartot=(((Integer.parseInt(berat)*1000)+abdata4)*harbar/100)*harkim;
			statement2.executeUpdate("INSERT INTO kirim(jeniskirim,jenisbarang,berat,id_biaya,total,id_pengirim,id_penerima) VALUES( '" + data.getjenkim() + "','" + data.getjenbar() + "','" + data.getberat() + "'," + abdata3 + ","+hartot+"," + abdata + "," + abdata2 + ")");
			String sql4 = "SELECT id_kirim FROM kirim";
                        resultSet = statement2.executeQuery(sql4);
                        while (resultSet.next()){
                            abdata5= Integer.parseInt(resultSet.getString("id_kirim"));
                        }		
                        JOptionPane.showMessageDialog(rootPane, "Data Berhasil Disimpan");
                        statement2.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        java.util.logging.Logger.getLogger(TambahData.class.getName()).log(Level.SEVERE, null, ex);
                    }
		} catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Tipe Data Salah");
		}catch (Error ext){
                    JOptionPane.showMessageDialog(rootPane, "SALAH!!");
		}
                setVisible(false);
                new HasilData(abdata5);
            }
	});
    }
}

