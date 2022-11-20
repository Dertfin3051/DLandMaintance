package dland_maintance.dland_maintance;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class MaintanceCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> args1 = new ArrayList<>();
        args1.add("maintance");
        args1.add("bugfix");
        args1.add("off");
        if (args.length == 1) {
            return args1;
        }
        return null;
    }
}
