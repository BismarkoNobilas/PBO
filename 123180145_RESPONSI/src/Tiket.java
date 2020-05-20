
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.sql.ResultSet;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.TableModel;

public class Tiket extends JFrame {
    JLabel lTittle, lnama, ljenkel, lstasiun, lkereta;
    JTextField fnama;
    javax.swing.JComboBox<String> fjenkel, fstasiun, fkereta;
    JTable tTable;
    JScrollPane scrollPane;
    JButton bTambah, bBack, bEdit, bHapus;
    ResultSet resultSet;
    Statement statement;
    String nama, jenkel, stasiun, kereta, rnama, rjenkel, rstasiun, rkereta;
    String[][] data = new String[500][4];
    String[] judul = {"Nama", "Jenis Kelamin", "Stasiun", "Kereta"};
    int index;
    

    public Tiket()
    {			 
        Font fJudul 	= new Font("Felix Titling", 0, 18);
        Font fJudul2 	= new Font("Bell MT", 0, 16);
	Font fglobal  = new Font("Times New Roman", 0, 14);
	setTitle("INPUT DATA");
	lTittle = new JLabel("TAMBAH TIKET");
	lTittle.setFont(fJudul);
        lTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

	lnama= new JLabel("Nama");
	lnama.setFont(fglobal);

	fnama = new JTextField();
	fnama.setFont(fglobal);

	ljenkel = new JLabel("Jenis Kelamin");
	ljenkel.setFont(fglobal);
                                
        fjenkel = new javax.swing.JComboBox<>();
        fjenkel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pria", "Wanita"}));
	fjenkel.setFont(fglobal);

	lstasiun = new JLabel("Stasiun Tujuan");
	lstasiun.setFont(fglobal);
                                
        fstasiun = new javax.swing.JComboBox<>();
        fstasiun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tugu Jogja", "Lempuyangan", "Maguwo"}));
	fstasiun.setFont(fglobal);

	lkereta = new JLabel("Stasiun Tujuan");
	lkereta.setFont(fglobal);
                                
        fkereta = new javax.swing.JComboBox<>();
        fkereta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ketandan", "Haua", "Prameks", "Pratameks", "Surya Kencas"}));
	fkereta.setFont(fglobal);

	bTambah = new JButton("Tambah");
	bTambah.setFont(fglobal);
	bTambah.setBackground(new Color(204,204,255));
           
	bEdit = new JButton("Edit");
	bEdit.setFont(fglobal);
	bEdit.setBackground(new Color(204,204,255));
        
	bHapus = new JButton("Hapus");
	bHapus.setFont(fglobal);
	bHapus.setBackground(new Color(204,204,255));
        
	bBack = new JButton("Kembali");
	bBack.setFont(fglobal);
	bBack.setBackground(new Color(204,204,255));
        
        
        tTable = new JTable(data, judul);
        tTable.setBackground(new Color(204,204,255));
        tTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tTableMouseClicked(evt);
            }
        });
        scrollPane = new JScrollPane(tTable);
        scrollPane.setBackground(new Color(204,204,255));

                           
	getContentPane().setBackground(new Color(102,153,255));

        
	setLayout(null);
	add(lTittle);
                            
	add(lnama);
	add(fnama);
                                
	add(ljenkel);
        add(fjenkel); 
        
	add(lstasiun);
        add(fstasiun);  
        
	add(lkereta);
        add(fkereta);
        
	add(bTambah);
	add(bEdit);
	add(bHapus);
	add(bBack);
        
        add(scrollPane);
                                
        lTittle.setBounds(1,30,989,30);
        
	lnama.setBounds(40, 110, 120, 30);
	fnama.setBounds(155, 110, 270, 30);
                                
	ljenkel.setBounds(40, 150, 120, 30);
	fjenkel.setBounds(155, 150, 270, 30);
        
	lstasiun.setBounds(40, 190, 120, 30);
	fstasiun.setBounds(155, 190, 270, 30);
        
	lkereta.setBounds(40, 230, 120, 30);
	fkereta.setBounds(155, 230, 270, 30);
                                
	bTambah.setBounds(143, 310, 110, 30);
	bEdit.setBounds(341, 310, 110, 30);
	bHapus.setBounds(539, 310, 110, 30);
	bBack.setBounds(737, 310, 110,30);
        
        scrollPane.setBounds(475, 110, 475, 150);

	setSize(990, 410);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

        Koneksi koneksi = new Koneksi();
        try {
            statement = koneksi.getConnection().createStatement();
            String sql = "SELECT * FROM daftartiket";
            resultSet = statement.executeQuery(sql);

            int row = 0;
            while (resultSet.next()){
                data[row][0] = resultSet.getString("nama");
                data[row][1] = resultSet.getString("jenkel");
                data[row][2] = resultSet.getString("stasiun");
                data[row][3] = resultSet.getString("kereta");
                row++;
            }
            statement.close();

        } catch (SQLException sqlError) {
        } catch (ClassNotFoundException classError) {
            JOptionPane.showMessageDialog(rootPane, "Driver tidak ditemukan !!");
        }

	bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Menu();
            }
	});

	bTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		try {
                    nama = fnama.getText();
                    jenkel = fjenkel.getSelectedItem().toString();
                    stasiun = fstasiun.getSelectedItem().toString();
                    kereta = fkereta.getSelectedItem().toString();
                    Koneksi koneksi = new Koneksi();
                    try {
                        statement = koneksi.getConnection().createStatement();
                        statement.executeUpdate("INSERT INTO daftartiket VALUES( '" + nama + "','" + jenkel + "','" + stasiun + "','" + kereta + "')");
                        statement.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        java.util.logging.Logger.getLogger(Tiket.class.getName()).log(Level.SEVERE, null, ex);
                    }
		} catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Tipe Data Salah");
		}catch (Error ext){
                    JOptionPane.showMessageDialog(rootPane, "SALAH!!");
		}
                setVisible(false);
                new Tiket();
            }
	});
        
        bEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		try {
                    nama = fnama.getText();
                    jenkel = fjenkel.getSelectedItem().toString();
                    stasiun = fstasiun.getSelectedItem().toString();
                    kereta = fkereta.getSelectedItem().toString();
                    Koneksi koneksi = new Koneksi();
                    try {
                        statement = koneksi.getConnection().createStatement();
                        statement.executeUpdate("UPDATE daftartiket SET jenkel='" + jenkel + "',stasiun='" + stasiun + "',kereta='" + kereta + "' where nama='" + nama + "'");
                        statement.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        java.util.logging.Logger.getLogger(Tiket.class.getName()).log(Level.SEVERE, null, ex);
                    }
		} catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Tipe Data Salah");
		}catch (Error ext){
                    JOptionPane.showMessageDialog(rootPane, "SALAH!!");
		}
                setVisible(false);
                new Tiket();
            }
	});
        
        bHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		try {
                    nama = fnama.getText();
                    Koneksi koneksi = new Koneksi();
                    try {
                        statement = koneksi.getConnection().createStatement();
                        statement.executeUpdate("DELETE FROM daftartiket WHERE nama ='" + nama + "'");
                        statement.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        java.util.logging.Logger.getLogger(Tiket.class.getName()).log(Level.SEVERE, null, ex);
                    }
		} catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Tipe Data Salah");
		}catch (Error ext){
                    JOptionPane.showMessageDialog(rootPane, "SALAH!!");
		}
                setVisible(false);
                new Tiket();
            }
	});
    }
    private void tTableMouseClicked(java.awt.event.MouseEvent evt) {  
        index = tTable.getSelectedRow();
        TableModel model = tTable.getModel();
        rnama = (String) model.getValueAt(index, 0);
        rjenkel = (String) model.getValueAt(index, 1);
        rstasiun = (String) model.getValueAt(index, 2);
        rkereta = (String) model.getValueAt(index, 3);
        fnama.setText(rnama);
        fnama.setEditable(false);
        fnama.setForeground(new Color(153,153,153));
        fnama.setText(rnama);
        fjenkel.setSelectedItem(rjenkel);
        fstasiun.setSelectedItem(rstasiun);
        fkereta.setSelectedItem(rkereta);
        
    }
}

