package bibliothek.notes.view.actions;

import bibliothek.gui.Dockable;
import bibliothek.gui.dock.action.ActionGuard;
import bibliothek.gui.dock.action.DefaultDockActionSource;
import bibliothek.gui.dock.action.DockActionSource;
import bibliothek.gui.dock.action.LocationHint;
import bibliothek.notes.model.Note;
import bibliothek.notes.model.NoteModel;
import bibliothek.notes.util.ResourceSet;
import bibliothek.notes.view.panels.NoteView;

public class NoteDeleteAction extends Delete implements ActionGuard{
	private DockActionSource source;
	
	public NoteDeleteAction( NoteModel model ){
		super( model );
		
		source = new DefaultDockActionSource(
				new LocationHint( LocationHint.ACTION_GUARD, LocationHint.RIGHT ),
				this );
		
		setIcon( ResourceSet.APPLICATION_ICONS.get( "delete" ) );
	}


	@Override
	public void action( Dockable dockable ){
		super.action( dockable );
		Note note = ((NoteView)dockable).getNote();
		delete( note, dockable );
	}

	public DockActionSource getSource( Dockable dockable ){
		return source;
	}

	public boolean react( Dockable dockable ){
		return dockable instanceof NoteView;
	}
}
