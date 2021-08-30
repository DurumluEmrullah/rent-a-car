package com.durumluemrullah.rentacar.dataAccess;

import com.durumluemrullah.rentacar.entities.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class ColorDao {

    private final String INSERT_QUERY="INSERT INTO public.\"COLORS\"(name) VALUES (:name);";
    private final String SELECT_QUERY="SELECT * FROM public.\"COLORS\"";
    private final String DELETE_QUERY="DELETE FROM public.\"COLORS\" WHERE color_id=:id;";
    private final String UPDATE_QUERY="UPDATE public.\"COLORS\" SET name=:name WHERE color_id=:id;";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void create(Color color){
        HashMap<String, Object> mapParams= new HashMap<>();
        mapParams.put("name",color.getName());

        namedParameterJdbcTemplate.update(INSERT_QUERY,mapParams);
    }

    public List<Color> getAll(){
        List<Color> colors = namedParameterJdbcTemplate.query(SELECT_QUERY, new RowMapper<Color>() {
            @Override
            public Color mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Color(resultSet.getInt("color_id"),resultSet.getString("name"));
            }
        });
        return colors;
    }

    public void delete(int id){
        HashMap<String, Object> mapParams= new HashMap<>();
        mapParams.put("id",id);

        namedParameterJdbcTemplate.update(DELETE_QUERY,mapParams);
    }

    public void update(Color color){
        HashMap<String, Object> mapParams= new HashMap<>();
        mapParams.put("id",color.getColorId());
        mapParams.put("name",color.getName());

        namedParameterJdbcTemplate.update(UPDATE_QUERY,mapParams);
    }

}
