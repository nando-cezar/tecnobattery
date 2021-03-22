package com.tecnobattery.tbsystem.repositories;

import com.tecnobattery.tbsystem.entities.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
