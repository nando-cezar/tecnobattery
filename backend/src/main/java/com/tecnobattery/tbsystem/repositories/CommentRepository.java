package com.tecnobattery.tbsystem.repositories;

import com.tecnobattery.tbsystem.entities.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
