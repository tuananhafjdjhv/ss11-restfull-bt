package ra.ra.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.ra.model.Blog;
import ra.ra.service.blog.IBlogService;

import java.util.List;
import java.util.Optional;


@RequestMapping("/api/blog")
@RestController
@CrossOrigin(origins = "*")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> findAll() {
        List<Blog> list = (List<Blog>) blogService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<Blog> create(@RequestBody Blog blog){
        Blog b = blogService.save(blog);
        return  new ResponseEntity<>(b,HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> update(@PathVariable("id") Long id,@RequestBody Blog blog){
        Optional<Blog> blogOptional = blogService.findById(id);
        if (blogOptional.isPresent()){
            blog.setId(id);
            blogService.save(blog);
            return new ResponseEntity<>( blog,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") Long  id){
        Optional<Blog> blogOptional = blogService.findById(id);
        if (blogOptional.isPresent()){
            blogService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Blog> findById(@PathVariable("id")Long id){
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogOptional.get(),HttpStatus.OK);

    }

    @GetMapping("/findByNameBlog/{blogName}")
    public ResponseEntity<List<Blog>> findByNameBlog(@PathVariable("blogName") String blogName){
        List<Blog> list = (List<Blog>) blogService.findByName(blogName);
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
