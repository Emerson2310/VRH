package com.vrh.RH.infrastructure.entitys;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.net.PasswordAuthentication;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "usuario")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

//    private PasswordAuthentication senha;
}
