package ra.ra.service.blog;

import jdk.nashorn.internal.ir.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.ra.dao.IBlogDao;
import ra.ra.model.Blog;

import java.util.Optional;
@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogDao blogDao;
    @Override
    public Iterable<Blog> findAll() {
        return blogDao.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogDao.findById(id);
    }

    @Override
    public Blog save(Blog block) {
        return blogDao.save(block);
    }

    @Override
    public void delete(Long id) {
        blogDao.deleteById(id);
    }

    @Override
    public Iterable<Blog> findByName(String blogName) {
        return blogDao.findByName(blogName);
    }
}
