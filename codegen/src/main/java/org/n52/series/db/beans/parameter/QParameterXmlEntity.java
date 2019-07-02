package org.n52.series.db.beans.parameter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QParameterXmlEntity is a Querydsl query type for ParameterXmlEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParameterXmlEntity extends EntityPathBase<ParameterXmlEntity> {

    private static final long serialVersionUID = -943434873L;

    public static final QParameterXmlEntity parameterXmlEntity = new QParameterXmlEntity("parameterXmlEntity");

    public final QParameterEntity _super = new QParameterEntity(this);

    //inherited
    public final StringPath domain = _super.domain;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.util.Date> lastUpdate = _super.lastUpdate;

    //inherited
    public final StringPath name = _super.name;

    public final SimplePath<Object> value = createSimple("value", Object.class);

    public QParameterXmlEntity(String variable) {
        super(ParameterXmlEntity.class, forVariable(variable));
    }

    public QParameterXmlEntity(Path<? extends ParameterXmlEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParameterXmlEntity(PathMetadata metadata) {
        super(ParameterXmlEntity.class, metadata);
    }

}
