/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator1;

import iterator1.safeCollections.Iterator;

import visitor.optionLambda.IOption;
import visitor.optionLambda.None;
import visitor.optionLambda.Some;

  public class OptionAdapter<T> implements Iterator<T>
  {
    private IOption<T> option;
    private boolean visited = false;
    public OptionAdapter(IOption<T> option)
    {
      this.option = option;
    }
    
   public IOption<T> getNext()
    {
      if (visited)
        return new None<T>();
      else
      {
        visited = true;
//        return option.visit<IOption<T>>(() -> new None<T>(), t -> new Some<T>(t));
        return option.visit(() -> new None<T>(), t -> new Some<T>(t));
      }
    }
  }