package study.restaurant.timeDomain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    //생성일시
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    //최종 수정일시
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now(); // 현재 날짜와 시간 반환
        createdDate = now;
        modifiedDate = now;
    }

    @PreUpdate
    public void preUpdate() { // 엔티티가 db에서 엡데이트될 때마다 최신 시간으로 갱신
        modifiedDate = LocalDateTime.now();
    }

    /**
     * @MappedSuperClass : BaseTimeEntity가 Jpa 엔티티의 공통 매핑 정보를 포함하는 클래스
     * -> BaseTimeEntity에 선언된 필드들은 어떠한 엔티티에서든 상속하여 사용,(코드 중복 방지, 매핑정보 재사용)
     *
     *@EntityListeners(AuditingEntityListener.class)
     * :엔티티 클래스에 적용되는 어노테이션으로, 해당 엔티티의 변경 사항을 자동으로 감지하고 특정 필드를 업데이트하는 데 사용
     *  주로 데이터 생성 및 수정 시각을 자동으로 관리하는 데 사용
     *
     * 자동 시간 기록: 엔티티가 생성되거나 수정될 때 자동으로 생성 시각(createdDate)과 수정 시각(lastModifiedDate)을 기록합니다.
     * 감사 정보 저장: 누가 엔티티를 생성했는지, 수정했는지와 같은 감사 정보를 자동으로 저장할 수 있습니다.
     *
     * @PrePersist
     * : 엔티티가 처음 저장될 때, 생성일과 최종 수정일을 현재 시간으로 설정한다.
     *
     * @PreUpdate
     * : 엔티티가 업데이트될 때, 최종 수정일을 현재 시간으로 설정한다.
     *
     *
     */

}
