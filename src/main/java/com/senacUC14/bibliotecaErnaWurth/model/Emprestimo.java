
package com.senacUC14.bibliotecaErnaWurth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Emprestimo")
public class Emprestimo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private int id;

    @ManyToOne
    private Livro livro;

    @ManyToOne
    private Aluno aluno;

    private LocalDate retornoEmprestimo;

    private String livroDevolvido = "NÃO";
    
    
}
