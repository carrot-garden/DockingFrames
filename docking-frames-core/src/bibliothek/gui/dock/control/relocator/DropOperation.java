/*
 * Bibliothek - DockingFrames
 * Library built on Java/Swing, allows the user to "drag and drop"
 * panels containing any Swing-Component the developer likes to add.
 * 
 * Copyright (C) 2010 Benjamin Sigg
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
package bibliothek.gui.dock.control.relocator;

import bibliothek.gui.DockController;
import bibliothek.gui.DockStation;
import bibliothek.gui.Dockable;
import bibliothek.gui.dock.station.StationDropOperation;

/**
 * This operation calls {@link StationDropOperation#execute()}
 * @author Benjamin Sigg
 *
 */
public class DropOperation implements RelocateOperation{
	private DockController controller;
	private DockStation station;
	private StationDropOperation operation;
	
	/**
	 * Creates a new operation
	 * @param controller the controller in whose realm this operation works
	 * @param station the target of this operation
	 * @param operation the operation that would be executed by <code>station</code>
	 */
	public DropOperation( DockController controller, DockStation station, StationDropOperation operation ){
		this.controller = controller;
		this.station = station;
		this.operation = operation;
	}
	
	public DockStation getStation(){
		return station;
	}
	
	public StationDropOperation getOperation(){
		return operation;
	}
	
	public Dockable[] getImplicit( Dockable selection ){
		return new Dockable[]{};
	}
	
	public void destroy(){
		operation.destroy();
	}
	
	public boolean execute( Dockable selection, VetoableDockRelocatorListener listener ){
		try{
			if( operation.isMove() ){
				DefaultDockRelocatorEvent event = new DefaultDockRelocatorEvent( controller, selection, new Dockable[]{}, station );
				listener.dragging( event );
				if( event.isCanceled() || event.isForbidden() ){
					return false;
				}
				operation.execute();
				listener.dragged( new DefaultDockRelocatorEvent( controller, selection, new Dockable[]{}, station ) );
			}
			else{
				DockStation parent = selection.getDockParent();
				if( parent != null ){
					DefaultDockRelocatorEvent event = new DefaultDockRelocatorEvent( controller, selection, new Dockable[]{}, station );
					listener.dragging( event );
					if( event.isCanceled() || event.isForbidden() ){
						return false;
					}
					parent.drag( selection );
					listener.dragged( new DefaultDockRelocatorEvent( controller, selection, new Dockable[]{}, station ) );
				}
				operation.execute();
			}
		}
		finally{
			operation.destroy();
		}
		return true;	
	}
}
