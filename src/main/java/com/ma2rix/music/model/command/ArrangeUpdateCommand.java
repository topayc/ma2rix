package com.ma2rix.music.model.command;

import java.io.Serializable;
import java.util.ArrayList;

import com.ma2rix.music.model.domain.Arrangement;
import com.ma2rix.music.model.domain.Performance;

public class ArrangeUpdateCommand implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CompositionCommand compositionCommand;
	private ArrangementCommand arrangeCommand;
	private ArrayList<PerformanceCommand> performanceCommands;
	private ArrayList<ArrangeVocalCommand> arrangeVocalCommands;
	private Arrangement arrangement;
	public ArrangeUpdateCommand() {
		compositionCommand = new CompositionCommand();
		performanceCommands = new ArrayList<PerformanceCommand>();
		arrangeVocalCommands = new ArrayList<ArrangeVocalCommand>();
		arrangement = new Arrangement();
	}
	public ArrangeUpdateCommand(CompositionCommand compositionCommand,
			ArrangementCommand arrangeCommand,
			ArrayList<PerformanceCommand> performanceCommands,
			ArrayList<ArrangeVocalCommand> arrangeVocalCommands,
			Arrangement arrangement) {
		super();
		this.compositionCommand = compositionCommand;
		this.arrangeCommand = arrangeCommand;
		this.performanceCommands = performanceCommands;
		this.arrangeVocalCommands = arrangeVocalCommands;
		this.arrangement = arrangement;
	}
	public CompositionCommand getCompositionCommand() {
		return compositionCommand;
	}
	public void setCompositionCommand(CompositionCommand compositionCommand) {
		this.compositionCommand = compositionCommand;
	}
	public ArrangementCommand getArrangeCommand() {
		return arrangeCommand;
	}
	public void setArrangeCommand(ArrangementCommand arrangeCommand) {
		this.arrangeCommand = arrangeCommand;
	}
	public ArrayList<PerformanceCommand> getPerformanceCommands() {
		return performanceCommands;
	}
	public void setPerformanceCommands(
			ArrayList<PerformanceCommand> performanceCommands) {
		this.performanceCommands = performanceCommands;
	}
	public ArrayList<ArrangeVocalCommand> getArrangeVocalCommands() {
		return arrangeVocalCommands;
	}
	public void setArrangeVocalCommands(
			ArrayList<ArrangeVocalCommand> arrangeVocalCommands) {
		this.arrangeVocalCommands = arrangeVocalCommands;
	}
	public Arrangement getArrangement() {
		return arrangement;
	}
	public void setArrangement(Arrangement arrangement) {
		this.arrangement = arrangement;
	}
}
