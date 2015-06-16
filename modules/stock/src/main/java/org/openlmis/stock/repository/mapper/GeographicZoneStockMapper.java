package org.openlmis.stock.repository.mapper;

import org.apache.ibatis.annotations.*;
import org.openlmis.stock.domain.GeographicZoneStock;
import org.openlmis.stock.domain.Vaccine;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Morley on 6/14/2015.
 */

@Repository
public interface GeographicZoneStockMapper {
    @Select("select * from geographic_zone_stocks")
    List<GeographicZoneStock> getAll();

    @Insert("insert into geographic_zone_stocks (expire_date, lot_number, number_of_doses, vaccine_id, geographic_zone_id) values " +
            "(#{expire_date}, #{lot_number}, #{number_of_doses}, #{vaccine_id}, #{geographic_zone_id})")
    @Options(flushCache = true, useGeneratedKeys = true)
    Integer insert(GeographicZoneStock geographicZoneStock);

    @Update("update geographic_zone_stocks " +
            "set " +
            " expire_date = #{expire_date}, " +
            " lot_number = #{lot_number}," +
            " number_of_doses = #{number_of_doses}, " +
            " vaccine_id = #{vaccine_id}, " +
            " geographic_zone_id = #{geographic_zone_id} " +
            "where id = #{id}")
    void update(GeographicZoneStock geographicZoneStock);

    @Select("select * from geographic_zone_stocks where id = #{id}")
    GeographicZoneStock getById(@Param("id") Long id);
}
