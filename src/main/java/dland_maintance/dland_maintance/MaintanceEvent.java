package dland_maintance.dland_maintance;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import javax.security.auth.login.Configuration;

public class MaintanceEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Plugin plugin = DLand_Maintance.getPlugin(DLand_Maintance.class);
        if (Maintance.status.equals("Maintance")) {
            if (event.getPlayer().hasPermission("maintance.bypass")) {
                event.getPlayer().sendMessage(ChatColor.RED + "Добро пожаловать, Админ! На сервере включен статус : Тех-Работы");
                event.getPlayer().sendMessage(ChatColor.RED + "В данный момент игроки не могут зайти на сервер. Используй '/maintance off' для отключения этого режима.");
            } else {
                FileConfiguration getConfig = plugin.getConfig();
                event.getPlayer().kickPlayer(ChatColor.RED + getConfig.getString("maintance.line1") + "\n" + getConfig.getString("maintance.line2") + "\n"+ getConfig.getString("maintance.line3"));
            }
        } else if (Maintance.status.equals("BugFix")) {
            if (event.getPlayer().hasPermission("maintance.bypass")) {
                event.getPlayer().sendMessage(ChatColor.RED + "Добро пожаловать, Админ! На сервере включен статус : Фикс Бага");
                event.getPlayer().sendMessage(ChatColor.RED + "В данный момент игроки не могут зайти на сервер. Используй '/maintance off' для отключения этого режима.");
            } else {
                FileConfiguration getConfig = plugin.getConfig();
                event.getPlayer().kickPlayer(ChatColor.RED + getConfig.getString("bugfix.line1") + "\n" + getConfig.getString("bugfix.line2") + "\n"+ getConfig.getString("bugfix.line3"));
            }
        } else if (Maintance.status.equals("off")) {
            // Тут ничего не происходит
        } else if (Maintance.status.equals("Custom")) {
            if (event.getPlayer().hasPermission("maintance.bypass")) {
                event.getPlayer().sendMessage(ChatColor.RED + "Добро пожаловать, Админ! На сервере включен статус : " + Maintance.status_msg);
                event.getPlayer().sendMessage(ChatColor.RED + "В данный момент игроки не могут зайти на сервер. Используй '/maintance off' для отключения этого режима.");
            } else {
                FileConfiguration config = plugin.getConfig();
                event.getPlayer().kickPlayer(ChatColor.RED + config.getString("custom.line1") + "\n" + config.getString("custom.line2")+ "\n" + config.getString("custom.line3"));
            }
        }
    }
}
