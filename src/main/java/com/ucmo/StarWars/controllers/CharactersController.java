package com.ucmo.StarWars.controllers;

import com.ucmo.StarWars.dto.CharactersDTO;
import com.ucmo.StarWars.models.CharactersEntity;
import com.ucmo.StarWars.repositories.CharactersRepository;
import com.ucmo.StarWars.services.CharactersService;
import com.ucmo.StarWars.utils.CharactersMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/chars")
public class CharactersController {
    private final CharactersService charactersService;

    public CharactersController(CharactersService charactersService) {
        this.charactersService = charactersService;
    }

    @PostMapping("/")
    public ResponseEntity<CharactersDTO> addCharacter(@RequestBody CharactersDTO charactersDTO) {
        CharactersDTO newCharacter = charactersService.addCharacter(charactersDTO);
        return ResponseEntity.ok(newCharacter);
    }

    @PutMapping("/{name}")
    public ResponseEntity<CharactersDTO> updateCharacter(@PathVariable String name, @RequestBody CharactersDTO updatedCharacterDTO) throws Exception {
        Optional<CharactersDTO> updatedCharactersDTO = charactersService.updateCharacter(name, updatedCharacterDTO);
        return ResponseEntity.ok(updatedCharactersDTO.orElse(null));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable String name) {
        charactersService.deleteCharacter(name);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<CharactersDTO>> charactersIndex() {
        List<CharactersEntity> entities = charactersService.getAllCharacters();
        List<CharactersDTO> dtos = entities.stream()
                .map(CharactersMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CharactersDTO> getCharacterByName(@PathVariable String name) {
        Optional<CharactersDTO> dto = charactersService.getCharacterByName(name)
                .map(CharactersMapper::toDTO);
        return ResponseEntity.ok(dto.orElse(null));
    }




}