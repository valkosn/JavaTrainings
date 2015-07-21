package fibonacci;

import menu.Menu;
import menu.impl.MenuOnInterfaceImpl;

import java.io.IOException;

/**
 * @author OrestO
 * @since 7/21/2015
 */
public class Runner
{
  public static void main(String[] args) throws IOException
  {
    Menu menu = new MenuOnInterfaceImpl();
    menu.build();
  }
}
