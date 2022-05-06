package dao;

import java.util.List;

public interface DAO<Entity> {

    void create(Entity t);
    void update(Entity t);
    void delete(int t);
    List<Entity> read();
    void print();
}
