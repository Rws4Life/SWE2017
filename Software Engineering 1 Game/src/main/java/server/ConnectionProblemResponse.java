package server;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class ConnectionProblemResponse {
	boolean loss, win;

	public boolean isLoss() {
		return loss;
	}
	@XmlElement
	public void setLoss(boolean loss) {
		this.loss = loss;
	}

	public boolean isWin() {
		return win;
	}
	@XmlElement
	public void setWin(boolean win) {
		this.win = win;
	}
	
}
