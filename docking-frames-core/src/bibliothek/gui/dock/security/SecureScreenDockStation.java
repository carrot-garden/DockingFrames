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

package bibliothek.gui.dock.security;

import java.awt.Window;

import bibliothek.gui.dock.ScreenDockStation;
import bibliothek.gui.dock.station.screen.ScreenDockDialog;
import bibliothek.gui.dock.util.WindowProvider;
import bibliothek.util.Todo;
import bibliothek.util.Todo.Compatibility;
import bibliothek.util.Todo.Priority;
import bibliothek.util.Todo.Version;

/**
 * A {@link ScreenDockStation} that uses {@link SecureScreenDockDialog} 
 * instead of {@link ScreenDockDialog}.
 * @author Benjamin Sigg
 * @deprecated This class now behaves like {@link ScreenDockStation} and is no longer
 * necessary. This class will be removed in a future release. 
 */
@Deprecated
@Todo( compatibility=Compatibility.BREAK_MAJOR, priority=Priority.MAJOR, target=Version.VERSION_1_1_1,
		description="remove this class")
public class SecureScreenDockStation extends ScreenDockStation {
    /**
     * Creates a new station.
     * @param owner the owner of all dialogs created by this station
     */
    public SecureScreenDockStation( Window owner ) {
        super(owner);
    }

    /**
     * Creates a new factory.
     * @param owner the window which will be used as owner of all windows
     * created by this station.
     */
    public SecureScreenDockStation( WindowProvider owner ) {
        super(owner);
    }
    
    @Override
    public String getFactoryID() {
        return SecureScreenDockStationFactory.ID;
    }
}
