package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;
/*
 * Com isso terei o componente que faz consulta com o banco 
 * inserir, atualizar, deletar etc
 * */
public interface GameRepository extends JpaRepository<Game, Long>{

}
