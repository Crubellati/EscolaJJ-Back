package com.r2csistemas.escolajj.controller;

import com.r2csistemas.escolajj.dto.AlunoDtoForm;
import com.r2csistemas.escolajj.orm.Aluno;
import com.r2csistemas.escolajj.repository.AlunoRepository;
import com.r2csistemas.escolajj.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/paginacao")
    public ResponseEntity page(Pageable pageable) {
        var page = alunoRepository.findAll(pageable).map(AlunoDtoForm::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/listAll")
    public ResponseEntity listAll() {
        List<AlunoDtoForm> collect = alunoRepository
                .findAll()
                .stream()
                .map(AlunoDtoForm::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(collect); //retorno 200 -> específico para OK com corpo
    }

    @GetMapping("/buscar")
    public ResponseEntity buscarPorNome(@RequestParam(required = false) String q) {
        List<AlunoDtoForm> collect = alunoRepository
                .findByAlunoNomeContainsOrderByAlunoCodigoDesc(nullToEmpty(q))
                .stream()
                .map(AlunoDtoForm::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(collect); //retorno 200 -> específico para OK com corpo
    }


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid AlunoDtoForm dados,
                                    UriComponentsBuilder uriBuilder) {
        var novoAlunoSalvo = alunoRepository.save(new Aluno(dados));

        var uri = uriBuilder.path("/aluno/{id}").buildAndExpand(novoAlunoSalvo.getAlunoCodigo()).toUri();
        return ResponseEntity.created(uri)
                .body(new AlunoDtoForm(novoAlunoSalvo));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AlunoDtoForm dados) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(dados.codigo());
        if (alunoOptional.isPresent()) {
            alunoService.atualizarDados(alunoOptional.get(), dados);
        }
        return ResponseEntity.ok(dados);
    }

    //deletando recebendo id por URL
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Integer id) {
        alunoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Integer id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            return ResponseEntity.ok(new AlunoDtoForm(alunoOptional.get()));
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
