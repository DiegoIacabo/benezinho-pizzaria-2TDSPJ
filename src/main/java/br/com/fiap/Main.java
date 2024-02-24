package br.com.fiap;

import br.com.fiap.domain.entity.Opcional;
import br.com.fiap.domain.entity.Pizzaria;
import br.com.fiap.domain.entity.Produto;
import br.com.fiap.domain.entity.Sabor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.LinkedHashSet;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("fiap");
        EntityManager manager = factory.createEntityManager();

        salvar(manager);

        Pizzaria pizzaria = manager.find(Pizzaria.class, 1);

        System.out.println(pizzaria);

        manager.close();
        factory.close();
    }

    private static void salvar(EntityManager manager) {

        Sabor frangoComCatupiry = Sabor.builder().nome("Frango com Catupiry").descricao("Deliciosa pizza de frango com o autentico Catupiri").build();

        Sabor caipira = Sabor.builder().nome("Caipira").descricao("Um sabor meio chato").build();

        var opcionais = new LinkedHashSet<Opcional>();

        var bordaDeCatupiry = Opcional.builder()
                .nome("Borda de Catupiry")
                .preco(9.99)
                .build();

        var cocaCola = Opcional.builder()
                .nome("Coca-Cola 2L")
                .preco(13.90)
                .build();

        var tortaDeLimao = Opcional.builder()
                .nome("Torta de Limão")
                .preco(19.99)
                .build();

        opcionais.add(bordaDeCatupiry);
        opcionais.add(cocaCola);
        opcionais.add(tortaDeLimao);

        var pizzaFrangoCatu = Produto.builder()
                .nome("Pizza de Frango com Catupiry")
                .preco(BigDecimal.valueOf(59.99))
                .sabor(frangoComCatupiry)
                .opcionais(opcionais)
                .build();

        var pizzaCaipira = Produto.builder()
                .nome("Pizza Caipira")
                .preco(BigDecimal.valueOf(59.99))
                .sabor(caipira)
                .opcionais(opcionais)
                .build();

        var cardapio = new LinkedHashSet<Produto>();

        cardapio.add(pizzaFrangoCatu);
        cardapio.add(pizzaCaipira);

        Pizzaria dominus = Pizzaria.builder().nome("Dominus").cardapio(cardapio).build();

        manager.getTransaction().begin();
        manager.persist(dominus);
        manager.getTransaction().commit();

    }

}
