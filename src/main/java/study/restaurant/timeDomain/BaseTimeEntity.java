package study.restaurant.timeDomain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    //생성일시
    @Column(name = "created_date", updatable = false) // @CreatedDate로도 바로 할 수 있음
    private LocalDateTime createdDate;

    //최종 수정일시
    @Column(name = "modified_date") // @LastModifiedDate로도 바로 할 수 있음
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

    @CreatedBy // 등록자
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedBy // 수정자
    private String modifiedBy;
    // 마지막에 업데이트한 유저를 확인할 수 있으므로 유지보수 관점에서 편리.
    // 이렇게 하지 않으면 변경 컬럼이 null일 때 등록 컬럼을 또 찾아야 한다.

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

/**
 * 실무에서 대부분의 엔티티는 등록시간,수정시간이 필요하지만 등록자,수정자는 없을 수도 있다.
 * 그래서 상위 클래스에 시간에 관한 정보를 넣고 따로 BaseEntity 클래스를 생성해서 등록자,수정자를 처리하는 방법도 있다.
 */

}
