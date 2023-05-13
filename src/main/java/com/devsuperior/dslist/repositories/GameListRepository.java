package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.GameList;
/*
 * Com isso terei o componente que faz consulta com o banco 
 * inserir, atualizar, deletar etc
 * */
public interface GameListRepository extends JpaRepository<GameList, Long>{
	
	/*
	 * O modifying deve ser colocado quando diferente de SELECT
	 * neste caso usamos o UPDATE*/
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
