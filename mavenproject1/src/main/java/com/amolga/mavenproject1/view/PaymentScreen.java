package com.amolga.mavenproject1.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.amolga.mavenproject1.model.*;
import com.amolga.mavenproject1.model.MenuItem;

public class PaymentScreen extends javax.swing.JFrame {

    private Bill bill;

    private JLabel lblTableName;
    private JLabel lblClientName;
    private JRadioButton rbDebit;
    private JRadioButton rbCredit;
    private ButtonGroup bgMethod;
    private JLabel tfFee;
    private JComboBox<String> cbInstallments;
    private JTextArea taOrderDetails;
    private JTextArea taReceipt;
    
    private JLabel lblSubtotal;
    private JLabel lblDiscount;
    private JLabel lblTotal;
    
    private JButton btnCalculate;
    private JButton btnProcess;

    public PaymentScreen(Bill bill) {
        this.bill = bill;
        initComponents();
        if (bill != null) {
            lblTableName.setText(bill.getTable() != null ? "Mesa " + bill.getTable().getNumber() : "N/A");
            lblClientName.setText(bill.getClient() != null ? bill.getClient().getName() : "N/A");
            updateOrderDetails();
        }
    }

    private void initComponents() {
        setTitle("Tela de Pagamento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(850, 520);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel lblTitle = new JLabel("TELA DE PAGAMENTO");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        pnlTitle.add(lblTitle);
        add(pnlTitle, BorderLayout.NORTH);

        JPanel pnlCenter = new JPanel(new GridLayout(1, 2, 15, 15));
        pnlCenter.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 15));
        add(pnlCenter, BorderLayout.CENTER);

        JPanel pnlLeft = new JPanel(new BorderLayout(10, 10));
        pnlCenter.add(pnlLeft);

        JPanel pnlForm = new JPanel(new GridLayout(8, 2, 5, 12));
        pnlForm.setBorder(BorderFactory.createTitledBorder("Informações de Pagamento"));
        pnlLeft.add(pnlForm, BorderLayout.NORTH);

        pnlForm.add(new JLabel("  Mesa:"));
        lblTableName = new JLabel("N/A");
        lblTableName.setFont(new Font("Arial", Font.BOLD, 12));
        pnlForm.add(lblTableName);

        pnlForm.add(new JLabel("  Cliente:"));
        lblClientName = new JLabel("N/A");
        lblClientName.setFont(new Font("Arial", Font.BOLD, 12));
        pnlForm.add(lblClientName);

        pnlForm.add(new JLabel("  Forma de pagamento:"));
        JPanel pnlMethod = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        rbDebit = new JRadioButton("Débito", true);
        rbCredit = new JRadioButton("Crédito", false);
        bgMethod = new ButtonGroup();
        bgMethod.add(rbDebit);
        bgMethod.add(rbCredit);
        pnlMethod.add(rbDebit);
        pnlMethod.add(rbCredit);
        pnlForm.add(pnlMethod);

        pnlForm.add(new JLabel("  Taxa Adm (%):"));
        tfFee = new JLabel("2.0");
        tfFee.setFont(new Font("Arial", Font.BOLD, 12));
        pnlForm.add(tfFee);

        pnlForm.add(new JLabel("  Parcelas:"));
        cbInstallments = new JComboBox<>(new String[]{"1x (À vista)", "2x", "3x"});
        cbInstallments.setEnabled(false);
        pnlForm.add(cbInstallments);

        pnlForm.add(new JLabel("  Subtotal:"));
        lblSubtotal = new JLabel("R$ 0,00");
        lblSubtotal.setFont(new Font("Arial", Font.PLAIN, 12));
        pnlForm.add(lblSubtotal);

        pnlForm.add(new JLabel("  Desconto Bônus:"));
        lblDiscount = new JLabel("R$ 0,00");
        lblDiscount.setForeground(new Color(0, 128, 0));
        lblDiscount.setFont(new Font("Arial", Font.BOLD, 12));
        pnlForm.add(lblDiscount);

