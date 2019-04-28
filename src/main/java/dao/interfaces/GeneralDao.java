/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.util.List;

/**
 *
 * @author Islam El-Rougy
 */
public interface GeneralDao<Entity, Id> {

    public int countAll();

    public Entity retrievebyId(Id id);

    public Entity retrieveByUniqueKey(String columnName, Object retrievalProperty);

    public List<Entity> retrieveAll();

    public List<Entity> retrieveAllBySingleProperty(String columnName, Object retrievalProperty);

    public void insert(Entity entity);

    public void deleteById(Id userId);

    public void deleteByObject(Entity entity);
}
