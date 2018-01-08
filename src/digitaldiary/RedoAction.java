/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitaldiary;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.undo.CannotRedoException;

/**
 *
 * @author aks
 */
public class RedoAction extends AbstractAction{
    public RedoAction()
  {
    super("Redo");
    setEnabled(false);
  }

  public void actionPerformed(ActionEvent e)
  {
    try
    {
      NoteMaker.undoManager.redo();
    }
    catch (CannotRedoException ex)
    {
      
      ex.printStackTrace();
    }
    update();
    NoteMaker.undoAction.update();
  }

  protected void update()
  {
    if (NoteMaker.undoManager.canRedo())
    {
      setEnabled(true);
      putValue(Action.NAME, NoteMaker.undoManager.getRedoPresentationName());
    }
    else
    {
      setEnabled(false);
      putValue(Action.NAME, "Redo");
    }
  }
}
