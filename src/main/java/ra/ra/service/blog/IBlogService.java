package ra.ra.service.blog;

import jdk.nashorn.internal.ir.Block;
import ra.ra.model.Blog;
import ra.ra.service.IGenericService;

public interface IBlogService extends IGenericService<Blog,Long> {
    Iterable<Blog> findByName(String blogName);
}
