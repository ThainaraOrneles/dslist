package com.devsuperior.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
/*
 * Com isso terei o componente que faz consulta no banco 
 * inserir, atualizar, deletar etc
 * */
public interface GameRepository extends JpaRepository<Game, Long>{
	
	/*
	 *O nativeQuery = true é uma condição necessaria para fazer a consulta SQL
	 *porém o resultado da consulta terá que ser uma interface, aqui no spring chamado de 'projection'
	 * */
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);
}
