/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Telas;

import controllers.LivroController;
import models.Livro;

/**
 *
 * @author renan
 */
public class TelaMostraLivro extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaMostraLivro
     */
    public TelaMostraLivro() {
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

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jblTitulo = new javax.swing.JLabel();
        jblAutor = new javax.swing.JLabel();
        jblEditora = new javax.swing.JLabel();
        jblAno = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        spnCodigo = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Título:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 148, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Autor(es):");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 218, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Editora:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 288, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Ano:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 349, -1, -1));

        jblTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(jblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 174, 395, 26));

        jblAutor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(jblAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 239, 390, 31));

        jblEditora.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(jblEditora, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 314, 390, 29));

        jblAno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(jblAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 375, 96, 24));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Código:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 30, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 82, -1, -1));

        spnCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(spnCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 51, 200, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/Imagens/background2 - 447x454.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 447, 454));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setComponents(Livro livro){
    jblTitulo.setText(livro.getTitulo());
    jblAutor.setText(livro.getAutor());
    jblEditora.setText(livro.getEditora());
    jblAno.setText(String.valueOf(livro.getAno()));
    
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LivroController servico = new LivroController();
        Livro livro = servico.buscar(Integer.parseInt(spnCodigo.getValue().toString()));
        setComponents(livro);     
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jblAno;
    private javax.swing.JLabel jblAutor;
    private javax.swing.JLabel jblEditora;
    private javax.swing.JLabel jblTitulo;
    private javax.swing.JSpinner spnCodigo;
    // End of variables declaration//GEN-END:variables
}
