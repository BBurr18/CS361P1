
package fa;

import java.util.HashMap;

public class DFAState extends State{

    protected String name;
    protected boolean isStart;
    protected boolean isFinal;
    protected boolean isCurrentState;
    protected HashMap<Character,DFAState> transitions;
    public DFAState(String name){
    	this.name = name;
    	transitions = new HashMap<Character, DFAState>();
    }
    	
    @Override
    public String getName(){
      
        return name;
    }

    @Override
    public String toString(){
        return name;

    }
    
    public void setStart(boolean arg) {
    	isStart = arg;
    }
    public boolean getStart() {
    	return isStart;
    }
    
    public void setFinal(boolean arg) {
    	isFinal = arg;
    }
    public boolean isFinal() {
    	return isFinal;
    	
    }
    
    public void setCurrentState(boolean arg) {
    	isCurrentState = arg;
    	
    }
    
    public boolean isCurrentState() {
    	return isCurrentState();
    }
    
    public void addTransition(char sym, DFAState name) {
    	transitions.put(sym, name);
    }
    
    public DFAState getToState(char sym) {
    	
    	return (DFAState) transitions.get(sym);
    	
    	
    	
    	
    }

}