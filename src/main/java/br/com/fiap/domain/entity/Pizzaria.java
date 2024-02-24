package br.com.fiap.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TB_PIZZARIA")
<<<<<<< HEAD
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
=======
>>>>>>> f30eb1f4ac0921c0f07a69ecf449e469d0918915
public class Pizzaria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PIZZARIA")
    @SequenceGenerator(name = "SQ_PIZZARIA")
<<<<<<< HEAD
    @Column(name="ID_PIZZARIA")
    private Long id;

    @Column(name="NM_PIZZARIA")
=======
    @Column(name = "ID_PIZZARIA")
    private Long id;

    @Column(name = "NM_PIZZARIA")
>>>>>>> f30eb1f4ac0921c0f07a69ecf449e469d0918915
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_CARDAPIO",
            joinColumns = {
                    @JoinColumn(
                            name = "PIZZARIA",
                            referencedColumnName = "ID_PIZZARIA",
                            foreignKey = @ForeignKey(name = "FK_PIZZARIA_PRODUTO")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "PRODUTO",
                            referencedColumnName = "ID_PRODUTO",
                            foreignKey = @ForeignKey(name = "FK_PRODUTO_PIZZARIA")
                    )
            }
    )
    private Set<Produto> cardapio = new LinkedHashSet<>();

}
