package com.durumluemrullah.rentacar.dataAccess;

import com.durumluemrullah.rentacar.entities.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class CarDao {

    private final String SELECT_QUERY="";
    private final String INSERT_QUERY="INSERT INTO public.\"CARS\"( brand_id, color_id, model_year, daily_price, description) VALUES ( :brand_id, :color_id, :model_year, :daily_price, :description);";
    private final String DELETE_QUERY="";
    private final String UPDATE_QUERY="";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void create(Car car){
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("brand_id",car.getBrandId());
        paramMap.put("color_id",car.getColorId());
        paramMap.put("model_year",car.getModelYear());
        paramMap.put("daily_price",car.getDailyPrice());
        paramMap.put("description",car.getDescription());
        namedParameterJdbcTemplate.update(INSERT_QUERY,paramMap);
    }
    public void update(Car car){

    }

    public List<Car> getAll(){
        return null;
    }

    public void delete(int id){

    }
}
