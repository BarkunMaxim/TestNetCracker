package com.netcracker.edu.storage;

import  java.util.Map;
import java.util.HashMap;

public final class TemporaryStorage {
    private Map<String, Object> storage = new HashMap<String, Object>(256);

    private TemporaryStorage(){

    }

    public Object getEntity(String id){
        return storage.get(id);
    }

    public void insertEntity(String id, Object entity){
        storage.put(id,entity);
    }

    public static TemporaryStorage getInstance(){
        return Holder.instance;
    }

    private static class Holder{
        private static TemporaryStorage instance = new TemporaryStorage();
    }
}
