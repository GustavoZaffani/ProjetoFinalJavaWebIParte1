package br.com.utfpr.projeto.projetofinaladministrativo.controller;

import br.com.utfpr.projeto.projetofinaladministrativo.model.Cidade;
import br.com.utfpr.projeto.projetofinaladministrativo.model.Estado;
import br.com.utfpr.projeto.projetofinaladministrativo.model.Fornecedor;
import br.com.utfpr.projeto.projetofinaladministrativo.model.Produto;
import br.com.utfpr.projeto.projetofinaladministrativo.service.CidadeService;
import br.com.utfpr.projeto.projetofinaladministrativo.service.EstadoService;
import br.com.utfpr.projeto.projetofinaladministrativo.service.FornecedorService;
import br.com.utfpr.projeto.projetofinaladministrativo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilController {

    @Autowired
    private EstadoService estadoService;
    @Autowired
    private CidadeService cidadeService;
    @Autowired
    private FornecedorService fornecedorService;
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("fornecedor/estado/complete")
    public List<Estado> completeEstado(@RequestParam("texto") String texto) {
        return estadoService.complete(texto);
    }

    @GetMapping("fornecedor/cidade/complete/{idEstado}")
    public List<Cidade> completeCidade(@PathVariable("idEstado") Long idEstado,
                                 @RequestParam("texto") String texto) {
        return cidadeService.complete(texto, idEstado);
    }

    @GetMapping("fornecedor/estado/{id}")
    public Estado findEstadoById(@PathVariable("id") Long idEstado) {
        return estadoService.findOne(idEstado);
    }

    @GetMapping("fornecedor/cidade/{id}")
    public Cidade findCidadeById(@PathVariable("id") Long idCidade) {
        return cidadeService.findOne(idCidade);
    }

    @GetMapping("compra/fornecedor/complete")
    public List<Fornecedor> completeFornecedor(@RequestParam("texto") String fornecedor) {
        return fornecedorService.complete(fornecedor);
    }

    @GetMapping("compra/produto/complete")
    public List<Produto> completeProduto(@RequestParam("texto") String nomeProduto) {
        return produtoService.complete(nomeProduto);
    }

}
