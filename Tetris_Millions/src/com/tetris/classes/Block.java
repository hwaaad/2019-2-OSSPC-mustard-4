package com.tetris.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import com.tetris.window.TetrisBoard;


/**
 * 
 * @author minshik
 * 2019/12/04 01:11 
 * 내용 :  boolean isCustomBlock 변수 ,  getter, setter 추가
 * 
 *
 */

public class Block implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int size = TetrisBoard.BLOCK_SIZE;
	private int width = size, height = size;
	private int gap = 3;
	private int fixGridX, fixGridY;
	private int posGridX, posGridY;
	private Color color;
	private Color ghostColor;	
	private boolean ghost;
	private boolean isCustomBlock;
	
	
	/**
	 * 
	 * @param fixGridX : 사각형 고정 X 그리드좌표
	 * @param fixGridY : 사각형 고정 Y 그리드좌표
	 * @param color : 사각형 색상
	 */
	public Block(int fixGridX, int fixGridY, Color color, Color ghostColor) {
		this.fixGridX = fixGridX;
		this.fixGridY = fixGridY;
		this.color=color;
		this.ghostColor = ghostColor;
		this.isCustomBlock = false;
	}
	

	/**
	 * 사각형을 그려준다.
	 * @param g
	 */
	public void drawColorBlock(Graphics g){
		if(ghost)g.setColor(ghostColor);
		else g.setColor(color);
		g.fillRect((fixGridX+posGridX)*size + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect((fixGridX+posGridX)*size + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y, width, height);
		g.drawLine((fixGridX+posGridX)*size + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y, (fixGridX+posGridX)*size+width + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size+height + TetrisBoard.BOARD_Y);
		g.drawLine((fixGridX+posGridX)*size + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size+height + TetrisBoard.BOARD_Y, (fixGridX+posGridX)*size+width + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y);
		if(ghost)g.setColor(ghostColor);
		else g.setColor(color);
		g.fillRect((fixGridX+posGridX)*size+gap + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size+gap + TetrisBoard.BOARD_Y, width-gap*2, height-gap*2);
		g.setColor(Color.BLACK);
		g.drawRect((fixGridX+posGridX)*size+gap + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size+gap + TetrisBoard.BOARD_Y, width-gap*2, height-gap*2);
	}
	
	/**
	 * 현재 블럭의 절대좌표를 보여준다.
	 * @return 현재블럭의 X절대좌표
	 */
	public int getX(){return posGridX + fixGridX;}	
	
	
	/**
	 * 현재 블럭의 절대좌표를 보여준다.
	 * @return 현재블럭의 Y절대좌표
	 */
	public int getY(){return posGridY + fixGridY;}

	
	/**
	 * Getter Setter
	 */
	public int getPosGridX(){return this.posGridX;}
	public int getPosGridY(){return this.posGridY;}
	public void setPosGridX(int posGridX) {this.posGridX = posGridX;}
	public void setPosGridY(int posGridY) {this.posGridY = posGridY;}
	public void setPosGridXY(int posGridX, int posGridY){this.posGridX = posGridX;this.posGridY = posGridY;}
	public void setFixGridX(int fixGridX) {this.fixGridX = fixGridX;}
	public void setFixGridY(int fixGridY) {this.fixGridY = fixGridY;}
	public void setFixGridXY(int fixGridX, int fixGridY){this.fixGridX = fixGridX;this.fixGridY = fixGridY;}
	public void setGhostView(boolean b){this.ghost = b;}

	
	public Color getColor() {return color;}
	public void setColor(Color color) {this.color = color;}

	
	
	
	
	
	/**
	 * @author minshik 2019-12-04
	 * @param isCustomBlock 커스컴 맵 만들 떄 들어가는 블럭에 들어갈 세팅값 true
	 */
	public void setCustomBlock(boolean isCustomBlock) {
		this.isCustomBlock = isCustomBlock;
	}

	/**
	 * @author minshik 2019-12-04
	 * @return true, false
	 */
	
	public boolean isCustomBlock() {
		return isCustomBlock;
	}


	
	
	
	
}
