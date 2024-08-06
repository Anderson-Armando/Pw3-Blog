package br.com.etechoracio.blog.controller;

import br.com.etechoracio.blog.repository.PostRepository;
import br.com.etechoracio.blog.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository repository;

    @GetMapping
    public List<Post> listarPosts(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Post> buscarPorId(@PathVariable Long id){
        return repository.findById(id);
    }
}
