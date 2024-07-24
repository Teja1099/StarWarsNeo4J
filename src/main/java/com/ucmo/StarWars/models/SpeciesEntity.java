package com.ucmo.StarWars.models;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Species")
public class SpeciesEntity {

    @Id
    private final String name;
    private final String classification;
    private final String designation;
    private final int averageHeight;
    private final String skinColors;
    private final String hairColors;
    private final String eyeColors;
    private final int averageLifespan;
    private final String language;
    private final String homeworld;

    public SpeciesEntity(String name, String classification, String designation, int averageHeight, String skinColors, String hairColors, String eyeColors, int averageLifespan, String language, String homeworld) {
        this.name = name;
        this.classification = classification;
        this.designation = designation;
        this.averageHeight = averageHeight;
        this.skinColors = skinColors;
        this.hairColors = hairColors;
        this.eyeColors = eyeColors;
        this.averageLifespan = averageLifespan;
        this.language = language;
        this.homeworld = homeworld;
    }

    // Getters omitted for brevity

    public String getName() {
        return name;
    }

    public String getClassification() {
        return classification;
    }

    public String getDesignation() {
        return designation;
    }

    public int getAverageHeight() {
        return averageHeight;
    }

    public String getSkinColors() {
        return skinColors;
    }

    public String getHairColors() {
        return hairColors;
    }

    public String getEyeColors() {
        return eyeColors;
    }

    public int getAverageLifespan() {
        return averageLifespan;
    }

    public String getLanguage() {
        return language;
    }

    public String getHomeworld() {
        return homeworld;
    }
}
