package org.welcome;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RecentlyPlayedStore {
    private Map<String, List<String>> store;
    private int capacity;
    public RecentlyPlayedStore(int capacity) {
        this.store = new LinkedHashMap<>();
        this.capacity = capacity;
    }
    public void addSong(String user, String song) {
        List<String> songs = store.get(user);
        if (songs == null) {
            songs = new LinkedList<>();
            store.put(user, songs);
        }
        songs.add(song);
        if (songs.size() > capacity) {
            songs.remove(0);
        }
    }
    public List<String> getRecentSongs(String user) {
        return store.getOrDefault(user, new LinkedList<>());
    }
    public static void main(String[] args) {
        RecentlyPlayedStore store = new RecentlyPlayedStore(5);
        store.addSong("Alice", "Song1");
        store.addSong("Alice", "Song2");
        store.addSong("Bob", "Song3");
        store.addSong("Alice", "Song4");
        store.addSong("Bob", "Song5");
        store.addSong("Charlie", "Song6");
        store.addSong("Bob", "Song7");
        store.addSong("Alice", "Song8");
      
        System.out.println("Recent songs for Alice: " + store.getRecentSongs("Alice"));
        System.out.println("Recent songs for Bob: " + store.getRecentSongs("Bob"));
        System.out.println("Recent songs for Charlie: " + store.getRecentSongs("Charlie"));
        System.out.println("Recent songs for David: " + store.getRecentSongs("David"));
    }
}


