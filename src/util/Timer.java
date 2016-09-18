package util;

import static org.lwjgl.glfw.GLFW.glfwGetTime;

public class Timer {
	
	private double lastTime;
	private float timeCount;
	
	private int fps;
	private int fpsCount;
	
	private int tick;
	private int tickCount;
	
	public void initTimer() {
		lastTime = getTime();
	}
	
	public void update() {
		if (timeCount > 1f) {
			fps = fpsCount;
			fpsCount = 0;
			
			tick = tickCount;
			tickCount = 0;
			
			timeCount -= 1f;
		}
	}
	
	public void updateFPS() {
		fpsCount++;
	}
	
	public void updateTick() {
		tickCount++;
	}

	public double getTime() {
		return glfwGetTime();
	}
	
	public double getLastTime() {
		return lastTime;
	}
	
	public float getDeltaTime() {
		double time = getTime();
		float deltaTime = (float) (time - lastTime);
		lastTime = time;
		timeCount += deltaTime;
		return deltaTime;
	}
	
	public int getFPS() {
		return fps > 0 ? fps : fpsCount;
	}
	
	public int getTick() {
		return tick > 0 ? tick : tickCount;
	}
	
}
