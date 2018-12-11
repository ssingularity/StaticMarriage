package cn.pipipan.staticmarriage.staticmarriageweb.Service;

import com.pipipan.staticmarriage.App;
import org.springframework.stereotype.Service;

@Service
public class MarriageService {
    public void initApp(App app){
        app.init();
    }
    public void nextStep(App app){
        app.process(app.getMen(), app.getWomen());
    }
    public void nextStepDoubleSide(App app){
        app.process(app.getWomen(), app.getMen());
    }
    public boolean proove(App app){
        return app.proove();
    }
}
