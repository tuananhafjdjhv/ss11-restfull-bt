package ra.ra.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.ra.model.Category;

@Repository
public interface ICategoryDao extends PagingAndSortingRepository<Category,Long> {
}
