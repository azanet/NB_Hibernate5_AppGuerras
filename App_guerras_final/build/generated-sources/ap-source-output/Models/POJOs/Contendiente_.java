package Models.POJOs;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Contendiente.class)
public abstract class Contendiente_ {

	public static volatile SingularAttribute<Contendiente, Guerra> guerra;
	public static volatile SingularAttribute<Contendiente, Integer> ganador;
	public static volatile SingularAttribute<Contendiente, Integer> idContendiente;
	public static volatile SingularAttribute<Contendiente, String> nombre;
	public static volatile SetAttribute<Contendiente, ?> unionBandoses;

	public static final String GUERRA = "guerra";
	public static final String GANADOR = "ganador";
	public static final String ID_CONTENDIENTE = "idContendiente";
	public static final String NOMBRE = "nombre";
	public static final String UNION_BANDOSES = "unionBandoses";

}

