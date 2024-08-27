//Anderson Armando e Isabella Amaro 3AI

package br.com.etechoracio.blog.controller;

import br.com.etechoracio.blog.entity.Comment;
import br.com.etechoracio.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentRepository repositoryComment;

    @GetMapping
    public List<Comment> listarComment(){
        return repositoryComment.findAll();
    }

    @GetMapping("/{idComment}")
    public ResponseEntity<Object> buscarComment(@PathVariable Long idComment){
        var resp = repositoryComment.findById(idComment);

        if(resp.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(resp.get());
        }
    }

    @PostMapping
    public ResponseEntity<Comment> inserirComment(@RequestBody Comment comment){
        repositoryComment.save(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(repositoryComment.save(comment));
    }

    @PutMapping("/{idComment}")
    public ResponseEntity<Comment> atualizarComment(@PathVariable long idComment, @RequestBody Comment comment){
        var tem = repositoryComment.findById(idComment);

        if(!tem.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(repositoryComment.save(comment));
    }

    @DeleteMapping("/{idComment}")
    public ResponseEntity<Comment> deletarComment(@PathVariable Long idComment){
        var deletar = repositoryComment.findById(idComment);

        if (deletar.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        repositoryComment.deleteById(idComment);

        return ResponseEntity.noContent().build();
    }
}
