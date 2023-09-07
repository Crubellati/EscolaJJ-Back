package com.r2csistemas.escolajj.controller;

import com.r2csistemas.escolajj.dto.ProfissionalDto;
import com.r2csistemas.escolajj.orm.Profissional;
import com.r2csistemas.escolajj.repository.ProfissionalRepository;
import com.r2csistemas.escolajj.service.ProfissionalService;
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
@RequestMapping("/profissional")
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private ProfissionalService profissionalService;

    @GetMapping("/listAll")
    public ResponseEntity listAll() {
        List<ProfissionalDto> collect = profissionalRepository
                .findAll()
                .stream()
                .map(ProfissionalDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(collect); //retorno 200 -> específico para OK com corpo
    }

    @GetMapping("/buscar")
    public ResponseEntity buscarPorNome(@RequestParam(required = false) String q) {
        List<ProfissionalDto> collect = profissionalRepository
                .findByProNomeContainsOrderByProCodigoDesc(nullToEmpty(q))
                .stream()
                .map(ProfissionalDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(collect); //retorno 200 -> específico para OK com corpo
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid ProfissionalDto dados,
                                    UriComponentsBuilder uriBuilder) {
        var novoProfissionalSalvo = profissionalRepository.save(new Profissional(dados.nome()));
        var uri = uriBuilder.path("/profissional/{id}")
                .buildAndExpand(novoProfissionalSalvo.getProCodigo()).toUri();
        return ResponseEntity.created(uri)
                .body(new ProfissionalDto(novoProfissionalSalvo));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid ProfissionalDto dados) {
        Optional<Profissional> optionalProfissional = profissionalRepository.findById(dados.codigo());
        if (optionalProfissional.isPresent()) {
            profissionalService.atualizarDados(optionalProfissional.get(), dados);
        }
        return ResponseEntity.ok(dados);
    }

    //deletando recebendo id por URL
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Integer id) {
        profissionalRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Integer id) {
        Optional<Profissional> optionalProfissional = profissionalRepository.findById(id);
        if (optionalProfissional.isPresent()) {
            return ResponseEntity.ok(new ProfissionalDto(optionalProfissional.get()));
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
