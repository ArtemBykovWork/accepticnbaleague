package org.acceptic.nba.repository;

import org.acceptic.nba.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, String>{
}
