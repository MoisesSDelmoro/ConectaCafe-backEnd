package br.com.shortcoffee.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "login")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Login {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "login_id", columnDefinition = "int")
    private long loginId;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;
}
