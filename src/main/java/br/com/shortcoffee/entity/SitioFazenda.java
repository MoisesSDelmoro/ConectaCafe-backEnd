package br.com.shortcoffee.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
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
    @Column(name = "sitio_fazenda_id", columnDefinition = "int")
    private long sitioFazendaId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "rua")
    private String rua;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "cep")
    private String cep;

    @Column(name = "sobreHistoria")
    private String sobreHistoria;

    @Column(name = "fotosVideos")
    private String fotosVideos;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "redesSociais")
    private String redesSociais;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_id", nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Cafe cafe;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafeicutor_id", nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Cafeicultor cafeicultor;
}
