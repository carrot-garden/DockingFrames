/*
 * Bibliothek - DockingFrames
 * Library built on Java/Swing, allows the user to "drag and drop"
 * panels containing any Swing-Component the developer likes to add.
 * 
 * Copyright (C) 2007 Benjamin Sigg
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 * Benjamin Sigg
 * benjamin_sigg@gmx.ch
 * CH - Switzerland
 */
package bibliothek.gui.dock.facile.action;

import javax.swing.Icon;

import bibliothek.gui.dock.action.actions.SimpleDropDownAction;
import bibliothek.gui.dock.facile.intern.FDecorateableAction;
import bibliothek.gui.dock.facile.intern.action.FSeparator;

/**
 * A dropdown-button, the last action which was selected by the user will be
 * marked graphically.
 * @author Benjamin Sigg
 */
public class FDropDownButton extends FDecorateableAction{
    /** the internal representation */
    private SimpleDropDownAction menu;
    
    /**
     * Creates a new dropdown-button
     */
    public FDropDownButton(){
        super( new SimpleDropDownAction() );
        menu = (SimpleDropDownAction)intern();
    }
    
    /**
     * Creates a new dropdown-button
     * @param text the text of this button
     * @param icon the icon of this button
     */
    public FDropDownButton( String text, Icon icon ){
        this();
        setText( text );
        setIcon( icon );
    }
    
    /**
     * Adds an action to this menu.
     * @param action the new action
     */
    public void add( FAction action ){
        menu.add( action.intern() );
    }

    /**
     * Adds an action to the menu.
     * @param index the location of the action
     * @param action the new action
     */
    public void insert( int index, FAction action ){
        menu.insert( index, action.intern() );
    }
    
    /**
     * Adds a separator at the end of this menu.
     */
    public void addSeparator(){
        add( FSeparator.SEPARATOR );
    }
    
    /**
     * Adds a separator. 
     * @param index the location of the new separator
     */
    public void insertSeparator( int index ){
        insert( index, FSeparator.SEPARATOR );
    }
    
    /**
     * Removes the action at location <code>index</code>.
     * @param index the location of the element to remove
     */
    public void remove( int index ){
        menu.remove( index );
    }
    
    /**
     * Removes an action from this menu
     * @param action the action to remove
     */
    public void remove( FAction action ){
        menu.remove( action.intern() );
    }
}
