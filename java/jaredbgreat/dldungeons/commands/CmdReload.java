package jaredbgreat.dldungeons.commands;

/* 
 * This mod is the creation and copyright (c) 2015 
 * of Jared Blackburn (JaredBGreat).
 * 
 * It is licensed under the creative commons 4.0 attribution license: * 
 * https://creativecommons.org/licenses/by/4.0/legalcode
*/	

import jaredbgreat.dldungeons.ConfigHandler;
import jaredbgreat.dldungeons.ReadAPI;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class CmdReload extends CommandBase {

    public CmdReload() {
		super();
	}

	
	@Override
	public int compareTo(Object o) {
		return 0;
	}

	
	@Override
	public String getCommandName() {
		return "dldreload";
	}

	
	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/dldreload";
	}

	
	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {		
			System.out.println("[DLDUNGEONS] " + icommandsender.getCommandSenderName()
					+ " Used /dldreload command; Reloading config file now.");
			ReadAPI.reloadConfig();
			if(ConfigHandler.announceCommands) icommandsender.addChatMessage(new ChatComponentText("[DLDUNGEONS] " 
					+ icommandsender.getCommandSenderName()
					+ " Used /dldreload command; Reloading config file now."));
	}
	
	
	@Override
    public int getRequiredPermissionLevel()
    {
        return 2;
    }

	
	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender,
			String[] astring) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean isUsernameIndex(String[] astring, int i) {
		return false;
	}

}
