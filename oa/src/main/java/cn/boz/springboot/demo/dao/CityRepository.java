package cn.boz.springboot.demo.dao;

import cn.boz.springboot.demo.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

public interface CityRepository extends Repository<City, Long> {

    Page<City> findAll(Pageable pageable);

    City findByNameAllIgnoringCase(String name);

}
