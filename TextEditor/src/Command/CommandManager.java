/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import java.util.HashMap;

/**
 *
 * @author Esteb
 */
public class CommandManager {
    private HashMap<Commands, ICommand> commandsList; 
    
    
    
    public CommandManager() {
        this.commandsList = new HashMap<>();
    }
    public  ICommand getCommand(Commands command){
        return commandsList.get(command);
    }
    public void registCommand(Commands commandType, ICommand command){
        this.commandsList.put(commandType, command);
    }
    
}
