package Models.POJOs;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pais.class)
public abstract class Pais_ {

	public static volatile SingularAttribute<Pais, Integer> idPais;
	public static volatile SingularAttribute<Pais, String> nombre;
	public static volatile SetAttribute<Pais, ?> periodoIndependecias;
	public static volatile SetAttribute<Pais, ?> unionBandoses;

	public static final String ID_PAIS = "idPais";
	public static final String NOMBRE = "nombre";
	public static final String PERIODO_INDEPENDECIAS = "periodoIndependecias";
	public static final String UNION_BANDOSES = "unionBandoses";

}

