package Flyweight_1;

import java.util.HashMap;
import java.util.Map;

public class SoldierFactory {
    private static final Map<String, Soldier> cache = new HashMap<>();

    public static Soldier getSoldier(String vuKhi, String trangPhuc) {
        String key = vuKhi + "-" + trangPhuc;

        if (!cache.containsKey(key)) {
            cache.put(key, new SoldierType(vuKhi, trangPhuc));
        }

        return cache.get(key);
    }
}
