package com.hyunhak.springboard.service;

import com.hyunhak.springboard.dto.BoardCreateDto;
import com.hyunhak.springboard.dto.BoardResponseDto;
import com.hyunhak.springboard.dto.BoardUpdateDto;
import com.hyunhak.springboard.entity.BoardEntity;
import com.hyunhak.springboard.repository.BoardRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 비즈니스 로직 계층이라는 걸 Spring에 알려줌 (Service 역할)
public class BoardService {

    // 생성자 주입 후 변경할 수 없도록 final 적용
    private final BoardRepository boardRepository;

    @Autowired // Spring이 자동으로 해당 타입의 객체(Bean)를 찾아서 주입해주는 기능
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 게시글 저장
    public BoardEntity save(BoardCreateDto dto) {

        // DTO를 BoardEntity 객체로 변환
        BoardEntity board = new BoardEntity();

        // DTO의 데이터를 BoardEntity에 복사
        board.setTitle(dto.getTitle());
        board.setContent(dto.getContent());
        board.setWriter(dto.getWriter());

        // Repository에 저장
        return boardRepository.save(board);
    }

    // 전체 게시글 조회
    public List<BoardResponseDto> findAll() {

        // Repository에서 전체 게시글(Entity) 조회
        List<BoardEntity> boards = boardRepository.findAll();

        // 화면에 전달할 DTO 목록
        List<BoardResponseDto> responseDtos = new ArrayList<>();

        // BoardEntity -> BoardResponseDto 변환
        for (BoardEntity board : boards) {
            BoardResponseDto dto = new BoardResponseDto();

            dto.setId(board.getId());
            dto.setTitle(board.getTitle());
            dto.setContent(board.getContent());
            dto.setWriter(board.getWriter());

            responseDtos.add(dto);
        }

        // DTO 목록 반환
        return responseDtos;
    }

    // 게시글 단건 조회
    public BoardResponseDto findById(Long id) {

        // Repository에서 게시글 조회
        Optional<BoardEntity> board = boardRepository.findById(id);

        // Optional에서 BoardEntity 꺼내기
        BoardEntity entity = board.orElseThrow(() -> new RuntimeException("게시글 없음"));

        // BoardEntity -> BoardResponseDto 변환
        BoardResponseDto dto = new BoardResponseDto();

        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setWriter(entity.getWriter());

        return dto;
    }

    // 게시글 수정
    public BoardEntity update(Long id, BoardUpdateDto dto) {

        // id로 기존 게시글 조회 (없으면 예외 발생)
        Optional<BoardEntity> board = boardRepository.findById(id);

        // Optional에서 실제 엔티티 꺼내기 (없으면 "게시글 없음" 예외 발생)
        BoardEntity entity = board.orElseThrow(() -> new RuntimeException("게시글 없음"));

        // DTO 값을 기존 엔티티에 덮어쓰기 (수정)
        entity.setTitle(dto.getTitle());
        entity.setWriter(dto.getWriter());
        entity.setContent(dto.getContent());

        // 변경된 엔티티 저장 (JPA에서는 save가 update 역할도 함)
        return boardRepository.save(entity);
    }

    // 게시글 삭제
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

}
