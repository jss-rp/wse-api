package jss.api.wse.repository;

import jss.api.wse.model.Trend;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrendRepository extends ReactiveCrudRepository<Trend, String> {
}
