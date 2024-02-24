package br.com.fiap.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_SABOR")
<<<<<<< HEAD
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
=======
>>>>>>> f30eb1f4ac0921c0f07a69ecf449e469d0918915
public class Sabor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SABOR")
    @SequenceGenerator(name = "SQ_SABOR", sequenceName = "SQ_SABOR", initialValue = 1, allocationSize = 1)
<<<<<<< HEAD
    @Column(name="ID_SABOR")
    private Long id;

    @Column(name="NM_SABOR")
    private String nome;

    @Column(name="DS_SABOR")
=======
    @Column(name = "ID_SABOR")
    private Long id;

    @Column(name = "NM_SABOR")
    private String nome;

    @Column(name = "DS_SABOR")
>>>>>>> f30eb1f4ac0921c0f07a69ecf449e469d0918915
    private String descricao;

}
