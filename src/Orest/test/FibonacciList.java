package Orest.test;

import java.util.Iterator;

/**
 * @author OrestO
 * @since 7/28/2015
 */
public class FibonacciList<E extends Number> implements Iterable<E>
{
  private Node<E> first = null;
  private Node<E> last = null;
  private int m = 2;
  private int size = 0;
  private long result;

  public FibonacciList()
  {
    init();
  }

  public FibonacciList(int m)
  {
    this.m = m;
    init();
  }

  private void init()
  {
    for (int i = 0; i < m; i++)
    {
      add((E) Long.valueOf(1));
    }
  }

  public void add(E element)
  {
    final Node<E> prev = last;
    final Node<E> newNode = new Node<>(prev, element, null);
    last = newNode;
    if (prev == null)
    {
      first = newNode;
    }
    else
    {
      prev.next = newNode;
    }

    if (size == m)
    {
      result -= first.item.longValue();
      first = first.next;
    }
    result += element.longValue();

    size += size < m ? 1 : 0;
  }

  public long getSum()
  {
    if (size < m)
    {
      return 1;
    }
    return result;
  }

  @Override
  public Iterator<E> iterator()
  {
    return new Iterator<E>()
    {
      Node<E> cursor = first;

      @Override
      public boolean hasNext()
      {
        return cursor.next != null;
      }

      @Override
      public E next()
      {
        cursor = cursor.next;
        return cursor.item;
      }
    };
  }

  private static class Node<E>
  {
    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next)
    {
      this.item = element;
      this.next = next;
      this.prev = prev;
    }
  }
}
