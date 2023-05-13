package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.GameList;
/*
 * Com isso terei o componente que faz consulta com o banco 
 * inserir, atualizar, deletar etc
 * */
public interface GameListRepository extends JpaRepository<GameList, Long>{

}