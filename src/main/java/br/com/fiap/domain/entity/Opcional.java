package br.com.fiap.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "TB_OPCIONAL")
@Data //possibilita a criação automática dos getters and setters, toString e construtor vazio
@AllArgsConstructor //cria automaticamente o construtor com os atributos, mas dessa forma sobreescreve o construtor vazio
@NoArgsConstructor //cria o construtor vazio
@Builder
public class Opcional {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_OPCIONAL")
    @SequenceGenerator(
            name = "SQ_OPCIONAL", sequenceName = "SQ_OPCIONAL"
    )
    @Column(name = "ID_OPCIONAL")
    private Long id;

    @Column(name = "NM_OPCIONAL")
    private String nome;

    @Column(name = "PRECO")
    private Double preco;

}
