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
    public void finish(App app){
        int round = app.getN() * app.getM();
        for (int i=0; i<round; ++i) app.process(app.getMen(), app.getWomen());
    }
    public boolean proove(App app){
        return app.proove();
    }
}
