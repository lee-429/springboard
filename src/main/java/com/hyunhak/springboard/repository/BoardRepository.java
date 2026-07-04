package com.hyunhak.springboard.repository;

import com.hyunhak.springboard.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// BoardEntity를 관리하고, 기본 키 타입은 Long
// save(), findAll(), findById() 등의 메서드를 자동 제공
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {}
