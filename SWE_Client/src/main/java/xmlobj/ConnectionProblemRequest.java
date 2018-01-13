package xmlobj;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class ConnectionProblemRequest {
	int ID;

	public int getID() {
		return ID;
	}
	@XmlElement
	public void setID(int iD) {
		ID = iD;
	}
}
