package tqs.Air_Quality;

import tqs.entities.Quality;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private Map cacheMap;
    private long timeToLive;

    public int hits;
    public int misses;

    public class CacheObject {
        public long lastAccessed = System.currentTimeMillis();
        public Quality quality;

        public CacheObject(Quality quality) {
            this.quality = quality;
        }
        private Quality getQuality(){
            return this.quality;
        }
    }

    public Cache(long ttl) {
        this.timeToLive = ttl;
        cacheMap = new HashMap<String, CacheObject>();

        this.hits = 0;
        this.misses = 0;
    }

    public void put(String key, Quality quality) {
        cacheMap.put(key, new CacheObject(quality));
    }

    public Quality get(String key) {
        if (cacheMap.containsKey(key)) {
            CacheObject cO = (CacheObject) cacheMap.get(key);
            if (cO.lastAccessed > timeToLive) {
                misses += 1;
                cacheMap.remove(key);
            }else {
                hits += 1;
                return cO.getQuality();
            }
        }
        return null;
    }

    public int getHits() {
        return hits;
    }

    public int getMisses() {
        return misses;
    }


}

