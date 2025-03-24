package com.goodjunseon.Board.repository;

import com.goodjunseon.Board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    // update board_table set board_hits=board_hits+1 where id=?
    @Modifying
    @Transactional
    @Query(value = "update BoardEntity b set b.boardHits=b.boardHits+1 where b.id=:id") //JPA에서 제공하는 @어노테이션
    void updateHits(@Param("id") Long id);
//    @Modifying
//    @Query(value = "update board_table set board_hits = board_hits + 1 where id = :id", nativeQuery = true)
//    void updateHits(@Param("id") Long id);

}
