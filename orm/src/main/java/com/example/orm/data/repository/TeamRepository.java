package com.example.orm.data.repository;

import com.example.orm.data.entity.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
}
