package com.amolga.mavenproject1.view;

import com.amolga.mavenproject1.model.MenuItem;
import com.amolga.mavenproject1.model.Food;
import com.amolga.mavenproject1.model.Drink;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author enzoschubach
 */
public class MenuScreen extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuScreen.class.getName());

    private List<MenuItem> createFakeMenu() {
        List<MenuItem> list = new ArrayList<>();
        
        // Burgers (Hambúrgueres)
        list.add(new Food("Amolga Classic", 24.90, "Pão, blend de 150g, queijo prato, alface, tomate e maionese artesanal."));
        list.add(new Food("Double Bacon", 32.90, "Pão, dois blends de 120g, cheddar duplo, bacon crocante e molho barbecue."));
        list.add(new Food("Cheddar Monster", 29.90, "Pão brioche, blend de 180g, muito cheddar cremoso e cebola caramelizada."));
        list.add(new Food("Chicken Crispy", 26.90, "Pão brioche, sobrecoxa de frango frita super crocante, alface americana e maionese de alho."));
        list.add(new Food("Veggie Amolga", 27.90, "Pão brioche, hambúrguer de grão-de-bico, queijo prato, rúcula, tomate e maionese verde."));
        list.add(new Food("Smash Simples", 18.00, "Pão, blend smash de 80g, queijo cheddar e ketchup da casa."));
        list.add(new Food("Smash Duplo", 23.00, "Pão, dois blends smash de 80g, queijo cheddar duplo e molho especial."));
        
        // Acompanhamentos (Sides)
        list.add(new Food("Batata Frita", 12.00, "Batata frita tradicional bem crocante."));
        list.add(new Food("Batata Suprema", 19.90, "Batata frita coberta com cheddar cremoso e bacon picado."));
        list.add(new Food("Onion Rings", 14.00, "Anéis de cebola empanados e fritos, acompanha molho barbecue."));
        list.add(new Food("Nuggets (8 un)", 15.00, "Nuggets de frango crocantes, acompanha molho tártaro."));
        
        // Bebidas (Drinks)
        list.add(new Drink("Coca-Cola Lata", 6.00, "Coca-Cola Brasil"));
        list.add(new Drink("Guaraná Lata", 6.00, "Ambev"));
        list.add(new Drink("Suco de Laranja", 8.50, "Natural da Fruta"));
        list.add(new Drink("Água Sem Gás", 4.50, "Fontes de Minas"));
        list.add(new Drink("Água Com Gás", 5.00, "Fontes de Minas"));
        list.add(new Drink("Cerveja Heineken", 10.00, "Heineken"));
        list.add(new Drink("Milkshake Chocolate", 16.00, "Sorvete artesanal de chocolate"));
        list.add(new Drink("Milkshake Ovomaltine", 18.00, "Sorvete artesanal com Ovomaltine crocante"));
        list.add(new Drink("Soda Italiana Limão", 9.00, "Xarope Monin e água com gás"));
        
        return list;
    }
    
    /**
     * Creates new form MenuScreen
     */
    public MenuScreen() {
        initComponents();
        
        // Maximize/Fullscreen window
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        
        // Override GroupLayout with a responsive BorderLayout
        java.awt.Container contentPane = getContentPane();
        contentPane.removeAll();
        contentPane.setLayout(new java.awt.BorderLayout(20, 20));
        
        // Title at the top center
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contentPane.add(jLabel1, java.awt.BorderLayout.NORTH);
        
        // Scroll pane in the center (takes all remaining space)
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(20);
        contentPane.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        
        // Bottom panel with CONFIRMAR and CANCELAR buttons
        javax.swing.JPanel bottomPanel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 30, 10));
        jButton1.setPreferredSize(new java.awt.Dimension(180, 44));
        jButton2.setPreferredSize(new java.awt.Dimension(180, 44));
        bottomPanel.add(jButton1);
        bottomPanel.add(jButton2);
        contentPane.add(bottomPanel, java.awt.BorderLayout.SOUTH);
        
        // Add padding around the screen edge
        if (contentPane instanceof javax.swing.JComponent) {
            ((javax.swing.JComponent) contentPane).setBorder(
                javax.swing.BorderFactory.createEmptyBorder(20, 40, 20, 40)
            );
        }
        
        populateMenu();
    }

    private void populateMenu() {
        javax.swing.JPanel gridPanel = new javax.swing.JPanel();
        // 2 columns, vertical/horizontal gap of 15px
        gridPanel.setLayout(new java.awt.GridLayout(0, 2, 15, 15));
        
        List<MenuItem> items = createFakeMenu();
        for (MenuItem item : items) {
            gridPanel.add(new MenuItemPanel(item));
        }
        
        jScrollPane1.setViewportView(gridPanel);
        jScrollPane1.revalidate();
        jScrollPane1.repaint();
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
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList1.setAutoscrolls(false);
        jScrollPane1.setViewportView(jList1);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 48)); // NOI18N
        jLabel1.setText("Cardápio");

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CONFIRMAR");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setBackground(new java.awt.Color(153, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CANCELAR");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        javax.swing.JOptionPane.showMessageDialog(this, "Pedido confirmado com sucesso! Ele foi adicionado à sua lista de pedidos.", "Sucesso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        populateMenu();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        javax.swing.JOptionPane.showMessageDialog(this, "Pedido cancelado e limpo com sucesso.", "Cancelado", javax.swing.JOptionPane.WARNING_MESSAGE);
        populateMenu();
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MenuScreen().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
