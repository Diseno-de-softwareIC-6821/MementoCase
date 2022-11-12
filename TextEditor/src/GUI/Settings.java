package GUI;


import java.awt.Color;
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Esteb
 */
public class Settings {
    public static final String IMAGE_ROUTE  = "src\\Icons\\";
    public static final Theme DEFAULT_THEME = Theme.LIGHTER;
    public static final String COMPONENTS_COLOR = "color";
    public static final String COMPONENTS_ICONS = "icons";
    public static final String FOREGROUND_COLOR = "foreground";
    public static final String PANEL_BACKGROUND_COLOR= "backgroundpanel";
    public static final String TOOLBAR_BACKGROUND_COLOR = "backgroundtoolbar";
    public static final String TEXTFIELD_BACKGROUND_COLOR = "backgroundtextfield";
    public static final String BUTTON_BACKGROUND_COLOR = "buttonbackground";
    public static final String FOLDER_ICON = "folder";
    public static final String FONT_ICON = "font";
    public static final String MARKER_ICON = "marker";
    public static final String REDO_ICON = "redo";
    public static final String UNDO_ICON = "undo";
    public static final String SAVE_ICON = "save";
    public static final String TOGGLEBUTTON_BACKGROUND_COLOR = "togglebuttonbackground";
    
    private HashMap<Theme, HashMap> themeHasmap;
    
    private HashMap<String, String> icons;
    private HashMap<String, Color> colors;
    private static Settings instance;

    private Settings() {
        themeHasmap = new HashMap<>();
        icons = new HashMap<>();
        colors = new HashMap<>();
    }
    
    public static Settings getInstance(){
        if(instance==null){
            instance = new Settings();
        }
        return instance;
    }
    public void chooseTheme(Theme colorTheme){
        HashMap<String, HashMap> theme = themeHasmap.get(colorTheme);
        icons = theme.get(COMPONENTS_ICONS);
        colors = theme.get(COMPONENTS_COLOR);
    }
    
    public void addLighterTheme(){
        //always names in lowercase
        //----colors
        HashMap<String, Color> colorsMap = new HashMap<>();
        colorsMap.put(FOREGROUND_COLOR, Color.BLACK);
        colorsMap.put(PANEL_BACKGROUND_COLOR, Color.WHITE);
        colorsMap.put(TOOLBAR_BACKGROUND_COLOR, Color.WHITE);
        colorsMap.put(TEXTFIELD_BACKGROUND_COLOR, Color.LIGHT_GRAY);
        colorsMap.put(BUTTON_BACKGROUND_COLOR, new Color(255,255,153));
        colorsMap.put(TOGGLEBUTTON_BACKGROUND_COLOR, new Color(255,255,255));
        //----icons
        HashMap<String, String> iconsMap = new HashMap<>();
        iconsMap.put(FOLDER_ICON, "folderLight.png");
        iconsMap.put(FONT_ICON, "fontDark.png");
        iconsMap.put(MARKER_ICON, "markerLight.png");
        iconsMap.put(REDO_ICON, "redoLight.png");
        iconsMap.put(UNDO_ICON, "undoLight.png");
        iconsMap.put(SAVE_ICON, "saveDark.png");
        
        //
        HashMap<String, HashMap> components = new HashMap<>();
        components.put(COMPONENTS_ICONS, iconsMap);
        components.put(COMPONENTS_COLOR, colorsMap);
        
        themeHasmap.put(Theme.LIGHTER, components);
    }
    public void addDarkerTheme(){
        //always names in lowercase
        //----colors
        HashMap<String, Color> colorsMap = new HashMap<>();
        colorsMap.put(FOREGROUND_COLOR, Color.WHITE);
        colorsMap.put(PANEL_BACKGROUND_COLOR, Color.DARK_GRAY);
        colorsMap.put(TOOLBAR_BACKGROUND_COLOR, Color.DARK_GRAY);
        colorsMap.put(TEXTFIELD_BACKGROUND_COLOR, Color.DARK_GRAY);
        colorsMap.put(BUTTON_BACKGROUND_COLOR, new Color(204,255,255));
        colorsMap.put(TOGGLEBUTTON_BACKGROUND_COLOR, new Color(0,0,0));
        
        //---icons
        HashMap<String, String> iconsMap = new HashMap<>();
        iconsMap.put(FOLDER_ICON, "folderDark.png");
        iconsMap.put(FONT_ICON, "fontDark.png");
        iconsMap.put(MARKER_ICON, "markerDark.png");
        iconsMap.put(REDO_ICON, "redoDark.png");
        iconsMap.put(UNDO_ICON, "undoDark.png");
        iconsMap.put(SAVE_ICON, "saveDark.png");
        
        HashMap<String, HashMap> components = new HashMap<>();
        components.put(COMPONENTS_ICONS, iconsMap);
        components.put(COMPONENTS_COLOR, colorsMap);
        
        themeHasmap.put(Theme.DARKER, components);
        
    }

 

    public HashMap<String, String> getIcons() {
        return icons;
    }

    public HashMap<String, Color> getColors() {
        return colors;
    }
    
    
}
