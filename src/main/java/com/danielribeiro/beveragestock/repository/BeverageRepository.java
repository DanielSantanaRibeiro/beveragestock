package com.danielribeiro.beveragestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielribeiro.beveragestock.domain.Beverage;

public interface BeverageRepository extends JpaRepository<Beverage, Integer>{

}
