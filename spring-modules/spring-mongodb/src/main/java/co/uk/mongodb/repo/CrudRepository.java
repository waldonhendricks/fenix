package co.uk.mongodb.repo;

/**
 * Interface CrudRepository.
 * @author PAULO
 *
 * @param <T>
 * @param <ID>
 */
public interface CrudRepository<T, ID> extends Repository<T, ID>{
	public <S extends T> T save(S entity);
	public <S extends T> Iterable<S> save(Iterable<S> entities);
	
	public T findOne(ID id);
	public Iterable<T> findAll();
	
	public void delete(ID id);
	public void delete(Iterable<? extends T> entities);
	public void deleteAll();
	
	public long count();
	public boolean exists(ID id);
}
