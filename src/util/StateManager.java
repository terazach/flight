package util;

import java.util.Stack;

public class StateManager {

	private Stack<State> states;

	public StateManager() {
		states = new Stack<State>();
	}

	public void change(State state) {
		states.pop();
		states.push(state);
	}

	public void push(State state) {
		states.push(state);
	}

	public void pop() {
		states.pop();
	}

	// Calls update method from the state current at the top of stack
	public void update(float dt) {
		states.peek().update(dt);
	}

	// Calls draw method from the state current at the top of stack
	public void draw() {
		states.peek().draw();
	}

}
