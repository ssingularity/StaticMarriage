package cn.pipipan.staticmarriage.staticmarriageweb.Controller;

import cn.pipipan.staticmarriage.staticmarriageweb.Domain.CastHuman;
import cn.pipipan.staticmarriage.staticmarriageweb.Domain.PackageHuman;
import cn.pipipan.staticmarriage.staticmarriageweb.Service.MarriageService;
import com.pipipan.staticmarriage.App;
import com.pipipan.staticmarriage.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class MarriageController {
    @Autowired
    MarriageService marriageService;
    @RequestMapping("/init")
    public PackageHuman init(HttpServletRequest request,
                        @RequestParam(name = "n") int n, @RequestParam(name = "m") int m){
        App app = new App(n, m);
        marriageService.initApp(app);
        HttpSession session = request.getSession();
        session.setAttribute("app", app);
        return new PackageHuman(packageCastHuman(app.getMen()), packageCastHuman(app.getWomen()));
    }
    @RequestMapping("/process")
    public PackageHuman process(HttpServletRequest request){
        HttpSession session = request.getSession();
        App app = (App)session.getAttribute("app");
        marriageService.nextStep(app);
        return new PackageHuman(packageCastHuman(app.getMen()), packageCastHuman(app.getWomen()));
    }
    @RequestMapping("/doubleSideProcess")
    public PackageHuman doubleSideProcess(HttpServletRequest request){
        HttpSession session = request.getSession();
        App app = (App)session.getAttribute("app");
        marriageService.nextStepDoubleSide(app);
        return new PackageHuman(packageCastHuman(app.getMen()), packageCastHuman(app.getWomen()));
    }
    @RequestMapping("/proove")
    public boolean proove(HttpServletRequest request){
        HttpSession session = request.getSession();
        App app = (App)session.getAttribute("app");
        return marriageService.proove(app);
    }
    private CastHuman[] packageCastHuman(Human[] men){
        CastHuman[] castHumen = new CastHuman[men.length];
        for (int i=0; i<men.length; ++i){
            castHumen[i] = new CastHuman(men[i]);
        }
        return castHumen;
    }
}
