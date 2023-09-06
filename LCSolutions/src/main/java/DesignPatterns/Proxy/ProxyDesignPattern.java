package main.java.DesignPatterns.Proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface EntityInterface{

    Entity getEntity(String id);
    void saveEntity(Entity entity);
}
class Entity{
    String id;
    String name;
}

class RealEntity implements EntityInterface{

    Map<String, Entity> entities = new HashMap<>();

    @Override
    public Entity getEntity(String id) {
        return entities.get(id);
    }

    @Override
    public void saveEntity(Entity entity) {
        entities.put(entity.id, entity);
    }
}

class EntityProxy implements EntityInterface{

    @Override
    public Entity getEntity(String id) {
        return new Entity();
    }

    @Override
    public void saveEntity(Entity entity) {

    }
}

public class ProxyDesignPattern {


}
