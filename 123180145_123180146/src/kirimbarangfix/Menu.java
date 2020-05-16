
package kirimbarangfix;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class Menu extends JFrame {
    JLabel lTittle;
    JButton bMenu1, bMenu2, bExit;

    public void  Menu(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        
        setTitle("PENGIRIMAN BARANG");
        lTittle = new JLabel("PENDATAAN PENGIRIMAN BARANG");
        lTittle.setFont(new Font("Felix Titling", 0, 18));
        lTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTittle.setForeground(new Color(0,0,0));
        bMenu1 = new JButton("TAMBAH DATA");
        bMenu1.setFont(new Font("Times New Roman",0, 16));
        bMenu1.setBackground(new Color(204,204,255));
        bMenu2 = new JButton("LIHAT DATA");
        bMenu2.setFont(new Font("Times New Roman",0, 16));
        bMenu2.setBackground(new Color(204,204,255));
        bExit = new JButton("Exit ");
        bExit.setFont(new Font("Times New Roman",0, 16));
        bExit.setBackground(new Color(204,204,255));

        getContentPane().setBackground(new Color(102,153,255));

        setLayout(null);
        add(lTittle);
        add(bMenu1);
        add(bMenu2);
        add(bExit);

        lTittle.setBounds(1,30,429,30);
        bMenu1.setBounds(100, 80, 220, 30);
        bMenu2.setBounds(100, 120, 220, 30);
        bExit.setBounds(100, 180, 220, 30);

        setSize(430, 330);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bMenu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TambahData();
            }
        });
        bMenu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LihatData();
            }
        });
        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
