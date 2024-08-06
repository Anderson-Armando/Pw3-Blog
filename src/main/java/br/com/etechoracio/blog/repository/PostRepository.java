package br.com.etechoracio.blog.repository;

import br.com.etechoracio.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
