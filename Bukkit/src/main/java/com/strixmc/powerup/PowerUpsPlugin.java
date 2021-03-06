package com.strixmc.powerup;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.strixmc.common.service.ServiceManager;
import com.strixmc.powerup.utilities.BinderModule;
import org.bukkit.plugin.java.JavaPlugin;

public class PowerUpsPlugin extends JavaPlugin {

  @Inject @Named("Plugin-Service") private ServiceManager pluginService;

  @Override
  public void onEnable() {
    if (!getServer().getPluginManager().isPluginEnabled("HolographicDisplays")) {
      getServer().getPluginManager().disablePlugin(this);
      return;
    }

    BinderModule module = new BinderModule(this);
    Injector injector = module.createInjector();
    injector.injectMembers(this);

    pluginService.start();
  }

  @Override
  public void onDisable() {
    pluginService.stop();
  }

}
