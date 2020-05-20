
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

public class Kereta extends JFrame {
    JLabel lTittle, lid, lnama, lkelas;
    JTextField fid, fnama, fkelas;
    JTable tTable;
    JScrollPane scrollPane;
    JButton bTambah, bBack, bEdit, bHapus;
    ResultSet resultSet;
    Statement statement;
    String rid, rnama, rkelas, id, nama, kelas;
    String[][] data = new String[500][3];
    String[] judul = {"ID Kereta", "Nama Kereta", "Kelas"};
    

    public Kereta()
    {			 
        Font fJudul 	= new Font("Felix Titling", 0, 18);
        Font fJudul2 	= new Font("Bell MT", 0, 16);
	Font fglobal  = new Font("Times New Roman", 0, 14);
	setTitle("INPUT DATA");
	lTittle = new JLabel("TAMBAH KERETA");
	lTittle.setFont(fJudul);
        lTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
	lid= new JLabel("ID Kereta");
	lid.setFont(fglobal);

	fid = new JTextField();
	fid.setFont(fglobal);

	lnama= new JLabel("Nama Kereta");
	lnama.setFont(fglobal);

	fnama = new JTextField();
	fnama.setFont(fglobal);

	lkelas= new JLabel("Kelas");
	lkelas.setFont(fglobal);

	fkelas = new JTextField();
	fkelas.setFont(fglobal);
        
        tTable = new JTable(data, judul);
        tTable.setBackground(new Color(204,204,255));
        tTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tTableMouseClicked(evt);
            }
        });
        scrollPane = new JScrollPane(tTable);
        scrollPane.setBackground(new Color(204,204,255));

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
                           
	getContentPane().setBackground(new Color(102,153,255));

        
	setLayout(null);
	add(lTittle);
                                 
	add(lid);
        add(fid);     
        
	add(lnama);
	add(fnama);
        
	add(lkelas);
        add(fkelas);  
        
	add(bTambah);
	add(bEdit);
	add(bHapus);
	add(bBack);
        
        add(scrollPane);
                                
        lTittle.setBounds(1,30,989,30);
        
	lid.setBounds(40, 110, 120, 30);
	fid.setBounds(155, 110, 270, 30);
                                
	lnama.setBounds(40, 150, 120, 30);
	fnama.setBounds(155, 150, 270, 30);
        
	lkelas.setBounds(40, 190, 120, 30);
	fkelas.setBounds(155, 190, 270, 30);
                                
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
            String sql = "SELECT * FROM daftarkereta";
            resultSet = statement.executeQuery(sql);

            int row = 0;
            while (resultSet.next()){
                data[row][0] = resultSet.getString("id_kereta");
                data[row][1] = resultSet.getString("nm_kereta");
                data[row][2] = resultSet.getString("kelas");
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
                    id = fid.getText();
                    nama = fnama.getText();
                    kelas = fkelas.getText();
                    Koneksi koneksi = new Koneksi();
                    try {
                        statement = koneksi.getConnection().createStatement();
                        statement.executeUpdate("INSERT INTO daftarkereta VALUES( '" + id + "','" + nama + "','" + kelas + "')");
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
                new Kereta();
            }
	});
        
        bEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		try {
                    id = fid.getText();
                    nama = fnama.getText();
                    kelas = fkelas.getText();
                    Koneksi koneksi = new Koneksi();
                    try {
                        statement = koneksi.getConnection().createStatement();
                        statement.executeUpdate("UPDATE daftarkereta SET nm_kereta='" + nama + "',kelas='" + kelas + "' where id_kereta='" + id + "'");
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
                new Kereta();
            }
	});
        
        bHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		try {
                    id = fid.getText();
                    Koneksi koneksi = new Koneksi();
                    try {
                        statement = koneksi.getConnection().createStatement();
                        statement.executeUpdate("DELETE FROM daftarkereta WHERE id_kereta ='" + id + "'");
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
                new Kereta();
            }
	});
    }
    private void tTableMouseClicked(java.awt.event.MouseEvent evt) {  
        int index = tTable.getSelectedRow();
        TableModel model = tTable.getModel();
        rid = (String) model.getValueAt(index, 0);
        rnama = (String) model.getValueAt(index, 1);
        rkelas = (String) model.getValueAt(index, 2);
        fid.setText(rid);
        fid.setEditable(false);
        fid.setForeground(new Color(153,153,153));
        fnama.setText(rnama);
        fkelas.setText(rkelas);
        
    }
}

