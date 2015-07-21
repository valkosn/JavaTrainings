package menu.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import menu.AbstractMenu;
import fibonacci.Fibonacci;

/**
 * @author OrestO
 * @since 7/21/2015
 */
public class MenuOnInterfaceImpl extends AbstractMenu
{

  @Override
  public void build()
  {
    try
    {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      List<Class<? extends Fibonacci>> availableImplementations = getAvailableImplementations(Fibonacci.class);
      System.out.println(getMenuPrompt(availableImplementations.stream().map(Class::getSimpleName).collect(Collectors.toList())));

      while (true)
      {
        System.out.print("What implementation you want to use? - ");
        int rawChoice = Integer.parseInt(reader.readLine());
        if (rawChoice == 0)
        {
          return;
        }

        Class<? extends Fibonacci> choice = availableImplementations.get(rawChoice - 1);
        Fibonacci chosenImpl = choice.newInstance();

        int n = getN(reader);
        long lBegin = System.nanoTime();
        long result = chosenImpl.calculate(n);

        System.out.printf("Result: %25s; %25s elapsed time %20s ns\n", result, choice.getSimpleName(), System.nanoTime() - lBegin);
      }
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }
}
