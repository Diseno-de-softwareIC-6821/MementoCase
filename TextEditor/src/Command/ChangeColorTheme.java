/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import GUI.Editor;
import GUI.Settings;
import GUI.Theme;
import java.util.HashMap;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author Esteb
 */
public class ChangeColorTheme implements ICommand{
    private Theme colorTheme;
    private Editor editor;
    public ChangeColorTheme(Editor ss) {
        editor = ss;
    }
    
    
    
    @Override
    public boolean execute() {
        if(colorTheme!=null){         
            setTheme();
        }
        return false;
    }
    
    private void setTheme(){
        
        Settings.getInstance().chooseTheme(colorTheme);
        HashMap<String, Color> colors = Settings.getInstance().getColors();
        HashMap<String, String> icons = Settings.getInstance().getIcons();

        JButton redo = editor.getjButtonRedo();
        JButton undo =  editor.getjButtonUndo();
        JButton save =  editor.getjButtonSave();
        JButton open =  editor.getjButtonOpen();
        JButton highlight = editor.getjButtonHightLight();
        JButton foreground =  editor.getjButtonForegroundColor();
        redo.setText("");
        undo.setText("");
        save.setText("");
        open.setText("");
        highlight.setText("");
        foreground.setText("");
        
        redo.setBounds(new Rectangle(39,24));
        undo.setBounds(new Rectangle(39,24));
        save.setBounds(new Rectangle(39,24));
        open.setBounds(new Rectangle(39,24));
        highlight.setBounds(new Rectangle(39,24));
        foreground.setBounds(new Rectangle(39,24));
        redo.setBackground(colors.get(Settings.BUTTON_BACKGROUND_COLOR));
        undo.setBackground(colors.get(Settings.BUTTON_BACKGROUND_COLOR));
        save.setBackground(colors.get(Settings.BUTTON_BACKGROUND_COLOR));
        open.setBackground(colors.get(Settings.BUTTON_BACKGROUND_COLOR));
        highlight.setBackground(colors.get(Settings.BUTTON_BACKGROUND_COLOR));
        foreground.setBackground(colors.get(Settings.BUTTON_BACKGROUND_COLOR));
        editor.getjToggleButtonTheme().setBackground(colors.get(Settings.BUTTON_BACKGROUND_COLOR));
        editor.setIconIn(undo, icons.get(Settings.UNDO_ICON));
        editor.setIconIn(redo, icons.get(Settings.REDO_ICON));
        editor.setIconIn(save, icons.get(Settings.SAVE_ICON));
        editor.setIconIn(open, icons.get(Settings.FOLDER_ICON));
        editor.setIconIn(highlight, icons.get(Settings.MARKER_ICON));
        editor.setIconIn(foreground, icons.get(Settings.FONT_ICON));
        
        editor.getjTextPane().setBackground(colors.get(Settings.PANEL_BACKGROUND_COLOR));
        editor.getjToggleButtonTheme().setBackground(colors.get(Settings.TOGGLEBUTTON_BACKGROUND_COLOR));
        editor.getjToolBar().setBackground(colors.get(Settings.PANEL_BACKGROUND_COLOR));
        editor.getjTextFieldName().setBackground(colors.get(Settings.TEXTFIELD_BACKGROUND_COLOR));
        editor.getjTextPane().setBackground(colors.get(Settings.PANEL_BACKGROUND_COLOR));
        
        editor.getjTextFieldName().setForeground(colors.get(Settings.FOREGROUND_COLOR));
        editor.getjTextPane().setForeground(colors.get(Settings.FOREGROUND_COLOR));
        
        editor.getjToggleButtonTheme().setForeground(colors.get(Settings.FOREGROUND_COLOR));
        editor.getjScrollPaneText().setBackground(colors.get(Settings.PANEL_BACKGROUND_COLOR));
        editor.getjPanel1().setBackground(colors.get(Settings.PANEL_BACKGROUND_COLOR));
        editor.getjToolBar().setBackground(colors.get(Settings.PANEL_BACKGROUND_COLOR));
        editor.getjPanel1().setBackground(colors.get(Settings.PANEL_BACKGROUND_COLOR));
        editor.getjPanelTextPaneContainer().setBackground(colors.get(Settings.PANEL_BACKGROUND_COLOR));
    }

    public void setColorTheme(Theme coloTheme) {
        this.colorTheme = coloTheme;
    }
    
}
