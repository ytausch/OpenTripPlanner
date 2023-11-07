package org.opentripplanner.ext.emissions;

import org.opentripplanner.standalone.config.framework.json.NodeAdapter;

/**
 * This class is responsible for mapping emissions configuration into emissions parameters.
 */
public class EmissionsConfig {

  private int carAvgCo2PerKm;
  private double carAvgOccupancy;

  public EmissionsConfig(String parameterName, NodeAdapter root) {
    var c = root
      .of(parameterName)
      .summary("Emissions configuration.")
      .description(
        """
        By specifying the average CO₂ emissions of a car in grams per kilometer as well as
        the average number of passengers in a car the program is able to to perform emission
        calculations for car travel.
        """
      )
      .asObject();

    this.carAvgCo2PerKm =
      c
        .of("carAvgCo2PerKm")
        .summary("The average CO₂ emissions of a car in grams per kilometer.")
        .asInt(170);

    this.carAvgOccupancy =
      c.of("carAvgOccupancy").summary("The average number of passengers in a car.").asDouble(1.3);
  }

  public int getCarAvgCo2PerKm() {
    return carAvgCo2PerKm;
  }

  public double getCarAvgOccupancy() {
    return carAvgOccupancy;
  }
}
