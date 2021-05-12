package tqs.Air_Quality;

import org.hibernate.event.spi.SaveOrUpdateEvent;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private Map cacheMap;
    private long timeToLive;

    public int hits;
    public int misses;

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

        this.hits = 0;
        this.misses = 0;
    }

    public void put(String key, String quality) {
        cacheMap.put(key, new CacheObject(quality));
    }

    public String get(String key) {
        if (cacheMap.containsKey(key)) {
            CacheObject cO = (CacheObject) cacheMap.get(key);
            if ((System.currentTimeMillis() - cO.lastAccessed) > timeToLive) {
                cacheMap.remove(key);
            }else {
                hits += 1;
                return cO.getQuality();
            }
        }
        misses += 1;
        return null;
    }

    public int size(){
        return cacheMap.size();
    }

    public int getHits() {
        return hits;
    }

    public int getMisses() {
        return misses;
    }

    public int getRequests() {
        return hits + misses;
    }

    public void getCacheMap(){
        System.out.println("| CACHE MAP");
        cacheMap.forEach((k,v) -> {
            CacheObject value = (CacheObject) v;
            System.out.println("| " + k + " - " + value.getQuality());
        });
        System.out.println("----------");
    }


}

