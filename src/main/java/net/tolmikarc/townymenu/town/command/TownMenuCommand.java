package net.tolmikarc.townymenu.town.command;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import lombok.SneakyThrows;
import net.tolmikarc.townymenu.settings.Localization;
import net.tolmikarc.townymenu.town.TownMenu;
import org.mineacademy.fo.command.SimpleCommand;

public class TownMenuCommand extends SimpleCommand {
	public TownMenuCommand() {
		super("townmenu|tm");
		setPermission(null);

	}

	@SneakyThrows
	@Override
	protected void onCommand() {
		checkConsole();

		Town town;
		Resident resident = TownyAPI.getInstance().getResident(getPlayer().getUniqueId());
		if (resident.hasTown()) {
			town = resident.getTown();
			if (town.getMayor().equals(resident))
				new TownMenu(town, getPlayer()).displayTo(getPlayer());
			else if (getPlayer().hasPermission("townymenu.town.use")) {
				new TownMenu(town, getPlayer()).displayTo(getPlayer());
			} else
				tell(Localization.Error.NO_PERMISSION);
		} else {
			tell(Localization.Error.NO_TOWN);
		}


	}

}
