package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Conta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-22T19:02:03")
@StaticMetamodel(Bebidas.class)
public class Bebidas_ { 

    public static volatile CollectionAttribute<Bebidas, Conta> contaCollection;
    public static volatile SingularAttribute<Bebidas, Integer> nrob;
    public static volatile SingularAttribute<Bebidas, Long> valor;
    public static volatile SingularAttribute<Bebidas, String> nome;

}