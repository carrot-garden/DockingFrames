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
package bibliothek.gui.dock.util.font;

import bibliothek.extension.gui.dock.util.Path;
import bibliothek.gui.dock.util.UIValue;

/**
 * A wrapper around a {@link FontModifier} object.
 * @author Benjamin Sigg
 */
public interface DockFont extends UIValue<FontModifier> {
    /** the default kind of fonts */
    public static final Path KIND_DOCK_FONT = new Path( "DockFont" );
    
    /** default id for the title active font */
    public static final String ID_TITLE_ACTIVE = "title.active";
    
    /** default id for the title inactive font */
    public static final String ID_TITLE_INACTIVE = "title.inactive";
}
