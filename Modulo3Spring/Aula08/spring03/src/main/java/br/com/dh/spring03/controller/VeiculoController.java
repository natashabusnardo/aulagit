package br.com.dh.spring03.controller;

import br.com.dh.spring03.exception.VeiculoNotFoundException;
import br.com.dh.spring03.model.Veiculo;
import br.com.dh.spring03.service.IVeiculo;
import br.com.dh.spring03.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired //Injeção de dependencia (o framework gera o objeto)
    private IVeiculo service;

    @GetMapping("/{placa}")
    public ResponseEntity<Veiculo> getVeiculo(@PathVariable String placa){
        try{
            Veiculo veiculo = service.getVeiculo(placa);
            return new ResponseEntity<>(veiculo, HttpStatus.OK);
        }catch (VeiculoNotFoundException e) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
