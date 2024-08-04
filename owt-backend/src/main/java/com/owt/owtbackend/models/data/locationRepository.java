package com.owt.owtbackend.models.data;

import com.owt.owtbackend.models.location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface locationRepository extends CrudRepository<location, Integer>{
}