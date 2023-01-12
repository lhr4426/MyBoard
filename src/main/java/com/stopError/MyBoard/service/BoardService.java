package com.stopError.MyBoard.service;

import com.stopError.MyBoard.domain.Board;
import com.stopError.MyBoard.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    private final BoardMapper boardMapper;

    public int boardCount() {
        return boardMapper.boardCount();
    }

    public List<Board> boardList() {
        return boardMapper.getList();
    }

    public Board getBoard(Long id){
        return boardMapper.getBoard(id);
    }

    public void uploadBoard(Board board){
        boardMapper.uploadBoard(board);
    }

    public void updateBoard(Board board){
        boardMapper.updateBoard(board);
    }

    public void deleteBoard(Long id){
        boardMapper.deleteBoard(id);
    }

    public void viewCount(Long id){
        boardMapper.viewCount(id);
    }
}
