package com.strixmc.powerup.utilities.lang;

import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface LangUtility {

    void load();

    void createLang();

    FileConfiguration getLang();

    String getNoPermission();

    List<String> getHelp();

    String getNoAvailablePowerUp();

    String getAvailablePowerUp();

    String getAlreadyExist(@NotNull String name);

    String getNoExist(@NotNull String name);

    String getAlreadyEnabled(@NotNull String name);

    String getEnabled(@NotNull String name);

    String getAlreadyDisabled(@NotNull String name);

    String getDisabled(@NotNull String name);

    String getCreated(@NotNull String name, @NotNull String id);

    String getCreateHelp();

    String getDeleted(@NotNull String name);
}
