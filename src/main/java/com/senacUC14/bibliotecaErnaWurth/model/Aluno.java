
package com.senacUC14.bibliotecaErnaWurth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    public Integer id;
    @NotBlank(message = "Campo Nome do usuário é obrigatório")
    public String nomeUsuario;
    @NotBlank(message = "Campo Sexo é obrigatório")
    public String sexo;
    public Date dataNascimento;
    @Email(message = "Campo E-mail inválido")
    public String email;
    public int matriculaEscolar;
    public String serie;

          
}
