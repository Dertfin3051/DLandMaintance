package dland_maintance.dland_maintance;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class MaintanceEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (Maintance.status.equals("Maintance")) {
            if (event.getPlayer().hasPermission("maintance.bypass")) {
                event.getPlayer().sendMessage(ChatColor.RED + "Добро пожаловать, Админ! На сервере включен статус : Тех-Работы");
                event.getPlayer().sendMessage(ChatColor.RED + "В данный момент игроки не могут зайти на сервер. Используй '/maintance off' для отключения этого режима.");
            } else {
                event.getPlayer().kickPlayer(ChatColor.RED + "На сервере идут Тех-Работы. Перезайдите позже");
            }
        } else if (Maintance.status.equals("BugFix")) {
            if (event.getPlayer().hasPermission("maintance.bypass")) {
                event.getPlayer().sendMessage(ChatColor.RED + "Добро пожаловать, Админ! На сервере включен статус : Фикс Бага");
                event.getPlayer().sendMessage(ChatColor.RED + "В данный момент игроки не могут зайти на сервер. Используй '/maintance off' для отключения этого режима.");
            } else {
                event.getPlayer().kickPlayer(ChatColor.RED + "На сервере идёт фикс бага. Перезайдите позже");
            }
        } else if (Maintance.status.equals("off")) {
            // Тут ничего не происходит
        } else if (Maintance.status.equals("Custom")) {
            if (event.getPlayer().hasPermission("maintance.bypass")) {
                event.getPlayer().sendMessage(ChatColor.RED + "Добро пожаловать, Админ! На сервере включен статус : " + Maintance.status_msg);
                event.getPlayer().sendMessage(ChatColor.RED + "В данный момент игроки не могут зайти на сервер. Используй '/maintance off' для отключения этого режима.");
            } else {
                event.getPlayer().kickPlayer(Maintance.status_msg);
            }
        }
    }
}
