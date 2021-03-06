package com.strixmc.powerup.cache;

import com.google.inject.Singleton;
import com.strixmc.common.cache.CacheProvider;
import com.strixmc.powerup.powerup.PowerUp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class PowerUpsCache implements CacheProvider<String, PowerUp> {

  private Map<String, PowerUp> powerUpMap;

  public PowerUpsCache() {
    this.powerUpMap = new ConcurrentHashMap<>();
  }

  @Override
  public Map<String, PowerUp> get() {
    return this.powerUpMap;
  }
}
