package demo.mssql.db;

import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository  extends CrudRepository<Animal, Integer> {
}
