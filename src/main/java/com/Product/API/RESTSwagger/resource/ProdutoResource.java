package com.Product.API.RESTSwagger.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Product.API.RESTSwagger.models.ProdutoModel;
import com.Product.API.RESTSwagger.repositories.ProdutoRepository;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value="/api")
public class ProdutoResource {
	@Autowired
	private ProdutoRepository produtoRepository;

	// Vamos criar nossos métodos

	
	@Operation(summary = "Listar", description ="Método que retorna todos os produtos", tags = "Produtos_API" )
	@GetMapping(value = "/produtos")
	private List<ProdutoModel> listaProduto() {
		return produtoRepository.findAll();
	}

	
	@Operation(summary = "Listar Uúnico", description ="Método que retorna único produto", tags = "Produtos_API" )
	@GetMapping(value = "/produtos/{id}")
	private ProdutoModel produtoUnico(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);

	}

	
	@Operation(summary = "Created", description ="Método que cria produto", tags = "Produtos_API" )
	@PostMapping(value = "/produtos")
	public ProdutoModel salvarProduto(@RequestBody ProdutoModel produtoModel) {
		return produtoRepository.save(produtoModel);
	}

	@Operation(summary = "Deletar", description ="Método que deleta produto", tags = "Produtos_API" )
	@DeleteMapping(value = "/produtos")
	public void deletaProduto(@RequestBody ProdutoModel produtoModelo) {
		produtoRepository.delete(produtoModelo);

	}
	
	
	@Operation(summary = "Update", description ="Método que atualiza produto", tags = "Produtos_API" )
	@PutMapping(value = "/produtos")
	public ProdutoModel updateProduto(@RequestBody ProdutoModel produtoModel){
		return produtoRepository.save(produtoModel);
	}
}
