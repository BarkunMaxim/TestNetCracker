package com.netcracker.edu.storage;

import com.netcracker.edu.entity.Person;

import java.util.*;

public final class TemporaryStorage {
    private Map<String, Object> storage = new HashMap<>(256);

    private TemporaryStorage() {

    }

    public Object getEntity(String id) {
        return storage.get(id);
    }

    public Object deleteEntity(String id) {
        return storage.remove(id);
    }

    public void deleteAllPerson() {
        storage.values().removeIf(val -> val.getClass().equals(Person.class));
    }

    public List<Object> getAllEntity() {

        return new ArrayList<>(storage.values());
    }

    public void insertEntity(String id, Object entity) {
        storage.put(id, entity);
    }

    public static TemporaryStorage getInstance() {
        return Holder.instance;
    }

    private static class Holder {
        private static TemporaryStorage instance = new TemporaryStorage();
    }
}
