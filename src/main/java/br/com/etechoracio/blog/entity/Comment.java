package br.com.etechoracio.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TBL_COMENTARIO")

public class Comment {

    @Id
    @Column(name = "ID_COMENTARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComment;

    @Column(name = "TX_CONTEUDO")
    private String conteudo;

    @Column(name = "TX_AUTOR")
    private String autor;

    @Column(name = "DT_CRIACAO")
    private LocalDateTime dataCriacao;

}
