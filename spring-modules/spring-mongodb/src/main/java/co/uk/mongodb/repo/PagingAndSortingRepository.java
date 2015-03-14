package co.uk.mongodb.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Interface PagingAndSortingRepository.
 * @author PAULO
 *
 * @param <T>
 * @param <ID>
 */
public interface PagingAndSortingRepository<T, ID> extends CrudRepository<T, ID> {
	Page<T> findAll(Pageable pageable);
	Iterable<T> findAll(Sort sort);
}	
