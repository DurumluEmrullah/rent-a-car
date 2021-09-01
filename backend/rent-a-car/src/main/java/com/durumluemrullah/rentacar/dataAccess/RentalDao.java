package com.durumluemrullah.rentacar.dataAccess;

import com.durumluemrullah.rentacar.entities.concrete.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class RentalDao {

    private final String INSERT_QUERY="INSERT INTO public.\"RENTALS\"(customer_id, rent_date, return_date) VALUES (:customer_id" +
            ", :rent_date, :return_date);";
    private final String SELECT_QUERY="SELECT * FROM public.\"RENTALS\"";
    private final String DELETE_QUERY="DELETE FROM public.\"RENTALS\" WHERE id=:id;";
    private final String UPDATE_QUERY="UPDATE public.\"RENTALS\" SET customer_id=:customer_id,rent_date=:rent_date,return_date=:return_date WHERE brand_id=:id;";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void create(Rental rental){
        HashMap<String,Object> params= new HashMap<>();
        params.put("customer_id",rental.getCustomerId());
        params.put("rent_date",rental.getRentDate());
        params.put("return_date",rental.getReturnDate());
        namedParameterJdbcTemplate.update(INSERT_QUERY,params);

    }

    public List<Rental> getAll(){

        List<Rental> rentals = namedParameterJdbcTemplate.query(SELECT_QUERY, new RowMapper<Rental>() {
            @Override
            public Rental mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Rental(resultSet.getInt("id"),resultSet.getInt("customer_id"),resultSet.getDate("rent_date"),resultSet.getDate("return_date"));
            }
        });
        return rentals;
    }

    public void delete(int id){

        HashMap<String,Object> params = new HashMap<>();
        params.put("id",id);
        namedParameterJdbcTemplate.update(DELETE_QUERY,params);
    }

    public void update(Rental rental){
        HashMap<String,Object> params= new HashMap<>();
        params.put("id",rental.getId());
        params.put("customer_id",rental.getCustomerId());
        params.put("rent_date",rental.getRentDate());
        params.put("return_date",rental.getReturnDate());
        namedParameterJdbcTemplate.update(UPDATE_QUERY,params);
    }


}
