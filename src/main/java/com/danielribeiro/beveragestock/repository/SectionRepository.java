package com.danielribeiro.beveragestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danielribeiro.beveragestock.domain.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Integer>{

}
