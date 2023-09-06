package main.java.Design;

import java.util.*;

class Entry<K,V> {
    K key;
    V value;

    public Entry(K key, V value){
        this.key = key;
        this.value = value;
    }
}
public class HashMap<K,V> {

    int initalCapacity = 8;
    List<Entry<K,V>>[] buckets;

    public HashMap(){
        buckets = new LinkedList[initalCapacity];
    }

    public void put(K key, V value){
        if(key == null){
            handlePutForNull(key, value);
        } else {
            int hash= key.hashCode();
            int location = hash % 8;
            if(Objects.isNull(buckets[location])){
                buckets[location] = new LinkedList<>();
            } else {
                System.out.println("Collision detected for loc: " + location + " and key: " + key);
            }
            for (Entry<K,V> entry: buckets[location]) {
                if(entry.key.equals(key) && entry.key == key){
                    entry.value = value;
                    return;
                }
            }
            buckets[location].add(new Entry<>(key, value));
        }
    }

    public V get(K key){
        if(key == null){
            return buckets[0].get(0).value;
        } else {
            int hash= key.hashCode();
            int location = hash % 8;
            if(Objects.isNull(buckets[location])){
                return null;
            } else {
                for (Entry<K, V> entry: buckets[location]){
                    if(entry.key.equals(key) && entry.key == key){
                        return entry.value;
                    }
                }
                return null;
            }
        }
    }

    private void handlePutForNull(K key, V value){
        if (Objects.isNull(buckets[0]))
            buckets[0] = new LinkedList<>();
        buckets[0].set(0, new Entry<>(key, value));
    }

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap();
        map.put(1, "aa");
        map.put(2, "bb");
        map.put(3, "cc");
        Random rand = new Random();
        for (int i = 0; i< 50; i++){
            map.put(rand.nextInt(50), UUID.randomUUID().toString());
        }
        System.out.println(map.get(2));
    }
}
