package cn.pipipan.staticmarriage.staticmarriageweb.Domain;

public class PackageHuman {
    CastHuman[] men;
    CastHuman[] women;
    public PackageHuman(CastHuman[] men, CastHuman[] women){
        this.men = men;
        this.women = women;
    }

    public CastHuman[] getMen() {
        return men;
    }

    public void setMen(CastHuman[] men) {
        this.men = men;
    }

    public CastHuman[] getWomen() {
        return women;
    }

    public void setWomen(CastHuman[] women) {
        this.women = women;
    }
}
