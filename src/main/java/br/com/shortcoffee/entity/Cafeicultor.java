package br.com.shortcoffee.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "cafeicultor")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cafeicultor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "cafeicultor_id", columnDefinition = "int")
    private long cafeicultorId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;
}
