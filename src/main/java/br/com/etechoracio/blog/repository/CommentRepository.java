package br.com.etechoracio.blog.repository;

import br.com.etechoracio.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
