package UMC._th.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFoodPrefer is a Querydsl query type for FoodPrefer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodPrefer extends EntityPathBase<FoodPrefer> {

    private static final long serialVersionUID = 764507258L;

    public static final QFoodPrefer foodPrefer = new QFoodPrefer("foodPrefer");

    public final StringPath category = createString("category");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QFoodPrefer(String variable) {
        super(FoodPrefer.class, forVariable(variable));
    }

    public QFoodPrefer(Path<? extends FoodPrefer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFoodPrefer(PathMetadata metadata) {
        super(FoodPrefer.class, metadata);
    }

}

