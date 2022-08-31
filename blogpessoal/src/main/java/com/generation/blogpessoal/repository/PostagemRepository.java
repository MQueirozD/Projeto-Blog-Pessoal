package com.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.generation.blogpessoal.model.Postagem;

@Repository
/*JPA>Biblioteca de métodos e instruções que descreve como deve ser o comportamento dos frameworks.*/
//JPA - é que vai ligar entre o banco de dados e o back_end
public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	
	//seria no mysql = SELECT *FROM tb_postagem WHERE titulo LIKE "%%";
	//ajuda a procurar o que vc quer
	//public List <Postagem> findAllByTituloContainingIgnoreCase(String titulo);
	
	public List <Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo")String titulo);

}
// findAllByTituloContainingIgnoreCase