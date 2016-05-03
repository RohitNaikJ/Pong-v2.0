import java.awt.Color;
import java.awt.Graphics;

public class Paddle {
	public int paddleNumber;
	public int x,y, width=30, height=200, horizon;
	public static int speed = 5;
	
	public Paddle(Pong pong, int paddleNumber){
               switch(pong.difficulty){
                   case 0:
                       this.horizon = 200;
                       break;
                   case 1:
                       this.horizon = 400;
                       break;
                   case 2:
                       this.horizon = 600;
                       break;
                   default:
                       this.horizon = 350;
               }
               this.paddleNumber = paddleNumber;
		
		if(paddleNumber == 1){
			this.x = 0;
                        this.y = pong.height/2 - height/2;
		}
		else if(paddleNumber == 2){
			this.x = pong.width-this.width;
                        this.y = pong.height/2 - height/2;
		}
                else if(paddleNumber == 3){
			this.y = 0;
                        this.x = pong.width/2 - 100;
		}
                else if(paddleNumber == 4){
			this.y = pong.height-30;
                        this.x = pong.width/2 - 100;
		}
	}

	public void render(Graphics g,int n) {
		g.setColor(Color.WHITE);
                if(n == 2){
                    this.width = 200;
                    this.height = 30;
                }
		g.fillRect(x, y, width, height);
	}

	public void move(boolean up) {
		if(up){
			y -= speed;
			if(y<0)
				y = 0;
		}else{
			y += speed;
			if(y+height > Pong.pong.height)
				y = Pong.pong.height - height;
		}
	}

	public void update(Pong pong,int difficulty,Ball ball) {
		if(paddleNumber==1){
			if((ball.x < (horizon/*(int)(0.5*((pong.height/5)*ball.motionX)))*/))&&(ball.motionX < 0)){
				float floatestimate = ((ball.motionY/ball.motionX)*(width - ball.x)) + (float)ball.y;
				if(floatestimate<0){
					floatestimate =(float) ((((-ball.motionY)/ball.motionX)*(width - ((ball.motionX/ball.motionY)*(-ball.y))))+ ball.x );
				}
				if(floatestimate>pong.height){
					floatestimate =(float) ((((-ball.motionY)/ball.motionX)*(width - ((ball.motionX/ball.motionY)*(pong.height-ball.y))))+ ball.x ) + pong.width;
				}
				int estimate = (int)floatestimate;

				settarget(estimate);
			}
		}
		if(paddleNumber==2){
			if((ball.x > (pong.width - horizon/*(int)(0.5*((pong.height/5)*ball.motionX)))*/))&&(ball.motionX > 0)){
				float floatestimate = ((ball.motionY/ball.motionX)*((pong.width - width) - ball.x)) + (float)ball.y;
				if(floatestimate<0){
					floatestimate =(float) ((((-ball.motionY)/ball.motionX)*((pong.width - width) - ((ball.motionX/ball.motionY)*(-ball.y))))+ ball.x );
				}
				if(floatestimate>pong.height){
					floatestimate =(float) ((((-ball.motionY)/ball.motionX)*((pong.width - width) - ((ball.motionX/ball.motionY)*(pong.height-ball.y))))+ ball.x ) + (pong.width);
				}
				int estimate = (int)floatestimate;

				settarget(estimate);
			}
		}
                if(paddleNumber==3){
			if((ball.y < (horizon/*(int)(0.5*((pong.height/5)*ball.motionX)))*/))&&(ball.motionY < 0)){
				float floatestimate = ((ball.motionX/ball.motionY)*(height - ball.y)) + (float)ball.x;
				if(floatestimate<0){
					floatestimate =(float) ((((-ball.motionX)/ball.motionY)*(height - ((ball.motionY/ball.motionX)*(-ball.x))))+ ball.y);
				}
				if(floatestimate>pong.width){
					floatestimate =(float) ((((-ball.motionX)/ball.motionY)*(height - ((ball.motionY/ball.motionX)*(pong.width-ball.x))))+ ball.y) + pong.height;
				}
				int estimate = (int)floatestimate;

				settargetx(estimate);
			}
		}
                if(paddleNumber == 4){
                    if((ball.y > (pong.width - horizon/*(int)(0.5*((pong.height/5)*ball.motionX)))*/))&&(ball.motionY > 0)){
				float floatestimate = ((ball.motionX/ball.motionY)*((pong.height - height) - ball.y)) + (float)ball.x;
				if(floatestimate<0){
					floatestimate =(float) ((((-ball.motionX)/ball.motionY)*((pong.height - height) - ((ball.motionY/ball.motionX)*(-ball.x))))+ ball.y);
				}
				if(floatestimate>pong.width){
					floatestimate =(float) ((((-ball.motionX)/ball.motionY)*((pong.height - height) - ((ball.motionY/ball.motionX)*(pong.width-ball.x))))+ ball.y ) + (pong.height);
				}
				int estimate = (int)floatestimate;

				settargetx(estimate);
			}
                }
		// TODO Auto-generated method stub
		
	}

	private void settarget(int estimate) {
		
		if(estimate<=(y+35)){
			move(true);
		}else{
			if(estimate>=(y+height-35)){
				move(false);
			}
		}
		// TODO Auto-generated method stub
		
	}

    private void settargetx(int estimate) {
        if(estimate<=(x+35)){
			movex(true);
		}else{
			if(estimate>=(x+width-35)){
				movex(false);
			}
		}
		
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void movex(boolean left) {
        if(left){
			x -= speed;
			if(x<0)
				x = 0;
		}else{
			x += speed;
			if(x+width > Pong.pong.width)
				x = Pong.pong.width - width;
		}
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
