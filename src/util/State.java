package util;

public abstract class State {

	public abstract void update(float dt);

	public abstract void handleInput();

	public abstract void draw();

	protected State(StateManager stateMan) {
	}

}
