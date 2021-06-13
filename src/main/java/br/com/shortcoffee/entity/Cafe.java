package br.com.shortcoffee.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "cafe")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cafe {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "cafe_id", columnDefinition = "int")
    private long cafeId;

    @Column(name = "especie")
    private String especie;

    @Column(name = "variedade")
    private String variedade;

    @Column(name = "aroma")
    private String aroma;

    @Column(name = "sabor")
    private String sabor;

    @Column(name = "acidez")
    private String acidez;

    @Column(name = "inseticidas")
    private String inseticidas;

    @Column(name = "fetilizantes")
    private String fetilizantes;

    @Column(name = "altitude")
    private String altitude;

    @Column(name = "especial")
    private boolean especial;
}
