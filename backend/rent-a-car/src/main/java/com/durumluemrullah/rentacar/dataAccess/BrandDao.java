package com.durumluemrullah.rentacar.dataAccess;

import com.durumluemrullah.rentacar.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
@AllArgsConstructor
public class BrandDao {

    private final String INSERT_QUERY="INSERT INTO public.\"BRANDS\"(name) VALUES (:name);";
    private final String SELECT_QUERY="SELECT * FROM public.\"BRANDS\"";
    private final String DELETE_QUERY="DELETE FROM public.\"BRANDS\" WHERE brand_id=:id;";
    private final String UPDATE_QUERY="UPDATE public.\"BRANDS\" SET name=:name WHERE brand_id=:id;";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void create(Brand brand){
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("name",brand.getName());
        namedParameterJdbcTemplate.update(INSERT_QUERY,paramMap);
    }

    public List<Brand> getAll(){
        List<Brand> brands = namedParameterJdbcTemplate.query(SELECT_QUERY, new RowMapper<Brand>() {
            @Override
            public Brand mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Brand(resultSet.getInt("brand_id"), resultSet.getString("name"));
            }
        });
        return brands;
    }

    public void delete(int id){
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("id",id);
        namedParameterJdbcTemplate.update(DELETE_QUERY,paramMap);
    }

    public void update(Brand brand){
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("id",brand.getBrandId());
        paramMap.put("name",brand.getName());
        namedParameterJdbcTemplate.update(UPDATE_QUERY,paramMap);
    }

    public Brand getById(int id){
        String sql = SELECT_QUERY +" where brand_id =:id";
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("id",id);
        List<Brand> brands = namedParameterJdbcTemplate.query(SELECT_QUERY, new RowMapper<Brand>() {
            @Override
            public Brand mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Brand(resultSet.getInt("brand_id"), resultSet.getString("name"));
            }
        });
        return brands.get(0);
    }

}
