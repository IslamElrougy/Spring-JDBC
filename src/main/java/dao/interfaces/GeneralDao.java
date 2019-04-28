/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Islam El-Rougy
 */
public interface GeneralDao
{
    public int countAll(String tableName);
    public <T,G> T retrievebyId(G id, String tableName);
    public <T> List<T> retrieveAll(String tableName);
    public <T, G> List<T> retrieveAllBySingleProperty(String tableName, String columnName, G retrievalProperty);
    public <T, G> T retrieveByUniqueKey(String tableName, String columnName, G retrievalProperty);
    public <T> void insert(T entity);
    public <T> void deleteById(T userId, String tableName);
}
