package com.ethanphunter.coordinatescommand.command;

import java.util.Collections;
import java.util.List;

import net.kyori.adventure.text.Component;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CoordinatesCommand implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        Location location = player.getLocation();
        String description = "";

        if (args.length > 0) {
            StringBuilder descBuilder = new StringBuilder();
            for (String arg : args) {
                descBuilder.append(" ").append(arg);
            }

            description = descBuilder.toString();
        }
        Component message = Component.text(
            player.getName()
            + " ["
            + Math.round(location.getX()) + ", "
            + Math.round(location.getY()) + ", "
            + Math.round(location.getZ()) + "]"
            + description
            );
        Bukkit.broadcast(message);
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command,
            @NotNull String label, @NotNull String[] args) {
        return Collections.emptyList();
    }
}
