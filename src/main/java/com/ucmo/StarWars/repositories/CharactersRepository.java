package com.ucmo.StarWars.repositories;

import com.ucmo.StarWars.models.CharactersEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;


public interface CharactersRepository extends Neo4jRepository<CharactersEntity, String> {
}