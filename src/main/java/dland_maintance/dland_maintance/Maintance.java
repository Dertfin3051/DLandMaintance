package dland_maintance.dland_maintance;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class Maintance implements CommandExecutor {
    public static String status = "off";
    public static String status_msg = "None";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("maintance.admin")) {
            if (args[0].equalsIgnoreCase("maintance")) {
                status = "Maintance";
                sender.sendMessage("" + ChatColor.RED + ChatColor.BOLD + "Включен режим : Тех-Работы");
                return true;
            } else if (args[0].equalsIgnoreCase("bugfix")) {
                status = "BugFix";
                sender.sendMessage("" + ChatColor.RED + ChatColor.BOLD + "Включен режим : Фикс-Бага");
                return true;
            } else if (args[0].equalsIgnoreCase("off")) {
                status = "off";
                sender.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "Включен режим : Сервер Открыт!");
                return true;
            } else if (args[0].equalsIgnoreCase("custom")) {
                status = "Custom";
                sender.sendMessage("" + ChatColor.RED + ChatColor.BOLD + "Включен режим : Custom");
                return true;
            } else if (args[0].equalsIgnoreCase("reload")) {
                Plugin plugin = DLand_Maintance.getPlugin(DLand_Maintance.class);
                plugin.reloadConfig();
                plugin.saveConfig();
                sender.sendMessage(ChatColor.GREEN + "Конфиг перезагружен! ");
                return true;
            }
        } else {
            sender.sendMessage(ChatColor.RED + "У вас нет прав на данную команду! ");
            return true;
        }
        return false;
    }
}
