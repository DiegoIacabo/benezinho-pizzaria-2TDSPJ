package br.com.fiap.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TB_PRODUTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTO")
    @SequenceGenerator(
            name = "SQ_PRODUTO",
            sequenceName = "SQ_PRODUTO",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name="ID_PRODUTO")
    private Long id;

    @Column(name="NM_PRODUTO")
    private String nome;

    @Column(name="VL_PRODUTO")
    private BigDecimal preco;

    //Ao fazer as relações na classe 'Produto', estamos dizendo que a informação sobre o 'Sabor' e os 'Opcionais' de um produto específico é parte integrante da informação sobre o próprio 'Produto'.
    //Em outras palavras, estamos descrevendo as características do Produto que estão relacionadas ao 'Sabor' e aos 'Opcionais'.

    //Por ser uma relação muitos para um, o relacionamento se dá apenas por adicionar uma chave estrangeira para referênciar a outra entidade
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            //O nome da coluna na tabela "Produto" que servirá de chave estrangeira
            name = "SABOR_ID",
            //O nome da coluna na tabela "Sabor" que está sendo referenciada
            referencedColumnName = "ID_SABOR",
            //O nome da chave estrangeira criada
            foreignKey = @ForeignKey(name = "FK_SABOR_PRODUTO")
    )
    private Sabor sabor;

    //É necessário criar uma nova tabela para fazer a relação de muitos para muitos entre as tabelas "Produto" e "Opcional"
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            //Nome da nova tabela que está sendo criada
            name = "TB_OPCIONAL_PRODUTO",
            //Determina qual coluna representará a entidade "Produto" na nova tabela
            joinColumns = {
                    @JoinColumn(
                            //Nome da coluna que servirá de chave estrangeira na nova tabela para referenciar a chave primária da entidade "Produto"
                            name = "PRODUTO",
                            referencedColumnName = "ID_PRODUTO",
                            foreignKey = @ForeignKey(name = "FK_PRODUTO_OPCIONAL")
                    )
            },
            //Determina qual coluna representará a entidade "Opcional" na nova tabela
            inverseJoinColumns = {
                    @JoinColumn(
                            //Nome da coluna que servirá de chave estrangeira na nova tabela para referenciar a chave primária da entidade "Opcional"
                            name = "OPCIONAL",
                            referencedColumnName = "ID_OPCIONAL",
                            foreignKey = @ForeignKey(name = "FK_OPCIONAL_PRODUTO")
                    )
            }
    )
    //Está definindo um atributo opcionais que representa um conjunto (Set) de objetos do tipo "Opcional".
    private Set<Opcional> opcionais = new LinkedHashSet<>();

}
