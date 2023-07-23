package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	/* @Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);*/

    /*
    @Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.garantias gar WHERE "
            + "(COALESCE(:garantias) IS NULL OR gar IN :garantias) AND "
            + "(LOWER(obj.name) LIKE LOWER(CONCAT('%',:nome,'%')) )")
    List<Produto> find(List<Garantia> garantias, String nome);
    */

    Produto findByNome(String nome);
}
