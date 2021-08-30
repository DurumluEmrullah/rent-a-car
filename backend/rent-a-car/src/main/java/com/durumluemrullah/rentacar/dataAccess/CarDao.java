package com.durumluemrullah.rentacar.dataAccess;

import com.durumluemrullah.rentacar.entities.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
@Repository
public class CarDao {

    private final String SELECT_QUERY="SELECT * FROM \"CARS\"";
    private final String INSERT_QUERY="INSERT INTO public.\"CARS\"( brand_id, color_id, model_year, daily_price, description) VALUES ( :brand_id, :color_id, :model_year, :daily_price, :description);";
    private final String DELETE_QUERY="DELETE FROM public.\"CARS\" WHERE car_id=:car_id;";
    private final String UPDATE_QUERY="UPDATE public.\"CARS\" SET brand_id=:brand_id, color_id=:color_id, model_year=:model_year, daily_price=:daily_price, description=:description WHERE car_id=:car_id;";

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
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("car_id",car.getCarId());
        paramMap.put("brand_id",car.getBrandId());
        paramMap.put("color_id",car.getColorId());
        paramMap.put("model_year",car.getModelYear());
        paramMap.put("daily_price",car.getDailyPrice());
        paramMap.put("description",car.getDescription());
        namedParameterJdbcTemplate.update(UPDATE_QUERY,paramMap);
    }

    public List<Car> getAll(){
        List<Car> cars = namedParameterJdbcTemplate.query(SELECT_QUERY, new RowMapper<Car>() {
            @Override
            public Car mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Car(resultSet.getInt("car_id"), resultSet.getInt("brand_id"), resultSet.getInt("color_id")
                        , resultSet.getInt("model_year"), resultSet.getDouble("daily_price"), resultSet.getString("description"));
            }
        });
        return cars;
    }

    public void delete(int id){
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("car_id",id);
        namedParameterJdbcTemplate.update(DELETE_QUERY,paramMap);
    }
}
