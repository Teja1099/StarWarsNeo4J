package com.ucmo.StarWars.models;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Planets")
public class PlanetsEntity {

    @Id
    private final String name;
    private final int rotationPeriod;
    private final int orbitalPeriod;
    private final int diameter;
    private final String climate;
    private final String gravity;
    private final String terrain;
    private final int surfaceWater;
    private final long population;

    public PlanetsEntity(String name, int rotationPeriod, int orbitalPeriod, int diameter, String climate, String gravity, String terrain, int surfaceWater, long population) {
        this.name = name;
        this.rotationPeriod = rotationPeriod;
        this.orbitalPeriod = orbitalPeriod;
        this.diameter = diameter;
        this.climate = climate;
        this.gravity = gravity;
        this.terrain = terrain;
        this.surfaceWater = surfaceWater;
        this.population = population;
    }

    // Getters omitted for brevity

    public String getName() {
        return name;
    }

    public int getRotationPeriod() {
        return rotationPeriod;
    }

    public int getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public int getDiameter() {
        return diameter;
    }

    public String getClimate() {
        return climate;
    }

    public String getGravity() {
        return gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public int getSurfaceWater() {
        return surfaceWater;
    }

    public long getPopulation() {
        return population;
    }
}
