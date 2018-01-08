/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitaldiary;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

/**
 *
 * @author aks
 */
public class UndoHandler implements UndoableEditListener {
    public void undoableEditHappened(UndoableEditEvent e)
  {
    NoteMaker.undoManager.addEdit(e.getEdit());
    NoteMaker.undoAction.update();
    NoteMaker.redoAction.update();
  }
}
