package leetCode;
import java.util.TreeMap;
import java.util.Comparator;

public class LRUCache {
    public static class Key {
        int key;
        int time;
        public Key (int key, int time) {
            this.key  =  key;
            this.time =  time;
        }
        @Override
        public boolean equals(Object o) {
            if ( !this.getClass().equals(o.getClass()) ) {
                return false;
            }
            Key	other  =  (Key)o;
            if ( this.key  ==  other.key ) {
                return true;
            } else {
            	return false;
            }
        }
        @Override
        public int  hashCode () {
            int     prime  =  31;
            return prime * key;
        }
    }
    
    private TreeMap<Key, Integer>   cache;
    private         int     timeStamp;
    private         int     capacity;
    
    
    public LRUCache(int capacity) {
        cache  =  new TreeMap<>(new Comparator<Key>(){
            @Override
            public int compare (Key k1, Key k2) {
                if ( k1.time < k2.time ) {
                    return -1;
                } else if ( k1.time == k2.time ) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        timeStamp  =  0;
        this.capacity  =  capacity;
    }
    
    public int get(int key) {
        if ( cache.containsKey(new Key(key, 0)) ) {
            timeStamp++;
            int     val  =  cache.get( new Key(key, 0) );
            cache.put(new Key(key, timeStamp), val );
            return val;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        timeStamp++;
        if ( cache.containsKey(new Key(key, 0)) ) {
            cache.put(new Key(key, timeStamp), value);
        } else {
            if ( cache.size() >= capacity ) {
                cache.pollFirstEntry();
            }
            cache.put(new Key(key, timeStamp), value);
        }
    }
}