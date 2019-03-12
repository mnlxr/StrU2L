/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;
// ClipboardTest.java
class ClipboardTest extends javax.swing.JPanel
implements java.awt.event.ActionListener
{

  javax.swing.JPopupMenu popupMenu;
  javax.swing.JTextField textField;

  public ClipboardTest()
  {
    this.setPreferredSize(new java.awt.Dimension(640,480));
    this.textField = new javax.swing.JTextField(30);
    this.add(textField);    

    createPopupMenu();
    textField.addMouseListener(new MouseHandler(popupMenu));
  }


  public void createPopupMenu()
  {
    javax.swing.JMenuItem copy = new javax.swing.JMenuItem("copy");
    javax.swing.JMenuItem paste = new javax.swing.JMenuItem("paste");
    javax.swing.JMenuItem selectAll = new javax.swing.JMenuItem("select all");

    popupMenu = new javax.swing.JPopupMenu();
    popupMenu.add( copy );
    popupMenu.add( paste );
    popupMenu.add( selectAll );

    copy.addActionListener(this);
    paste.addActionListener(this);
    selectAll.addActionListener(this);
  }


  public void actionPerformed(java.awt.event.ActionEvent e)
  {
    String cmd = e.getActionCommand();

    if (cmd.equals("copy"))
    {
      textField.copy();
    }
    else if (cmd.equals("paste"))
    {
      textField.paste();
    }
    else if (cmd.equals("select all"))
    {
      textField.selectAll();
    }
  }

  public static void main(String[] args) throws Exception
  {
    ClipboardTest panel = new ClipboardTest();
    javax.swing.JFrame window = new javax.swing.JFrame("Clipboard Test");
    window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    window.add(panel);
    window.pack();
    window.setVisible(true);
  }
}

class MouseHandler extends java.awt.event.MouseAdapter
{
  private javax.swing.JPopupMenu popupMenu;

  public MouseHandler(javax.swing.JPopupMenu popup)
  {
    this.popupMenu = popup;
  }

  public void mousePressed(java.awt.event.MouseEvent e)
  {
    if (e.isPopupTrigger())
      popupMenu.show(e.getComponent(), e.getX(), e.getY());
  }
            
  public void mouseReleased(java.awt.event.MouseEvent e )
  {
    if (e.isPopupTrigger())
      popupMenu.show(e.getComponent(), e.getX(), e.getY());
  }
            
}
