package library;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserViewBook extends javax.swing.JFrame {

    public UserViewBook() throws SQLException {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        initComponents();
        DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();

        try (Connection Con = DB.getConnection()) {
            PreparedStatement ps = Con.prepareStatement(
                    "select Books.BookID, Books.BookName,Books.Genre,Books.Author,Books.Publisher, Books.Row,Books.Shelf, IssuedBook.MatricsNo from Books left outer join IssuedBook on Books.BookID= IssuedBook.BookID;",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();

            int colnum = rsmd.getColumnCount();

            String Row[];
            String Check = "";
            Row = new String[colnum];
            while (rs.next()) {
                for (int i = 1; i <= colnum; i++) {
                    if (i == colnum) {
                        if (rs.getString(i) == null)
                            Row[i - 1] = "Not Issued";
                        else
                            Row[i - 1] = "Issued";
                        System.out.println(rs.getString(i));
                    } else
                        Row[i - 1] = rs.getString(i);

                }
                model.addRow(Row);

            }
            Con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        NameRadio = new javax.swing.JRadioButton();
        AuthorRadio = new javax.swing.JRadioButton();
        NotIssued = new javax.swing.JRadioButton();
        SearchField = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        ShowALL = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Book ID", "Name", "Genre", "Author", "Publisher", "Shelf", "Row", "Available"
                }) {
            Class[] types = new Class[] {
                    java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Montserrat Black", 0, 36)); // NOI18N
        jLabel1.setText("BOOKS");

        jButton1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        NameRadio.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        NameRadio.setText("Name");
        NameRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameRadioActionPerformed(evt);
            }
        });

        AuthorRadio.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        AuthorRadio.setText("Author");
        AuthorRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuthorRadioActionPerformed(evt);
            }
        });

        NotIssued.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        NotIssued.setText("NOT ISSUED");
        NotIssued.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotIssuedActionPerformed(evt);
            }
        });

        Search.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        ShowALL.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        ShowALL.setText("Show All");
        ShowALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowALLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(698, 698, 698)
                                                .addComponent(jButton1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        1464, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(725, 725, 725)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(452, 452, 452)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                layout.createSequentialGroup()
                                                                        .addComponent(NameRadio)
                                                                        .addGap(69, 69, 69)
                                                                        .addComponent(AuthorRadio)
                                                                        .addGap(82, 82, 82)
                                                                        .addComponent(NotIssued))
                                                        .addComponent(SearchField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 426,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(31, 31, 31)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ShowALL))))
                                .addContainerGap(29, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(NameRadio)
                                        .addComponent(AuthorRadio)
                                        .addComponent(NotIssued)
                                        .addComponent(ShowALL, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Search, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(21, 21, 21)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code hereset
        this.dispose();
    }// GEN-LAST:event_jButton1ActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
        if ("".equals(SearchField.getText()))
            JOptionPane.showMessageDialog(UserViewBook.this, "Search Filed is Empty", "Search Error!",
                    JOptionPane.ERROR_MESSAGE);

        if (!ShowALL.isSelected())
            if (!NotIssued.isSelected())
                ShowALL.setEnabled(true);

        int flag = 0;
        if (ShowALL.isSelected())
            flag = 0;
        if (NotIssued.isSelected())
            flag = 1;
        DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();
        while (model.getRowCount() > 0)
            model.removeRow(model.getRowCount() - 1);
        if (NameRadio.isSelected()) {

            String Search = "%" + SearchField.getText() + "%";
            try (Connection Con = DB.getConnection()) {
                PreparedStatement ps = Con.prepareStatement(
                        "select A.BookID, A.BookName,A.Genre,A.Author,A.Publisher, A.Row,A.Shelf, IssuedBook.MatricsNo from (select * from Books where BookName like ?) as A left outer join IssuedBook on A.BookID= IssuedBook.BookID",
                        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ps.setString(1, Search);
                ResultSet rs = ps.executeQuery();

                ResultSetMetaData rsmd = rs.getMetaData();

                int colnum = rsmd.getColumnCount();

                String Row[];
                Row = new String[colnum];
                while (rs.next()) {
                    for (int i = 1; i <= colnum; i++) {
                        if (i == colnum) {
                            if (rs.getString(i) == null) {
                                Row[i - 1] = "Not Issued";
                                model.addRow(Row);
                            } else {
                                if (flag == 1)
                                    continue;
                                Row[i - 1] = "Issued";
                                model.addRow(Row);

                            }

                            System.out.println(rs.getString(i));
                        } else
                            Row[i - 1] = rs.getString(i);

                    }

                }
                int rowcount = model.getRowCount();
                System.out.println(rowcount);
                if (rowcount == 0) {
                    String NoRow[];
                    NoRow = new String[7];
                    NoRow[3] = "NO";
                    NoRow[4] = "RESULT";
                    NoRow[0] = "";
                    NoRow[1] = "";
                    NoRow[2] = "";
                    NoRow[5] = "";
                    NoRow[6] = "";
                    model.addRow(NoRow);

                }
                Con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        else if (AuthorRadio.isSelected()) {

            String Search = "%" + SearchField.getText() + "%";
            try (Connection Con = DB.getConnection()) {
                PreparedStatement ps = Con.prepareStatement(
                        "select A.BookID, A.BookName,A.Genre,A.Author,A.Publisher, A.Row,A.Shelf, IssuedBook.MatricsNo from (select * from Books where Author like ?) as A left outer join IssuedBook on A.BookID= IssuedBook.BookID",
                        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ps.setString(1, Search);
                ResultSet rs = ps.executeQuery();

                ResultSetMetaData rsmd = rs.getMetaData();

                int colnum = rsmd.getColumnCount();

                String Row[];
                Row = new String[colnum];
                while (rs.next()) {
                    for (int i = 1; i <= colnum; i++) {
                        if (i == colnum) {
                            if (rs.getString(i) == null) {
                                Row[i - 1] = "Not Issued";
                                model.addRow(Row);
                            } else {
                                if (flag == 1)
                                    continue;
                                Row[i - 1] = "Issued";
                                model.addRow(Row);
                            }
                            System.out.println(rs.getString(i));
                        } else
                            Row[i - 1] = rs.getString(i);
                    }

                }
                int rowcount = model.getRowCount();
                System.out.println(rowcount);
                if (rowcount == 0) {
                    String NoRow[];
                    NoRow = new String[7];
                    NoRow[3] = "NO";
                    NoRow[4] = "RESULT";
                    NoRow[0] = "";
                    NoRow[1] = "";
                    NoRow[2] = "";
                    NoRow[5] = "";
                    NoRow[6] = "";
                    model.addRow(NoRow);

                }
                Con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        else {

            JOptionPane.showMessageDialog(UserViewBook.this, "Select Name or Author", "No Selection!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_SearchActionPerformed

    private void AuthorRadioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_AuthorRadioActionPerformed
        // TODO add your handling code here:
        NameRadio.setSelected(false);
    }// GEN-LAST:event_AuthorRadioActionPerformed

    private void NameRadioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_NameRadioActionPerformed
        // TODO add your handling code here:
        AuthorRadio.setSelected(false);
    }// GEN-LAST:event_NameRadioActionPerformed

    private void NotIssuedActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_NotIssuedActionPerformed
        // TODO add your handling code here:
        ShowALL.setSelected(false);

    }// GEN-LAST:event_NotIssuedActionPerformed

    private void ShowALLActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ShowALLActionPerformed
        // TODO add your handling code here:
        AuthorRadio.setSelected(false);
        NameRadio.setSelected(false);
        DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();
        while (model.getRowCount() > 0)
            model.removeRow(model.getRowCount() - 1);

        if (!ShowALL.isSelected() && !NotIssued.isSelected()) {
            ShowALL.setSelected(true);
        }

        int flag = 0;
        if (ShowALL.isSelected())
            flag = 0;
        if (NotIssued.isSelected())
            flag = 1;

        try (Connection Con = DB.getConnection()) {
            PreparedStatement ps = Con.prepareStatement(
                    "select Books.BookID, Books.BookName,Books.Genre,Books.Author,Books.Publisher, Books.Row,Books.Shelf, IssuedBook.MatricsNo from Books left outer join IssuedBook on Books.BookID= IssuedBook.BookID;",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();

            int colnum = rsmd.getColumnCount();

            String Row[];
            String Check = "";
            Row = new String[colnum];
            while (rs.next()) {
                for (int i = 1; i <= colnum; i++) {
                    if (i == colnum) {
                        if (rs.getString(i) == null) {
                            Row[i - 1] = "Not Issued";
                            model.addRow(Row);
                        } else {
                            if (flag == 1)
                                continue;
                            Row[i - 1] = "Issued";
                            model.addRow(Row);
                        }
                        System.out.println(rs.getString(i));
                    } else
                        Row[i - 1] = rs.getString(i);

                }

            }
            Con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }// GEN-LAST:event_ShowALLActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new UserViewBook().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(UserViewBook.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AuthorRadio;
    private javax.swing.JRadioButton NameRadio;
    private javax.swing.JRadioButton NotIssued;
    private javax.swing.JButton Search;
    private javax.swing.JTextField SearchField;
    private javax.swing.JButton ShowALL;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
