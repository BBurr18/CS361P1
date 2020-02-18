package fa.dfa;

import fa.DFAState;
import fa.State;
import fa.dfa.DFAInterface;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DFA implements DFAInterface {

	Set<DFAState> states;
	Set<Character> abc;

	public DFA() {
		states = new HashSet<DFAState>();
		abc = new HashSet<Character>();
	}

	@Override
	public void addStartState(String name) {
		DFAState startState = new DFAState(name);
		startState.setStart(true);
		startState.setFinal(true);
		states.add(startState);

	}

	@Override
	public void addState(String name) {
		DFAState state = new DFAState(name);
		state.setStart(false);
		state.setFinal(false);
		states.add(state);
	}

	@Override
	public void addFinalState(String name) {
		DFAState finalState = new DFAState(name);
		finalState.setStart(false);
		finalState.setFinal(true);
		states.add(finalState);
	}

	@Override
	public void addTransition(String fromState, char onSymb, String toState) {
		Iterator<DFAState> iter = states.iterator();
		DFAState from;
		
		while (iter.hasNext()) {
			from = iter.next();
			if(from.getName() == fromState) {
				for(DFAState s : states) {
					if(s.getName() == toState) {
						from.addTransition(onSymb,s);
					}
				}
			}
		}
		
	}

	@Override
	public Set<? extends State> getStates() {

		return states;
	}

	@Override
	public Set<? extends State> getFinalStates() {
		HashSet<DFAState> finalStates = new HashSet<DFAState>();
		Iterator<DFAState> iter = states.iterator();
		DFAState temp;
		while (iter.hasNext()) {
			temp = iter.next();
			if (temp.isFinal() == true) {
				finalStates.add(temp);
			}
		}
		return finalStates;
	}

	@Override
	public State getStartState() {
		Iterator<DFAState> iter = states.iterator();
		DFAState temp;
		while (iter.hasNext()) {
			temp = iter.next();
			if (temp.getStart() == true) {
				return temp;
			}
		}

		return null;
	}

	@Override
	public Set<Character> getABC() {

		return abc;
	}

	@Override
	public DFA complement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean accepts(String s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public State getToState(DFAState from, char onSymb) {
		
		
		DFAState retVal = (DFAState) from.getToState(onSymb);
		
		return retVal;
	}
}
