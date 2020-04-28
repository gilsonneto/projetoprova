package com.gigi.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gigi.prova.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
