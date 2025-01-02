package UMC._th.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 807840006L;

    public static final QMember member = new QMember("member1");

    public final UMC._th.domain.common.QBaseEntity _super = new UMC._th.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final EnumPath<UMC._th.domain.enums.Agreement> agreement = createEnum("agreement", UMC._th.domain.enums.Agreement.class);

    public final StringPath birth = createString("birth");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<UMC._th.domain.enums.Gender> gender = createEnum("gender", UMC._th.domain.enums.Gender.class);

    public final ListPath<UMC._th.domain.mapping.Home, UMC._th.domain.mapping.QHome> homes = this.<UMC._th.domain.mapping.Home, UMC._th.domain.mapping.QHome>createList("homes", UMC._th.domain.mapping.Home.class, UMC._th.domain.mapping.QHome.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<UMC._th.domain.mapping.MemberPrefer, UMC._th.domain.mapping.QMemberPrefer> prefers = this.<UMC._th.domain.mapping.MemberPrefer, UMC._th.domain.mapping.QMemberPrefer>createList("prefers", UMC._th.domain.mapping.MemberPrefer.class, UMC._th.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final ListPath<Review, QReview> reviews = this.<Review, QReview>createList("reviews", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<UMC._th.domain.enums.MemberStatus> status = createEnum("status", UMC._th.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

