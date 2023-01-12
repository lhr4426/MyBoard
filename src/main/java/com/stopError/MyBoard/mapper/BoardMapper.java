package com.stopError.MyBoard.mapper;

import com.stopError.MyBoard.domain.Board;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BoardMapper {

    int boardCount(); // 게시물 개수
    List<Board> getList(); // 게시물 list 반환

    Board getBoard(Long id); // 특정 id를 가진 Board 반환

    void uploadBoard(Board board);

    @Transactional
    void updateBoard(Board board);

    @Transactional
    void deleteBoard(Long id);

    void viewCount(Long id);
}
