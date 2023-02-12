package charactercounter.caсhe;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheProviderImpl<K, V> extends LinkedHashMap<K, V> implements CaсheProvider<K, V>{
    private final int capacity;
    
    public LRUCacheProviderImpl(int capacity) {
        super(capacity + 1, 0.75f, true);
        this.capacity = capacity;
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return(size() > this.capacity);
    }

    @Override
    public void putValue(K key, V value) {
        super.put(key, value);
    }

    @Override
    public boolean isPresent(K key) {
        return (super.containsKey(key));
    }

    @Override
    public V getValue(K key) {
        return super.get(key);
    }
}
