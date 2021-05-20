package Models.POJOs;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Guerra.class)
public abstract class Guerra_ {

	public static volatile SingularAttribute<Guerra, String> anioInicio;
	public static volatile SingularAttribute<Guerra, String> anioFin;
	public static volatile SingularAttribute<Guerra, Integer> idGuerra;
	public static volatile SetAttribute<Guerra, ?> contendientes;
	public static volatile SingularAttribute<Guerra, String> nombre;

	public static final String ANIO_INICIO = "anioInicio";
	public static final String ANIO_FIN = "anioFin";
	public static final String ID_GUERRA = "idGuerra";
	public static final String CONTENDIENTES = "contendientes";
	public static final String NOMBRE = "nombre";

}

