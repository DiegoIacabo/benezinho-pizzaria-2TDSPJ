package br.com.fiap;

import br.com.fiap.domain.entity.Opcional;
import br.com.fiap.domain.entity.Pizzaria;
import br.com.fiap.domain.entity.Produto;
import br.com.fiap.domain.entity.Sabor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "fiap" );
        EntityManager manager = factory.createEntityManager();

        salvar(manager);

        Opcional borda = new Opcional(null, "Borda de Catupiry", 19.99);

        Opcional cocaCola = Opcional.builder().id(null).nome("Coca-Cola").preco(19.99).build();

        manager.getTransaction().begin();
        manager.persist(borda);
        manager.persist(cocaCola);
        manager.getTransaction().commit();


        Pizzaria pizzaria = manager.find( Pizzaria.class, 1 );


        JOptionPane.showMessageDialog( null, pizzaria );

        manager.close();
        factory.close();

    }

    private static void salvar(EntityManager manager) {
        Pizzaria dominus = new Pizzaria();
        dominus.setId( null ).setNome( "Dominus" );

        Sabor frangoComCatupiri = new Sabor( null, "Frango com Catupiri", "Deliciosa pizza de frango com o autentico Catupiri" );

        Sabor caipira = new Sabor( null, "Caipira", "Deliciosa caipira com milho macio" );

        var pizzaDeFrangoCatu = new Produto( null, "Pizza", BigDecimal.valueOf( 59.98 ), frangoComCatupiri );


        manager.getTransaction().begin();
        manager.persist( frangoComCatupiri );
        manager.persist( caipira );   //sql INSERT INTO
        manager.persist( dominus );
        manager.persist( pizzaDeFrangoCatu );
        manager.getTransaction().commit();
    }
}