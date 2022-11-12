package GUI;

import Command.ChangeBackground;
import Command.ChangeColorTheme;
import Command.ChangeForeground;
import Command.CommandManager;
import Command.Commands;
import Command.ICommand;
import Command.Open;
import Command.Redo;
import Command.Save;
import Command.SaveAs;
import Command.Undo;
import Memento.StyleVersion;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import Memento.SylesCaretaker;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Esteb
 */
public class Editor extends javax.swing.JFrame {

    /**
     * Creates new form Editor
     */

    private CommandManager commandManager;
    private StyleVersion styleversion;
    private SylesCaretaker caretaker;
    public Editor() {
        initComponents();
        this.setLocationRelativeTo(null);
        setupCommands();
        ICommand command = commandManager.getCommand(Commands.CHANGE_THEME);
        ((ChangeColorTheme) command).setColorTheme(Settings.DEFAULT_THEME);
        command.execute();
        styleversion = new StyleVersion();
        styleversion.setDoc(jTextPane.getStyledDocument());
        styleversion.setStyle(jTextPane.addStyle("newstyle", null));
        caretaker = new SylesCaretaker();
        this.jButtonUndo.setEnabled(false);
        this.jButtonRedo.setEnabled(false);
    }
    private void setupCommands(){
        commandManager = new CommandManager();
        commandManager.registCommand(Commands.UNDO, new Undo(this));
        commandManager.registCommand(Commands.REDO, new Redo(this));
        commandManager.registCommand(Commands.SAVE, new Save());
        commandManager.registCommand(Commands.SAVE_AS, new SaveAs());
        commandManager.registCommand(Commands.OPEN, new Open(this));
        commandManager.registCommand(Commands.CHANGE_THEME, new ChangeColorTheme(this));
        commandManager.registCommand(Commands.CHANGE_FOREGROUND, new ChangeForeground(this));
        commandManager.registCommand(Commands.CHANGE_BACKGROUND, new ChangeBackground(this));
        
    }
    
  

   
    public void setIconIn(JButton button, String route){
        route = Settings.IMAGE_ROUTE.concat(route);
         Icon icon =null;
        try {
            BufferedImage img = ImageIO.read(new File(route));
            Image imgl = img.getScaledInstance( button.getWidth()-10, button.getHeight()-10, Image.SCALE_DEFAULT );
            icon= new ImageIcon(imgl);
        } catch (IOException ex) {
           
        }
        /*ImageIcon image = new ImageIcon(route);
        image = image
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(
                                    button.getWidth(), 
                                    button.getHeight(), 
                                    Image.SCALE_SMOOTH));
        */
        
        button.setIcon(icon);
        button.repaint();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTextPaneContainer = new javax.swing.JPanel();
        jScrollPaneText = new javax.swing.JScrollPane();
        jTextPane = new javax.swing.JTextPane();
        jPanelToolbarContainr = new javax.swing.JPanel();
        jToolBar = new javax.swing.JToolBar();
        jButtonOpen = new javax.swing.JButton();
        jTextFieldName = new javax.swing.JTextField();
        jButtonSave = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButtonUndo = new javax.swing.JButton();
        jButtonRedo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButtonHightLight = new javax.swing.JButton();
        jButtonForegroundColor = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jToggleButtonTheme = new javax.swing.JToggleButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPaneText.setBorder(null);

        jTextPane.setBorder(null);
        jTextPane.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jScrollPaneText.setViewportView(jTextPane);

        jToolBar.setRollover(true);

        jButtonOpen.setText("Open");
        jButtonOpen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonOpen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenActionPerformed(evt);
            }
        });
        jToolBar.add(jButtonOpen);
        jToolBar.add(jTextFieldName);

        jButtonSave.setText("Save");
        jButtonSave.setFocusable(false);
        jButtonSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(jButtonSave);
        jToolBar.add(jSeparator1);

        jButtonUndo.setText("Undo");
        jButtonUndo.setFocusable(false);
        jButtonUndo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonUndo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUndoActionPerformed(evt);
            }
        });
        jToolBar.add(jButtonUndo);

        jButtonRedo.setText("Redo");
        jButtonRedo.setFocusable(false);
        jButtonRedo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRedo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRedoActionPerformed(evt);
            }
        });
        jToolBar.add(jButtonRedo);
        jToolBar.add(jSeparator2);

        jButtonHightLight.setText("Hightlight");
        jButtonHightLight.setFocusable(false);
        jButtonHightLight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonHightLight.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonHightLight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHightLightActionPerformed(evt);
            }
        });
        jToolBar.add(jButtonHightLight);

        jButtonForegroundColor.setText("Foreground");
        jButtonForegroundColor.setFocusable(false);
        jButtonForegroundColor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonForegroundColor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonForegroundColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForegroundColorActionPerformed(evt);
            }
        });
        jToolBar.add(jButtonForegroundColor);
        jToolBar.add(jSeparator3);

        jToggleButtonTheme.setText("Theme");
        jToggleButtonTheme.setFocusable(false);
        jToggleButtonTheme.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButtonTheme.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButtonTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonThemeActionPerformed(evt);
            }
        });
        jToolBar.add(jToggleButtonTheme);

        javax.swing.GroupLayout jPanelToolbarContainrLayout = new javax.swing.GroupLayout(jPanelToolbarContainr);
        jPanelToolbarContainr.setLayout(jPanelToolbarContainrLayout);
        jPanelToolbarContainrLayout.setHorizontalGroup(
            jPanelToolbarContainrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolbarContainrLayout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelToolbarContainrLayout.setVerticalGroup(
            jPanelToolbarContainrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelTextPaneContainerLayout = new javax.swing.GroupLayout(jPanelTextPaneContainer);
        jPanelTextPaneContainer.setLayout(jPanelTextPaneContainerLayout);
        jPanelTextPaneContainerLayout.setHorizontalGroup(
            jPanelTextPaneContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneText, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
            .addComponent(jPanelToolbarContainr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelTextPaneContainerLayout.setVerticalGroup(
            jPanelTextPaneContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTextPaneContainerLayout.createSequentialGroup()
                .addComponent(jPanelToolbarContainr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneText, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
        );

        jMenuFile.setText("File");
        jMenuBar.add(jMenuFile);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTextPaneContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTextPaneContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonThemeActionPerformed
        ICommand commandColor = commandManager.getCommand(Commands.CHANGE_THEME);
        if(this.jToggleButtonTheme.isSelected()){

            ((ChangeColorTheme) commandColor).setColorTheme(Theme.DARKER);
            jToggleButtonTheme.setText("Lighter");

        }else{
            ((ChangeColorTheme) commandColor).setColorTheme(Theme.LIGHTER);
            jToggleButtonTheme.setText("Darker");
        }
        commandColor.execute();
    }//GEN-LAST:event_jToggleButtonThemeActionPerformed

    private void jButtonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenActionPerformed
       commandManager.getCommand(Commands.OPEN).execute();
    }//GEN-LAST:event_jButtonOpenActionPerformed

    private void jButtonForegroundColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForegroundColorActionPerformed
        
        ChangeForeground command = (ChangeForeground)commandManager.getCommand(Commands.CHANGE_FOREGROUND);
        command.setStyle(styleversion);
        command.execute();
    }//GEN-LAST:event_jButtonForegroundColorActionPerformed

    private void jButtonHightLightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHightLightActionPerformed
        ChangeBackground command = (ChangeBackground)commandManager.getCommand(Commands.CHANGE_BACKGROUND);
        command.setStyle(styleversion);
        command.execute();
    }//GEN-LAST:event_jButtonHightLightActionPerformed

    private void jButtonUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUndoActionPerformed

        commandManager.getCommand(Commands.UNDO).execute();
    }//GEN-LAST:event_jButtonUndoActionPerformed

    private void jButtonRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRedoActionPerformed
       commandManager.getCommand(Commands.REDO).execute();
    }//GEN-LAST:event_jButtonRedoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Settings.getInstance().addDarkerTheme();
        Settings.getInstance().addLighterTheme();
        Settings.getInstance().chooseTheme(Theme.LIGHTER); //set our default color theme
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
           
                new Editor().setVisible(true);
                
            }
        });
    }

    public void setjScrollPaneText(JScrollPane jScrollPaneText) {
        this.jScrollPaneText = jScrollPaneText;
    }

    public void setjTextPane(JTextPane jTextPane) {
        this.jTextPane = jTextPane;
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonForegroundColor;
    private javax.swing.JButton jButtonHightLight;
    private javax.swing.JButton jButtonOpen;
    private javax.swing.JButton jButtonRedo;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonUndo;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JPanel jPanelTextPaneContainer;
    private javax.swing.JPanel jPanelToolbarContainr;
    private javax.swing.JScrollPane jScrollPaneText;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextPane jTextPane;
    private javax.swing.JToggleButton jToggleButtonTheme;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables
    
    public JButton getjButtonForegroundColor() {
        return jButtonForegroundColor;
    }
    

    public JButton getjButtonHightLight() {
        return jButtonHightLight;
    }

    public JButton getjButtonOpen() {
        return jButtonOpen;
    }

    public JButton getjButtonRedo() {
        return jButtonRedo;
    }

    public JButton getjButtonSave() {
        return jButtonSave;
    }

    public JButton getjButtonUndo() {
        return jButtonUndo;
    }

    public JPanel getjPanel1() {
        return jPanelToolbarContainr;
    }

    public JPanel getjPanelText() {
        return jPanelTextPaneContainer;
    }

    public JScrollPane getjScrollPaneText() {
        return jScrollPaneText;
    }

    public JTextField getjTextFieldName() {
        return jTextFieldName;
    }

    public JTextPane getjTextPane() {
        return jTextPane;
    }

    public JToggleButton getjToggleButtonTheme() {
        return jToggleButtonTheme;
    }

    public JToolBar getjToolBar() {
        return jToolBar;
    }

    public JPanel getjPanelTextPaneContainer() {
        return jPanelTextPaneContainer;
    }

    public StyleVersion getStyleversion() {
        return styleversion;
    }

    public SylesCaretaker getCaretaker() {
        return caretaker;
    }
   
    
}