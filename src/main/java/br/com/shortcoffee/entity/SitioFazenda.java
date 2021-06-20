package br.com.shortcoffee.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

import java.util.List;

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

    @Column(name = "sobreHistoria", columnDefinition = "TEXT")
    private String sobreHistoria;

    @Column(name = "fotosVideos", columnDefinition = "TEXT")
    private String fotosVideos;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "Facebook")
    private String facebook;

    @Column(name = "Instagram")
    private String instagram;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafeicutor_id", nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Cafeicultor cafeicultor;
}
