package ra.ra.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.ra.model.Blog;

@Repository
public interface IBlogDao  extends PagingAndSortingRepository<Blog,Long> {
    @Query("SELECT s from Blog as s where  s.blogName like concat('%',:blogName,'%') ")
    Iterable<Blog> findByName(@Param("blogName") String blogName);
}
