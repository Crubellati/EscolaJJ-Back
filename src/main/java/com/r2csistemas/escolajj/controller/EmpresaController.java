package com.r2csistemas.escolajj.controller;

import com.r2csistemas.escolajj.dto.EmpresaDto;
import com.r2csistemas.escolajj.orm.Escola;
import com.r2csistemas.escolajj.repository.EmpresaRepository;
import com.r2csistemas.escolajj.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/listAll")
    public ResponseEntity listAll() {
        List<EmpresaDto> collect = empresaRepository
                .findAll()
                .stream()
                .map(EmpresaDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(collect); //retorno 200 -> específico para OK com corpo
    }

    @GetMapping("/buscar")
    public ResponseEntity buscarPorNome(@RequestParam(required = false) String q) {
        List<EmpresaDto> collect = empresaRepository
                .findByEscolaNomeContainsOrderByEscolaCodigoDesc(nullToEmpty(q))
                .stream()
                .map(EmpresaDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(collect); //retorno 200 -> específico para OK com corpo
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid EmpresaDto dados,
                                    UriComponentsBuilder uriBuilder) {
        var novaEmpresaSalvo = empresaRepository.save(new Escola(dados));
        var uri = uriBuilder.path("/empresa/{id}").buildAndExpand(novaEmpresaSalvo.getEscolaCodigo()).toUri();
        return ResponseEntity.created(uri)
                .body(new EmpresaDto(novaEmpresaSalvo));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid EmpresaDto dados) {
        Optional<Escola> empresaOptional = empresaRepository.findById(dados.codigo());
        if (empresaOptional.isPresent()) {
            empresaService.atualizarDados(empresaOptional.get(), dados);
        }
        return ResponseEntity.ok(dados);
    }

    //deletando recebendo id por URL
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Integer id) {
        empresaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Integer id) {
        Optional<Escola> escolaOptional = empresaRepository.findById(id);
        if (escolaOptional.isPresent()) {
            return ResponseEntity.ok(new EmpresaDto(escolaOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    private String nullToEmpty(String q) {
        if (q == null) {
            return "";
        } else {
            return q;
        }
    }
}
