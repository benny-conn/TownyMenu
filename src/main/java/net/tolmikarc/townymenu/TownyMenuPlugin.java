package net.tolmikarc.townymenu;

import com.palmergames.bukkit.towny.Towny;
import com.palmergames.bukkit.towny.TownyEconomyHandler;
import net.tolmikarc.townymenu.plot.command.PlotMenuCommand;
import net.tolmikarc.townymenu.town.command.TownMenuCommand;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;

public class TownyMenuPlugin extends SimplePlugin {

	@Override
	protected void onPluginStart() {

		Common.log("Enabling Towny Menu by BebopBenny");
		Common.log("for TownyAdvanced");

		registerCommand(new TownMenuCommand());
		registerCommand(new PlotMenuCommand());


		TownyEconomyHandler.initialize(Towny.getPlugin());
	}
}
