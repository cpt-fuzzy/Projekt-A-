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
        commandsToUser = new javax.swing.JLabel();
        input = "";
        vector = 0;
        axis = '0';
        whichAxis = 0;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        inputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	inputActionPerformed(evt);
            }
        });

        jLayeredPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLayeredPane.setLayout(new java.awt.GridLayout(7, 7));
        commandsToUser.setText("Move X-Axis or Y-Axis?[x,y] ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(421, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLayeredPane)
                    .addComponent(Input, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(commandsToUser)
                .addGap(330, 330, 330))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(Input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(commandsToUser)    
                .addContainerGap(151, Short.MAX_VALUE))
        );

        pack();
    }
    
    public void setUpField(byte x, byte y) {
        jButtons[x][y] = new JButton();
    	jLayeredPane.add(jButtons[x][y]);
    }

    private void InputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputActionPerformed
      input =  evt.getActionCommand();
       if (input.equalsIgnoreCase("x")|| input.equalsIgnoreCase("y")){
    	   axis = input.charAt(0);
    	   commandsToUser.setText("Which one?[1-5] ");
       }
       else if (input.equals("1")|| input.equals("2")|| input.equals("3") || input.equals("4")|| input.equals("5"))
       {
    	   whichAxis = Byte.parseByte(input);
    	   if (axis == 'x') commandsToUser.setText("Direction?[-1 = left, +1 = right] ");
    	   else if( axis == 'y') commandsToUser.setText("Direction?[+1 = up, -1 = down] ");
       }
       else if (input.equals("-1")|| input.equals("+1"))
       {
    	   vector = (Byte.parseByte(input));
    	  if (axis == 'y') vector *= -1;
       }
       if (axis != '0' && whichAxis != 0 && vector != 0 ) {
    	   Game.player[1].initializeMove(axis, whichAxis, vector, this);
    	   axis = '0';
    	   whichAxis = 0;
    	   vector = 0;
    	   commandsToUser.setText("Move X-Axis or Y-Axis?[x,y] ");
       }
       inputField.setText("");
    }//GEN-LAST:event_InputActionPerformed
    
    public void setButton(byte x, byte y,  Token token) {
        jButtons[x][y].setText(token.getClass().getName().substring(5) + token.getAffinity().getName().substring(6));
    }
    
    public void setButtonEmpty(byte x, byte y) {
        jButtons[x][y].setText("");
    }


    private javax.swing.JButton[][]jButtons;
    private javax.swing.JTextField Input;
    private javax.swing.JLayeredPane jLayeredPane;
    private javax.swing.JLabel commandsToUser;
    private String input;
    private byte vector;
    private byte whichAxis;
	private char axis;
}
