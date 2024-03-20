/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Dell
 */   import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.List;
import javax.swing.JOptionPane;
public class DHillfram extends javax.swing.JFrame {

    private void getResult(String pt, String k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


// Java code to implement Hill Cipher
class GFG {

    // Following function generates the
    // key matrix for the key string
    static void getKeyMatrix(String key, int keyMatrix[][]) {
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keyMatrix[i][j] = (key.charAt(k)) % 65;
                k++;
            }
        }
    }

    // Following function calculates the
    // inverse of a matrix modulo 26
    static void getInverseMatrix(int keyMatrix[][], int inverseMatrix[][]) {
        int det = keyMatrix[0][0] * (keyMatrix[1][1] * keyMatrix[2][2] - keyMatrix[1][2] * keyMatrix[2][1])
                - keyMatrix[0][1] * (keyMatrix[1][0] * keyMatrix[2][2] - keyMatrix[1][2] * keyMatrix[2][0])
                + keyMatrix[0][2] * (keyMatrix[1][0] * keyMatrix[2][1] - keyMatrix[1][1] * keyMatrix[2][0]);

        // Find the determinant modulo 26
        det = (det % 26 + 26) % 26;

        // Find the multiplicative inverse of det
        int mulInverse = -1;
        for (int i = 0; i < 26; i++) {
            if ((det * i) % 26 == 1) {
                mulInverse = i;
                break;
            }
        }

        // Find the adjugate matrix
        int adj[][] = new int[3][3];
        adj[0][0] = (keyMatrix[1][1] * keyMatrix[2][2] - keyMatrix[1][2] * keyMatrix[2][1]);
        adj[0][1] = -(keyMatrix[1][0] * keyMatrix[2][2] - keyMatrix[1][2] * keyMatrix[2][0]);
        adj[0][2] = (keyMatrix[1][0] * keyMatrix[2][1] - keyMatrix[1][1] * keyMatrix[2][0]);
        adj[1][0] = -(keyMatrix[0][1] * keyMatrix[2][2] - keyMatrix[0][2] * keyMatrix[2][1]);
        adj[1][1] = (keyMatrix[0][0] * keyMatrix[2][2] - keyMatrix[0][2] * keyMatrix[2][0]);
        adj[1][2] = -(keyMatrix[0][0] * keyMatrix[2][1] - keyMatrix[0][1] * keyMatrix[2][0]);
        adj[2][0] = (keyMatrix[0][1] * keyMatrix[1][2] - keyMatrix[0][2] * keyMatrix[1][1]);
        adj[2][1] = -(keyMatrix[0][0] * keyMatrix[1][2] - keyMatrix[0][2] * keyMatrix[1][0]);
        adj[2][2] = (keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0]);

        // Find the inverse matrix by multiplying the adjugate matrix with the multiplicative inverse of det
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inverseMatrix[i][j] = ((adj[i][j] % 26 + 26) % 26 * mulInverse) % 26;
            }
        }
    }

    // Following function decrypts the message
    static void decrypt(int plainMatrix[][], int inverseMatrix[][], int cipherMatrix[][]) {
        int x, i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 1; j++) {
                cipherMatrix[i][j] = 0;

                for (x = 0; x < 3; x++) {
                    cipherMatrix[i][j] += inverseMatrix[i][x] * plainMatrix[x][j];
                }

                cipherMatrix[i][j] = (cipherMatrix[i][j] % 26 + 26) % 26;
            }
        }
    }

    // Function to implement Hill Cipher decryption
    static void HillCipher(String message, String key) {
        // Get key matrix from the key string
        int[][] keyMatrix = new int[3][3];
        getKeyMatrix(key, keyMatrix);

        // Get the inverse matrix of the key matrix
        int[][] inverseMatrix = new int[3][3];
        getInverseMatrix(keyMatrix, inverseMatrix);

        // Generate vector for the ciphertext
        int[][] cipherMatrix = new int[3][1];
        for (int i = 0; i < 3; i++)
            cipherMatrix[i][0] = (message.charAt(i)) % 65;

        // Following function generates the decrypted vector
        decrypt(cipherMatrix, inverseMatrix, cipherMatrix);

        // Generate the decrypted text from the decrypted vector
        String decryptedText = "";
        for (int i = 0; i < 3; i++)
            decryptedText += (char) (cipherMatrix[i][0] + 65);

        // Finally print the decrypted text
        System.out.println(" Decrypted Text: " + decryptedText);
    }

    // Driver code
    public static void main(String[] args) {
        // Get the ciphertext to be decrypted
        String ciphertext = "POH";

        // Get the key
        String key = "GYBNQKURP";

        HillCipher(ciphertext, key);
    }
}

    public DHillfram() {
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
        jButton1.setText("Get PlainText ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 250, 60));

        jLabel2.setFont(new java.awt.Font("Segoe Script", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hill");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 220, 50));

        jLabel4.setFont(new java.awt.Font("Snap ITC", 2, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Key");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 150, 60));

        jLabel5.setFont(new java.awt.Font("Snap ITC", 2, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Encrypted Text ");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 210, 60));

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
     String pt=plaintext.getText();
     String k=key.getText();
       JOptionPane.showConfirmDialog(this,"\nThe Encryption of your Text [  " + pt + "  ] using Ceaser Cipher Encryption is [   " + "   ACT   ]");


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
                new DHillfram().setVisible(true);
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
