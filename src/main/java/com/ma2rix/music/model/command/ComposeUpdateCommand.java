package com.ma2rix.music.model.command;

import java.io.Serializable;
import java.util.ArrayList;

import com.ma2rix.music.model.domain.Composition;

public class ComposeUpdateCommand implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CompositionCommand compositionCommand;
	private ArrayList<ComposeArrangeCommand> composeArrangeCommands;
	private Composition composition;
	
	public ComposeUpdateCommand() {
		compositionCommand = new CompositionCommand();
		composeArrangeCommands = new ArrayList<ComposeArrangeCommand>();
		composition = new Composition();
	}
	
	public ComposeUpdateCommand(CompositionCommand compositionCommand,
			ArrayList<ComposeArrangeCommand> composeArrangeCommands,
			Composition composition, int composeNo) {
		super();
		this.compositionCommand = compositionCommand;
		this.composeArrangeCommands = composeArrangeCommands;
		this.composition = composition;
	}

	public CompositionCommand getCompositionCommand() {
		return compositionCommand;
	}

	public void setCompositionCommand(CompositionCommand compositionCommand) {
		this.compositionCommand = compositionCommand;
	}

	public ArrayList<ComposeArrangeCommand> getComposeArrangeCommands() {
		return composeArrangeCommands;
	}

	public void setComposeArrangeCommands(
			ArrayList<ComposeArrangeCommand> composeArrangeCommands) {
		this.composeArrangeCommands = composeArrangeCommands;
	}

	public Composition getComposition() {
		return composition;
	}

	public void setComposition(Composition composition) {
		this.composition = composition;
	}

}
