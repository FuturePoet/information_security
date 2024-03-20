
import java.util.List;
import java.util.*;
import javax.swing.JOptionPane;
public class Dplayfairfram extends javax.swing.JFrame {
    public static List<String> preparingText(String text, String key) {
        String alpha = "abcdefghiklmnopqrstuvwxyz";
        List<String> matrix = new ArrayList<>();

        key = key.toLowerCase();
        text = text.toLowerCase();

        key = key.replace("j", "i");
        text = text.replace("j", "i");

        for (char c : (key + alpha).toCharArray()) {
            if (!matrix.contains(String.valueOf(c))) {
                matrix.add(String.valueOf(c));
            }
        }

        int n = 0;
        List<String> subTexts = new ArrayList<>();
        while (n < text.length()) {
            subTexts.add(text.substring(n, Math.min(n + 2, text.length())));

            if (!Character.isAlphabetic(subTexts.get(subTexts.size() - 1).charAt(0))) {
                n++;
                subTexts.set(subTexts.size() - 1, subTexts.get(subTexts.size() - 1).substring(0, 1));
                continue;
            } else if (subTexts.get(subTexts.size() - 1).length() > 1 && !Character.isAlphabetic(subTexts.get(subTexts.size() - 1).charAt(1))) {
                subTexts.add(subTexts.get(subTexts.size() - 1).substring(1));
                subTexts.set(subTexts.size() - 2, subTexts.get(subTexts.size() - 2).substring(0, 1) + "x");
                n += 2;
                continue;
            }

            if (subTexts.get(subTexts.size() - 1).length() == 1) {
                subTexts.set(subTexts.size() - 1, subTexts.get(subTexts.size() - 1) + "x");
            } else if (subTexts.get(subTexts.size() - 1).charAt(0) == subTexts.get(subTexts.size() - 1).charAt(1)) {
                subTexts.set(subTexts.size() - 1, text.substring(n, Math.min(n + 1, text.length())) + "x");
                n--;
            }
            n += 2;
        }

        return subTexts;
    }

    public static String decryptionPlayfairCipher(String text, String key) {
        StringBuilder decryption = new StringBuilder();
        List<String> subText = preparingText(text, key);
        int n = 0;

        for (String i : subText) {
            if (!i.matches("[a-zA-Z]+")) {
                decryption.append(i);
                continue;
            }

            n += 2;
            int col1, row1, col2, row2;

            row1 = matrix.indexOf(String.valueOf(i.charAt(0))) / 5;
            col1 = matrix.indexOf(String.valueOf(i.charAt(0))) % 5;
            row2 = matrix.indexOf(String.valueOf(i.charAt(1))) / 5;
            col2 = matrix.indexOf(String.valueOf(i.charAt(1))) % 5;

            if (row1 == row2) {
                col1 = (col1 - 1 + 5) % 5;
                col2 = (col2 - 1 + 5) % 5;
            } else if (col1 == col2) {
                row1 = (row1 - 1 + 5) % 5;
                row2 = (row2 - 1 + 5) % 5;
            } else {
                int temp = col1;
                col1 = col2;
                col2 = temp;
            }

            decryption.append(matrix.get((row1 * 5) + col1)).append(matrix.get((row2 * 5) + col2));

            if (n > 3 && decryption.charAt(decryption.length() - 2) == decryption.charAt(decryption.length() - 4) && decryption.charAt(decryption.length() - 3) == 'x') {
                decryption.deleteCharAt(decryption.length() - 3);
            }
        }

        String x="\nThe Decryption of your Text [" + text + "] using Playfair Cipher Decryption is [" + decryption + "]";
        return x;
    }

    private static List<String> matrix;
    
    
    
    
    
    
    
    
    
    
    
    public Dplayfairfram() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        key = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        plaintext = new javax.swing.JTextPane();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Segoe UI Emoji", 3, 18)); // NOI18N
        jButton1.setText("Get Plain Text");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 250, 60));

        jLabel2.setFont(new java.awt.Font("Segoe Script", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PlayFair Cipher");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 350, 50));

        jLabel4.setFont(new java.awt.Font("Snap ITC", 2, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Key");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 150, 60));

        jLabel5.setFont(new java.awt.Font("Snap ITC", 2, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("EncryptedText ");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 150, 60));

        key.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(key);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 280, 60));

        plaintext.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane2.setViewportView(plaintext);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 300, 60));

        jButton2.setFont(new java.awt.Font("Segoe Print", 3, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 102));
        jButton2.setText("main page");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 560, 160, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Desktop\\OIP.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 625, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       matrix = new ArrayList<>();
        String alpha = "abcdefghiklmnopqrstuvwxyz";
        
        String pt=plaintext.getText();
        pt = pt.toLowerCase();
        String k=key.getText();
       k = k.toLowerCase();
      for (char c : (k + alpha).toCharArray()) {
            if (!matrix.contains(String.valueOf(c))) {
                matrix.add(String.valueOf(c));
            }
        }

        String x =decryptionPlayfairCipher(pt,k);
              JOptionPane.showConfirmDialog(this,x);  

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        main u1=new main();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ceaserfram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ceaserfram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ceaserfram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ceaserfram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dplayfairfram().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane key;
    private javax.swing.JTextPane plaintext;
    // End of variables declaration//GEN-END:variables
}
