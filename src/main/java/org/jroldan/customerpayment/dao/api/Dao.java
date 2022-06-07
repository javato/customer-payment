package org.jroldan.customerpayment.dao.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface Dao<T, ID>  extends CrudRepository<T, ID> {

}
