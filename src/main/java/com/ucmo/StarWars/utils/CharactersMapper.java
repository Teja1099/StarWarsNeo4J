package com.ucmo.StarWars.utils;

import com.ucmo.StarWars.dto.CharactersDTO;
import com.ucmo.StarWars.models.CharactersEntity;

public class CharactersMapper {

    public static CharactersDTO toDTO(CharactersEntity entity) {
        return new CharactersDTO(
                entity.getName(),
                entity.getHeight(),
                entity.getMass(),
                entity.getHair_color(),
                entity.getSkin_color(),
                entity.getSkin_color(),
                entity.getBirth_year(),
                entity.getGender(),
                entity.getHomeworld(),
                entity.getSpecies()
        );
    }

    public static CharactersEntity toEntity(CharactersDTO dto) {
        return new CharactersEntity(
                dto.getName(),
                dto.getHeight(),
                dto.getMass(),
                dto.getHairColor(),
                dto.getSkinColor(),
                dto.getEyeColor(),
                dto.getBirthYear(),
                dto.getGender(),
                dto.getHomeworld(),
                dto.getSpecies()
        );
    }
}
