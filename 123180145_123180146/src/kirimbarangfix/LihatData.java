/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirimbarangfix;

/**
 *
 * @author Nadifsa
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LihatData extends JFrame {
    String[][] datas = new String[500][12];
    String[] kolom = {"ID Kirim", "Jenis Kirim", "Jenis Barang", "Berat", "Total Biaya", "Nama Pengirim", "Asal", "No Pengirim", "Nama Penerima", "Tujuan", "Alamat Pengirim","No Penerima"};
    JLabel lTitle;
    JTable tTable;
    JButton bBack, bHapus,bEdit;
    JScrollPane scrollPane;
    ResultSet resultSet;
    Statement statement;

    public LihatData(){
        setTitle("List Data");

        lTitle = new JLabel("Data pengiriman");
        lTitle.setFont(new Font("Felix Titling", 0, 18));
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle.setForeground(new Color(0,0,0));
        bBack = new JButton("Kembali");
        bBack.setFont(new Font("Times New Roman",Font.PLAIN, 14));
        bBack.setBackground(new Color(204,204,255));
        
        bHapus = new JButton("Hapus");
        bHapus.setFont(new Font("Times New Roman",Font.PLAIN, 14));
        bHapus.setBackground(new Color(204,204,255));
        
        bEdit = new JButton("Edit");
        bEdit.setFont(new Font("Times New Roman",Font.PLAIN, 14));
        bEdit.setBackground(new Color(204,204,255));
        
        
        tTable = new JTable(datas, kolom);
        tTable.setBackground(new Color(204,204,255));
        scrollPane = new JScrollPane(tTable);
        scrollPane.setBackground(new Color(204,204,255));

        getContentPane().setBackground(new Color(102,153,255));

        setLayout(null);
        add(lTitle);
        add(bBack);
        add(bHapus);
        add(bEdit);
        add(scrollPane);

        lTitle.setBounds(1,30,1349,30);
        scrollPane.setBounds(50, 70, 1250, 400);
        bEdit.setBounds(520, 490, 90, 30);
        bHapus.setBounds(630, 490, 90, 30);
        bBack.setBounds(740, 490, 90, 30);

        setSize(1350, 620);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Main();
            }
        });
        
        bHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new HapusData();
            }
        });
        
        bEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Edit();
            }
        });

        Koneksi koneksi = new Koneksi();
        try {
            statement = koneksi.getConnection().createStatement();
            String sql = "SELECT k.id_kirim, k.jeniskirim, k.jenisbarang, k.berat, k.total, m.nm_pengirim, m.asal, m.hp_pengirim, r.nm_penerima, r.tujuan, r.alamat, r.hp_penerima FROM kirim k JOIN pengirim m ON k.id_pengirim=m.id_pengirim JOIN penerima r ON k.id_penerima=r.id_penerima";
            resultSet = statement.executeQuery(sql);

            int row = 0;
            while (resultSet.next()){
                datas[row][0] = resultSet.getString("id_kirim");
                datas[row][1] = resultSet.getString("jeniskirim");
                datas[row][2] = resultSet.getString("jenisbarang");
                datas[row][3] = resultSet.getString("berat");
                datas[row][4] = resultSet.getString("total");
                datas[row][5] = resultSet.getString("nm_pengirim");
                datas[row][6] = resultSet.getString("asal");
                datas[row][7] = resultSet.getString("hp_pengirim");
                datas[row][8] = resultSet.getString("nm_penerima");
                datas[row][9] = resultSet.getString("tujuan");
                datas[row][10] = resultSet.getString("alamat");
                datas[row][11] = resultSet.getString("hp_penerima");
                row++;
            }
            statement.close();

        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(rootPane, "Data Gagal Ditampilkan" + sqlError);
        } catch (ClassNotFoundException classError) {
            JOptionPane.showMessageDialog(rootPane, "Driver tidak ditemukan !!");
        }
    }
}
