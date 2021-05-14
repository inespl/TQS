package tqs.Air_Quality;

import org.hibernate.event.spi.SaveOrUpdateEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cache {
    private Map cacheMap;
    private long timeToLive;

    public class CacheObject {
        public long lastAccessed = System.currentTimeMillis();
        public String quality;

        public CacheObject(String quality) {
            this.quality = quality;
        }

        private String getQuality(){
            return this.quality;
        }
    }

    public Cache(long ttl) {
        this.timeToLive = ttl;
        cacheMap = new HashMap<String, CacheObject>();
    }

    public void put(String key, String quality) {
        cacheMap.put(key, new CacheObject(quality));
    }

    public String get(String key) {
        if (cacheMap.containsKey(key)) {
            CacheObject cO = (CacheObject) cacheMap.get(key);
            if ((System.currentTimeMillis() - cO.lastAccessed) > timeToLive)
                cacheMap.remove(key);
            else
                return cO.getQuality();
        }
        return null;
    }

    public int size(){
        return cacheMap.size();
    }

    public void getCacheMap(){
        System.out.println("| CACHE MAP");
        cacheMap.forEach((k,v) -> {
            CacheObject value = (CacheObject) v;
            System.out.println("| " + k + " - " + value.getQuality());
        });
        System.out.println("----------");
    }

    public List<String> getCache(){
        List<String> mapKeys = new ArrayList<>();

        cacheMap.forEach((k,v) -> {
            CacheObject value = (CacheObject) v;
            if ((System.currentTimeMillis() - value.lastAccessed) > timeToLive)
                cacheMap.remove(k);
            else
                mapKeys.add((String) k);
        });
        return mapKeys;
    }


}

