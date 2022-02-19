package jss.api.wse.repository;

import jss.api.wse.model.SKU;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SKURepository extends CrudRepository<SKU, UUID> {
}
