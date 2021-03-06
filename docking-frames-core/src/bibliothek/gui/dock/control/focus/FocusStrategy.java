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
package bibliothek.gui.dock.control.focus;

import java.awt.Component;

import bibliothek.gui.DockController;
import bibliothek.gui.Dockable;

/**
 * A {@link FocusStrategy} is used by a {@link DockController} to decide which {@link Component} to focus if
 * a {@link Dockable} should receive the focus.
 * @author Benjamin Sigg
 */
public interface FocusStrategy {
	
	/**
	 * Informs this strategy that it will be used from now on.
	 */
	public void bind();
	
	/**
	 * Informs this strategy that it is no longer used from now on.
	 */
	public void unbind();
	
	/**
	 * Given a {@link Dockable} this method tells which {@link Component} should be focused.
	 * @param dockable some dockable which is about to get the focus
	 * @param mouseClicked the component which was touched by the mouse and which would get the focus normally. Can be <code>null</code>.
	 * @return the component to focus or <code>null</code>.
	 * <ul>
	 * 	<li><code>null</code> indicates that this strategy cannot decide what to do. In this case a default component will receive the focus.</li>
	 *  <li><code>mouseClicked</code> forces focus onto <code>mouseClicked</code>, even if that <code>Component</code> is not focusable.</li>
	 *  <li>any other <code>Component</code> will receive focus if focusable, or focus will be transfered to the next focusable <code>Component</code>
	 *  starting the search at the returned value.</li>
	 * </ul> 
	 */
	public Component getFocusComponent( Dockable dockable, Component mouseClicked );
}
