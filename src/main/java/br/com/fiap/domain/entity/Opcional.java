package br.com.fiap.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //indicando que essa classe deve ser mapeada como uma tabela no banco de dados
@Table(name="TB_OPCIONAL") //usada para especificar o nome da tabela no banco de dados
@Data //gera automaticamente os métodos getters e setters, toString(), equals() e hashCode() para todos os atributos da classe
@AllArgsConstructor //cria automaticamente o construtor com os atributos como argumentos, mas dessa forma sobreescreve o construtor vazio
@NoArgsConstructor //cria o construtor vazio
@Builder //possibilita criar uma instância da classe de maneira mais fluente e legível usando o padrão de método Builder
public class Opcional {

    @Id //usada para marcar o atributo como a chave primária da tabela no banco de dados
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SQ_OPCIONAL") //usada para definir o gerador de sequência dos valores da chave primária e o nome desse gerador
    @SequenceGenerator(name="SQ_OPCIONAL", sequenceName = "SQ_OPCIONAL")
    @Column(name="NM_OPCIONAL")
    private Long id;

    @Column(name="NM_OPCIONAL")
    private String nome;

    @Column(name="VL_OPCIONAL")
    private Double preco;

}
