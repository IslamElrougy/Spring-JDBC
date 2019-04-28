/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementation;

import dao.interfaces.GeneralDao;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.core.GenericTypeResolver;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 *
 * @author Islam El-Rougy
 */
public class GeneralDaoImpl<Entity, Id> implements GeneralDao<Entity, Id> {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(getTableName())
                .usingGeneratedKeyColumns("id");
    }

    protected void update(String updateQuery, Object[] updateQueryParameters) {
        jdbcTemplate.update(updateQuery, updateQueryParameters);
    }

    private Class getEntityClass() {
        return (Class<Entity>) GenericTypeResolver
                .resolveTypeArgument(getClass(),
                        GeneralDaoImpl.class);
    }

    private String getTableName() {
        return getEntityClass().getName();
    }

    private RowMapper getTableRowMapper() {
        RowMapper rowMapper = null;
        try {
            rowMapper = (RowMapper) Class.forName(getTableName() + "RowMapper").newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GeneralDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GeneralDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GeneralDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (rowMapper == null) {
            rowMapper = new BeanPropertyRowMapper(getEntityClass());
        }
        return rowMapper;
    }

    @Override
    public int countAll() {
        String countQuery = "select count(*) from " + getTableName();
        int rowCount = jdbcTemplate.queryForObject(countQuery, Integer.class);
        return rowCount;
    }

    @Override
    public Entity retrievebyId(Id id) {
        String retrievalQuery = "select * from " + getTableName() + " where id = ?";
        Entity retrievedEntity = (Entity) jdbcTemplate.queryForObject(retrievalQuery,
                new Object[]{id}, getTableRowMapper());
        return retrievedEntity;
    }

    @Override
    public Entity retrieveByUniqueKey(String columnName, Object retrievalProperty) {
        String retrievalQuery = "select * from " + getTableName() + " where " + columnName + " = ?";
        Entity retrievedEntity = (Entity) jdbcTemplate.queryForObject(retrievalQuery,
                new Object[]{retrievalProperty}, getTableRowMapper());
        return retrievedEntity;
    }

    @Override
    public List<Entity> retrieveAll() {
        String retrievalQuery = "select * from " + getTableName();
        List<Entity> retrievedList = jdbcTemplate
                .query(retrievalQuery, getTableRowMapper());
        return retrievedList;
    }

    @Override
    public List<Entity> retrieveAllBySingleProperty(String columnName, Object retrievalProperty) {
        String retrievalQuery = "select * from " + getTableName() + " where " + columnName + " = ?";
        Object[] retrievalQueryParameters = new Object[]{retrievalProperty};
        List<Entity> retrievedList = jdbcTemplate.query(retrievalQuery,
                retrievalQueryParameters, getTableRowMapper());
        return retrievedList;
    }

    @Override
    public void insert(Entity entity) {
        SqlParameterSource parameters = new BeanPropertySqlParameterSource(entity);
        simpleJdbcInsert.execute(parameters);
    }

    @Override
    public void deleteById(Id userId) {
        String deletionQuery = "delete from " + getTableName() + " where id = ?";
        Object[] deletionQueryParameters = new Object[]{userId};
        jdbcTemplate.update(deletionQuery, deletionQueryParameters);
    }

    @Override
    public void deleteByObject(Entity entity) {
        try {
            Field field = getEntityClass().getDeclaredField("id");
            field.setAccessible(true);
            Id id = (Id) field.get(entity);
            deleteById(id);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(GeneralDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(GeneralDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GeneralDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
