package charactercounter.caсhe;

public interface CaсheProvider <K, V> {
    boolean isPresent(K key);
    
    void putValue(K key, V value);
    
    V getValue(K key);
}
