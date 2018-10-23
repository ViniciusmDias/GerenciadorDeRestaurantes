package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Pratos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-22T19:02:03")
@StaticMetamodel(Ingredientes.class)
public class Ingredientes_ { 

    public static volatile SingularAttribute<Ingredientes, Long> peso;
    public static volatile SingularAttribute<Ingredientes, Long> valor;
    public static volatile SingularAttribute<Ingredientes, String> nome;
    public static volatile SingularAttribute<Ingredientes, Integer> nroi;
    public static volatile CollectionAttribute<Ingredientes, Pratos> pratosCollection;

}