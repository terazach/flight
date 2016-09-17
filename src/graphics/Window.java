package graphics;

import util.*;

import org.lwjgl.opengl.*;
import org.lwjgl.glfw.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Window {

	public long glWindow;
	private static StateManager stateMan = new StateManager();

	public void init(int width, int height, String title) {
		if (!glfwInit())
			throw new IllegalStateException("Failed to initialize GLFW!");

		glWindow = glfwCreateWindow(width, height, title, NULL, NULL);

		if (glWindow == NULL)
			throw new RuntimeException("Failed to initialize GLFW Window!");

		glfwMakeContextCurrent(glWindow);

		GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

		glfwSetWindowPos(glWindow, ((videoMode.width() - width) / 2), ((videoMode.height() - height) / 2));
	}

	public void gameLoop() {
		GL.createCapabilities();
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

		stateMan.push(new Splash(stateMan));

		while (!glfwWindowShouldClose(glWindow)) {
			glfwPollEvents();

			stateMan.draw();

			glfwSwapBuffers(glWindow);
		}
	}
}
