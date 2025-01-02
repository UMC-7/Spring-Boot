package UMC._th.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHome is a Querydsl query type for Home
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHome extends EntityPathBase<Home> {

    private static final long serialVersionUID = 1337926507L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHome home = new QHome("home");

    public final UMC._th.domain.common.QBaseEntity _super = new UMC._th.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final UMC._th.domain.QMember member;

    public final UMC._th.domain.QMission mission;

    public final EnumPath<UMC._th.domain.enums.MissionStatus> status = createEnum("status", UMC._th.domain.enums.MissionStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QHome(String variable) {
        this(Home.class, forVariable(variable), INITS);
    }

    public QHome(Path<? extends Home> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHome(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHome(PathMetadata metadata, PathInits inits) {
        this(Home.class, metadata, inits);
    }

    public QHome(Class<? extends Home> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new UMC._th.domain.QMember(forProperty("member")) : null;
        this.mission = inits.isInitialized("mission") ? new UMC._th.domain.QMission(forProperty("mission"), inits.get("mission")) : null;
    }

}

