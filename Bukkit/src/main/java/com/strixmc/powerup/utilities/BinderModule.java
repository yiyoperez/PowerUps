package com.strixmc.powerup.utilities;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import com.strixmc.common.cache.CacheProvider;
import com.strixmc.common.loader.LoaderManager;
import com.strixmc.common.service.ServiceManager;
import com.strixmc.powerup.PowerUpsPlugin;
import com.strixmc.powerup.cache.ActiveHologramsCache;
import com.strixmc.powerup.cache.PowerUpsCache;
import com.strixmc.powerup.loaders.LangUtilityLoader;
import com.strixmc.powerup.loaders.ListenersLoader;
import com.strixmc.powerup.powerup.PowerUp;
import com.strixmc.powerup.services.ActiveHologramsService;
import com.strixmc.powerup.services.PluginService;
import com.strixmc.powerup.utilities.lang.LangUtility;
import com.strixmc.powerup.utilities.lang.LangUtilityManager;
import com.strixmc.powerup.loaders.CommandsLoader;
import com.strixmc.powerup.services.PowerUpsService;

public class BinderModule extends AbstractModule {

  private final PowerUpsPlugin plugin;

  public BinderModule(PowerUpsPlugin plugin) {
    this.plugin = plugin;
  }

  public Injector createInjector() {
    return Guice.createInjector(this);
  }

  @Override
  protected void configure() {
    bind(PowerUpsPlugin.class).toInstance(this.plugin);
    bind(LangUtility.class).to(LangUtilityManager.class);

    bind(new TypeLiteral<CacheProvider<String, PowerUp>>() {
    }).annotatedWith(Names.named("PowerUpsCache")).to(PowerUpsCache.class);
    bind(new TypeLiteral<CacheProvider<Long, Hologram>>() {
    }).annotatedWith(Names.named("ActiveHologramsCache")).to(ActiveHologramsCache.class);

    this.bind(ServiceManager.class).annotatedWith(Names.named("Plugin-Service")).to(PluginService.class);
    this.bind(ServiceManager.class).annotatedWith(Names.named("PowerUpsService")).to(PowerUpsService.class);
    this.bind(ServiceManager.class).annotatedWith(Names.named("ActiveHologramsService")).to(ActiveHologramsService.class);

    this.bind(LoaderManager.class).annotatedWith(Names.named("CommandsLoader")).to(CommandsLoader.class);
    this.bind(LoaderManager.class).annotatedWith(Names.named("LangUtilityLoader")).to(LangUtilityLoader.class);
    this.bind(LoaderManager.class).annotatedWith(Names.named("ListenersLoader")).to(ListenersLoader.class);
  }
}
