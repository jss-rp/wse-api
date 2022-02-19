package jss.api.wse.repository;

import jss.api.wse.model.Trend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrendRepository extends CrudRepository<Trend, String> {
}
