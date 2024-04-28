package com.ada.economizaapi.services;

import com.ada.economizaapi.entities.Produto;
import com.ada.economizaapi.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Iterable<Produto> findAll() throws Exception {
        try {
            return produtoRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Erro ao buscar todos os produtos", e);
        }
    }

    public Produto findById(Long id) throws Exception {
        try {
            Optional<Produto> produto = produtoRepository.findById(id);
            if (produto.isPresent()) {
                return produto.get();
            } else {
                throw new Exception("Produto não encontrado");
            }
        } catch (Exception e) {
            throw new Exception("Erro ao buscar o produto", e);
        }
    }

    public Produto save(Produto produto) throws Exception {
        try {
            return produtoRepository.save(produto);
        } catch (Exception e) {
            throw new Exception("Erro ao salvar o produto", e);
        }
    }

    public Produto update(Long id, Produto produto) throws Exception {
        try {
            Optional<Produto> produtoExistente = produtoRepository.findById(id);
            if (produtoExistente.isPresent()) {
                produto.setId(id);
                return produtoRepository.save(produto);
            } else {
                throw new Exception("Produto não encontrado");
            }
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar o produto", e);
        }
    }

    public void deleteById(Long id) throws Exception {
        try {
            produtoRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Erro ao deletar o produto", e);
        }
    }
}
