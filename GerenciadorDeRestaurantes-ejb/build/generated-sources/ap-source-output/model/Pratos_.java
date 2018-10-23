package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Conta;
import model.Ingredientes;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-22T19:02:03")
@StaticMetamodel(Pratos.class)
public class Pratos_ { 

    public static volatile CollectionAttribute<Pratos, Conta> contaCollection;
    public static volatile SingularAttribute<Pratos, Integer> nrop;
    public static volatile SingularAttribute<Pratos, Long> valor;
    public static volatile SingularAttribute<Pratos, String> tipos;
    public static volatile SingularAttribute<Pratos, Ingredientes> nroi;

}