package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Bebidas;
import model.Pratos;
import model.Vendas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-22T19:02:03")
@StaticMetamodel(Conta.class)
public class Conta_ { 

    public static volatile SingularAttribute<Conta, Bebidas> nrob;
    public static volatile SingularAttribute<Conta, Pratos> nrop;
    public static volatile SingularAttribute<Conta, Long> valor;
    public static volatile SingularAttribute<Conta, Integer> nroc;
    public static volatile CollectionAttribute<Conta, Vendas> vendasCollection;

}