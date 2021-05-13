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
    @Column(name = "id", columnDefinition = "int")
    private long id;

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
}
