import javax.swing.*;

class Frame1 {
   public static void main(String[] args) {
	GUI g = new GUI();
   }
}

class GUI extends JFrame {
   final JTextField fnama = new JTextField(10);
   final JTextField fAlamat1 = new JTextField(15);
   final JTextField fAlamat2 = new JTextField(15);
   
   JLabel lnama = new JLabel(" Nama Lengkap ");
   JLabel lAlamat = new JLabel(" Alamat ");
   JLabel lProvinsi = new JLabel(" - Provinsi ");
   JLabel lKota = new JLabel(" - Kota ");
   
   JLabel ljeniskelamin = new JLabel(" Jenis Kelamin ");

   JRadioButton rbPria = new JRadioButton(" Laki-Laki ");
   JRadioButton rbWanita = new JRadioButton("perempuan ");

   JLabel lagama = new JLabel(" Agama ");
   String[] namaAgama =
            {"Islam","Kristen","Katolik","Hindu","Budha"};
   JComboBox cmbAgama = new JComboBox(namaAgama);
   
   JLabel lSek = new JLabel(" Sekolah ");

   JCheckBox cbSD = new JCheckBox(" SD ");
   JCheckBox cbSMP = new JCheckBox(" SMP ");
   JCheckBox cbSMAK = new JCheckBox(" SMA/SMK ");
   JCheckBox cbS1 = new JCheckBox(" S1 ");
   JCheckBox cbS2 = new JCheckBox(" S2 ");
   JCheckBox cbS3 = new JCheckBox(" S3 ");

   JButton btnSave = new JButton("Comfirm");
   
   public GUI() {
	setTitle("Form");
	setDefaultCloseOperation(3);
	setSize(500,300);

	ButtonGroup group = new ButtonGroup();
	group.add(rbPria);
	group.add(rbWanita);

	setLayout(null);
	add(lnama);
	add(fnama);
	add(lAlamat);
	add(lAlamat);
        add(lKota);
        add(lProvinsi);
	add(fAlamat1);
	add(fAlamat2);
	add(ljeniskelamin);
	add(rbPria);
	add(rbWanita);
	add(lagama);
	add(cmbAgama);
	add(lSek);
	add(cbSD);
	add(cbSMP);
	add(cbSMAK);
	add(cbS1);
	add(cbS2);
	add(cbS3);
	add(btnSave);

	// setBounds(m,n,o,p)
	// m = posisi x; n = posisi n
	// o = panjang komponen; p = tinggi komponen
	lnama.setBounds(10,10,120,20);
	fnama.setBounds(130,10,150,20);
	lAlamat.setBounds(10,35,120,20);
        lProvinsi.setBounds(130,35,120,20);
        lKota.setBounds(290,35,120,20);
	fAlamat1.setBounds(130,60,150,20);
	fAlamat2.setBounds(290,60,150,20);
	ljeniskelamin.setBounds(10,85,120,20);
	rbPria.setBounds(130,85,100,20);
	rbWanita.setBounds(230,85,100,20);
	lagama.setBounds(10,110,150,20);
	cmbAgama.setBounds(130,110,150,20);
	lSek.setBounds(10,135,120,20);
	cbSD.setBounds (130,135,70,20);
	cbSMP.setBounds(210,135,70,20);
	cbSMAK.setBounds(290,135,100,20);
	cbS1.setBounds(130,150,70,20);
	cbS2.setBounds(210,150,70,20);
	cbS3.setBounds(290,150,100,20);
	btnSave.setBounds(100,180,120,20);
	setVisible(true);
   }
}
