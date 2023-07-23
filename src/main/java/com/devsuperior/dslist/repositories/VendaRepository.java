package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.Venda;
import com.devsuperior.dslist.projections.VendaIDProjection;
import com.devsuperior.dslist.projections.VendaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    @Query(nativeQuery = true, value = """
                    SELECT\s
                    tb_belonging_venda.venda_id as venda,\s
                    tb_produto.id,\s
                    tb_produto.nome,\s
                    tb_produto.valor,\s
                    tb_belonging_venda.quantidade,
                    (tb_produto.valor * tb_belonging_venda.quantidade) as total
                                                  
                    FROM tb_produto
                    INNER JOIN tb_belonging_venda ON tb_produto.id = tb_belonging_venda.produto_id
                                                  			
            """)
    List<VendaProjection> searchByList();

    @Query(nativeQuery = true, value = """
                   SELECT ID
                   FROM TB_VENDA
                   ORDER BY ID DESC LIMIT 1;
                                                  			
            """)
    VendaIDProjection insertVendaID();

    @Modifying
    @Query(nativeQuery = true, value = """
                   INSERT INTO TB_BELONGING_VENDA
                   VALUES (:quantidade,:produtoID,:vendaID)\s
                                                  			
            """)
    void insertBelongVenda(Integer quantidade, Long produtoID, Long vendaID);

    @Modifying
    @Query(nativeQuery = true, value = """
                   INSERT INTO TB_PRODUTO_VENDAS
                   VALUES (:produtoID,:vendaID)\s
                                                  			
            """)
    void insertProdutoVenda(Long produtoID, Long vendaID);

    @Modifying
    @Query(nativeQuery = true, value = """
                   INSERT INTO TB_VENDA () VALUES ();
                                                  			
            """)
    void insertTBVenda();

    @Modifying
    @Query(nativeQuery = true, value = """
                   DELETE FROM TB_BELONGING_VENDA
                   WHERE VENDA_ID = :vendaID                      			
            """)
    void deleteBelongVenda(Long vendaID);

    @Modifying
    @Query(nativeQuery = true, value = """
                   DELETE FROM TB_PRODUTO_VENDAS
                   WHERE VENDA_ID = :vendaID                     			
            """)
    void deleteProdutoVenda(Long vendaID);

    @Modifying
    @Query(nativeQuery = true, value = """
                   DELETE FROM TB_VENDA
                   WHERE ID = :vendaID                     			
            """)
    void deleteVenda(Long vendaID);

}
