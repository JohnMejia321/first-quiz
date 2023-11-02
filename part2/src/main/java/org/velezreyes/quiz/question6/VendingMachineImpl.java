package org.velezreyes.quiz.question6;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineImpl implements VendingMachine {
  private static VendingMachineImpl instance;
  private Map<String, Drink> drinks = new HashMap<>();
  private int currentMoney = 0;

  private VendingMachineImpl() {
    // Create and stock the vending machine with drinks.
    drinks.put("ScottCola", new DrinkImpl("ScottCola", true));
    drinks.put("KarenTea", new DrinkImpl("KarenTea", false));
  }

  public static VendingMachine getInstance() {
    if (instance == null) {
      instance = new VendingMachineImpl();
    }
    return instance;
  }

  @Override
  public void insertQuarter() {
    currentMoney += 25;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    Drink drink = drinks.get(name);

    if (drink == null) {
      throw new UnknownDrinkException();
    }

    if (currentMoney < 75) {
      throw new NotEnoughMoneyException();
    }

    currentMoney -= 75;
    return drink;
  }
}

