/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Telas;

import controllers.LivroController;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.Livro;

/**
 *
 * @author renan
 */
public class TelaListaLivros extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaListaLivros
     */
    public TelaListaLivros() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jtbLivros.getModel();
        jtbLivros.setRowSorter(new TableRowSorter(modelo));
        readTable();
    }
    
    public void readTable(){
         DefaultTableModel modelo = (DefaultTableModel) jtbLivros.getModel();
         LivroController livro = new LivroController();
         modelo.setNumRows(0);
         livro.listar().forEach((book) -> {
             modelo.addRow(new Object[]{
                 book.getId(),
                 book.getTitulo(),
                 book.getAutor(),
                 book.getEditora(),
                 book.getAno()
             });
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbLivros = new javax.swing.JTable();

        setClosable(true);

        jScrollPane1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jtbLivros.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jtbLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Titulo", "Autor", "Editora", "Ano"
            }
        ));
        jScrollPane1.setViewportView(jtbLivros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbLivros;
    // End of variables declaration//GEN-END:variables
}
