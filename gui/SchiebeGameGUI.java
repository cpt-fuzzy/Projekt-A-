package gui;

import game.Token;
import javax.swing.JButton;

public class SchiebeGameGUI extends javax.swing.JFrame {

    public SchiebeGameGUI() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane = new javax.swing.JLayeredPane();
        jButtons = new javax.swing.JButton[7][7];
        Input = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLayeredPane.setLayout(new java.awt.GridLayout(7, 7));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(421, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLayeredPane)
                    .addComponent(Input, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(330, 330, 330))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(Input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        pack();
    }
    
    public void setUpField(byte x, byte y) {
        jButtons[x][y] = new JButton();
    	jLayeredPane.add(jButtons[x][y]);
    }

    private void InputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputActionPerformed
    
    public void setButton(byte x, byte y,  Token token) {
        jButtons[x][y].setText(token.getClass().getName().substring(5));
    }
    
    public void setButtonEmpty(byte x, byte y) {
        jButtons[x][y].setText("");
    }


    private javax.swing.JButton[][]jButtons;
    private javax.swing.JTextField Input;
    private javax.swing.JLayeredPane jLayeredPane;
}
