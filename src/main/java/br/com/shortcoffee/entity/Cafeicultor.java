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
    @Column(name = "id", columnDefinition = "int")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;
}
