package Models.POJOs;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UnionBandos.class)
public abstract class UnionBandos_ {

	public static volatile SingularAttribute<UnionBandos, String> fechaUnion;
	public static volatile SingularAttribute<UnionBandos, String> fechaAbandono;
	public static volatile SingularAttribute<UnionBandos, Integer> idUnionBandos;
	public static volatile SingularAttribute<UnionBandos, Contendiente> contendiente;
	public static volatile SingularAttribute<UnionBandos, Pais> pais;

	public static final String FECHA_UNION = "fechaUnion";
	public static final String FECHA_ABANDONO = "fechaAbandono";
	public static final String ID_UNION_BANDOS = "idUnionBandos";
	public static final String CONTENDIENTE = "contendiente";
	public static final String PAIS = "pais";

}

