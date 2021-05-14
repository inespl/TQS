package tqs.Air_Quality;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cache {
    private Map<String, CacheObject> cacheMap;
    private long timeToLive;

    public class CacheObject {
        private long lastAccessed = System.currentTimeMillis();
        private String quality;

        public CacheObject(String quality) {
            this.quality = quality;
        }

        private String getQuality(){
            return this.quality;
        }
    }

    public Cache(long ttl) {
        this.timeToLive = ttl;
        cacheMap = new HashMap<>();
    }

    public void put(String key, String quality) {
        cacheMap.put(key, new CacheObject(quality));
    }

    public String get(String key) {
        if (cacheMap.containsKey(key)) {
            CacheObject cO = cacheMap.get(key);
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
        StringBuilder sb = new StringBuilder();
        sb.append("| CACHE MAP");
        cacheMap.forEach((k,v) -> {
            CacheObject value = v;
            sb.append("| " + k + " - " + value.getQuality());
        });
        sb.append("----------");
    }

    public List<String> getCache(){
        List<String> mapKeys = new ArrayList<>();

        cacheMap.forEach((k,v) -> {
            CacheObject value = v;
            if ((System.currentTimeMillis() - value.lastAccessed) > timeToLive)
                cacheMap.remove(k);
            else
                mapKeys.add(k);
        });
        return mapKeys;
    }


}