        pnlForm.add(new JLabel("  Total a Pagar:"));
        lblTotal = new JLabel("R$ 0,00");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 14));
        lblTotal.setForeground(Color.RED);
        pnlForm.add(lblTotal);

        JPanel pnlButtons = new JPanel(new GridLayout(2, 1, 5, 5));
        pnlButtons.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        pnlLeft.add(pnlButtons, BorderLayout.SOUTH);

        btnCalculate = new JButton("Calcular Total");
        pnlButtons.add(btnCalculate);

        btnProcess = new JButton("Confirmar Pagamento");
        pnlButtons.add(btnProcess);

        JPanel pnlDetails = new JPanel(new GridLayout(2, 1, 10, 10));
        pnlCenter.add(pnlDetails);

        taOrderDetails = new JTextArea();
        taOrderDetails.setEditable(false);
        taOrderDetails.setFocusable(false);
        taOrderDetails.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane spOrder = new JScrollPane(taOrderDetails);
        spOrder.setBorder(BorderFactory.createTitledBorder("Consumo / Itens do Pedido"));
        pnlDetails.add(spOrder);

        taReceipt = new JTextArea();
        taReceipt.setEditable(false);
        taReceipt.setFocusable(false);
        taReceipt.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane spReceipt = new JScrollPane(taReceipt);
        spReceipt.setBorder(BorderFactory.createTitledBorder("Recibo de Pagamento Gerado"));
        pnlDetails.add(spReceipt);

        rbDebit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbInstallments.setEnabled(false);
                cbInstallments.setSelectedIndex(0);
                tfFee.setText("2.0");
                calculateTotals();
            }
        });

        rbCredit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbInstallments.setEnabled(true);
                tfFee.setText("3.0");
                calculateTotals();
            }
        });

        cbInstallments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotals();
            }
        });

        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotals();
            }
        });

        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processPayment();
            }
        });
    }

    private void updateOrderDetails() {
        if (bill == null) {
            taOrderDetails.setText("Nenhuma conta selecionada.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        if (bill.getTable() != null) {
            sb.append("Consumo da Mesa ").append(bill.getTable().getNumber()).append(":\n");
        } else {
            sb.append("Consumo:\n");
        }
        sb.append("-----------------------------\n");
        double subtotal = 0;
        if (bill.getOrders() != null) {
            for (Order o : bill.getOrders()) {
                if (o.getItens() != null) {
                    for (Map.Entry<MenuItem, Integer> entry : o.getItens().entrySet()) {
                        MenuItem item = entry.getKey();
                        int qty = entry.getValue();
                        double price = item.getPrice() * qty;
                        subtotal += price;
                        sb.append(qty).append("x ").append(item.getName()).append(" - R$ ").append(price).append("\n");
                    }
                }
            }
        }
        sb.append("-----------------------------\n");
        sb.append("Subtotal: R$ ").append(String.format("%.2f", subtotal));
        taOrderDetails.setText(sb.toString());

        calculateTotals();
    }

    private void calculateTotals() {
        if (bill == null) return;

        double subtotal = 0;
        if (bill.getOrders() != null) {
            for (Order o : bill.getOrders()) {
                subtotal += o.calculateTotal();
            }
        }
        Client c = bill.getClient();
        double bonus = c != null ? c.getBonus() : 0.0;

        double baseTotal = Math.max(0, subtotal - bonus);
        double feePercent = 0.0;
        try {
            feePercent = Double.parseDouble(tfFee.getText().trim()) / 100.0;
        } catch (NumberFormatException ignored) {}

        double total;
        boolean isInstallments = cbInstallments.isEnabled() && cbInstallments.getSelectedIndex() > 0;
        if (rbDebit.isSelected()) {
            total = baseTotal * (1 + feePercent);
        } else {
            double effFee = isInstallments ? (feePercent + 0.02) : feePercent;
            total = baseTotal * (1 + effFee);
        }

        lblSubtotal.setText("R$ " + String.format("%.2f", subtotal));
        lblDiscount.setText("R$ " + String.format("%.2f", bonus));
        
        if (isInstallments) {
            int parts = cbInstallments.getSelectedIndex() + 1;
            double partValue = total / parts;
            lblTotal.setText("R$ " + String.format("%.2f", total) + " (" + parts + "x R$ " + String.format("%.2f", partValue) + ")");
        } else {
            lblTotal.setText("R$ " + String.format("%.2f", total));
        }
    }

    private void processPayment() {
        if (bill == null) return;
        Table t = bill.getTable();
        Client c = bill.getClient();
        ArrayList<Order> ordersList = bill.getOrders();
        
        if (ordersList == null || ordersList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum pedido na conta.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double feePercent = 0.0;
        try {
            feePercent = Double.parseDouble(tfFee.getText().trim()) / 100.0;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Taxa inválida", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PaymentMethod pm;
        boolean isInstallments = cbInstallments.isEnabled() && cbInstallments.getSelectedIndex() > 0;
        if (rbDebit.isSelected()) {
            pm = new Debit(feePercent);
        } else {
            pm = new Credit(isInstallments, feePercent);
        }

        Order primaryOrder = ordersList.get(0);
        Payment payment = new Payment(primaryOrder, c, t, pm);
        payment.processPayment();

        // Finish all other orders in the bill as well
        for (int i = 1; i < ordersList.size(); i++) {
            ordersList.get(i).finishOrder();
        }

        double subtotal = 0;
        for (Order o : ordersList) {
            subtotal += o.calculateTotal();
        }
        double base = Math.max(0, subtotal - c.getBonus());
        double finalVal = pm.calcValue(base);

        StringBuilder sb = new StringBuilder();
        sb.append("======= RECIBO DE PAGAMENTO =======\n");
        if (t != null) {
            sb.append("Mesa: ").append(t.getNumber()).append("\n");
        }
        if (c != null) {
            sb.append("Cliente: ").append(c.getName()).append("\n");
        }
        sb.append("Método: ").append(pm.getMethodName()).append("\n");
        if (pm instanceof Credit) {
            int parts = cbInstallments.getSelectedIndex() + 1;
            sb.append("Opção: ").append(isInstallments ? parts + " parcelas" : "À vista").append("\n");
        }
        sb.append("Subtotal: R$ ").append(String.format("%.2f", subtotal)).append("\n");
        if (c != null) {
            sb.append("Desconto: R$ ").append(String.format("%.2f", c.getBonus())).append("\n");
        }
        sb.append("Total Pago: R$ ").append(String.format("%.2f", finalVal)).append("\n");
        if (pm instanceof Credit && isInstallments) {
            int parts = cbInstallments.getSelectedIndex() + 1;
            sb.append("Valor da Parcela: R$ ").append(String.format("%.2f", finalVal / parts)).append("\n");
        }
        sb.append("===================================\n");
        taReceipt.setText(sb.toString());

        if (c != null && c.getBonus() > 0) {
            c.setBonus(0.0);
        }

        JOptionPane.showMessageDialog(this, "Pagamento realizado com sucesso! Mesa desocupada.");
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new PaymentScreen(null).setVisible(true));
    }
}
