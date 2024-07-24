package com.ucmo.StarWars.services;

import com.ucmo.StarWars.dto.CharactersDTO;
import com.ucmo.StarWars.models.CharactersEntity;
import com.ucmo.StarWars.repositories.CharactersRepository;
import com.ucmo.StarWars.utils.CharactersMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharactersService {
    private final CharactersRepository charactersRepository;

    public CharactersService(CharactersRepository charactersRepository) {
        this.charactersRepository = charactersRepository;
    }

    public List<CharactersEntity> getAllCharacters() {
        return charactersRepository.findAll();
    }

    public Optional<CharactersEntity> getCharacterByName(String name) {
        return charactersRepository.findById(name);
    }

    public CharactersDTO addCharacter(CharactersDTO charactersDTO) {
        CharactersEntity charactersEntity = CharactersMapper.toEntity(charactersDTO);
        CharactersEntity savedCharactersEntity = charactersRepository.save(charactersEntity);
        return CharactersMapper.toDTO(savedCharactersEntity);
    }

    public void deleteCharacter(String name) {
        Optional<CharactersEntity> existingCharactersEntity = charactersRepository.findById(name);
        charactersRepository.deleteById(name);
    }

    public Optional<CharactersDTO> updateCharacter(String name, CharactersDTO updatedCharacterDTO) throws Exception {
        Optional<CharactersEntity> existingCharactersEntity = charactersRepository.findById(name);
        if (existingCharactersEntity.isEmpty()) throw new Exception("User not found");

        CharactersEntity updatedCharactersEntity = CharactersMapper.toEntity(updatedCharacterDTO);
        updatedCharactersEntity.setName(name);
        charactersRepository.save(updatedCharactersEntity);

        CharactersDTO charactersDTO = CharactersMapper.toDTO(updatedCharactersEntity);
        return Optional.of(charactersDTO);
    }
}
