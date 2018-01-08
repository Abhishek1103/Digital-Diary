/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitaldiary;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.undo.CannotUndoException;

/**
 *
 * @author aks
 */
public class UndoAction extends AbstractAction{
    
    public UndoAction()
  {
    super("Undo");
    setEnabled(false);
  }

  public void actionPerformed(ActionEvent e)
  {
    try
    {
      NoteMaker.undoManager.undo();
    }
    catch (CannotUndoException ex)
    {
      
    }
    update();
    NoteMaker.redoAction.update();
  }

  protected void update()
  {
    if (NoteMaker.undoManager.canUndo())
    {
      setEnabled(true);
      putValue(Action.NAME, NoteMaker.undoManager.getUndoPresentationName());
    }
    else
    {
      setEnabled(false);
      putValue(Action.NAME, "Undo");
    }
  }
}
