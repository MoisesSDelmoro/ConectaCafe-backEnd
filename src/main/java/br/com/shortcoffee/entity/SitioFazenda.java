package br.com.shortcoffee.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "sitioFazenda")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SitioFazenda {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "rua")
    private String rua;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "sobreHistoria")
    private String sobreHistoria;

    @Column(name = "altitude")
    private String altitude;

    @Column(name = "fotosVideos")
    private String fotosVideos;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "redesSociais")
    private String redesSociais;
}
