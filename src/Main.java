import graphics.*;
import util.*;

import org.lwjgl.*;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.glfw.Callbacks.*;

public class Main {

	private static Window window = new Window();
	private static StateManager stateMan = new StateManager();
	
	public static void run() {
		System.out.println("Running game with LWJGL version: " + Version.getVersion());
		
		try {
			window.init(1280, 720, "Flight");
			gameLoop();

			glfwFreeCallbacks(window.glWindow);
			glfwDestroyWindow(window.glWindow);
		} finally {
			glfwTerminate();
		}
	}
	
	public static void gameLoop() {
		GL.createCapabilities();
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

		//Set initial state as splash screen 
		stateMan.push(new Splash(stateMan));

		while (!glfwWindowShouldClose(window.glWindow)) {
			glfwPollEvents();

			stateMan.draw();

			glfwSwapBuffers(window.glWindow);
		}
	}

	public static void main(String[] args) {
		run();
	}

}