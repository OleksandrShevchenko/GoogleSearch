package pac.browsers;

import io.github.bonigarcia.wdm.EdgeDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge  extends WebDriverGeneral {

    public Edge(){
        EdgeDriverManager.getInstance().setup();
        this.setDriver( new EdgeDriver() );
    }
}