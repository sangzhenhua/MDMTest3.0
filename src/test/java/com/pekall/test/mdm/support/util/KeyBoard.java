package com.pekall.test.mdm.support.util;

import java.awt.AWTException;
import java.awt.Robot;


public class KeyBoard {
	public static void pressKeyboard(int KeyCode) throws AWTException {

		Robot rb = new Robot();

		rb.keyPress(KeyCode); // 按下按键

		rb.delay(100); // 保持100毫秒

		rb.keyRelease(KeyCode); // 释放按键
     }
	//pressKeyboard(KeyEvent.VK_ENTER);
}
